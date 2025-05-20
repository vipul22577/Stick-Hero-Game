package com.example.apfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    Button exitbutton;
    @FXML
    Pane pane;
    @FXML
    StackPane stackPane;

    @FXML
    AnchorPane anchorPane;

    private Stage stage;
    private Scene scene;
    private Parent root;



    public void exitTheGAme(){
        Stage stage =(Stage) stackPane.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("logout");
        alert.setHeaderText("Are you sure to exit?!");
        //alert.setContentText("");
        if(alert.showAndWait().get()== ButtonType.OK){
            alert.getContentText();
            System.out.println("exit the game");
            stage.close();}

    }
    public void enterTheGame(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("themeview.fxml"));
            Parent themeRoot = fxmlLoader.load();
            Scene themeScene = new Scene(themeRoot);
            Stage stage = (Stage) stackPane.getScene().getWindow();

            // Set the new scene to the stage
            stage.setScene(themeScene);

        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
    public void setRoot(Parent root) {
        this.root = root;
    }

    public Parent getRoot() {
        return root;
    }
    public static HelloController createHelloController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("themeview.fxml"));
            Parent root = fxmlLoader.load();
            HelloController controller = fxmlLoader.getController();
            controller.setRoot(root);
            return controller;
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null;
        }
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}