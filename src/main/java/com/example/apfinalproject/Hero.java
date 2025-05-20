package com.example.apfinalproject;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Hero {
    private Rectangle hero;
    Pane pane;
    private int state;
    Hero(Pane pane){
        this.hero = new Rectangle(30,30);
        hero.setX(0);
        hero.setY(370);
        this.state=1;
        Image heroImage = new Image(getClass().getResource("/images/hero.png").toExternalForm());
        hero.setFill(new ImagePattern(heroImage));


        pane.getChildren().add(this.hero);
        // Load the image
       //Image image = new Image("hero.png");
//       // Create an ImagePattern and set it as the fill for the rectangle
        //ImagePattern imagePattern = new ImagePattern(image);

    }

    public TranslateTransition  move(double length, int time){
        // Create a TranslateTransition to move the hero forward

        TranslateTransition transition = new TranslateTransition(Duration.millis(time), hero);
        transition.setByX(length);
        return transition;
    }

    public TranslateTransition  moveDownward(double deep, int time){
        // Create a TranslateTransition to move the hero forward
        TranslateTransition transition = new TranslateTransition(Duration.millis(time), hero);
        transition.setByY(deep);
        return transition;

    }
    public void flipDown(){
        if (state==1){
        RotateTransition transition = new RotateTransition(Duration.millis(200), hero);
        //also move it down;
        TranslateTransition tt = new TranslateTransition(Duration.millis(20), hero);
        tt.setByY(hero.getHeight());
        tt.play();
        // Set the pivot point to the bottom edge of the hero
        hero.setRotationAxis(Rotate.X_AXIS);
        transition.setByAngle(180); // Rotate by 180 degrees for a complete flip
        transition.play();
        state=0;}

    }
    public void flipUP(){
        if(state==0){
        RotateTransition transition = new RotateTransition(Duration.millis(200), hero);
        TranslateTransition tt = new TranslateTransition(Duration.millis(20), hero);
        tt.setByY(-hero.getHeight());
        tt.play();
        // Set the pivot point to the bottom edge of the hero
        hero.setRotationAxis(Rotate.X_AXIS);
        transition.setByAngle(180); // Rotate by 180 degrees for a complete flip

        transition.play();
        state=1;}

    }
    public Bounds getBounds(){
        return this.hero.getBoundsInParent();
    }
    public int getState(){return this.state;}
    public Rectangle getHero(){return this.hero;}

}
