import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Pattern INPUT_PATTERN = Pattern.compile("^[a-cA-C][0-2]$");

    public static void main(String[] args) {

        printMovingExample();

        System.out.println("\nStarting new game....");

        Game game = new Game();
        Boolean isGameOver = false;
        game.printBoard();

        char turn = 'X';

        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            System.out.print("\n" + turn + ": ");
            input = scanner.next();

            Matcher m = INPUT_PATTERN.matcher(input);

            if (m.matches()) {
                try {
                    isGameOver = game.move(input, turn);
                    if (isGameOver) {
                        game.printBoard();
                        System.out.println("\nGame over...Player " + turn + " won! yay!!");
                        break;
                    } else if (game.isTurnOver()) {
                        game.printBoard();
                        System.out.println("\nGame over...Nobody won :( ");
                        break;
                    }
                } catch (Exception ex) {
                    System.err.println("Spot is not empty, try again..");
                    continue;
                }
            } else {
                if (!"exit".equals(input)) {
                    System.err.println("Invalid move, try again..");
                    continue;
                }
            }
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            game.printBoard();
        } while (!"exit".equals(input) && !isGameOver);
    }

    private static void printMovingExample() {
        System.out.println("\nExample of moving:");
        System.out.println(" > X: A1");
        System.out.println(" > O: B2");
        System.out.println(" > exit // exit the program");
    }
}