import java.util.Arrays;

public class Game {

    char[][] board;

    ValidateGame validateGame = new ValidateGame();

    int turns = 9;

    public Game() {
        board = new char[3][3];
        for (char[] row : board)
            Arrays.fill(row, '_');
    }

    public void printBoard() {
        System.out.print("\n   A  B   C ");
        for (int i = 0; i < 3; i++) {
            System.out.print("\n " + i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
        }
        System.out.println("");
    }

    public boolean move(String input, char player) throws Exception {
        try {
            if (turns <= 0)
                throw new Exception("Game over!");
            if (validateGame.isMoveValid(board, input)) {
                makeMove(input, player);
                turns--;
            }
            else{
                throw new Exception("invalid move");
            }
        } catch (Exception e) {
            throw new Exception("invalid move");
        }
        return validateGame.isStrike(board, player);
    }

    private void makeMove(String input, char player) {
        Move move = new Move(input);
        board[move.row][move.col] = player;
    }

    public boolean isTurnOver(){
        return turns==0;
    }
}
