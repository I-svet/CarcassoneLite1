package City;

import chip.Playerp;
import chip.Side;
import entity.Player;

import java.util.ArrayList;

public class CityPart {
ArrayList<Side> sides;
ArrayList<Side> opensides;

    public ArrayList<Side> getOpensides() {
        return opensides;
    }
//ArrayList<Playerp> players;

    public CityPart(ArrayList<Side> sides)
    {
         this.sides = sides;
    }

    public ArrayList<Side> getSides() {
        return sides;
    }
    public void closeSide(Side side){
        opensides.remove(side);
        side.connect();
    }


   /* public boolean isAllSidesConnected(){
        boolean t = true;
        for(Side side : sides ){
          t = side.isConnected();
          if(!t) break;
        }
        return t;
}*/
    public boolean isAllSidesConnected(){
        return opensides.isEmpty();
    }

}
