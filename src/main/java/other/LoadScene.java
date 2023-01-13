package other;

import application.AppData;
import application.AppLaunch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadScene {

    private static Stage launcherStage;
    private static Stage mainStage;
    private static Stage selectionStage;

    public LoadScene(Stage inputLauncher, Stage inputMain, Stage inputSelection){

        launcherStage = inputLauncher;
        mainStage = inputMain;
        selectionStage = inputSelection;

        launcherStage.setResizable(false);
        mainStage.setResizable(false);
        selectionStage.setResizable(false);

    }

    public static void changeLauncherScene(String fxmlToShow) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource("/fxmls/" + fxmlToShow + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        //Set proper window name
        launcherStage.setTitle("7WA Launcher");
        launcherStage.setScene(scene);
        launcherStage.show();

    }

    public static void changeScene(String type, String fxmlToShow) throws IOException {

        Stage stage = type.equals("main") ? mainStage : selectionStage;
        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource("/fxmls/" + fxmlToShow + ".fxml"));

        int screenWidth = type.equals("main") ? AppData.getPrefWidth() : 500;
        int screenHeight = type.equals("main") ? AppData.getPrefHeight() : 400;

        Scene scene = new Scene(fxmlLoader.load(), screenWidth, screenHeight);
        stage.setTitle("7W Main window");
        stage.setScene(scene);
        stage.show();
    }

}
