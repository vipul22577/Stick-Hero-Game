package com.example.apfinalproject;

import java.util.ArrayList;

public class Gamemain {
    Player currentPlayer;
    ArrayList<Player> players;
    int maxScore;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }
    public boolean checkPlayer(Player player){
        for (Player value : players) {
            if (value == player)
                return true;
        }
        return false;

    }
    public void showStats(){

    }
    public void newGame(){

    }
    public void saveGame(){

    }


    private void setMaxScore(int maxScore){
        this.maxScore=maxScore;

    }
    public int getMaxScore(){
        return this.maxScore;
    }
    public void oadGame(){

}
}
