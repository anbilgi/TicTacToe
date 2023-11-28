public class ValidateGame {

    public boolean isMoveValid(char[][] board, String input) {
        Move move = new Move(input);

        if (move.row < 0 && move.row > 3)
            return false;
        if (move.col < 0 && move.row > 3)
            return false;

        if (board[move.row][move.col] == '_') {
            return true;
        }
        return false;
    }

    public boolean isStrike(char[][] board, char player) {
        boolean hasWon = false;

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                hasWon = true;
            else if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                hasWon = true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            hasWon = true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            hasWon = true;

        return hasWon;
    }
}
