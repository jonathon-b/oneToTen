package Utilities;

import Game.Container;

import java.awt.*;

public interface Main {

    public enum GameState{
        menu, pause, search, game;
    }

    Font mainFont = new Font ("Trebuchet MS",Font.BOLD,20);

    //card ranges for suit
    int[] club = {0,12};
    int[] diamond = {13,25};
    int[] heart = {26,38};
    int[] spade = {39,51};

}
