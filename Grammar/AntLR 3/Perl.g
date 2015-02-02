grammar Perl;

options {
		memoize=true; 
		k=1;
		output = AST;
		ASTLabelType = CommonTree;
		backtrack = true;
	}

//tokens {
//		POD;
//	}
	
@parser::header {package org.language.perl.grammar;}
@lexer::header {package org.language.perl.grammar;}

@members {
	
	public List<SyntaxError> syntaxErrors = new ArrayList<SyntaxError>();
    	@Override 
	public String getErrorMessage(RecognitionException e, String[] tokenNames) { 
	      String message = super.getErrorMessage(e, tokenNames); 
	      SyntaxError syntaxError = new SyntaxError(); 
	      if (e.token != null && e.token instanceof CommonToken) { 
	         CommonToken ct = (CommonToken) e.token; 
	         syntaxError.start = ct.getStartIndex(); 
	         syntaxError.stop = ct.getStopIndex()+1; 
	      } 
	       
	      syntaxError.exception = e; 
	      syntaxError.message = message; 
	
      	      syntaxErrors.add(syntaxError); 
	      return message; 
	
	} 
	
	public static class SyntaxError { 
		   public RecognitionException exception; 
		   public String message; 
		   public int line; 
		   public int charPositionInLine; 
		   public int start = -1; 
		   public int stop = -1; 
	} 
}

//Parser
parseSource : (.)+ EOF;

// Lexer
WHITESPACE
	:	(' '|'\t'|'\n'|'\r')+ {$channel=HIDDEN;}
	;

COMMANDS:	'NULL' | '__FILE__' | '__LINE__' | '__PACKAGE__' | '__DATA__' | '__END__' | 'AUTOLOAD' 
		| 'BEGIN' | 'CORE' | 'DESTROY' | 'END' | 'EQ' | 'GE' | 'GT' | 'INIT' | 'LE' | 'LT' | 'NE' | 'CHECK' 
		| 'abs' | 'accept' | 'alarm' | 'and' | 'atan2' | 'bind' | 'binmode' | 'bless' | 'caller' | 'chdir' 
		| 'chmod' | 'chomp' | 'chop' | 'chown' | 'chr' | 'chroot' | 'close' | 'closedir' | 'cmp' | 'connect' 
		| 'continue' | 'cos' | 'crypt' | 'dbmclose' | 'dbmopen' | 'defined' | 'delete' | 'die' | 'do' | 'dump' 
		| 'each' | 'else' | 'elsif' | 'endgrent' | 'endhostent' | 'endnetent' | 'endprotoent' | 'endpwent' 
		| 'endservent' | 'eof' | 'eq' | 'eval' | 'exec' | 'exists' | 'exit' | 'exp' | 'fcntl' | 'fileno' 
		| 'flock' | 'for' | 'foreach' | 'fork' | 'format' | 'formline' | 'ge' | 'getc' | 'getgrent' | 'getgrgid' 
		| 'getgrnam' | 'gethostbyaddr' | 'gethostbyname' | 'gethostent' | 'getlogin' | 'getnetbyaddr' 
		| 'getnetbyname' | 'getnetent' | 'getpeername' | 'getpgrp' | 'getppid' | 'getpriority' 
		| 'getprotobyname' | 'getprotobynumber' | 'getprotoent' | 'getpwent' | 'getpwnam' | 'getpwuid' 
		| 'getservbyname' | 'getservbyport' | 'getservent' | 'getsockname' | 'getsockopt' | 'glob' | 'gmtime' 
		| 'goto' | 'grep' | 'gt' | 'hex' | 'if' | 'index' | 'int' | 'ioctl' | 'join' | 'keys' | 'kill' | 'last' 
		| 'lc' | 'lcfirst' | 'le' | 'length' | 'link' | 'listen' | 'local' | 'localtime' | 'lock' | 'log' 
		| 'lstat' | 'lt' | 'm' | 'map' | 'mkdir' | 'msgctl' | 'msgget' | 'msgrcv' | 'msgsnd' | 'my' | 'ne' 
		| 'next' | 'no' | 'not' | 'oct' | 'open' | 'opendir' | 'or' | 'ord' | 'our' | 'pack' | 'package' 
		| 'pipe' | 'pop' | 'pos' | 'print' | 'printf' | 'prototype' | 'push' | 'q' | 'qq' | 'qr' | 'quotemeta' 
		| 'qu' | 'qw' | 'qx' | 'rand' | 'read' | 'readdir' | 'readline' | 'readlink' | 'readpipe' | 'recv' 
		| 'redo' | 'ref' | 'rename' | 'require' | 'reset' | 'return' | 'reverse' | 'rewinddir' | 'rindex' 
		| 'rmdir' | 's' | 'scalar' | 'seek' | 'seekdir' | 'select' | 'semctl' | 'semget' | 'semop' | 'send' 
		| 'setgrent' | 'sethostent' | 'setnetent' | 'setpgrp' | 'setpriority' | 'setprotoent' | 'setpwent' 
		| 'setservent' | 'setsockopt' | 'shift' | 'shmctl' | 'shmget' | 'shmread' | 'shmwrite' | 'shutdown' 
		| 'sin' | 'sleep' | 'socket' | 'socketpair' | 'sort' | 'splice' | 'split' | 'sprintf' | 'sqrt' 
		| 'srand' | 'stat' | 'study' | 'sub' | 'substr' | 'symlink' | 'syscall' | 'sysopen' | 'sysread' 
		| 'sysseek' | 'system' | 'syswrite' | 'tell' | 'telldir' | 'tie' | 'tied' | 'time' | 'times' | 'tr' 
		| 'truncate' | 'uc' | 'ucfirst' | 'umask' | 'undef' | 'unless' | 'unlink' | 'unpack' | 'unshift' 
		| 'untie' | 'until' | 'use' | 'utime' | 'values' | 'vec' | 'wait' | 'waitpid' | 'wantarray' | 'warn' 
		| 'while' | 'write' |  'xor'
	;

