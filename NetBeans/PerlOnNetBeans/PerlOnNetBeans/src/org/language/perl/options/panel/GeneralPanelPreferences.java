/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.options.panel;

import java.util.prefs.Preferences;
import org.language.perl.utilities.PerlConstants;
import org.openide.util.NbPreferences;

/**
 *
 * @author Sudeep
 */
public class GeneralPanelPreferences {

    Preferences pref = NbPreferences.forModule(GeneralPanel.class);

    public String getPerlCustomBinary() {
        String perlCustomBinary = pref.get("perlBinary", "").trim();
        return perlCustomBinary;
    }
    
    public String getPerlDancer2Location() {
        String perlDancer2Location = pref.get("perlDancer2Location", "").trim();
        return perlDancer2Location;
    }

    public String getPerlCustomLibrary() {
        String perlLibraryList = pref.get("perlLibrary", "");
        String perlLibrary = "";
        if (!perlLibraryList.equals("")) {
            String[] perlLibraryLocations = perlLibraryList.split(";");
            for (String value : perlLibraryLocations) {
                if (!value.equals("")) {
                    perlLibrary = perlLibrary + PerlConstants.INCLUDE_LIBRARY_FLAG
                        + "\"" + value + "\"";
                }
            }
        }
        return perlLibrary;
    }
}
