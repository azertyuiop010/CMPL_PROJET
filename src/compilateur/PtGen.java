package compilateur;

import analyseurs.UtilLex;
import edl.*;
import libIO.*;

/**
 * classe de mise en oeuvre du compilateur
 * =======================================
 * (verifications semantiques + production du code objet)
 * 
 * @author Girard, Masson, Perraudeau
 *
 */

public class PtGen {

	// Renseigner ici un nom pour le trinome, constitué UNIQUEMENT DE LETTRES
	public static String trinome = "VeillardViey"; 

	// taille max de la table des symboles
	private static final int MAXSYMB = 300;

	// TABLE DES SYMBOLES
	private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];
	private static int it; // indice de remplissage de tabSymb
	private static int bc; // bloc courant (=1 si le bloc courant est le programme principal)

	// codes MAPILE
	private static final int RESERVER = 1, EMPILER = 2, CONTENUG = 3, AFFECTERG = 4,
			OU = 5, ET = 6, NON = 7, INF = 8, INFEG = 9, SUP = 10, SUPEG = 11, EG = 12, DIFF = 13,
			ADD = 14, SOUS = 15, MUL = 16, DIV = 17,
			BSIFAUX = 18, BINCOND = 19,
			LIRENT = 20, LIREBOOL = 21, ECRENT = 22, ECRBOOL = 23,
			ARRET = 24,
			EMPILERADG = 25, EMPILERADL = 26, CONTENUL = 27, AFFECTERL = 28, APPEL = 29, RETOUR = 30;

	// codes des valeurs vrai/faux
	private static final int VRAI = 1, FAUX = 0;

	// types permis
	private static final int ENT = 1, BOOL = 2, NEUTRE = 3;

	// categories des identificateurs
	private static final int CONSTANTE = 1, VARGLOBALE = 2, VARLOCALE = 3,
			PARAMFIXE = 4, PARAMMOD = 5, PROC = 6, DEF = 7, REF = 8, PRIVEE = 9;

	// production du code objet en memoire
	private static ProgObjet po;

	// pile de reprise pour les branchements en avant et en arrière
	private static TPileRep pileRep;

	// compilation des littéraux (entier ou booléen)
	private static int vCour;

	// contrôle de type : type de l'expression compilee
	private static int tCour;

	private static int varCour = 0;


	private static int adAff; // Adresse de la variable à affecter
	private static int tAff;  // Type de la variable (ENT ou BOOL)

	private static int varLocCour;
	private static int nbParam;


	// TABLE DES SYMBOLES
	// ----------------------
	/**
	 * utilitaire de recherche de l'ident courant (ayant pour code
	 * UtilLex.numIdCourant) dans tabSymb
	 * 
	 * @param borneInf recherche de l'indice it vers borneInf (=1 si recherche
	 *                 dans tout tabSymb)
	 * @return indice de l'ident courant (de code UtilLex.numIdCourant) dans
	 *         tabSymb (O si absence)
	 */
	private static int presentIdent(int borneInf) {
		int i = it;
		while (i >= borneInf && tabSymb[i].code != UtilLex.numIdCourant)
			i--;
		if (i >= borneInf)
			return i;
		else
			return 0;
	}

	/**
	 * utilitaire de placement des caracteristiques d'un nouvel ident dans tabSymb
	 * 
	 * @param code UtilLex.numIdCourant de l'ident
	 * @param cat  categorie de l'ident parmi CONSTANTE, VARGLOBALE, PROC, etc.
	 * @param type ENT, BOOL ou NEUTRE
	 * @param info valeur pour une constante, ad d'exécution pour une variable, etc.
	 */
	private static void placeIdent(int code, int cat, int type, int info) {
		if (it == MAXSYMB)
			UtilLex.messErr("debordement de la table des symboles");
		it = it + 1;
		tabSymb[it] = new EltTabSymb(code, cat, type, info);
	}

	/**
	 * utilitaire d'affichage de la table des symboles
	 */
	private static void afftabSymb() {
		System.out.println("       code           categorie      type    info");
		System.out.println("      |--------------|--------------|-------|----");
		for (int i = 1; i <= it; i++) {
			if (i == bc) {
				System.out.print("bc=");
				Ecriture.ecrireInt(i, 3);
			} else if (i == it) {
				System.out.print("it=");
				Ecriture.ecrireInt(i, 3);
			} else
				Ecriture.ecrireInt(i, 6);
			if (tabSymb[i] == null)
				System.out.println(" reference NULL");
			else
				System.out.println(" " + tabSymb[i]);
		}
		System.out.println();
	}

	// VERIFICATION DE TYPE
	// ----------------------

	/**
	 * verification du type entier de l'expression en cours de compilation
	 * (arret de la compilation sinon)
	 */
	private static void verifEnt() {
		if (tCour != ENT)
			UtilLex.messErr("expression entiere attendue");
	}

	/**
	 * verification du type booleen de l'expression en cours de compilation
	 * (arret de la compilation sinon)
	 */
	private static void verifBool() {
		if (tCour != BOOL)
			UtilLex.messErr("expression booleenne attendue");
	}

	// COMPILATION SEPAREE
	// -------------------

	// Valeurs possible du vecteur de translation
	private static final int TRANSDON = 1, TRANSCODE = 2, REFEXT = 3;

	// descripteur associe a un programme objet
	private static Descripteur desc;

	/**
	 * modification du vecteur de translation associe au code produit
	 * + incrementation attribut nbTransExt du descripteur
	 * NB: effectue uniquement si c'est une reference externe ou si on compile un
	 * module
	 * 
	 * @param valeur TRANSDON, TRANSCODE ou REFEXT
	 */
	private static void modifVecteurTrans(int valeur) {
		if (valeur == REFEXT || desc.getUnite().equals("module")) {
			po.vecteurTrans(valeur);
			desc.incrNbTansExt();
		}
	}

	// À COMPLÉTER SI BESOIN
	// ---------------------

	/**
	 * initialisations A COMPLETER SI BESOIN
	 * -------------------------------------
	 */
	public static void initialisations() {

		// indices de gestion de la table des symboles
		it = 0;
		bc = 1;

		// pile des reprises pour compilation des branchements en avant
		pileRep = new TPileRep();
		// programme objet = code Mapile de l'unite en cours de compilation
		po = new ProgObjet();
		// COMPILATION SEPAREE: desripteur de l'unite en cours de compilation
		desc = new Descripteur();

		// initialisation necessaire aux attributs lexicaux
		UtilLex.initialisation();

		// initialisation du type de l'expression courante
		tCour = NEUTRE;

		varCour = 0;


	}

	/**
	 * code des points de generation A COMPLETER
	 * -----------------------------------------
	 * 
	 * @param numGen : numero du point de generation a executer
	 */
	public static void pt(int numGen) {

		switch (numGen) {
			case 0:
				initialisations();
				break;

			// --- VALEURS ---
			case 1: // Positif
				tCour = ENT;
				vCour = UtilLex.valEnt;
				break;

			case 2 : // Négati
				tCour = ENT;
				vCour = -UtilLex.valEnt;
				break;

			case 3 : // Vrai
				tCour = BOOL;
				vCour = VRAI;
				break;

			case 4 : // Faux
				tCour = BOOL;
				vCour = FAUX;
				break;

			// --- DÉCLARATIONS ---
			case 5 : // Constante
				if (presentIdent(bc) != 0) {
					UtilLex.messErr("ERREUR : Vars Déjà Déclaré");
				}
				placeIdent(UtilLex.numIdCourant, CONSTANTE, tCour, vCour);
				break;

			case 6 : // Type entier
				tCour = ENT;
				break;

			case 7 : // Type booléen
				tCour = BOOL;
				break;

			case 8: // Variable
				if (presentIdent(bc) != 0) {
					UtilLex.messErr("ERREUR : Identifiant déjà déclaré dans ce bloc");
				}
				
				if (bc == 1) { // VARGLOBAL
					placeIdent(UtilLex.numIdCourant, VARGLOBALE, tCour, varCour);
					varCour++;
				} else { // VARLOCAL
					placeIdent(UtilLex.numIdCourant, VARLOCALE, tCour, varLocCour);
					varLocCour++;
				}
				break;

			//declarations
			case 9: // Réserver
				po.produire(RESERVER);
				po.produire(varCour);
				// Skip Proc 
				po.produire(BINCOND);
    			po.produire(0); // On ne connaît pas encore l'adresse du début du programme
    			pileRep.empiler(po.getIpo());
				break;

			// --- EXPRESSIONS ---category
			case 10:
				po.produire(EMPILER);
				po.produire(vCour);
				break;

			case 11:
				int indice11 = presentIdent(1);
				tCour = tabSymb[indice11].type;
				int cat = tabSymb[indice11].categorie;
				int info = tabSymb[indice11].info;

				switch(cat) {
					case CONSTANTE :
						po.produire(EMPILER);
						po.produire(tabSymb[indice11].info); 
						break;

					case VARGLOBALE :
						po.produire(CONTENUG);
						po.produire(tabSymb[indice11].info);
						break;

					case VARLOCALE : 
						po.produire(CONTENUL);
            			po.produire(info);
            			po.produire(0);
            			break;

					case PARAMFIXE :
						po.produire(CONTENUL);
            			po.produire(info);
            			po.produire(0);
            			break;

					case PARAMMOD:
						po.produire(CONTENUL);
						po.produire(info);
						po.produire(1); // /!\ INDIRECTION : On va chercher la valeur à l'adresse stockée
						break;

					default :
						UtilLex.messErr("Erreur");
				}
				break;
			
			// --- OPÉRATEURS ---
			// Vérification type ENT
			case 12: verifEnt(); break;

			// +
			case 13: verifEnt(); po.produire(ADD); tCour = ENT; break;

			// -
			case 14: verifEnt(); po.produire(SOUS); tCour = ENT; break;

			// *
			case 15: verifEnt(); po.produire(MUL); tCour = ENT; break;

			// div
			case 16: verifEnt(); po.produire(DIV); tCour = ENT; break;

			// Vérification type BOOL
			case 17: verifBool(); break;

			// ou
			case 18: verifBool(); po.produire(OU); tCour = BOOL; break;

			// et
			case 19: verifBool(); po.produire(ET); tCour = BOOL; break;

			// non
			case 20: verifBool(); po.produire(NON); tCour = BOOL; break;

			// =
			case 21: verifEnt(); po.produire(EG); tCour = BOOL; break;

			// <>
			case 22: verifEnt(); po.produire(DIFF); tCour = BOOL; break;

			// >
			case 23: verifEnt(); po.produire(SUP); tCour = BOOL; break;

			// >=
			case 24: verifEnt(); po.produire(SUPEG); tCour = BOOL; break;

			// <
			case 25: verifEnt(); po.produire(INF); tCour = BOOL; break;

			// <=
			case 26: verifEnt(); po.produire(INFEG); tCour = BOOL; break;

			// --- INSTRUCTIONS ---
			case 27: 
				int indice27 = presentIdent(1); 
				if (indice27 == 0) {UtilLex.messErr("ERREUR : Identifiant inconnu");}
				if (tabSymb[indice27].categorie == CONSTANTE) {UtilLex.messErr("ERREUR : Impossible de modif une CONS");}
				
				adAff = tabSymb[indice27].info;
				tAff = tabSymb[indice27].type;
				int catAff = tabSymb[indice27].categorie;
				
				pileRep.empiler(catAff); 
				break;

			case 28:
				if (tCour != tAff) {
					UtilLex.messErr("Erreur : Type incompatible.");
				}

				int catVariable = pileRep.depiler();

				if (catVariable == VARGLOBALE) {
					po.produire(AFFECTERG);
					po.produire(adAff);
				} 
				else if (catVariable == PARAMMOD) {
					po.produire(AFFECTERL);
					po.produire(adAff);
					po.produire(1);
				} 
				else { 
					po.produire(AFFECTERL);
					po.produire(adAff);
					po.produire(0);
				}
				break;

			
			case 30 : // Lectur
                int indice30 = presentIdent(1);

                if (indice30 == 0) {
                    UtilLex.messErr("ERREUR : Identificateur Non Déclaré");
                }
                if(tabSymb[indice30].categorie == CONSTANTE){
                    UtilLex.messErr("ERREUR : Une constante ne peut être modifiée ");
                }


                if(tabSymb[indice30].type == ENT){
                    po.produire(LIRENT);
                }
                else{
                    po.produire(LIREBOOL);
                }

				switch (tabSymb[indice30].categorie) {
					case VARGLOBALE :
						po.produire(AFFECTERG);
						po.produire(tabSymb[indice30].info);
						break;

					case PARAMMOD :
						po.produire(AFFECTERL);
						po.produire(tabSymb[indice30].info);
						po.produire(1);
						break;

					default :
						po.produire(AFFECTERL);
						po.produire(tabSymb[indice30].info);
						po.produire(0);
						break;
				}
                break;

			case 31 : // Ecriture
				if (tCour == ENT) {
					po.produire(ECRENT);
				} 
				else if (tCour == BOOL) {
					po.produire(ECRBOOL);
				} 
				break;
			
			// --- STRUCTURES DE CONTRÔLE ---

			// IF ELSE - inssi
			case 32: // BSIFAUX
                verifBool();
                po.produire(BSIFAUX);
                po.produire(0); 
                pileRep.empiler(po.getIpo()); 
                break;

            case 33: // BINCOND
                po.produire(BINCOND);
                po.produire(0);
                
                int adrSiFaux = pileRep.depiler(); 
                po.modifier(adrSiFaux, po.getIpo() + 1); 
                
                pileRep.empiler(po.getIpo()); 
                break;

            case 34: // Fin SI
                int adrDernier = pileRep.depiler(); 
                po.modifier(adrDernier, po.getIpo() + 1); 
                break;

			// TTQ - boucle
			case 35 : 
				pileRep.empiler(po.getIpo() + 1);
				break;

			case 36 : 
				verifBool();
                po.produire(BSIFAUX);
                po.produire(0);
                pileRep.empiler(po.getIpo());
                break;

			case 37: // Fin boucle
				int adrSortie = pileRep.depiler();
				int adrRetour = pileRep.depiler();
				
				po.produire(BINCOND);
				po.produire(adrRetour);
				
				po.modifier(adrSortie, po.getIpo() + 1);
				break;

			// Cond
			case 38 : //Init
				pileRep.empiler(0);
                break;

			case 39: //Test Cond
				verifBool();
                po.produire(BSIFAUX);
                po.produire(-1);
                pileRep.empiler(po.getIpo());
				break;

			case 40 : 
				int adrMajBSIFAUX = pileRep.depiler(); 
                int adrProdBINCOND = pileRep.depiler();
                
                po.produire(BINCOND);
                po.produire(adrProdBINCOND);
                int adrNouveauBincond = po.getIpo();
                
                po.modifier(adrMajBSIFAUX, po.getIpo() + 1);
                pileRep.empiler(adrNouveauBincond);
                break;

			case 41:
                int adrCourante = pileRep.depiler(); 
                
                while (adrCourante != 0) {
                    int adrPrecedente = po.getElt(adrCourante); 
                    
                    po.modifier(adrCourante, po.getIpo() + 1); 
                    adrCourante = adrPrecedente;
                }
                break;

			case 42 : 
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
    			break;
				
			// --- Procédures ---
			case 50:
				int numIdProc = UtilLex.numIdCourant;
				if (presentIdent(1) != 0) {
					UtilLex.messErr("ERREUR : proc déja déclarée");
				}
				placeIdent(numIdProc, PROC, NEUTRE, po.getIpo() + 1);
				placeIdent(-1, PRIVEE, NEUTRE, 0);
				bc = it + 1;
				varLocCour = 0;
				break;
			
			case 51:	//decproc màj tabsymb nombre param proc
                int nbparam = it - bc + 1; 
                tabSymb[bc - 1].info = nbparam;
				varLocCour = nbparam + 2;
    			break;

			case 52:	//decproc  Suppression des variables locales Masquage paramètres Màj bc
                int nbparam1 = tabSymb[bc - 1].info; 
                po.produire(RETOUR);
                po.produire(nbparam1);

                while (tabSymb[it].categorie == 3) {
                    it -= 1; 
                }

                for (int i = bc; i <= it; i++) {
                    if (tabSymb[i].categorie == 4 || tabSymb[i].categorie == 5) {
                        tabSymb[i].code = -1;
                    }
                }

                bc = 1;
				afftabSymb();
                break;

			case 53: // Param FIXE
				if(presentIdent(bc) != 0) UtilLex.messErr("Déjà déclaré");
				placeIdent(UtilLex.numIdCourant, PARAMFIXE, tCour, varLocCour);
				varLocCour++;
				break;

			case 54 : // Param MOD
				if(presentIdent(bc) != 0) UtilLex.messErr("Déjà déclaré");
				placeIdent(UtilLex.numIdCourant, PARAMMOD, tCour, varLocCour);
				varLocCour++;
				break;

			case 55: // Réservation locale
				int nbLoc = varLocCour - (tabSymb[bc - 1].info + 2); 
				if (nbLoc > 0) {
					po.produire(RESERVER);
					po.produire(nbLoc);
				}
				break;

			case 60: // Début d'appel (verif)
				int iProc = presentIdent(1);
				if (iProc == 0) UtilLex.messErr("Erreur : Proc non déclarée");
				if (tabSymb[iProc].categorie != PROC) UtilLex.messErr("Erreur : Ce n'est pas une procédure");
				
				pileRep.empiler(iProc); 
				break;

			case 61 : // Passage param
				//Recup infos
				int idArg = presentIdent(1);
				int catArg = tabSymb[idArg].categorie;
				int adArg = tabSymb[idArg].info;

				switch (catArg) {
					case VARGLOBALE:
						po.produire(EMPILERADG);
        				po.produire(adArg);
						break;

					case PARAMMOD:
						po.produire(EMPILERADL);
        				po.produire(adArg);
						po.produire(1);
						break;
				
					default:
						po.produire(EMPILERADL);
        				po.produire(adArg);
						po.produire(0);
						break;
				}
				break;

			case 62 :
				int indexProcAppelee = pileRep.depiler();
    			po.produire(APPEL);
    			po.produire(tabSymb[indexProcAppelee].info);
				po.produire(tabSymb[indexProcAppelee + 1].info); 
    			break;


			case 255:
				po.produire(ARRET);
				// En fin de compilation :
				// - création des fichiers contenant le code produit (exécutable et mnémonique)
				// - affichage de la table des symboles
				// TODO À compléter si besoin
				po.constObj();
				po.constGen();
				afftabSymb();
				break;

			default:
				System.out.println("Point de generation non prevu dans votre liste");
				break;

		}
	}
}
