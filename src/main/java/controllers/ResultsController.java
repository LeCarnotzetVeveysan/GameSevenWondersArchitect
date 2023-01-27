package controllers;

import data.GameData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

import static other.LoadScene.changeLauncherScene;
import static other.UICommonMethods.getTextFromLangDict;

public class ResultsController {

    @FXML
    private Label playerNameLabel, gameResultsLabel;
    @FXML
    private Button quitButton, mainMenuButton;
    @FXML
    private ImageView p1LaurelIV, p2LaurelIV, p3LaurelIV, p4LaurelIV, p5LaurelIV, p6LaurelIV, p7LaurelIV;
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

    private ImageView[] laurelIVs;
    String[] playerNames;
    int[][] scoreBoard;

    public void initialize() throws IOException {

        gameResultsLabel.setText(getTextFromLangDict("gameResults"));
        playerNameLabel.setText(getTextFromLangDict("playerName"));
        mainMenuButton.setText(getTextFromLangDict("mainMenu"));
        quitButton.setText(getTextFromLangDict("quit"));

        playerNames = GameData.getPlayerNames();
        scoreBoard = GameData.getScoreBoard();

        initComponents();
        setLabelValues();
        showWinner();
    }



    private void initComponents() {
        laurelIVs = new ImageView[]{p1LaurelIV, p2LaurelIV, p3LaurelIV, p4LaurelIV, p5LaurelIV, p6LaurelIV, p7LaurelIV};
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

        for (int i = 0; i < 7;i++){
            nameLabels[i].setText("");
            for(int j = 0; j < 5; j++){
                labelGrid[i][j].setText("");
            }
        }

        for (int i = 0; i < playerNames.length;i++){
            nameLabels[i].setText(playerNames[i]);
            for(int j = 0; j < 5; j++){
                labelGrid[i][j].setText(String.valueOf(scoreBoard[i][j]));
            }
        }
    }

    private void showWinner() {

        for(ImageView iv : laurelIVs){
            iv.setVisible(false);
        }

        int topScore = -1;
        for (int i = 0; i < playerNames.length; i++){
            if(scoreBoard[i][4] > topScore){
                topScore = scoreBoard[i][4];
            }
        }
        for (int i = 0; i < playerNames.length; i++){
            if(scoreBoard[i][4] == topScore){
                laurelIVs[i].setVisible(true);
                nameLabels[i].setFont(Font.font("system", FontWeight.BOLD, 14));
                //ajouter un petit contour pour bien voir le texte
                nameLabels[i].setTextFill(Color.GOLDENROD);
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
