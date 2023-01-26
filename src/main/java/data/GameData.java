package data;

public class GameData {

    private static int numberOfPlayers;
    private static String[] playerNames;
    private static int[][] scoreBoard;

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

}
