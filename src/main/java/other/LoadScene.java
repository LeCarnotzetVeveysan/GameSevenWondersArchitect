package other;

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

    }

    public static void initLauncher() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource("/fxmls/launcher.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        launcherStage.setTitle("7WA Launcher");
        launcherStage.setScene(scene);
        launcherStage.show();

    }

    public static void changeScene(String type, String fxmlToShow) throws IOException {

        Stage stage = type.equals("main") ? mainStage : selectionStage;
        FXMLLoader fxmlLoader = new FXMLLoader(AppLaunch.class.getResource(fxmlToShow + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("7W Main window");
        stage.setScene(scene);
        stage.show();
    }

}