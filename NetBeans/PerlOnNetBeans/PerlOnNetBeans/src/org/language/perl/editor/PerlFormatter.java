/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.editor;

import javax.swing.text.BadLocationException;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.editor.indent.spi.Context;
import org.openide.util.Exceptions;
import javax.swing.text.Document;
import org.netbeans.editor.BaseDocument;
import static java.lang.Character.isWhitespace;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.language.perl.parser.Perl5Parser.PerlEditorParserResult;

/**
 *
 * @author Sudeep
 */
public class PerlFormatter implements Formatter  {

    @Override
    public void reformat(Context context, ParserResult compilationInfo) {
        Logger.getLogger(PerlFormatter.class.getName()).log(Level.WARNING, "reformat: {0} - {1}, caret = {2}", new Object[]{context.startOffset(), context.endOffset(), context.caretOffset()});
        PerlEditorParserResult parseResult = (PerlEditorParserResult) compilationInfo;
        BaseDocument document = (BaseDocument) context.document();
        final PerlDocumentFormatter formatter = new PerlDocumentFormatter(this, parseResult, document, context);
        //TODO:
        //In addition to locking, PHP also does
        //MutableTextInput mti = (MutableTextInput) doc.getProperty(MutableTextInput.class);
        //try {
        //    mti.tokenHierarchyControl().setActive(false);
        //    <format>
        //} finally {
        //    mti.tokenHierarchyControl().setActive(true);
        //}
        //TODO: do we need the write lock the whole time? Looking for the braces just needs a read lock, but it seems like we can't get the write lock when we already have the read lock
        document.runAtomic(new Runnable() {
            @Override
            public void run() {
                formatter.format();
            }
        });
    }

    @Override
    public void reindent(Context context) {
        Logger.getLogger(PerlFormatter.class.getName()).log(Level.WARNING, "reindent: {0} - {1}, {2}", new Object[]{context.startOffset(), context.endOffset(), context.caretOffset()});
        try {
            int lineStart = context.lineStartOffset(context.startOffset());
            int previousLineEnd = lineStart - 1;
            int previousLineStart = context.lineStartOffset(previousLineEnd);
            int previousLineIndent = context.lineIndent(previousLineStart);
            Document document = context.document();
            char lastCharOfPreviousLine = lastNonWhiteCharacter(previousLineStart, previousLineEnd, document);
            int targetIndent;
            if (lastCharOfPreviousLine == '{') {
                targetIndent = previousLineIndent + indentSize();
            } else {
                targetIndent = previousLineIndent;
            }
            context.modifyIndent(lineStart, targetIndent);
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private static char lastNonWhiteCharacter(int lineStart, int lineEnd, Document document) throws BadLocationException {
        for (int i = lineEnd; i > lineStart; i--) {
            char character = document.getText(i - 1, 1).charAt(0);
            if (!isWhitespace(character)) {
                return character;
            }
        }
        return ' ';
    }

    @Override
    public boolean needsParserResult() {
        return true;
    }

    @Override
    public int indentSize() {
        return 4;
    }

    @Override
    public int hangingIndentSize() {
        return 8;
    }
    
}
