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
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.options.panel.PerlTidyPreferences;
import org.language.perl.utilities.CheckInstalledPerlModules;
import org.language.perl.utilities.PerlConstants;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.apache.commons.lang.SystemUtils;

@ActionID(
        category = "Build",
        id = "org.netbeans.perl.file.PerlTidyCodeFormatterAction")
@ActionRegistration(
        iconBase = "org/language/perl/action/file-code-format.png",
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

        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlCustomBinary = perlPreferences.getPerlCustomBinary();
        String perlLibrary = perlPreferences.getPerlCustomLibrary();

        CheckInstalledPerlModules checkModules = new CheckInstalledPerlModules();

        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent());
        myExecution.setDisplayName(file.getName() + PerlConstants.PERL_CODE_FORMATING_OUTPUT_WINDOW_TITLE);
        myExecution.setShowWindow(false);
        if (perlCustomBinary.equals("")) {
            myExecution.setCommand(PerlConstants.PERL_DEFAULT);
            boolean isPerlInstalled = false;
            try {
                isPerlInstalled = checkModules.isPerlInstalled();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
            if (!isPerlInstalled) {
                return;
            }
        } else {
            myExecution.setCommand(perlCustomBinary);
        }

        PerlTidyPreferences tidyPref = new PerlTidyPreferences();
        String perlTidyBinary = tidyPref.getPerlTidyBinary();
        String perlTidyColumnIndentation = tidyPref.getPerlTidyColumnIndentation();
        String perlTidyLineLength = tidyPref.getPerlTidyLineLength();
        boolean perlTidyGenerateLog = tidyPref.getPerlTidyGenerateLog();
        boolean perlTidyUseConfigFile = tidyPref.getPerlTidyUseConfigFile();
        String perlTidyConfigFile = tidyPref.getPerlTidyConfigFile();
        boolean perlTidyUsePBPConfig = tidyPref.getPerlTidyUsePBPConfig();
        boolean perlTidyGenerateHTML = tidyPref.getPerlTidyGenerateHTML();
        boolean perlTidyGenerateHTMLTableOfContents = tidyPref.getPerlTidyGenerateHTMLTableOfContents();
        boolean perlTidyHTMLWithPRE = tidyPref.getPerlTidyHTMLWithPRE();
        boolean perlTidyHTMLWithFRAME = tidyPref.getPerlTidyHTMLWithFRAME();
        String perlTidyCSSFile = tidyPref.getPerlTidyCSSFile();
        String perlCustomHTMLOutputFolder = tidyPref.getPerlTidyCustomHTMLOutputFolder();
        String perlTidyAdditionalParameters = tidyPref.getPerlTidyAdditionalParameters();

        if (perlTidyBinary.equals("")) {
            if (checkModules.isPerlTidyInstalled() == true) {
                if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
                    myExecution.setCommand(PerlConstants.PERL_TIDY_BINARY_LINUX_MAC);
                }
                if (SystemUtils.IS_OS_WINDOWS) {
                    myExecution.setCommand(PerlConstants.PERL_TIDY_BINARY_WIN);
                }
            } else {
                JOptionPane.showMessageDialog(null, PerlConstants.MSG_PERL_TIDY_NOT_INSTALLED, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            myExecution.setCommand(perlTidyBinary);
            File tidy = new File(myExecution.getCommand());
            if (!tidy.exists()) {
                JOptionPane.showMessageDialog(null, PerlConstants.MSG_PERL_TIDY_NOT_CONFIGURED, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (!perlLibrary.equals("")) {
            myExecution.setCommandArgs(perlLibrary);
        }

        //The below option is always required --DO NOT REMOVE THIS SWITCH
        if (myExecution.getCommandArgs() == null) {
            myExecution.setCommandArgs(PerlConstants.PERL_TIDY_BACKUP_PARAM);
        } else {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_BACKUP_PARAM);
        }
        //Putting all the options as available from the Options panel
        if (perlTidyUseConfigFile) {
            if (perlTidyConfigFile.equals("")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_CONFIG_FILE_PARAM + PerlConstants.PERL_TIDY_DEFAULT_CONFIG_FILE);
            } else {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_CONFIG_FILE_PARAM + perlTidyConfigFile);
            }
        } else if (perlTidyUsePBPConfig) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_PBP_PARAM);
        } else {
            if (perlTidyColumnIndentation.equals("")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_DEFAULT_INDENT_PARAM);
            } else {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_INDENT_PARAM + perlTidyColumnIndentation);
            }
            if (perlTidyLineLength.equals("")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_DEFAULT_LINE_LENGTH_PARAM);
            } else {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_LINE_LENGTH_PARAM + perlTidyLineLength);
            }
        }
        //If output is HTML
        if (perlTidyGenerateHTML) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_GENERATE_HTML_PARAM);
            if (perlTidyGenerateHTMLTableOfContents) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_GENERATE_HTML_TOC_PARAM);
            }
            if (perlTidyHTMLWithPRE) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_GENERATE_HTML_PRE_PARAM);
            }
            if (perlTidyHTMLWithFRAME) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_GENERATE_HTML_FRAMES_PARAM);
            }
            if (!perlTidyCSSFile.equals("")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_GENERATE_HTML_CSS_PARAM + "\"" + perlTidyCSSFile + "\"");
            }
            if (!perlCustomHTMLOutputFolder.equals("")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_GENERATE_HTML_OUTPUT_PARAM + perlCustomHTMLOutputFolder);
            }
        }
        if (perlTidyGenerateLog) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + PerlConstants.PERL_TIDY_GENERATE_LOG_PARAM);
        }
        if (!perlTidyAdditionalParameters.equals("")) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " " + perlTidyAdditionalParameters + " ");
        }
        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        Thread codeFormatterThread = new Thread(new PerlCodeFormatterThread(myExecution));
        codeFormatterThread.start();
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
