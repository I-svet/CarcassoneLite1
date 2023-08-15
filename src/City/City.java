package City;

import chip.CLCard;
import chip.Playerp;
import chip.Side;
import entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
    ArrayList<Playerp> players;
    ArrayList<CityPart> sides;
    ArrayList<CityPart> openParts;
    boolean open = true;
     int scor =0;
    public City(Side side,Playerp playerp){
      players.add(playerp);
       CityPart part = new CityPart(side.getConnections());
       sides.add(part);
       openParts.add(part);
       scor += 1;
    }

    public synchronized CityPart addOnePart(CityPart part, Side side1, Side side2){

        part.closeSide(side1);
        if(part.isAllSidesConnected()) openParts.remove(part);
        CityPart newpart = new CityPart(side2.getConnections());
        sides.add(newpart);
        openParts.add(newpart);
        newpart.closeSide(side2);
        if(newpart.isAllSidesConnected()) openParts.remove(part);
        scor +=1;
        return newpart;
    }
    public City(ArrayList<CityPart> parts,ArrayList<CityPart> openParts, ArrayList<Playerp> players){

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
