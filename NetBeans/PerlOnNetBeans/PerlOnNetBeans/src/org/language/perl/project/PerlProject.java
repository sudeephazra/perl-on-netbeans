/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.project;

import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.language.perl.action.ExecuteAction;
import org.language.perl.action.SyntaxCheckAction;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.utilities.PerlConstants;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.CopyOperationImplementation;
import org.netbeans.spi.project.DeleteOperationImplementation;
import org.netbeans.spi.project.MoveOrRenameOperationImplementation;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.netbeans.spi.project.ui.support.DefaultProjectOperations;
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
//    PerlDebugger debugger;

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
                new PerlProjectActionProvider(),
                new PerlProjectMoveOrRenameOperation(),
                new PerlProjectCopyOperation(),
                new PerlProjectDeleteOperation(this),
                this,
                new Info(),
                new PerlProjectLogicalView(this),});
        }
        return lkp;
    }

    private final class PerlProjectActionProvider implements ActionProvider {

        private final String[] supported = new String[]{
            ActionProvider.COMMAND_DELETE,
            ActionProvider.COMMAND_COPY,
            ActionProvider.COMMAND_MOVE,
            ActionProvider.COMMAND_RENAME,
            ActionProvider.COMMAND_RUN_SINGLE,
            ActionProvider.COMMAND_RUN,
            ActionProvider.COMMAND_COMPILE_SINGLE/*,
            ActionProvider.COMMAND_DEBUG*/

        };

        @Override
        public String[] getSupportedActions() {
            return supported;
        }

        @Override
        public void invokeAction(String string, Lookup lookup) throws IllegalArgumentException {
            //Disabling till project structure is corrected 
            //Project should not have hidden files in structure

            if (string.equalsIgnoreCase(ActionProvider.COMMAND_DELETE)) {
                DefaultProjectOperations.performDefaultDeleteOperation(PerlProject.this);

            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_COPY)) {
                DefaultProjectOperations.performDefaultCopyOperation(PerlProject.this);
                //PerlProjectOperationsImplementation.copyProject(PerlProject.this);
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_MOVE)) {
                DefaultProjectOperations.performDefaultMoveOperation(PerlProject.this);
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_RENAME)) {
                DefaultProjectOperations.performDefaultRenameOperation(PerlProject.this, "");
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_RUN)
                    || string.equalsIgnoreCase(ActionProvider.COMMAND_RUN_SINGLE)) {
                JTextComponent editor = EditorRegistry.lastFocusedComponent();
                if (editor == null) {
                    JOptionPane.showMessageDialog(null, "No file selected. Please select a file.");
                    return;
                }
                Document document = editor.getDocument();
                if (NbEditorUtilities.getMimeType(document).equals(PerlConstants.MIME_TYPE)) {
                    ExecuteAction execute
                            = new ExecuteAction((PerlFileDataObject) NbEditorUtilities.getDataObject(document));
                    execute.runPerlFile();
                }
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_COMPILE_SINGLE)) {
                JTextComponent editor = EditorRegistry.lastFocusedComponent();
                if (editor == null) {
                    JOptionPane.showMessageDialog(null, "No file selected. Please select a file.");
                    return;
                }
                Document document = editor.getDocument();
                if (NbEditorUtilities.getMimeType(document).equals(PerlConstants.MIME_TYPE)) {
                    SyntaxCheckAction execute
                            = new SyntaxCheckAction((PerlFileDataObject) NbEditorUtilities.getDataObject(document));
                    execute.runSyntaxCheck();
                }
            }

//            if (string.equalsIgnoreCase(ActionProvider.COMMAND_DEBUG)) {
//                debugger.startDebugger();
//            }
        }

        @Override
        public boolean isActionEnabled(String command, Lookup lookup) throws IllegalArgumentException {
            //Disabling till project structure is corrected

            if (command.equals(ActionProvider.COMMAND_DELETE)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_COPY)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_MOVE)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_RENAME)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_RUN)) { //for enabling the debugger button.
                return true;
            } else if (command.equals(ActionProvider.COMMAND_RUN_SINGLE)) { //for enabling the debugger button.
                return true;
            } else if (command.equals(ActionProvider.COMMAND_COMPILE_SINGLE)) { //for enabling the debugger button.
                return true;
            } else if (command.equals(ActionProvider.COMMAND_DEBUG)) {
                return true;
            } else {
                throw new IllegalArgumentException(command);
            }
        }
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
                    CommonProjectActions.moveProjectAction(),
                    CommonProjectActions.renameProjectAction(),
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

    private final class PerlProjectMoveOrRenameOperation implements MoveOrRenameOperationImplementation {

        @Override
        public void notifyRenaming() throws IOException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void notifyRenamed(String string) throws IOException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void notifyMoving() throws IOException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void notifyMoved(Project prjct, File file, String string) throws IOException {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<FileObject> getMetadataFiles() {
            return new ArrayList<FileObject>();
        }

        @Override
        public List<FileObject> getDataFiles() {
            return new ArrayList<FileObject>();
        }

    }

    private final class PerlProjectCopyOperation implements CopyOperationImplementation {

        @Override
        public void notifyCopying() throws IOException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void notifyCopied(Project prjct, File file, String string) throws IOException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<FileObject> getMetadataFiles() {
            return new ArrayList<FileObject>();
        }

        @Override
        public List<FileObject> getDataFiles() {
            return new ArrayList<FileObject>();
        }

    }

    private final class PerlProjectDeleteOperation implements DeleteOperationImplementation {

        private final PerlProject project;

        private PerlProjectDeleteOperation(PerlProject project) {
            this.project = project;
        }

        @Override
        public void notifyDeleting() throws IOException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void notifyDeleted() throws IOException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<FileObject> getMetadataFiles() {
            return new ArrayList<FileObject>();
        }

        @Override
        public List<FileObject> getDataFiles() {
            List<FileObject> files = new ArrayList<FileObject>();
            FileObject[] projectChildren = project.getProjectDirectory().getChildren();
            for (FileObject fileObject : projectChildren) {
                addFile(project.getProjectDirectory(), fileObject.getNameExt(), files);
            }
            return files;
        }

        private void addFile(FileObject projectDirectory, String fileName, List<FileObject> result) {
            FileObject file = projectDirectory.getFileObject(fileName);
            if (file != null) {
                result.add(file);
            }
        }

    }

}
