package com.example.apfinalproject;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class Junit {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player("John", "password123");

        assertEquals("John", player.getName());
        assertEquals("password123", player.getPassword());
        assertEquals(0, player.getPosition());
        assertEquals(0, player.getTotalReward());
        assertEquals(1, player.getLevelUnlocked());
    }

    @Test
    public void testMoveForward() {
        Player player = new Player("Alice", "securePass");

        player.moveForward();
        assertEquals(1, player.getPosition());

        player.moveForward();
        assertEquals(2, player.getPosition());
    }

    @Test
    public void testMoveBackward() {
        Player player = new Player("Bob", "strongPassword");

        player.moveBackward();
        assertEquals(-1, player.getPosition());

        player.moveBackward();
        assertEquals(-2, player.getPosition());
    }

    @Test
    public void testSetPosition() {
        Player player = new Player("Eve", "secret123");

        player.setPosition(5);
        assertEquals(5, player.getPosition());

        player.setPosition(-3);
        assertEquals(-3, player.getPosition());
    }

    @Test
    public void testSetLevelUnlocked() {
        Player player = new Player("Charlie", "topSecret");

        player.setLevelUnlocked(3);
        assertEquals(3, player.getLevelUnlocked());

        player.setLevelUnlocked(0);
        assertEquals(0, player.getLevelUnlocked());
    }

    @Test
    public void testSetTotalReward() {
        Player player = new Player("Mallory", "superSecret");

        player.setTotalReward(100);
        assertEquals(100, player.getTotalReward());

        player.setTotalReward(-50);
        assertEquals(-50, player.getTotalReward());
    }

    @org.junit.Test
    public void testRotateStick() {


        Pane pane = new Pane();
        Stick stick = new Stick(pane);
        Transition rotate = stick.rotateStick();

        assertEquals(Duration.millis(1000), rotate.getCycleDuration());

        // You can add more assertions based on your specific requirements
    }

    @org.junit.Test
    public void testFall() {
        // Initialize JavaFX

        Pane pane = new Pane();
        Stick stick = new Stick(pane);
        Transition fall = stick.fall();

        assertEquals(Duration.millis(1000), fall.getCycleDuration());

        // You can add more assertions based on your specific requirements
    }

    private Line getLineFromStick(Stick stick) {
        return stick.stick;
    }

}

