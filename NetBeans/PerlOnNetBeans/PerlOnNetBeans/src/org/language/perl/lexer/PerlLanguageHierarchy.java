
package org.language.perl.lexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class PerlLanguageHierarchy extends LanguageHierarchy<PerlTokenId>{
    
    private static List<PerlTokenId> tokens = new ArrayList<PerlTokenId>();
    private static Map<Integer, PerlTokenId> idToToken = new HashMap<Integer, PerlTokenId>();

    static {
        TokenType[] tokenTypes = TokenType.values();
        for (TokenType tokenType : tokenTypes) {
            tokens.add(new PerlTokenId(tokenType.name(), tokenType.category, tokenType.id));
        }
        for (PerlTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized PerlTokenId getToken(int id) {
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<PerlTokenId> createTokenIds() {
        return tokens;
    }

    @Override
    protected synchronized Lexer<PerlTokenId> createLexer(LexerRestartInfo<PerlTokenId> info) {
        
        return new Perl5Lexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-perl";
    }
}
