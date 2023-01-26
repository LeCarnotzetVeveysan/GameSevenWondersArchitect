package controllers;

import data.GameData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

import static other.LoadScene.changeLauncherScene;

public class ResultsController {

    @FXML
    private Button quitButton;
    @FXML
    private Label p1NameLabel, p2NameLabel,p3NameLabel,p4NameLabel,p5NameLabel,p6NameLabel,p7NameLabel;
    @FXML
    private Label p1WPLabel, p2WPLabel, p3WPLabel, p4WPLabel, p5WPLabel, p6WPLabel, p7WPLabel;
    @FXML
    private Label p1LPLabel, p2LPLabel, p3LPLabel, p4LPLabel, p5LPLabel, p6LPLabel, p7LPLabel;
    @FXML
    private Label p1CPLabel, p2CPLabel, p3CPLabel, p4CPLabel, p5CPLabel, p6CPLabel, p7CPLabel;
    @FXML
    private Label p1PPLabel, p2PPLabel, p3PPLabel, p4PPLabel, p5PPLabel, p6PPLabel, p7PPLabel;
    @FXML
    private Label p1TPLabel, p2TPLabel, p3TPLabel, p4TPLabel, p5TPLabel, p6TPLabel, p7TPLabel;
    private Label[] nameLabels, p1Labels, p2Labels, p3Labels, p4Labels, p5Labels, p6Labels, p7Labels;
    private Label[][] labelGrid;
    String[] playerNames;
    int[][] scoreBoard;

    public void initialize(){

        playerNames = GameData.getPlayerNames();
        scoreBoard = GameData.getScoreBoard();

        initLabels();
        setLabelValues();
    }

    private void initLabels() {
        nameLabels = new Label[]{p1NameLabel, p2NameLabel, p3NameLabel, p4NameLabel, p5NameLabel, p6NameLabel, p7NameLabel};
        p1Labels = new Label[]{p1WPLabel, p1LPLabel, p1CPLabel, p1PPLabel, p1TPLabel};
        p2Labels = new Label[]{p2WPLabel, p2LPLabel, p2CPLabel, p2PPLabel, p2TPLabel};
        p3Labels = new Label[]{p3WPLabel, p3LPLabel, p3CPLabel, p3PPLabel, p3TPLabel};
        p4Labels = new Label[]{p4WPLabel, p4LPLabel, p4CPLabel, p4PPLabel, p4TPLabel};
        p5Labels = new Label[]{p5WPLabel, p5LPLabel, p5CPLabel, p5PPLabel, p5TPLabel};
        p6Labels = new Label[]{p6WPLabel, p6LPLabel, p6CPLabel, p6PPLabel, p6TPLabel};
        p7Labels = new Label[]{p7WPLabel, p7LPLabel, p7CPLabel, p7PPLabel, p7TPLabel};
        labelGrid = new Label[][]{p1Labels, p2Labels, p3Labels, p4Labels, p5Labels, p6Labels, p7Labels};
    }

    private void setLabelValues() {
        for (int i = 0; i < playerNames.length;i++){
            nameLabels[i].setText(playerNames[i]);
            for(int j = 0; j < 5; j++){
                labelGrid[i][j].setText(String.valueOf(scoreBoard[i][j]));
            }
        }
    }

    @FXML
    void onMainMenuButtonClick() throws IOException {
        changeLauncherScene("game-init");
    }

    @FXML
    void onQuitButtonClick() {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

}
