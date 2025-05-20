package com.example.apfinalproject;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;

public class Stick implements Serializable {
    Line stick;
    Pane pane;
    Stick(Pane pane){
        this.stick = new Line(0,398,0,pane.getHeight()-200);
        stick.setStroke(Color.RED);
        stick.setStrokeWidth(5);
        this.pane=pane;
        pane.getChildren().add(stick);

    }
    public Transition rotateStick() {
        Transition rotate = new Transition() {
            {
                setCycleDuration(Duration.millis(1000));
            }

            @Override
            protected void interpolate(double frac) {
                double angle = frac * 90.0;
                Rotate rotation = new Rotate(angle, stick.getEndX(), stick.getEndY());
                stick.getTransforms().setAll(rotation);
            }
        };


        return rotate;
    }
    public Transition fall() {
        Transition rotate = new Transition() {
            {
                setCycleDuration(Duration.millis(1000));
            }

            @Override
            protected void interpolate(double frac) {
                double angle =  90+frac * 90.0;
                Rotate rotation = new Rotate(angle, stick.getEndX(), stick.getEndY());
                stick.getTransforms().setAll(rotation);
            }
        };


        return rotate;
    }
    public TranslateTransition moveBackward(double time){
        TranslateTransition translate = new TranslateTransition(Duration.seconds(time), stick);
        translate.setByX(-(this.stick.getEndY()-stick.getStartY()));
        translate.play();
        translate.setOnFinished(e->{
            pane.getChildren().remove(stick);
        });
        return translate;
    }
    public void setHeight(double val){
        this.stick.setStartY(stick.getStartY()-val);
    }

}
