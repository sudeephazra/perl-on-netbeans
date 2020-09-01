/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.utilities.PerlConstants;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.netbeans.perl.file.ExecuteAction")
//@ActionRegistration(
//        iconBase = "org/language/perl/images/file-run-icon.png",
//        displayName = "#CTL_ExecuteAction")
@ActionReferences({
    @ActionReference(path = "Toolbars/Build", position = 600),
    @ActionReference(path = "Loaders/text/x-perl/Actions", position = 175)
})
@Messages("CTL_ExecuteAction=Execute")
public final class ExecuteAction implements ActionListener {

    private final PerlFileDataObject context;

    public ExecuteAction(PerlFileDataObject context) {
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

        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent().toString());
        myExecution.setDisplayName(file.getName() + " (Execute)");
        if (perlCustomBinary.equals("")) {
            myExecution.setCommand(PerlConstants.PERL_DEFAULT);
        } else {
            myExecution.setCommand(perlCustomBinary);
        }
        myExecution.setCommandArgs(" -w ");
        if (!perlLibrary.equals("")) {
            myExecution.setCommandArgs(perlLibrary);
        }
        //Removing the need to create a new file for output buffer flushing
        myExecution.setCommandArgs(myExecution.getCommandArgs() + " -I ");
        myExecution.setCommandArgs(myExecution.getCommandArgs()
                + "\"" + myExecution.getBundledPerlAutoflushPath() + "\"");
        myExecution.setCommandArgs(myExecution.getCommandArgs() + " -MDevel::Autoflush ");
        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        myExecution.run();

    }

    public void runPerlFile() {
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

        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent().toString());
        myExecution.setDisplayName(file.getName() + " (Execute)");
        if (perlCustomBinary.equals("")) {
            myExecution.setCommand(PerlConstants.PERL_DEFAULT);
        } else {
            myExecution.setCommand(perlCustomBinary);
        }
        myExecution.setCommandArgs(" -w ");
        if (!perlLibrary.equals("")) {
            myExecution.setCommandArgs(perlLibrary);
        }
        //Removing the need to create a new file for output buffer flushing
        myExecution.setCommandArgs(myExecution.getCommandArgs()
                + PerlConstants.INCLUDE_LIBRARY_FLAG
                + " \"" + myExecution.getBundledPerlAutoflushPath() + "\" ");
        myExecution.setCommandArgs(myExecution.getCommandArgs()
                + " -MDevel::Autoflush ");
        //Adding current folder for include list as it is not allowed
        //by default in taint mode
        myExecution.setCommandArgs(myExecution.getCommandArgs()
                + " -I " + myExecution.getWorkingDirectory());
        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        if (file.exists()) {
            myExecution.run();
        } else {
            return;
        }

    }
}
