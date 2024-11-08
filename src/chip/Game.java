package chip;



import City.City;
import menu.InvalidPlayerTurnException;
import menu.InvalidSideEdgeSubmissionException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Game {
    private int currentPlayer;
    private String[] playerIds;

    private CLFieldPoint currentPoint;
    private CLDeck deck;

   // private HashSet<City> finishedCities;
   // private ArrayList<CLCard> stockPile;

 //  private CLCard.Type validType;
 //  private CLFieldPoint.Orientation ont;
 //  private Side.TypeEdge validEdA;
 //  private Side.TypeEdge validEdB;
 //  private Side.TypeEdge validEdC;
 //  private Side.TypeEdge validEdD;
 //  private Side.Connections validConA;
 //  private Side.Connections validConB;
 //  private Side.Connections validConC;
 //  private Side.Connections validConD;
 //  private Center validCenter;
 //  private Side validA;
 //  private Side validB;
 //  private Side validC;
 //  private Side validD;
 //  boolean gameDirection;
    public Playerp[] players;


    public Game(String[] pids) {
        deck = new CLDeck();
        deck.shuffle();
      //  finishedCities=new HashSet<>();
        playerIds = pids;
        currentPlayer = 0;
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellow");
        players = new Playerp[pids.length];

       for (int i = 0; i < pids.length; i++) {
                String namecolor = colors.get(i);
                players[i] = new Playerp(pids[i],namecolor);

            }

    }
   /* public void addToFinishedCities(City city){
        finishedCities.add(city);
    }
    public void isCityFinished(City city){
        return finishedCities.contains()
    }*/





  //  public void start(Game game) {
      /*  CLCard card = deck.drawCard();
        validType = card.getType();
        validEdA = card.A.getTypeEdge();
        validEdB = card.B.getTypeEdge();
        validEdC = card.C.getTypeEdge();
        validEdD = card.D.getTypeEdge();
        validConA = card.A.getConn();
        validConB = card.B.getConn();
        validConC = card.C.getConn();
        validConD = card.D.getConn();
        validCenter = card.getCenter();
        validA = card.getSideA();
        validB = card.getSideB();
        validC = card.getSideC();
        validD = card.getSideD();
        stockPile.add(card);*/
   // }

   /* public CLCard getTopCard() {
        return new CLCard(validA, validB, validC, validD, validCenter, validType);
    }

    public ImageIcon getTopCardImage() {
        return new ImageIcon(validType + ".png");
    }*/

    public boolean isGameOver() {
        if (deck.isEmpty())
            return true;
        else return false;
    }

    public String getCurrentPlayer() {
        return this.playerIds[this.currentPlayer];
    }
    public int getCurrentPlayerIndex() {
        return this.currentPlayer;
    }
    public void setCurrentPoint(CLFieldPoint point){
        this.currentPoint=point;
    }
    public boolean isItCurrentPoint(CLFieldPoint point){return this.currentPoint==point;}


    public String getPreviousPlayer() {
        int index=this.currentPlayer-1;
        if(index == -1){
            index = playerIds.length-1;
        }
        return this.playerIds[index];
    }
    public String changePlayer() {
        this.currentPlayer-=1;
        if( this.currentPlayer == -1){
            this.currentPlayer = playerIds.length-1;
        }
        return this.playerIds[ this.currentPlayer];
    }
    public String[] getPlayer(){
        return playerIds;
    }

    /*public ArrayList<SuperMiple> getPlayerHand(String pid){
        int index =Arrays.asList(playerIds).indexOf(pid);
        return playerHand.get(index);
    }*/
   /* public CLCard getPlayerCard(String pid,int choice){
        ArrayList<CLCard> hand =  getPlayerHand(pid);
        return hand.get(choice);
    }*/
   /* public boolean validCardPlay(CLCard card, int orientation,  int x,int y){
        return field.isPointOkey(x,y,card,orientation);
    }*/
    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException {
        if (this.playerIds[this.currentPlayer]!= pid){
            throw new InvalidPlayerTurnException("it is not"+pid+ "'s turn",pid);
        }
    }
   /* public Side.TypeEdge getLeftEdge(CLCard card, CLFieldPoint.Orientation ont){
        Side.TypeEdge t=null;
        switch(ont){
            case A -> t= card.getD().getTypeEdge();
            case B -> t= card.getA().getTypeEdge();
            case C -> t= card.getB().getTypeEdge();
            case D -> t= card.getC().getTypeEdge();
        }
        return t;
    }
    public Side.TypeEdge getRightEdge(CLCard card, CLFieldPoint.Orientation ont){
        Side.TypeEdge t=null;
        switch(ont){
            case A -> t= card.getB().getTypeEdge();
            case B -> t= card.getC().getTypeEdge();
            case C -> t= card.getD().getTypeEdge();
            case D -> t= card.getA().getTypeEdge();
        }
        return t;
    }
    public Side.TypeEdge getUpperEdge(CLCard card, CLFieldPoint.Orientation ont){
        Side.TypeEdge t=null;
        switch(ont){
            case A -> t= card.getA().getTypeEdge();
            case B -> t= card.getB().getTypeEdge();
            case C -> t= card.getC().getTypeEdge();
            case D -> t= card.getD().getTypeEdge();
        }
        return t;
    }
    public Side.TypeEdge getLowerEdge(CLCard card, CLFieldPoint.Orientation ont){
        Side.TypeEdge t=null;
        switch(ont){
            case A -> t= card.getC().getTypeEdge();
            case B -> t= card.getD().getTypeEdge();
            case C -> t= card.getA().getTypeEdge();
            case D -> t= card.getB().getTypeEdge();
        }
        return t;
    }*/
  /*  public void submitPlayerCard(String pid, CLCard card, int declaredx, int declaredy, CLFieldPoint.Orientation ont)
            throws InvalidPlayerTurnException, InvalidSideEdgeSubmissionException {
        checkPlayerTurn(pid);
      //  ArrayList<CLCard> pHand = getPlayerHand(pid);
        if(field.getCard(declaredx-1,declaredy) != null){
            if(getLeftEdge(card,ont)!=field.getRightEdge(declaredx-1,declaredy)){
                JLabel message = new JLabel("Invalid player move, expected Left edge:"+field.getRightEdge(declaredx-1,declaredy)+"but got Left edge:"+getLeftEdge(card,ont));
                message.setFont(new Font("Arial", Font.BOLD,48));
                JOptionPane.showMessageDialog(null,message);
                throw new InvalidSideEdgeSubmissionException("Invalid player move, expected Left edge:"+field.getRightEdge(declaredx-1,declaredy)+"but got Left edge:"+getLeftEdge(card,ont),getLeftEdge(card,ont),field.getRightEdge(declaredx-1,declaredy));
            }}
        if(field.getCard(declaredx+1,declaredy) != null){
            if(getRightEdge(card,ont)!=field.getLeftEdge(declaredx+1,declaredy)){
                JLabel message2 = new JLabel("Invalid player move, expected Right edge:"+field.getLeftEdge(declaredx+1,declaredy)+"but got Right edge:"+getRightEdge(card,ont));
                message2.setFont(new Font("Arial", Font.BOLD,48));
                JOptionPane.showMessageDialog(null,message2);
                throw new InvalidSideEdgeSubmissionException("Invalid player move, expected Right edge:"+field.getLeftEdge(declaredx+1,declaredy)+"but got Right edge:"+getRightEdge(card,ont),getRightEdge(card,ont),field.getLeftEdge(declaredx+1,declaredy));
            }}
        if(field.getCard(declaredx,declaredy+1) != null){
            if(getUpperEdge(card,ont)!=field.getLowerEdge(declaredx,declaredy+1)){
                JLabel message3 = new JLabel("Invalid player move, expected Upper edge:"+field.getLowerEdge(declaredx,declaredy+1)+"but got Upper edge:"+getUpperEdge(card,ont));
                message3.setFont(new Font("Arial", Font.BOLD,48));
                JOptionPane.showMessageDialog(null,message3);
                throw new InvalidSideEdgeSubmissionException("Invalid player move, expected Upper edge:"+field.getLowerEdge(declaredx,declaredy+1)+"but got Upper edge:"+getUpperEdge(card,ont),getUpperEdge(card,ont),field.getLowerEdge(declaredx,declaredy+1));
            }}
        if(field.getCard(declaredx,declaredy-1) != null){
            if(getLowerEdge(card,ont)!=field.getUpperEdge(declaredx,declaredy-1)){
                JLabel message4 = new JLabel("Invalid player move, expected Left edge:"+field.getUpperEdge(declaredx,declaredy-1)+"but got Lower edge:"+getLowerEdge(card,ont));
                message4.setFont(new Font("Arial", Font.BOLD,48));
                JOptionPane.showMessageDialog(null,message4);

                throw new InvalidSideEdgeSubmissionException("Invalid player move, expected Left edge:"+field.getUpperEdge(declaredx,declaredy-1)+"but got Lower edge:"+getLowerEdge(card,ont),getLowerEdge(card,ont),field.getUpperEdge(declaredx,declaredy-1));
            }}
       // pHand.remove(card);
        if(deck.isEmpty()){
            JLabel message4 = new JLabel("Game is over");
            message4.setFont(new Font("Arial", Font.BOLD,48));
            JOptionPane.showMessageDialog(null,message4);
            System.exit(0);
        }
        field.addCard(declaredx,declaredy,card,ont);
    }
    */

}

