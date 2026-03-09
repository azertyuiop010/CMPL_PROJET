/*
 * Grammaire du langage PROJET
 * CMPL L3info 
 * Nathalie Girard, Veronique Masson, Laurent Perraudeau
 * 
 * Il convient d'y insérer les appels aux points de génération
 * de la forme {PtGen.pt(k);}
 * 
 * Attention : relancer ANTLR après chaque modification des 
 * points de génération, pour regénérer les analyseurs.
 */

grammar projet;

options {
	language = Java;
	k = 1;
}

@lexer::header { 
  package analyseurs ;

  import libIO.*;
  import compilateur.*;
}

@parser::header {
	package analyseurs ;   

 	import libIO.*;       
  	import compilateur.*;

	import java.io.IOException;
	import java.io.DataInputStream;
	import java.io.FileInputStream;

}

/*
 * Partie syntaxique : description de la grammaire
 * les non-terminaux doivent commencer par une minuscule
 */

@members {
// variables globales et methodes utiles à placer ici
  
}

@rulecatch {
// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
	catch (RecognitionException e) {
		reportError (e) ;
		throw e ; 
	}
}

unite:
	unitprog {PtGen.pt(255);} EOF
	| unitmodule EOF;

unitprog:
	'programme' ident ':' declarations corps { System.out.println("succès, arrêt de la compilation "); 
		};

unitmodule:
	'module' ident ':' declarations;

declarations:
	partiedef? partieref? consts? vars? decprocs?{PtGen.pt(9);};

partiedef:
	'def' ident (',' ident)* ptvg;

partieref:
	'ref' specif (',' specif)* ptvg;

specif:
	ident ('fixe' '(' type ( ',' type)* ')')? (
		'mod' '(' type ( ',' type)* ')'
	)?;

consts: //compil declarations
    'const' (ident '=' valeur {PtGen.pt(5);} ptvg)+;

vars: //compil declarations
	'var' (type ident {PtGen.pt(8);}( ',' ident {PtGen.pt(8);})* ptvg)+;

type: //compil declarations
	'ent'{PtGen.pt(6);}
	| 'bool'{PtGen.pt(7);};

decprocs: (decproc ptvg)+;

decproc:
	'proc' ident parfixe? parmod? consts? vars? corps;

ptvg:
	';'
	|;

corps:
	'debut' instructions 'fin';

parfixe:
	'fixe' '(' pf (';' pf)* ')';

pf:
	type ident (',' ident)*;

parmod:
	'mod' '(' pm (';' pm)* ')';

pm:
	type ident (',' ident)*;

instructions:
	instruction (';' instruction)*;

instruction:
	inssi
	| inscond
	| boucle
	| lecture
	| ecriture
	| affouappel
	|;

inssi:
	'si' expression {PtGen.pt(32);} 'alors' instructions ('sinon' {PtGen.pt(33);}  instructions)? {PtGen.pt(34);} 'fsi';

inscond: //TODO
	'cond' expression ':' instructions (
		',' expression ':' instructions
	)* ('aut' instructions |) 'fcond';

boucle:
	'ttq' {PtGen.pt(35);} expression {PtGen.pt(36);} 'faire' instructions 'fait' {PtGen.pt(37);};

lecture:
	'lire' '(' ident {PtGen.pt(30);}(',' ident{PtGen.pt(30);})* ')';

ecriture:
	'ecrire' '(' expression {PtGen.pt(31);} (',' expression {PtGen.pt(31);})* ')';

affouappel:
	ident (':=' {PtGen.pt(27);} expression {PtGen.pt(28);}| (effixes (effmods)?)?);

effixes:
	'(' (expression (',' expression)*)? ')';

effmods:
	'(' (ident (',' ident)*)? ')';

expression: (exp1) ('ou' {PtGen.pt(17);} exp1 {PtGen.pt(18);})*;

exp1:
	exp2 ('et' {PtGen.pt(17);} exp2 {PtGen.pt(19);})*;

exp2:
	'non' exp2 {PtGen.pt(20);}
	| exp3;

exp3:
	exp4 (
		'=' {PtGen.pt(12);} exp4 {PtGen.pt(21);}
		| '<>' {PtGen.pt(12);} exp4 {PtGen.pt(22);}
		| '>' {PtGen.pt(12);} exp4 {PtGen.pt(23);}
		| '>=' {PtGen.pt(12);} exp4 {PtGen.pt(24);}
		| '<' {PtGen.pt(12);} exp4 {PtGen.pt(25);}
		| '<=' {PtGen.pt(12);} exp4 {PtGen.pt(26);}
	)?;

exp5:
	primaire (
		'*' {PtGen.pt(12);} primaire {PtGen.pt(15);} 
		| 'div' {PtGen.pt(12);} primaire {PtGen.pt(16);}
	)*;

exp4:
	exp5 (
		'+' {PtGen.pt(12);} exp5 {PtGen.pt(13);} 
		| '-' {PtGen.pt(12);} exp5 {PtGen.pt(14);}
	)*;

primaire:
	valeur {PtGen.pt(10);}
	| ident {PtGen.pt(11);}
	| '(' expression ')';

valeur: //compil declarations
	nbentier{PtGen.pt(1);}
	| '+' nbentier {PtGen.pt(1);}
	| '-' nbentier {PtGen.pt(2);}
	| 'vrai' {PtGen.pt(3);}
	| 'faux' {PtGen.pt(4);};

/*
 * Partie lexicale  : cette partie ne doit pas être modifiée
 * Les unités lexicales ANTLR sont en majuscules
 */

// Attention : ANTLR n'autorise pas certains traitements sur les unites lexicales, 
// il est alors ncessaire de passer par un non-terminal intermediaire 
// exemple : pour l'unit lexicale INT, le non-terminal nbentier a du etre introduit

nbentier:
	INT { UtilLex.valEnt = $INT.int; }; // mise à jour de valEnt

ident:
	ID { UtilLex.traiterId($ID.text); }; // mise à jour de numIdCourant

// Les identifiants commencent obligatoirement par une lettre
ID: ('a' ..'z' | 'A' ..'Z') (
		'a' ..'z'
		| 'A' ..'Z'
		| '0' ..'9'
		| '_'
	)*;

INT:
	'0' ..'9'+;

// On ignore les blancs et tabulations
WS: (' ' | '\t' | '\r')+ { skip(); };

// Définition d'un unique "passage à la ligne" et comptage des numéros de lignes
RC: ('\n') {UtilLex.incrementeLigne(); skip() ;};

// Définition des commentaires : 
// Tout ce qui suit un caractère dièse sur une ligne est un commentaire
// Toute suite de caractères entre accolades est un commentaire
COMMENT:
	'#' ~('\r' | '\n')* {skip();}
	| '\{' (.)* '\}' {skip();};