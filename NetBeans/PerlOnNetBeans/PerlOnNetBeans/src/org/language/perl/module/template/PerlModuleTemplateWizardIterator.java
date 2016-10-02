/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.module.template;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.language.perl.utilities.PerlConstants;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.util.NbBundle.Messages;

// TODO the following section is disabled to use the existing file menu
@TemplateRegistration(folder = "Perl", displayName = "#PerlModuleTemplateWizardIterator_displayName", 
        iconBase = "org/language/perl/images/perl-module.png", description = "perlModuleTemplate.html",
        scriptEngine = "freemarker", content = "PerlModuleTemplate.pm")
@Messages("PerlModuleTemplateWizardIterator_displayName=New Perl Module")
// TODO the above section is disabled to use the existing file menu

public final class PerlModuleTemplateWizardIterator implements WizardDescriptor.InstantiatingIterator<WizardDescriptor> {

    public int index;

    public WizardDescriptor wizard;
    public List<WizardDescriptor.Panel<WizardDescriptor>> panels;

    private List<WizardDescriptor.Panel<WizardDescriptor>> getPanels() {
        if (panels == null) {
            panels = new ArrayList<WizardDescriptor.Panel<WizardDescriptor>>();
            // Change to default new file panel and add our panel at bottom
            Project p = Templates.getProject(wizard);
            SourceGroup[] groups = ProjectUtils.getSources(p).getSourceGroups(Sources.TYPE_GENERIC);

            // Add our panel at the bottom
            WizardDescriptor.Panel<WizardDescriptor> advNewFilePanel = 
                    Templates.buildSimpleTargetChooser(p, groups).bottomPanel(
                            new PerlModuleTemplateWizardPanel1(p)).create();

            panels.add(new PerlModuleTemplateWizardPanel1(p));
            String[] steps = createSteps();
            for (int i = 0; i < panels.size(); i++) {
                Component c = panels.get(i).getComponent();
                if (steps[i] == null) {
                    // Default step name to component name of panel. Mainly
                    // useful for getting the name of the target chooser to
                    // appear in the list of steps.
                    steps[i] = c.getName();
                }
                if (c instanceof JComponent) { // assume Swing components
                    JComponent jc = (JComponent) c;
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                    jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
                }
            }
        }
        return panels;
    }

    @Override
    public Set<?> instantiate() throws IOException {
        // TODO return set of FileObject (or DataObject) you have created
        //return Collections.emptySet();
        FileObject createdFile = null;
        
        // Read Title from wizard 
        String ModuleName = (String) wizard.getProperty("ModuleName");
        String PackageName = (String) wizard.getProperty("PackageName");
        String ModuleInPackageLocation = (String) wizard.getProperty("ModuleInPackageLocation");
        String ProjectFolder = (String) wizard.getProperty("ProjectFolder");
                
        // FreeMarker Template will get its variables from HashMap.
        // HashMap key is the variable name.
        Map args = new HashMap();
        args.put("ModuleName", ModuleName);
        args.put("ModuleInPackageLocation", ModuleInPackageLocation);
        args.put("ProjectFolder", ProjectFolder);

        //Get the template and convert it:
        FileObject template = Templates.getTemplate(wizard);
        DataObject dTemplate = DataObject.find(template);

        //Get the package:
        FileObject dir = Templates.getTargetFolder(wizard);
        DataFolder df = DataFolder.findFolder(dir);

        //Get the class:
        String targetName = Templates.getTargetName(wizard);
        
        //Define the template from the above,
        //passing the package, the file name, and the map of strings to the template:
        String path = df.getPrimaryFile().getPath() + PerlConstants.FILE_SEPARATOR + ModuleName;
        String base = ProjectFolder;
        String relative = new File(base).toURI().relativize(new File(path).toURI()).getPath();
        PackageName = relative.replace(PerlConstants.FILE_SEPARATOR, PerlConstants.MODULE_SEPARATOR);
        
        args.put("PackageName", PackageName);
        DataObject dobj = dTemplate.createFromTemplate(df, ModuleName, args);

        //Obtain a FileObject:
        createdFile = dobj.getPrimaryFile();
        
        // Return the created file.
        return Collections.singleton(createdFile);
    }

    @Override
    public void initialize(WizardDescriptor wizard) {
        this.wizard = wizard;
    }

    @Override
    public void uninitialize(WizardDescriptor wizard) {
        panels = null;
    }

    @Override
    public WizardDescriptor.Panel<WizardDescriptor> current() {
        return getPanels().get(index);
    }

    @Override
    public String name() {
        return index + 1 + ". from " + getPanels().size();
    }

    @Override
    public boolean hasNext() {
        return index < getPanels().size() - 1;
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public void nextPanel() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index++;
    }

    @Override
    public void previousPanel() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        index--;
    }

    // If nothing unusual changes in the middle of the wizard, simply:
    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }
    // If something changes dynamically (besides moving between panels), e.g.
    // the number of panels changes in response to user input, then use
    // ChangeSupport to implement add/removeChangeListener and call fireChange
    // when needed

    // You could safely ignore this method. Is is here to keep steps which were
    // there before this wizard was instantiated. It should be better handled
    // by NetBeans Wizard API itself rather than needed to be implemented by a
    // client code.
    private String[] createSteps() {
        String[] beforeSteps = (String[]) wizard.getProperty("WizardPanel_contentData");
        assert beforeSteps != null : "This wizard may only be used embedded in the template wizard";
        String[] res = new String[(beforeSteps.length - 1) + panels.size()];
        for (int i = 0; i < res.length; i++) {
            if (i < (beforeSteps.length - 1)) {
                res[i] = beforeSteps[i];
            } else {
                res[i] = panels.get(i - beforeSteps.length + 1).getComponent().getName();
            }
        }
        return res;
    }

}
