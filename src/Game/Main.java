package Game;

import Utilities.GDV5;
import Utilities.ImageSlicer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main extends GDV5 implements Utilities.Main {

    static ImageSlicer is; //order club,diamond,heart,spade
    static BufferedImage back;
    public boolean keys[] = new boolean[10];

    public static void main(String args[]){
        Main m = new Main();
        m.start();
    }

    public Main(){
        for (int i=0; i<keys.length; i++){
            keys[i]=this.KeysPressed[48+i];
        }

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

    }

    @Override
    public void draw(Graphics2D win) {
        game.draw(win);
    }
}
