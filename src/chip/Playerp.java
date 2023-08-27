package chip;

import City.City;
import City.CityPart;
import chipMiple.SuperMiple;
import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Playerp {
    private ArrayList<City> cities ;
    private String name;
    private int score=0;

    private ArrayList<SuperMiple> hand;
    public Playerp(String nameIds, String namecolor ){
        this.name=nameIds;
        cities = new ArrayList<>();
        setHand(namecolor);

    }
    public void setHand(String namecolor){
        SuperMiple[] miple = new SuperMiple[8];
        for(int k=0;k<8;k++){
            miple[k]=new SuperMiple();

        }

        for (int j = 0; j < 8; j++) {
            miple[j].name =namecolor;
            try{
                miple[j].image = ImageIO.read(getClass().getResourceAsStream("/resPlayer/"+namecolor+".png"));

            }catch(IOException e){
                e.printStackTrace();;
            }

        }

         hand = new ArrayList<SuperMiple>(Arrays.asList(miple));
    }
    /*public void finishCity(City city){
        scor+=city.getScor();
        hand.addAll(city.getMiples());
        cities.remove(city);
    }*/
    public ArrayList<SuperMiple> getHand(){
        return this.hand;
    }


    public void addCity(City city){
        cities.add(city);
    }
    public void addPointsCity(int score){
        this.score+=score;

    }
    public void addMiple(ArrayList<SuperMiple> miples){
        hand.addAll(miples);
    }
    public void addMiple(SuperMiple miple){
        hand.add(miple);
    }
    public void removeCity(City city){
        cities.remove(city);
    }
    public int getScore()
    {
        return score;
    }




}
