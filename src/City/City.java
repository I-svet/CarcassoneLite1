package City;

import chip.CLCard;
import chip.Playerp;
import chip.Side;
import chipMiple.SuperMiple;
import com.sun.net.httpserver.Authenticator;
import entity.Player;

import java.util.*;

public class City {

    ArrayList<CityPart> sides ;
    ArrayList<CityPart> openParts;

   private HashMap<Playerp,ArrayList<Side>> sidesWithMiples;


    private final int pointOfOnePart=2;
    boolean open = true;
     int scor =0;
    public City(Side side,Playerp playerp){

        ArrayList<Side> arrayOfOneSide = new ArrayList<>(List.of(side));
        sidesWithMiples = new HashMap<>();
        sidesWithMiples.put(playerp,arrayOfOneSide);

       CityPart part = new CityPart( side, side.getConnections());
       //side.setCityPart(part);//?????????????? TODO
       sides = new ArrayList<>(List.of(part));
       openParts= new ArrayList<>(List.of(part));
       scor += pointOfOnePart;

       part.sidesAddToCity(this);


    }
//synchronized
  /*  public synchronized  void addOnePart2(Side side1, Side side2){
        CityPart part1 = side1.getCityPart();
        part1.closeSide(side1);
        if(part1.isAllSidesConnected()) openParts.remove(part1);
        CityPart newpart;
        if(side2.getCityPart()==null){
             newpart = new CityPart(side2, side2.getConnections());
            sides.add(newpart);
            openParts.add(newpart);
        }
        else newpart=side2.getCityPart();


        newpart.closeSide(side2);
        if(newpart.isAllSidesConnected()) openParts.remove(newpart);
        scor +=pointOfOnePart;

    }*/

    public synchronized  void addOnePart(Side side1, Side side2){
        CityPart part1 = side1.getCityPart();
       // part1.closeSide(side1);
        if(part1.isAllSidesConnected()) openParts.remove(part1);

        CityPart newpart;
        if(side2.getCityPart()==null){
            newpart = new CityPart(side2, side2.getConnections());
            sides.add(newpart);
            openParts.add(newpart);
            newpart.sidesAddToCity(this);
            System.out.println("Successfull added" + newpart);
        }
        else newpart=side2.getCityPart();


        newpart.closeSide(side2);
        if(newpart.isAllSidesConnected()) openParts.remove(newpart);
        scor +=pointOfOnePart;
    }



    public int getScor() {
        return scor;
    }

    public HashMap<Playerp, ArrayList<Side>> getSidesWithMiples() {
        return sidesWithMiples;
    }

    public City(City city1, Side side1, City city2,  Side side2){
        CityPart part1= side1.getCityPart();
        part1.closeSide(side1);
        if(part1.isAllSidesConnected()) city1.getOpenParts().remove(part1);
        CityPart part2=side2.getCityPart();
        part2.closeSide(side2);
        if(part2.isAllSidesConnected()) city2.getOpenParts().remove(part1);
     sides.addAll(city1.getSides());
     sides.addAll(city2.getSides());
     openParts.addAll(city1.getOpenParts());
     openParts.addAll(city2.getOpenParts());
     sidesWithMiples.putAll(city1.getSidesWithMiples());
     for(Playerp playerInCity2 : city2.getSidesWithMiples().keySet()){
         if(!sidesWithMiples.containsKey(playerInCity2)){
             sidesWithMiples.put(playerInCity2,new ArrayList<>());
         }
         sidesWithMiples.get(playerInCity2).addAll(city2.getSidesWithMiples().get(playerInCity2));
     }



    }
    public City(ArrayList<CityPart> parts, ArrayList<CityPart> openPartss, ArrayList<Playerp> playerss){

        openParts.addAll(openPartss);
        this.sides.addAll(parts);

    }
    public synchronized void addParts( Side side) {
        Iterator<Side> iterator = side.getCityPart().getOpensides().iterator();

        while(iterator.hasNext()){
            Side siddde = iterator.next();
            //System.out.println("iteration  "+side.getCityPart()+" "+siddde);

            if(siddde.getOppositeSide()!= null) {

                this.addOnePart(siddde, siddde.getOppositeSide()); //
                // System.out.println("close " + siddde );
                iterator.remove();

                addParts( siddde.getOppositeSide());
            }
            else System.out.println(siddde.getOppositeSide() +" is null");
        }


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
