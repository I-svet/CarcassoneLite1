package City;

import chip.Side;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public abstract class InfrastructurePart {
    ArrayList<Side> sides;
    ArrayList<Side> opensiddes;



    public ArrayList<Side> getOpensides() {
        return opensiddes;
    }

  /*  public  void sidesAddToInfrastructure(Infrastructure infrastructure);
    {
        for(Side side : sides ) {
            side.setInfrastructure(infrastructure);
            System.out.println("setCity"+ "to the"+ side);
        }
    }*/


    public abstract void sidesAddToInfrastructure(Infrastructure infrastructure);

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
