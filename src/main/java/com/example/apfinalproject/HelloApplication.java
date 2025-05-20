package com.example.apfinalproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        HelloController helloController = HelloControllerFactory.createHelloController();

        // Assuming that helloController has a method to get the root
        Parent root = helloController.getRoot();

        // Set up the stage and scene
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Your JavaFX Application");
        stage.setScene(scene);

        // Show the stage
        stage.show();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Scene scene1 = new Scene(root1);
                Platform.runLater(() -> {
                    stage.setScene(scene1);
                    stage.setTitle("STICK HERO'S");
                    stage.setResizable(false);
                    stage.show();
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

    public static void main(String[] args) {
        launch();
    }
}