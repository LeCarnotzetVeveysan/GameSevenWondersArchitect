package controllers;

import javafx.scene.Node;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;

public class PreviewController {

    public void onBackButtonClick(InputEvent e){
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
