package org.language.perl.lexer;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.language.perl.grammar.AntlrCharStream;

import org.language.perl.grammar.PerlLexer;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class Perl5Lexer implements Lexer<PerlTokenId> {
    
    private LexerRestartInfo<PerlTokenId> lexerRestartInfo;
    private PerlLexer perlLexer;

   
    public Perl5Lexer(LexerRestartInfo<PerlTokenId> lexerRestartInfo) {
        this.lexerRestartInfo = lexerRestartInfo;
        AntlrCharStream charStream = new AntlrCharStream(lexerRestartInfo.input(), "PerlEditor");
        perlLexer = new PerlLexer((CharStream) charStream);
        
    }

    @Override
    public org.netbeans.api.lexer.Token<PerlTokenId> nextToken() {
        Token token = perlLexer.nextToken();
        if (token.getType() != PerlLexer.EOF) {
            PerlTokenId tokenId = PerlLanguageHierarchy.getToken(token.getType());
            return lexerRestartInfo.tokenFactory().createToken(tokenId);
        }
        return null;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {}
    
}
