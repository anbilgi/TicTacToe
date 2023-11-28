import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Move {

    int row;

    int col;

    public Move(String input) {
        HashMap<Integer, Integer> move = new HashMap<>();

        Pattern patternPosition = Pattern.compile("(\\w)(\\d)");
        Matcher matcherPosition = patternPosition.matcher(input);

        if (!matcherPosition.matches()) {
            System.err.println("Move is not well constructed");
        }

        this.col = (int) (Character.toUpperCase(matcherPosition.group(1).charAt(0)))-'A';
        this.row = Integer.parseInt(matcherPosition.group(2));
    }
}


