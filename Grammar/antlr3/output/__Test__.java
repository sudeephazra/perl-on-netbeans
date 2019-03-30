import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import org.language.perl.grammar.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        PerlLexer lex = new PerlLexer(new ANTLRFileStream("D:\\Source Code\\Bitbucket\\PerlOnNetBeans\\branches\\feature\\grammar_enhancements\\Grammar\\AntLR 3\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        PerlParser g = new PerlParser(tokens, 49100, null);
        try {
            g.parseSource();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}