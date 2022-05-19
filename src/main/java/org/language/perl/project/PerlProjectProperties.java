/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.project;

import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author Sudeep
 */
public class PerlProjectProperties  implements ProjectCustomizer.CompositeCategoryProvider {

    private static final String GENERAL = "General";

    @ProjectCustomizer.CompositeCategoryProvider.Registration( projectType = "org-perl-project", position = 10)
    public static PerlProjectProperties createGeneral() {
        return new PerlProjectProperties();
    }
    
    @NbBundle.Messages("LBL_Config_General=General")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create( GENERAL, Bundle.LBL_Config_General(), null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category ctgr, Lookup lkp) {
        PerlProjectGeneralPropertiesPanel PerlProjectGeneralPropertiesPanel = new PerlProjectGeneralPropertiesPanel();
        final PerlProject project = lkp.lookup(PerlProject.class);
        PerlProjectGeneralPropertiesPanel.setPerlProjectFolderPath(project);
        return PerlProjectGeneralPropertiesPanel;
    }
    
}
