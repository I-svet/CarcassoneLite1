package chip;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class CLDeck {
    private CLCard[] cards;
    private int cardsInDeck;
    public CLDeck()
    {
        cards = new CLCard[72];
    }
    public void reset()
    {
        cardsInDeck=0;
/*
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road5();
        cards[cardsInDeck++]= new CLCard().Road5();
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road3();
        cards[cardsInDeck++]= new CLCard().Road4();
        cards[cardsInDeck++]= new CLCard().RoadCity3();
        cards[cardsInDeck++]= new CLCard().RoadCity1();
        cards[cardsInDeck++]= new CLCard().RoadCity2();
        cards[cardsInDeck++]= new CLCard().RoadCity4();
        cards[cardsInDeck++]= new CLCard().Road1();
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road5();
        cards[cardsInDeck++]= new CLCard().Road5();
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road3();
        cards[cardsInDeck++]= new CLCard().Road4();
        cards[cardsInDeck++]= new CLCard().RoadCity3();
        cards[cardsInDeck++]= new CLCard().RoadCity1();
        cards[cardsInDeck++]= new CLCard().RoadCity2();
        cards[cardsInDeck++]= new CLCard().RoadCity4();
        cards[cardsInDeck++]= new CLCard().Road1()*/












        cards[cardsInDeck++]= new CLCard().Monastery();
        cards[cardsInDeck++]= new CLCard().Monastery();
        cards[cardsInDeck++]= new CLCard().Monastery();
        cards[cardsInDeck++]= new CLCard().Monastery();
        cards[cardsInDeck++]= new CLCard().Monastery();
        cards[cardsInDeck++]= new CLCard().Monastery();
        cards[cardsInDeck++]= new CLCard().city3();
        cards[cardsInDeck++]= new CLCard().city3();

        cards[cardsInDeck++]= new CLCard().city1();
        cards[cardsInDeck++]= new CLCard().city1();

        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().city5();

        cards[cardsInDeck++]= new CLCard().RoadCity3();
        cards[cardsInDeck++]= new CLCard().RoadCity3();
        cards[cardsInDeck++]= new CLCard().city3();
        cards[cardsInDeck++]= new CLCard().city3();
        cards[cardsInDeck++]= new CLCard().RoadCity3();
        cards[cardsInDeck++]= new CLCard().RoadCity3();


        cards[cardsInDeck++]= new CLCard().city3();
        cards[cardsInDeck++]= new CLCard().city4();
        cards[cardsInDeck++]= new CLCard().city4();
        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().city5();

        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().CityCornerCHF();
        cards[cardsInDeck++]= new CLCard().CityCornerCHF();
        cards[cardsInDeck++]= new CLCard().city5();
        cards[cardsInDeck++]= new CLCard().city3();
        cards[cardsInDeck++]= new CLCard().city1();
        cards[cardsInDeck++]= new CLCard().city2();
        cards[cardsInDeck++]= new CLCard().city1();
        cards[cardsInDeck++]= new CLCard().city2();
        cards[cardsInDeck++]= new CLCard().Monastery();
        cards[cardsInDeck++]= new CLCard().Monastery();
        /*
        cards[cardsInDeck++]= new CLCard().Road1();
        cards[cardsInDeck++]= new CLCard().Road1();
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road2();
        cards[cardsInDeck++]= new CLCard().Road3();
        cards[cardsInDeck++]= new CLCard().Road3();
        cards[cardsInDeck++]= new CLCard().Road4();
        cards[cardsInDeck++]= new CLCard().Road4();
        cards[cardsInDeck++]= new CLCard().Road5();
        cards[cardsInDeck++]= new CLCard().Road5();
        cards[cardsInDeck++]= new CLCard().RoadCity1();
        cards[cardsInDeck++]= new CLCard().RoadCity1();
        cards[cardsInDeck++]= new CLCard().RoadCity2();
        cards[cardsInDeck++]= new CLCard().RoadCity2();
        cards[cardsInDeck++]= new CLCard().RoadCity3();
        cards[cardsInDeck++]= new CLCard().RoadCity3();
        cards[cardsInDeck++]= new CLCard().RoadCity4();
        cards[cardsInDeck++]= new CLCard().RoadCity4();

 */




    }
    public void replaceDeckWith(ArrayList<CLCard> cards){
        this.cards = cards.toArray(new CLCard[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }
    public boolean isEmpty(){
        return cardsInDeck ==0;
    }
    public void shuffle(){
        //int n = cards.length;
        int n = cardsInDeck;
        Random random = new Random();
        for(int i=0; i< cardsInDeck;i++){
            int randomValue = i + random.nextInt(n-i);
            CLCard randomCard = cards[randomValue];
            cards[randomValue]= cards[i];
            cards[i]=randomCard;
        }
    }

    public CLCard drawCard() throws IllegalArgumentException {
        if(isEmpty()) {
            throw new IllegalArgumentException("Can not draw a card since there no card in a deck");
        }
        return cards[--cardsInDeck];
    }
    public void drawCLCard(){
        if(cardsInDeck>0)
        if(isEmpty()) {
            throw new IllegalArgumentException("Can not draw a card since there no card in a deck");
        }
        else
        cardsInDeck--;
    }

    /*
    public ImageIcon drawCardImage() throws IllegalArgumentException {
        if(isEmpty()) {
            throw new IllegalArgumentException("Can not draw a card since there no card in a deck");
        }
        return new ImageIcon(cards[--cardsInDeck].type+".png");
    }
    public CLCard[] drawCard(int n){
        if(n<0){
            throw new IllegalArgumentException("shit, cards must be positive");
        }
        if(n>cardsInDeck){
            throw new IllegalArgumentException("shit, there only "+ cardsInDeck+"cards");
        }
        CLCard[] ret = new CLCard[n];
        for(int i =0;i<n; i++){
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }*/

}
