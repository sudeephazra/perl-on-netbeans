/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.parser;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.language.perl.utilities.PerlConstants;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;

@MimeRegistration(mimeType=PerlConstants.MIME_TYPE,service=TaskFactory.class)
public class SyntaxErrorsHighlightingTaskFactory extends TaskFactory{
    
    private static final Logger LOG = Logger.getLogger(SyntaxErrorsHighlightingTaskFactory.class.getName());
    
    @Override
    public Collection<? extends SchedulerTask> create (Snapshot snapshot) {
            if (LOG.isLoggable(Level.FINER)) {
                LOG.finer("Returning a collection of Syntax Error Highlighting Task");
            }
            return Collections.singleton (new SyntaxErrorsHighlightingTask ());
       }

}

