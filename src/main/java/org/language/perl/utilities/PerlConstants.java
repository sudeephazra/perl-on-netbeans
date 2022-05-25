/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.utilities;

public final class PerlConstants {
    
    public static final String PERL_DEFAULT = "perl";
       
    public static final String PERL_CRITIC_WIN = "perlcritic.bat";
    public static final String PERL_CRITIC_LINUX_MAC = "perlcritic";
    
    public static final String PERL_DOC_WIN = "perldoc.bat";
    public static final String PERL_DOC_LINUX_MAC = "perldoc";
        
    public static final boolean SUCCESS = true;
    public static final boolean FAILURE = false;

    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final String FILE_SEPARATOR = "/";
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");
    public static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir");
    
    public static final String MODULE_SEPARATOR = "::";
    
    public static final String MIME_TYPE = "text/x-perl";
    public static final String LINE_COMMENT_PREFIX = "#";
    
    public static final String LANGUAGE_NAME = "Perl";
    public static final String INCLUDE_LIBRARY_FLAG = " -I ";
    
    public static final String PERL_DANCER_WIN = "dancer.bat";
    public static final String PERL_DANCER_UIX = "dancer";
    public static final String DANCER_DEFAULT_URL = "http://localhost:3000/";
    
    public static final String PERL_DANCER2_SCRIPT = "dancer2";
    public static final String PERL_DANCER2_WIN = "dancer2.bat";
    public static final String PERL_DANCER2_UIX = "dancer2";
    public static final String PERL_DANCER2_PLACKUP = "plackup";
    public static final String DANCER2_DEFAULT_URL = "http://localhost:5000/";
        
    //Perl Tidy Parameters
    public static final String PERL_TIDY_BINARY_LINUX_MAC = "perltidy";
    public static final String PERL_TIDY_BINARY_WIN = "perltidy.bat";
    public static final String PERL_TIDY_BACKUP_PARAM = " -b";
    public static final String PERL_TIDY_INDENT_PARAM = " -i=";
    public static final String PERL_TIDY_DEFAULT_INDENT_PARAM = " -i=4";
    public static final String PERL_TIDY_LINE_LENGTH_PARAM = " -l=";
    public static final String PERL_TIDY_DEFAULT_LINE_LENGTH_PARAM = " -l=80";
    public static final String PERL_TIDY_CONFIG_FILE_PARAM = " -npro=";
    public static final String PERL_TIDY_DEFAULT_CONFIG_FILE = ".perltidyrc";
    public static final String PERL_TIDY_PBP_PARAM = " -pbp -nst";
    public static final String PERL_TIDY_GENERATE_LOG_PARAM = " -g";
    public static final String PERL_TIDY_GENERATE_HTML_PARAM = " -html";
    public static final String PERL_TIDY_GENERATE_HTML_PRE_PARAM = " -pre";
    public static final String PERL_TIDY_GENERATE_HTML_TOC_PARAM = " -toc";
    public static final String PERL_TIDY_GENERATE_HTML_FRAMES_PARAM = " -frm";
    public static final String PERL_TIDY_GENERATE_HTML_CSS_PARAM = " -css=";
    public static final String PERL_TIDY_GENERATE_HTML_OUTPUT_PARAM = " -opath=";
    
    //Output window display messages
    public static final String PERL_CODE_FORMATING_OUTPUT_WINDOW_TITLE = " (Source Code Formatting)";
    public static final String PERL_CODE_ANALYSIS_OUTPUT_WINDOW_TITLE = " (Source Code Analysis)";
    public static final String PERL_CODE_EXECUTION_OUTPUT_WINDOW_TITLE = " (Source Code Execution)";
    
    
    public static final String MSG_PERL_NOT_INSTALLED = "Perl not installed. Please install/configure Perl and try again.";
    public static final String MSG_PERL_TIDY_NOT_INSTALLED = "Perl::Tidy not installed and not configured in the Options panel. Please install/configure and try again.";
    public static final String MSG_PERL_TIDY_NOT_CONFIGURED = "PerlTidy binary in the Options panel is invalid. Please install/configure and try again.";
    
    public static final String MSG_PERL_CRITIC_NOT_INSTALLED = "Code Analysis not available. Please install/configure Perl::Critic and try again.";
            
}
