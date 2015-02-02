/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.project;

import java.awt.Image;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.actions.FileSystemAction;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;
/**
 *
 * @author Sudeep
 */
public class PerlProject implements Project {

    private final FileObject projectDir;
    private final ProjectState state;
    private Lookup lkp;

    PerlProject(FileObject dir, ProjectState state) {
        this.projectDir = dir;
        this.state = state;
    }
    
    @Override
    public FileObject getProjectDirectory() {
        return projectDir;
    }

    @Override
    public Lookup getLookup() {
        if (lkp == null) {
            lkp = Lookups.fixed(new Object[]{
                //Register your features here
               this,
               new Info(),
               new PerlProjectLogicalView(this),
            });
        }
        return lkp;
    }
    
    //New Info class
    private final class Info implements ProjectInformation {

        @StaticResource()
        public static final String PERL_ICON = "org/language/perl/images/perl-project.png";

        @Override
        public Icon getIcon() {
            return new ImageIcon(ImageUtilities.loadImage(PERL_ICON));
        }

        @Override
        public String getName() {
            return getProjectDirectory().getName();
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public Project getProject() {
            return PerlProject.this;
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener pl) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener pl) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

    }
    
    //Logical view class
    class PerlProjectLogicalView implements LogicalViewProvider {

        @StaticResource()
        public static final String PERL_ICON = "org/language/perl/images/perl-project.png";

        private final PerlProject project;

        public PerlProjectLogicalView(PerlProject project) {
            this.project = project;
        }

        @Override
        public Node createLogicalView() {
            try {
            FileObject Text = project.getProjectDirectory();
            DataFolder TextDataObject = DataFolder.findFolder(Text);
            Node realTextFolderNode = TextDataObject.getNodeDelegate();
            return new ProjectNode(realTextFolderNode, project);

            } catch (DataObjectNotFoundException donfe) {
                Exceptions.printStackTrace(donfe);
                return new AbstractNode(Children.LEAF);
            }
        }

        private final class ProjectNode extends FilterNode {

            final PerlProject project;

            public ProjectNode(Node node, PerlProject project) throws DataObjectNotFoundException {
                
                super(node,
                        new PerlProjectFilterNodeFactory(node),
                        new ProxyLookup(
                        new Lookup[]{
                            Lookups.singleton(project),
                            node.getLookup()
                        }));
                
                this.project = project;
            }

            @Override
            public Action[] getActions(boolean arg0) {
                return new Action[]{
                            CommonProjectActions.newFileAction(),
                            CommonProjectActions.copyProjectAction(),
                            CommonProjectActions.deleteProjectAction(),
                            CommonProjectActions.closeProjectAction(),
                            SystemAction.get(FileSystemAction.class)
                        };
            }

            @Override
            public Image getIcon(int type) {
                return ImageUtilities.loadImage(PERL_ICON);
            }

            @Override
            public Image getOpenedIcon(int type) {
                return getIcon(type);
            }

            @Override
            public String getDisplayName() {
                return project.getProjectDirectory().getName();
            }

        }

        @Override
        public Node findPath(Node root, Object target) {
            //leave unimplemented for now
            return null;
        }

    }

}
