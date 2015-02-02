package org.language.perl.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckInstalledPerlModules {

    //Check if Perl::Tidy is installed
    public Boolean isPerlTidyInstalled() {
        String line;
        String cmdLine = "perl -MPerl::Tidy -e 1";
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(cmdLine);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                output += (line + '\n');
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (output.matches("locate")) {
            return false;
        } else {
            return true;
        }
    }

    //Check if Perl::Critic is installed
    public Boolean isPerlCriticInstalled() {
        String line;
        String cmdLine = "perl -MPerl::Critic -e 1";
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(cmdLine);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                output += (line + '\n');
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (output.matches("locate")) {
            return false;
        } else {
            return true;
        }
    }
}