SPECIAL_VAR
	: (
	  '*^A' | '*^C' | '*^D' | '*^E' | '*^F' | '*^I' | '*^L' | '*^N'
	| '*^O' | '*^P' | '*^R' | '*^S' | '*^T' | '*^V' | '*^W' | '*^X'
	| '*/' |  '*?' | '*%' | '*@' | '*_' | '*-' | '*+' | '*.' | '*|' | '*,'
	| '*;' | '*~' | '*:' | '*^' | '*<' | '*>' | '*(' | '*)' /* | '*$' TODO, watch out: 5*$x */
 	| '*\'' | '*\\' | '$$m' | '$$s' | '$"'
	| '$^A' | '$^C' | '$^D' | '$^E' | '$^F' | '$^H' | '$^I' | '$^L' | '$^M'
	| '$^N' | '$^O' | '$^P' | '$^R' | '$^S' | '$^T' | '$^V' | '$^W' | '$^X'
	| '$/' | '$?' | '$%' | '$@' | '$_' | '$-' | '$+' | '$.' | '$|' | '$!'
	| '$;' | '$~' | '$$' | '$`' | '$<' | '$>' | '$(' | '$)' | '$,'
	| '$[' | '$]' | '$:' | '$*' | '$#' | '$=' | '$^' | '$&'
	| '$\'' | '$\\' | '@+' | '@-' | '@_' | '@$' | '%!' | '%@' | '%^H'
	);
	
COMMENT
	:	'#' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
	;


NUMBER	:	
	('0x' ('0'..'9' | 'A'..'F' | 'a'..'f')+ ('.' ('0'..'9' | 'A'..'F' | 'a'..'f')+)?) 	//Hexadecimal
	| ('0b' ('0' | '1')+ ('.' ('0' | '1')+)? )				//Binary
	| ('0'..'9') (('0'..'9')* ('.' ('0'..'9')+)?)				//Decimal / Octal
	;
	
SUBST_OR_MATCH_OPER
	: ('tr/' | 'qq/' | 'qx/' | 'qw/' | 'qr/' | 's/' | 'y/' | 'm/' | 'q/');

//Brackets
LBRACK		: '[' ;
RBRACK		: ']' ;
LPAREN		: '(' ;
RPAREN		: ')' ;
LCURLY		: '{';
RCURLY		: '}';

//Symbols
COMMA		: ',' ;
SEMI_COLON	: ';';
COLON		: ':';
DOT		: '.';

//Mathematical operators
EQUAL	:	'=';
PLUS	:	'+';
MINUS	:	'-';
MULTIPLY:	'*';
DIVIDE	:	'/';
GT	:	'>';
LT	:	'<';

//Quotes
SQUOTE	:	'\'';
DQUOTE	:	'"';


//Miscellaneous
BACKSLASH
	:	'\\';
UNDERSCORE
	:	'_';

VARIABLE	: ('$' | '@' | '%') ('$' | '@' | '%' | '#')? ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ ;


WORD_CHAR 	: ('a'..'z'|'A'..'Z'|'_')+
	;

STRING
    :  '"' (  EscapeSequence | ~('\\'|'"') )* '"'? 
    | '\'' (  EscapeSequence | ~('\\'|'\'') )* '\''? ; 
    
fragment
EscapeSequence
      :   '\\' .
    ;
//POD	:	'=p'('o')?('d')?
//		(.)*
//		('=cut')
//	;
