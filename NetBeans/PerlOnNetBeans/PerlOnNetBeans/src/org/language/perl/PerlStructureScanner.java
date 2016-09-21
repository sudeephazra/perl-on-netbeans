/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.language.perl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;
import org.language.perl.grammar.PerlLexer;
import org.language.perl.parser.Perl5Parser.PerlEditorParserResult;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.StructureItem;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.ParserResult;
import org.openide.text.NbDocument;

public class PerlStructureScanner implements StructureScanner  {

    private final String FOLD_TYPE = "comments";
    
    @Override
    public List<? extends StructureItem> scan(ParserResult pr) {
        return new ArrayList<>();
    }

    @Override
    public Map<String, List<OffsetRange>> folds(ParserResult pr) {
        Map<String, List<OffsetRange>> folds = new HashMap<>();
        Document document = pr.getSnapshot().getSource().getDocument(false);
        collectTokenFolds(folds, pr, document);
//        collectGrammarFolds(folds, Utils.getRoot(pr), document);
        return folds;
    }

    @Override
    public Configuration getConfiguration() {
        return new StructureScanner.Configuration(true, false);
    }
    
    protected static Tree getLastChild(ParserRuleContext tree, int lastToken) {
        Tree lastChild = tree.getChild(tree.getChildCount() - lastToken);
        if (lastChild.getChildCount() > 0) {
            do {
                lastChild = lastChild.getChild(lastChild.getChildCount() - 1);
            } while (lastChild.getChildCount() > 0);
        }
        //System.out.println(lastChild.getText() + '\t' + lastChild.getLine());
        return lastChild;
    }
    
    private void collectTokenFolds(Map<String, List<OffsetRange>> folds, ParserResult pr, Document document) {
        if (pr != null) {
            org.antlr.v4.runtime.CommonTokenStream tokens = ((PerlEditorParserResult) pr).getTokens();
            for (int i = 0; i < tokens.getTokens().size(); i++) {
                Token token = (Token) (tokens.getTokens().get(i));
//                if (token.getType() == PerlLexer.POD) {
//                    addFold(FOLD_TYPE, folds, token, document);
//                }
            }
        }
    }
    
     private void collectGrammarFolds(Map<String, List<OffsetRange>> folds, ParserRuleContext tree, Document document) {
//        if (tree != null) {
//            for (int i = 0; i < tree.getChildCount(); i++) {
//                switch (tree.getChild(i).getType()) {
//                    case PL_SQLLexer.IM_BEGIN_END:
//                        addFold(FOLD_TYPE, folds, (CommonTree) tree.getChild(i), document, 0, 1);
//                        break;
//                    case PL_SQLLexer.IM_IF:
//                        addFold(FOLD_TYPE, folds, (CommonTree) tree.getChild(i), document, 0, 2);
//                        break;
//                    case PL_SQLLexer.IM_LOOP:
//                        addFold(FOLD_TYPE, folds, (CommonTree) tree.getChild(i), document, 0, 2);
//                        break;
//                    case PL_SQLLexer.IM_CASE:
//                        addFold(FOLD_TYPE, folds, (CommonTree) tree.getChild(i), document, 0, 1);
//                        break;
//                    case PL_SQLLexer.IM_FUNC:
//                        addFold(FOLD_TYPE, folds, (CommonTree) tree.getChild(i), document, 1, 1);
//                        break;
//                    case PL_SQLLexer.IM_PROC:
//                        addFold(FOLD_TYPE, folds, (CommonTree) tree.getChild(i), document, 1, 1);
//                        break;
//                }
//
//                collectGrammarFolds(folds, (CommonTree) tree.getChild(i), document);
//            }
//        }
    }
     
    private void addFold(String foldType, Map<String, List<OffsetRange>> folds, ParserRuleContext tree, Document document, int firstToken, int lastToken) {
        ParseTree firstChild = tree.getChild(firstToken);
        ParseTree lastChild = (ParseTree) getLastChild(tree, lastToken);
//        if (firstChild.getLine() != 0 && lastChild.getLine() != 0 && lastChild.getLine() - firstChild.getLine() > 1) {
//            int start = NbDocument.findLineOffset((StyledDocument) document, firstChild.getLine() - 1) + firstChild.getCharPositionInLine() + firstChild.getText().length();
//            int end = NbDocument.findLineOffset((StyledDocument) document, lastChild.getLine() - 1) + lastChild.getCharPositionInLine();
//            createFold(foldType, folds, start, end);
//        }
    }

    private void addFold(String foldType, Map<String, List<OffsetRange>> folds, Token token, Document document) {
        int start = NbDocument.findLineOffset((StyledDocument) document, token.getLine() - 1) + token.getCharPositionInLine();
        int startLine = NbDocument.findLineNumber((StyledDocument) document, start);
        int end = start + token.getText().length();
        int endLine = NbDocument.findLineNumber((StyledDocument) document, end);
        if (endLine - startLine > 1) {
            createFold(foldType, folds, start, end);
        }
    }
    
    private void createFold(String foldType, Map<String, List<OffsetRange>> folds, int start, int end) {
        OffsetRange range = new OffsetRange(start, end);
        List<OffsetRange> fold = folds.get(foldType);
        if (fold == null) {
            fold = new ArrayList<>();
            folds.put(foldType, fold);
        }
        fold.add(range);
    }
    
    
}
