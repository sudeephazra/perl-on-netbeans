/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.utilities;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openide.modules.InstalledFileLocator;

/**
 *
 * @author Sudeep
 */
public class PerlBundledUtilities {
    
    private static final Logger logger = Logger.getLogger(PerlBundledUtilities.class.getName());

    public String getBundledPerlAutoflushPath() {
        File perlAutoflush = null;
        String flushFolder = null;
        try {
            perlAutoflush = InstalledFileLocator.getDefault().locate(
                "org/language/perl/autoflush/Autoflush.pod",
                null,
                false);
            flushFolder = perlAutoflush.getParent();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Unable to get Autoflush module");
        }
        return flushFolder;
    }

    public String getBundledPerlBarewordsFile() {

        File perl_barewords = InstalledFileLocator.getDefault().locate(
                "org/language/perl/perl_barewords.txt",
                null,
                false);
        return perl_barewords.getAbsolutePath();
    }

    public String getBundledPerlTidyPath() {

        File perlTidy = InstalledFileLocator.getDefault().locate(
                "org/language/perl/perltidy/perltidy",
                null,
                false);
        String executableFolder = perlTidy.getParent();
        return executableFolder;
    }
}
