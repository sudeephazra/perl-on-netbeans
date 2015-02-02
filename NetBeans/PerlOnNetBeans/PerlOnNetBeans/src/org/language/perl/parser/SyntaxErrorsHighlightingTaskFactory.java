/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.parser;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;

public class SyntaxErrorsHighlightingTaskFactory extends TaskFactory{
    
    @Override
    public Collection<? extends SchedulerTask> create (Snapshot snapshot) {
           //return (Set) Collections.singleton (new SyntaxErrorsHighlightingTask ());
            return Collections.singleton (new SyntaxErrorsHighlightingTask ());
       }

}
