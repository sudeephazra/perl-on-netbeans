package org.language.perl.lexer;

public enum TokenType {

    BACKSLASH(4, "default"),
    COLON(5, "default"),
    COMMA(6, "default"),
    COMMANDS(7, "keyword"),
    COMMENT(8, "comment"),
    DIVIDE(9, "default"),
    DOT(10, "default"),
    DQUOTE(11, "default"),
    EQUAL(12, "default"),
    EscapeSequence(13, "default"),
    GT(14, "default"),
    LBRACK(15, "default"), 
    LCURLY(16, "default"),
    LPAREN(17, "default"),
    LT(18, "default"),
    MINUS(19, "default"),
    MULTIPLY(20, "default"),
    NUMBER(21, "number"),
    PLUS(22, "default"),
//    POD(23, "pod"),
    RBRACK(23, "default"),
    RCURLY(24, "default"),
    RPAREN(25, "default"),
    SEMI_COLON(26, "default"),
    SPECIAL_VAR(27, "variable"),
    SQUOTE(28, "default"),
    STRING(29, "string"),
    SUBST_OR_MATCH_OPER(30, "default"),
    UNDERSCORE(31, "default"), 
    VARIABLE(32, "variable"),
    WHITESPACE(33, "default"),
    WORD_CHAR(34, "default");
    
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
