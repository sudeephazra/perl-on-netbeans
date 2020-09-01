/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Sudeep
 */
public class FileOperations {

    public void deleteFolder(File folder) throws IOException {
        if(folder.isDirectory()){
 
    		//directory is empty, then delete it
    		if(folder.list().length==0){
 
    		   folder.delete();
    		   System.out.println("Directory is deleted : " 
                                                 + folder.getAbsolutePath());
 
    		}else{
 
    		   //list all the directory contents
        	   String files[] = folder.list();
 
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(folder, temp);
 
        	      //recursive delete
        	     deleteFolder(fileDelete);
        	   }
 
        	   //check the directory again, if empty then delete it
        	   if(folder.list().length==0){
           	     folder.delete();
        	     System.out.println("Directory is deleted : " 
                                                  + folder.getAbsolutePath());
        	   }
    		}
 
    	}else{
    		//if file, then delete it
    		folder.delete();
    		System.out.println("File is deleted : " + folder.getAbsolutePath());
    	}
    }

    public void copyFiles(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            //if directory not exists, create it
            if (!destination.exists()) {
                destination.mkdir();
                System.out.println("Directory copied from "
                        + source + "  to " + destination);
            }

            //list all the directory contents
            String files[] = source.list();

            for (String file : files) {
                //construct the source and destination file structure
                File sourceFile = new File(source, file);
                File destinationFile = new File(destination, file);
                //recursive copy
                copyFiles(sourceFile, destinationFile);
            }

        } else {
            OutputStream out;
            try ( //if file, then copy it
            //Use bytes stream to support all file types
                InputStream in = new FileInputStream(source)) {
                out = new FileOutputStream(destination);
                byte[] buffer = new byte[1024];
                int length;
                //copy the file content in bytes
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
            out.close();
            System.out.println("File copied from " + source + " to " + destination);
        }
    }
}
