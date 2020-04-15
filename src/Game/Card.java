package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Card {

    int cardNum;
    int cardIndex;
    int playerID;
    static final int cardHeight=30;
    public static final int cardOffset=42;
    Suit s;

    public Card(int cardNum, int cardIndex, int playerID){
        this.cardNum=cardNum; this.cardIndex=cardIndex; this.playerID=playerID;
        this.s=this.getSuit();
    }

    Suit getSuit(){
        if(this.cardNum/13==0)
            return Suit.club;
        else if(this.cardNum/13==1)
            return Suit.diamond;
        else if(this.cardNum/13==2)
            return Suit.heart;

            return Suit.spade;
    }

    enum Suit{
    club, diamond, heart, spade;
    }

    public boolean equals(Card c){
        return c.cardNum==this.cardNum;
    }

    public Card copy(){
        return new Card(this.cardNum,this.cardIndex,this.playerID);
    }

    private int getVal(){
        return cardNum%13;
    }

    private int getSuitNum(){
        if(this.s==Suit.club)
            return 0;
        if(this.s==Suit.diamond)
            return 1;
        if(this.s==Suit.heart)
            return 2;
        if(this.s==Suit.spade)
            return 3;
        return -1;
    }

    public void draw(Graphics2D win){
        win.drawImage(Main.is.getSlice(this.getVal(),this.getSuitNum()),cardOffset*cardIndex, cardHeight,null);
    }

}
