/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
@TemplateRegistration(
            folder = "Perl", 
            content = "/org/language/perl/file/PerlFileTemplate.pl", 
            displayName ="New Perl File", 
            position = 100,
            scriptEngine = "freemarker"
        )
@ContainerRegistration(id = "PerlOnNetBeans", 
        categoryName = "#OptionsCategory_Name_PerlOnNetBeans", 
        iconBase = "org/language/perl/images/perl-options-panel.png", 
        keywords = "#OptionsCategory_Keywords_PerlOnNetBeans", 
        keywordsCategory = "PerlOnNetBeans")
@Messages(value = {"OptionsCategory_Name_PerlOnNetBeans=Perl On NetBeans", 
    "OptionsCategory_Keywords_PerlOnNetBeans=Perl On NetBeans"})

package org.language.perl.options.panel;

import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.spi.options.OptionsPanelController.ContainerRegistration;
import org.openide.util.NbBundle.Messages;
