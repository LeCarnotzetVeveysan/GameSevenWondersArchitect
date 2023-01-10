package classes;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        Game game = new Game();
        ArrayList<String> playerNames = new ArrayList<>();

        playerNames.add("Player 1");
        playerNames.add("Player 2");
        playerNames.add("Player 3");

        game.initializeBoard(playerNames);
    }

}
