public class Token {
    private LexemPatterns lexemPattern;
    private String value;

    Token(LexemPatterns lexemPattern, String value) {
        this.lexemPattern = lexemPattern;
        this.value = value;
    }

    LexemPatterns getLexeme() {
        return lexemPattern;
    }
    String getValue()  {
        return value;
    }
    public String toString() {
        return lexemPattern + " '" + value + "'";
    }
}
