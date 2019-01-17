import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

class Lexer {
    private String acc = "";
    private int position = 0;
    private boolean waitForSuccess = true;
    private LexemPatterns currentLexeme = null;

    List<Token> identify(String input) {
        List<Token> tokens = new ArrayList<>();
        String str = input;
        if (str.length() != 0) {
            while (position < str.length()) {
                acc += str.charAt(position++);
                if (!find()) {
                    if (!waitForSuccess) {
                        waitForSuccess = true;
                        Token token = new Token(currentLexeme, format(acc));
                        tokens.add(token);
                        acc = "";
                        position--;
                    }
                    else{
                        System.exit(2);
                    }
                } else {
                    waitForSuccess = false;
                }
            }
            tokens.add(new Token(currentLexeme, acc));
        }else {
            System.err.println('\n' + "Error: Null input!");
            System.exit(1);
        }
        return tokens;
    }

    private boolean find() {
        for (LexemPatterns lexeme : LexemPatterns.values()) {
            Matcher matcher = lexeme.getPattern().matcher(acc);
            if (matcher.matches()) {
                currentLexeme = lexeme;
                return true;
            }
        }
        return false;
    }

    private String format(String acc) {
        return acc.substring(0, acc.length() - 1);
    }
}
