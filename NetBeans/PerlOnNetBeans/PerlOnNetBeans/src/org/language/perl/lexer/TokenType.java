package org.language.perl.lexer;

public enum TokenType {
    WHITESPACE(1, "default"),
    COMMENT(2, "comment"),
    COMMANDS(3, "keyword"),
    SPECIAL_VAR(4, "variable"),
    LBRACK(5, "default"),
    RBRACK(6, "default"),
    LPAREN(7, "default"),
    RPAREN(8, "default"),
    LCURLY(9, "default"),
    RCURLY(10, "default"),
    COMMA(11, "default"),
    SEMI_COLON(12, "default"),
    COLON(13, "default"),
    DOT(14, "default"),
    BACKSLASH(15, "default"),
    CARET(16, "default"),
    UNDERSCORE(17, "default"), 
    PIPE(18, "default"), 
    AMPERSAND(19, "default"), 
    EQUAL(20, "default"),
    PLUS(21, "default"),
    MINUS(22, "default"),
    MULTIPLY(23, "default"),    
    DIVIDE(24, "default"),
    GT(25, "default"),
    LT(26, "default"),
    SQUOTE(27, "default"),
    DQUOTE(28, "default"),
    SCALAR_VAR(29, "default"),
    ARRAY_VAR(30, "default"),
    HASH_VAR(31, "default"),
    VARIABLE(32, "variable"),
    NUMBER(33, "number"),
    CHARACTERS(34, "default"),
    ESCAPE_SEQUENCE(35, "default"),
    STRING(36, "string")
//  POD(23, "pod"),
//  SUBST_OR_MATCH_OPER(30, "default"),
//  WORD_CHAR(34, "default")
    ;
    
    public int id;
    public String category;
    public String text;

    private TokenType(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public static TokenType valueOf(int id) {
        TokenType[] values = values();
        for (TokenType value : values) {
            if (value.id == id) {
                return value;
            }
        }
        throw new IllegalArgumentException("The id " + id + " is not recognized");
    }
}
