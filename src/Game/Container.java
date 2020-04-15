package Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Container {
    int turn;
    int handNum=9;
    final int myID = 0;
    Random r = new Random();
    ArrayList<Player> p = new ArrayList<>();
    Trick t = new Trick();
    Main m;

    public void addPlayer(Player p){
        this.p.add(p);
    }

    int getCardsInHand(){
        return handNum%getMaxHands();
    }

    int getMaxHands(){
        return 52/p.size();
    }

    boolean isSecondTime(){
        return handNum>getMaxHands()-1;
    }

    void reset(){
        handNum=0;

        for (Player i:
             p) {
            i.c.clear();
        }

        t.reset();
    }

    boolean checkCard(int genNum){ //check if card has been dealt
        for (Player i:p) {
            for (Card j:i.c) {
                if(j.cardNum==genNum)
                    return false;
            }
        }
        return true;
    }

    int genCard(){
        int prospect=r.nextInt(52);
        if(!checkCard(prospect))
            return genCard();
        return prospect;
    }

    void giveCards(int num){
        for(int i=0;i<num;i++) {
            for (int j = 0; j < p.size(); j++) {
                p.get(j).c.add(new Card(genCard(), p.get(j).c.size(), j));
            }
        }
        for (Player i:p) {
            i.sortCards();
        }
    }

    boolean isMyTurn(){
        return turn==myID;
    }

    void nextHand(){
        t.reset();
        for (Player i:p) {
            i.hasBid=false;
        }
    }

    void nextTurn(){
        turn++; turn%=p.size();
    }

    public void drawScoreBoard(Graphics2D win){
        win.setColor(Color.WHITE);
        win.setFont(Main.mainFont);
        win.drawString("SCOREBOARD:",0,150);
        for (int i = 0; i<p.size(); i++) {
            if(i%2==1)
                win.setColor(Color.YELLOW);
            else
                win.setColor(Color.WHITE);

            if(p.get(i).hasBid)
                win.drawString(p.get(i).name+": "+"     Bid: "+ p.get(i).bid+"     Score: "+p.get(i).score,0, 190+30*i);

            else
                win.drawString(p.get(i).name+": "+"     Bid: HAS NOT BID" +"     Score: "+p.get(i).score,0, 190+30*i);
        }
    }

    public void drawHandNum(Graphics2D win){
        win.setColor(Color.WHITE);
        win.setFont(Main.mainFont);
        String temp = "";
        if(isSecondTime()){temp = " (2)";}
        win.drawString("Current Hand: " + (getCardsInHand()+1) + temp,575,590);
    }

    void draw(Graphics2D win){
        p.get(myID).drawCards(win);
        p.get(myID).draw(win);
        drawHandNum(win);
        drawScoreBoard(win);
    }
    
    void debugPrint(){
        for (int i=0; i<p.size(); i++) {
            System.out.print("\nPlayer "+i+": ");

            for (Card j: p.get(i).c) {
              System.out.print(" "+j.cardNum);
            }
        }
    }

    int keyControl(){
        for(int i=0;i<m.keys.length;i++){
            if(m.keys[i])
                return i;
        }
        return -1;
    }

    void update(){
        if(isMyTurn()){
            int temp=keyControl();

            if(temp>-1){
                //add a copy of the card selected by player to the current trick
                t.c.add(p.get(myID).c.get(temp).copy());

                //remove card from players hand
                p.get(myID).c.remove(temp);
            }

        }
    }

    }

