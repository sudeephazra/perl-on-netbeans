package org.language.perl.parser;

import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;

public class SyntaxErrorsHighlightingTask extends ParserResultTask<Parser.Result> {
    
    public boolean cancelled = false; 
    
    public SyntaxErrorsHighlightingTask() {
    }
    
    @Override
    public void run(Result result, SchedulerEvent event) {
//         try { 
//            List<SyntaxError> syntaxErrors = ((Perl5Parser.PerlEditorParserResult)result).getPerlParser().syntaxErrors; 
//
//            if (syntaxErrors == null) { 
//              return; 
//            } 
//
//            Document document = result.getSnapshot().getSource().getDocument(false); 
//            List<ErrorDescription> errors = new ArrayList<ErrorDescription>(); 
//
//            for (SyntaxError syntaxError : syntaxErrors) { 
//                RecognitionException exception = syntaxError.exception; 
//                String message = syntaxError.message; 
//
//              int line = exception.getOffendingToken().getLine();
//              if (line <= 0 || syntaxError.start <= 0) { 
//                continue; 
//              } 
//
//              ErrorDescription errorDescription = ErrorDescriptionFactory.createErrorDescription( 
//                      Severity.ERROR, message, document, document.createPosition(syntaxError.start), 
//                      document.createPosition(syntaxError.stop)); 
//              errors.add(errorDescription); 
//            } 
//            HintsController.setErrors(document, "perl", errors); 
//          } catch (Exception ex) { 
//            ex.printStackTrace(); 
//          } 
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
