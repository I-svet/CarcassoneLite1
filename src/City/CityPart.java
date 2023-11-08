package City;

import chip.CLFieldPoint;
import chip.Side;

import java.util.ArrayList;

public class CityPart extends InfrastructurePart {
//ArrayList<Side> sides;
//ArrayList<Side> opensiddes;
//Set<Side> set =  new ConcurrentSkipListSet<>();
//Queue<Side> list = new ConcurrentLinkedQueue<>();

    public ArrayList<Side> getOpensides() {
        return opensiddes;
    }
    public CityPart(Side side,ArrayList<Side> sides)
    {
        //side.setCityPart(this); // TODO why i cannot delete this

        this.sides = side.getConnections();
        opensiddes = new ArrayList<>(this.sides);
        for(Side sidde: sides){
             sidde.setInfrastructurePart(this);
             System.out.println("setCityPart " +this+ " to the "+ sidde);
         }

         if(sides.isEmpty()) System.out.println("shit sides is empty");

    }
    @Override
    public void sidesAddToInfrastructure(Infrastructure infrastructure){
        for(Side side : sides ) {
        side.setInfrastructure(infrastructure);
            System.out.println("setCity"+ "to the"+ side);
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
