/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.project.existing.sources;

import javax.swing.JComponent;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author Sudeep
 */
public class PerlProjectWithExistingSourcesProperties implements ProjectCustomizer.CompositeCategoryProvider {

    private static final String GENERAL = "General";

    @ProjectCustomizer.CompositeCategoryProvider.Registration(projectType = "org-perl-project-existing-sources", position = 10)
    public static PerlProjectWithExistingSourcesProperties createGeneral() {
        return new PerlProjectWithExistingSourcesProperties();
    }
    
    @NbBundle.Messages("LBL_Config_General=General")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create( GENERAL, org.language.perl.project.existing.sources.Bundle.LBL_Config_General(), null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category ctgr, Lookup lkp) {
        PerlProjectExistingSourcesGeneralPropertiesPanel PerlProjectGeneralPropertiesPanel = new PerlProjectExistingSourcesGeneralPropertiesPanel();
        final PerlProjectWithExistingSources project = lkp.lookup(PerlProjectWithExistingSources.class);
        PerlProjectGeneralPropertiesPanel.setPerlProjectFolderPath(project);
        return PerlProjectGeneralPropertiesPanel;
    }

}
