package Game;

import Utilities.GDV5;
import Utilities.ImageSlicer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Main extends GDV5 implements Utilities.Main {

    static ImageSlicer is; //order club,diamond,heart,spade
    static BufferedImage back;
    public boolean keys[] = new boolean[11];
    Container game;


    public static void main(String args[]){
        Main m = new Main();
        m.start();
    }

    void updateKeys(){
        for (int i=0; i<10; i++){
            keys[i]=this.KeysPressed[48+i];
        }
        keys[10]=this.KeysPressed[KeyEvent.VK_A];
    }

    public Main(){

        game = new Container(this);

        back = this.addImage("Images/back_resize.jpg");
        is = new ImageSlicer(this.addImage("Images/cards.png"),13,4);
        for(int i=0; i<5; i++) {
            game.addPlayer(new Player(i));
        }

        game.giveCards(10);

        game.debugPrint();
    }

    @Override
    public void update() {
        updateKeys();
        game.update();
    }

    @Override
    public void draw(Graphics2D win) {
        game.draw(win);
    }
}
