package org.language.perl.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.language.perl.grammar.PerlLexer;
import org.language.perl.grammar.PerlParser;
import org.language.perl.grammar.ThrowingErrorListener;
import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.openide.filesystems.FileObject;

public class Perl5Parser extends Parser {

    private Snapshot snapshot;
    private PerlParser parser;
    private PerlLexer lexer;
    //private CommonTree tree;
    private CommonTokenStream tokens;

    @Override
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

//    public static String parse(String text) throws ParseCancellationException {
//        PerlLexer lexer = new PerlLexer(new ANTLRInputStream(text));
//        lexer.removeErrorListeners();
//        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
//
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        PerlParser parser = new PerlParser(tokens);
//        parser.removeErrorListeners();
//        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
//
//        ParserRuleContext tree = parser.prog();
//        MyParseRules extractor = new MyParseRules();
//
//        return extractor.visit(tree);
//    }

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
        
        List<Error> errorList = new ArrayList<Error>();
        List<Block> blockList = new ArrayList<Block>();

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
//            return Collections.<Error>emptyList();
            return errorList;
        }
    }
    
    public class Error implements org.netbeans.modules.csl.api.Error {
        
        String description;
        int offset;
        int length;
        Snapshot snapshot;
        
        public Error( String description, int offset, int length, Snapshot snapshot ) {
            this.description = description;
            this.offset = offset;
            this.length = length;
            this.snapshot = snapshot;
        }
        
        @Override
        public  String getDescription() {
            return description;
        }
        
        public   int getOffset() {
            return offset;
        }
        
        public   int getLength() {
            return length;
        }

        @Override
        public  String getDisplayName() {
            return description;
        }

        @Override
        public  String getKey() {
            return description;
        }

        @Override
        public  FileObject getFile() {
            return snapshot.getSource().getFileObject();
        }

        @Override
        public  int getStartPosition() {
            return offset;
        }

        @Override
        public  int getEndPosition() {
            return offset + length;
        }

        @Override
        public  boolean isLineError() {
            return false;
        }

        @Override
        public  Severity getSeverity() {
            return Severity.ERROR;
        }

        @Override
        public  Object[] getParameters() {
            return null;
        }
        
    }
    
    public class Block {
        
        CharSequence function;
        int offset;
        int length;
        CharSequence extra;
        
        public Block( CharSequence function, int offset, int length, CharSequence extra ) {
            this.function = function;
            this.offset = offset;
            this.length = length;
            this.extra = extra;
        }
        
        public  CharSequence getExtra() { return extra; }
        
        public  CharSequence getDescription() {
            return function;
        }
        
        public int getOffset() {
            return offset;
        }
        
        public int getLength() {
            return length;
        }
        
    }

}

