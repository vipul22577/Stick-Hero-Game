package com.example.apfinalproject;

public class Player extends Gamemain {
    String name;
    String password;
    int levelUnlocked;
    int totalReward;
    int position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getPosition(){
        return this.position;
    }
    public void setPosition(int x){this.position=x;};
    public void moveForward(){
        this.position++;
    }
    public void moveBackward(){this.position+=-1;}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevelUnlocked() {
        return this.levelUnlocked ;
    }

    public void setLevelUnlocked(int levelunclocked) {
        this.levelUnlocked = levelunclocked;
    }

    public int getTotalReward() {
        return totalReward;
    }

    public void setTotalReward(int totalReward) {
        this.totalReward = totalReward;
    }


    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.totalReward=0;
        this.levelUnlocked=1;

        this.position=0;
    }
    public void pauseGame(){

    }
    public void saveGame(){

    }
    public void restartGame(){

    }
}
