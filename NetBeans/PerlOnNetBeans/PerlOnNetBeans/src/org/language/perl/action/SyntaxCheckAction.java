/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.options.panel.GeneralPanel;
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.utilities.PerlConstants;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;

@ActionID(
    category = "File",
id = "org.netbeans.perl.file.SyntaxCheckAction")
//@ActionRegistration(
//    iconBase = "org/language/perl/images/file-parse-icon.png",
//displayName = "#CTL_SyntaxCheckAction")
@ActionReferences({
    @ActionReference(path = "Toolbars/Build", position = 500),
    @ActionReference(path = "Loaders/text/x-perl/Actions", position = 150)
})
@Messages("CTL_SyntaxCheckAction=Syntax Check")
public final class SyntaxCheckAction implements ActionListener {

    private final PerlFileDataObject context;

    public SyntaxCheckAction(PerlFileDataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        //If the file in the editor has been modified, save it first and then trigger the action
        if (context.isModified() == true)
        {
            //Save the file before checking for syntax errors
            SaveCookie sc = context.getLookup().lookup(SaveCookie.class);
            try {
                sc.save();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        //Check the syntax of the file
        //new Thread(new PerlSyntaxCheckerThread()).start();
        File file = FileUtil.toFile(context.getPrimaryFile());
        String fileName = file.getAbsolutePath();
        
//        Preferences pref = NbPreferences.forModule(GeneralPanel.class);
//        String perlBinary = pref.get("perlBinary", "").trim();
//        String perlLibrary = pref.get("perlLibrary", "").trim();
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlCustomBinary = perlPreferences.getPerlCustomBinary();
        String perlLibrary = perlPreferences.getPerlCustomLibrary();
        
        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent().toString());
        myExecution.setDisplayName(file.getName() + " (Syntax Checking)");
        if (perlCustomBinary.equals(""))
        {
            myExecution.setCommand(PerlConstants.PERL_DEFAULT);
        } else {
            myExecution.setCommand(perlCustomBinary);
        }
        myExecution.setCommandArgs(" -c ");
        if (!perlLibrary.equals("")) {
            myExecution.setCommandArgs(perlLibrary);
        }
        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        myExecution.run();
    }
    
    public void runSyntaxCheck() {
        if (context.isModified() == true)
        {
            //Save the file before checking for syntax errors
            SaveCookie sc = context.getLookup().lookup(SaveCookie.class);
            try {
                sc.save();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        //Check the syntax of the file
        //new Thread(new PerlSyntaxCheckerThread()).start();
        File file = FileUtil.toFile(context.getPrimaryFile());
        String fileName = file.getAbsolutePath();
        
//        Preferences pref = NbPreferences.forModule(GeneralPanel.class);
//        String perlBinary = pref.get("perlBinary", "").trim();
//        String perlLibrary = pref.get("perlLibrary", "").trim();
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlCustomBinary = perlPreferences.getPerlCustomBinary();
        String perlLibrary = perlPreferences.getPerlCustomLibrary();
        
        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent().toString());
        myExecution.setDisplayName(file.getName() + " (Syntax Checking)");
        if (perlCustomBinary.equals(""))
        {
            myExecution.setCommand(PerlConstants.PERL_DEFAULT);
        } else {
            myExecution.setCommand(perlCustomBinary);
        }
        myExecution.setCommandArgs(" -c ");
        if (!perlLibrary.equals("")) {
            myExecution.setCommandArgs(perlLibrary);
        }
        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        myExecution.run();
    }
    
}
