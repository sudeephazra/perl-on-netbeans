/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.language.perl.project;

import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Sudeep
 */
@ServiceProvider(service=ProjectFactory.class)
public class PerlProjectFactory implements ProjectFactory  {

     public static final String PROJECT_FILE = ".perl_project.ini";

    @Override
    public boolean isProject(FileObject projectDirectory) {
        return (projectDirectory.getFileObject(PROJECT_FILE) != null);
    }

    @Override
    public Project loadProject(FileObject dir, ProjectState state) throws IOException {
        return isProject(dir) ? new PerlProject(dir, state) : null;
    }

    @Override
    public void saveProject(final Project project) throws IOException, ClassCastException {
        FileObject projectRoot = project.getProjectDirectory();
        if (projectRoot.getFileObject(PROJECT_FILE) == null) {
            throw new IOException("Project dir " + projectRoot.getPath() +
                    " deleted," +
                    " cannot save project");
        }
        ((PerlProject) project).getProjectDirectory();
    }
    
}
