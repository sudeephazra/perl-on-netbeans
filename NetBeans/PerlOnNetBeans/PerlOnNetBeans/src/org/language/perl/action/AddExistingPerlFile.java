/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;


@ActionID(
    category = "File",
id = "org.language.perl.action.AddExistingPerlFile")
@ActionRegistration(
    iconBase = "org/language/perl/images/perl-project-add-file.png",
displayName = "#CTL_AddExistingFile")
@ActionReference(path = "Toolbars/File", position = 150)
@Messages("CTL_AddExistingFile=Add Existing File(s)")
public final class AddExistingPerlFile implements ActionListener {

    private final Project context;

    public AddExistingPerlFile(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        // TODO use context
        String newLocation = context.getProjectDirectory().getPath();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        
        int returnVal;
        returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            for (File file : files)
            {
                FileObject source = FileUtil.toFileObject(file);
                FileObject dest = FileUtil.toFileObject(new File(newLocation));
                try {
                    FileUtil.copyFile(source, dest, source.getName());
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }
}
