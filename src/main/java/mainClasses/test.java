<<<<<<< HEAD
package mainClasses;

import data.Player;
import token.MaterialToken;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        Game game = new Game();
        ArrayList<String> playerNames = new ArrayList<>();

        playerNames.add("Player 1");
        playerNames.add("Player 2");
        playerNames.add("Player 3");

        game.initializeBoard(playerNames);

        // boucle indiquant la merveille de chaque joueurs
        for (int i = 0; i < game.getPlayers().size(); i++) {
            System.out.println("Player " + (i + 1) + " : " + game.getPlayers().get(i).getWonder().getName());
        }
    }

}
=======
package mainClasses;

import java.util.ArrayList;
import data.Board;

public class test {

    public static void main(String[] args) {
        ArrayList<String> playerNames = new ArrayList<>();

        playerNames.add("Player 1");
        playerNames.add("Player 2");
        playerNames.add("Player 3");

        Board board = new Board(playerNames);

        // boucle indiquant la merveille de chaque joueurs
        for (int i = 0; i < board.getPlayers().size(); i++) {
            System.out.println("Player " + (i + 1) + " : " + board.getPlayers().get(i).getWonder().getName());
        }
    }

}
>>>>>>> bruce
