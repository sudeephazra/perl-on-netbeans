/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.options.panel;

import java.io.File;
import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;
import org.openide.util.Utilities;

public class PerlCriticPreferences {
    
    Preferences pref = NbPreferences.forModule(PerlCriticPanel.class);
    
    public String getPerlCriticBinary() {
        String perlCriticBinary = pref.get("perlCriticBinary", "").trim();
        return perlCriticBinary;        
    }
    
    public String getPerlCriticSeverity() {
        String perlCriticSeverity = pref.get("perlCriticSeverity", "").trim();
        return perlCriticSeverity;        
    }
    
    public String getPerlCriticForce(){
        String perlCriticForce = pref.get("perlCriticForce", "").trim();
        return perlCriticForce;
    }
    
    public String getPerlCriticTheme(){
        String perlCriticTheme = pref.get("perlCriticTheme", "").trim();
        return perlCriticTheme;
    }
    
    public String getBundledPerlCriticPath() {
        
        String path = System.getProperty("user.dir");
        String executableFolder;
        File newFile = new File(path);
        switch (Utilities.getOperatingSystem()) {
            case Utilities.OS_WIN_OTHER:
                executableFolder = (newFile.getAbsolutePath() + File.separator + "utils");
                break;
            //Not supporting Mac OS yet
            case Utilities.OS_MAC:
                executableFolder = null; //Pending
                break;
            case Utilities.OS_LINUX:
                executableFolder = (newFile.getParent() + File.separator + "utils") ; 
                break;
            default:
                executableFolder = "";
                break;
        }

        return executableFolder;
    }
    
    public String getBundledPerlCritic() {
        String perlCritic;
        switch (Utilities.getOperatingSystem()) {
            case Utilities.OS_WIN_OTHER:
                perlCritic = "perlcritic.bat";
                break;
            case Utilities.OS_MAC:
                perlCritic = "perlcritic";
                break;
            case Utilities.OS_LINUX:
                perlCritic = "perlcritic";
                break;
            default:
                perlCritic = "";
                break;
        }
        return perlCritic;
    }
}
