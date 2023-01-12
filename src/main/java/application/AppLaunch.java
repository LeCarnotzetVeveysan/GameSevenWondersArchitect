package application;

import javafx.application.Application;
import javafx.stage.Stage;
import other.LoadScene;

public class AppLaunch extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Stage launcherStage = new Stage();
        Stage mainStage = new Stage();
        Stage selectionStage = new Stage();
        LoadScene ls = new LoadScene(launcherStage, mainStage, selectionStage);
        ls.initLauncher();
    }

    public static void main(String[] args) {
        launch();
    }

}