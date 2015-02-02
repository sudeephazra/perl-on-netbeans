package org.language.perl.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;
import org.netbeans.api.extexecution.input.InputProcessor;
import org.openide.util.Exceptions;

public class PerlExecution {
    
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
                                                .showSuspended(true)
                                                
                                                ;
    
    public synchronized Future<Integer> run(){
        try {
            ExecutionService service = 
                    ExecutionService.newService(
                    buildProcess(),
                    descriptor, 
                    displayName);
           return service.run();
            
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
    
    //check the Process builder
    private ExternalProcessBuilder buildProcess() throws IOException{
        ExternalProcessBuilder processBuilder =  new ExternalProcessBuilder(command);
        processBuilder = processBuilder.workingDirectory(new File(workingDirectory));
        if(commandArgs != null) {
            /*
            String[] values = commandArgs.split(" ");
            for(int i =0; i < values.length ; i++){
                processBuilder = processBuilder.addArgument(values[i]);
            }
            */
            Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
            Matcher regexMatcher = regex.matcher(commandArgs);
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null) {
                    // Add double-quoted string without the quotes
                    processBuilder = processBuilder.addArgument(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    // Add single-quoted string without the quotes
                    processBuilder = processBuilder.addArgument(regexMatcher.group(2));
                } else {
                    // Add unquoted word
                    processBuilder = processBuilder.addArgument(regexMatcher.group());
                }
            } 
            
            
            //processBuilder = processBuilder.addArgument(commandArgs);
        }
        if(script != null) {
            processBuilder = processBuilder.addArgument(script);
        }
        //Executing script with multiple runtime command line parameters
        if(scriptArgs != null) {
            Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
            Matcher regexMatcher = regex.matcher(scriptArgs);
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null) {
                    // Add double-quoted string without the quotes
                    processBuilder = processBuilder.addArgument(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    // Add single-quoted string without the quotes
                    processBuilder = processBuilder.addArgument(regexMatcher.group(2));
                } else {
                    // Add unquoted word
                    processBuilder = processBuilder.addArgument(regexMatcher.group());
                }
            } 
        }
        processBuilder = processBuilder.redirectErrorStream(redirect);
        return processBuilder;
    }
    
    private ExecutionDescriptor buildDescriptor(){
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

    public synchronized void setScript(String script) throws IOException {

        File file = new File(script);
        String content = new Scanner(file).useDelimiter("\\Z").next(); 
        content = 
                "local $| = 1;" + "\n" + 
                content;
        Random rndNumbers = new Random();
        
        String tempFileURL = 
                System.getProperty("java.io.tmpdir") + 
                System.getProperty("file.separator") + 
                "PerlOnNetBeans_Temp"+
                System.getProperty("file.separator") + 
                "filename" + Integer.toString(rndNumbers.nextInt()) + 
                //".pl" +
                file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.'));
        
        File newFile = new File(tempFileURL);
        //Check if the directory exists, if no then create
        String dir = newFile.getParent();
        File parentDir = new File(dir);
        if (!parentDir.exists())
        {
            parentDir.mkdirs();
        } 
        
        //Deleting all files
        File[] files = parentDir.listFiles();
        for (File toBeDeletedfile : files)
        {
           if (!toBeDeletedfile.delete())
           {
               System.out.println("Failed to delete " + file);
           }
        } 
        //
        //Check if the file exists, if yes then delete it else create a new file
        if (newFile.exists() == true)
        {
            newFile.delete();                
        }
        //
        
        //Creating the new file here
        PrintWriter out = new PrintWriter(tempFileURL);
        out.println(content);
        out.close();
        this.script = newFile.getAbsolutePath();
        
        //The following is the original method
        //this.script = script;
    }
    
    public synchronized void setRawScript(String script) throws IOException {
        this.script = script;
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

    public synchronized void setRedirectError(boolean redirect){
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
     * @param showWindow display the windown or not?
     */
    public synchronized void setShowWindow(boolean showWindow) {
        descriptor = descriptor.frontWindow(showWindow);
    }
    
    private final PerlOutputProcessor outProcessor = new PerlOutputProcessor();
    /**
     * Attach a Processor to collect the output of the running process
     */
    public void attachOutputProcessor(){
        descriptor = descriptor.outProcessorFactory(new ExecutionDescriptor.InputProcessorFactory() {

            @Override
            public InputProcessor newInputProcessor(InputProcessor ip) {
                return outProcessor;
            }
        });
    }

    public Reader getOutput(){
        return new StringReader(outProcessor.getData());
    }
    /**
     * Attach input processor to the running process
     */
    public void attachInputProcessor(){
        //descriptor = descriptor.
    }
    /**
     * Writes data to the running process
     * @return StringWirter
     */
    public Writer getInput(){
        return null;
    }
}
