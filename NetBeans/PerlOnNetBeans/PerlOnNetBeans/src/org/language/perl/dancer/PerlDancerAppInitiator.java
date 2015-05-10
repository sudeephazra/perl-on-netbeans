/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.dancer;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.language.perl.utilities.FileOperations;
import org.language.perl.utilities.PerlConstants;
import org.openide.util.Utilities;

/**
 *
 * @author Sudeep
 */
public class PerlDancerAppInitiator {
    
    public String getPerlDancer()
    {
        //String path = System.getProperty("user.dir") + File.separator + "bin" + File.separator;
        String executableName = null;
        switch( Utilities.getOperatingSystem() )
        {
            case Utilities.OS_WIN_OTHER:
                executableName = PerlConstants.PERL_DANCER_WIN;
                break;
            case Utilities.OS_MAC:
                executableName = PerlConstants.PERL_DANCER_UIX;
                break;
            case Utilities.OS_LINUX:
                executableName = PerlConstants.PERL_DANCER_UIX; 
                break;
            default: 
                executableName = null;
                break;
        }
        return executableName;
    }
    
    public void createDefaultDancerWebApplication(File appLocation) {
        if (!appLocation.getParentFile().exists()) {
            appLocation.getParentFile().mkdirs();
        }

        List<String> dancerCreation = 
                Arrays.asList(getPerlDancer(), "-a", appLocation.getName());
        File tempDirectory = new File(PerlConstants.TEMP_DIRECTORY);
        File tempAppDirectory = new File(PerlConstants.TEMP_DIRECTORY
                                + PerlConstants.FILE_SEPARATOR
                                + appLocation.getName());
        try {
            if (tempAppDirectory.exists()) {
                FileOperations deleteFile = new FileOperations();
                deleteFile.deleteFolder(tempAppDirectory);
            }
            ProcessBuilder pb = new ProcessBuilder(dancerCreation);
            pb.directory(tempDirectory);
            Process p = pb.start();
            p.waitFor();
            FileOperations fileOp = new FileOperations();
            fileOp.copyFiles(tempAppDirectory, appLocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
