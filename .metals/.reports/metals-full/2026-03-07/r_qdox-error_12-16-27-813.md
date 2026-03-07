error id: file://<WORKSPACE>/src/compilateur/PtGen.java
file://<WORKSPACE>/src/compilateur/PtGen.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[63,21]

error in qdox parser
file content:
```java
offset: 1908
uri: file://<WORKSPACE>/src/compilateur/PtGen.java
text:
```scala
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
	public static String trinome = "VeillardViey"; // TODO

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


	private static int @@@Aff; // Adresse de la variable à affecter
	private static int tAff;  // Type de la variable (ENT ou BOOL)

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

			//Ptgen Valeur
			case 1: //pos
				tCour = ENT;
				vCour = UtilLex.valEnt;
				break;

			case 2 : //neg
				tCour = ENT;
				vCour = -UtilLex.valEnt;
				break;

			case 3 : //true
				tCour = BOOL;
				vCour = VRAI;
				break;

			case 4 : //false
				tCour = BOOL;
				vCour = FAUX;
				break;

			//Ptgen consts
			case 5 :
				if (presentIdent(bc) != 0) {
					UtilLex.messErr("ERREUR : Vars Déjà Déclaré");
				}
				placeIdent(UtilLex.numIdCourant, CONSTANTE, tCour, vCour);
				break;

			//Ptgen type
			case 6 :
				tCour = ENT;
				break;

			case 7 : 
				tCour = BOOL;
				break;

			//Ptgen var
			case 8 :
				if (presentIdent(bc) != 0) {
					UtilLex.messErr("ERREUR : Vars Déjà Déclaré");
				}
				
				placeIdent(UtilLex.numIdCourant, VARGLOBALE, tCour, varCour);

				varCour++;
				break;

			//declarations
			case 9:
				po.produire(RESERVER);
				po.produire(varCour); 
				break;

			//primaire
			case 10:
				po.produire(EMPILER);
				po.produire(vCour);
				break;

			case 11:
				int indice11 = presentIdent(1);
				tCour = tabSymb[indice11].type;

				//CONST
				if (tabSymb[indice11].categorie == CONSTANTE) {
					po.produire(EMPILER);
					po.produire(tabSymb[indice11].info); 
					
				//VAR
				} else { 
					po.produire(CONTENUG);
					po.produire(tabSymb[indice11].info);
				}
				break;
			
			//exp4 & exp5
			case 12 : 
				verifEnt(); 
    			break;

			//exp4 : +
			case 13 :
				verifEnt();
				po.produire(ADD);
				tCour = ENT;
				break;

			//exp4 : -
			case 14 :
				verifEnt();
				po.produire(SOUS);
				tCour = ENT;
				break;

			//exp5 : *
			case 15 :
				verifEnt();
				po.produire(MUL);
				tCour = ENT;
				break;

			//exp5 : *
			case 16 :
				verifEnt();
				po.produire(DIV);
				tCour = ENT;
				break;

			
			case 17: 
				verifBool();
				break;

			case 18:
				verifBool();
				po.produire(OU);
				tCour = BOOL;
				break;

			case 19:
				verifBool(); 
				po.produire(ET);
				tCour = BOOL;
				break;

			case 20:
				verifBool(); 
				po.produire(NON);
				tCour = BOOL;
				break;

			case 21 : 

			
			case 30 ://lecture
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
                po.produire(AFFECTERG);
                po.produire(tabSymb[indice30].info);
                break;

			case 31 ://ecrire
				if (tCour == ENT) {
					po.produire(ECRENT);
				} 
				else if (tCour == BOOL) {
					po.produire(ECRBOOL);
				} 
				break;


			case 255:
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

```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1090)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:614)
	java.base/java.lang.Thread.run(Thread.java:1474)
```
#### Short summary: 

QDox parse error in file://<WORKSPACE>/src/compilateur/PtGen.java