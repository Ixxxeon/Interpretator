import java.util.regex.Pattern;

public enum LexemPatterns {
    TYPE(Pattern.compile("^int$")),
    IF(Pattern.compile("^if$")),
    FOR(Pattern.compile("^for$")),
    VAR(Pattern.compile("^[a-zA-Z]+$")),
    ASSIGN_OP(Pattern.compile("^=$")),
    LOG_OP(Pattern.compile("^<|>|<=|>=|!|!=|==$")),
    DIGIT(Pattern.compile("^0|[1-9][0-9]*")),
    OP(Pattern.compile("^\\+|\\-|\\*|\\/|\\%|\\^$")),
    WS(Pattern.compile("^\\s+")),
    L_F_B(Pattern.compile("^\\{$")),
    R_F_B(Pattern.compile("^}$")),
    L_R_B(Pattern.compile("^\\($")),
    R_R_B(Pattern.compile("^\\)$")),
    SEM(Pattern.compile("^;$"));

    private Pattern pattern;

    LexemPatterns(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
