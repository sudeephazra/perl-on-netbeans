/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl;

import org.language.perl.editor.PerlFormatter;
import org.language.perl.lexer.PerlTokenId;
import org.language.perl.parser.Perl5Parser;
import org.language.perl.utilities.PerlConstants;
import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;

/**
 *
 * @author Sudeep
 */
@LanguageRegistration(mimeType = PerlConstants.MIME_TYPE)
public class PerlLanguageProvider extends DefaultLanguageConfig {

    @Override
    public Language<PerlTokenId> getLexerLanguage() {
        return PerlTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return PerlConstants.LANGUAGE_NAME;
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

    @Override
    public String getLineCommentPrefix() {
        return PerlConstants.LINE_COMMENT_PREFIX;
    }

    @Override
    public boolean hasFormatter() {
        return true;
    }

    @Override
    public Formatter getFormatter() {
        return new PerlFormatter();
    }
}
