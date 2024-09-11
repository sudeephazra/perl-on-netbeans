/*
 * The MIT License
 *
 * Copyright 2024 Sudeep.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.language.perl.project;

import java.awt.Image;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.apache.commons.lang3.StringUtils;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.queries.VisibilityQuery;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 *
 * @author Sudeep
 */
public class PerlProjectNodes {
    
    @StaticResource
    private static final String IMAGE = "org/language/perl/file/carton-package.png";
    private static final String SRC_IMAGE = "org/language/perl/file/source.png";
    private static final String TST_IMAGE = "org/language/perl/file/tests.png";
    private static final String LIB_IMAGE = "org/language/perl/file/libraries.png";
    private static final String CONF_IMAGE = "org/language/perl/file/config.png";

    @NodeFactory.Registration(projectType = "org-language-perl-project", position = 1)
    public static NodeFactory sourceNode() {
        return new PerlSourceNodeFactory();
    }

    @NodeFactory.Registration(projectType = "org-language-perl-project", position = 2)
    public static NodeFactory testsNode() {
        return new PerlTestNodeFactory();
    }
    
    @NodeFactory.Registration(projectType = "org-language-perl-project", position = 3)
    public static NodeFactory librariesNode() {
        return new PerlLibrariesNodeFactory();
    }

    @NodeFactory.Registration(projectType = "org-language-perl-project", position = 5)
    public static NodeFactory importantNode() {
        return new PerlProjectFilesNodeFactory();
    }
    
    public static final String[] IMPORTANT_FILES = {
        "Dockerfile",
        "Jenkinsfile",
        "LICENSE",
        "cpanfile",
        "README.md",
        "Makefile.pl"
    };

    public static String[] EXCLUDED_DIRS = new String[]{
        "local",
        "cpanfile.snapshot",
        "build",
        "dist",
        "nbproject",
        ".ropeproject",
        ".coverage.json"
    };
    
    private static final class PerlSourceNodeFactory implements NodeFactory {

