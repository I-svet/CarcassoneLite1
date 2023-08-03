package City;

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
    public int scor =0;
    public City(Side side, Playerp player){
       players.add(player);
       CityPart part = new CityPart(side.connections,player);
       sides.add(part);
       openParts.add(part);
       scor += 1;
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
