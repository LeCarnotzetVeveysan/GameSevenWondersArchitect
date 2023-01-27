package data;

import java.util.ArrayList;

public class GameData {

    private static Board board;
    private static int numberOfPlayers;
    private static String[] playerNames;
    private static int[][] scoreBoard;
    private static int actionPlayerIndex;
    private static int halicarnasseIndex;
    private static int alexandrieIndex;

    public static int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public static void setNumberOfPlayers(int input){
        numberOfPlayers = input;
    }

    public static String[] getPlayerNames(){
        return playerNames;
    }

    public static void setPlayerNames(String[] input){
        playerNames = input;
    }

    public static int[][] getScoreBoard(){ return scoreBoard; }

    public static void setScoreBoard(int[][] inputBoard){ scoreBoard = inputBoard; }

    public static int getActionPlayerIndex(){ return actionPlayerIndex; }

    public static void setActionPlayerIndex(int input){ actionPlayerIndex = input; }

    public static int getHalicarnasseIndex(){ return halicarnasseIndex; }

    public static void setHalicarnasseIndex(int input){ halicarnasseIndex = input; }

    public static int getAlexandrieIndex(){ return alexandrieIndex; }

    public static void setAlexandrieIndex(int input){ alexandrieIndex = input; }

    public static Board getBoard() { return board; }

    public static void setBoard(Board input) { board = input; }
}
