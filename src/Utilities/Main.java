package Utilities;

import Game.Container;

import java.awt.*;

public interface Main {

    public enum GameState{
        menu, pause, search, game;
    }

    Font mainFont = new Font ("Trebuchet MS",Font.BOLD,20);

    final int CARD_WIDTH = 43;
    final int CARD_HEIGHT = 63;

    //card ranges for suit
    int[] club = {-1,13};
    int[] diamond = {13,26};
    int[] heart = {26,39};
    int[] spade = {39,52};

}
