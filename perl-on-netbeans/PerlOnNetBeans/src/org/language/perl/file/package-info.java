@TemplateRegistration(folder = "Perl", content = "PerlFileTemplate.pl", 
        displayName = "Perl File", scriptEngine = "freemarker",
        iconBase = "org/language/perl/images/perl-module.png")
//@ContainerRegistration(id = "PerlOnNetBeans", categoryName = "#OptionsCategory_Name_PerlOnNetBeans", iconBase = "org/netbeans/perl/actions/32x32-perl-options.png", keywords = "#OptionsCategory_Keywords_PerlOnNetBeans", keywordsCategory = "PerlOnNetBeans")
@Messages(value = {"OptionsCategory_Name_PerlOnNetBeans=Perl On NetBeans", 
    "OptionsCategory_Keywords_PerlOnNetBeans=Perl On NetBeans"})

package org.language.perl.file;

import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.spi.options.OptionsPanelController.ContainerRegistration;
import org.openide.util.NbBundle.Messages;

