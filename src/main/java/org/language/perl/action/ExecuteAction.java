/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.action;

import java.io.File;
import java.io.IOException;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.utilities.PerlConstants;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.language.perl.utilities.CheckInstalledPerlModules;

@ActionID(
        category = "File",
        id = "org.netbeans.perl.file.ExecuteAction")
@ActionReferences({
    @ActionReference(path = "Toolbars/Build", position = 600),
    @ActionReference(path = "Loaders/text/x-perl/Actions", position = 175)
})
@Messages("CTL_ExecuteAction=Execute")
public final class ExecuteAction {

    private final PerlFileDataObject context;

    public ExecuteAction(PerlFileDataObject context) {
        this.context = context;
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

        PerlExecution perlFileExecution = new PerlExecution();
        perlFileExecution.setRedirectError(true);
        perlFileExecution.setWorkingDirectory(file.getParent());
        perlFileExecution.setDisplayName(file.getName() + " (Execute)");
        if (perlCustomBinary.equals("")) {
            perlFileExecution.setCommand(PerlConstants.PERL_DEFAULT);
            CheckInstalledPerlModules checkModules = new CheckInstalledPerlModules();
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
            perlFileExecution.setCommand(perlCustomBinary);
        }
        perlFileExecution.setCommandArgs(" -w ");
        if (!perlLibrary.equals("")) {
            perlFileExecution.setCommandArgs(perlLibrary);
        }
        //Removing the need to create a new file for output buffer flushing
        perlFileExecution.setCommandArgs(perlFileExecution.getCommandArgs()
                + PerlConstants.INCLUDE_LIBRARY_FLAG
                + " \"" 
                + perlFileExecution.getBundledPerlAutoflushPath() 
                + "\" ");
        perlFileExecution.setCommandArgs(perlFileExecution.getCommandArgs()
                + " -MDevel::Autoflush ");
        //Adding current folder for include list as it is not allowed
        //by default in taint mode
        perlFileExecution.setCommandArgs(perlFileExecution.getCommandArgs()
                + PerlConstants.INCLUDE_LIBRARY_FLAG 
                + perlFileExecution.getWorkingDirectory());
        perlFileExecution.setCommandArgs(perlFileExecution.getCommandArgs()
                + PerlConstants.INCLUDE_LIBRARY_FLAG 
                + perlFileExecution.getWorkingDirectory() 
                + File.separator 
                + "local" 
                + File.separator 
                + "lib" 
                + File.separator 
                + "perl5");
        try {
            perlFileExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        if (file.exists()) {
            perlFileExecution.run();
        } 

    }
}
