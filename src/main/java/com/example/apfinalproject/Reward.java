package com.example.apfinalproject;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.Random;

public class Reward {
    private Rectangle reward;
    Pane pane;
    Block b1;
    Block b2;
    Hero hero;
    Reward(Pane pane,Block B1,Block BlockB2,Hero hero){
        this.b1=B1;
        this.b2=BlockB2;
        this.hero=hero;
        this.pane=pane;

        this.reward = new Rectangle(30,30);
        reward.setX(generateX());
        reward.setY(pane.getHeight()-202);
        Image heroImage = new Image(getClass().getResource("/images/Cherry.png").toExternalForm());
        reward.setFill(new ImagePattern(heroImage));
        pane.getChildren().add(this.reward);}

    private double generateX() {
        //generate the cheery between two pllars;
        int max= (int) (b2.GetX()-50);
        int min = (int) (b1.GetWidth()+40);
        Random rand = new Random();
        int i = rand.nextInt((max -min) + min) + min;
        return i;
    }

    public TranslateTransition moveBackward(double time){
        TranslateTransition tt = new TranslateTransition(Duration.seconds(time), reward);
        tt.setByX(-(reward.getX()+reward.getWidth()));
        tt.play();
        tt.setOnFinished(e->{
            pane.getChildren().remove(this.reward);
        });
        return tt;
    }
    public double GetX(){return reward.getX();}
   public boolean Herocollison(){
       //return reward.getBoundsInParent().intersects(hero.getBoundsInParent());
      // Shape intersection = Shape.intersect(hero.getHero(), reward);
       return reward.getBoundsInParent().intersects(hero.getBounds());
       // If the intersection is non-empty, there is a collision
      // return intersection.getBoundsInLocal().getWidth() != -1;
   }
}
