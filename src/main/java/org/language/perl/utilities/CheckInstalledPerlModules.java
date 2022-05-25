package org.language.perl.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.apache.commons.lang.SystemUtils;
import org.language.perl.options.panel.GeneralPanelPreferences;

public class CheckInstalledPerlModules {

    private static boolean isPerlExecutableOnLinuxMac() throws IOException {
        String line;
        ProcessBuilder builder;
        BufferedReader reader;
        Process process;

        builder = new ProcessBuilder("/usr/bin/which", "perl");
        builder.redirectErrorStream(true);
        process = builder.start();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        while ((line = reader.readLine()) != null) {
            break;
        }
        return (line != null && !line.isEmpty());
    }

    private static boolean isPerlExecutableOnWindows() throws IOException {
        String line;
        ProcessBuilder builder;
        BufferedReader reader;
        Process process;

        builder = new ProcessBuilder("cmd", "/c", "perl", "-v");
        builder.redirectErrorStream(true);
        process = builder.start();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        while ((line = reader.readLine()) != null) {
            break;
        }
        return (line != null && !line.contains("is not recognized as an internal or external command"));
    }

    public boolean isPerlInstalled() throws IOException {
        if ((SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) && !isPerlExecutableOnLinuxMac()) {
            JOptionPane.showMessageDialog(null, PerlConstants.MSG_PERL_NOT_INSTALLED, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (SystemUtils.IS_OS_WINDOWS && !isPerlExecutableOnWindows()) {
            JOptionPane.showMessageDialog(null, PerlConstants.MSG_PERL_NOT_INSTALLED, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

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
//            perlDancer2Script = PerlConstants.PERL_DANCER2_SCRIPT;
            if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
                perlDancer2Script = PerlConstants.PERL_DANCER2_LINUX_MAC;
            }
            if (SystemUtils.IS_OS_WINDOWS) {
                perlDancer2Script = PerlConstants.PERL_DANCER2_WIN;
            }
        } else {
            perlDancer2Script = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_SCRIPT;
            if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
                perlDancer2Script = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_LINUX_MAC;
            }
            if (SystemUtils.IS_OS_WINDOWS) {
                perlDancer2Script = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR
                    + PerlConstants.PERL_DANCER2_WIN;
            }
        }
        return perlDancer2Script;
    }

    public String getCurrentPlackup() {
        GeneralPanelPreferences perlPreferences = new GeneralPanelPreferences();
        String perlDancer2Location = perlPreferences.getPerlDancer2Location();
        String perlPlackScript = "";
        if (perlDancer2Location.isEmpty()) {
//            perlPlackScript = PerlConstants.PERL_DANCER2_PLACKUP;
            if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
                perlPlackScript = PerlConstants.PERL_DANCER2_PLACKUP_LINUX_MAC;
            }
            if (SystemUtils.IS_OS_WINDOWS) {
                perlPlackScript = PerlConstants.PERL_DANCER2_PLACKUP_WIN;
            }
        } else {
            perlPlackScript = perlDancer2Location
                    + PerlConstants.FILE_SEPARATOR;
            if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
                perlPlackScript = perlPlackScript + PerlConstants.PERL_DANCER2_PLACKUP_LINUX_MAC;
            }
            if (SystemUtils.IS_OS_WINDOWS) {
                perlPlackScript = perlPlackScript + PerlConstants.PERL_DANCER2_PLACKUP_WIN;
            }
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
        } catch (IOException ex) {
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
            try ( BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                while ((line = input.readLine()) != null) {
                    output += (line + '\n');
                }
            }
        } catch (IOException ex) {
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
            try ( BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                while ((line = input.readLine()) != null) {
                    output += (line + '\n');
                }
//            p.waitFor();
            }
        } catch (IOException | InterruptedException ex) {
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
            try ( BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                while ((line = input.readLine()) != null) {
                    output += (line + '\n');
                }
//            p.waitFor();
            }
        } catch (IOException | InterruptedException ex) {
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
            try ( BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                while ((line = input.readLine()) != null) {
                    output += (line + '\n');
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return output.isEmpty();
    }
}
