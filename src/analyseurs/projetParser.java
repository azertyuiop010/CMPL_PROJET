// $ANTLR 3.5.2 src/analyseurs/projet.g 2026-04-09 18:57:02

	package analyseurs ;   

 	import libIO.*;       
  	import compilateur.*;

	import java.io.IOException;
	import java.io.DataInputStream;
	import java.io.FileInputStream;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "RC", 
		"WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", "';'", 
		"'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", "'bool'", 
		"'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", "'ent'", 
		"'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", "'fsi'", 
		"'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int RC=7;
	public static final int WS=8;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/analyseurs/projet.g"; }


	// variables globales et methodes utiles à placer ici
	  



	// $ANTLR start "unite"
	// src/analyseurs/projet.g:57:1: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:57:6: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==48) ) {
				alt1=1;
			}
			else if ( (LA1_0==44) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// src/analyseurs/projet.g:58:2: unitprog EOF
					{
					pushFollow(FOLLOW_unitprog_in_unite67);
					unitprog();
					state._fsp--;

					PtGen.pt(255);
					match(input,EOF,FOLLOW_EOF_in_unite71); 
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:59:4: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite76);
					unitmodule();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite78); 
					}
					break;

			}
		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// src/analyseurs/projet.g:61:1: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:61:9: ( 'programme' ident ':' declarations corps )
			// src/analyseurs/projet.g:62:2: 'programme' ident ':' declarations corps
			{
			match(input,48,FOLLOW_48_in_unitprog86); 
			pushFollow(FOLLOW_ident_in_unitprog88);
			ident();
			state._fsp--;

			match(input,15,FOLLOW_15_in_unitprog90); 
			pushFollow(FOLLOW_declarations_in_unitprog92);
			declarations();
			state._fsp--;

			PtGen.pt(42);
			pushFollow(FOLLOW_corps_in_unitprog96);
			corps();
			state._fsp--;

			 System.out.println("succès, arrêt de la compilation "); 
					
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// src/analyseurs/projet.g:65:1: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:65:11: ( 'module' ident ':' declarations )
			// src/analyseurs/projet.g:66:2: 'module' ident ':' declarations
			{
			match(input,44,FOLLOW_44_in_unitmodule106); 
			pushFollow(FOLLOW_ident_in_unitmodule108);
			ident();
			state._fsp--;

			match(input,15,FOLLOW_15_in_unitmodule110); 
			pushFollow(FOLLOW_declarations_in_unitmodule112);
			declarations();
			state._fsp--;

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// src/analyseurs/projet.g:68:1: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:68:13: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// src/analyseurs/projet.g:69:2: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// src/analyseurs/projet.g:69:2: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==30) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/analyseurs/projet.g:69:2: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations120);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// src/analyseurs/projet.g:69:13: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==49) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/analyseurs/projet.g:69:13: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations123);
					partieref();
					state._fsp--;

					}
					break;

			}

			// src/analyseurs/projet.g:69:24: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==28) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/analyseurs/projet.g:69:24: consts
					{
					pushFollow(FOLLOW_consts_in_declarations126);
					consts();
					state._fsp--;

					}
					break;

			}

			// src/analyseurs/projet.g:69:32: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==53) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// src/analyseurs/projet.g:69:32: vars
					{
					pushFollow(FOLLOW_vars_in_declarations129);
					vars();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(9);
			// src/analyseurs/projet.g:69:53: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==47) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/analyseurs/projet.g:69:53: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations134);
					decprocs();
					state._fsp--;

					}
					break;

			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// src/analyseurs/projet.g:71:1: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:71:10: ( 'def' ident ( ',' ident )* ptvg )
			// src/analyseurs/projet.g:72:2: 'def' ident ( ',' ident )* ptvg
			{
			match(input,30,FOLLOW_30_in_partiedef143); 
			pushFollow(FOLLOW_ident_in_partiedef145);
			ident();
			state._fsp--;

			// src/analyseurs/projet.g:72:14: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==13) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/analyseurs/projet.g:72:15: ',' ident
					{
					match(input,13,FOLLOW_13_in_partiedef148); 
					pushFollow(FOLLOW_ident_in_partiedef150);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef154);
			ptvg();
			state._fsp--;

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// src/analyseurs/projet.g:74:1: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:74:10: ( 'ref' specif ( ',' specif )* ptvg )
			// src/analyseurs/projet.g:75:2: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,49,FOLLOW_49_in_partieref162); 
			pushFollow(FOLLOW_specif_in_partieref164);
			specif();
			state._fsp--;

			// src/analyseurs/projet.g:75:15: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==13) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/analyseurs/projet.g:75:16: ',' specif
					{
					match(input,13,FOLLOW_13_in_partieref167); 
					pushFollow(FOLLOW_specif_in_partieref169);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref173);
			ptvg();
			state._fsp--;

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// src/analyseurs/projet.g:77:1: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:77:7: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// src/analyseurs/projet.g:78:2: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif181);
			ident();
			state._fsp--;

			// src/analyseurs/projet.g:78:8: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==40) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// src/analyseurs/projet.g:78:9: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,40,FOLLOW_40_in_specif184); 
					match(input,9,FOLLOW_9_in_specif186); 
					pushFollow(FOLLOW_type_in_specif188);
					type();
					state._fsp--;

					// src/analyseurs/projet.g:78:25: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==13) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// src/analyseurs/projet.g:78:27: ',' type
							{
							match(input,13,FOLLOW_13_in_specif192); 
							pushFollow(FOLLOW_type_in_specif194);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,10,FOLLOW_10_in_specif198); 
					}
					break;

			}

			// src/analyseurs/projet.g:78:44: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==43) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// src/analyseurs/projet.g:79:3: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,43,FOLLOW_43_in_specif206); 
					match(input,9,FOLLOW_9_in_specif208); 
					pushFollow(FOLLOW_type_in_specif210);
					type();
					state._fsp--;

					// src/analyseurs/projet.g:79:18: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==13) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// src/analyseurs/projet.g:79:20: ',' type
							{
							match(input,13,FOLLOW_13_in_specif214); 
							pushFollow(FOLLOW_type_in_specif216);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					match(input,10,FOLLOW_10_in_specif220); 
					}
					break;

			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// src/analyseurs/projet.g:82:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:82:7: ( 'const' ( ident '=' valeur ptvg )+ )
			// src/analyseurs/projet.g:83:5: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,28,FOLLOW_28_in_consts236); 
			// src/analyseurs/projet.g:83:13: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// src/analyseurs/projet.g:83:14: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts239);
					ident();
					state._fsp--;

					match(input,21,FOLLOW_21_in_consts241); 
					pushFollow(FOLLOW_valeur_in_consts243);
					valeur();
					state._fsp--;

					PtGen.pt(5);
					pushFollow(FOLLOW_ptvg_in_consts247);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// src/analyseurs/projet.g:85:1: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:85:5: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// src/analyseurs/projet.g:86:2: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,53,FOLLOW_53_in_vars258); 
			// src/analyseurs/projet.g:86:8: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==26||LA15_0==33) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// src/analyseurs/projet.g:86:9: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars261);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars263);
					ident();
					state._fsp--;

					PtGen.pt(8);
					// src/analyseurs/projet.g:86:34: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==13) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// src/analyseurs/projet.g:86:36: ',' ident
							{
							match(input,13,FOLLOW_13_in_vars268); 
							pushFollow(FOLLOW_ident_in_vars270);
							ident();
							state._fsp--;

							PtGen.pt(8);
							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars276);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// src/analyseurs/projet.g:88:1: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:88:5: ( 'ent' | 'bool' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==33) ) {
				alt16=1;
			}
			else if ( (LA16_0==26) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// src/analyseurs/projet.g:89:2: 'ent'
					{
					match(input,33,FOLLOW_33_in_type287); 
					PtGen.pt(6);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:90:4: 'bool'
					{
					match(input,26,FOLLOW_26_in_type293); 
					PtGen.pt(7);
					}
					break;

			}
		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// src/analyseurs/projet.g:92:1: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:92:9: ( ( decproc ptvg )+ )
			// src/analyseurs/projet.g:92:11: ( decproc ptvg )+
			{
			// src/analyseurs/projet.g:92:11: ( decproc ptvg )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==47) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// src/analyseurs/projet.g:92:12: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs302);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs304);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// src/analyseurs/projet.g:94:1: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:94:8: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// src/analyseurs/projet.g:94:10: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,47,FOLLOW_47_in_decproc313); 
			pushFollow(FOLLOW_ident_in_decproc315);
			ident();
			state._fsp--;

			PtGen.pt(50);
			// src/analyseurs/projet.g:94:39: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==40) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// src/analyseurs/projet.g:94:39: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc319);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// src/analyseurs/projet.g:94:48: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==43) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// src/analyseurs/projet.g:94:48: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc322);
					parmod();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(51);
			// src/analyseurs/projet.g:94:72: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==28) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// src/analyseurs/projet.g:94:72: consts
					{
					pushFollow(FOLLOW_consts_in_decproc327);
					consts();
					state._fsp--;

					}
					break;

			}

			// src/analyseurs/projet.g:94:80: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==53) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// src/analyseurs/projet.g:94:80: vars
					{
					pushFollow(FOLLOW_vars_in_decproc330);
					vars();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(55);
			pushFollow(FOLLOW_corps_in_decproc335);
			corps();
			state._fsp--;

			PtGen.pt(52);
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// src/analyseurs/projet.g:96:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:96:5: ( ';' |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==17) ) {
				alt22=1;
			}
			else if ( (LA22_0==EOF||LA22_0==ID||LA22_0==26||(LA22_0 >= 28 && LA22_0 <= 29)||LA22_0==33||LA22_0==47||LA22_0==49||LA22_0==53) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// src/analyseurs/projet.g:97:2: ';'
					{
					match(input,17,FOLLOW_17_in_ptvg345); 
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:98:3: 
					{
					}
					break;

			}
		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// src/analyseurs/projet.g:100:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:100:6: ( 'debut' instructions 'fin' )
			// src/analyseurs/projet.g:101:2: 'debut' instructions 'fin'
			{
			match(input,29,FOLLOW_29_in_corps356); 
			pushFollow(FOLLOW_instructions_in_corps358);
			instructions();
			state._fsp--;

			match(input,39,FOLLOW_39_in_corps360); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// src/analyseurs/projet.g:103:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:103:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// src/analyseurs/projet.g:104:2: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,40,FOLLOW_40_in_parfixe368); 
			match(input,9,FOLLOW_9_in_parfixe370); 
			pushFollow(FOLLOW_pf_in_parfixe372);
			pf();
			state._fsp--;

			// src/analyseurs/projet.g:104:16: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==17) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// src/analyseurs/projet.g:104:17: ';' pf
					{
					match(input,17,FOLLOW_17_in_parfixe375); 
					pushFollow(FOLLOW_pf_in_parfixe377);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,10,FOLLOW_10_in_parfixe381); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// src/analyseurs/projet.g:106:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:106:3: ( type ident ( ',' ident )* )
			// src/analyseurs/projet.g:107:2: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf389);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf391);
			ident();
			state._fsp--;

			PtGen.pt(53);
			// src/analyseurs/projet.g:107:29: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==13) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// src/analyseurs/projet.g:107:30: ',' ident
					{
					match(input,13,FOLLOW_13_in_pf396); 
					pushFollow(FOLLOW_ident_in_pf398);
					ident();
					state._fsp--;

					PtGen.pt(53);
					}
					break;

				default :
					break loop24;
				}
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// src/analyseurs/projet.g:109:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:109:7: ( 'mod' '(' pm ( ';' pm )* ')' )
			// src/analyseurs/projet.g:110:2: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,43,FOLLOW_43_in_parmod410); 
			match(input,9,FOLLOW_9_in_parmod412); 
			pushFollow(FOLLOW_pm_in_parmod414);
			pm();
			state._fsp--;

			// src/analyseurs/projet.g:110:15: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==17) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// src/analyseurs/projet.g:110:16: ';' pm
					{
					match(input,17,FOLLOW_17_in_parmod417); 
					pushFollow(FOLLOW_pm_in_parmod419);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,10,FOLLOW_10_in_parmod423); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// src/analyseurs/projet.g:112:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:112:3: ( type ident ( ',' ident )* )
			// src/analyseurs/projet.g:113:2: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm431);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm433);
			ident();
			state._fsp--;

			PtGen.pt(54);
			// src/analyseurs/projet.g:113:29: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==13) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// src/analyseurs/projet.g:113:30: ',' ident
					{
					match(input,13,FOLLOW_13_in_pm438); 
					pushFollow(FOLLOW_ident_in_pm440);
					ident();
					state._fsp--;

					PtGen.pt(54);
					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// src/analyseurs/projet.g:115:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:115:13: ( instruction ( ';' instruction )* )
			// src/analyseurs/projet.g:116:2: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions452);
			instruction();
			state._fsp--;

			// src/analyseurs/projet.g:116:14: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==17) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// src/analyseurs/projet.g:116:15: ';' instruction
					{
					match(input,17,FOLLOW_17_in_instructions455); 
					pushFollow(FOLLOW_instruction_in_instructions457);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// src/analyseurs/projet.g:118:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:118:12: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt28=7;
			switch ( input.LA(1) ) {
			case 50:
				{
				alt28=1;
				}
				break;
			case 27:
				{
				alt28=2;
				}
				break;
			case 52:
				{
				alt28=3;
				}
				break;
			case 42:
				{
				alt28=4;
				}
				break;
			case 32:
				{
				alt28=5;
				}
				break;
			case ID:
				{
				alt28=6;
				}
				break;
			case 13:
			case 17:
			case 25:
			case 36:
			case 38:
			case 39:
			case 41:
			case 51:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// src/analyseurs/projet.g:119:2: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction467);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// src/analyseurs/projet.g:120:4: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction472);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// src/analyseurs/projet.g:121:4: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction477);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// src/analyseurs/projet.g:122:4: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction482);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// src/analyseurs/projet.g:123:4: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction487);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// src/analyseurs/projet.g:124:4: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction492);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// src/analyseurs/projet.g:125:3: 
					{
					}
					break;

			}
		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// src/analyseurs/projet.g:127:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:127:6: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// src/analyseurs/projet.g:128:2: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,50,FOLLOW_50_in_inssi503); 
			pushFollow(FOLLOW_expression_in_inssi505);
			expression();
			state._fsp--;

			PtGen.pt(32);
			match(input,24,FOLLOW_24_in_inssi509); 
			pushFollow(FOLLOW_instructions_in_inssi511);
			instructions();
			state._fsp--;

			// src/analyseurs/projet.g:128:55: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==51) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// src/analyseurs/projet.g:128:56: 'sinon' instructions
					{
					match(input,51,FOLLOW_51_in_inssi514); 
					PtGen.pt(33);
					pushFollow(FOLLOW_instructions_in_inssi519);
					instructions();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(34);
			match(input,41,FOLLOW_41_in_inssi525); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// src/analyseurs/projet.g:130:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:130:8: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// src/analyseurs/projet.g:131:2: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,27,FOLLOW_27_in_inscond533); 
			PtGen.pt(38);
			pushFollow(FOLLOW_expression_in_inscond539);
			expression();
			state._fsp--;

			PtGen.pt(39);
			match(input,15,FOLLOW_15_in_inscond543); 
			pushFollow(FOLLOW_instructions_in_inscond545);
			instructions();
			state._fsp--;

			PtGen.pt(40);
			// src/analyseurs/projet.g:132:62: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==13) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// src/analyseurs/projet.g:133:3: ',' expression ':' instructions
					{
					match(input,13,FOLLOW_13_in_inscond553); 
					pushFollow(FOLLOW_expression_in_inscond555);
					expression();
					state._fsp--;

					PtGen.pt(39);
					match(input,15,FOLLOW_15_in_inscond559); 
					pushFollow(FOLLOW_instructions_in_inscond561);
					instructions();
					state._fsp--;

					PtGen.pt(40);
					}
					break;

				default :
					break loop30;
				}
			}

			// src/analyseurs/projet.g:133:69: ( 'aut' instructions |)
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==25) ) {
				alt31=1;
			}
			else if ( (LA31_0==38) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// src/analyseurs/projet.g:133:70: 'aut' instructions
					{
					match(input,25,FOLLOW_25_in_inscond568); 
					pushFollow(FOLLOW_instructions_in_inscond570);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// src/analyseurs/projet.g:133:91: 
					{
					}
					break;

			}

			match(input,38,FOLLOW_38_in_inscond576); 
			PtGen.pt(41);
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// src/analyseurs/projet.g:135:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:135:7: ( 'ttq' expression 'faire' instructions 'fait' )
			// src/analyseurs/projet.g:136:2: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,52,FOLLOW_52_in_boucle586); 
			PtGen.pt(35);
			pushFollow(FOLLOW_expression_in_boucle590);
			expression();
			state._fsp--;

			PtGen.pt(36);
			match(input,35,FOLLOW_35_in_boucle594); 
			pushFollow(FOLLOW_instructions_in_boucle596);
			instructions();
			state._fsp--;

			match(input,36,FOLLOW_36_in_boucle598); 
			PtGen.pt(37);
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// src/analyseurs/projet.g:138:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:138:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// src/analyseurs/projet.g:139:2: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,42,FOLLOW_42_in_lecture608); 
			match(input,9,FOLLOW_9_in_lecture610); 
			pushFollow(FOLLOW_ident_in_lecture612);
			ident();
			state._fsp--;

			PtGen.pt(30);
			// src/analyseurs/projet.g:139:34: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==13) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// src/analyseurs/projet.g:139:35: ',' ident
					{
					match(input,13,FOLLOW_13_in_lecture616); 
					pushFollow(FOLLOW_ident_in_lecture618);
					ident();
					state._fsp--;

					PtGen.pt(30);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,10,FOLLOW_10_in_lecture623); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// src/analyseurs/projet.g:141:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:141:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// src/analyseurs/projet.g:142:2: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,32,FOLLOW_32_in_ecriture631); 
			match(input,9,FOLLOW_9_in_ecriture633); 
			pushFollow(FOLLOW_expression_in_ecriture635);
			expression();
			state._fsp--;

			PtGen.pt(31);
			// src/analyseurs/projet.g:142:42: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==13) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// src/analyseurs/projet.g:142:43: ',' expression
					{
					match(input,13,FOLLOW_13_in_ecriture640); 
					pushFollow(FOLLOW_expression_in_ecriture642);
					expression();
					state._fsp--;

					PtGen.pt(31);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,10,FOLLOW_10_in_ecriture648); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// src/analyseurs/projet.g:144:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:144:11: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// src/analyseurs/projet.g:145:5: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel659);
			ident();
			state._fsp--;

			// src/analyseurs/projet.g:145:11: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==16) ) {
				alt36=1;
			}
			else if ( (LA36_0==9||LA36_0==13||LA36_0==17||LA36_0==25||LA36_0==36||(LA36_0 >= 38 && LA36_0 <= 39)||LA36_0==41||LA36_0==51) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// src/analyseurs/projet.g:145:12: ':=' expression
					{
					match(input,16,FOLLOW_16_in_affouappel662); 
					PtGen.pt(27);
					pushFollow(FOLLOW_expression_in_affouappel666);
					expression();
					state._fsp--;

					PtGen.pt(28);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:145:62: ( effixes ( effmods )? )?
					{
					PtGen.pt(60);
					// src/analyseurs/projet.g:145:78: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==9) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// src/analyseurs/projet.g:145:79: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel675);
							effixes();
							state._fsp--;

							// src/analyseurs/projet.g:145:87: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==9) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// src/analyseurs/projet.g:145:88: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel678);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					PtGen.pt(62);
					}
					break;

			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// src/analyseurs/projet.g:147:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:147:8: ( '(' ( expression ( ',' expression )* )? ')' )
			// src/analyseurs/projet.g:148:2: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effixes694); 
			// src/analyseurs/projet.g:148:6: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==9||LA38_0==12||LA38_0==14||LA38_0==37||LA38_0==45||LA38_0==54) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// src/analyseurs/projet.g:148:7: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes697);
					expression();
					state._fsp--;

					// src/analyseurs/projet.g:148:18: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==13) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// src/analyseurs/projet.g:148:19: ',' expression
							{
							match(input,13,FOLLOW_13_in_effixes700); 
							pushFollow(FOLLOW_expression_in_effixes702);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop37;
						}
					}

					}
					break;

			}

			match(input,10,FOLLOW_10_in_effixes708); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// src/analyseurs/projet.g:150:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:150:8: ( '(' ( ident ( ',' ident )* )? ')' )
			// src/analyseurs/projet.g:151:2: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effmods716); 
			// src/analyseurs/projet.g:151:6: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// src/analyseurs/projet.g:151:7: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods719);
					ident();
					state._fsp--;

					PtGen.pt(61);
					// src/analyseurs/projet.g:151:29: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==13) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// src/analyseurs/projet.g:151:30: ',' ident
							{
							match(input,13,FOLLOW_13_in_effmods724); 
							pushFollow(FOLLOW_ident_in_effmods726);
							ident();
							state._fsp--;

							PtGen.pt(61);
							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,10,FOLLOW_10_in_effmods735); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// src/analyseurs/projet.g:153:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:153:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// src/analyseurs/projet.g:153:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// src/analyseurs/projet.g:153:13: ( exp1 )
			// src/analyseurs/projet.g:153:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression743);
			exp1();
			state._fsp--;

			}

			// src/analyseurs/projet.g:153:20: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==46) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// src/analyseurs/projet.g:153:21: 'ou' exp1
					{
					match(input,46,FOLLOW_46_in_expression747); 
					PtGen.pt(17);
					pushFollow(FOLLOW_exp1_in_expression751);
					exp1();
					state._fsp--;

					PtGen.pt(18);
					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// src/analyseurs/projet.g:155:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:155:5: ( exp2 ( 'et' exp2 )* )
			// src/analyseurs/projet.g:156:2: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp1763);
			exp2();
			state._fsp--;

			// src/analyseurs/projet.g:156:7: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==34) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// src/analyseurs/projet.g:156:8: 'et' exp2
					{
					match(input,34,FOLLOW_34_in_exp1766); 
					PtGen.pt(17);
					pushFollow(FOLLOW_exp2_in_exp1770);
					exp2();
					state._fsp--;

					PtGen.pt(19);
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// src/analyseurs/projet.g:158:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:158:5: ( 'non' exp2 | exp3 )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==45) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= ID && LA43_0 <= INT)||LA43_0==9||LA43_0==12||LA43_0==14||LA43_0==37||LA43_0==54) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// src/analyseurs/projet.g:159:2: 'non' exp2
					{
					match(input,45,FOLLOW_45_in_exp2782); 
					pushFollow(FOLLOW_exp2_in_exp2784);
					exp2();
					state._fsp--;

					PtGen.pt(20);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:160:4: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp2791);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// src/analyseurs/projet.g:162:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:162:5: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// src/analyseurs/projet.g:163:2: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp3799);
			exp4();
			state._fsp--;

			// src/analyseurs/projet.g:163:7: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt44=7;
			switch ( input.LA(1) ) {
				case 21:
					{
					alt44=1;
					}
					break;
				case 20:
					{
					alt44=2;
					}
					break;
				case 22:
					{
					alt44=3;
					}
					break;
				case 23:
					{
					alt44=4;
					}
					break;
				case 18:
					{
					alt44=5;
					}
					break;
				case 19:
					{
					alt44=6;
					}
					break;
			}
			switch (alt44) {
				case 1 :
					// src/analyseurs/projet.g:164:3: '=' exp4
					{
					match(input,21,FOLLOW_21_in_exp3805); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3809);
					exp4();
					state._fsp--;

					PtGen.pt(21);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:165:5: '<>' exp4
					{
					match(input,20,FOLLOW_20_in_exp3817); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3821);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					}
					break;
				case 3 :
					// src/analyseurs/projet.g:166:5: '>' exp4
					{
					match(input,22,FOLLOW_22_in_exp3829); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3833);
					exp4();
					state._fsp--;

					PtGen.pt(23);
					}
					break;
				case 4 :
					// src/analyseurs/projet.g:167:5: '>=' exp4
					{
					match(input,23,FOLLOW_23_in_exp3841); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3845);
					exp4();
					state._fsp--;

					PtGen.pt(24);
					}
					break;
				case 5 :
					// src/analyseurs/projet.g:168:5: '<' exp4
					{
					match(input,18,FOLLOW_18_in_exp3853); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3857);
					exp4();
					state._fsp--;

					PtGen.pt(25);
					}
					break;
				case 6 :
					// src/analyseurs/projet.g:169:5: '<=' exp4
					{
					match(input,19,FOLLOW_19_in_exp3865); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3869);
					exp4();
					state._fsp--;

					PtGen.pt(26);
					}
					break;

			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp5"
	// src/analyseurs/projet.g:172:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:172:5: ( primaire ( '*' primaire | 'div' primaire )* )
			// src/analyseurs/projet.g:173:2: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp5883);
			primaire();
			state._fsp--;

			// src/analyseurs/projet.g:173:11: ( '*' primaire | 'div' primaire )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==11) ) {
					alt45=1;
				}
				else if ( (LA45_0==31) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// src/analyseurs/projet.g:174:3: '*' primaire
					{
					match(input,11,FOLLOW_11_in_exp5889); 
					PtGen.pt(12);
					pushFollow(FOLLOW_primaire_in_exp5893);
					primaire();
					state._fsp--;

					PtGen.pt(15);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:175:5: 'div' primaire
					{
					match(input,31,FOLLOW_31_in_exp5902); 
					PtGen.pt(12);
					pushFollow(FOLLOW_primaire_in_exp5906);
					primaire();
					state._fsp--;

					PtGen.pt(16);
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "exp4"
	// src/analyseurs/projet.g:178:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:178:5: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// src/analyseurs/projet.g:179:2: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp4920);
			exp5();
			state._fsp--;

			// src/analyseurs/projet.g:179:7: ( '+' exp5 | '-' exp5 )*
			loop46:
			while (true) {
				int alt46=3;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==12) ) {
					alt46=1;
				}
				else if ( (LA46_0==14) ) {
					alt46=2;
				}

				switch (alt46) {
				case 1 :
					// src/analyseurs/projet.g:180:3: '+' exp5
					{
					match(input,12,FOLLOW_12_in_exp4926); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp5_in_exp4930);
					exp5();
					state._fsp--;

					PtGen.pt(13);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:181:5: '-' exp5
					{
					match(input,14,FOLLOW_14_in_exp4939); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp5_in_exp4943);
					exp5();
					state._fsp--;

					PtGen.pt(14);
					}
					break;

				default :
					break loop46;
				}
			}

			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "primaire"
	// src/analyseurs/projet.g:184:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:184:9: ( valeur | ident | '(' expression ')' )
			int alt47=3;
			switch ( input.LA(1) ) {
			case INT:
			case 12:
			case 14:
			case 37:
			case 54:
				{
				alt47=1;
				}
				break;
			case ID:
				{
				alt47=2;
				}
				break;
			case 9:
				{
				alt47=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// src/analyseurs/projet.g:185:2: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire957);
					valeur();
					state._fsp--;

					PtGen.pt(10);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:186:4: ident
					{
					pushFollow(FOLLOW_ident_in_primaire964);
					ident();
					state._fsp--;

					PtGen.pt(11);
					}
					break;
				case 3 :
					// src/analyseurs/projet.g:187:4: '(' expression ')'
					{
					match(input,9,FOLLOW_9_in_primaire971); 
					pushFollow(FOLLOW_expression_in_primaire973);
					expression();
					state._fsp--;

					match(input,10,FOLLOW_10_in_primaire975); 
					}
					break;

			}
		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// src/analyseurs/projet.g:189:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:189:7: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt48=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt48=1;
				}
				break;
			case 12:
				{
				alt48=2;
				}
				break;
			case 14:
				{
				alt48=3;
				}
				break;
			case 54:
				{
				alt48=4;
				}
				break;
			case 37:
				{
				alt48=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// src/analyseurs/projet.g:190:2: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur984);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:191:4: '+' nbentier
					{
					match(input,12,FOLLOW_12_in_valeur990); 
					pushFollow(FOLLOW_nbentier_in_valeur992);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 3 :
					// src/analyseurs/projet.g:192:4: '-' nbentier
					{
					match(input,14,FOLLOW_14_in_valeur999); 
					pushFollow(FOLLOW_nbentier_in_valeur1001);
					nbentier();
					state._fsp--;

					PtGen.pt(2);
					}
					break;
				case 4 :
					// src/analyseurs/projet.g:193:4: 'vrai'
					{
					match(input,54,FOLLOW_54_in_valeur1008); 
					PtGen.pt(3);
					}
					break;
				case 5 :
					// src/analyseurs/projet.g:194:4: 'faux'
					{
					match(input,37,FOLLOW_37_in_valeur1015); 
					PtGen.pt(4);
					}
					break;

			}
		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// src/analyseurs/projet.g:205:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// src/analyseurs/projet.g:205:9: ( INT )
			// src/analyseurs/projet.g:206:2: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1032); 
			 UtilLex.valEnt = (INT1!=null?Integer.valueOf(INT1.getText()):0); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// src/analyseurs/projet.g:208:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// src/analyseurs/projet.g:208:6: ( ID )
			// src/analyseurs/projet.g:209:2: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1043); 
			 UtilLex.traiterId((ID2!=null?ID2.getText():null)); 
			}

		}

		// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
			catch (RecognitionException e) {
				reportError (e) ;
				throw e ; 
			}

		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite67 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite76 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite78 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_unitprog86 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog88 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_unitprog90 = new BitSet(new long[]{0x0022800070000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog92 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_corps_in_unitprog96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_unitmodule106 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule108 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_unitmodule110 = new BitSet(new long[]{0x0022800050000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations120 = new BitSet(new long[]{0x0022800010000002L});
	public static final BitSet FOLLOW_partieref_in_declarations123 = new BitSet(new long[]{0x0020800010000002L});
	public static final BitSet FOLLOW_consts_in_declarations126 = new BitSet(new long[]{0x0020800000000002L});
	public static final BitSet FOLLOW_vars_in_declarations129 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_partiedef143 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef145 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partiedef148 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef150 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_partieref162 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref164 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partieref167 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref169 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partieref173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif181 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_40_in_specif184 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif186 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif188 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif192 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif194 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif198 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_43_in_specif206 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif208 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif210 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif214 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif216 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_consts236 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts239 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_consts241 = new BitSet(new long[]{0x0040002000005040L});
	public static final BitSet FOLLOW_valeur_in_consts243 = new BitSet(new long[]{0x0000000000020020L});
	public static final BitSet FOLLOW_ptvg_in_consts247 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_53_in_vars258 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_vars261 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars263 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_13_in_vars268 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars270 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_ptvg_in_vars276 = new BitSet(new long[]{0x0000000204000002L});
	public static final BitSet FOLLOW_33_in_type287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs302 = new BitSet(new long[]{0x0000800000020000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs304 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_decproc313 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc315 = new BitSet(new long[]{0x0020090030000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc319 = new BitSet(new long[]{0x0020080030000000L});
	public static final BitSet FOLLOW_parmod_in_decproc322 = new BitSet(new long[]{0x0020000030000000L});
	public static final BitSet FOLLOW_consts_in_decproc327 = new BitSet(new long[]{0x0020000020000000L});
	public static final BitSet FOLLOW_vars_in_decproc330 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_corps_in_decproc335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_ptvg345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_corps356 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_corps358 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_corps360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_parfixe368 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parfixe370 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe372 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parfixe375 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe377 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parfixe381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf389 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf391 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pf396 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf398 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_43_in_parmod410 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parmod412 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod414 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parmod417 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod419 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parmod423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm431 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm433 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pm438 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm440 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_instruction_in_instructions452 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_instructions455 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instruction_in_instructions457 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_inssi_in_instruction467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction487 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_inssi503 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inssi505 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_inssi509 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi511 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_51_in_inssi514 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi519 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_inssi525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_inscond533 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond539 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond543 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond545 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_13_in_inscond553 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond555 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond559 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond561 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_25_in_inscond568 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond570 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_inscond576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_boucle586 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_boucle590 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_boucle594 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_boucle596 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_lecture608 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_lecture610 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture612 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_lecture616 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture618 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_lecture623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_ecriture631 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_ecriture633 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture635 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_ecriture640 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture642 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_ecriture648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel659 = new BitSet(new long[]{0x0000000000010202L});
	public static final BitSet FOLLOW_16_in_affouappel662 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_affouappel666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel675 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_effmods_in_affouappel678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effixes694 = new BitSet(new long[]{0x0040202000005660L});
	public static final BitSet FOLLOW_expression_in_effixes697 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effixes700 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_effixes702 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effixes708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effmods716 = new BitSet(new long[]{0x0000000000000420L});
	public static final BitSet FOLLOW_ident_in_effmods719 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effmods724 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods726 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effmods735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression743 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_expression747 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp1_in_expression751 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_exp2_in_exp1763 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_exp1766 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp1770 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_45_in_exp2782 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp2784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp2791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp3799 = new BitSet(new long[]{0x0000000000FC0002L});
	public static final BitSet FOLLOW_21_in_exp3805 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp3817 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_exp3829 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp3841 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3845 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_exp3853 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp3865 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primaire_in_exp5883 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_11_in_exp5889 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp5893 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_31_in_exp5902 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp5906 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_exp5_in_exp4920 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_12_in_exp4926 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp4930 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_14_in_exp4939 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp4943 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_valeur_in_primaire957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_primaire971 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_primaire973 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_primaire975 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_valeur990 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_valeur999 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_valeur1008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_valeur1015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1043 = new BitSet(new long[]{0x0000000000000002L});
}
