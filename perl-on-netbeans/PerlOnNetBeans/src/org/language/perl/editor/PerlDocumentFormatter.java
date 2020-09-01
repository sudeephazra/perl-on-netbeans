/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.editor;

import java.util.LinkedList;
import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import org.netbeans.api.lexer.Token;
import org.language.perl.lexer.PerlTokenId;
import org.language.perl.parser.Perl5Parser.PerlEditorParserResult;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.lib.editor.util.swing.DocumentUtilities;
import org.netbeans.modules.parsing.api.Snapshot;
import org.openide.util.Exceptions;
import org.netbeans.modules.editor.indent.spi.Context;
/**
 *
 * @author Sudeep
 */
public class PerlDocumentFormatter {
    private final PerlFormatter formatter;
    private final PerlEditorParserResult parseResult;
    private final BaseDocument document;
    private final Context context;

    PerlDocumentFormatter(PerlFormatter formatter, PerlEditorParserResult parseResult, BaseDocument document, Context context) {
        this.formatter = formatter;
        this.parseResult = parseResult;
        this.document = document;
        this.context = context;
    }

    public void format() {
        final Snapshot snapshot = parseResult.getSnapshot();
        try {
            List<Delimiter> delimiters = new LinkedList<>();
            TokenSequence<PerlTokenId> tokenSequence = snapshot.getTokenHierarchy().tokenSequence(PerlTokenId.language);
            tokenSequence.move(0);

            while (tokenSequence.moveNext()) {
                Token<PerlTokenId> token = tokenSequence.token();
                int tokenOffset = tokenSequence.offset();
                if (token.id() == PerlTokenId.language.tokenId("LCURLY")) {
                    delimiters.add(new Delimiter(DelimiterType.OPEN_CURLY, tokenOffset));
                } else if (token.id() == PerlTokenId.language.tokenId("RCURLY")) {
                    delimiters.add(new Delimiter(DelimiterType.CLOSE_CURLY, tokenOffset));
                } else if (token.id() == PerlTokenId.language.tokenId("SEMI_COLON")) {
                    delimiters.add(new Delimiter(DelimiterType.SEMICOLON, tokenOffset));
                } 
            }

            int depth = 0;
            // We need these, because context.endOffset() doesn't update if we modify the document directly (i.e. not through the context object)
            Position startPosition = document.createPosition(context.startOffset());
            Position endPosition = document.createPosition(context.endOffset());
            for (Delimiter delimiter : delimiters) {
                depth += delimiter.type.depthChangeBefore;
                int nextDepth = depth + delimiter.type.depthChangeAfter;
                if (delimiter.offset() >= startPosition.getOffset() && delimiter.offset() < endPosition.getOffset()) {
                    delimiter.adjustSurroundings();
                    delimiter.modifyIndentDepth(depth);

                    //TODO: we wouldn't need this if we added a placeholding delimiter for lines before closing braces with no semicolon
                    if (delimiter.startOfNextLine() >= startPosition.getOffset() && delimiter.startOfNextLine() < endPosition.getOffset()) {
                        delimiter.modifyIndentDepthOfNextLine(nextDepth);
                    }
                }
                depth = nextDepth;
            }
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public int indentForDepth(int depth) {
        //TODO: return 0 if depth negative
        return depth * formatter.indentSize();
    }

    private enum DelimiterType {

        OPEN_CURLY(" ", "\n", 0, 1),
        CLOSE_CURLY("\n", "\n", -1, 0),
        SEMICOLON("", "\n", 0, 0);
        final String prefix;
        final String suffix;
        final int depthChangeBefore;
        final int depthChangeAfter;

        DelimiterType(String prefix, String suffix, int depthChangeBefore, int depthChangeAfter) {
            this.prefix = prefix;
            this.suffix = suffix;
            this.depthChangeBefore = depthChangeBefore;
            this.depthChangeAfter = depthChangeAfter;
        }
    }

    private class Delimiter {

        private static final int TOKEN_WIDTH = 1;
        final DelimiterType type;
        final Position position;

        private Delimiter(DelimiterType type, int offset) throws BadLocationException {
            this.type = type;
            this.position = document.createPosition(offset);
        }

        int offset() {
            return position.getOffset();
        }

        void adjustSurroundings() throws BadLocationException {
            setSurrounding(type.prefix, type.suffix);
        }

        void setSurrounding(String before, String after) throws BadLocationException {
            replaceLeadingWhitespace(before);
            replaceTrailingWhitespace(after);
        }

        void modifyIndentDepth(int newDepth) throws BadLocationException {
            context.modifyIndent(context.lineStartOffset(offset()), indentForDepth(newDepth));
        }

        void modifyIndentDepthOfNextLine(int depth) throws BadLocationException {
            context.modifyIndent(startOfNextLine(), indentForDepth(depth));
        }

        int startOfNextLine() throws BadLocationException {
            assert type.suffix.equals("\n") : "This only works for delimiter types that are followed by newlines";
            assert type.suffix.equals(getText(offset() + TOKEN_WIDTH, type.suffix.length())) : "Trying to find where the next line starts, but doing it dodgily!";
            return offset() + TOKEN_WIDTH + type.suffix.length();
        }

        private void replaceLeadingWhitespace(String prefix) throws BadLocationException {
            final int endOfGap = offset();
            int previousCharacterPosition = endOfGap;
            char nextChar = charAt(previousCharacterPosition - 1);
            while (Character.isWhitespace(nextChar)) {
                previousCharacterPosition--;
                nextChar = charAt(previousCharacterPosition - 1);
            }
            final int startOfGap = previousCharacterPosition;
            final int lengthOfGap = endOfGap - startOfGap;
            document.replace(startOfGap, lengthOfGap, prefix, null);
        }

        private void replaceTrailingWhitespace(String suffix) throws BadLocationException {
            final int startOfGap = offset() + TOKEN_WIDTH;
            int endOfGap = startOfGap;
            for (int i = startOfGap; i < document.getLength() && Character.isWhitespace(charAt(i)); i++) {
                endOfGap = i + 1;
            }
            final int lengthOfGap = endOfGap - startOfGap;
            document.replace(startOfGap, lengthOfGap, suffix, null);
        }

        private char charAt(int nextCharPosition) {
            return DocumentUtilities.getText(document).charAt(nextCharPosition);
        }

        private String getText(int start, int length) throws BadLocationException {
            return DocumentUtilities.getText(document, start, length).toString();
        }
    }
}
