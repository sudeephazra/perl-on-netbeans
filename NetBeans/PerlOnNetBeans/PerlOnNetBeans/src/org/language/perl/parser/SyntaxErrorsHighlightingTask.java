package org.language.perl.parser;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.antlr.v4.runtime.RecognitionException;
import org.language.perl.grammar.PerlLexer.SyntaxError;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.ErrorDescriptionFactory;
import org.netbeans.spi.editor.hints.HintsController;
import org.netbeans.spi.editor.hints.Severity;

public class SyntaxErrorsHighlightingTask extends ParserResultTask<Parser.Result> {
    
    public boolean cancelled = false; 
    
    public SyntaxErrorsHighlightingTask() {
    }
    
    @Override
    public void run(Result result, SchedulerEvent event) {
         try { 
            List<SyntaxError> syntaxErrors = ((Perl5Parser.PerlEditorParserResult)result).getPerlParser().syntaxErrors; 

            if (syntaxErrors == null) { 
              return; 
            } 

            Document document = result.getSnapshot().getSource().getDocument(false); 
            List<ErrorDescription> errors = new ArrayList<ErrorDescription>(); 

            for (SyntaxError syntaxError : syntaxErrors) { 
                RecognitionException exception = syntaxError.exception; 
                String message = syntaxError.message; 

              int line = exception.getOffendingToken().getLine();
              if (line <= 0 || syntaxError.start <= 0) { 
                continue; 
              } 

              ErrorDescription errorDescription = ErrorDescriptionFactory.createErrorDescription( 
                      Severity.ERROR, message, document, document.createPosition(syntaxError.start), 
                      document.createPosition(syntaxError.stop)); 
              errors.add(errorDescription); 
            } 
            HintsController.setErrors(document, "perl", errors); 
          } catch (Exception ex) { 
            ex.printStackTrace(); 
          } 
    }

    @Override
    public int getPriority() {
        return 100;
    }
    
    @Override
    public Class<? extends Scheduler> getSchedulerClass() {
        return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
    }
    
    @Override
    public void cancel() {
        cancelled = true; 
    }
    
    
    protected final synchronized boolean isCancelled() { 
        return cancelled; 
    } 
}
