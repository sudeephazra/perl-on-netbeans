package org.language.perl.project.dancer;

import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.language.perl.action.PerlExecution;
import org.language.perl.action.SyntaxCheckAction;
import org.language.perl.file.PerlFileDataObject;
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.utilities.CheckInstalledPerlModules;
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
import org.openide.awt.HtmlBrowser;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.FilterNode;
import org.openide.nodes.FilterNode.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

public class PerlDancerProject implements Project {

    private final FileObject projectDir;
    private final ProjectState state;
    private Lookup lkp;

    PerlDancerProject(FileObject dir, ProjectState state) {
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
                new PerlDancerProjectActionProvider(this),
                new PerlDancerProjectMoveOrRenameOperation(),
                new PerlDancerProjectCopyOperation(),
                new PerlDancerProjectDeleteOperation(this),
                this,
                state,
                new PerlDancerProjectInfo(),
                new PerlDancerProjectLogicalView(this),});
        }
        return lkp;
    }

    private final class PerlDancerProjectActionProvider implements ActionProvider {

        private final String[] supported = new String[]{
            ActionProvider.COMMAND_DELETE,
            ActionProvider.COMMAND_COPY,
            ActionProvider.COMMAND_MOVE,
            ActionProvider.COMMAND_RENAME,
            ActionProvider.COMMAND_RUN_SINGLE,
            ActionProvider.COMMAND_RUN,
            ActionProvider.COMMAND_COMPILE_SINGLE

        };
        PerlDancerProject project;

        PerlDancerProjectActionProvider(PerlDancerProject p) {
            this.project = p;
        }

        @Override
        public String[] getSupportedActions() {
            return supported;
        }

        @Override
        public void invokeAction(String string, Lookup lookup) throws IllegalArgumentException {
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_DELETE)) {
                DefaultProjectOperations.performDefaultDeleteOperation(PerlDancerProject.this);
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_COPY)) {
                DefaultProjectOperations.performDefaultCopyOperation(PerlDancerProject.this);
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_MOVE)) {
                DefaultProjectOperations.performDefaultMoveOperation(PerlDancerProject.this);
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_RENAME)) {
                DefaultProjectOperations.performDefaultRenameOperation(PerlDancerProject.this, "");
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_RUN)
                    || string.equalsIgnoreCase(ActionProvider.COMMAND_RUN_SINGLE)) {
                JTextComponent editor = EditorRegistry.lastFocusedComponent();
                if (editor == null) {
                    JOptionPane.showMessageDialog(null, "No file selected. Please open the file bin/app.psgi file.");
                    return;
                }
                Document document = editor.getDocument();
                //Execute the app.psgi file
                String currentFile = NbEditorUtilities.getFileObject(document).getPath();
                String currentFilaName = NbEditorUtilities.getFileObject(document).getNameExt();
                if (!currentFilaName.equals("app.psgi")) {
                    JOptionPane.showMessageDialog(null,
                            "Please open and run the file bin\\app.psgi to execute the project.",
                            "Unable to run Dancer2 project",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    //When the app.psgi file is executed
                    File file = new File(currentFile);
                    String fileName = file.getAbsolutePath();

//                    GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
//                    String perlCustomBinary = perlPreferences.getPerlCustomBinary();
//                    String perlLibrary = perlPreferences.getPerlCustomLibrary();
//                    String perlPlackupBinaryLocation = perlPreferences.getPerlDancer2Location();
                    
                    CheckInstalledPerlModules checkModules = new CheckInstalledPerlModules();
                    
                    PerlExecution myExecution = new PerlExecution();
                    myExecution.setRedirectError(true);
                    myExecution.setWorkingDirectory(file.getParent());
                    myExecution.setDisplayName(file.getName() + " (Execute Dancer2)");
                    myExecution.setCommand(checkModules.getCurrentPlackup());
                    
//                    if (!perlLibrary.equals("")) {
//                        myExecution.setCommandArgs(perlLibrary);
//                    }
//                    if (!perlPlackupLibraryLocation.equals("")) {
//                        if(!(new File(perlPlackupLibraryLocation
//                                + PerlConstants.FILE_SEPARATOR
//                                + PerlConstants.PERL_DANCER2_PLACKUP)).exists()) {
//                            JOptionPane.showMessageDialog(null,
//                            "The plackup file does not exist in the Dancer2 location.",
//                            "Unable to run Dancer2 project",
//                            JOptionPane.ERROR_MESSAGE);
//                            return;
//                        }
//                        myExecution.setCommandArgs(perlPlackupLibraryLocation
//                                + PerlConstants.FILE_SEPARATOR
//                                + PerlConstants.PERL_DANCER2_PLACKUP);
//                    } else {
//                        myExecution.setCommandArgs(PerlConstants.PERL_DANCER2_PLACKUP);
//                    }
//                    myExecution.setCommandArgs(checkModules.getCurrentPlackup());
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
                try {
                    HtmlBrowser.URLDisplayer.getDefault().showURL(new URL(PerlConstants.DANCER2_DEFAULT_URL));
                } catch (MalformedURLException ex) {
                    Exceptions.printStackTrace(ex);
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
        }

        @Override
        public boolean isActionEnabled(String command, Lookup lookup) throws IllegalArgumentException {
            if (command.equals(ActionProvider.COMMAND_DELETE)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_COPY)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_MOVE)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_RENAME)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_RUN)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_RUN_SINGLE)) {
                return true;
            } else if (command.equals(ActionProvider.COMMAND_COMPILE_SINGLE)) {
                return true;
            } else {
                throw new IllegalArgumentException(command);
            }
        }
    }

    //New Info class
    private final class PerlDancerProjectInfo implements ProjectInformation {

        @StaticResource()
        public static final String PERL_ICON = "org/language/perl/project/dancer/perl-dancer-project.png";

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
            return PerlDancerProject.this;
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
    class PerlDancerProjectLogicalView implements LogicalViewProvider {

        @StaticResource()
        public static final String PERL_ICON = "org/language/perl/project/dancer/perl-dancer-project.png";
        private final PerlDancerProject project;

        public PerlDancerProjectLogicalView(PerlDancerProject project) {
            this.project = project;
        }

        @Override
        public Node createLogicalView() {
            try {
                FileObject Text = project.getProjectDirectory();
                DataFolder TextDataObject = DataFolder.findFolder(Text);
                Node realTextFolderNode = TextDataObject.getNodeDelegate();
                return new PerlDancerProjectFilterNode(realTextFolderNode, project);

            } catch (DataObjectNotFoundException donfe) {
                Exceptions.printStackTrace(donfe);
                return new AbstractNode(Children.LEAF);
            }
        }

        private final class PerlDancerProjectFilterNode extends FilterNode {

            final PerlDancerProject project;

            public PerlDancerProjectFilterNode(Node node, PerlDancerProject project) throws DataObjectNotFoundException {

                super(node,
                        new PerlDancerProjectFilterNodeFactory(node),
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
                    SystemAction.get(FileSystemAction.class) // Version Control is done from here
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

    private final class PerlDancerProjectMoveOrRenameOperation implements MoveOrRenameOperationImplementation {

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
            return new ArrayList<>();
        }

        @Override
        public List<FileObject> getDataFiles() {
            return new ArrayList<>();
        }

    }

    private final class PerlDancerProjectCopyOperation implements CopyOperationImplementation {

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
            return new ArrayList<>();
        }

        @Override
        public List<FileObject> getDataFiles() {
            return new ArrayList<>();
        }

    }

    private final class PerlDancerProjectDeleteOperation implements DeleteOperationImplementation {

        private final PerlDancerProject project;

        private PerlDancerProjectDeleteOperation(PerlDancerProject project) {
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
            return new ArrayList<>();
        }

        @Override
        public List<FileObject> getDataFiles() {
            List<FileObject> files = new ArrayList<>();
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
