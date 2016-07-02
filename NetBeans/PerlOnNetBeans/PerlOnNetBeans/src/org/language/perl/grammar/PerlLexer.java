// $ANTLR 3.4 D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g 2016-06-23 05:58:21
package org.language.perl.grammar;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PerlLexer extends Lexer {
    public static final int EOF=-1;
    public static final int BACKSLASH=4;
    public static final int COLON=5;
    public static final int COMMA=6;
    public static final int COMMANDS=7;
    public static final int COMMENT=8;
    public static final int DIVIDE=9;
    public static final int DOT=10;
    public static final int DQUOTE=11;
    public static final int EQUAL=12;
    public static final int EscapeSequence=13;
    public static final int GT=14;
    public static final int LBRACK=15;
    public static final int LCURLY=16;
    public static final int LPAREN=17;
    public static final int LT=18;
    public static final int MINUS=19;
    public static final int MULTIPLY=20;
    public static final int NUMBER=21;
    public static final int PLUS=22;
    public static final int RBRACK=23;
    public static final int RCURLY=24;
    public static final int RPAREN=25;
    public static final int SEMI_COLON=26;
    public static final int SPECIAL_VAR=27;
    public static final int SQUOTE=28;
    public static final int STRING=29;
    public static final int SUBST_OR_MATCH_OPER=30;
    public static final int UNDERSCORE=31;
    public static final int VARIABLE=32;
    public static final int WHITESPACE=33;
    public static final int WORD_CHAR=34;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public PerlLexer() {} 
    public PerlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PerlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g"; }

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:54:2: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:54:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:54:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "COMMANDS"
    public final void mCOMMANDS() throws RecognitionException {
        try {
            int _type = COMMANDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:9: ( 'NULL' | '__FILE__' | '__LINE__' | '__PACKAGE__' | '__DATA__' | '__END__' | 'AUTOLOAD' | 'BEGIN' | 'CORE' | 'DESTROY' | 'END' | 'EQ' | 'GE' | 'GT' | 'INIT' | 'LE' | 'LT' | 'NE' | 'CHECK' | 'abs' | 'accept' | 'alarm' | 'and' | 'atan2' | 'bind' | 'binmode' | 'bless' | 'caller' | 'chdir' | 'chmod' | 'chomp' | 'chop' | 'chown' | 'chr' | 'chroot' | 'close' | 'closedir' | 'cmp' | 'connect' | 'continue' | 'cos' | 'crypt' | 'dbmclose' | 'dbmopen' | 'defined' | 'delete' | 'die' | 'do' | 'dump' | 'each' | 'else' | 'elsif' | 'endgrent' | 'endhostent' | 'endnetent' | 'endprotoent' | 'endpwent' | 'endservent' | 'eof' | 'eq' | 'eval' | 'exec' | 'exists' | 'exit' | 'exp' | 'fcntl' | 'fileno' | 'flock' | 'for' | 'foreach' | 'fork' | 'format' | 'formline' | 'ge' | 'getc' | 'getgrent' | 'getgrgid' | 'getgrnam' | 'gethostbyaddr' | 'gethostbyname' | 'gethostent' | 'getlogin' | 'getnetbyaddr' | 'getnetbyname' | 'getnetent' | 'getpeername' | 'getpgrp' | 'getppid' | 'getpriority' | 'getprotobyname' | 'getprotobynumber' | 'getprotoent' | 'getpwent' | 'getpwnam' | 'getpwuid' | 'getservbyname' | 'getservbyport' | 'getservent' | 'getsockname' | 'getsockopt' | 'glob' | 'gmtime' | 'goto' | 'grep' | 'gt' | 'hex' | 'if' | 'index' | 'int' | 'ioctl' | 'join' | 'keys' | 'kill' | 'last' | 'lc' | 'lcfirst' | 'le' | 'length' | 'link' | 'listen' | 'local' | 'localtime' | 'lock' | 'log' | 'lstat' | 'lt' | 'map' | 'mkdir' | 'msgctl' | 'msgget' | 'msgrcv' | 'msgsnd' | 'my' | 'ne' | 'next' | 'no' | 'not' | 'oct' | 'open' | 'opendir' | 'or' | 'ord' | 'our' | 'pack' | 'package' | 'pipe' | 'pop' | 'pos' | 'print' | 'printf' | 'prototype' | 'push' | 'quotemeta' | 'rand' | 'read' | 'readdir' | 'readline' | 'readlink' | 'readpipe' | 'recv' | 'redo' | 'ref' | 'rename' | 'require' | 'reset' | 'return' | 'reverse' | 'rewinddir' | 'rindex' | 'rmdir' | 'scalar' | 'seek' | 'seekdir' | 'select' | 'semctl' | 'semget' | 'semop' | 'send' | 'setgrent' | 'sethostent' | 'setnetent' | 'setpgrp' | 'setpriority' | 'setprotoent' | 'setpwent' | 'setservent' | 'setsockopt' | 'shift' | 'shmctl' | 'shmget' | 'shmread' | 'shmwrite' | 'shutdown' | 'sin' | 'sleep' | 'socket' | 'socketpair' | 'sort' | 'splice' | 'split' | 'sprintf' | 'sqrt' | 'srand' | 'stat' | 'study' | 'sub' | 'substr' | 'symlink' | 'syscall' | 'sysopen' | 'sysread' | 'sysseek' | 'system' | 'syswrite' | 'tell' | 'telldir' | 'tie' | 'tied' | 'time' | 'times' | 'truncate' | 'uc' | 'ucfirst' | 'umask' | 'undef' | 'unless' | 'unlink' | 'unpack' | 'unshift' | 'untie' | 'until' | 'use' | 'utime' | 'values' | 'vec' | 'wait' | 'waitpid' | 'wantarray' | 'warn' | 'while' | 'write' | 'xor' )
            int alt2=242;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:11: 'NULL'
                    {
                    match("NULL"); 



                    }
                    break;
                case 2 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:20: '__FILE__'
                    {
                    match("__FILE__"); 



                    }
                    break;
                case 3 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:33: '__LINE__'
                    {
                    match("__LINE__"); 



                    }
                    break;
                case 4 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:46: '__PACKAGE__'
                    {
                    match("__PACKAGE__"); 



                    }
                    break;
                case 5 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:62: '__DATA__'
                    {
                    match("__DATA__"); 



                    }
                    break;
                case 6 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:75: '__END__'
                    {
                    match("__END__"); 



                    }
                    break;
                case 7 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:57:87: 'AUTOLOAD'
                    {
                    match("AUTOLOAD"); 



                    }
                    break;
                case 8 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:5: 'BEGIN'
                    {
                    match("BEGIN"); 



                    }
                    break;
                case 9 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:15: 'CORE'
                    {
                    match("CORE"); 



                    }
                    break;
                case 10 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:24: 'DESTROY'
                    {
                    match("DESTROY"); 



                    }
                    break;
                case 11 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:36: 'END'
                    {
                    match("END"); 



                    }
                    break;
                case 12 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:44: 'EQ'
                    {
                    match("EQ"); 



                    }
                    break;
                case 13 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:51: 'GE'
                    {
                    match("GE"); 



                    }
                    break;
                case 14 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:58: 'GT'
                    {
                    match("GT"); 



                    }
                    break;
                case 15 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:65: 'INIT'
                    {
                    match("INIT"); 



                    }
                    break;
                case 16 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:74: 'LE'
                    {
                    match("LE"); 



                    }
                    break;
                case 17 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:81: 'LT'
                    {
                    match("LT"); 



                    }
                    break;
                case 18 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:88: 'NE'
                    {
                    match("NE"); 



                    }
                    break;
                case 19 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:58:95: 'CHECK'
                    {
                    match("CHECK"); 



                    }
                    break;
                case 20 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:5: 'abs'
                    {
                    match("abs"); 



                    }
                    break;
                case 21 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:13: 'accept'
                    {
                    match("accept"); 



                    }
                    break;
                case 22 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:24: 'alarm'
                    {
                    match("alarm"); 



                    }
                    break;
                case 23 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:34: 'and'
                    {
                    match("and"); 



                    }
                    break;
                case 24 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:42: 'atan2'
                    {
                    match("atan2"); 



                    }
                    break;
                case 25 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:52: 'bind'
                    {
                    match("bind"); 



                    }
                    break;
                case 26 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:61: 'binmode'
                    {
                    match("binmode"); 



                    }
                    break;
                case 27 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:73: 'bless'
                    {
                    match("bless"); 



                    }
                    break;
                case 28 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:83: 'caller'
                    {
                    match("caller"); 



                    }
                    break;
                case 29 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:59:94: 'chdir'
                    {
                    match("chdir"); 



                    }
                    break;
                case 30 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:5: 'chmod'
                    {
                    match("chmod"); 



                    }
                    break;
                case 31 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:15: 'chomp'
                    {
                    match("chomp"); 



                    }
                    break;
                case 32 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:25: 'chop'
                    {
                    match("chop"); 



                    }
                    break;
                case 33 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:34: 'chown'
                    {
                    match("chown"); 



                    }
                    break;
                case 34 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:44: 'chr'
                    {
                    match("chr"); 



                    }
                    break;
                case 35 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:52: 'chroot'
                    {
                    match("chroot"); 



                    }
                    break;
                case 36 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:63: 'close'
                    {
                    match("close"); 



                    }
                    break;
                case 37 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:73: 'closedir'
                    {
                    match("closedir"); 



                    }
                    break;
                case 38 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:86: 'cmp'
                    {
                    match("cmp"); 



                    }
                    break;
                case 39 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:60:94: 'connect'
                    {
                    match("connect"); 



                    }
                    break;
                case 40 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:5: 'continue'
                    {
                    match("continue"); 



                    }
                    break;
                case 41 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:18: 'cos'
                    {
                    match("cos"); 



                    }
                    break;
                case 42 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:26: 'crypt'
                    {
                    match("crypt"); 



                    }
                    break;
                case 43 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:36: 'dbmclose'
                    {
                    match("dbmclose"); 



                    }
                    break;
                case 44 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:49: 'dbmopen'
                    {
                    match("dbmopen"); 



                    }
                    break;
                case 45 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:61: 'defined'
                    {
                    match("defined"); 



                    }
                    break;
                case 46 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:73: 'delete'
                    {
                    match("delete"); 



                    }
                    break;
                case 47 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:84: 'die'
                    {
                    match("die"); 



                    }
                    break;
                case 48 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:92: 'do'
                    {
                    match("do"); 



                    }
                    break;
                case 49 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:61:99: 'dump'
                    {
                    match("dump"); 



                    }
                    break;
                case 50 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:5: 'each'
                    {
                    match("each"); 



                    }
                    break;
                case 51 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:14: 'else'
                    {
                    match("else"); 



                    }
                    break;
                case 52 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:23: 'elsif'
                    {
                    match("elsif"); 



                    }
                    break;
                case 53 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:33: 'endgrent'
                    {
                    match("endgrent"); 



                    }
                    break;
                case 54 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:46: 'endhostent'
                    {
                    match("endhostent"); 



                    }
                    break;
                case 55 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:61: 'endnetent'
                    {
                    match("endnetent"); 



                    }
                    break;
                case 56 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:75: 'endprotoent'
                    {
                    match("endprotoent"); 



                    }
                    break;
                case 57 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:62:91: 'endpwent'
                    {
                    match("endpwent"); 



                    }
                    break;
                case 58 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:5: 'endservent'
                    {
                    match("endservent"); 



                    }
                    break;
                case 59 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:20: 'eof'
                    {
                    match("eof"); 



                    }
                    break;
                case 60 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:28: 'eq'
                    {
                    match("eq"); 



                    }
                    break;
                case 61 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:35: 'eval'
                    {
                    match("eval"); 



                    }
                    break;
                case 62 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:44: 'exec'
                    {
                    match("exec"); 



                    }
                    break;
                case 63 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:53: 'exists'
                    {
                    match("exists"); 



                    }
                    break;
                case 64 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:64: 'exit'
                    {
                    match("exit"); 



                    }
                    break;
                case 65 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:73: 'exp'
                    {
                    match("exp"); 



                    }
                    break;
                case 66 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:81: 'fcntl'
                    {
                    match("fcntl"); 



                    }
                    break;
                case 67 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:63:91: 'fileno'
                    {
                    match("fileno"); 



                    }
                    break;
                case 68 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:5: 'flock'
                    {
                    match("flock"); 



                    }
                    break;
                case 69 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:15: 'for'
                    {
                    match("for"); 



                    }
                    break;
                case 70 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:23: 'foreach'
                    {
                    match("foreach"); 



                    }
                    break;
                case 71 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:35: 'fork'
                    {
                    match("fork"); 



                    }
                    break;
                case 72 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:44: 'format'
                    {
                    match("format"); 



                    }
                    break;
                case 73 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:55: 'formline'
                    {
                    match("formline"); 



                    }
                    break;
                case 74 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:68: 'ge'
                    {
                    match("ge"); 



                    }
                    break;
                case 75 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:75: 'getc'
                    {
                    match("getc"); 



                    }
                    break;
                case 76 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:84: 'getgrent'
                    {
                    match("getgrent"); 



                    }
                    break;
                case 77 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:64:97: 'getgrgid'
                    {
                    match("getgrgid"); 



                    }
                    break;
                case 78 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:65:5: 'getgrnam'
                    {
                    match("getgrnam"); 



                    }
                    break;
                case 79 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:65:18: 'gethostbyaddr'
                    {
                    match("gethostbyaddr"); 



                    }
                    break;
                case 80 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:65:36: 'gethostbyname'
                    {
                    match("gethostbyname"); 



                    }
                    break;
                case 81 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:65:54: 'gethostent'
                    {
                    match("gethostent"); 



                    }
                    break;
                case 82 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:65:69: 'getlogin'
                    {
                    match("getlogin"); 



                    }
                    break;
                case 83 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:65:82: 'getnetbyaddr'
                    {
                    match("getnetbyaddr"); 



                    }
                    break;
                case 84 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:66:5: 'getnetbyname'
                    {
                    match("getnetbyname"); 



                    }
                    break;
                case 85 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:66:22: 'getnetent'
                    {
                    match("getnetent"); 



                    }
                    break;
                case 86 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:66:36: 'getpeername'
                    {
                    match("getpeername"); 



                    }
                    break;
                case 87 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:66:52: 'getpgrp'
                    {
                    match("getpgrp"); 



                    }
                    break;
                case 88 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:66:64: 'getppid'
                    {
                    match("getppid"); 



                    }
                    break;
                case 89 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:66:76: 'getpriority'
                    {
                    match("getpriority"); 



                    }
                    break;
                case 90 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:67:5: 'getprotobyname'
                    {
                    match("getprotobyname"); 



                    }
                    break;
                case 91 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:67:24: 'getprotobynumber'
                    {
                    match("getprotobynumber"); 



                    }
                    break;
                case 92 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:67:45: 'getprotoent'
                    {
                    match("getprotoent"); 



                    }
                    break;
                case 93 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:67:61: 'getpwent'
                    {
                    match("getpwent"); 



                    }
                    break;
                case 94 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:67:74: 'getpwnam'
                    {
                    match("getpwnam"); 



                    }
                    break;
                case 95 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:67:87: 'getpwuid'
                    {
                    match("getpwuid"); 



                    }
                    break;
                case 96 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:68:5: 'getservbyname'
                    {
                    match("getservbyname"); 



                    }
                    break;
                case 97 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:68:23: 'getservbyport'
                    {
                    match("getservbyport"); 



                    }
                    break;
                case 98 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:68:41: 'getservent'
                    {
                    match("getservent"); 



                    }
                    break;
                case 99 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:68:56: 'getsockname'
                    {
                    match("getsockname"); 



                    }
                    break;
                case 100 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:68:72: 'getsockopt'
                    {
                    match("getsockopt"); 



                    }
                    break;
                case 101 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:68:87: 'glob'
                    {
                    match("glob"); 



                    }
                    break;
                case 102 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:68:96: 'gmtime'
                    {
                    match("gmtime"); 



                    }
                    break;
                case 103 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:5: 'goto'
                    {
                    match("goto"); 



                    }
                    break;
                case 104 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:14: 'grep'
                    {
                    match("grep"); 



                    }
                    break;
                case 105 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:23: 'gt'
                    {
                    match("gt"); 



                    }
                    break;
                case 106 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:30: 'hex'
                    {
                    match("hex"); 



                    }
                    break;
                case 107 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:38: 'if'
                    {
                    match("if"); 



                    }
                    break;
                case 108 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:45: 'index'
                    {
                    match("index"); 



                    }
                    break;
                case 109 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:55: 'int'
                    {
                    match("int"); 



                    }
                    break;
                case 110 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:63: 'ioctl'
                    {
                    match("ioctl"); 



                    }
                    break;
                case 111 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:73: 'join'
                    {
                    match("join"); 



                    }
                    break;
                case 112 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:82: 'keys'
                    {
                    match("keys"); 



                    }
                    break;
                case 113 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:91: 'kill'
                    {
                    match("kill"); 



                    }
                    break;
                case 114 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:69:100: 'last'
                    {
                    match("last"); 



                    }
                    break;
                case 115 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:5: 'lc'
                    {
                    match("lc"); 



                    }
                    break;
                case 116 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:12: 'lcfirst'
                    {
                    match("lcfirst"); 



                    }
                    break;
                case 117 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:24: 'le'
                    {
                    match("le"); 



                    }
                    break;
                case 118 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:31: 'length'
                    {
                    match("length"); 



                    }
                    break;
                case 119 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:42: 'link'
                    {
                    match("link"); 



                    }
                    break;
                case 120 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:51: 'listen'
                    {
                    match("listen"); 



                    }
                    break;
                case 121 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:62: 'local'
                    {
                    match("local"); 



                    }
                    break;
                case 122 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:72: 'localtime'
                    {
                    match("localtime"); 



                    }
                    break;
                case 123 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:86: 'lock'
                    {
                    match("lock"); 



                    }
                    break;
                case 124 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:70:95: 'log'
                    {
                    match("log"); 



                    }
                    break;
                case 125 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:5: 'lstat'
                    {
                    match("lstat"); 



                    }
                    break;
                case 126 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:15: 'lt'
                    {
                    match("lt"); 



                    }
                    break;
                case 127 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:22: 'map'
                    {
                    match("map"); 



                    }
                    break;
                case 128 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:30: 'mkdir'
                    {
                    match("mkdir"); 



                    }
                    break;
                case 129 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:40: 'msgctl'
                    {
                    match("msgctl"); 



                    }
                    break;
                case 130 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:51: 'msgget'
                    {
                    match("msgget"); 



                    }
                    break;
                case 131 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:62: 'msgrcv'
                    {
                    match("msgrcv"); 



                    }
                    break;
                case 132 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:73: 'msgsnd'
                    {
                    match("msgsnd"); 



                    }
                    break;
                case 133 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:84: 'my'
                    {
                    match("my"); 



                    }
                    break;
                case 134 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:71:91: 'ne'
                    {
                    match("ne"); 



                    }
                    break;
                case 135 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:5: 'next'
                    {
                    match("next"); 



                    }
                    break;
                case 136 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:14: 'no'
                    {
                    match("no"); 



                    }
                    break;
                case 137 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:21: 'not'
                    {
                    match("not"); 



                    }
                    break;
                case 138 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:29: 'oct'
                    {
                    match("oct"); 



                    }
                    break;
                case 139 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:37: 'open'
                    {
                    match("open"); 



                    }
                    break;
                case 140 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:46: 'opendir'
                    {
                    match("opendir"); 



                    }
                    break;
                case 141 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:58: 'or'
                    {
                    match("or"); 



                    }
                    break;
                case 142 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:65: 'ord'
                    {
                    match("ord"); 



                    }
                    break;
                case 143 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:73: 'our'
                    {
                    match("our"); 



                    }
                    break;
                case 144 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:81: 'pack'
                    {
                    match("pack"); 



                    }
                    break;
                case 145 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:72:90: 'package'
                    {
                    match("package"); 



                    }
                    break;
                case 146 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:5: 'pipe'
                    {
                    match("pipe"); 



                    }
                    break;
                case 147 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:14: 'pop'
                    {
                    match("pop"); 



                    }
                    break;
                case 148 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:22: 'pos'
                    {
                    match("pos"); 



                    }
                    break;
                case 149 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:30: 'print'
                    {
                    match("print"); 



                    }
                    break;
                case 150 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:40: 'printf'
                    {
                    match("printf"); 



                    }
                    break;
                case 151 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:51: 'prototype'
                    {
                    match("prototype"); 



                    }
                    break;
                case 152 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:65: 'push'
                    {
                    match("push"); 



                    }
                    break;
                case 153 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:73:74: 'quotemeta'
                    {
                    match("quotemeta"); 



                    }
                    break;
                case 154 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:74:5: 'rand'
                    {
                    match("rand"); 



                    }
                    break;
                case 155 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:74:14: 'read'
                    {
                    match("read"); 



                    }
                    break;
                case 156 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:74:23: 'readdir'
                    {
                    match("readdir"); 



                    }
                    break;
                case 157 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:74:35: 'readline'
                    {
                    match("readline"); 



                    }
                    break;
                case 158 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:74:48: 'readlink'
                    {
                    match("readlink"); 



                    }
                    break;
                case 159 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:74:61: 'readpipe'
                    {
                    match("readpipe"); 



                    }
                    break;
                case 160 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:74:74: 'recv'
                    {
                    match("recv"); 



                    }
                    break;
                case 161 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:5: 'redo'
                    {
                    match("redo"); 



                    }
                    break;
                case 162 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:14: 'ref'
                    {
                    match("ref"); 



                    }
                    break;
                case 163 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:22: 'rename'
                    {
                    match("rename"); 



                    }
                    break;
                case 164 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:33: 'require'
                    {
                    match("require"); 



                    }
                    break;
                case 165 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:45: 'reset'
                    {
                    match("reset"); 



                    }
                    break;
                case 166 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:55: 'return'
                    {
                    match("return"); 



                    }
                    break;
                case 167 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:66: 'reverse'
                    {
                    match("reverse"); 



                    }
                    break;
                case 168 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:78: 'rewinddir'
                    {
                    match("rewinddir"); 



                    }
                    break;
                case 169 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:75:92: 'rindex'
                    {
                    match("rindex"); 



                    }
                    break;
                case 170 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:5: 'rmdir'
                    {
                    match("rmdir"); 



                    }
                    break;
                case 171 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:15: 'scalar'
                    {
                    match("scalar"); 



                    }
                    break;
                case 172 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:26: 'seek'
                    {
                    match("seek"); 



                    }
                    break;
                case 173 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:35: 'seekdir'
                    {
                    match("seekdir"); 



                    }
                    break;
                case 174 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:47: 'select'
                    {
                    match("select"); 



                    }
                    break;
                case 175 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:58: 'semctl'
                    {
                    match("semctl"); 



                    }
                    break;
                case 176 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:69: 'semget'
                    {
                    match("semget"); 



                    }
                    break;
                case 177 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:80: 'semop'
                    {
                    match("semop"); 



                    }
                    break;
                case 178 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:76:90: 'send'
                    {
                    match("send"); 



                    }
                    break;
                case 179 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:77:5: 'setgrent'
                    {
                    match("setgrent"); 



                    }
                    break;
                case 180 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:77:18: 'sethostent'
                    {
                    match("sethostent"); 



                    }
                    break;
                case 181 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:77:33: 'setnetent'
                    {
                    match("setnetent"); 



                    }
                    break;
                case 182 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:77:47: 'setpgrp'
                    {
                    match("setpgrp"); 



                    }
                    break;
                case 183 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:77:59: 'setpriority'
                    {
                    match("setpriority"); 



                    }
                    break;
                case 184 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:77:75: 'setprotoent'
                    {
                    match("setprotoent"); 



                    }
                    break;
                case 185 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:77:91: 'setpwent'
                    {
                    match("setpwent"); 



                    }
                    break;
                case 186 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:5: 'setservent'
                    {
                    match("setservent"); 



                    }
                    break;
                case 187 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:20: 'setsockopt'
                    {
                    match("setsockopt"); 



                    }
                    break;
                case 188 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:35: 'shift'
                    {
                    match("shift"); 



                    }
                    break;
                case 189 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:45: 'shmctl'
                    {
                    match("shmctl"); 



                    }
                    break;
                case 190 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:56: 'shmget'
                    {
                    match("shmget"); 



                    }
                    break;
                case 191 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:67: 'shmread'
                    {
                    match("shmread"); 



                    }
                    break;
                case 192 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:79: 'shmwrite'
                    {
                    match("shmwrite"); 



                    }
                    break;
                case 193 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:78:92: 'shutdown'
                    {
                    match("shutdown"); 



                    }
                    break;
                case 194 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:5: 'sin'
                    {
                    match("sin"); 



                    }
                    break;
                case 195 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:13: 'sleep'
                    {
                    match("sleep"); 



                    }
                    break;
                case 196 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:23: 'socket'
                    {
                    match("socket"); 



                    }
                    break;
                case 197 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:34: 'socketpair'
                    {
                    match("socketpair"); 



                    }
                    break;
                case 198 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:49: 'sort'
                    {
                    match("sort"); 



                    }
                    break;
                case 199 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:58: 'splice'
                    {
                    match("splice"); 



                    }
                    break;
                case 200 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:69: 'split'
                    {
                    match("split"); 



                    }
                    break;
                case 201 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:79: 'sprintf'
                    {
                    match("sprintf"); 



                    }
                    break;
                case 202 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:79:91: 'sqrt'
                    {
                    match("sqrt"); 



                    }
                    break;
                case 203 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:5: 'srand'
                    {
                    match("srand"); 



                    }
                    break;
                case 204 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:15: 'stat'
                    {
                    match("stat"); 



                    }
                    break;
                case 205 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:24: 'study'
                    {
                    match("study"); 



                    }
                    break;
                case 206 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:34: 'sub'
                    {
                    match("sub"); 



                    }
                    break;
                case 207 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:42: 'substr'
                    {
                    match("substr"); 



                    }
                    break;
                case 208 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:53: 'symlink'
                    {
                    match("symlink"); 



                    }
                    break;
                case 209 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:65: 'syscall'
                    {
                    match("syscall"); 



                    }
                    break;
                case 210 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:77: 'sysopen'
                    {
                    match("sysopen"); 



                    }
                    break;
                case 211 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:80:89: 'sysread'
                    {
                    match("sysread"); 



                    }
                    break;
                case 212 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:5: 'sysseek'
                    {
                    match("sysseek"); 



                    }
                    break;
                case 213 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:17: 'system'
                    {
                    match("system"); 



                    }
                    break;
                case 214 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:28: 'syswrite'
                    {
                    match("syswrite"); 



                    }
                    break;
                case 215 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:41: 'tell'
                    {
                    match("tell"); 



                    }
                    break;
                case 216 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:50: 'telldir'
                    {
                    match("telldir"); 



                    }
                    break;
                case 217 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:62: 'tie'
                    {
                    match("tie"); 



                    }
                    break;
                case 218 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:70: 'tied'
                    {
                    match("tied"); 



                    }
                    break;
                case 219 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:79: 'time'
                    {
                    match("time"); 



                    }
                    break;
                case 220 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:81:88: 'times'
                    {
                    match("times"); 



                    }
                    break;
                case 221 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:5: 'truncate'
                    {
                    match("truncate"); 



                    }
                    break;
                case 222 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:18: 'uc'
                    {
                    match("uc"); 



                    }
                    break;
                case 223 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:25: 'ucfirst'
                    {
                    match("ucfirst"); 



                    }
                    break;
                case 224 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:37: 'umask'
                    {
                    match("umask"); 



                    }
                    break;
                case 225 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:47: 'undef'
                    {
                    match("undef"); 



                    }
                    break;
                case 226 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:57: 'unless'
                    {
                    match("unless"); 



                    }
                    break;
                case 227 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:68: 'unlink'
                    {
                    match("unlink"); 



                    }
                    break;
                case 228 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:79: 'unpack'
                    {
                    match("unpack"); 



                    }
                    break;
                case 229 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:82:90: 'unshift'
                    {
                    match("unshift"); 



                    }
                    break;
                case 230 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:5: 'untie'
                    {
                    match("untie"); 



                    }
                    break;
                case 231 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:15: 'until'
                    {
                    match("until"); 



                    }
                    break;
                case 232 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:25: 'use'
                    {
                    match("use"); 



                    }
                    break;
                case 233 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:33: 'utime'
                    {
                    match("utime"); 



                    }
                    break;
                case 234 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:43: 'values'
                    {
                    match("values"); 



                    }
                    break;
                case 235 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:54: 'vec'
                    {
                    match("vec"); 



                    }
                    break;
                case 236 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:62: 'wait'
                    {
                    match("wait"); 



                    }
                    break;
                case 237 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:71: 'waitpid'
                    {
                    match("waitpid"); 



                    }
                    break;
                case 238 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:83: 'wantarray'
                    {
                    match("wantarray"); 



                    }
                    break;
                case 239 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:83:97: 'warn'
                    {
                    match("warn"); 



                    }
                    break;
                case 240 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:84:5: 'while'
                    {
                    match("while"); 



                    }
                    break;
                case 241 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:84:15: 'write'
                    {
                    match("write"); 



                    }
                    break;
                case 242 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:84:26: 'xor'
                    {
                    match("xor"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMANDS"

    // $ANTLR start "SPECIAL_VAR"
    public final void mSPECIAL_VAR() throws RecognitionException {
        try {
            int _type = SPECIAL_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:88:2: ( ( '*^A' | '*^C' | '*^D' | '*^E' | '*^F' | '*^I' | '*^L' | '*^N' | '*^O' | '*^P' | '*^R' | '*^S' | '*^T' | '*^V' | '*^W' | '*^X' | '*/' | '*?' | '*%' | '*@' | '*_' | '*-' | '*+' | '*.' | '*|' | '*,' | '*;' | '*~' | '*:' | '*^' | '*<' | '*>' | '*(' | '*)' | '*\\'' | '*\\\\' | '$$m' | '$$s' | '$\"' | '$^A' | '$^C' | '$^D' | '$^E' | '$^F' | '$^H' | '$^I' | '$^L' | '$^M' | '$^N' | '$^O' | '$^P' | '$^R' | '$^S' | '$^T' | '$^V' | '$^W' | '$^X' | '$/' | '$?' | '$%' | '$@' | '$_' | '$-' | '$+' | '$.' | '$|' | '$!' | '$;' | '$~' | '$$' | '$`' | '$<' | '$>' | '$(' | '$)' | '$,' | '$[' | '$]' | '$:' | '$*' | '$#' | '$=' | '$^' | '$&' | '$\\'' | '$\\\\' | '@+' | '@-' | '@_' | '@$' | '%!' | '%@' | '%^H' ) )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:88:4: ( '*^A' | '*^C' | '*^D' | '*^E' | '*^F' | '*^I' | '*^L' | '*^N' | '*^O' | '*^P' | '*^R' | '*^S' | '*^T' | '*^V' | '*^W' | '*^X' | '*/' | '*?' | '*%' | '*@' | '*_' | '*-' | '*+' | '*.' | '*|' | '*,' | '*;' | '*~' | '*:' | '*^' | '*<' | '*>' | '*(' | '*)' | '*\\'' | '*\\\\' | '$$m' | '$$s' | '$\"' | '$^A' | '$^C' | '$^D' | '$^E' | '$^F' | '$^H' | '$^I' | '$^L' | '$^M' | '$^N' | '$^O' | '$^P' | '$^R' | '$^S' | '$^T' | '$^V' | '$^W' | '$^X' | '$/' | '$?' | '$%' | '$@' | '$_' | '$-' | '$+' | '$.' | '$|' | '$!' | '$;' | '$~' | '$$' | '$`' | '$<' | '$>' | '$(' | '$)' | '$,' | '$[' | '$]' | '$:' | '$*' | '$#' | '$=' | '$^' | '$&' | '$\\'' | '$\\\\' | '@+' | '@-' | '@_' | '@$' | '%!' | '%@' | '%^H' )
            {
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:88:4: ( '*^A' | '*^C' | '*^D' | '*^E' | '*^F' | '*^I' | '*^L' | '*^N' | '*^O' | '*^P' | '*^R' | '*^S' | '*^T' | '*^V' | '*^W' | '*^X' | '*/' | '*?' | '*%' | '*@' | '*_' | '*-' | '*+' | '*.' | '*|' | '*,' | '*;' | '*~' | '*:' | '*^' | '*<' | '*>' | '*(' | '*)' | '*\\'' | '*\\\\' | '$$m' | '$$s' | '$\"' | '$^A' | '$^C' | '$^D' | '$^E' | '$^F' | '$^H' | '$^I' | '$^L' | '$^M' | '$^N' | '$^O' | '$^P' | '$^R' | '$^S' | '$^T' | '$^V' | '$^W' | '$^X' | '$/' | '$?' | '$%' | '$@' | '$_' | '$-' | '$+' | '$.' | '$|' | '$!' | '$;' | '$~' | '$$' | '$`' | '$<' | '$>' | '$(' | '$)' | '$,' | '$[' | '$]' | '$:' | '$*' | '$#' | '$=' | '$^' | '$&' | '$\\'' | '$\\\\' | '@+' | '@-' | '@_' | '@$' | '%!' | '%@' | '%^H' )
            int alt3=93;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:4: '*^A'
                    {
                    match("*^A"); 



                    }
                    break;
                case 2 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:12: '*^C'
                    {
                    match("*^C"); 



                    }
                    break;
                case 3 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:20: '*^D'
                    {
                    match("*^D"); 



                    }
                    break;
                case 4 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:28: '*^E'
                    {
                    match("*^E"); 



                    }
                    break;
                case 5 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:36: '*^F'
                    {
                    match("*^F"); 



                    }
                    break;
                case 6 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:44: '*^I'
                    {
                    match("*^I"); 



                    }
                    break;
                case 7 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:52: '*^L'
                    {
                    match("*^L"); 



                    }
                    break;
                case 8 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:89:60: '*^N'
                    {
                    match("*^N"); 



                    }
                    break;
                case 9 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:4: '*^O'
                    {
                    match("*^O"); 



                    }
                    break;
                case 10 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:12: '*^P'
                    {
                    match("*^P"); 



                    }
                    break;
                case 11 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:20: '*^R'
                    {
                    match("*^R"); 



                    }
                    break;
                case 12 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:28: '*^S'
                    {
                    match("*^S"); 



                    }
                    break;
                case 13 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:36: '*^T'
                    {
                    match("*^T"); 



                    }
                    break;
                case 14 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:44: '*^V'
                    {
                    match("*^V"); 



                    }
                    break;
                case 15 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:52: '*^W'
                    {
                    match("*^W"); 



                    }
                    break;
                case 16 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:90:60: '*^X'
                    {
                    match("*^X"); 



                    }
                    break;
                case 17 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:4: '*/'
                    {
                    match("*/"); 



                    }
                    break;
                case 18 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:12: '*?'
                    {
                    match("*?"); 



                    }
                    break;
                case 19 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:19: '*%'
                    {
                    match("*%"); 



                    }
                    break;
                case 20 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:26: '*@'
                    {
                    match("*@"); 



                    }
                    break;
                case 21 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:33: '*_'
                    {
                    match("*_"); 



                    }
                    break;
                case 22 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:40: '*-'
                    {
                    match("*-"); 



                    }
                    break;
                case 23 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:47: '*+'
                    {
                    match("*+"); 



                    }
                    break;
                case 24 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:54: '*.'
                    {
                    match("*."); 



                    }
                    break;
                case 25 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:61: '*|'
                    {
                    match("*|"); 



                    }
                    break;
                case 26 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:91:68: '*,'
                    {
                    match("*,"); 



                    }
                    break;
                case 27 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:4: '*;'
                    {
                    match("*;"); 



                    }
                    break;
                case 28 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:11: '*~'
                    {
                    match("*~"); 



                    }
                    break;
                case 29 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:18: '*:'
                    {
                    match("*:"); 



                    }
                    break;
                case 30 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:25: '*^'
                    {
                    match("*^"); 



                    }
                    break;
                case 31 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:32: '*<'
                    {
                    match("*<"); 



                    }
                    break;
                case 32 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:39: '*>'
                    {
                    match("*>"); 



                    }
                    break;
                case 33 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:46: '*('
                    {
                    match("*("); 



                    }
                    break;
                case 34 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:92:53: '*)'
                    {
                    match("*)"); 



                    }
                    break;
                case 35 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:93:5: '*\\''
                    {
                    match("*'"); 



                    }
                    break;
                case 36 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:93:13: '*\\\\'
                    {
                    match("*\\"); 



                    }
                    break;
                case 37 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:93:21: '$$m'
                    {
                    match("$$m"); 



                    }
                    break;
                case 38 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:93:29: '$$s'
                    {
                    match("$$s"); 



                    }
                    break;
                case 39 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:93:37: '$\"'
                    {
                    match("$\""); 



                    }
                    break;
                case 40 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:4: '$^A'
                    {
                    match("$^A"); 



                    }
                    break;
                case 41 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:12: '$^C'
                    {
                    match("$^C"); 



                    }
                    break;
                case 42 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:20: '$^D'
                    {
                    match("$^D"); 



                    }
                    break;
                case 43 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:28: '$^E'
                    {
                    match("$^E"); 



                    }
                    break;
                case 44 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:36: '$^F'
                    {
                    match("$^F"); 



                    }
                    break;
                case 45 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:44: '$^H'
                    {
                    match("$^H"); 



                    }
                    break;
                case 46 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:52: '$^I'
                    {
                    match("$^I"); 



                    }
                    break;
                case 47 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:60: '$^L'
                    {
                    match("$^L"); 



                    }
                    break;
                case 48 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:94:68: '$^M'
                    {
                    match("$^M"); 



                    }
                    break;
                case 49 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:4: '$^N'
                    {
                    match("$^N"); 



                    }
                    break;
                case 50 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:12: '$^O'
                    {
                    match("$^O"); 



                    }
                    break;
                case 51 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:20: '$^P'
                    {
                    match("$^P"); 



                    }
                    break;
                case 52 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:28: '$^R'
                    {
                    match("$^R"); 



                    }
                    break;
                case 53 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:36: '$^S'
                    {
                    match("$^S"); 



                    }
                    break;
                case 54 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:44: '$^T'
                    {
                    match("$^T"); 



                    }
                    break;
                case 55 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:52: '$^V'
                    {
                    match("$^V"); 



                    }
                    break;
                case 56 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:60: '$^W'
                    {
                    match("$^W"); 



                    }
                    break;
                case 57 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:95:68: '$^X'
                    {
                    match("$^X"); 



                    }
                    break;
                case 58 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:4: '$/'
                    {
                    match("$/"); 



                    }
                    break;
                case 59 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:11: '$?'
                    {
                    match("$?"); 



                    }
                    break;
                case 60 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:18: '$%'
                    {
                    match("$%"); 



                    }
                    break;
                case 61 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:25: '$@'
                    {
                    match("$@"); 



                    }
                    break;
                case 62 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:32: '$_'
                    {
                    match("$_"); 



                    }
                    break;
                case 63 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:39: '$-'
                    {
                    match("$-"); 



                    }
                    break;
                case 64 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:46: '$+'
                    {
                    match("$+"); 



                    }
                    break;
                case 65 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:53: '$.'
                    {
                    match("$."); 



                    }
                    break;
                case 66 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:60: '$|'
                    {
                    match("$|"); 



                    }
                    break;
                case 67 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:96:67: '$!'
                    {
                    match("$!"); 



                    }
                    break;
                case 68 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:4: '$;'
                    {
                    match("$;"); 



                    }
                    break;
                case 69 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:11: '$~'
                    {
                    match("$~"); 



                    }
                    break;
                case 70 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:18: '$$'
                    {
                    match("$$"); 



                    }
                    break;
                case 71 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:25: '$`'
                    {
                    match("$`"); 



                    }
                    break;
                case 72 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:32: '$<'
                    {
                    match("$<"); 



                    }
                    break;
                case 73 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:39: '$>'
                    {
                    match("$>"); 



                    }
                    break;
                case 74 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:46: '$('
                    {
                    match("$("); 



                    }
                    break;
                case 75 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:53: '$)'
                    {
                    match("$)"); 



                    }
                    break;
                case 76 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:97:60: '$,'
                    {
                    match("$,"); 



                    }
                    break;
                case 77 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:4: '$['
                    {
                    match("$["); 



                    }
                    break;
                case 78 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:11: '$]'
                    {
                    match("$]"); 



                    }
                    break;
                case 79 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:18: '$:'
                    {
                    match("$:"); 



                    }
                    break;
                case 80 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:25: '$*'
                    {
                    match("$*"); 



                    }
                    break;
                case 81 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:32: '$#'
                    {
                    match("$#"); 



                    }
                    break;
                case 82 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:39: '$='
                    {
                    match("$="); 



                    }
                    break;
                case 83 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:46: '$^'
                    {
                    match("$^"); 



                    }
                    break;
                case 84 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:98:53: '$&'
                    {
                    match("$&"); 



                    }
                    break;
                case 85 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:4: '$\\''
                    {
                    match("$'"); 



                    }
                    break;
                case 86 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:12: '$\\\\'
                    {
                    match("$\\"); 



                    }
                    break;
                case 87 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:20: '@+'
                    {
                    match("@+"); 



                    }
                    break;
                case 88 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:27: '@-'
                    {
                    match("@-"); 



                    }
                    break;
                case 89 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:34: '@_'
                    {
                    match("@_"); 



                    }
                    break;
                case 90 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:41: '@$'
                    {
                    match("@$"); 



                    }
                    break;
                case 91 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:48: '%!'
                    {
                    match("%!"); 



                    }
                    break;
                case 92 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:55: '%@'
                    {
                    match("%@"); 



                    }
                    break;
                case 93 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:99:62: '%^H'
                    {
                    match("%^H"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPECIAL_VAR"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:103:2: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:103:4: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match('#'); 

            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:103:8: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:103:22: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:103:22: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:107:8: ( ( '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ ( '.' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )? ) | ( '0b' ( '0' | '1' )+ ( '.' ( '0' | '1' )+ )? ) | ( '0' .. '9' ) ( ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt15=1;
                    }
                    break;
                case 'b':
                    {
                    alt15=2;
                    }
                    break;
                default:
                    alt15=3;
                }

            }
            else if ( ((LA15_0 >= '1' && LA15_0 <= '9')) ) {
                alt15=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:108:2: ( '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ ( '.' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )? )
                    {
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:108:2: ( '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ ( '.' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )? )
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:108:3: '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ ( '.' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )?
                    {
                    match("0x"); 



                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:108:8: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'F')||(LA6_0 >= 'a' && LA6_0 <= 'f')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:108:42: ( '.' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='.') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:108:43: '.' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
                            {
                            match('.'); 

                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:108:47: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
                            int cnt7=0;
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'F')||(LA7_0 >= 'a' && LA7_0 <= 'f')) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt7 >= 1 ) break loop7;
                                        EarlyExitException eee =
                                            new EarlyExitException(7, input);
                                        throw eee;
                                }
                                cnt7++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:109:4: ( '0b' ( '0' | '1' )+ ( '.' ( '0' | '1' )+ )? )
                    {
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:109:4: ( '0b' ( '0' | '1' )+ ( '.' ( '0' | '1' )+ )? )
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:109:5: '0b' ( '0' | '1' )+ ( '.' ( '0' | '1' )+ )?
                    {
                    match("0b"); 



                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:109:10: ( '0' | '1' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '0' && LA9_0 <= '1')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:109:23: ( '.' ( '0' | '1' )+ )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='.') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:109:24: '.' ( '0' | '1' )+
                            {
                            match('.'); 

                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:109:28: ( '0' | '1' )+
                            int cnt10=0;
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( ((LA10_0 >= '0' && LA10_0 <= '1')) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt10 >= 1 ) break loop10;
                                        EarlyExitException eee =
                                            new EarlyExitException(10, input);
                                        throw eee;
                                }
                                cnt10++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:110:4: ( '0' .. '9' ) ( ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? )
                    {
                    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:110:15: ( ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? )
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:110:16: ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )?
                    {
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:110:16: ( '0' .. '9' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:110:28: ( '.' ( '0' .. '9' )+ )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='.') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:110:29: '.' ( '0' .. '9' )+
                            {
                            match('.'); 

                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:110:33: ( '0' .. '9' )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt13 >= 1 ) break loop13;
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "SUBST_OR_MATCH_OPER"
    public final void mSUBST_OR_MATCH_OPER() throws RecognitionException {
        try {
            int _type = SUBST_OR_MATCH_OPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:114:2: ( ( 'tr/' | 's/' | 'y/' | 'm/' ) )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:114:4: ( 'tr/' | 's/' | 'y/' | 'm/' )
            {
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:114:4: ( 'tr/' | 's/' | 'y/' | 'm/' )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt16=1;
                }
                break;
            case 's':
                {
                alt16=2;
                }
                break;
            case 'y':
                {
                alt16=3;
                }
                break;
            case 'm':
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:114:5: 'tr/'
                    {
                    match("tr/"); 



                    }
                    break;
                case 2 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:114:13: 's/'
                    {
                    match("s/"); 



                    }
                    break;
                case 3 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:114:20: 'y/'
                    {
                    match("y/"); 



                    }
                    break;
                case 4 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:114:27: 'm/'
                    {
                    match("m/"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUBST_OR_MATCH_OPER"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:117:9: ( '[' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:117:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:118:9: ( ']' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:118:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:119:9: ( '(' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:119:11: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:120:9: ( ')' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:120:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:121:9: ( '{' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:121:11: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:122:9: ( '}' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:122:11: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:125:8: ( ',' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:125:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SEMI_COLON"
    public final void mSEMI_COLON() throws RecognitionException {
        try {
            int _type = SEMI_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:126:12: ( ';' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:126:14: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI_COLON"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:127:8: ( ':' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:127:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:128:6: ( '.' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:128:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:131:7: ( '=' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:131:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:132:6: ( '+' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:132:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:133:7: ( '-' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:133:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULTIPLY"
    public final void mMULTIPLY() throws RecognitionException {
        try {
            int _type = MULTIPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:134:9: ( '*' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:134:11: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTIPLY"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:135:8: ( '/' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:135:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:136:4: ( '>' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:136:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:137:4: ( '<' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:137:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "SQUOTE"
    public final void mSQUOTE() throws RecognitionException {
        try {
            int _type = SQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:140:8: ( '\\'' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:140:10: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SQUOTE"

    // $ANTLR start "DQUOTE"
    public final void mDQUOTE() throws RecognitionException {
        try {
            int _type = DQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:141:8: ( '\"' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:141:10: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DQUOTE"

    // $ANTLR start "BACKSLASH"
    public final void mBACKSLASH() throws RecognitionException {
        try {
            int _type = BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:146:2: ( '$' | '@' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
            {
            if ( input.LA(1)=='$'||input.LA(1)=='@' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BACKSLASH"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:148:2: ( '_' )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:148:4: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:150:10: ( ( '$' | '@' | '%' ) ( '$' | '@' | '%' | '#' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:150:12: ( '$' | '@' | '%' ) ( '$' | '@' | '%' | '#' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            {
            if ( (input.LA(1) >= '$' && input.LA(1) <= '%')||input.LA(1)=='@' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:150:30: ( '$' | '@' | '%' | '#' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0 >= '#' && LA17_0 <= '%')||LA17_0=='@') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                    {
                    if ( (input.LA(1) >= '#' && input.LA(1) <= '%')||input.LA(1)=='@' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:150:55: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '0' && LA18_0 <= '9')||(LA18_0 >= 'A' && LA18_0 <= 'Z')||LA18_0=='_'||(LA18_0 >= 'a' && LA18_0 <= 'z')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "WORD_CHAR"
    public final void mWORD_CHAR() throws RecognitionException {
        try {
            int _type = WORD_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:153:12: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+ )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:153:14: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            {
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:153:14: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= 'A' && LA19_0 <= 'Z')||LA19_0=='_'||(LA19_0 >= 'a' && LA19_0 <= 'z')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WORD_CHAR"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken escaped=null;
            int normal;

            StringBuilder lBuf = new StringBuilder();
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:162:5: ( '\"' (escaped= EscapeSequence |normal=~ ( '\\\"' | '\\\\' ) )+ ( '\"' )? | '\\'' (escaped= EscapeSequence |normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )+ ( '\\'' )? | 'q' ( 'q' | 'w' | 'r' )? '|' (escaped= EscapeSequence |normal=~ ( '\\|' | '\\\\' | '\\n' | '\\r' ) )+ '|' | 'q' ( 'q' | 'w' | 'r' )? '/' (escaped= EscapeSequence |normal=~ ( '\\/' | '\\\\' | '\\n' | '\\r' ) )* ( '/' )? | 'q' ( 'q' | 'w' | 'r' )? '{' (escaped= EscapeSequence |normal=~ ( '\\{' | '\\\\' | '\\n' | '\\r' ) )+ '}' | 'q' ( 'q' | 'w' | 'r' )? '(' (escaped= EscapeSequence |normal=~ ( '\\(' | '\\\\' ) )+ ( ')' )? )
            int alt34=6;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt34=1;
                }
                break;
            case '\'':
                {
                alt34=2;
                }
                break;
            case 'q':
                {
                switch ( input.LA(2) ) {
                case 'q':
                case 'r':
                case 'w':
                    {
                    switch ( input.LA(3) ) {
                    case '|':
                        {
                        alt34=3;
                        }
                        break;
                    case '/':
                        {
                        alt34=4;
                        }
                        break;
                    case '{':
                        {
                        alt34=5;
                        }
                        break;
                    case '(':
                        {
                        alt34=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 4, input);

                        throw nvae;

                    }

                    }
                    break;
                case '|':
                    {
                    alt34=3;
                    }
                    break;
                case '/':
                    {
                    alt34=4;
                    }
                    break;
                case '{':
                    {
                    alt34=5;
                    }
                    break;
                case '(':
                    {
                    alt34=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 3, input);

                    throw nvae;

                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:163:12: '\"' (escaped= EscapeSequence |normal=~ ( '\\\"' | '\\\\' ) )+ ( '\"' )?
                    {
                    match('\"'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:164:12: (escaped= EscapeSequence |normal=~ ( '\\\"' | '\\\\' ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\\') ) {
                            alt20=1;
                        }
                        else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '!')||(LA20_0 >= '#' && LA20_0 <= '[')||(LA20_0 >= ']' && LA20_0 <= '\uFFFF')) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:164:14: escaped= EscapeSequence
                    	    {
                    	    int escapedStart1949 = getCharIndex();
                    	    int escapedStartLine1949 = getLine();
                    	    int escapedStartCharPos1949 = getCharPositionInLine();
                    	    mEscapeSequence(); 
                    	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart1949, getCharIndex()-1);
                    	    escaped.setLine(escapedStartLine1949);
                    	    escaped.setCharPositionInLine(escapedStartCharPos1949);


                    	    lBuf.append(getText());

                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:166:14: normal=~ ( '\\\"' | '\\\\' )
                    	    {
                    	    normal= input.LA(1);

                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    lBuf.appendCodePoint(normal);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:167:12: ( '\"' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='\"') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:167:12: '\"'
                            {
                            match('\"'); 

                            }
                            break;

                    }


                    setText(lBuf.toString());

                    }
                    break;
                case 2 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:170:12: '\\'' (escaped= EscapeSequence |normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )+ ( '\\'' )?
                    {
                    match('\''); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:171:12: (escaped= EscapeSequence |normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=3;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0=='\\') ) {
                            alt22=1;
                        }
                        else if ( ((LA22_0 >= '\u0000' && LA22_0 <= '\t')||(LA22_0 >= '\u000B' && LA22_0 <= '\f')||(LA22_0 >= '\u000E' && LA22_0 <= '&')||(LA22_0 >= '(' && LA22_0 <= '[')||(LA22_0 >= ']' && LA22_0 <= '\uFFFF')) ) {
                            alt22=2;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:171:14: escaped= EscapeSequence
                    	    {
                    	    int escapedStart2076 = getCharIndex();
                    	    int escapedStartLine2076 = getLine();
                    	    int escapedStartCharPos2076 = getCharPositionInLine();
                    	    mEscapeSequence(); 
                    	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart2076, getCharIndex()-1);
                    	    escaped.setLine(escapedStartLine2076);
                    	    escaped.setCharPositionInLine(escapedStartCharPos2076);


                    	    lBuf.append(getText());

                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:172:14: normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' )
                    	    {
                    	    normal= input.LA(1);

                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    lBuf.appendCodePoint(normal);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:173:12: ( '\\'' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='\'') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:173:12: '\\''
                            {
                            match('\''); 

                            }
                            break;

                    }


                    setText(lBuf.toString());

                    }
                    break;
                case 3 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:176:12: 'q' ( 'q' | 'w' | 'r' )? '|' (escaped= EscapeSequence |normal=~ ( '\\|' | '\\\\' | '\\n' | '\\r' ) )+ '|'
                    {
                    match('q'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:176:16: ( 'q' | 'w' | 'r' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( ((LA24_0 >= 'q' && LA24_0 <= 'r')||LA24_0=='w') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                            {
                            if ( (input.LA(1) >= 'q' && input.LA(1) <= 'r')||input.LA(1)=='w' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    match('|'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:177:12: (escaped= EscapeSequence |normal=~ ( '\\|' | '\\\\' | '\\n' | '\\r' ) )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=3;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0=='\\') ) {
                            alt25=1;
                        }
                        else if ( ((LA25_0 >= '\u0000' && LA25_0 <= '\t')||(LA25_0 >= '\u000B' && LA25_0 <= '\f')||(LA25_0 >= '\u000E' && LA25_0 <= '[')||(LA25_0 >= ']' && LA25_0 <= '{')||(LA25_0 >= '}' && LA25_0 <= '\uFFFF')) ) {
                            alt25=2;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:177:14: escaped= EscapeSequence
                    	    {
                    	    int escapedStart2201 = getCharIndex();
                    	    int escapedStartLine2201 = getLine();
                    	    int escapedStartCharPos2201 = getCharPositionInLine();
                    	    mEscapeSequence(); 
                    	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart2201, getCharIndex()-1);
                    	    escaped.setLine(escapedStartLine2201);
                    	    escaped.setCharPositionInLine(escapedStartCharPos2201);


                    	    lBuf.append(getText());

                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:178:14: normal=~ ( '\\|' | '\\\\' | '\\n' | '\\r' )
                    	    {
                    	    normal= input.LA(1);

                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '{')||(input.LA(1) >= '}' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    lBuf.appendCodePoint(normal);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    match('|'); 

                    setText(lBuf.toString());

                    }
                    break;
                case 4 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:182:12: 'q' ( 'q' | 'w' | 'r' )? '/' (escaped= EscapeSequence |normal=~ ( '\\/' | '\\\\' | '\\n' | '\\r' ) )* ( '/' )?
                    {
                    match('q'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:182:16: ( 'q' | 'w' | 'r' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0 >= 'q' && LA26_0 <= 'r')||LA26_0=='w') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                            {
                            if ( (input.LA(1) >= 'q' && input.LA(1) <= 'r')||input.LA(1)=='w' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    match('/'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:183:12: (escaped= EscapeSequence |normal=~ ( '\\/' | '\\\\' | '\\n' | '\\r' ) )*
                    loop27:
                    do {
                        int alt27=3;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0=='\\') ) {
                            alt27=1;
                        }
                        else if ( ((LA27_0 >= '\u0000' && LA27_0 <= '\t')||(LA27_0 >= '\u000B' && LA27_0 <= '\f')||(LA27_0 >= '\u000E' && LA27_0 <= '.')||(LA27_0 >= '0' && LA27_0 <= '[')||(LA27_0 >= ']' && LA27_0 <= '\uFFFF')) ) {
                            alt27=2;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:183:14: escaped= EscapeSequence
                    	    {
                    	    int escapedStart2327 = getCharIndex();
                    	    int escapedStartLine2327 = getLine();
                    	    int escapedStartCharPos2327 = getCharPositionInLine();
                    	    mEscapeSequence(); 
                    	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart2327, getCharIndex()-1);
                    	    escaped.setLine(escapedStartLine2327);
                    	    escaped.setCharPositionInLine(escapedStartCharPos2327);


                    	    lBuf.append(getText());

                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:184:14: normal=~ ( '\\/' | '\\\\' | '\\n' | '\\r' )
                    	    {
                    	    normal= input.LA(1);

                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '.')||(input.LA(1) >= '0' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    lBuf.appendCodePoint(normal);

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:185:12: ( '/' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='/') ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:185:12: '/'
                            {
                            match('/'); 

                            }
                            break;

                    }


                    setText(lBuf.toString());

                    }
                    break;
                case 5 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:188:12: 'q' ( 'q' | 'w' | 'r' )? '{' (escaped= EscapeSequence |normal=~ ( '\\{' | '\\\\' | '\\n' | '\\r' ) )+ '}'
                    {
                    match('q'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:188:16: ( 'q' | 'w' | 'r' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0 >= 'q' && LA29_0 <= 'r')||LA29_0=='w') ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                            {
                            if ( (input.LA(1) >= 'q' && input.LA(1) <= 'r')||input.LA(1)=='w' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    match('{'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:189:12: (escaped= EscapeSequence |normal=~ ( '\\{' | '\\\\' | '\\n' | '\\r' ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=3;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0=='}') ) {
                            int LA30_1 = input.LA(2);

                            if ( ((LA30_1 >= '\u0000' && LA30_1 <= '\t')||(LA30_1 >= '\u000B' && LA30_1 <= '\f')||(LA30_1 >= '\u000E' && LA30_1 <= 'z')||(LA30_1 >= '|' && LA30_1 <= '\uFFFF')) ) {
                                alt30=2;
                            }


                        }
                        else if ( (LA30_0=='\\') ) {
                            alt30=1;
                        }
                        else if ( ((LA30_0 >= '\u0000' && LA30_0 <= '\t')||(LA30_0 >= '\u000B' && LA30_0 <= '\f')||(LA30_0 >= '\u000E' && LA30_0 <= '[')||(LA30_0 >= ']' && LA30_0 <= 'z')||LA30_0=='|'||(LA30_0 >= '~' && LA30_0 <= '\uFFFF')) ) {
                            alt30=2;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:189:14: escaped= EscapeSequence
                    	    {
                    	    int escapedStart2455 = getCharIndex();
                    	    int escapedStartLine2455 = getLine();
                    	    int escapedStartCharPos2455 = getCharPositionInLine();
                    	    mEscapeSequence(); 
                    	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart2455, getCharIndex()-1);
                    	    escaped.setLine(escapedStartLine2455);
                    	    escaped.setCharPositionInLine(escapedStartCharPos2455);


                    	    lBuf.append(getText());

                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:190:14: normal=~ ( '\\{' | '\\\\' | '\\n' | '\\r' )
                    	    {
                    	    normal= input.LA(1);

                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= 'z')||(input.LA(1) >= '|' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    lBuf.appendCodePoint(normal);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);


                    match('}'); 

                    setText(lBuf.toString());

                    }
                    break;
                case 6 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:194:12: 'q' ( 'q' | 'w' | 'r' )? '(' (escaped= EscapeSequence |normal=~ ( '\\(' | '\\\\' ) )+ ( ')' )?
                    {
                    match('q'); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:194:16: ( 'q' | 'w' | 'r' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0 >= 'q' && LA31_0 <= 'r')||LA31_0=='w') ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:
                            {
                            if ( (input.LA(1) >= 'q' && input.LA(1) <= 'r')||input.LA(1)=='w' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    match('('); 

                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:195:12: (escaped= EscapeSequence |normal=~ ( '\\(' | '\\\\' ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=3;
                        int LA32_0 = input.LA(1);

                        if ( ((LA32_0 >= '\u0000' && LA32_0 <= '\'')||(LA32_0 >= ')' && LA32_0 <= '[')||(LA32_0 >= ']' && LA32_0 <= '\uFFFF')) ) {
                            alt32=2;
                        }
                        else if ( (LA32_0=='\\') ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:195:14: escaped= EscapeSequence
                    	    {
                    	    int escapedStart2581 = getCharIndex();
                    	    int escapedStartLine2581 = getLine();
                    	    int escapedStartCharPos2581 = getCharPositionInLine();
                    	    mEscapeSequence(); 
                    	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart2581, getCharIndex()-1);
                    	    escaped.setLine(escapedStartLine2581);
                    	    escaped.setCharPositionInLine(escapedStartCharPos2581);


                    	    lBuf.append(getText());

                    	    }
                    	    break;
                    	case 2 :
                    	    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:197:14: normal=~ ( '\\(' | '\\\\' )
                    	    {
                    	    normal= input.LA(1);

                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\'')||(input.LA(1) >= ')' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    lBuf.appendCodePoint(normal);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);


                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:198:12: ( ')' )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==')') ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:198:12: ')'
                            {
                            match(')'); 

                            }
                            break;

                    }


                    setText(lBuf.toString());

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:206:7: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' | '|' ) )
            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:207:7: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' | '|' )
            {
            match('\\'); 

            // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:208:9: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' | '|' )
            int alt35=10;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt35=1;
                }
                break;
            case 'r':
                {
                alt35=2;
                }
                break;
            case 't':
                {
                alt35=3;
                }
                break;
            case 'b':
                {
                alt35=4;
                }
                break;
            case 'f':
                {
                alt35=5;
                }
                break;
            case '\"':
                {
                alt35=6;
                }
                break;
            case '\'':
                {
                alt35=7;
                }
                break;
            case '/':
                {
                alt35=8;
                }
                break;
            case '\\':
                {
                alt35=9;
                }
                break;
            case '|':
                {
                alt35=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:208:13: 'n'
                    {
                    match('n'); 

                    setText("\n");

                    }
                    break;
                case 2 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:209:13: 'r'
                    {
                    match('r'); 

                    setText("\r");

                    }
                    break;
                case 3 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:210:13: 't'
                    {
                    match('t'); 

                    setText("\t");

                    }
                    break;
                case 4 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:211:13: 'b'
                    {
                    match('b'); 

                    setText("\b");

                    }
                    break;
                case 5 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:212:13: 'f'
                    {
                    match('f'); 

                    setText("\f");

                    }
                    break;
                case 6 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:213:13: '\"'
                    {
                    match('\"'); 

                    setText("\"");

                    }
                    break;
                case 7 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:214:13: '\\''
                    {
                    match('\''); 

                    setText("\'");

                    }
                    break;
                case 8 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:215:13: '/'
                    {
                    match('/'); 

                    setText("\\/");

                    }
                    break;
                case 9 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:216:13: '\\\\'
                    {
                    match('\\'); 

                    setText("\\\\");

                    }
                    break;
                case 10 :
                    // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:217:13: '|'
                    {
                    match('|'); 

                    setText("\\|");

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EscapeSequence"

    public void mTokens() throws RecognitionException {
        // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:8: ( WHITESPACE | COMMANDS | SPECIAL_VAR | COMMENT | NUMBER | SUBST_OR_MATCH_OPER | LBRACK | RBRACK | LPAREN | RPAREN | LCURLY | RCURLY | COMMA | SEMI_COLON | COLON | DOT | EQUAL | PLUS | MINUS | MULTIPLY | DIVIDE | GT | LT | SQUOTE | DQUOTE | BACKSLASH | UNDERSCORE | VARIABLE | WORD_CHAR | STRING )
        int alt36=30;
        alt36 = dfa36.predict(input);
        switch (alt36) {
            case 1 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:10: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 2 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:21: COMMANDS
                {
                mCOMMANDS(); 


                }
                break;
            case 3 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:30: SPECIAL_VAR
                {
                mSPECIAL_VAR(); 


                }
                break;
            case 4 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:42: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 5 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:50: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 6 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:57: SUBST_OR_MATCH_OPER
                {
                mSUBST_OR_MATCH_OPER(); 


                }
                break;
            case 7 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:77: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 8 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:84: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 9 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:91: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 10 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:98: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 11 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:105: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 12 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:112: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 13 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:119: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 14 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:125: SEMI_COLON
                {
                mSEMI_COLON(); 


                }
                break;
            case 15 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:136: COLON
                {
                mCOLON(); 


                }
                break;
            case 16 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:142: DOT
                {
                mDOT(); 


                }
                break;
            case 17 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:146: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 18 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:152: PLUS
                {
                mPLUS(); 


                }
                break;
            case 19 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:157: MINUS
                {
                mMINUS(); 


                }
                break;
            case 20 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:163: MULTIPLY
                {
                mMULTIPLY(); 


                }
                break;
            case 21 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:172: DIVIDE
                {
                mDIVIDE(); 


                }
                break;
            case 22 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:179: GT
                {
                mGT(); 


                }
                break;
            case 23 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:182: LT
                {
                mLT(); 


                }
                break;
            case 24 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:185: SQUOTE
                {
                mSQUOTE(); 


                }
                break;
            case 25 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:192: DQUOTE
                {
                mDQUOTE(); 


                }
                break;
            case 26 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:199: BACKSLASH
                {
                mBACKSLASH(); 


                }
                break;
            case 27 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:209: UNDERSCORE
                {
                mUNDERSCORE(); 


                }
                break;
            case 28 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:220: VARIABLE
                {
                mVARIABLE(); 


                }
                break;
            case 29 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:229: WORD_CHAR
                {
                mWORD_CHAR(); 


                }
                break;
            case 30 :
                // D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\Perl.g:1:239: STRING
                {
                mSTRING(); 


                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA2_eotS =
        "\113\uffff\1\u00a0\13\uffff\1\u00a4\1\u00a6\10\uffff\1\u00ad\1\u00af"+
        "\2\uffff\1\u00b2\31\uffff\1\u00d7\22\uffff\1\u00e6\13\uffff\1\u00f8"+
        "\61\uffff\1\u011a\3\uffff\1\u0123\61\uffff\1\u013a\1\u013c\1\uffff"+
        "\1\u0141\1\u0143\26\uffff\1\u014d\2\uffff\1\u014f\3\uffff\1\u0153"+
        "\1\u0155\16\uffff\1\u0163\4\uffff\1\u0165\53\uffff\1\u0172\41\uffff";
    static final String DFA2_eofS =
        "\u018b\uffff";
    static final String DFA2_minS =
        "\1\101\1\105\1\137\2\uffff\1\110\1\uffff\1\116\1\105\1\uffff\1\105"+
        "\1\142\1\151\1\141\1\142\1\141\1\143\1\145\1\uffff\1\146\1\uffff"+
        "\1\145\2\141\1\145\1\143\1\141\1\uffff\1\141\1\143\1\145\1\143\2"+
        "\141\3\uffff\1\104\15\uffff\1\156\2\uffff\1\144\1\157\1\uffff\1"+
        "\156\1\uffff\1\155\1\146\4\uffff\1\163\1\144\3\uffff\1\145\3\uffff"+
        "\1\162\1\164\6\uffff\1\144\4\uffff\1\146\2\156\1\143\4\uffff\1\147"+
        "\1\uffff\1\170\1\164\1\uffff\1\145\1\144\1\uffff\1\143\1\uffff\1"+
        "\160\1\151\2\uffff\1\141\3\uffff\1\145\1\151\2\uffff\1\143\1\154"+
        "\2\uffff\1\141\1\142\1\155\1\154\1\145\1\uffff\1\146\1\uffff\1\144"+
        "\4\uffff\1\151\7\uffff\1\144\2\uffff\1\155\1\157\1\163\1\156\1\uffff"+
        "\1\143\2\uffff\1\145\1\147\1\uffff\1\163\1\uffff\1\145\1\143\11"+
        "\uffff\1\141\1\uffff\1\143\4\uffff\1\156\2\uffff\1\153\2\uffff\1"+
        "\156\1\uffff\1\144\11\uffff\1\153\1\uffff\1\143\1\uffff\1\147\1"+
        "\uffff\1\143\1\uffff\1\153\1\uffff\1\151\3\uffff\1\163\1\uffff\1"+
        "\143\1\154\1\144\1\145\3\uffff\1\145\2\uffff\1\151\1\164\11\uffff"+
        "\1\145\11\uffff\1\162\5\uffff\1\141\2\uffff\1\162\1\157\1\uffff"+
        "\3\145\1\154\5\uffff\1\144\1\141\1\164\2\144\6\uffff\1\147\1\145"+
        "\4\uffff\1\145\1\143\10\uffff\1\144\2\uffff\1\163\2\uffff\1\145"+
        "\1\160\1\144\4\uffff\1\145\1\163\1\164\3\uffff\1\151\1\145\1\162"+
        "\1\143\1\164\4\uffff\1\146\1\uffff\1\151\5\uffff\1\151\3\uffff\1"+
        "\164\17\uffff\1\164\1\142\1\uffff\1\164\3\uffff\1\166\1\153\4\uffff"+
        "\1\156\2\uffff\1\160\1\142\1\171\1\uffff\1\157\1\142\1\156\1\145"+
        "\2\uffff\1\171\1\uffff\1\141\1\142\1\171\5\uffff\1\141\2\uffff\1"+
        "\171\1\uffff\1\156\2\uffff\1\156\2\uffff\1\141\2\uffff";
    static final String DFA2_maxS =
        "\1\170\1\125\1\137\2\uffff\1\117\1\uffff\1\121\1\124\1\uffff\1\124"+
        "\1\164\1\154\1\162\1\165\1\170\1\157\1\164\1\uffff\1\157\1\uffff"+
        "\1\151\1\164\1\171\1\157\2\165\1\uffff\1\155\1\171\1\162\1\164\1"+
        "\145\1\162\3\uffff\1\120\15\uffff\1\156\2\uffff\1\162\1\157\1\uffff"+
        "\1\163\1\uffff\1\155\1\154\4\uffff\1\163\1\144\3\uffff\1\160\3\uffff"+
        "\1\162\1\164\6\uffff\1\164\4\uffff\1\146\1\156\1\163\1\147\4\uffff"+
        "\1\147\1\uffff\1\170\1\164\1\uffff\1\145\1\144\1\uffff\1\143\1\uffff"+
        "\1\163\1\157\2\uffff\1\167\3\uffff\1\164\1\165\2\uffff\2\162\2\uffff"+
        "\1\165\1\142\1\163\1\154\1\155\1\uffff\1\146\1\uffff\1\164\4\uffff"+
        "\1\162\7\uffff\1\155\2\uffff\1\167\1\157\1\163\1\164\1\uffff\1\157"+
        "\2\uffff\1\151\1\163\1\uffff\1\164\1\uffff\1\155\1\163\11\uffff"+
        "\1\153\1\uffff\1\163\4\uffff\1\156\2\uffff\1\153\2\uffff\1\156\1"+
        "\uffff\1\144\11\uffff\1\153\1\uffff\1\157\1\uffff\1\163\1\uffff"+
        "\1\167\1\uffff\1\153\1\uffff\1\151\3\uffff\1\163\1\uffff\1\167\1"+
        "\154\1\144\1\145\3\uffff\1\151\2\uffff\1\151\1\164\11\uffff\1\145"+
        "\11\uffff\1\167\5\uffff\1\154\2\uffff\1\162\1\157\1\uffff\1\145"+
        "\1\167\1\157\1\154\5\uffff\1\144\1\141\1\164\1\160\1\144\6\uffff"+
        "\1\167\1\157\4\uffff\1\145\1\164\10\uffff\1\144\2\uffff\1\163\2"+
        "\uffff\1\154\1\160\1\144\4\uffff\1\156\1\163\1\164\3\uffff\1\157"+
        "\1\165\1\162\1\143\1\164\4\uffff\1\146\1\uffff\1\151\5\uffff\1\157"+
        "\3\uffff\1\164\17\uffff\1\164\1\145\1\uffff\1\164\3\uffff\1\166"+
        "\1\153\4\uffff\1\156\2\uffff\1\160\1\145\1\171\1\uffff\1\157\1\145"+
        "\1\157\1\153\2\uffff\1\171\1\uffff\1\156\1\145\1\171\5\uffff\1\156"+
        "\2\uffff\1\171\1\uffff\1\160\2\uffff\1\156\2\uffff\1\165\2\uffff";
    static final String DFA2_acceptS =
        "\3\uffff\1\7\1\10\1\uffff\1\12\2\uffff\1\17\10\uffff\1\152\1\uffff"+
        "\1\157\6\uffff\1\u0099\6\uffff\1\u00f2\1\1\1\22\1\uffff\1\11\1\23"+
        "\1\13\1\14\1\15\1\16\1\20\1\21\1\24\1\25\1\26\1\27\1\30\1\uffff"+
        "\1\33\1\34\2\uffff\1\46\1\uffff\1\52\2\uffff\1\57\1\60\1\61\1\62"+
        "\2\uffff\1\73\1\74\1\75\1\uffff\1\102\1\103\1\104\2\uffff\1\145"+
        "\1\146\1\147\1\150\1\151\1\153\1\uffff\1\156\1\160\1\161\1\162\4"+
        "\uffff\1\175\1\176\1\177\1\u0080\1\uffff\1\u0085\2\uffff\1\u008a"+
        "\2\uffff\1\u008f\1\uffff\1\u0092\2\uffff\1\u0098\1\u009a\1\uffff"+
        "\1\u00a9\1\u00aa\1\u00ab\2\uffff\1\u00c2\1\u00c3\2\uffff\1\u00ca"+
        "\1\u00cb\5\uffff\1\u00dd\1\uffff\1\u00e0\1\uffff\1\u00e8\1\u00e9"+
        "\1\u00ea\1\u00eb\1\uffff\1\u00f0\1\u00f1\1\2\1\3\1\4\1\5\1\6\1\uffff"+
        "\1\35\1\36\4\uffff\1\51\1\uffff\1\55\1\56\2\uffff\1\76\1\uffff\1"+
        "\101\2\uffff\1\112\1\154\1\155\1\164\1\163\1\166\1\165\1\167\1\170"+
        "\1\uffff\1\174\1\uffff\1\u0087\1\u0086\1\u0089\1\u0088\1\uffff\1"+
        "\u008e\1\u008d\1\uffff\1\u0093\1\u0094\1\uffff\1\u0097\1\uffff\1"+
        "\u00a0\1\u00a1\1\u00a2\1\u00a3\1\u00a4\1\u00a5\1\u00a6\1\u00a7\1"+
        "\u00a8\1\uffff\1\u00ae\1\uffff\1\u00b2\1\uffff\1\u00bc\1\uffff\1"+
        "\u00c1\1\uffff\1\u00c6\1\uffff\1\u00c9\1\u00cc\1\u00cd\1\uffff\1"+
        "\u00d0\4\uffff\1\u00df\1\u00de\1\u00e1\1\uffff\1\u00e4\1\u00e5\2"+
        "\uffff\1\u00ee\1\u00ef\1\31\1\32\1\37\1\40\1\41\1\43\1\42\1\uffff"+
        "\1\47\1\50\1\53\1\54\1\63\1\64\1\65\1\66\1\67\1\uffff\1\72\1\77"+
        "\1\100\1\106\1\107\1\uffff\1\105\1\113\2\uffff\1\122\4\uffff\1\173"+
        "\1\u0081\1\u0082\1\u0083\1\u0084\5\uffff\1\u00af\1\u00b0\1\u00b1"+
        "\1\u00b3\1\u00b4\1\u00b5\2\uffff\1\u00bd\1\u00be\1\u00bf\1\u00c0"+
        "\2\uffff\1\u00cf\1\u00ce\1\u00d1\1\u00d2\1\u00d3\1\u00d4\1\u00d5"+
        "\1\u00d6\1\uffff\1\u00da\1\u00d9\1\uffff\1\u00e2\1\u00e3\3\uffff"+
        "\1\70\1\71\1\110\1\111\3\uffff\1\126\1\127\1\130\5\uffff\1\u008c"+
        "\1\u008b\1\u0091\1\u0090\1\uffff\1\u009c\1\uffff\1\u009f\1\u009b"+
        "\1\u00ad\1\u00ac\1\u00b6\1\uffff\1\u00b9\1\u00ba\1\u00bb\1\uffff"+
        "\1\u00c7\1\u00c8\1\u00d8\1\u00d7\1\u00dc\1\u00db\1\u00e6\1\u00e7"+
        "\1\u00ed\1\u00ec\1\45\1\44\1\114\1\115\1\116\2\uffff\1\131\1\uffff"+
        "\1\135\1\136\1\137\2\uffff\1\172\1\171\1\u0096\1\u0095\1\uffff\1"+
        "\u00b7\1\u00b8\3\uffff\1\125\4\uffff\1\u00c5\1\u00c4\1\uffff\1\121"+
        "\3\uffff\1\142\1\143\1\144\1\u009d\1\u009e\1\uffff\1\123\1\124\1"+
        "\uffff\1\134\1\uffff\1\117\1\120\1\uffff\1\140\1\141\1\uffff\1\132"+
        "\1\133";
    static final String DFA2_specialS =
        "\u018b\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\uffff\1\11\2\uffff\1\12"+
            "\1\uffff\1\1\20\uffff\1\2\1\uffff\1\13\1\14\1\15\1\16\1\17\1"+
            "\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1"+
            "\34\1\35\1\36\1\37\1\40\1\41\1\42",
            "\1\44\17\uffff\1\43",
            "\1\45",
            "",
            "",
            "\1\47\6\uffff\1\46",
            "",
            "\1\50\2\uffff\1\51",
            "\1\52\16\uffff\1\53",
            "",
            "\1\54\16\uffff\1\55",
            "\1\56\1\57\10\uffff\1\60\1\uffff\1\61\5\uffff\1\62",
            "\1\63\2\uffff\1\64",
            "\1\65\6\uffff\1\66\3\uffff\1\67\1\70\1\uffff\1\71\2\uffff\1"+
            "\72",
            "\1\73\2\uffff\1\74\3\uffff\1\75\5\uffff\1\76\5\uffff\1\77",
            "\1\100\12\uffff\1\101\1\uffff\1\102\1\103\1\uffff\1\104\4\uffff"+
            "\1\105\1\uffff\1\106",
            "\1\107\5\uffff\1\110\2\uffff\1\111\2\uffff\1\112",
            "\1\113\6\uffff\1\114\1\115\1\uffff\1\116\2\uffff\1\117\1\uffff"+
            "\1\120",
            "",
            "\1\121\7\uffff\1\122\1\123",
            "",
            "\1\124\3\uffff\1\125",
            "\1\126\1\uffff\1\127\1\uffff\1\130\3\uffff\1\131\5\uffff\1"+
            "\132\3\uffff\1\133\1\134",
            "\1\135\11\uffff\1\136\7\uffff\1\137\5\uffff\1\140",
            "\1\141\11\uffff\1\142",
            "\1\143\14\uffff\1\144\1\uffff\1\145\2\uffff\1\146",
            "\1\147\7\uffff\1\150\5\uffff\1\151\2\uffff\1\152\2\uffff\1"+
            "\153",
            "",
            "\1\154\3\uffff\1\155\3\uffff\1\156\3\uffff\1\157",
            "\1\160\1\uffff\1\161\2\uffff\1\162\1\163\2\uffff\1\164\2\uffff"+
            "\1\165\1\166\1\167\1\170\1\uffff\1\171\1\172\3\uffff\1\173",
            "\1\174\3\uffff\1\175\10\uffff\1\176",
            "\1\177\11\uffff\1\u0080\1\u0081\4\uffff\1\u0082\1\u0083",
            "\1\u0084\3\uffff\1\u0085",
            "\1\u0086\6\uffff\1\u0087\11\uffff\1\u0088",
            "",
            "",
            "",
            "\1\u008c\1\u008d\1\u0089\5\uffff\1\u008a\3\uffff\1\u008b",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008e",
            "",
            "",
            "\1\u008f\10\uffff\1\u0090\1\uffff\1\u0091\2\uffff\1\u0092",
            "\1\u0093",
            "",
            "\1\u0094\4\uffff\1\u0095",
            "",
            "\1\u0096",
            "\1\u0097\5\uffff\1\u0098",
            "",
            "",
            "",
            "",
            "\1\u0099",
            "\1\u009a",
            "",
            "",
            "",
            "\1\u009b\3\uffff\1\u009c\6\uffff\1\u009d",
            "",
            "",
            "",
            "\1\u009e",
            "\1\u009f",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a1\17\uffff\1\u00a2",
            "",
            "",
            "",
            "",
            "\1\u00a3",
            "\1\u00a5",
            "\1\u00a7\4\uffff\1\u00a8",
            "\1\u00a9\3\uffff\1\u00aa",
            "",
            "",
            "",
            "",
            "\1\u00ab",
            "",
            "\1\u00ac",
            "\1\u00ae",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "\1\u00b3",
            "",
            "\1\u00b4\2\uffff\1\u00b5",
            "\1\u00b6\5\uffff\1\u00b7",
            "",
            "",
            "\1\u00b8\1\uffff\1\u00b9\1\u00ba\1\uffff\1\u00bb\7\uffff\1"+
            "\u00bc\2\uffff\1\u00bd\1\uffff\1\u00be\1\u00bf\1\uffff\1\u00c0"+
            "\1\u00c1",
            "",
            "",
            "",
            "\1\u00c2\6\uffff\1\u00c3\1\u00c4\1\u00c5\5\uffff\1\u00c6",
            "\1\u00c7\3\uffff\1\u00c8\7\uffff\1\u00c9",
            "",
            "",
            "\1\u00ca\16\uffff\1\u00cb",
            "\1\u00cc\5\uffff\1\u00cd",
            "",
            "",
            "\1\u00ce\23\uffff\1\u00cf",
            "\1\u00d0",
            "\1\u00d1\5\uffff\1\u00d2",
            "\1\u00d3",
            "\1\u00d4\7\uffff\1\u00d5",
            "",
            "\1\u00d6",
            "",
            "\1\u00d8\7\uffff\1\u00d9\3\uffff\1\u00da\2\uffff\1\u00db\1"+
            "\u00dc",
            "",
            "",
            "",
            "",
            "\1\u00dd\4\uffff\1\u00de\3\uffff\1\u00df",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e0\10\uffff\1\u00e1",
            "",
            "",
            "\1\u00e2\2\uffff\1\u00e3\6\uffff\1\u00e4",
            "\1\u00e5",
            "\1\u00e7",
            "\1\u00e8\5\uffff\1\u00e9",
            "",
            "\1\u00ea\13\uffff\1\u00eb",
            "",
            "",
            "\1\u00ec\3\uffff\1\u00ed",
            "\1\u00ee\1\u00ef\5\uffff\1\u00f0\1\uffff\1\u00f1\2\uffff\1"+
            "\u00f2",
            "",
            "\1\u00f3\1\u00f4",
            "",
            "\1\u00f5\5\uffff\1\u00f6\1\uffff\1\u00f7",
            "\1\u00f9\3\uffff\1\u00fa\1\u00fb\3\uffff\1\u00fc\1\uffff\1"+
            "\u00fd\1\uffff\1\u00fe\2\uffff\1\u00ff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0100\11\uffff\1\u0101",
            "",
            "\1\u0102\3\uffff\1\u0103\12\uffff\1\u0104\1\u0105",
            "",
            "",
            "",
            "",
            "\1\u0106",
            "",
            "",
            "\1\u0107",
            "",
            "",
            "\1\u0108",
            "",
            "\1\u0109",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u010a",
            "",
            "\1\u010b\3\uffff\1\u010c\7\uffff\1\u010d",
            "",
            "\1\u010e\1\u010f\5\uffff\1\u0110\1\uffff\1\u0111\2\uffff\1"+
            "\u0112",
            "",
            "\1\u0113\3\uffff\1\u0114\12\uffff\1\u0115\4\uffff\1\u0116",
            "",
            "\1\u0117",
            "",
            "\1\u0118",
            "",
            "",
            "",
            "\1\u0119",
            "",
            "\1\u011b\13\uffff\1\u011c\2\uffff\1\u011d\1\u011e\1\u011f\2"+
            "\uffff\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0124",
            "",
            "",
            "",
            "\1\u0125\3\uffff\1\u0126",
            "",
            "",
            "\1\u0127",
            "\1\u0128",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0129",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u012a\4\uffff\1\u012b",
            "",
            "",
            "",
            "",
            "",
            "\1\u012c\12\uffff\1\u012d",
            "",
            "",
            "\1\u012e",
            "\1\u012f",
            "",
            "\1\u0130",
            "\1\u0131\1\uffff\1\u0132\10\uffff\1\u0133\1\uffff\1\u0134\4"+
            "\uffff\1\u0135",
            "\1\u0136\11\uffff\1\u0137",
            "\1\u0138",
            "",
            "",
            "",
            "",
            "",
            "\1\u0139",
            "\1\u013b",
            "\1\u013d",
            "\1\u013e\7\uffff\1\u013f\3\uffff\1\u0140",
            "\1\u0142",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0144\12\uffff\1\u0145\4\uffff\1\u0146",
            "\1\u0147\11\uffff\1\u0148",
            "",
            "",
            "",
            "",
            "\1\u0149",
            "\1\u014a\20\uffff\1\u014b",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u014c",
            "",
            "",
            "\1\u014e",
            "",
            "",
            "\1\u0150\6\uffff\1\u0151",
            "\1\u0152",
            "\1\u0154",
            "",
            "",
            "",
            "",
            "\1\u0156\1\uffff\1\u0157\6\uffff\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "",
            "",
            "",
            "\1\u015b\5\uffff\1\u015c",
            "\1\u015d\10\uffff\1\u015e\6\uffff\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "",
            "",
            "",
            "",
            "\1\u0164",
            "",
            "\1\u0166",
            "",
            "",
            "",
            "",
            "",
            "\1\u0167\5\uffff\1\u0168",
            "",
            "",
            "",
            "\1\u0169",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u016a",
            "\1\u016b\2\uffff\1\u016c",
            "",
            "\1\u016d",
            "",
            "",
            "",
            "\1\u016e",
            "\1\u016f",
            "",
            "",
            "",
            "",
            "\1\u0170",
            "",
            "",
            "\1\u0171",
            "\1\u0173\2\uffff\1\u0174",
            "\1\u0175",
            "",
            "\1\u0176",
            "\1\u0177\2\uffff\1\u0178",
            "\1\u0179\1\u017a",
            "\1\u017b\5\uffff\1\u017c",
            "",
            "",
            "\1\u017d",
            "",
            "\1\u017e\14\uffff\1\u017f",
            "\1\u0180\2\uffff\1\u0181",
            "\1\u0182",
            "",
            "",
            "",
            "",
            "",
            "\1\u0183\14\uffff\1\u0184",
            "",
            "",
            "\1\u0185",
            "",
            "\1\u0186\1\uffff\1\u0187",
            "",
            "",
            "\1\u0188",
            "",
            "",
            "\1\u0189\23\uffff\1\u018a",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "57:1: COMMANDS : ( 'NULL' | '__FILE__' | '__LINE__' | '__PACKAGE__' | '__DATA__' | '__END__' | 'AUTOLOAD' | 'BEGIN' | 'CORE' | 'DESTROY' | 'END' | 'EQ' | 'GE' | 'GT' | 'INIT' | 'LE' | 'LT' | 'NE' | 'CHECK' | 'abs' | 'accept' | 'alarm' | 'and' | 'atan2' | 'bind' | 'binmode' | 'bless' | 'caller' | 'chdir' | 'chmod' | 'chomp' | 'chop' | 'chown' | 'chr' | 'chroot' | 'close' | 'closedir' | 'cmp' | 'connect' | 'continue' | 'cos' | 'crypt' | 'dbmclose' | 'dbmopen' | 'defined' | 'delete' | 'die' | 'do' | 'dump' | 'each' | 'else' | 'elsif' | 'endgrent' | 'endhostent' | 'endnetent' | 'endprotoent' | 'endpwent' | 'endservent' | 'eof' | 'eq' | 'eval' | 'exec' | 'exists' | 'exit' | 'exp' | 'fcntl' | 'fileno' | 'flock' | 'for' | 'foreach' | 'fork' | 'format' | 'formline' | 'ge' | 'getc' | 'getgrent' | 'getgrgid' | 'getgrnam' | 'gethostbyaddr' | 'gethostbyname' | 'gethostent' | 'getlogin' | 'getnetbyaddr' | 'getnetbyname' | 'getnetent' | 'getpeername' | 'getpgrp' | 'getppid' | 'getpriority' | 'getprotobyname' | 'getprotobynumber' | 'getprotoent' | 'getpwent' | 'getpwnam' | 'getpwuid' | 'getservbyname' | 'getservbyport' | 'getservent' | 'getsockname' | 'getsockopt' | 'glob' | 'gmtime' | 'goto' | 'grep' | 'gt' | 'hex' | 'if' | 'index' | 'int' | 'ioctl' | 'join' | 'keys' | 'kill' | 'last' | 'lc' | 'lcfirst' | 'le' | 'length' | 'link' | 'listen' | 'local' | 'localtime' | 'lock' | 'log' | 'lstat' | 'lt' | 'map' | 'mkdir' | 'msgctl' | 'msgget' | 'msgrcv' | 'msgsnd' | 'my' | 'ne' | 'next' | 'no' | 'not' | 'oct' | 'open' | 'opendir' | 'or' | 'ord' | 'our' | 'pack' | 'package' | 'pipe' | 'pop' | 'pos' | 'print' | 'printf' | 'prototype' | 'push' | 'quotemeta' | 'rand' | 'read' | 'readdir' | 'readline' | 'readlink' | 'readpipe' | 'recv' | 'redo' | 'ref' | 'rename' | 'require' | 'reset' | 'return' | 'reverse' | 'rewinddir' | 'rindex' | 'rmdir' | 'scalar' | 'seek' | 'seekdir' | 'select' | 'semctl' | 'semget' | 'semop' | 'send' | 'setgrent' | 'sethostent' | 'setnetent' | 'setpgrp' | 'setpriority' | 'setprotoent' | 'setpwent' | 'setservent' | 'setsockopt' | 'shift' | 'shmctl' | 'shmget' | 'shmread' | 'shmwrite' | 'shutdown' | 'sin' | 'sleep' | 'socket' | 'socketpair' | 'sort' | 'splice' | 'split' | 'sprintf' | 'sqrt' | 'srand' | 'stat' | 'study' | 'sub' | 'substr' | 'symlink' | 'syscall' | 'sysopen' | 'sysread' | 'sysseek' | 'system' | 'syswrite' | 'tell' | 'telldir' | 'tie' | 'tied' | 'time' | 'times' | 'truncate' | 'uc' | 'ucfirst' | 'umask' | 'undef' | 'unless' | 'unlink' | 'unpack' | 'unshift' | 'untie' | 'until' | 'use' | 'utime' | 'values' | 'vec' | 'wait' | 'waitpid' | 'wantarray' | 'warn' | 'while' | 'write' | 'xor' );";
        }
    }
    static final String DFA3_eotS =
        "\5\uffff\1\116\23\uffff\1\121\1\uffff\1\144\111\uffff";
    static final String DFA3_eofS =
        "\145\uffff";
    static final String DFA3_minS =
        "\1\44\1\45\1\41\1\44\1\41\1\101\23\uffff\1\155\1\uffff\1\101\111"+
        "\uffff";
    static final String DFA3_maxS =
        "\1\100\2\176\1\137\1\136\1\130\23\uffff\1\163\1\uffff\1\130\111"+
        "\uffff";
    static final String DFA3_acceptS =
        "\6\uffff\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
        "\1\34\1\35\1\37\1\40\1\41\1\42\1\43\1\44\1\uffff\1\47\1\uffff\1"+
        "\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105"+
        "\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121"+
        "\1\122\1\124\1\125\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\135"+
        "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
        "\1\17\1\20\1\36\1\45\1\46\1\106\1\50\1\51\1\52\1\53\1\54\1\55\1"+
        "\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\123";
    static final String DFA3_specialS =
        "\145\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\1\4\4\uffff\1\1\25\uffff\1\3",
            "\1\10\1\uffff\1\27\1\25\1\26\1\uffff\1\14\1\17\1\13\1\15\1"+
            "\6\12\uffff\1\22\1\20\1\23\1\uffff\1\24\1\7\1\11\33\uffff\1"+
            "\30\1\uffff\1\5\1\12\34\uffff\1\16\1\uffff\1\21",
            "\1\45\1\32\1\62\1\31\1\36\1\64\1\65\1\53\1\54\1\61\1\42\1\55"+
            "\1\41\1\43\1\34\12\uffff\1\60\1\46\1\51\1\63\1\52\1\35\1\37"+
            "\32\uffff\1\56\1\66\1\57\1\33\1\40\1\50\33\uffff\1\44\1\uffff"+
            "\1\47",
            "\1\72\6\uffff\1\67\1\uffff\1\70\61\uffff\1\71",
            "\1\73\36\uffff\1\74\35\uffff\1\75",
            "\1\76\1\uffff\1\77\1\100\1\101\1\102\2\uffff\1\103\2\uffff"+
            "\1\104\1\uffff\1\105\1\106\1\107\1\uffff\1\110\1\111\1\112\1"+
            "\uffff\1\113\1\114\1\115",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\117\5\uffff\1\120",
            "",
            "\1\122\1\uffff\1\123\1\124\1\125\1\126\1\uffff\1\127\1\130"+
            "\2\uffff\1\131\1\132\1\133\1\134\1\135\1\uffff\1\136\1\137\1"+
            "\140\1\uffff\1\141\1\142\1\143",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "88:4: ( '*^A' | '*^C' | '*^D' | '*^E' | '*^F' | '*^I' | '*^L' | '*^N' | '*^O' | '*^P' | '*^R' | '*^S' | '*^T' | '*^V' | '*^W' | '*^X' | '*/' | '*?' | '*%' | '*@' | '*_' | '*-' | '*+' | '*.' | '*|' | '*,' | '*;' | '*~' | '*:' | '*^' | '*<' | '*>' | '*(' | '*)' | '*\\'' | '*\\\\' | '$$m' | '$$s' | '$\"' | '$^A' | '$^C' | '$^D' | '$^E' | '$^F' | '$^H' | '$^I' | '$^L' | '$^M' | '$^N' | '$^O' | '$^P' | '$^R' | '$^S' | '$^T' | '$^V' | '$^W' | '$^X' | '$/' | '$?' | '$%' | '$@' | '$_' | '$-' | '$+' | '$.' | '$|' | '$!' | '$;' | '$~' | '$$' | '$`' | '$<' | '$>' | '$(' | '$)' | '$,' | '$[' | '$]' | '$:' | '$*' | '$#' | '$=' | '$^' | '$&' | '$\\'' | '$\\\\' | '@+' | '@-' | '@_' | '@$' | '%!' | '%@' | '%^H' )";
        }
    }
    static final String DFA36_eotS =
        "\2\uffff\1\75\1\101\40\75\1\u00b1\2\u00b7\3\uffff\1\75\20\uffff"+
        "\1\u00bc\1\u00bd\1\uffff\1\75\1\u00bf\1\75\1\uffff\6\75\3\u00bf"+
        "\1\75\2\u00bf\20\75\1\u00bf\5\75\1\u00bf\6\75\1\u00bf\4\75\1\u00bf"+
        "\1\75\1\u00bf\6\75\2\u00bf\3\75\1\u00bf\3\75\1\u00bf\1\uffff\2\u00bf"+
        "\2\75\1\u00bf\10\75\1\uffff\23\75\1\u00bf\12\75\2\uffff\5\u00b0"+
        "\2\uffff\3\u00b0\2\uffff\1\75\1\uffff\12\75\1\u00bf\1\75\1\u00bf"+
        "\2\75\1\u00bf\7\75\1\u00bf\1\75\1\u00bf\1\75\1\u00bf\4\75\1\u00bf"+
        "\4\75\1\u00bf\3\75\1\u00bf\3\75\1\u00bf\5\75\1\u00bf\1\75\1\u00bf"+
        "\12\75\1\u00bf\1\75\1\u00bf\3\75\2\u00bf\1\75\2\u00bf\2\75\2\u00bf"+
        "\10\75\1\u00bf\21\75\1\u00bf\11\75\1\u00bf\3\75\1\u00bf\11\75\1"+
        "\u00bf\2\75\1\u00bf\5\75\1\u00bf\2\u00b0\1\u00bf\7\75\1\u00bf\2"+
        "\75\1\u00bf\3\75\1\u00bf\6\75\1\u00bf\12\75\3\u00bf\6\75\2\u00bf"+
        "\1\75\1\u00bf\4\75\1\u00bf\1\75\1\u00bf\6\75\1\u00bf\1\75\2\u00bf"+
        "\2\75\4\u00bf\2\75\1\u00bf\2\75\1\u00bf\6\75\4\u00bf\2\75\1\u00bf"+
        "\1\75\4\u00bf\11\75\1\u00bf\4\75\1\u00bf\15\75\1\u00bf\2\75\1\u00bf"+
        "\1\75\1\u00bf\11\75\3\u00bf\13\75\1\u00bf\1\75\1\u00bf\10\75\2\u00bf"+
        "\2\75\1\u00bf\1\75\1\u00bf\1\75\4\u00bf\1\75\1\u00bf\2\75\1\u00bf"+
        "\4\75\1\u00bf\7\75\1\u00bf\1\75\1\u00bf\17\75\2\u00bf\3\75\3\u00bf"+
        "\6\75\1\u00bf\7\75\1\u00bf\4\75\1\u00bf\5\75\1\u00bf\10\75\1\u00bf"+
        "\5\75\1\u00bf\2\75\1\u00bf\1\75\2\u00bf\11\75\1\u00bf\2\75\2\u00bf"+
        "\4\75\3\u00bf\3\75\2\u00bf\7\75\1\u00bf\1\75\2\u00bf\6\75\1\u00bf"+
        "\6\75\2\u00bf\1\75\1\u00bf\21\75\1\u00bf\1\75\2\u00bf\1\75\4\u00bf"+
        "\2\75\1\u00bf\5\75\1\u00bf\1\75\1\u00bf\2\75\2\u00bf\1\75\3\u00bf"+
        "\11\75\2\u00bf\3\75\2\u00bf\1\75\1\u00bf\5\75\1\u00bf\4\75\3\u00bf"+
        "\1\75\1\u00bf\6\75\1\u00bf\1\75\2\u00bf\1\75\1\u00bf\2\75\2\u00bf"+
        "\6\75\1\u00bf\11\75\2\u00bf\7\75\1\u00bf\1\75\2\u00bf\2\75\1\u00bf"+
        "\2\75\2\u00bf\1\75\1\u00bf\3\75\1\u00bf\5\75\1\u00bf\3\75\6\u00bf"+
        "\1\75\1\u00bf\1\75\3\u00bf\1\75\2\u00bf\1\75\6\u00bf\3\75\1\u00bf"+
        "\1\75\4\u00bf\2\75\1\u00bf\5\75\3\u00bf\7\75\3\u00bf\1\75\1\u00bf"+
        "\4\75\1\u00bf\2\75\2\u00bf\1\75\2\u00bf\3\75\1\u00bf\6\75\1\u00bf"+
        "\10\75\4\u00bf\1\75\1\u00bf\5\75\1\u00bf\1\75\1\u00bf\1\75\1\u00bf"+
        "\2\75\1\u00bf\10\75\1\u00bf\1\75\2\u00bf\2\75\5\u00bf\4\75\2\u00bf"+
        "\1\75\1\u00bf\2\75\3\u00bf\2\75\2\u00bf\4\75\2\u00bf\2\75\3\u00bf"+
        "\2\75\1\u00bf";
    static final String DFA36_eofS =
        "\u03b5\uffff";
    static final String DFA36_minS =
        "\1\11\1\uffff\1\105\1\101\1\125\1\105\1\110\1\105\1\116\1\105\1"+
        "\116\1\105\1\142\1\151\1\141\1\142\1\141\1\143\2\145\1\146\1\157"+
        "\1\145\1\141\1\57\1\145\1\143\1\141\1\50\1\141\1\57\1\145\1\143"+
        "\2\141\1\157\1\45\1\41\1\43\1\41\2\uffff\1\57\20\uffff\2\0\1\uffff"+
        "\1\114\1\101\1\104\1\uffff\1\124\1\107\1\122\1\105\1\123\1\104\3"+
        "\101\1\111\2\101\1\163\1\143\1\141\1\144\1\141\1\156\1\145\1\154"+
        "\1\144\1\157\1\160\1\156\1\171\1\155\1\146\1\145\1\101\1\155\1\143"+
        "\1\163\1\144\1\146\1\101\1\141\1\145\1\156\1\154\1\157\1\162\1\101"+
        "\1\157\2\164\1\145\1\101\1\170\1\101\1\144\1\143\1\151\1\171\1\154"+
        "\1\163\2\101\1\156\1\143\1\164\1\101\1\160\1\144\1\147\1\101\1\uffff"+
        "\2\101\1\164\1\145\1\101\1\162\1\143\2\160\1\151\1\163\1\157\1\50"+
        "\1\uffff\1\156\1\141\1\156\1\144\1\141\1\145\1\151\1\156\1\145\1"+
        "\143\1\154\1\162\2\141\1\142\1\155\1\154\1\145\1\57\1\101\1\141"+
        "\1\144\1\145\1\151\1\154\1\143\3\151\1\162\2\uffff\5\60\2\uffff"+
        "\3\60\2\uffff\1\114\1\uffff\2\111\2\101\1\116\1\117\1\111\1\105"+
        "\1\103\1\124\1\101\1\124\1\101\1\145\1\162\1\101\1\156\1\144\1\163"+
        "\1\154\1\151\1\157\1\155\1\101\1\163\1\101\1\156\1\101\1\160\1\143"+
        "\1\151\1\145\1\101\1\160\1\150\1\145\1\147\1\101\1\154\1\143\1\163"+
        "\1\101\1\164\1\145\1\143\1\101\1\143\1\142\1\151\1\157\1\160\1\101"+
        "\1\145\1\101\1\164\1\156\1\163\1\154\1\164\1\151\1\147\1\153\1\164"+
        "\1\141\1\101\1\141\1\101\1\151\1\143\1\164\2\101\1\156\2\101\1\153"+
        "\1\145\2\101\1\156\1\164\1\150\1\164\2\144\1\166\1\157\1\101\1\141"+
        "\1\165\1\145\1\165\1\145\1\151\1\144\1\151\1\154\1\153\1\145\1\143"+
        "\1\144\1\147\1\146\1\143\1\164\1\101\1\145\1\153\1\164\2\151\1\164"+
        "\1\156\1\164\1\144\1\101\1\154\1\143\1\154\1\101\1\145\1\156\1\151"+
        "\1\163\2\145\1\141\1\150\1\151\1\101\1\155\1\165\1\101\2\164\1\156"+
        "\1\154\1\164\1\101\2\60\1\101\1\114\1\116\1\103\1\124\1\104\1\114"+
        "\1\116\1\101\1\113\1\122\1\101\1\160\1\155\1\62\1\101\1\157\1\163"+
        "\1\145\1\162\1\144\1\160\1\101\1\156\1\157\2\145\1\151\1\164\1\154"+
        "\1\160\1\156\1\164\3\101\1\146\1\162\1\157\1\145\1\162\1\145\2\101"+
        "\1\164\1\101\1\154\1\156\1\153\1\141\1\101\1\141\1\101\1\162\2\157"+
        "\3\145\1\101\1\155\2\101\1\170\1\154\4\101\1\162\1\164\1\101\1\145"+
        "\1\154\1\101\1\164\1\162\1\164\1\145\1\143\1\156\4\101\1\164\1\157"+
        "\1\101\1\145\4\101\1\155\1\151\1\164\2\162\1\156\1\145\1\162\1\141"+
        "\1\101\1\143\1\164\1\145\1\160\1\101\1\162\1\157\1\145\1\147\1\145"+
        "\2\164\2\145\1\162\1\144\1\160\1\145\1\101\1\143\1\156\1\101\1\144"+
        "\1\101\1\171\1\164\1\151\1\141\1\160\3\145\1\162\3\101\1\143\1\162"+
        "\1\153\1\146\1\163\1\156\1\143\1\151\3\145\1\101\1\141\1\101\2\145"+
        "\2\105\1\113\1\101\1\137\1\117\2\101\1\117\1\164\1\101\1\144\1\101"+
        "\1\162\4\101\1\164\1\101\1\143\1\156\1\101\1\157\3\145\1\101\1\145"+
        "\1\163\1\164\1\157\1\145\1\162\1\163\1\101\1\157\1\101\1\143\1\164"+
        "\1\151\1\145\1\163\1\147\1\164\1\145\1\162\2\151\1\145\1\162\1\143"+
        "\1\145\2\101\1\163\1\150\1\156\3\101\1\154\1\164\1\166\1\144\1\151"+
        "\1\147\1\101\1\164\1\155\3\151\1\145\1\162\1\101\1\156\1\163\1\144"+
        "\1\170\1\101\1\162\1\151\1\164\1\154\1\164\1\101\1\145\1\163\1\164"+
        "\1\162\1\151\1\145\1\162\1\143\1\101\1\154\1\164\1\141\1\151\1\157"+
        "\1\101\1\164\1\145\1\101\1\164\2\101\1\162\1\156\1\154\1\145\1\141"+
        "\1\145\1\155\2\151\1\101\1\141\1\163\2\101\1\163\2\153\1\146\3\101"+
        "\1\163\1\151\1\162\2\101\2\137\1\101\2\137\1\101\1\131\1\101\1\145"+
        "\2\101\1\151\1\164\1\165\1\163\1\156\1\144\1\101\1\156\1\164\1\145"+
        "\1\164\1\156\1\166\2\101\1\150\1\101\2\156\1\151\1\141\1\164\1\151"+
        "\1\142\1\162\1\160\1\144\1\157\1\164\1\156\1\141\1\151\1\166\1\153"+
        "\1\101\1\164\2\101\1\151\4\101\1\162\1\145\1\101\1\171\1\145\1\162"+
        "\1\156\1\160\1\101\1\145\1\101\1\145\1\144\2\101\1\162\3\101\1\156"+
        "\1\164\1\145\1\160\1\157\1\164\1\156\1\166\1\153\2\101\1\144\1\164"+
        "\1\167\2\101\1\146\1\101\1\153\1\154\1\156\1\144\1\153\1\101\1\164"+
        "\1\162\2\164\3\101\1\164\1\101\1\144\1\162\2\137\1\107\1\137\1\101"+
        "\1\104\2\101\1\162\1\101\2\145\2\101\1\164\1\145\1\156\1\157\1\164"+
        "\1\145\1\101\1\145\1\164\1\144\1\155\1\142\1\156\1\171\2\156\2\101"+
        "\1\162\1\157\1\164\1\155\1\144\1\142\1\156\1\101\1\155\2\101\1\160"+
        "\1\164\1\101\2\145\2\101\1\151\1\101\1\164\1\145\1\156\1\101\1\162"+
        "\1\157\1\164\1\145\1\157\1\101\1\145\1\156\1\141\6\101\1\145\1\101"+
        "\1\145\3\101\1\141\2\101\1\105\6\101\1\156\1\164\1\145\1\101\1\156"+
        "\4\101\1\171\1\156\1\101\1\141\1\164\1\141\1\151\1\142\3\101\1\171"+
        "\1\156\1\141\1\160\2\145\1\141\3\101\1\162\1\101\1\156\1\164\1\151"+
        "\1\145\1\101\1\156\1\160\2\101\1\151\2\101\1\171\1\137\1\164\1\101"+
        "\1\156\1\164\1\141\1\164\1\144\1\141\1\101\1\155\1\164\1\171\2\156"+
        "\1\164\1\155\1\164\4\101\1\164\1\101\1\164\1\156\2\164\1\162\1\101"+
        "\1\137\1\101\1\164\1\101\1\144\1\141\1\101\1\144\1\155\1\145\1\171"+
        "\1\156\1\164\1\141\1\157\1\101\1\145\2\101\1\171\1\164\5\101\1\144"+
        "\1\155\1\162\1\145\2\101\1\141\1\101\1\155\1\162\3\101\1\162\1\145"+
        "\2\101\2\155\1\145\1\164\2\101\1\145\1\142\3\101\1\145\1\162\1\101";
    static final String DFA36_maxS =
        "\1\175\1\uffff\1\125\1\172\1\125\1\105\1\117\1\105\1\121\1\124\1"+
        "\116\1\124\1\164\1\154\1\162\1\165\1\170\1\157\1\164\1\145\2\157"+
        "\1\151\1\164\1\171\1\157\2\165\1\174\1\155\1\171\1\162\1\164\1\145"+
        "\1\162\1\157\2\176\2\172\2\uffff\1\57\20\uffff\2\uffff\1\uffff\1"+
        "\114\1\172\1\120\1\uffff\1\124\1\107\1\122\1\105\1\123\1\104\3\172"+
        "\1\111\2\172\1\163\1\143\1\141\1\144\1\141\1\156\1\145\1\154\1\162"+
        "\1\157\1\160\1\163\1\171\1\155\1\154\1\145\1\172\1\155\1\143\1\163"+
        "\1\144\1\146\1\172\1\141\1\160\1\156\1\154\1\157\1\162\1\172\1\157"+
        "\2\164\1\145\1\172\1\170\1\172\1\164\1\143\1\151\1\171\1\154\1\163"+
        "\2\172\1\163\1\147\1\164\1\172\1\160\1\144\1\147\1\172\1\uffff\2"+
        "\172\1\164\1\145\1\172\1\162\1\143\1\160\1\163\1\157\1\163\1\157"+
        "\1\174\1\uffff\1\156\1\167\1\156\1\144\1\141\1\164\1\165\1\156\1"+
        "\145\3\162\1\141\1\165\1\142\1\163\1\154\1\155\1\165\1\172\1\141"+
        "\1\164\1\145\1\151\1\154\1\143\1\162\2\151\1\162\2\uffff\5\172\2"+
        "\uffff\3\172\2\uffff\1\114\1\uffff\2\111\2\101\1\116\1\117\1\111"+
        "\1\105\1\103\1\124\1\172\1\124\1\172\1\145\1\162\1\172\1\156\1\155"+
        "\1\163\1\154\1\151\1\157\1\167\1\172\1\163\1\172\1\164\1\172\1\160"+
        "\1\157\1\151\1\145\1\172\1\160\1\150\1\151\1\163\1\172\1\154\1\143"+
        "\1\164\1\172\1\164\1\145\1\143\1\172\1\163\1\142\1\151\1\157\1\160"+
        "\1\172\1\145\1\172\1\164\1\156\1\163\1\154\1\164\1\151\1\147\1\153"+
        "\1\164\1\153\1\172\1\141\1\172\1\151\1\163\1\164\2\172\1\156\2\172"+
        "\1\153\1\145\2\172\1\156\1\164\1\150\1\164\2\144\1\166\1\157\1\172"+
        "\1\141\1\165\1\145\1\165\1\145\1\151\1\144\1\151\1\154\1\153\1\145"+
        "\1\157\1\144\1\163\1\146\1\167\1\164\1\172\1\145\1\153\1\164\2\151"+
        "\1\164\1\156\1\164\1\144\1\172\1\154\1\167\1\154\1\172\1\145\1\156"+
        "\1\151\1\163\1\145\1\151\1\141\1\150\1\151\1\172\1\155\1\165\1\172"+
        "\2\164\1\156\1\154\1\164\4\172\1\114\1\116\1\103\1\124\1\104\1\114"+
        "\1\116\1\172\1\113\1\122\1\172\1\160\1\155\1\62\1\172\1\157\1\163"+
        "\1\145\1\162\1\144\1\160\1\172\1\156\1\157\2\145\1\151\1\164\1\154"+
        "\1\160\1\156\1\164\3\172\1\146\1\162\1\157\1\145\1\167\1\145\2\172"+
        "\1\164\1\172\1\154\1\156\1\153\1\141\1\172\1\154\1\172\1\162\2\157"+
        "\1\145\1\167\1\157\1\172\1\155\2\172\1\170\1\154\4\172\1\162\1\164"+
        "\1\172\1\145\1\154\1\172\1\164\1\162\1\164\1\145\1\143\1\156\4\172"+
        "\1\164\1\157\1\172\1\145\4\172\1\155\1\151\1\164\2\162\1\156\1\145"+
        "\1\162\1\141\1\172\1\143\1\164\1\145\1\160\1\172\1\162\1\157\1\145"+
        "\1\167\1\157\2\164\2\145\1\162\1\144\1\160\1\145\1\172\1\164\1\156"+
        "\1\172\1\144\1\172\1\171\1\164\1\151\1\141\1\160\3\145\1\162\3\172"+
        "\1\143\1\162\1\153\1\146\1\163\1\156\1\143\1\151\1\154\2\145\1\172"+
        "\1\141\1\172\2\145\2\105\1\113\1\101\1\137\1\117\2\172\1\117\1\164"+
        "\1\172\1\144\1\172\1\162\4\172\1\164\1\172\1\143\1\156\1\172\1\157"+
        "\3\145\1\172\1\145\1\163\1\164\1\157\1\145\1\162\1\163\1\172\1\157"+
        "\1\172\1\143\1\164\1\151\1\156\1\163\1\147\1\164\1\145\1\162\1\151"+
        "\1\157\1\165\1\162\1\143\1\145\2\172\1\163\1\150\1\156\3\172\1\154"+
        "\1\164\1\166\1\144\1\151\1\147\1\172\1\164\1\155\3\151\1\145\1\162"+
        "\1\172\1\156\1\163\1\144\1\170\1\172\1\162\1\151\1\164\1\154\1\164"+
        "\1\172\1\145\1\163\1\164\1\162\1\157\1\145\1\162\1\143\1\172\1\154"+
        "\1\164\1\141\1\151\1\157\1\172\1\164\1\145\1\172\1\164\2\172\1\162"+
        "\1\156\1\154\1\145\1\141\1\145\1\155\2\151\1\172\1\141\1\163\2\172"+
        "\1\163\2\153\1\146\3\172\1\163\1\151\1\162\2\172\2\137\1\101\2\137"+
        "\1\101\1\131\1\172\1\145\2\172\1\151\1\164\1\165\1\163\1\156\1\144"+
        "\1\172\1\156\1\164\1\145\1\164\1\156\1\166\2\172\1\150\1\172\2\156"+
        "\1\151\1\141\1\164\1\151\1\145\1\162\1\160\1\144\1\157\1\164\1\156"+
        "\1\141\1\151\1\166\1\153\1\172\1\164\2\172\1\151\4\172\1\162\1\145"+
        "\1\172\1\171\1\145\1\162\1\156\1\160\1\172\1\145\1\172\1\145\1\144"+
        "\2\172\1\162\3\172\1\156\1\164\1\145\1\160\1\157\1\164\1\156\1\166"+
        "\1\153\2\172\1\144\1\164\1\167\2\172\1\146\1\172\1\153\1\154\1\156"+
        "\1\144\1\153\1\172\1\164\1\162\2\164\3\172\1\164\1\172\1\144\1\162"+
        "\2\137\1\107\1\137\1\172\1\104\2\172\1\162\1\172\2\145\2\172\1\164"+
        "\1\145\1\156\1\157\1\164\1\145\1\172\1\145\1\164\1\144\1\155\1\145"+
        "\1\156\1\171\2\156\2\172\1\162\1\157\1\164\1\155\1\144\1\145\1\157"+
        "\1\172\1\155\2\172\1\160\1\164\1\172\1\153\1\145\2\172\1\151\1\172"+
        "\1\164\1\145\1\156\1\172\1\162\1\157\1\164\1\145\1\157\1\172\1\145"+
        "\1\156\1\141\6\172\1\145\1\172\1\145\3\172\1\141\2\172\1\105\6\172"+
        "\1\156\1\164\1\145\1\172\1\156\4\172\1\171\1\156\1\172\1\156\1\164"+
        "\1\141\1\151\1\145\3\172\1\171\1\156\1\141\1\160\2\145\1\141\3\172"+
        "\1\162\1\172\1\156\1\164\1\151\1\145\1\172\1\156\1\160\2\172\1\151"+
        "\2\172\1\171\1\137\1\164\1\172\1\156\1\164\1\156\1\164\1\144\1\141"+
        "\1\172\1\155\1\164\1\171\1\156\1\160\1\164\1\155\1\164\4\172\1\164"+
        "\1\172\1\164\1\156\2\164\1\162\1\172\1\137\1\172\1\164\1\172\1\144"+
        "\1\141\1\172\1\144\1\155\1\145\1\171\1\156\1\164\1\141\1\157\1\172"+
        "\1\145\2\172\1\171\1\164\5\172\1\144\1\155\1\162\1\145\2\172\1\165"+
        "\1\172\1\155\1\162\3\172\1\162\1\145\2\172\2\155\1\145\1\164\2\172"+
        "\1\145\1\142\3\172\1\145\1\162\1\172";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\46\uffff\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\25\1\26\1\27\2\uffff\1"+
        "\35\3\uffff\1\33\101\uffff\1\6\15\uffff\1\36\36\uffff\1\3\1\24\5"+
        "\uffff\1\32\1\34\3\uffff\1\30\1\31\1\uffff\1\2\u02f5\uffff";
    static final String DFA36_specialS =
        "\73\uffff\1\1\1\0\u0378\uffff}>";
    static final String[] DFA36_transitionS = {
            "\2\1\2\uffff\1\1\22\uffff\1\1\1\uffff\1\74\1\50\1\45\1\47\1"+
            "\uffff\1\73\1\55\1\56\1\44\1\66\1\61\1\67\1\64\1\70\12\51\1"+
            "\63\1\62\1\72\1\65\1\71\1\uffff\1\46\1\4\1\5\1\6\1\7\1\10\1"+
            "\75\1\11\1\75\1\12\2\75\1\13\1\75\1\2\14\75\1\53\1\uffff\1\54"+
            "\1\uffff\1\3\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
            "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
            "\1\40\1\41\1\42\1\43\1\52\1\75\1\57\1\uffff\1\60",
            "",
            "\1\77\17\uffff\1\76",
            "\32\75\4\uffff\1\100\1\uffff\32\75",
            "\1\102",
            "\1\103",
            "\1\105\6\uffff\1\104",
            "\1\106",
            "\1\107\2\uffff\1\110",
            "\1\111\16\uffff\1\112",
            "\1\113",
            "\1\114\16\uffff\1\115",
            "\1\116\1\117\10\uffff\1\120\1\uffff\1\121\5\uffff\1\122",
            "\1\123\2\uffff\1\124",
            "\1\125\6\uffff\1\126\3\uffff\1\127\1\130\1\uffff\1\131\2\uffff"+
            "\1\132",
            "\1\133\2\uffff\1\134\3\uffff\1\135\5\uffff\1\136\5\uffff\1"+
            "\137",
            "\1\140\12\uffff\1\141\1\uffff\1\142\1\143\1\uffff\1\144\4\uffff"+
            "\1\145\1\uffff\1\146",
            "\1\147\5\uffff\1\150\2\uffff\1\151\2\uffff\1\152",
            "\1\153\6\uffff\1\154\1\155\1\uffff\1\156\2\uffff\1\157\1\uffff"+
            "\1\160",
            "\1\161",
            "\1\162\7\uffff\1\163\1\164",
            "\1\165",
            "\1\166\3\uffff\1\167",
            "\1\170\1\uffff\1\171\1\uffff\1\172\3\uffff\1\173\5\uffff\1"+
            "\174\3\uffff\1\175\1\176",
            "\1\u0083\61\uffff\1\177\11\uffff\1\u0080\7\uffff\1\u0081\5"+
            "\uffff\1\u0082",
            "\1\u0084\11\uffff\1\u0085",
            "\1\u0086\14\uffff\1\u0087\1\uffff\1\u0088\2\uffff\1\u0089",
            "\1\u008a\7\uffff\1\u008b\5\uffff\1\u008c\2\uffff\1\u008d\2"+
            "\uffff\1\u008e",
            "\1\u0091\6\uffff\1\u0091\101\uffff\2\u0090\2\uffff\1\u008f"+
            "\1\uffff\1\u0090\3\uffff\2\u0091",
            "\1\u0092\3\uffff\1\u0093\3\uffff\1\u0094\3\uffff\1\u0095",
            "\1\u0083\63\uffff\1\u0096\1\uffff\1\u0097\2\uffff\1\u0098\1"+
            "\u0099\2\uffff\1\u009a\2\uffff\1\u009b\1\u009c\1\u009d\1\u009e"+
            "\1\uffff\1\u009f\1\u00a0\3\uffff\1\u00a1",
            "\1\u00a2\3\uffff\1\u00a3\10\uffff\1\u00a4",
            "\1\u00a5\11\uffff\1\u00a6\1\u00a7\4\uffff\1\u00a8\1\u00a9",
            "\1\u00aa\3\uffff\1\u00ab",
            "\1\u00ac\6\uffff\1\u00ad\11\uffff\1\u00ae",
            "\1\u00af",
            "\1\u00b0\1\uffff\3\u00b0\1\uffff\5\u00b0\12\uffff\3\u00b0\1"+
            "\uffff\3\u00b0\33\uffff\1\u00b0\1\uffff\2\u00b0\34\uffff\1\u00b0"+
            "\1\uffff\1\u00b0",
            "\2\u00b0\1\u00b6\1\u00b2\1\u00b3\12\u00b0\12\u00b8\6\u00b0"+
            "\1\u00b4\32\u00b8\4\u00b0\1\u00b5\1\u00b0\32\u00b8\1\uffff\1"+
            "\u00b0\1\uffff\1\u00b0",
            "\1\u00b8\1\u00ba\1\u00b8\5\uffff\1\u00b0\1\uffff\1\u00b0\2"+
            "\uffff\12\u00b8\6\uffff\33\u00b8\4\uffff\1\u00b9\1\uffff\32"+
            "\u00b8",
            "\1\u00b0\1\uffff\3\u00b8\12\uffff\12\u00b8\6\uffff\1\u00bb"+
            "\32\u00b8\3\uffff\1\u00b0\1\u00b8\1\uffff\32\u00b8",
            "",
            "",
            "\1\u0083",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\u0091\1\uffff\2\u0091\1\uffff\31\u0091\1\uffff\uffd8\u0091",
            "\42\u0091\1\uffff\uffdd\u0091",
            "",
            "\1\u00be",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00c3\1\u00c4\1\u00c0\5\uffff\1\u00c1\3\uffff\1\u00c2",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00cb",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4\10\uffff\1\u00d5\1\uffff\1\u00d6\2\uffff\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da\4\uffff\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de\5\uffff\1\u00df",
            "\1\u00e0",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00e6",
            "\1\u00e7\3\uffff\1\u00e8\6\uffff\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\32\75\4\uffff\1\75\1\uffff\23\75\1\u00ee\6\75",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00f3",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u00f4\17\uffff\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\32\75\4\uffff\1\75\1\uffff\5\75\1\u00fb\24\75",
            "\32\75\4\uffff\1\75\1\uffff\15\75\1\u00fc\14\75",
            "\1\u00fd\4\uffff\1\u00fe",
            "\1\u00ff\3\uffff\1\u0100",
            "\1\u0101",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "",
            "\32\75\4\uffff\1\75\1\uffff\27\75\1\u0105\2\75",
            "\32\75\4\uffff\1\75\1\uffff\23\75\1\u0106\6\75",
            "\1\u0107",
            "\1\u0108",
            "\32\75\4\uffff\1\75\1\uffff\3\75\1\u0109\26\75",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d\2\uffff\1\u010e",
            "\1\u010f\5\uffff\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0091\6\uffff\1\u0091\113\uffff\2\u0091",
            "",
            "\1\u0113",
            "\1\u0114\1\uffff\1\u0115\1\u0116\1\uffff\1\u0117\7\uffff\1"+
            "\u0118\2\uffff\1\u0119\1\uffff\1\u011a\1\u011b\1\uffff\1\u011c"+
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121\6\uffff\1\u0122\1\u0123\1\u0124\5\uffff\1\u0125",
            "\1\u0126\3\uffff\1\u0127\7\uffff\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b\16\uffff\1\u012c",
            "\1\u012d\5\uffff\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131\23\uffff\1\u0132",
            "\1\u0133",
            "\1\u0134\5\uffff\1\u0135",
            "\1\u0136",
            "\1\u0137\7\uffff\1\u0138",
            "\1\u0083\105\uffff\1\u0139",
            "\32\75\4\uffff\1\75\1\uffff\5\75\1\u013a\24\75",
            "\1\u013b",
            "\1\u013c\7\uffff\1\u013d\3\uffff\1\u013e\2\uffff\1\u013f\1"+
            "\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145\4\uffff\1\u0146\3\uffff\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "",
            "",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\14\u00b8"+
            "\1\u014b\5\u00b8\1\u014c\7\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "",
            "",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "",
            "",
            "\1\u014d",
            "",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0158",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0159",
            "\1\u015a",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u015b",
            "\1\u015c\10\uffff\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162\2\uffff\1\u0163\6\uffff\1\u0164",
            "\32\75\4\uffff\1\75\1\uffff\16\75\1\u0165\13\75",
            "\1\u0166",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0167\5\uffff\1\u0168",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0169",
            "\1\u016a\13\uffff\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170\3\uffff\1\u0171",
            "\1\u0172\1\u0173\5\uffff\1\u0174\1\uffff\1\u0175\2\uffff\1"+
            "\u0176",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179\1\u017a",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\32\75\4\uffff\1\75\1\uffff\4\75\1\u017e\5\75\1\u017f\1\75"+
            "\1\u0180\15\75",
            "\1\u0181\3\uffff\1\u0182\1\u0183\3\uffff\1\u0184\1\uffff\1"+
            "\u0185\1\uffff\1\u0186\2\uffff\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u018c",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196\11\uffff\1\u0197",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0198",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0199",
            "\1\u019a\3\uffff\1\u019b\12\uffff\1\u019c\1\u019d",
            "\1\u019e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u019f",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01a0",
            "\1\u01a1",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5\3\uffff\1\u01b6\7\uffff\1\u01b7",
            "\1\u01b8",
            "\1\u01b9\1\u01ba\5\uffff\1\u01bb\1\uffff\1\u01bc\2\uffff\1"+
            "\u01bd",
            "\1\u01be",
            "\1\u01bf\3\uffff\1\u01c0\12\uffff\1\u01c1\4\uffff\1\u01c2",
            "\1\u01c3",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\1\u01cc",
            "\32\75\4\uffff\1\75\1\uffff\22\75\1\u01cd\7\75",
            "\1\u01ce",
            "\1\u01cf\13\uffff\1\u01d0\2\uffff\1\u01d1\1\u01d2\1\u01d3\2"+
            "\uffff\1\u01d4",
            "\1\u01d5",
            "\32\75\4\uffff\1\75\1\uffff\3\75\1\u01d6\26\75",
            "\1\u01d7",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "\1\u01db",
            "\1\u01dc\3\uffff\1\u01dd",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01e1",
            "\1\u01e2",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01e3",
            "\1\u01e4",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\12\u00b8\7\uffff\32\u00b8\4\uffff\1\u00b8\1\uffff\32\u00b8",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01e8",
            "\1\u01e9",
            "\1\u01ea",
            "\1\u01eb",
            "\1\u01ec",
            "\1\u01ed",
            "\1\u01ee",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01ef",
            "\1\u01f0",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01f1",
            "\1\u01f2",
            "\1\u00bf",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01f3",
            "\1\u01f4",
            "\1\u01f5",
            "\1\u01f6",
            "\1\u01f7",
            "\1\u01f8",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u01f9",
            "\1\u01fa",
            "\1\u01fb",
            "\1\u01fc",
            "\1\u01fd",
            "\1\u01fe",
            "\1\u01ff",
            "\1\u0200",
            "\1\u0201",
            "\1\u0202",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0203",
            "\1\u0204",
            "\1\u0205",
            "\1\u0206",
            "\1\u0207\4\uffff\1\u0208",
            "\1\u0209",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u020a",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u020b",
            "\1\u020c",
            "\1\u020d",
            "\1\u020e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u020f\12\uffff\1\u0210",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0211",
            "\1\u0212",
            "\1\u0213",
            "\1\u0214",
            "\1\u0215\1\uffff\1\u0216\10\uffff\1\u0217\1\uffff\1\u0218\4"+
            "\uffff\1\u0219",
            "\1\u021a\11\uffff\1\u021b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u021c",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u021d",
            "\1\u021e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u021f",
            "\1\u0220",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0221",
            "\1\u0222",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0223",
            "\1\u0224",
            "\1\u0225",
            "\1\u0226",
            "\1\u0227",
            "\1\u0228",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\3\75\1\u0229\26\75",
            "\32\75\4\uffff\1\75\1\uffff\1\u022a\31\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u022b",
            "\1\u022c",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u022d",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\3\75\1\u022e\7\75\1\u022f\3\75"+
            "\1\u0230\12\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0231",
            "\1\u0232",
            "\1\u0233",
            "\1\u0234",
            "\1\u0235",
            "\1\u0236",
            "\1\u0237",
            "\1\u0238",
            "\1\u0239",
            "\32\75\4\uffff\1\75\1\uffff\3\75\1\u023a\26\75",
            "\1\u023b",
            "\1\u023c",
            "\1\u023d",
            "\1\u023e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u023f",
            "\1\u0240",
            "\1\u0241",
            "\1\u0242\12\uffff\1\u0243\4\uffff\1\u0244",
            "\1\u0245\11\uffff\1\u0246",
            "\1\u0247",
            "\1\u0248",
            "\1\u0249",
            "\1\u024a",
            "\1\u024b",
            "\1\u024c",
            "\1\u024d",
            "\1\u024e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u024f\20\uffff\1\u0250",
            "\1\u0251",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0252",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0253",
            "\1\u0254",
            "\1\u0255",
            "\1\u0256",
            "\1\u0257",
            "\1\u0258",
            "\1\u0259",
            "\1\u025a",
            "\1\u025b",
            "\32\75\4\uffff\1\75\1\uffff\3\75\1\u025c\26\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\22\75\1\u025d\7\75",
            "\1\u025e",
            "\1\u025f",
            "\1\u0260",
            "\1\u0261",
            "\1\u0262",
            "\1\u0263",
            "\1\u0264",
            "\1\u0265",
            "\1\u0266\6\uffff\1\u0267",
            "\1\u0268",
            "\1\u0269",
            "\32\75\4\uffff\1\75\1\uffff\17\75\1\u026a\12\75",
            "\1\u026b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u026c",
            "\1\u026d",
            "\1\u026e",
            "\1\u026f",
            "\1\u0270",
            "\1\u0271",
            "\1\u0272",
            "\1\u0273",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0274",
            "\1\u0275",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0276",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0277",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0278",
            "\32\75\4\uffff\1\75\1\uffff\3\75\1\u0279\26\75",
            "\1\u027a",
            "\1\u027b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u027c",
            "\1\u027d",
            "\1\u027e",
            "\1\u027f",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0280",
            "\1\u0281",
            "\1\u0282",
            "\1\u0283",
            "\1\u0284",
            "\1\u0285",
            "\1\u0286",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0287",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0288",
            "\1\u0289",
            "\1\u028a",
            "\1\u028b\1\uffff\1\u028c\6\uffff\1\u028d",
            "\1\u028e",
            "\1\u028f",
            "\1\u0290",
            "\1\u0291",
            "\1\u0292",
            "\1\u0293",
            "\1\u0294\5\uffff\1\u0295",
            "\1\u0296\10\uffff\1\u0297\6\uffff\1\u0298",
            "\1\u0299",
            "\1\u029a",
            "\1\u029b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u029c",
            "\1\u029d",
            "\1\u029e",
            "\32\75\4\uffff\1\75\1\uffff\23\75\1\u029f\6\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02a0",
            "\1\u02a1",
            "\1\u02a2",
            "\1\u02a3",
            "\1\u02a4",
            "\1\u02a5",
            "\32\75\4\uffff\1\75\1\uffff\5\75\1\u02a6\24\75",
            "\1\u02a7",
            "\1\u02a8",
            "\1\u02a9",
            "\1\u02aa",
            "\1\u02ab",
            "\1\u02ac",
            "\1\u02ad",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02ae",
            "\1\u02af",
            "\1\u02b0",
            "\1\u02b1",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02b2",
            "\1\u02b3",
            "\1\u02b4",
            "\1\u02b5",
            "\1\u02b6",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02b7",
            "\1\u02b8",
            "\1\u02b9",
            "\1\u02ba",
            "\1\u02bb\5\uffff\1\u02bc",
            "\1\u02bd",
            "\1\u02be",
            "\1\u02bf",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02c0",
            "\1\u02c1",
            "\1\u02c2",
            "\1\u02c3",
            "\1\u02c4",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02c5",
            "\1\u02c6",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02c7",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02c8",
            "\1\u02c9",
            "\1\u02ca",
            "\1\u02cb",
            "\1\u02cc",
            "\1\u02cd",
            "\1\u02ce",
            "\1\u02cf",
            "\1\u02d0",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02d1",
            "\1\u02d2",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02d3",
            "\1\u02d4",
            "\1\u02d5",
            "\1\u02d6",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02d7",
            "\1\u02d8",
            "\1\u02d9",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02da",
            "\1\u02db",
            "\1\u02dc",
            "\1\u02dd",
            "\1\u02de",
            "\1\u02df",
            "\1\u02e0",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02e1",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02e2",
            "\1\u02e3",
            "\1\u02e4",
            "\1\u02e5",
            "\1\u02e6",
            "\1\u02e7",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02e8",
            "\1\u02e9",
            "\1\u02ea",
            "\1\u02eb",
            "\1\u02ec",
            "\1\u02ed",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02ee",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u02ef",
            "\1\u02f0",
            "\1\u02f1",
            "\1\u02f2",
            "\1\u02f3",
            "\1\u02f4",
            "\1\u02f5\2\uffff\1\u02f6",
            "\1\u02f7",
            "\1\u02f8",
            "\1\u02f9",
            "\1\u02fa",
            "\1\u02fb",
            "\1\u02fc",
            "\1\u02fd",
            "\1\u02fe",
            "\1\u02ff",
            "\1\u0300",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0301",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0302",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0303",
            "\1\u0304",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0305",
            "\1\u0306",
            "\1\u0307",
            "\1\u0308",
            "\1\u0309",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u030a",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u030b",
            "\1\u030c",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u030d",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u030e",
            "\1\u030f",
            "\1\u0310",
            "\1\u0311",
            "\1\u0312",
            "\1\u0313",
            "\1\u0314",
            "\1\u0315",
            "\1\u0316",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0317",
            "\1\u0318",
            "\1\u0319",
            "\32\75\4\uffff\1\75\1\uffff\17\75\1\u031a\12\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u031b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u031c",
            "\1\u031d",
            "\1\u031e",
            "\1\u031f",
            "\1\u0320",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0321",
            "\1\u0322",
            "\1\u0323",
            "\1\u0324",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0325",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0326",
            "\1\u0327",
            "\1\u0328",
            "\1\u0329",
            "\1\u032a",
            "\1\u032b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u032c",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u032d",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u032e",
            "\1\u032f",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0330",
            "\1\u0331",
            "\1\u0332",
            "\1\u0333",
            "\1\u0334",
            "\1\u0335",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0336",
            "\1\u0337",
            "\1\u0338",
            "\1\u0339",
            "\1\u033a\2\uffff\1\u033b",
            "\1\u033c",
            "\1\u033d",
            "\1\u033e",
            "\1\u033f",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0340",
            "\1\u0341",
            "\1\u0342",
            "\1\u0343",
            "\1\u0344",
            "\1\u0345\2\uffff\1\u0346",
            "\1\u0347\1\u0348",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0349",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u034a",
            "\1\u034b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u034c\5\uffff\1\u034d",
            "\1\u034e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u034f",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0350",
            "\1\u0351",
            "\1\u0352",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0353",
            "\1\u0354",
            "\1\u0355",
            "\1\u0356",
            "\1\u0357",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0358",
            "\1\u0359",
            "\1\u035a",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u035b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u035c",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u035d",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u035e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u035f",
            "\1\u0360",
            "\1\u0361",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0362",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0363",
            "\1\u0364",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0365\14\uffff\1\u0366",
            "\1\u0367",
            "\1\u0368",
            "\1\u0369",
            "\1\u036a\2\uffff\1\u036b",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u036c",
            "\1\u036d",
            "\1\u036e",
            "\1\u036f",
            "\1\u0370",
            "\1\u0371",
            "\1\u0372",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0373",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0374",
            "\1\u0375",
            "\1\u0376",
            "\1\u0377",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0378",
            "\1\u0379",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u037a",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u037b",
            "\1\u037c",
            "\1\u037d",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u037e",
            "\1\u037f",
            "\1\u0380\14\uffff\1\u0381",
            "\1\u0382",
            "\1\u0383",
            "\1\u0384",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0385",
            "\1\u0386",
            "\1\u0387",
            "\1\u0388",
            "\1\u0389\1\uffff\1\u038a",
            "\1\u038b",
            "\1\u038c",
            "\1\u038d",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u038e",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u038f",
            "\1\u0390",
            "\1\u0391",
            "\1\u0392",
            "\1\u0393",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0394",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0395",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0396",
            "\1\u0397",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u0398",
            "\1\u0399",
            "\1\u039a",
            "\1\u039b",
            "\1\u039c",
            "\1\u039d",
            "\1\u039e",
            "\1\u039f",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03a0",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03a1",
            "\1\u03a2",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03a3",
            "\1\u03a4",
            "\1\u03a5",
            "\1\u03a6",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03a7\23\uffff\1\u03a8",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03a9",
            "\1\u03aa",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03ab",
            "\1\u03ac",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03ad",
            "\1\u03ae",
            "\1\u03af",
            "\1\u03b0",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03b1",
            "\1\u03b2",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\32\75\4\uffff\1\75\1\uffff\32\75",
            "\1\u03b3",
            "\1\u03b4",
            "\32\75\4\uffff\1\75\1\uffff\32\75"
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( WHITESPACE | COMMANDS | SPECIAL_VAR | COMMENT | NUMBER | SUBST_OR_MATCH_OPER | LBRACK | RBRACK | LPAREN | RPAREN | LCURLY | RCURLY | COMMA | SEMI_COLON | COLON | DOT | EQUAL | PLUS | MINUS | MULTIPLY | DIVIDE | GT | LT | SQUOTE | DQUOTE | BACKSLASH | UNDERSCORE | VARIABLE | WORD_CHAR | STRING );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_60 = input.LA(1);

                        s = -1;
                        if ( ((LA36_60 >= '\u0000' && LA36_60 <= '!')||(LA36_60 >= '#' && LA36_60 <= '\uFFFF')) ) {s = 145;}

                        else s = 189;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA36_59 = input.LA(1);

                        s = -1;
                        if ( ((LA36_59 >= '\u0000' && LA36_59 <= '\t')||(LA36_59 >= '\u000B' && LA36_59 <= '\f')||(LA36_59 >= '\u000E' && LA36_59 <= '&')||(LA36_59 >= '(' && LA36_59 <= '\uFFFF')) ) {s = 145;}

                        else s = 188;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}