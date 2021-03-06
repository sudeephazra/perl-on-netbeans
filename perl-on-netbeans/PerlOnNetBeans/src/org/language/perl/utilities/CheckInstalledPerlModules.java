package org.language.perl.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.language.perl.options.panel.GeneralPanelPreferences;

public class CheckInstalledPerlModules {

    public String getCurrentPerlExecutable() {
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlCustomBinary = perlPreferences.getPerlCustomBinary();
        String perlLibrary = perlPreferences.getPerlCustomLibrary();
        String currentPerlExecutable = "";

        if (perlCustomBinary.equals("")) {
            currentPerlExecutable = PerlConstants.PERL_DEFAULT;
        } else {
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
            perlDancer2Script = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_SCRIPT;
        }
        return perlDancer2Script;
    }

    public String getCurrentPlackup() {
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlDancer2Location = perlPreferences.getPerlDancer2Location();
        String perlPlackScript = "";
        if (perlDancer2Location.isEmpty()) {
            perlPlackScript = PerlConstants.PERL_DANCER2_PLACKUP;
        } else {
            perlPlackScript = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_PLACKUP;
        }
        return perlPlackScript;
    }

    //Check if Perl::Tidy is installed
    public Boolean isPerlTidyInstalled() {
        String line;
        String cmdLine = this.getCurrentPerlExecutable() + " -MPerl::Tidy -e 1";
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(cmdLine);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = input.readLine()) != null) {
                output += (line + '\n');
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output.isEmpty();
    }

    //Check if Perl::Critic is installed
    public Boolean isPerlCriticInstalled() {
        String line;
        String cmdLine = this.getCurrentPerlExecutable() + " -MPerl::Critic -e 1";
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(cmdLine);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = input.readLine()) != null) {
                output += (line + '\n');
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return output.isEmpty();
    }

    //Check if Dancer is installed
    public Boolean isPerlDancerInstalled() {
        String line;
        String cmdLine = this.getCurrentPerlExecutable() + " -MDancer -e 1";
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(cmdLine);
            p.waitFor();
            BufferedReader input
                    = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = input.readLine()) != null) {
                output += (line + '\n');
            }
//            p.waitFor();
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output.isEmpty();
    }

    public Boolean isPerlDancer2Installed() {
        String line;
        String cmdLine = this.getCurrentPerlExecutable() + " -MDancer2 -e 1";
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(cmdLine);
            p.waitFor();
            BufferedReader input
                    = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = input.readLine()) != null) {
                output += (line + '\n');
            }
//            p.waitFor();
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output.isEmpty();
    }

    //Check if YAML is installed
    public Boolean isYAMLInstalled() {
        String line;
        String cmdLine = this.getCurrentPerlExecutable() + " -MYAML -e 1";
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(cmdLine);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = input.readLine()) != null) {
                output += (line + '\n');
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return output.isEmpty();
    }
}
