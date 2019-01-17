import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        StackMachine stackMachine = new StackMachine();
        System.out.println("Введите код:");
        String input = new String(in.nextLine());
        List<Token> tokens = lexer.identify(input);

        System.out.println();
        System.out.println("Входная строка: \n" + input);



        System.out.println();
        System.out.println("Список команд:");
        System.out.println(parser.lang(tokens));
        System.out.println();
        System.out.println(stackMachine.stackMachine(parser));
        System.out.println();


    }
}
