/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.module.template;

import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

public class PerlModuleTemplateWizardPanel1 implements WizardDescriptor.Panel<WizardDescriptor> {

    static String getFilename() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private PerlModuleTemplateVisualPanel1 component;
    public Project p;
    
    public PerlModuleTemplateWizardPanel1(Project p) {
        this.p = p;
    }
    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public PerlModuleTemplateVisualPanel1 getComponent() {
        if (component == null) {
            component = new PerlModuleTemplateVisualPanel1(p);
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        // use wiz.getProperty to retrieve previous panel state
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        wiz.putProperty("ModuleName", PerlModuleTemplateVisualPanel1.MODULE_NAME);
        wiz.putProperty("PackageName", PerlModuleTemplateVisualPanel1.PACKAGE_NAME);
        wiz.putProperty("ModuleInPackageLocation", PerlModuleTemplateVisualPanel1.LOCATION);
        wiz.putProperty("ProjectFolder", this.p.getProjectDirectory().getPath());
        
    }
    

}