        @Override
        public NodeList createNodes(Project project) {
            try {
                final SourceFilesNode nd = new SourceFilesNode(project);
                return NodeFactorySupport.fixedNodeList(nd);
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
            return NodeFactorySupport.fixedNodeList();

        }

        @NbBundle.Messages("CTL_SourceName=Sources")
        public static class SourceFilesNode extends FilterNode {

            public SourceFilesNode(Project proj) throws DataObjectNotFoundException {
                super(DataObject.find(proj.getProjectDirectory()).getNodeDelegate(),
                        new SourcesChildren(DataObject.find(proj.getProjectDirectory().getFileObject("scripts")).getNodeDelegate(),
                                proj)
                );
            }

            @Override
            public String getDisplayName() {
                return Bundle.CTL_SourceName();
            }

            @Override
            public Image getIcon(int type) {
                Image original = super.getIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.assignToolTipToImage(ImageUtilities
                                .loadImage(SRC_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

            @Override
            public Image getOpenedIcon(int type) {
                Image original = super.getOpenedIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.assignToolTipToImage(ImageUtilities
                                .loadImage(SRC_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

        }

        private static class SourcesChildren extends FilterNode.Children implements ChangeListener {

            Project proj;

            public SourcesChildren(Node original, Project proj) {
                super(original);
                this.proj = proj;
                PerlPropertiesNotifier.addChangeListener(this);

            }

            @Override
            protected void addNotify() {
                super.addNotify();
                createNodes(original);
            }

            @Override
            protected Node[] createNodes(Node object) {
                List<Node> result = new ArrayList<>();
                for (Node node : super.createNodes(object)) {
                    if (accept(node)) {
                        result.add(node);
                    }
                }
                return result.toArray(Node[]::new);
            }

            private boolean accept(Node node) {
                String displayName = node.getDisplayName();
                SourceGroup[] sourceGroups = ProjectUtils.getSources(proj).getSourceGroups("sources");
                boolean isTest = false;
                if (sourceGroups.length > 0) {
                    isTest = Paths.get(sourceGroups[0].getRootFolder().getPath()).endsWith(displayName);

                }
                return !(!VisibilityQuery.getDefault().isVisible(node.getLookup().lookup(FileObject.class))
                        || StringUtils.equalsAny(displayName, EXCLUDED_DIRS)
                        || displayName.equals("cpanfile")
                        || isTest
                        || StringUtils.endsWithAny(displayName, IMPORTANT_FILES)
                        || displayName.startsWith("."));
            }

            @Override
            public void stateChanged(ChangeEvent ce) {
                if (ProjectManager.getDefault().isModified(proj)) {
                    changeOriginal(original);
                }
            }

        }

    }

    public static class PerlTestNodeFactory implements NodeFactory {

        @Override
        public NodeList createNodes(Project project) {
            try {
                final TestFilesNode nd = new TestFilesNode(project);
                return NodeFactorySupport.fixedNodeList(nd);
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
            return NodeFactorySupport.fixedNodeList();

        }

        @NbBundle.Messages("CTL_TestsName=Tests")
        public static class TestFilesNode extends FilterNode {
            
            public TestFilesNode(Project proj) throws DataObjectNotFoundException {
                super(DataObject.find(proj.getProjectDirectory()).getNodeDelegate(),
                        new TestsChildren(DataObject.find(proj.getProjectDirectory().getFileObject("t")).getNodeDelegate(),
                                proj)
                );
            }

            @Override
            public String getDisplayName() {
                return Bundle.CTL_TestsName();
            }

            @Override
            public Image getIcon(int type) {
                Image original = super.getIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.assignToolTipToImage(ImageUtilities
                                .loadImage(TST_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

            @Override
            public Image getOpenedIcon(int type) {
                Image original = super.getOpenedIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.assignToolTipToImage(ImageUtilities
                                .loadImage(TST_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

        }

        private static class TestsChildren extends FilterNode.Children implements ChangeListener {

            Project project;

            public TestsChildren(Node original, Project project) {
                super(original);
                this.project = project;
                PerlPropertiesNotifier.addChangeListener(this);
            }

            @Override
            protected void addNotify() {
                super.addNotify();
                createNodes(original);
            }

            @Override
            protected Node[] createNodes(Node object) {
                List<Node> result = new ArrayList<>();
                for (Node node : super.createNodes(object)) {
                    if (accept(node)) {
                        result.add(node);
                    }
                }
                return result.toArray(Node[]::new);
            }

            private boolean accept(Node node) {
                return !StringUtils.equalsAny(node.getDisplayName(), EXCLUDED_DIRS)
                        || VisibilityQuery.getDefault().isVisible(node.getLookup().lookup(FileObject.class));
            }

            @Override
            public void stateChanged(ChangeEvent ce) {
                if (ProjectManager.getDefault().isModified(project)) {
                    for (SourceGroup testSourceGroup : ProjectUtils.getSources(project).getSourceGroups("testsources")) {
                        try {
                            changeOriginal(DataObject.find(testSourceGroup.getRootFolder()).getNodeDelegate());
                        } catch (DataObjectNotFoundException ex) {
                            Exceptions.printStackTrace(ex);
                        }
                    }
                }
            }

        }

    }

    public static class PerlProjectFilesNodeFactory implements NodeFactory {

        @Override
        public NodeList createNodes(Project project) {
            try {
                ProjectFilesNode nd = new ProjectFilesNode(project);
                return NodeFactorySupport.fixedNodeList(nd);
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
            return NodeFactorySupport.fixedNodeList();
        }

        @NbBundle.Messages("CTL_ImportantFiles=Project Files")
        public static class ProjectFilesNode extends FilterNode {

            public ProjectFilesNode(Project proj) throws DataObjectNotFoundException {
                super(DataObject.find(proj.getProjectDirectory()).getNodeDelegate(),
                        new ProjectFilesChildren(DataObject.find(proj.getProjectDirectory()).getNodeDelegate()));
            }

            @Override
            public String getDisplayName() {
                return Bundle.CTL_ImportantFiles();
            }

            @Override
            public Image getIcon(int type) {
                Image original = super.getIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.addToolTipToImage(ImageUtilities
                                .loadImage(CONF_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

            @Override
            public Image getOpenedIcon(int type) {
                Image original = super.getOpenedIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.addToolTipToImage(ImageUtilities
                                .loadImage(CONF_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

        }

        private static class ProjectFilesChildren extends FilterNode.Children {

            public ProjectFilesChildren(Node original) {
                super(original);
            }

            @Override
            protected Node[] createNodes(Node object) {
                List<Node> result = new ArrayList<>();
                for (Node node : super.createNodes(object)) {
                    if (accept(node)) {
                        result.add(node);
                    }
                    if (node.getDisplayName().equals("nbproject")) {
                        FileObject fileObject = node.getLookup()
                                .lookup(FileObject.class).getFileObject("perl_project.properties");
                        if (fileObject != null) {
                            Node lookup = fileObject.getLookup().lookup(Node.class);
                            result.add(lookup);
                        }

                    }
                }
                return result.toArray(Node[]::new);
            }

            private boolean accept(Node node) {
                String displayName = node.getDisplayName();
                return StringUtils.endsWithAny(displayName, IMPORTANT_FILES)
                        && VisibilityQuery.getDefault().isVisible(node.getLookup().lookup(FileObject.class));
            }

        }

    }
    
    public static class PerlLibrariesNodeFactory implements NodeFactory {

        @Override
        public NodeList createNodes(Project project) {
            try {
                LibrariesNode nd = new LibrariesNode(project);
                return NodeFactorySupport.fixedNodeList(nd);
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
            return NodeFactorySupport.fixedNodeList();

        }

        @NbBundle.Messages("CTL_Dependencies=Libraries")
        public static class LibrariesNode extends FilterNode {

            public LibrariesNode(Project proj) throws DataObjectNotFoundException {
                super(DataObject.find(proj.getProjectDirectory()).getNodeDelegate(),
                        new ProjectLibrariesChildren(DataObject.find(proj.getProjectDirectory().getFileObject("lib")).getNodeDelegate(),
                                proj)
                );
            }

            @Override
            public String getDisplayName() {
                return Bundle.CTL_Dependencies();
            }

            @Override
            public Image getIcon(int type) {
                Image original = super.getIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.addToolTipToImage(ImageUtilities
                                .loadImage(LIB_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

            @Override
            public Image getOpenedIcon(int type) {
                Image original = super.getOpenedIcon(type);
                original = ImageUtilities.mergeImages(original,
                        ImageUtilities.addToolTipToImage(ImageUtilities
                                .loadImage(LIB_IMAGE), "<i>" + getDisplayName() + "</i>"), 7, 7);

                return original;
            }

        }

        private static class ProjectLibrariesChildren extends FilterNode.Children implements ChangeListener {
            
            Project proj;

            public ProjectLibrariesChildren(Node original, Project proj) {
                super(original);
                this.proj = proj;
                PerlPropertiesNotifier.addChangeListener(this);

            }

            @Override
            protected Node[] createNodes(Node object) {
                List<Node> result = new ArrayList<>();
                for (Node node : super.createNodes(object)) {
                    if (accept(node)) {
                        result.add(node);
                    }
                    if (node.getDisplayName().equals("nbproject")) {
                        FileObject fileObject = node.getLookup()
                                .lookup(FileObject.class).getFileObject("perl_project.properties");
                        if (fileObject != null) {
                            Node lookup = fileObject.getLookup().lookup(Node.class);
                            result.add(lookup);
                        }

                    }
                }
                return result.toArray(Node[]::new);
            }

            private boolean accept(Node node) {
                String displayName = node.getDisplayName();
                SourceGroup[] sourceGroups = ProjectUtils.getSources(proj).getSourceGroups("testsources");
                boolean isTest = false;
                if (sourceGroups.length > 0) {
                    isTest = Paths.get(sourceGroups[0].getRootFolder().getPath()).endsWith(displayName);

                }
                return !(!VisibilityQuery.getDefault().isVisible(node.getLookup().lookup(FileObject.class))
                        || StringUtils.equalsAny(displayName, EXCLUDED_DIRS)
                        || displayName.equals("cpanfile")
                        || isTest
                        || StringUtils.endsWithAny(displayName, IMPORTANT_FILES)
                        || displayName.startsWith("."));
            }

            @Override
            public void stateChanged(ChangeEvent e) {
                if (ProjectManager.getDefault().isModified(proj)) {
                    changeOriginal(original);
                }
            }

        }

    }
    
}
