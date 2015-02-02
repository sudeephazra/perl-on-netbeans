/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.language.perl.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

public class PerlTokenId implements TokenId {
    
    private static final Language<PerlTokenId> language = new PerlLanguageHierarchy().language();
    private final String name;
    private final String primaryCategory;
    private final int id;

    public PerlTokenId(String name, String primaryCategory, int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    public static Language<PerlTokenId> getLanguage() {
        return language;
    }
}
