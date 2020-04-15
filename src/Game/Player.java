package Game;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> c = new ArrayList<>();
    boolean hasBid=false;
    int bid=0;
    int score=0;

    public Player(){
        this.name="test";
    }

    public Player(int index){
        this.name = "Player " + (index+1);
    }

    public Player(String name){
        this.name=name;
    }

    public void drawCards(Graphics2D win){
        for (Card i:c) {
            i.draw(win);
        }
    }

    int sortCardBySuit(int index, int[] range, ArrayList<Card> temp){ //returns new index
        for(int i=range[0];i<range[1];i++){
            for (Card j:c) {
                if (j.cardNum == i) {
                    temp.add(new Card(j.cardNum, index, j.playerID));
                    index++;
                }
            }

        }
        return index;
    }

    void sortCards(){
        int index=0;
        ArrayList<Card> temp = new ArrayList<>();
        index=sortCardBySuit(index, Main.diamond, temp);
        index=sortCardBySuit(index, Main.club, temp);
        index=sortCardBySuit(index, Main.heart, temp);
        sortCardBySuit(index, Main.spade,temp);

        c=temp;

    }

    void draw(Graphics2D win){
        win.setFont(Main.mainFont);
        win.setColor(Color.WHITE);
        win.drawString("YOUR HAND",0,20);
        win.drawString("CURRENT TRICK",550,20);
        for(int i=0;i<c.size();i++) {
            win.drawString(""+i,i*Card.cardOffset+15,110);
        }
    }

}
