/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.dancer;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import org.language.perl.options.panel.GeneralPanelPreferences;
import org.language.perl.utilities.PerlConstants;

/**
 *
 * @author Sudeep
 */
public class PerlDancerAppInitiator {

    public String getCurrentPerlExecutable() {
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlCustomBinary = perlPreferences.getPerlCustomBinary();
        String perlLibrary = perlPreferences.getPerlCustomLibrary();
        String currentPerlExecutable = "";

        if (perlCustomBinary.isEmpty()) {
            currentPerlExecutable = PerlConstants.PERL_DEFAULT;
        } else {
            if (!(new File(perlCustomBinary)).exists()) {
                return "";
            }
            currentPerlExecutable = perlCustomBinary;
        }
        currentPerlExecutable = currentPerlExecutable + perlLibrary;

        return currentPerlExecutable;
    }

    public String getCurrentDancer2() {
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlDancer2Location = perlPreferences.getPerlDancer2Location();
        String perlDancer2Script = "";
        if (perlDancer2Location.isEmpty()) {
            perlDancer2Script = PerlConstants.PERL_DANCER2_SCRIPT;
        } else {
            if (!(new File(perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_SCRIPT)).exists()) {
                return "";
            }
            perlDancer2Script = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_SCRIPT;
        }
        return perlDancer2Script;
    }

    public void createDefaultDancerWebApplication(File appLocation) {
        if  (getCurrentPerlExecutable().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                        "The Perl executable could not be located. Please check your settings.",
                        "Unable to locate Perl executable",
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (getCurrentDancer2().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                        "The Dancer2 script file does not exist in the Dancer2 location.",
                        "Unable to create Dancer2 project",
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!appLocation.getParentFile().exists()) {
            appLocation.getParentFile().mkdirs();
        }

        List<String> dancerCreation
                = Arrays.asList(getCurrentPerlExecutable(), getCurrentDancer2(), "-a", appLocation.getName());
//        File tempDirectory = new File(PerlConstants.TEMP_DIRECTORY);
//        File tempAppDirectory = new File(PerlConstants.TEMP_DIRECTORY
//                + PerlConstants.FILE_SEPARATOR
//                + appLocation.getName());
        try {
//            if (tempAppDirectory.exists()) {
//                FileOperations deleteFile = new FileOperations();
//                deleteFile.deleteFolder(tempAppDirectory);
//            }
            ProcessBuilder pb = new ProcessBuilder(dancerCreation);
            pb.directory(appLocation.getParentFile());
            Process p = pb.start();
            p.waitFor();
//            FileOperations fileOp = new FileOperations();
//            fileOp.copyFiles(tempAppDirectory, appLocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getPerlDancerPlackup() {
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlDancer2Location = perlPreferences.getPerlDancer2Location();
        String executableName = "";
        if (perlDancer2Location.isEmpty()) {
            executableName = PerlConstants.PERL_DANCER2_PLACKUP;
        } else {
            executableName = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_PLACKUP;
        }

        return executableName;
    }

}
