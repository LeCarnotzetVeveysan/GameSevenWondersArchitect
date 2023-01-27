package controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static utils.UICommonMethods.getTextFromLangDict;

public class PreviewController {

    @FXML
    private Label windowSizeLB;
    @FXML
    private Button backButton;

    public void initialize() throws IOException {
        windowSizeLB.setText(getTextFromLangDict("windowSizeIndic"));
        backButton.setText(getTextFromLangDict("understood"));
    }

    public void onBackButtonClick(InputEvent e){
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
