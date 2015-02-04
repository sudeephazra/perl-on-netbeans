/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import org.language.perl.utilities.PerlConstants;
import org.netbeans.api.editor.EditorRegistry;
import org.openide.cookies.EditorCookie;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;

@ActionID(
    category = "Build",
id = "org.netbeans.perl.file.perlDocAction")
@ActionRegistration(
    iconBase = "org/language/perl/images/perldoc_16x16.png",
displayName = "#CTL_perlDocAction")
@ActionReference(path = "Toolbars/Build", position = 800)
@Messages("CTL_perlDocAction=PerlDOC Help")
public final class perlDocAction implements ActionListener {

    private final EditorCookie context;

    public perlDocAction(EditorCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        String selectedText = "";
        JTextComponent editor = EditorRegistry.lastFocusedComponent();
        if (editor != null){
            selectedText = editor.getSelectedText();
            if (selectedText == null)
            {
                selectedText = "";
                //JOptionPane.showMessageDialog(null, selectedText);
                selectedText = JOptionPane.showInputDialog(null, "Search Perl DOC topic : ",
                                "Perl DOC Search", JOptionPane.PLAIN_MESSAGE);
                if ((selectedText == null) || (selectedText.isEmpty())) {
                    return;
                }
            }
        }
        
        PerlExecution myExecution = new PerlExecution();
        myExecution.setRedirectError(true);
        myExecution.setWorkingDirectory(System.getProperty("user.dir"));
        myExecution.setDisplayName("Perl DOC Help");
        //myExecution.setCommand("perldoc.bat");
        myExecution.setCommand(getPerlDoc());
        myExecution.setCommandArgs(" -f");
        myExecution.setCommandArgs(myExecution.getCommandArgs() + selectedText);
        try{
            myExecution.run();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public String getPerlDoc()
    {
        //String path = System.getProperty("user.dir") + File.separator + "bin" + File.separator;
        String executableName = null;
        switch( Utilities.getOperatingSystem() )
        {
            case Utilities.OS_WIN_OTHER:
                executableName = PerlConstants.PERL_DOC_WIN;
                break;
            case Utilities.OS_MAC:
                executableName = PerlConstants.PERL_DOC_UIX;
                break;
            case Utilities.OS_LINUX:
                executableName = PerlConstants.PERL_DOC_UIX; 
                break;
            default: 
                executableName = null;
                break;
        }
        return executableName;
    }
}
