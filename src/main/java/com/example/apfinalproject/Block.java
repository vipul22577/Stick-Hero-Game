package com.example.apfinalproject;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class Block {
    private Rectangle rect;
    private Pane pane;

    Block(Pane pane){
        this.rect = new Rectangle(GenerateWidth(), 200);
        rect.setFill(Color.BLACK);
        rect.setY(pane.getHeight() - rect.getHeight());
        rect.setX(pane.getWidth()-rect.getWidth()-GenerateX());
        this.pane=pane;
        pane.getChildren().add(rect);
    }
    private int GenerateWidth(){
        Random rand = new Random();
        int i = rand.nextInt((60 - 23) + 23) + 23;
        System.out.println("\n" + i);

        return  i;
    }
    public double GetX(){return rect.getX();}
    private int GenerateX(){
        Random rand = new Random();
        int i = rand.nextInt((200 -100) + 100) + 100;
        return  i;
    }
    public TranslateTransition moveBackward(double time){
        TranslateTransition tt = new TranslateTransition(Duration.seconds(time), rect);
        tt.setByX(-(rect.getX()));
        //tt.play();
        return tt;
    }
    public double GetWidth(){
        return rect.getWidth();
    }
    public TranslateTransition finishBlock(double time){
        TranslateTransition tt = new TranslateTransition(Duration.seconds(time), rect);
        tt.setByX(-rect.getWidth());
        tt.play();
        tt.setOnFinished(e->{
            this.pane.getChildren().remove(this.rect);
        });
        return tt;
    }
    public void SetX(){
        rect.setX(0);
    }
    public void setY(){
        rect.setY(pane.getHeight() - rect.getHeight());
    }
}
