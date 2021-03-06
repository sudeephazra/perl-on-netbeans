/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.project.existing.sources;

import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service=ProjectFactory.class)
public class PerlProjectExistingSourcesProjectFactory  implements ProjectFactory {
    
    public static final String PROJECT_EXISTING_FILE = 
            "nbproject/perl_project_existing_sources.xml";
    
    @Override
    public boolean isProject(FileObject projectDirectory) {
        return projectDirectory.getFileObject(PROJECT_EXISTING_FILE) != null;
    }

    @Override
    public Project loadProject(FileObject dir, ProjectState state) throws IOException {
        return isProject(dir) ? new PerlProjectWithExistingSources(dir, state) : null;
    }

    @Override
    public void saveProject(Project project) throws IOException, ClassCastException {
        FileObject projectRoot = project.getProjectDirectory();
        if (projectRoot.getFileObject(PROJECT_EXISTING_FILE) == null) {
            throw new IOException("Project dir " + projectRoot.getPath() +
                    " deleted," +
                    " cannot save project");
        }
        ((PerlProjectWithExistingSources) project).getProjectDirectory();
    }
    
}
