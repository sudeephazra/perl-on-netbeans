// $ANTLR 3.4 D:\\Source Code\\PerlOnNetBeans_GoogleCode\\branches\\netbeans8\\Grammar\\AntLR 3\\Perl.g 2014-09-28 13:54:13
package org.language.perl.grammar;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class PerlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BACKSLASH", "COLON", "COMMA", "COMMANDS", "COMMENT", "DIVIDE", "DOT", "DQUOTE", "EQUAL", "EscapeSequence", "GT", "LBRACK", "LCURLY", "LPAREN", "LT", "MINUS", "MULTIPLY", "NUMBER", "PLUS", "RBRACK", "RCURLY", "RPAREN", "SEMI_COLON", "SPECIAL_VAR", "SQUOTE", "STRING", "SUBST_OR_MATCH_OPER", "UNDERSCORE", "VARIABLE", "WHITESPACE", "WORD_CHAR"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public PerlParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PerlParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[2+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return PerlParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Source Code\\PerlOnNetBeans_GoogleCode\\branches\\netbeans8\\Grammar\\AntLR 3\\Perl.g"; }


    	
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


    public static class parseSource_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parseSource"
    // D:\\Source Code\\PerlOnNetBeans_GoogleCode\\branches\\netbeans8\\Grammar\\AntLR 3\\Perl.g:50:1: parseSource : ( . )+ EOF ;
    public final PerlParser.parseSource_return parseSource() throws RecognitionException {
        PerlParser.parseSource_return retval = new PerlParser.parseSource_return();
        retval.start = input.LT(1);

        int parseSource_StartIndex = input.index();

        CommonTree root_0 = null;

        Token wildcard1=null;
        Token EOF2=null;

        CommonTree wildcard1_tree=null;
        CommonTree EOF2_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // D:\\Source Code\\PerlOnNetBeans_GoogleCode\\branches\\netbeans8\\Grammar\\AntLR 3\\Perl.g:50:13: ( ( . )+ EOF )
            // D:\\Source Code\\PerlOnNetBeans_GoogleCode\\branches\\netbeans8\\Grammar\\AntLR 3\\Perl.g:50:15: ( . )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // D:\\Source Code\\PerlOnNetBeans_GoogleCode\\branches\\netbeans8\\Grammar\\AntLR 3\\Perl.g:50:15: ( . )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= BACKSLASH && LA1_0 <= WORD_CHAR)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Source Code\\PerlOnNetBeans_GoogleCode\\branches\\netbeans8\\Grammar\\AntLR 3\\Perl.g:50:16: .
            	    {
            	    wildcard1=(Token)input.LT(1);

            	    matchAny(input); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    wildcard1_tree = (CommonTree)adaptor.create(wildcard1);
            	    adaptor.addChild(root_0, wildcard1_tree);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parseSource92); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF2_tree = 
            (CommonTree)adaptor.create(EOF2)
            ;
            adaptor.addChild(root_0, EOF2_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, parseSource_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "parseSource"

    // Delegated rules


 

    public static final BitSet FOLLOW_EOF_in_parseSource92 = new BitSet(new long[]{0x0000000000000002L});

}