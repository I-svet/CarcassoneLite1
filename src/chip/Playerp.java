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
    public ArrayList<City> cities;
    public String name;
    public int scor=0;
    ArrayList<SuperMiple> hand;
    public Playerp(String nameIds, String namecolor ){
        this.name=nameIds;
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
    public void finishCity(City city){
        scor+=city.getScor();
        hand.addAll(city.getMiples());
        cities.remove(city);
    }
    public ArrayList<SuperMiple> getHand(){
        return this.hand;
    }
    public void newcity(City city){
        cities.add(city);
    }
    public void connectCities(City city1,City city2){
        ArrayList<CityPart> parts = new ArrayList<>(city1.getSides());
        ArrayList<CityPart> openParts = new ArrayList<>(city1.getOpenParts());
        ArrayList<Playerp> players = new ArrayList<>(city1.getNames());
        parts.addAll(city2.getSides());
        openParts.addAll(city2.getOpenParts());
        players.addAll(city2.getNames());
        City city = new City(parts,openParts,players);

    }
    public void addCity(City city){
        cities.add(city);
    }
    public void addPointsCity(){
        // TODO add function

    }



}
