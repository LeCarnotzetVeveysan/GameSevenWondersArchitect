
package mainClasses;

import java.util.ArrayList;
import data.Board;

public class test {

    public static void main(String[] args) {

        Board board = new Board();

        // boucle indiquant la merveille de chaque joueurs
        for (int i = 0; i < board.getPlayers().size(); i++) {
            System.out.println("Player " + (i + 1) + " : " + board.getPlayers().get(i).getWonder().getName());
        }
    }

}
