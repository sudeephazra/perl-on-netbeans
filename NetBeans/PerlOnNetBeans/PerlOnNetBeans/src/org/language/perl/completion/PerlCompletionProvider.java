/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.completion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.language.perl.utilities.PerlBundledUtilities;
import org.language.perl.utilities.PerlConstants;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.openide.util.Exceptions;

/**
 *
 * @author Sudeep
 */
@MimeRegistration(mimeType = PerlConstants.MIME_TYPE, service = CompletionProvider.class)
public class PerlCompletionProvider implements CompletionProvider {

    @Override
    public CompletionTask createTask(int queryType, JTextComponent jtc) {
        //return null;
        if (queryType != CompletionProvider.COMPLETION_QUERY_TYPE) {
            return null;
        }
        return new AsyncCompletionTask(new AsyncCompletionQuery() {
            @Override
            protected void query(CompletionResultSet crs, Document dcmnt, int i) {

                String filter = null;
                int startOffset = i - 1;

                try {
                    final StyledDocument bDoc = (StyledDocument) dcmnt;
                    final int lineStartOffset = getRowFirstNonWhite(bDoc, i);
                    final char[] line = bDoc.getText(lineStartOffset, i - lineStartOffset).toCharArray();
                    final int whiteOffset = indexOfWhite(line);
                    filter = new String(line, whiteOffset + 1, line.length - whiteOffset - 1);
                    if (whiteOffset > 0) {
                        startOffset = lineStartOffset + whiteOffset + 1;
                    } else {
                        startOffset = lineStartOffset;
                    }
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                }

                File perlKeywordFile = new File(getBundledPerlBarewordsFile());
                try {
                    FileInputStream fis = new FileInputStream(perlKeywordFile);
                    //Construct BufferedReader from InputStreamReader
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        crs.addItem(new PerlKeywordCompletionItem(line, startOffset, i));
                    }
                    br.close();
                } catch (Exception ex) {
//                    Exceptions.printStackTrace(ioexp);
                    Exceptions.printStackTrace(ex);
                }
                crs.finish();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }, jtc);
    }

    public String getBundledPerlBarewordsFile() {
        PerlBundledUtilities bundledBarewordsFile = new PerlBundledUtilities();
        return bundledBarewordsFile.getBundledPerlBarewordsFile();
    }
    
    static int getRowFirstNonWhite(StyledDocument doc, int offset)
            throws BadLocationException {
        Element lineElement = doc.getParagraphElement(offset);
        int start = lineElement.getStartOffset();
        while (start + 1 < lineElement.getEndOffset()) {
            try {
                if (doc.getText(start, 1).charAt(0) != ' ') {
                    break;
                }
            } catch (BadLocationException ex) {
                throw (BadLocationException) new BadLocationException(
                        "calling getText(" + start + ", " + (start + 1)
                        + ") on doc of length: " + doc.getLength(), start
                ).initCause(ex);
            }
            start++;
        }
        return start;
    }

    static int indexOfWhite(char[] line) {
        int i = line.length;
        while (--i > -1) {
            final char c = line[i];
            if (Character.isWhitespace(c)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String string) {
        autoCompletion(component);
        return 0;
    }

    private static void autoCompletion(JTextComponent component) {
        try {
            int offset = component.getCaretPosition();
            String fragment = component.getText(0, offset);
            if (fragment.endsWith("(")) {
                complete(component, offset, ")");
            } else if (fragment.endsWith("{")) {
                complete(component, offset, "}");
            } else if (fragment.endsWith("[")) {
                complete(component, offset, "]");
            } else if (fragment.endsWith("=pod")) {
                complete(component, offset, "\n\r=cut");
            }

        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private static void complete(JTextComponent component, int offset, String s) throws BadLocationException {
        component.getDocument().insertString(offset, s, null);
        component.setCaretPosition(offset);
    }
}
