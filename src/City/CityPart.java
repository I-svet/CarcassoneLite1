package City;

import chip.Playerp;
import chip.Side;
import entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

public class CityPart {
ArrayList<Side> sides;
ArrayList<Side> opensiddes;
Set<Side> set =  new ConcurrentSkipListSet<>();
Queue<Side> list = new ConcurrentLinkedQueue<>();

    public ArrayList<Side> getOpensides() {
        return opensiddes;
    }
    public CityPart(Side side,ArrayList<Side> sides)
    {
        //side.setCityPart(this); // TODO why i cannot delete this

        this.sides = side.getConnections();
        for(Side sidde: sides){
             sidde.setCityPart(this);
            // System.out.println("setCityPart " +this+ " to the "+ sidde);
         }
         if(sides.isEmpty()) System.out.println("shit sides is empty");
         opensiddes = new ArrayList<>(sides);
    }
    public void sidesAddToCity(City city){
        for(Side side : sides ) {
        side.setCity(city);
          //  System.out.println("setCity"+ "to the"+ side);
        }
    }


    public ArrayList<Side> getSides() {
        return sides;
    }
    public void closeSide(Side side){
        opensiddes.remove(side);
      //  System.out.println("Close" +side);
        side.connect();
    }
    public boolean isAllSidesConnected(){
        return opensiddes.isEmpty();
    }

}
