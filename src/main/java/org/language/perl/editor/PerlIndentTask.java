/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.editor;

import javax.swing.text.BadLocationException;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.IndentTask;
import org.netbeans.modules.editor.indent.spi.Context;

/**
 *
 * @author Sudeep
 */
public class PerlIndentTask implements IndentTask {

    private Context context;

    PerlIndentTask(Context context) {
        this.context = context;
    }

    @Override
    public void reindent() throws BadLocationException {
        // determine start offset of current line
        int lineStartOffset = context.lineStartOffset(context.startOffset());
        if (lineStartOffset <= 0) {
            return;
        }
        // determine offset of line before this one
        int priorOffset = context.lineStartOffset(lineStartOffset - 1);
        int lineIndent = context.lineIndent(priorOffset);
        // set current line's offset to that of prior
        context.modifyIndent(lineStartOffset, lineIndent);
        context.setCaretOffset(lineIndent);
    }

    @Override
    public ExtraLock indentLock() {
        return null;
    }
    
}
