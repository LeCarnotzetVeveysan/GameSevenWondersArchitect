
package tests;

import application.AppData;
import data.GameData;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.LoadScene;


import java.io.IOException;

public class test2 extends Application {

    public static void main() throws IOException {
        Stage launcherStage = new Stage();
        Stage mainStage = new Stage();
        Stage selectionStage = new Stage();
        LoadScene ls = new LoadScene(launcherStage, mainStage, selectionStage);
        String[] names = new String[]{"jean-mi","edouard","gusse3","jaiplusdidée"};
        GameData.setPlayerNames(names);
        AppData.setLanguage("IT");
        initTestScoreBoard();
        ls.changeLauncherScene("results");
    }

    private static void initTestScoreBoard() {
        int[] p1score = new int[]{1,2,3,4,5};
        int[] p2score = new int[]{2,4,6,8,10};
        int[] p3score = new int[]{3,6,9,12,15};
        int[] p4score = new int[]{4,8,12,16,20};
        int[][] scoreBoard = new int[][]{p1score, p2score, p3score, p4score};
        GameData.setScoreBoard(scoreBoard);
    }

    @Override
    public void start(Stage stage) throws Exception {
        main();
    }
}
