package org.language.perl.lexer;

public enum TokenType {
    T__0(1, "keyword"),
    T__1(2, "keyword"),
    T__2(3, "keyword"),
    T__3(4, "keyword"),
    WHITESPACE(5, "default"),
    COMMENT(6, "comment"),
    VARIABLE_SCOPE(7, "keyword"),
    COMMANDS(8, "keyword"),
    SPECIAL_VAR(9, "variable"),
    LBRACK(10, "default"),
    RBRACK(11, "default"),
    LPAREN(12, "default"),
    RPAREN(13, "default"),
    LCURLY(14, "default"),
    RCURLY(15, "default"),
    COMMA(16, "default"),
    SEMI_COLON(17, "default"),
    COLON(18, "default"),
    DOT(19, "default"),
    BACKSLASH(20, "default"),
    CARET(21, "default"),
    UNDERSCORE(22, "default"),
    PIPE(23, "default"),
    AMPERSAND(24, "default"),
    EQUAL(25, "default"),
    PLUS(26, "default"),
    MINUS(27, "default"),
    MULTIPLY(28, "default"),
    DIVIDE(29, "default"),
    GT(30, "default"),
    LT(31, "default"),
    SQUOTE(32, "default"),
    DQUOTE(33, "default"),
    HASH_LITERAL(34, "default"),
    QUESTIONMARK_LITERAL(35, "default"),
    EXCLAMATION_LITERAL(36, "default"),
    SCALAR_VAR(37, "default"),
    ARRAY_VAR(38, "default"),
    HASH_VAR(39, "default"),
    DIGIT(40, "default"),
    VARIABLE(41, "variable"),
    NUMBER(42, "number"),
    CHARACTERS(43, "default"),
    ESCAPE_SEQUENCE(44, "default"),
    STRING(45, "string") 
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
