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
import org.language.perl.utilities.PerlUtilsConstants;
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
id = "org.netbeans.perl.file.exportToHTMLAction")
@ActionRegistration(
    iconBase = "org/language/perl/images/exportToHTML24.png",
displayName = "#CTL_exportToHTMLAction")
@ActionReferences({
    @ActionReference(path = "Toolbars/Build", position = 475),
    @ActionReference(path = "Loaders/text/x-perl/Actions", position = 140, separatorAfter = 141)
})
@Messages("CTL_exportToHTMLAction=Export to HTML")
public final class exportToHTMLAction implements ActionListener {

    private final PerlFileDataObject context;

    public exportToHTMLAction(PerlFileDataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (context.isModified() == true)
        {
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
        boolean perlTidyGenerateHTMLTableOfContents = tidyPref.getPerlTidyGenerateHTMLTableOfContents();
        String perlTidyCSSFile = tidyPref.getPerlTidyCSSFile();
        String perlCustomHTMLOutputFolder = tidyPref.getPerlTidyCustomHTMLOutputFolder();
        boolean perlTidyHTMLWithPRE = tidyPref.getPerlTidyHTMLWithPRE();
        boolean perlTidyHTMLWithFRAME = tidyPref.getPerlTidyHTMLWithFRAME();
        
        
        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(file.getParent().toString());
        myExecution.setDisplayName(file.getName() + " (Source Code -> HTML)");
        if (perlTidyBinary.equals(""))
        {
            File bundledTidy = new File(tidyPref.getBundledPerlTidyPath());
            if (!bundledTidy.exists()) {
                JOptionPane.showMessageDialog(null, "Code Formatting not supported. Please refer to the documentation.");
                return;
            }
            myExecution.setWorkingDirectory(bundledTidy.getAbsolutePath());
            myExecution.setCommand(PerlUtilsConstants.PERL_DEFAULT);
            myExecution.setCommandArgs(PerlUtilsConstants.PERL_TIDY_BINARY);
        } else {
            myExecution.setCommand(perlTidyBinary);
            File tidy = new File(myExecution.getCommand());
            if(!tidy.exists()) {
                JOptionPane.showMessageDialog(null, "HTML Generation not properly set. Please refer to the product documentation");
                return;
            }
        }
        //Check here if the executable is available or not
        if (myExecution.getCommandArgs() == null) {
            myExecution.setCommandArgs(" -html");
        } else {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -html");
        }
        
        if (perlTidyGenerateHTMLTableOfContents) {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -toc");
        }
        if (!perlTidyCSSFile.equals(""))
        {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -css=" + perlTidyCSSFile);
        }
        if (perlTidyHTMLWithPRE)
        {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -pre");
        }
        if (perlTidyHTMLWithFRAME)
        {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -frm");
        }
        if (!perlCustomHTMLOutputFolder.equals(""))
        {
            myExecution.setCommandArgs(myExecution.getCommandArgs() + " -o=" + perlCustomHTMLOutputFolder + File.separator + file.getName() + ".html");
        }
        
        try {
            myExecution.setRawScript(fileName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        Thread codeHTMLExporterThread = new Thread(new PerlHTMLGeneratorThread(myExecution));
        codeHTMLExporterThread.start();
        /*
        try {
            codeHTMLExporterThread.join();
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
        */
        
    }
    
   public class PerlHTMLGeneratorThread implements Runnable {
        
        PerlExecution myExecution;
        PerlHTMLGeneratorThread(PerlExecution htmlCodeGenerationExecution) { myExecution = htmlCodeGenerationExecution;}
        
        @Override
        public void run() {
            myExecution.run();
        }
    }
}
