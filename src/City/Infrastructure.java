package City;

import chip.Playerp;
import chip.Side;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class Infrastructure {


        ArrayList<InfrastructurePart> sides ;
        ArrayList<InfrastructurePart> openParts;

        HashMap<Playerp,ArrayList<Side>> sidesWithMiples;


        int pointOfOnePart;

         int score =0;



        public  abstract void addOnePart(Side side1, Side side2);





        public int getScor() {
            return score;
        }

        public HashMap<Playerp, ArrayList<Side>> getSidesWithMiples() {
            return sidesWithMiples;
        }



        public abstract void addParts( Side side);



        public ArrayList<InfrastructurePart> getSides(){
            return this.sides;
        }
        public ArrayList<InfrastructurePart> getOpenParts(){
            return this.openParts;
        }






    public  abstract boolean isFinished();
     public abstract void finishInfrastructure() ;

}
