package org.language.perl.action;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.language.perl.utilities.PerlBundledUtilities;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.base.ProcessBuilder;
import org.netbeans.api.extexecution.base.input.InputProcessor;
import org.openide.util.Exceptions;

@SuppressWarnings("deprecation")
public class PerlExecution {

    private static final Logger LOGGER = Logger.getLogger(PerlExecution.class.getName());

    //Execution commands
    private String command;
    private String workingDirectory;
    private String commandArgs;
    private String path;
    private String script;
    private String scriptArgs;
    private String displayName;
    private boolean redirect;

    //internal process control    
    private ExecutionDescriptor descriptor = new ExecutionDescriptor()
            .frontWindow(true)
            .controllable(true)
            .inputVisible(true)
            .showProgress(true)
            .showSuspended(true);

    public synchronized Future<Integer> run() {
        LOGGER.log(Level.INFO, "Execution Service to be configured");
        try {
            ExecutionService service
                = ExecutionService.newService(
                        buildProcess(),
                        descriptor,
                        displayName);
            LOGGER.log(Level.INFO, "Execution Service configured {0}", service.toString());
            return service.run();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

    //check the Process builder
    private ProcessBuilder buildProcess() throws IOException {
        LOGGER.log(Level.INFO, "Starting method buildProcess...");

        ProcessBuilder processBuilder = ProcessBuilder.getLocal();
        processBuilder.setWorkingDirectory(workingDirectory);
        processBuilder.setExecutable(command);

        List<String> argList = new ArrayList<>();

        if (commandArgs != null) {
            Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
            Matcher regexMatcher = regex.matcher(commandArgs);
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null) {
                    // Add double-quoted string without the quotes
                    argList.add(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    // Add single-quoted string without the quotes
                    argList.add(regexMatcher.group(2));
                } else {
                    // Add unquoted word
                    argList.add(regexMatcher.group());
                }
            }
        }
        if (script != null) {
            argList.add(script);
        }
        //Executing script with multiple runtime command line parameters
        if (scriptArgs != null) {
            Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
            Matcher regexMatcher = regex.matcher(scriptArgs);
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null) {
                    // Add double-quoted string without the quotes
                    argList.add(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    // Add single-quoted string without the quotes
                    argList.add(regexMatcher.group(2));
                } else {
                    // Add unquoted word
                    argList.add(regexMatcher.group());
                }
            }
        }
        processBuilder.setArguments(argList);
        processBuilder.setRedirectErrorStream(redirect);
        return processBuilder;
    }

    private ExecutionDescriptor buildDescriptor() {
        return descriptor;
    }

    public synchronized String getCommand() {
        return command;
    }

    public synchronized void setCommand(String command) {
        this.command = command;
    }

    public synchronized String getCommandArgs() {
        return commandArgs;
    }

    public synchronized void setCommandArgs(String commandArgs) {
        this.commandArgs = commandArgs;
    }

    public synchronized String getPath() {
        return path;
    }

    public synchronized void setPath(String path) {
        this.path = path;
    }

    public synchronized String getScript() {
        return script;
    }

    public synchronized void setRawScript(String script) throws IOException {
        this.script = script;
    }

    public String getBundledPerlAutoflushPath() {
        PerlBundledUtilities flushFolder = new PerlBundledUtilities();
        return flushFolder.getBundledPerlAutoflushPath();
    }

    public synchronized String getRawScript() {
        return script;
    }

    public synchronized String getScriptArgs() {
        return scriptArgs;
    }

    public synchronized void setScriptArgs(String scriptArgs) {
        this.scriptArgs = scriptArgs;
    }

    public synchronized String getWorkingDirectory() {
        return workingDirectory;
    }

    public synchronized void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    public synchronized String getDisplayName() {
        return displayName;
    }

    public synchronized void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public synchronized void setShowControls(boolean showControls) {
        descriptor = descriptor.controllable(showControls);
    }

    public synchronized void setShowInput(boolean showInput) {
        descriptor = descriptor.inputVisible(showInput);
    }

    public synchronized void setRedirectError(boolean redirect) {
        this.redirect = redirect;
    }

    public synchronized void setShowProgress(boolean showProgress) {
        descriptor = descriptor.showProgress(showProgress);
    }

    public synchronized void setShowSuspended(boolean showSuspended) {
        descriptor = descriptor.showSuspended(showSuspended);
    }

    /**
     * Show the window of the running process
     *
     * @param showWindow display the window or not?
     */
    public synchronized void setShowWindow(boolean showWindow) {
        descriptor = descriptor.frontWindow(showWindow);
    }

    private final PerlOutputProcessor outProcessor = new PerlOutputProcessor();

    /**
     * Attach a Processor to collect the output of the running process
     */
    public void attachOutputProcessor() {
        descriptor = descriptor.outProcessorFactory((InputProcessor arg0) -> (InputProcessor) outProcessor);
    }

    public Reader getOutput() {
        return new StringReader(outProcessor.getData());
    }

    /**
     * Attach input processor to the running process
     */
    public void attachInputProcessor() {
        //descriptor = descriptor.
    }

    /**
     * Writes data to the running process
     *
     * @return StringWirter
     */
    public Writer getInput() {
        return null;
    }
}
