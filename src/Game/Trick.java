package Game;

import java.awt.*;
import java.util.ArrayList;

public class Trick {
    public ArrayList<Card> c = new ArrayList();
    final int cardOnLine=5;
    Container gameInstance;

    public Trick(Container game){
        this.gameInstance=game;
    }

    public void reset(){
        c.clear();
    }

    public int suitCheck(int start, int end, Card.Suit s, boolean blocking){
        if((c.get(0).s==s&&blocking)||!blocking) {
            for (int i = start; i > end; i--) {
                for (Card j : c) {

                    if (j.cardNum == i)
                        return j.playerID;

                }
            }
        }
        return -1;
    }

    public void draw(Graphics2D win){
        for(int i=0;i<c.size();i++){
            c.get(i).controlDraw(Main.CARD_WIDTH*(i%cardOnLine)+520,(i/cardOnLine)*Main.CARD_HEIGHT+40,win);
        }
    }

    public int findWinnner(){ //returns playerID of winner

        int temp = -1;

        //spades
        if(suitCheck(51,38, Card.Suit.spade,false)>-1)
            temp = suitCheck(51, 38, Card.Suit.spade, false);
        //end spades

        //hearts
        else if(suitCheck(38,25, Card.Suit.heart,true)>-1)
            temp = suitCheck(38,25, Card.Suit.heart,true);
        //end hearts

        //diamonds
        else if(suitCheck(25,12, Card.Suit.diamond,true)>-1)
            temp = suitCheck(25,12, Card.Suit.diamond,true);
        //end diamonds

        //clubs
        else if(suitCheck(12,-1, Card.Suit.club,true)>-1)
            temp = suitCheck(12,-1, Card.Suit.club,true);
        //end clubs

        gameInstance.turn=temp;

        return temp;

    }

}
