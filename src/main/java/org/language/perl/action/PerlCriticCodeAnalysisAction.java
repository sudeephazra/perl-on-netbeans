package org.language.perl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.commons.lang.SystemUtils;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.options.panel.PerlCriticPreferences;
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

@ActionID(
    category = "Build",
id = "org.netbeans.perl.actions.PerlCriticCodeAnalysisAction")
@ActionRegistration(
    iconBase = "org/language/perl/action/file-code-analysis.png",
displayName = "#CTL_PerlCriticCodeAnalysisAction")
@ActionReferences({
    @ActionReference(path = "Toolbars/Build", position = 400),
    @ActionReference(path = "Loaders/text/x-perl/Actions", position = 125, separatorBefore = 112)
})
@Messages("CTL_PerlCriticCodeAnalysisAction=Perl::Critic Code Analysis")
public final class PerlCriticCodeAnalysisAction implements ActionListener {

    private final PerlFileDataObject context;

    public PerlCriticCodeAnalysisAction(PerlFileDataObject context) {
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
        myExecution.setDisplayName(file.getName() + PerlConstants.PERL_CODE_ANALYSIS_OUTPUT_WINDOW_TITLE);
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
        
        PerlCriticPreferences criticPref = new PerlCriticPreferences();
        String perlCriticBinary = criticPref.getPerlCriticBinary();
        String perlCriticSeverity = criticPref.getPerlCriticSeverity();
        String perlCriticForce = criticPref.getPerlCriticForce();
        String perlCriticTheme = criticPref.getPerlCriticTheme();
        
        if (perlCriticBinary.equals("")) {
            //Check if the module is installed
            if (checkModules.isPerlCriticInstalled() == false) {
                JOptionPane.showMessageDialog(null, PerlConstants.MSG_PERL_CRITIC_NOT_INSTALLED, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
                myExecution.setCommand(PerlConstants.PERL_CRITIC_LINUX_MAC);
            }
            if (SystemUtils.IS_OS_WINDOWS) {
                myExecution.setCommand(PerlConstants.PERL_CRITIC_WIN);
            }
        } else {
            myExecution.setCommand(perlCriticBinary);
            File critic = new File(myExecution.getCommand());
            if (!critic.exists()) {
                JOptionPane.showMessageDialog(null, PerlConstants.MSG_PERL_CRITIC_NOT_INSTALLED, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Severity
            myExecution.setCommandArgs(" --severity ");
            if (perlCriticSeverity.equals("")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + " 5");
            } else {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + perlCriticSeverity);
            }
            //Force
            if (perlCriticForce.equals("True")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + " --force");
            } else {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + " --noforce");
            }
            //Theme
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " --theme");
            if (perlCriticTheme.equals("")) {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + " 'core'");
            } else {
                myExecution.setCommandArgs(myExecution.getCommandArgs() + " \'" + perlCriticTheme + "\'");
            }
        }

        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        //This is done on a separate thread
        Thread codeAnalysisThread = new Thread(new PerlCodeAnalysisThread(myExecution));
        codeAnalysisThread.start();
    }

    public class PerlCodeAnalysisThread implements Runnable {

        PerlExecution myExecution;

        PerlCodeAnalysisThread(PerlExecution analysisExecution) {
            myExecution = analysisExecution;
        }

        @Override
        public void run() {
            myExecution.run();
        }
    }
}
