/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.options.panel;

import java.io.File;
import java.util.prefs.Preferences;
import org.openide.modules.InstalledFileLocator;
import org.openide.util.NbPreferences;

public class PerlTidyPreferences {

    Preferences pref = NbPreferences.forModule(PerlTidyPanel.class);

    public String getPerlTidyBinary() {
        String perlTidyBinary = pref.get("perlTidyBinary", "").trim();
        return perlTidyBinary;
    }

    public String getPerlTidyColumnIndentation() {
        String perlTidyColumnIndentation = pref.get("perlTidyColumnIndentation", "").trim();
        return perlTidyColumnIndentation;
    }

    public String getPerlTidyLineLength() {
        String perlTidyLineLength = pref.get("perlTidyLineLength", "").trim();
        return perlTidyLineLength;
    }

    public boolean getPerlTidyGenerateLog() {
        boolean perlTidyGenerateLog = pref.getBoolean("perlTidyGenerateLog", false);
        return perlTidyGenerateLog;
    }
    
    public boolean getPerlTidyGenerateHTML() {
        boolean perlTidyGenerateHTML = pref.getBoolean("perlTidyGenerateHTML", false);
        return perlTidyGenerateHTML;
    }
    
    public boolean getPerlTidyGenerateHTMLTableOfContents() {
        boolean perlTidyGenerateHTMLTableOfContents = pref.getBoolean("perlTidyGenerateHTMLTableOfContents", false);
        return perlTidyGenerateHTMLTableOfContents;
    }

    public String getPerlTidyCSSFile() {
        String perlTidyCSSFile = pref.get("perlTidyCSSFile", "").trim();
        return perlTidyCSSFile;
    }

    public String getPerlTidyCustomHTMLOutputFolder() {
        String perlCustomHTMLOutputFolder = pref.get("perlCustomHTMLOutputFolder", "").trim();
        return perlCustomHTMLOutputFolder;
    }

    public boolean getPerlTidyHTMLWithPRE() {
        boolean perlTidyHTMLWithPRE = pref.getBoolean("perlTidyHTMLWithPRE", false);
        return perlTidyHTMLWithPRE;
    }

    public boolean getPerlTidyHTMLWithFRAME() {
        boolean perlTidyHTMLWithFRAME = pref.getBoolean("perlTidyHTMLWithFRAME", false);
        return perlTidyHTMLWithFRAME;
    }

    public String getBundledPerlTidyPath() {

        File perlTidy = InstalledFileLocator.getDefault().locate(
                "perltidy/perltidy",
                "org.languages.perl",
                false);
        String executableFolder = perlTidy.getParent();
        return executableFolder;
    }

    public boolean getPerlTidyUseConfigFile() {
        boolean perlTidyUseConfigFile = pref.getBoolean("perlTidyUseConfigFile", false);
        return perlTidyUseConfigFile;
    }
    
    public String getPerlTidyConfigFile() {
        String perlTidyConfigFile = pref.get("perlTidyUseConfigFile", "").trim();
        return perlTidyConfigFile;
    }
    
    public boolean getPerlTidyUsePBPConfig() {
        boolean perlTidyUsePBPConfig = pref.getBoolean("perlTidyUsePBPConfig", false);
        return perlTidyUsePBPConfig;
    }
    
    public String getPerlTidyAdditionalParameters() {
        String perlTidyAdditionalParameters = pref.get("perlTidyAdditionalParameters", "").trim();
        return perlTidyAdditionalParameters;
    }
    
    
    
}
