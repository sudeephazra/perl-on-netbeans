/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.options.panel.PerlTidyPreferences;
import org.language.perl.utilities.PerlConstants;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
    category = "Build",
id = "org.netbeans.perl.file.PerlTidyCodeFormatterAction")
@ActionRegistration(
    iconBase = "org/language/perl/images/file-code-format.gif",
displayName = "#CTL_PerlTidyCodeFormatterAction")
@ActionReferences({
    @ActionReference(path = "Toolbars/Build", position = 450),
    @ActionReference(path = "Loaders/text/x-perl/Actions", position = 137, separatorAfter = 143)
})
@Messages("CTL_PerlTidyCodeFormatterAction=Perl::Tidy Code Formatter")
public class PerlTidyCodeFormatterAction implements ActionListener {

    private final PerlFileDataObject context;

    public PerlTidyCodeFormatterAction(PerlFileDataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (context.isModified() == true) {
            SaveCookie sc = context.getLookup().lookup(SaveCookie.class);
            try {
                sc.save();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        File file = FileUtil.toFile(context.getPrimaryFile());
        String fileName = file.getAbsolutePath();

        PerlTidyPreferences tidyPref = new PerlTidyPreferences();
        String perlTidyBinary = tidyPref.getPerlTidyBinary();
        String perlTidyColumnIndentation = tidyPref.getPerlTidyColumnIndentation();
        String perlTidyLineLength = tidyPref.getPerlTidyLineLength();
        boolean perlTidyGenerateLog = tidyPref.getPerlTidyGenerateLog();

        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent().toString());
        myExecution.setDisplayName(file.getName() + " (Source Code Formatting)");
        if (perlTidyBinary.equals("")) {
            File bundledTidy = new File(tidyPref.getBundledPerlTidyPath());
            if (!bundledTidy.exists()) {
                JOptionPane.showMessageDialog(null, "Code Formatting not supported. Please refer to the documentation.");
                return;
            }
            myExecution.setWorkingDirectory(bundledTidy.getAbsolutePath());
            myExecution.setCommand(PerlConstants.PERL_DEFAULT);
            myExecution.setCommandArgs(PerlConstants.PERL_TIDY_BINARY);
        } else {
            myExecution.setCommand(perlTidyBinary);
            File tidy = new File(myExecution.getCommand());
            if (!tidy.exists()) {
                JOptionPane.showMessageDialog(null, "Code Formatting not properly set. Please refer to the product documentation");
                return;
            }
        }

        //The below option is always required --DO NOT REMOVE THIS SWITCH
        if (myExecution.getCommandArgs() == null) {
            myExecution.setCommandArgs(" -b");
        } else {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -b");
        }
        //Putting all the options as available from the Options panel
        if (perlTidyColumnIndentation.equals("")) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -i=4");
        } else {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -i=" + perlTidyColumnIndentation);
        }
        if (perlTidyLineLength.equals("")) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -l=80");
        } else {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -l=" + perlTidyLineLength);
        }
        if (perlTidyGenerateLog) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -g");
        }
        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }


        //This can be done on a separate thread
        /* //This is the main thread
         PerlCodeFormatterThread code = new PerlCodeFormatterThread(myExecution);
         code.run();
         */
        Thread codeFormatterThread = new Thread(new PerlCodeFormatterThread(myExecution));
        codeFormatterThread.start();
        /*
         try {
         codeFormatterThread.join();
         } catch (InterruptedException ex) {
         Exceptions.printStackTrace(ex);
         }
         */
    }

    public class PerlCodeFormatterThread implements Runnable {

        PerlExecution myExecution;

        PerlCodeFormatterThread(PerlExecution tidyExecution) {
            myExecution = tidyExecution;
        }

        @Override
        public void run() {
            String fileName = myExecution.getRawScript();
            File backupFile = new File(fileName + ".bak");
            //Delete any residual files from previous executions
            if (backupFile.exists()) {
                try {
                    backupFile.delete();
                } catch (Exception ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
            myExecution.run();
            //Wait till the file becomes available
            while (!backupFile.exists()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
            try {
                backupFile.delete();
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }

        }
    }
}
