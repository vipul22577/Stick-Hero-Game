package com.example.apfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class enterGameController {
    private Player player;
    @FXML
    private Image image1;
    @FXML
    private Image image2;
    @FXML
    private Image image3;
    @FXML
    private Image selectedImage;

    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Label maxscoreL;
    @FXML
    private Label lastccoreL;
    @FXML
    private Label RewardccoreL;
    @FXML
    private Button bhutiya;
    @FXML
    private Button jungle;
    @FXML
    private Button aqua;

    public void getBackTolLoginScreen(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void bhutiyaenterTheGame(ActionEvent event)throws IOException{
        gameAnimation game = gameAnimation.getInstance(2,0);

        // Create a new thread to launch the gameAnimation
            // Call the start method of gameAnimation
            game.start(new Stage());
        // Close the current window (if needed)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    public void jungleenterTheGame(ActionEvent event)throws IOException{

        gameAnimation game = gameAnimation.getInstance(3,0);

        // Create a new thread to launch the gameAnimation
        // Call the start method of gameAnimation
        game.start(new Stage());
        // Close the current window (if needed)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    public void wateryaenterTheGame(ActionEvent event)throws IOException{
        gameAnimation game = gameAnimation.getInstance(1,0);
        game.start(new Stage());
        // Close the current window (if needed)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    public void reloadgame(ActionEvent event)throws IOException{
        gameAnimation game = gameAnimation.getInstance(4,1);
        game.start(new Stage());
        // Close the current window (if needed)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }
    public void setScore() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/example/apfinalproject/data.txt"));
        maxscoreL.setText(String.valueOf(Integer.parseInt(reader.readLine())));
        lastccoreL.setText(String.valueOf(Integer.parseInt(reader.readLine())));
        RewardccoreL.setText(String.valueOf(Integer.parseInt(reader.readLine())));
        reader.close();
    }

}
