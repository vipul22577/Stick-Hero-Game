package com.example.apfinalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class HelloControllerFactory {

    public static HelloController createHelloController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            HelloController controller = fxmlLoader.getController();
            controller.setRoot(root);
            return controller;
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null;
        }
    }
}