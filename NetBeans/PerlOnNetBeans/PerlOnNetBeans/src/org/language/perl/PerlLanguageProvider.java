/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.language.perl;

import org.language.perl.lexer.PerlTokenId;
import org.language.perl.parser.Perl5Parser;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;

/**
 *
 * @author Sudeep
 */
@LanguageRegistration(mimeType = "text/x-perl")
public class PerlLanguageProvider extends DefaultLanguageConfig  {

    private static final String LINE_COMMENT_PREFIX = "#";
    
    @Override
    public Language<PerlTokenId> getLexerLanguage() {
        return PerlTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "Perl";
    }
    
    @Override
    public StructureScanner getStructureScanner() {
        return new PerlStructureScanner();
    }

    @Override
    public boolean hasStructureScanner() {
        return true;
    }
    
    @Override
    public Parser getParser() {
        return new Perl5Parser();
    }
    
    
    
}
