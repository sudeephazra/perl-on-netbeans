/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.utilities;

import java.io.File;
import org.openide.modules.InstalledFileLocator;

/**
 *
 * @author Sudeep
 */
public class PerlBundledUtilities {
    
    
    public String getBundledPerlAutoflushPath() {

        File perlAutoflush = InstalledFileLocator.getDefault().locate(
                "autoflush/Autoflush.pod",
                "org.languages.perl",
                false);
        String flushFolder = perlAutoflush.getParent();
        return flushFolder;
    }
    
    public String getBundledPerlBarewordsFile() {
        
        File perl_barewords = InstalledFileLocator.getDefault().locate(
                "perl_barewords.txt",
                "org.language.perl.completion",
                false);
        return perl_barewords.getAbsolutePath();
    }
    
    public String getBundledPerlTidyPath() {

        File perlTidy = InstalledFileLocator.getDefault().locate(
                "perltidy/perltidy",
                "org.languages.perl",
                false);
        String executableFolder = perlTidy.getParent();
        return executableFolder;
    }
}
