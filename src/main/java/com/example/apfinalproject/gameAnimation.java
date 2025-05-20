package com.example.apfinalproject;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class gameAnimation extends Application {
    private int score;
    private Text scoreText;
    private  int rewardscore;
    private int choicebg;
    private Text rewardText;
    private int highestSCore;
    private int lastScore;

    private Stage stage;
    private String audioPAth;
    private AtomicBoolean isAnimationInProgress = new AtomicBoolean(false);
    //    public gameAnimation(Player p){
//        rewardscore = p.totalReward;
//    }
    private gameAnimation(int themechoice,int reload ){
        this.choicebg=themechoice;

        this.stage=new Stage();
        setsc(reload);

    }

    // Step 2: Private static instance
    private static gameAnimation instance;

    // Step 3: Public static method to get the instance
    public static gameAnimation getInstance(int themechoice,int reload) {
        // If the instance is null, create a new one
        if (instance == null) {
            instance = new gameAnimation( themechoice,reload);
        }
        // Return the instance
        return instance;
    }
    public String getAudioPAth(){
        if(this.choicebg==1){
            String audioPath = "src/main/resources/Audio/splash.mp3";
            return  audioPath;
        }
        if(choicebg==2){
            String audioPath = "src/main/resources/Audio/horror.mp3";
            return  audioPath;
        }
        else{
            String audioPath = "src/main/resources/Audio/tip.mp3";
            return  audioPath;
        }
    }
    public void setsc(int relaod){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/example/apfinalproject/data.txt"));
            this.highestSCore= Integer.parseInt(reader.readLine());
            this.lastScore = Integer.parseInt(reader.readLine());
            this.rewardscore = Integer.parseInt(reader.readLine());
            if(relaod==1){
                this.score=this.lastScore;
            }
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage ) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 600);
        Image backgroundChoice= backgroundImage();

        BackgroundImage background = new BackgroundImage(backgroundChoice,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        pane.setBackground(new Background(background));

        primaryStage.setScene(scene);
        primaryStage.show();

        // Display score on the top
        scoreText = new Text("Score: 0");
        rewardText = new Text("Rewards: "+this.rewardscore);
        scoreText.setFont(new Font(20));
        rewardText.setFont(new Font(20));
        scoreText.setFill(Color.ORANGE);
        rewardText.setFill(Color.ORANGE);
        scoreText.setX(10);
        scoreText.setY(30);
        rewardText.setX(10);
        rewardText.setY(60);
        pane.getChildren().add(scoreText);
        pane.getChildren().add(rewardText);

        // Start the animation
        Hero hero = new Hero(pane);
        Block startBlock = new Block(pane);
        startBlock.setY();
        startBlock.SetX();

        GameLoop(hero, startBlock, pane, scene);
    }
    public Image backgroundImage(){
        int themeChoice = this.choicebg;
        Image backgroundAqua = new Image(getClass().getResource("/images/aqua.jpg").toExternalForm());
        Image backgrounddjungle = new Image(getClass().getResource("/images/jungle.jpg").toExternalForm());

        Image backgroundbhutiya = new Image(getClass().getResource("/images/bhutiya.jpg").toExternalForm());
        if(themeChoice==1){
            return backgroundAqua;
        } else if (themeChoice==2) {
            return backgroundbhutiya;
        } else {
            return backgrounddjungle;
        }
    }

    public void GameLoop(Hero hero, Block startBlock, Pane pane, Scene scene) {

        //String audioPath = "src/main/resources/Audio/horror.mp3";
        String audioPath = getAudioPAth();
        Media media1 = new Media(new File(audioPath).toURI().toString());
        AtomicInteger rewardFlag= new AtomicInteger(1);

        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);

        mediaPlayer1.play();

        AtomicReference<Double> length = new AtomicReference<>((double) 2);
        Block nextBlock = new Block(pane);
        Stick stick = new Stick(pane);
        Reward reward = GenerateReward(pane,startBlock,nextBlock,hero);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE && !isAnimationInProgress.get()) {
                stick.setHeight(10);
                length.updateAndGet(v -> v + 10);
            }else if (e.getCode() == KeyCode.UP && isAnimationInProgress.get()) {
                hero.flipUP();
            } else if (e.getCode() == KeyCode.DOWN && isAnimationInProgress.get()) {
                hero.flipDown();
            }
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.SPACE && !isAnimationInProgress.get()) {
                isAnimationInProgress.set(true);

                Transition rotate = stick.rotateStick();
                TranslateTransition heroMoveForwardtt = hero.move(length.get(), 3000);
                SequentialTransition sequentialTransition = new SequentialTransition(rotate, heroMoveForwardtt);
                sequentialTransition.play();

                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), ev -> {
                    if (reward != null && reward.Herocollison()&& rewardFlag.get() ==1) {
                        handleRewardCollision();
                        rewardFlag.set(0);
                    }
                }));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();

                sequentialTransition.setOnFinished(event -> {
                    timeline.stop();
                    if ((length.get() < getMinDistanceBetweenBlocks(pane, nextBlock) ||
                            length.get() > getMaxDistanceBetweenBlocks(pane, nextBlock))|| hero.getState()==0) {
                        Transition fallStick = stick.fall();
                        fallStick.play();
                        TranslateTransition heroFall = hero.moveDownward(200, 1000);
                        heroFall.play();
                        String audioFilePath = "src/main/resources/Audio/endgame.mp3";
                        new Thread(() -> {
                            Media media = new Media(new File(audioFilePath).toURI().toString());
                            MediaPlayer mediaPlayer = new MediaPlayer(media);
                            mediaPlayer.play();
                        }).start();

                        heroFall.setOnFinished(fallEvent -> {
                            isAnimationInProgress.set(false);
                            //the labels and return
                            try {
                                setLabels();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            //return back to theme Selection screen
                            return;

                        });
                    } else {
                        TranslateTransition startBlockFinish = startBlock.finishBlock(1);
                        TranslateTransition NextBlockbackTT = nextBlock.moveBackward(1);
                        TranslateTransition stickBackTT = stick.moveBackward(1);
                        TranslateTransition heroBackTT = hero.move(-(length.get()), 1000);
                        if(reward != null){
                            TranslateTransition rewardBackTT = reward.moveBackward(1);
                            rewardBackTT.play();}

                        ParallelTransition parallelTransition = new ParallelTransition(
                                startBlockFinish, NextBlockbackTT, stickBackTT, heroBackTT);
                        parallelTransition.play();
                        parallelTransition.setOnFinished(gamestart -> {
                            addScore();
                            isAnimationInProgress.set(false);
                            GameLoop(hero, nextBlock, pane, scene);
                        });
                    }
                });
            }
        });
    }
    public int getScore(){
        return this.score;
    }


    public void setLabels() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/example/apfinalproject/data.txt"));
        if (this.score > this.highestSCore) {
            writer.write(Integer.toString(this.score));  // Update the highest score.
        } else {
            writer.write(Integer.toString(this.highestSCore));  // Keep the highest score.
        }
        writer.newLine();
        writer.write(Integer.toString(this.score));  // Update the last score.
        writer.newLine();
        writer.write(Integer.toString(this.rewardscore));  // Update the reward score.
        writer.close();

        Stage currentStage = (Stage) scoreText.getScene().getWindow();
        currentStage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("themeView.fxml"));
        Parent root = loader.load();

        // Set the new scene in the stage
        Scene newScene = new Scene(root);
        enterGameController controller = loader.getController();
        controller.setScore();

        stage.setScene(newScene);
        stage.show();
    }

    public void addScore() {
        this.score += 1;
        scoreText.setText("Score: " + this.score);
    }
    public Reward GenerateReward(Pane pane,Block b1, Block b2,Hero hero){
        Random rand = new Random();
        int i = rand.nextInt((3-1) + 1) + 1;
        if(i==1){
            System.out.println("success");
            return new Reward(pane,b1,b2,hero);
        }
        return null;
    }
    private void handleRewardCollision() {
        rewardText.setText("Rewards: " + ++rewardscore);
    }

    public double getMinDistanceBetweenBlocks(Pane pane, Block b) {
        return b.GetX();
    }

    public double getMaxDistanceBetweenBlocks(Pane pane, Block b) {
        return (b.GetX() + b.GetWidth());
    }


}