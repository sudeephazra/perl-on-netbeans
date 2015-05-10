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
        String cmdLine = "perl -MPerl::Critic -e 1";
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
        String cmdLine = "perl -MDancer -e 1";
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
        String cmdLine = "perl -MYAML -e 1";
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
