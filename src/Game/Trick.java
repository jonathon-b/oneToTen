package Game;

import java.util.ArrayList;

public class Trick {
    public ArrayList<Card> c = new ArrayList();

    public void reset(){
        c.clear();
    }

    public int suitCheck(int start, int end, Card.Suit s, boolean blocking){
        if(c.get(0).s==s&&blocking) {
            for (int i = start; i > end; i--) {
                for (Card j : c) {

                    if (j.cardNum == i)
                        return j.playerID;

                }
            }
        }
        return -1;
    }

    public int findWinnner(){ //returns playerID of winner

        //spades
        if(suitCheck(51,38, Card.Suit.spade,false)>-1)
            return suitCheck(51,38, Card.Suit.spade,false);
        //end spades

        //hearts
        if(suitCheck(38,25, Card.Suit.heart,true)>-1)
            return suitCheck(38,25, Card.Suit.heart,true);
        //end hearts

        //diamonds
        if(suitCheck(25,12, Card.Suit.heart,true)>-1)
            return suitCheck(25,12, Card.Suit.heart,true);
        //end diamonds

        //clubs
        if(suitCheck(12,-1, Card.Suit.heart,true)>-1)
            return suitCheck(12,-1, Card.Suit.heart,true);
        //end clubs

        return -1;
    }

}
