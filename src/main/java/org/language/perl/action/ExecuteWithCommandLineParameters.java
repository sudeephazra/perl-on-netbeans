package org.language.perl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.utilities.PerlConstants;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author Sudeep
 */
@ActionID(
        category = "Build",
        id = "org.netbeans.perl.file.ExecuteWithCommandLineParameters")
@ActionRegistration(
        iconBase = "org/language/perl/action/file-command-line.png",
        displayName = "#CTL_ExecuteWithCommandLineParameters")
@ActionReferences({
    @ActionReference(path = "Toolbars/Build", position = 700),
    @ActionReference(path = "Loaders/text/x-perl/Actions", position = 187, separatorAfter = 193)
})
@Messages("CTL_ExecuteWithCommandLineParameters=Execute (With Command Line Parameters)")
public class ExecuteWithCommandLineParameters implements ActionListener {

    private final PerlFileDataObject context;

    public ExecuteWithCommandLineParameters(PerlFileDataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (context.isModified() == true) {
            SaveCookie sc = context.getLookup().lookup(SaveCookie.class);
            try {
                sc.save();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        //Display pop-up here to get the command line options
        String commandLineParamaters;
        commandLineParamaters = JOptionPane.showInputDialog(null, "Command Line Parameters: ",
                "Command Line Paramateres for script", JOptionPane.PLAIN_MESSAGE);
        if (commandLineParamaters == null) {
            return;
        }
        File file = FileUtil.toFile(context.getPrimaryFile());
        String fileName = file.getAbsolutePath();

        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlCustomBinary = perlPreferences.getPerlCustomBinary();
        String perlLibrary = perlPreferences.getPerlCustomLibrary();
        
        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent().toString());
        myExecution.setDisplayName(file.getName() + " (Execute with command line parameters)");
        if (perlCustomBinary.equals("")) {
            myExecution.setCommand(PerlConstants.PERL_DEFAULT);
        } else {
            myExecution.setCommand(perlCustomBinary);
        }

        myExecution.setCommandArgs("-w");
        //Add perl library location here
        if (!perlLibrary.equals("")) {
            myExecution.setCommandArgs(perlLibrary);
        }
        //Removing the need to create a new file for output buffer flushing
        myExecution.setCommandArgs(myExecution.getCommandArgs()
                + PerlConstants.INCLUDE_LIBRARY_FLAG
                + " \"" + myExecution.getBundledPerlAutoflushPath() + "\" ");
        myExecution.setCommandArgs(myExecution.getCommandArgs() + " -MDevel::Autoflush ");

        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        myExecution.setScriptArgs(commandLineParamaters);
        myExecution.run();
    }
}
