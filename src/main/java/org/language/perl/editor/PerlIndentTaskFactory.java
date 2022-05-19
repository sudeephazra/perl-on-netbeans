/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.editor;

import org.language.perl.utilities.PerlConstants;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.IndentTask;

/**
 *
 * @author Sudeep
 */
@MimeRegistration(mimeType = PerlConstants.MIME_TYPE, service = IndentTask.Factory.class)
public class PerlIndentTaskFactory  implements IndentTask.Factory {

    @Override
    public IndentTask createTask(Context context) {
        return new PerlIndentTask(context);
    }
    
}
