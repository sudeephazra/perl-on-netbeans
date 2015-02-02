/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.completion;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.openide.util.Exceptions;

/**
 *
 * @author Sudeep
 */
public class PerlCompletionProvider implements CompletionProvider {

    @Override
    public CompletionTask createTask(int i, JTextComponent jtc) {
        return null;
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
                //            } else if (fragment.endsWith("\"")) {
                //                complete(component, offset, " \"");
                //            } else if (fragment.endsWith("\'")) {
                //                complete(component, offset, " \'");
                //            } 
            }   else if (fragment.endsWith("=pod")) {
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
