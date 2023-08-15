package City;

import chip.CLCard;
import chip.Playerp;
import chip.Side;
import chipMiple.SuperMiple;
import entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
    ArrayList<Playerp> players;
    ArrayList<CityPart> sides;
    ArrayList<CityPart> openParts;
    ArrayList<SuperMiple> miples;

    ArrayList<Side> sidesWithMiple;
    final int pointOfOnePart=2;
    boolean open = true;
     int scor =0;
    public City(Side side,Playerp playerp){
       players.add(playerp);
       CityPart part = new CityPart(side.getConnections());
       sides.add(part);
       openParts.add(part);
       scor += pointOfOnePart;
       sidesWithMiple.add(side);
       part.sidesAddToCity(this);

    }

    public synchronized CityPart addOnePart(CityPart part, Side side1, Side side2){

        part.closeSide(side1);
        if(part.isAllSidesConnected()) openParts.remove(part);
        CityPart newpart = new CityPart(side2.getConnections());
        sides.add(newpart);
        openParts.add(newpart);
        newpart.closeSide(side2);
        if(newpart.isAllSidesConnected()) openParts.remove(newpart);
        scor +=1;
        return newpart;
    }

    public ArrayList<SuperMiple> getMiples() {
        return miples;
    }

    public int getScor() {
        return scor;
    }

    public City(City city1, Side side1, City city2, Side side2){


    }
    public City(ArrayList<CityPart> parts, ArrayList<CityPart> openPartss, ArrayList<Playerp> playerss){
        players.addAll(playerss);
        openParts.addAll(openPartss);
        this.sides.addAll(parts);

    }


    public ArrayList<Playerp> getNames(){
        return this.players;
    }
    public ArrayList<CityPart> getSides(){
        return this.sides;
    }
    public ArrayList<CityPart> getOpenParts(){
        return this.openParts;
    }




    public boolean isOpen(){
        return openParts.isEmpty();
    }






}
