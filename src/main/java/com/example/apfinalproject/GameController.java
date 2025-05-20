package com.example.apfinalproject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    Scene scene;
    @FXML
    Stage stage;

    @FXML
    private Rectangle blackBlock;
    private Player player;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Get the initial X coordinate of the black block
        double initialX = blackBlock.getLayoutX();

        // Get the width of the black block
        double blockWidth = blackBlock.getWidth();

        // Calculate the destination X coordinate based on the block width
        double destinationX = initialX - blockWidth;

        // Create a TranslateTransition for the black block
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), blackBlock);

        // Set the destination X coordinate
        transition.setToX(destinationX);

        // Set the number of cycles (Animation.INDEFINITE for indefinite looping)
        transition.setCycleCount(100);

        // Play the animation
        transition.play();

    }
    public void getBack(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("themeView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public  void play(){

    }
    public void pause(){

    }
    public void placeAssasin(){

    }
    public void placeFlyer(){

    }
    public void makePillar(){

    }
    public void MakeStick(){

    }
}
