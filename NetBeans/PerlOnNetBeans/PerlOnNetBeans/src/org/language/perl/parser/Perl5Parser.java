package org.language.perl.parser;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.language.perl.grammar.PerlLexer;
import org.language.perl.grammar.PerlParser;
import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

public class Perl5Parser extends Parser {

    private Snapshot snapshot;
    private PerlParser parser;
    private PerlLexer lexer;
    //private CommonTree tree;
    private CommonTokenStream tokens;

    
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) {
        this.snapshot = snapshot;
        ANTLRInputStream stream = new ANTLRInputStream(snapshot.getText().toString());
        
        lexer = new PerlLexer(stream);
        tokens = new CommonTokenStream(lexer);
        parser = new PerlParser(tokens);
        //parser = new PerlParser(new CommonTokenStream(lexer));

        try {
            parser.prog();
        } catch (RecognitionException ex) {
            Logger.getLogger(PerlParser.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    
    @Override
    public Result getResult(Task task) throws ParseException {
        return new PerlEditorParserResult(snapshot, parser, lexer, /*tree,*/ tokens);
    }

    
    @Override
    public void addChangeListener(ChangeListener cl) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public void removeChangeListener(ChangeListener cl) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    //
    public static class PerlEditorParserResult extends ParserResult {

        private PerlParser parser;
        private PerlLexer lexer;
        //private CommonTree tree;
        private CommonTokenStream tokens;
        private boolean valid = true;

        PerlEditorParserResult(Snapshot snapshot, PerlParser parser, PerlLexer lexer, /*CommonTree tree,*/ CommonTokenStream tokens) {
            super(snapshot);
            this.parser = parser;
            this.lexer = lexer;
            //this.tree = tree;
            this.tokens = tokens;

        }

        public PerlLexer getLexer() {
            return lexer;
        }

//        public CommonTree getTree() {
//            return tree;
//        }

        public CommonTokenStream getTokens() {
            return tokens;
        }

        public PerlParser getPerlParser() throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return parser;
        }

        @Override
        protected void invalidate() {
            valid = false;
        }

        @Override
        public List<? extends Error> getDiagnostics() {
            return Collections.<Error>emptyList();
        }
    }

}
