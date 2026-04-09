// $ANTLR 3.5.2 src/analyseurs/projet.g 2026-04-03 11:06:18

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

			pushFollow(FOLLOW_corps_in_unitprog94);
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
			match(input,44,FOLLOW_44_in_unitmodule104); 
			pushFollow(FOLLOW_ident_in_unitmodule106);
			ident();
			state._fsp--;

			match(input,15,FOLLOW_15_in_unitmodule108); 
			pushFollow(FOLLOW_declarations_in_unitmodule110);
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
					pushFollow(FOLLOW_partiedef_in_declarations118);
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
					pushFollow(FOLLOW_partieref_in_declarations121);
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
					pushFollow(FOLLOW_consts_in_declarations124);
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
					pushFollow(FOLLOW_vars_in_declarations127);
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
					pushFollow(FOLLOW_decprocs_in_declarations132);
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
			match(input,30,FOLLOW_30_in_partiedef141); 
			pushFollow(FOLLOW_ident_in_partiedef143);
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
					match(input,13,FOLLOW_13_in_partiedef146); 
					pushFollow(FOLLOW_ident_in_partiedef148);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef152);
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
			match(input,49,FOLLOW_49_in_partieref160); 
			pushFollow(FOLLOW_specif_in_partieref162);
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
					match(input,13,FOLLOW_13_in_partieref165); 
					pushFollow(FOLLOW_specif_in_partieref167);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref171);
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
			pushFollow(FOLLOW_ident_in_specif179);
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
					match(input,40,FOLLOW_40_in_specif182); 
					match(input,9,FOLLOW_9_in_specif184); 
					pushFollow(FOLLOW_type_in_specif186);
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
							match(input,13,FOLLOW_13_in_specif190); 
							pushFollow(FOLLOW_type_in_specif192);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,10,FOLLOW_10_in_specif196); 
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
					match(input,43,FOLLOW_43_in_specif204); 
					match(input,9,FOLLOW_9_in_specif206); 
					pushFollow(FOLLOW_type_in_specif208);
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
							match(input,13,FOLLOW_13_in_specif212); 
							pushFollow(FOLLOW_type_in_specif214);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					match(input,10,FOLLOW_10_in_specif218); 
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
			match(input,28,FOLLOW_28_in_consts234); 
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
					pushFollow(FOLLOW_ident_in_consts237);
					ident();
					state._fsp--;

					match(input,21,FOLLOW_21_in_consts239); 
					pushFollow(FOLLOW_valeur_in_consts241);
					valeur();
					state._fsp--;

					PtGen.pt(5);
					pushFollow(FOLLOW_ptvg_in_consts245);
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
			match(input,53,FOLLOW_53_in_vars256); 
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
					pushFollow(FOLLOW_type_in_vars259);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars261);
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
							match(input,13,FOLLOW_13_in_vars266); 
							pushFollow(FOLLOW_ident_in_vars268);
							ident();
							state._fsp--;

							PtGen.pt(8);
							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars274);
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
					match(input,33,FOLLOW_33_in_type285); 
					PtGen.pt(6);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:90:4: 'bool'
					{
					match(input,26,FOLLOW_26_in_type291); 
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
					pushFollow(FOLLOW_decproc_in_decprocs300);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs302);
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
			// src/analyseurs/projet.g:95:2: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,47,FOLLOW_47_in_decproc312); 
			pushFollow(FOLLOW_ident_in_decproc314);
			ident();
			state._fsp--;

			PtGen.pt(50);
			// src/analyseurs/projet.g:95:31: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==40) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// src/analyseurs/projet.g:95:31: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc318);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// src/analyseurs/projet.g:95:40: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==43) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// src/analyseurs/projet.g:95:40: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc321);
					parmod();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(51);
			// src/analyseurs/projet.g:95:64: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==28) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// src/analyseurs/projet.g:95:64: consts
					{
					pushFollow(FOLLOW_consts_in_decproc326);
					consts();
					state._fsp--;

					}
					break;

			}

			// src/analyseurs/projet.g:95:72: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==53) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// src/analyseurs/projet.g:95:72: vars
					{
					pushFollow(FOLLOW_vars_in_decproc329);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc332);
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
	// src/analyseurs/projet.g:97:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:97:5: ( ';' |)
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
					// src/analyseurs/projet.g:98:2: ';'
					{
					match(input,17,FOLLOW_17_in_ptvg342); 
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:99:3: 
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
	// src/analyseurs/projet.g:101:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:101:6: ( 'debut' instructions 'fin' )
			// src/analyseurs/projet.g:102:2: 'debut' instructions 'fin'
			{
			match(input,29,FOLLOW_29_in_corps353); 
			pushFollow(FOLLOW_instructions_in_corps355);
			instructions();
			state._fsp--;

			match(input,39,FOLLOW_39_in_corps357); 
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
	// src/analyseurs/projet.g:104:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:104:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// src/analyseurs/projet.g:105:2: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,40,FOLLOW_40_in_parfixe365); 
			match(input,9,FOLLOW_9_in_parfixe367); 
			pushFollow(FOLLOW_pf_in_parfixe369);
			pf();
			state._fsp--;

			// src/analyseurs/projet.g:105:16: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==17) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// src/analyseurs/projet.g:105:17: ';' pf
					{
					match(input,17,FOLLOW_17_in_parfixe372); 
					pushFollow(FOLLOW_pf_in_parfixe374);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,10,FOLLOW_10_in_parfixe378); 
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
	// src/analyseurs/projet.g:107:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:107:3: ( type ident ( ',' ident )* )
			// src/analyseurs/projet.g:108:2: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf386);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf388);
			ident();
			state._fsp--;

			// src/analyseurs/projet.g:108:13: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==13) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// src/analyseurs/projet.g:108:14: ',' ident
					{
					match(input,13,FOLLOW_13_in_pf391); 
					pushFollow(FOLLOW_ident_in_pf393);
					ident();
					state._fsp--;

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
	// src/analyseurs/projet.g:110:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:110:7: ( 'mod' '(' pm ( ';' pm )* ')' )
			// src/analyseurs/projet.g:111:2: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,43,FOLLOW_43_in_parmod403); 
			match(input,9,FOLLOW_9_in_parmod405); 
			pushFollow(FOLLOW_pm_in_parmod407);
			pm();
			state._fsp--;

			// src/analyseurs/projet.g:111:15: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==17) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// src/analyseurs/projet.g:111:16: ';' pm
					{
					match(input,17,FOLLOW_17_in_parmod410); 
					pushFollow(FOLLOW_pm_in_parmod412);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,10,FOLLOW_10_in_parmod416); 
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
	// src/analyseurs/projet.g:113:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:113:3: ( type ident ( ',' ident )* )
			// src/analyseurs/projet.g:114:2: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm424);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm426);
			ident();
			state._fsp--;

			// src/analyseurs/projet.g:114:13: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==13) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// src/analyseurs/projet.g:114:14: ',' ident
					{
					match(input,13,FOLLOW_13_in_pm429); 
					pushFollow(FOLLOW_ident_in_pm431);
					ident();
					state._fsp--;

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
	// src/analyseurs/projet.g:116:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:116:13: ( instruction ( ';' instruction )* )
			// src/analyseurs/projet.g:117:2: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions441);
			instruction();
			state._fsp--;

			// src/analyseurs/projet.g:117:14: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==17) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// src/analyseurs/projet.g:117:15: ';' instruction
					{
					match(input,17,FOLLOW_17_in_instructions444); 
					pushFollow(FOLLOW_instruction_in_instructions446);
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
	// src/analyseurs/projet.g:119:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:119:12: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
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
					// src/analyseurs/projet.g:120:2: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction456);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// src/analyseurs/projet.g:121:4: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction461);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// src/analyseurs/projet.g:122:4: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction466);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// src/analyseurs/projet.g:123:4: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction471);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// src/analyseurs/projet.g:124:4: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction476);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// src/analyseurs/projet.g:125:4: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction481);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// src/analyseurs/projet.g:126:3: 
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
	// src/analyseurs/projet.g:128:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:128:6: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// src/analyseurs/projet.g:129:2: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,50,FOLLOW_50_in_inssi492); 
			pushFollow(FOLLOW_expression_in_inssi494);
			expression();
			state._fsp--;

			PtGen.pt(32);
			match(input,24,FOLLOW_24_in_inssi498); 
			pushFollow(FOLLOW_instructions_in_inssi500);
			instructions();
			state._fsp--;

			// src/analyseurs/projet.g:129:55: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==51) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// src/analyseurs/projet.g:129:56: 'sinon' instructions
					{
					match(input,51,FOLLOW_51_in_inssi503); 
					PtGen.pt(33);
					pushFollow(FOLLOW_instructions_in_inssi508);
					instructions();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(34);
			match(input,41,FOLLOW_41_in_inssi514); 
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
	// src/analyseurs/projet.g:131:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:131:8: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// src/analyseurs/projet.g:132:2: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,27,FOLLOW_27_in_inscond522); 
			PtGen.pt(38);
			pushFollow(FOLLOW_expression_in_inscond528);
			expression();
			state._fsp--;

			PtGen.pt(39);
			match(input,15,FOLLOW_15_in_inscond532); 
			pushFollow(FOLLOW_instructions_in_inscond534);
			instructions();
			state._fsp--;

			PtGen.pt(40);
			// src/analyseurs/projet.g:133:62: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==13) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// src/analyseurs/projet.g:134:3: ',' expression ':' instructions
					{
					match(input,13,FOLLOW_13_in_inscond542); 
					pushFollow(FOLLOW_expression_in_inscond544);
					expression();
					state._fsp--;

					PtGen.pt(39);
					match(input,15,FOLLOW_15_in_inscond548); 
					pushFollow(FOLLOW_instructions_in_inscond550);
					instructions();
					state._fsp--;

					PtGen.pt(40);
					}
					break;

				default :
					break loop30;
				}
			}

			// src/analyseurs/projet.g:134:69: ( 'aut' instructions |)
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
					// src/analyseurs/projet.g:134:70: 'aut' instructions
					{
					match(input,25,FOLLOW_25_in_inscond557); 
					pushFollow(FOLLOW_instructions_in_inscond559);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// src/analyseurs/projet.g:134:91: 
					{
					}
					break;

			}

			match(input,38,FOLLOW_38_in_inscond565); 
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
	// src/analyseurs/projet.g:136:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:136:7: ( 'ttq' expression 'faire' instructions 'fait' )
			// src/analyseurs/projet.g:137:2: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,52,FOLLOW_52_in_boucle575); 
			PtGen.pt(35);
			pushFollow(FOLLOW_expression_in_boucle579);
			expression();
			state._fsp--;

			PtGen.pt(36);
			match(input,35,FOLLOW_35_in_boucle583); 
			pushFollow(FOLLOW_instructions_in_boucle585);
			instructions();
			state._fsp--;

			match(input,36,FOLLOW_36_in_boucle587); 
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
	// src/analyseurs/projet.g:139:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:139:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// src/analyseurs/projet.g:140:2: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,42,FOLLOW_42_in_lecture597); 
			match(input,9,FOLLOW_9_in_lecture599); 
			pushFollow(FOLLOW_ident_in_lecture601);
			ident();
			state._fsp--;

			PtGen.pt(30);
			// src/analyseurs/projet.g:140:34: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==13) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// src/analyseurs/projet.g:140:35: ',' ident
					{
					match(input,13,FOLLOW_13_in_lecture605); 
					pushFollow(FOLLOW_ident_in_lecture607);
					ident();
					state._fsp--;

					PtGen.pt(30);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,10,FOLLOW_10_in_lecture612); 
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
	// src/analyseurs/projet.g:142:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:142:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// src/analyseurs/projet.g:143:2: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,32,FOLLOW_32_in_ecriture620); 
			match(input,9,FOLLOW_9_in_ecriture622); 
			pushFollow(FOLLOW_expression_in_ecriture624);
			expression();
			state._fsp--;

			PtGen.pt(31);
			// src/analyseurs/projet.g:143:42: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==13) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// src/analyseurs/projet.g:143:43: ',' expression
					{
					match(input,13,FOLLOW_13_in_ecriture629); 
					pushFollow(FOLLOW_expression_in_ecriture631);
					expression();
					state._fsp--;

					PtGen.pt(31);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,10,FOLLOW_10_in_ecriture637); 
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
	// src/analyseurs/projet.g:145:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:145:11: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// src/analyseurs/projet.g:146:2: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel645);
			ident();
			state._fsp--;

			// src/analyseurs/projet.g:146:8: ( ':=' expression | ( effixes ( effmods )? )? )
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
					// src/analyseurs/projet.g:146:9: ':=' expression
					{
					match(input,16,FOLLOW_16_in_affouappel648); 
					PtGen.pt(27);
					pushFollow(FOLLOW_expression_in_affouappel652);
					expression();
					state._fsp--;

					PtGen.pt(28);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:146:58: ( effixes ( effmods )? )?
					{
					// src/analyseurs/projet.g:146:58: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==9) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// src/analyseurs/projet.g:146:59: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel658);
							effixes();
							state._fsp--;

							// src/analyseurs/projet.g:146:67: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==9) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// src/analyseurs/projet.g:146:68: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel661);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

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
	// src/analyseurs/projet.g:148:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:148:8: ( '(' ( expression ( ',' expression )* )? ')' )
			// src/analyseurs/projet.g:149:2: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effixes674); 
			// src/analyseurs/projet.g:149:6: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==9||LA38_0==12||LA38_0==14||LA38_0==37||LA38_0==45||LA38_0==54) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// src/analyseurs/projet.g:149:7: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes677);
					expression();
					state._fsp--;

					// src/analyseurs/projet.g:149:18: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==13) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// src/analyseurs/projet.g:149:19: ',' expression
							{
							match(input,13,FOLLOW_13_in_effixes680); 
							pushFollow(FOLLOW_expression_in_effixes682);
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

			match(input,10,FOLLOW_10_in_effixes688); 
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
	// src/analyseurs/projet.g:151:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:151:8: ( '(' ( ident ( ',' ident )* )? ')' )
			// src/analyseurs/projet.g:152:2: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effmods696); 
			// src/analyseurs/projet.g:152:6: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// src/analyseurs/projet.g:152:7: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods699);
					ident();
					state._fsp--;

					// src/analyseurs/projet.g:152:13: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==13) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// src/analyseurs/projet.g:152:14: ',' ident
							{
							match(input,13,FOLLOW_13_in_effmods702); 
							pushFollow(FOLLOW_ident_in_effmods704);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,10,FOLLOW_10_in_effmods710); 
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
	// src/analyseurs/projet.g:154:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:154:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// src/analyseurs/projet.g:154:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// src/analyseurs/projet.g:154:13: ( exp1 )
			// src/analyseurs/projet.g:154:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression718);
			exp1();
			state._fsp--;

			}

			// src/analyseurs/projet.g:154:20: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==46) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// src/analyseurs/projet.g:154:21: 'ou' exp1
					{
					match(input,46,FOLLOW_46_in_expression722); 
					PtGen.pt(17);
					pushFollow(FOLLOW_exp1_in_expression726);
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
	// src/analyseurs/projet.g:156:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:156:5: ( exp2 ( 'et' exp2 )* )
			// src/analyseurs/projet.g:157:2: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp1738);
			exp2();
			state._fsp--;

			// src/analyseurs/projet.g:157:7: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==34) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// src/analyseurs/projet.g:157:8: 'et' exp2
					{
					match(input,34,FOLLOW_34_in_exp1741); 
					PtGen.pt(17);
					pushFollow(FOLLOW_exp2_in_exp1745);
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
	// src/analyseurs/projet.g:159:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:159:5: ( 'non' exp2 | exp3 )
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
					// src/analyseurs/projet.g:160:2: 'non' exp2
					{
					match(input,45,FOLLOW_45_in_exp2757); 
					pushFollow(FOLLOW_exp2_in_exp2759);
					exp2();
					state._fsp--;

					PtGen.pt(20);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:161:4: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp2766);
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
	// src/analyseurs/projet.g:163:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:163:5: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// src/analyseurs/projet.g:164:2: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp3774);
			exp4();
			state._fsp--;

			// src/analyseurs/projet.g:164:7: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
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
					// src/analyseurs/projet.g:165:3: '=' exp4
					{
					match(input,21,FOLLOW_21_in_exp3780); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3784);
					exp4();
					state._fsp--;

					PtGen.pt(21);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:166:5: '<>' exp4
					{
					match(input,20,FOLLOW_20_in_exp3792); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3796);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					}
					break;
				case 3 :
					// src/analyseurs/projet.g:167:5: '>' exp4
					{
					match(input,22,FOLLOW_22_in_exp3804); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3808);
					exp4();
					state._fsp--;

					PtGen.pt(23);
					}
					break;
				case 4 :
					// src/analyseurs/projet.g:168:5: '>=' exp4
					{
					match(input,23,FOLLOW_23_in_exp3816); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3820);
					exp4();
					state._fsp--;

					PtGen.pt(24);
					}
					break;
				case 5 :
					// src/analyseurs/projet.g:169:5: '<' exp4
					{
					match(input,18,FOLLOW_18_in_exp3828); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3832);
					exp4();
					state._fsp--;

					PtGen.pt(25);
					}
					break;
				case 6 :
					// src/analyseurs/projet.g:170:5: '<=' exp4
					{
					match(input,19,FOLLOW_19_in_exp3840); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp4_in_exp3844);
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
	// src/analyseurs/projet.g:173:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:173:5: ( primaire ( '*' primaire | 'div' primaire )* )
			// src/analyseurs/projet.g:174:2: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp5858);
			primaire();
			state._fsp--;

			// src/analyseurs/projet.g:174:11: ( '*' primaire | 'div' primaire )*
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
					// src/analyseurs/projet.g:175:3: '*' primaire
					{
					match(input,11,FOLLOW_11_in_exp5864); 
					PtGen.pt(12);
					pushFollow(FOLLOW_primaire_in_exp5868);
					primaire();
					state._fsp--;

					PtGen.pt(15);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:176:5: 'div' primaire
					{
					match(input,31,FOLLOW_31_in_exp5877); 
					PtGen.pt(12);
					pushFollow(FOLLOW_primaire_in_exp5881);
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
	// src/analyseurs/projet.g:179:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:179:5: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// src/analyseurs/projet.g:180:2: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp4895);
			exp5();
			state._fsp--;

			// src/analyseurs/projet.g:180:7: ( '+' exp5 | '-' exp5 )*
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
					// src/analyseurs/projet.g:181:3: '+' exp5
					{
					match(input,12,FOLLOW_12_in_exp4901); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp5_in_exp4905);
					exp5();
					state._fsp--;

					PtGen.pt(13);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:182:5: '-' exp5
					{
					match(input,14,FOLLOW_14_in_exp4914); 
					PtGen.pt(12);
					pushFollow(FOLLOW_exp5_in_exp4918);
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
	// src/analyseurs/projet.g:185:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:185:9: ( valeur | ident | '(' expression ')' )
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
					// src/analyseurs/projet.g:186:2: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire932);
					valeur();
					state._fsp--;

					PtGen.pt(10);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:187:4: ident
					{
					pushFollow(FOLLOW_ident_in_primaire939);
					ident();
					state._fsp--;

					PtGen.pt(11);
					}
					break;
				case 3 :
					// src/analyseurs/projet.g:188:4: '(' expression ')'
					{
					match(input,9,FOLLOW_9_in_primaire946); 
					pushFollow(FOLLOW_expression_in_primaire948);
					expression();
					state._fsp--;

					match(input,10,FOLLOW_10_in_primaire950); 
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
	// src/analyseurs/projet.g:190:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// src/analyseurs/projet.g:190:7: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
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
					// src/analyseurs/projet.g:191:2: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur959);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 2 :
					// src/analyseurs/projet.g:192:4: '+' nbentier
					{
					match(input,12,FOLLOW_12_in_valeur965); 
					pushFollow(FOLLOW_nbentier_in_valeur967);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 3 :
					// src/analyseurs/projet.g:193:4: '-' nbentier
					{
					match(input,14,FOLLOW_14_in_valeur974); 
					pushFollow(FOLLOW_nbentier_in_valeur976);
					nbentier();
					state._fsp--;

					PtGen.pt(2);
					}
					break;
				case 4 :
					// src/analyseurs/projet.g:194:4: 'vrai'
					{
					match(input,54,FOLLOW_54_in_valeur983); 
					PtGen.pt(3);
					}
					break;
				case 5 :
					// src/analyseurs/projet.g:195:4: 'faux'
					{
					match(input,37,FOLLOW_37_in_valeur990); 
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
	// src/analyseurs/projet.g:206:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// src/analyseurs/projet.g:206:9: ( INT )
			// src/analyseurs/projet.g:207:2: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1007); 
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
	// src/analyseurs/projet.g:209:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// src/analyseurs/projet.g:209:6: ( ID )
			// src/analyseurs/projet.g:210:2: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1018); 
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
	public static final BitSet FOLLOW_corps_in_unitprog94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_unitmodule104 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule106 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_unitmodule108 = new BitSet(new long[]{0x0022800050000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations118 = new BitSet(new long[]{0x0022800010000002L});
	public static final BitSet FOLLOW_partieref_in_declarations121 = new BitSet(new long[]{0x0020800010000002L});
	public static final BitSet FOLLOW_consts_in_declarations124 = new BitSet(new long[]{0x0020800000000002L});
	public static final BitSet FOLLOW_vars_in_declarations127 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_partiedef141 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef143 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partiedef146 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef148 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_partieref160 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref162 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partieref165 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref167 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partieref171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif179 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_40_in_specif182 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif184 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif186 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif190 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif192 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif196 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_43_in_specif204 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif206 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif208 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif212 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif214 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_consts234 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts237 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_consts239 = new BitSet(new long[]{0x0040002000005040L});
	public static final BitSet FOLLOW_valeur_in_consts241 = new BitSet(new long[]{0x0000000000020020L});
	public static final BitSet FOLLOW_ptvg_in_consts245 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_53_in_vars256 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_vars259 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars261 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_13_in_vars266 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars268 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_ptvg_in_vars274 = new BitSet(new long[]{0x0000000204000002L});
	public static final BitSet FOLLOW_33_in_type285 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs300 = new BitSet(new long[]{0x0000800000020000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs302 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_decproc312 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc314 = new BitSet(new long[]{0x0020090030000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc318 = new BitSet(new long[]{0x0020080030000000L});
	public static final BitSet FOLLOW_parmod_in_decproc321 = new BitSet(new long[]{0x0020000030000000L});
	public static final BitSet FOLLOW_consts_in_decproc326 = new BitSet(new long[]{0x0020000020000000L});
	public static final BitSet FOLLOW_vars_in_decproc329 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_corps_in_decproc332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_ptvg342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_corps353 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_corps355 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_corps357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_parfixe365 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parfixe367 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe369 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parfixe372 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe374 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parfixe378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf386 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf388 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pf391 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf393 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_43_in_parmod403 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parmod405 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod407 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parmod410 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod412 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parmod416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm424 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm426 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pm429 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm431 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_instruction_in_instructions441 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_instructions444 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instruction_in_instructions446 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_inssi_in_instruction456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_inssi492 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inssi494 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_inssi498 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi500 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_51_in_inssi503 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi508 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_inssi514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_inscond522 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond528 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond532 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond534 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_13_in_inscond542 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond544 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond548 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond550 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_25_in_inscond557 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond559 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_inscond565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_boucle575 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_boucle579 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_boucle583 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_boucle585 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_lecture597 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_lecture599 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture601 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_lecture605 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture607 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_lecture612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_ecriture620 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_ecriture622 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture624 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_ecriture629 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture631 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_ecriture637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel645 = new BitSet(new long[]{0x0000000000010202L});
	public static final BitSet FOLLOW_16_in_affouappel648 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_affouappel652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel658 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_effmods_in_affouappel661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effixes674 = new BitSet(new long[]{0x0040202000005660L});
	public static final BitSet FOLLOW_expression_in_effixes677 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effixes680 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_effixes682 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effixes688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effmods696 = new BitSet(new long[]{0x0000000000000420L});
	public static final BitSet FOLLOW_ident_in_effmods699 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effmods702 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods704 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effmods710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression718 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_expression722 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp1_in_expression726 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_exp2_in_exp1738 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_exp1741 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp1745 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_45_in_exp2757 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp2759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp2766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp3774 = new BitSet(new long[]{0x0000000000FC0002L});
	public static final BitSet FOLLOW_21_in_exp3780 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp3792 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_exp3804 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp3816 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_exp3828 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3832 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp3840 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp3844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primaire_in_exp5858 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_11_in_exp5864 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp5868 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_31_in_exp5877 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp5881 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_exp5_in_exp4895 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_12_in_exp4901 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp4905 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_14_in_exp4914 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp4918 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_valeur_in_primaire932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_primaire946 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_primaire948 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_primaire950 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_valeur965 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_valeur974 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_valeur983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_valeur990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1018 = new BitSet(new long[]{0x0000000000000002L});
}
