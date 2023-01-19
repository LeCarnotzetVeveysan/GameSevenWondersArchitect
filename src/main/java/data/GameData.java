package data;

public class GameData {

    private static int numberOfPlayers;
    private static String[] playerNames;

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

}
