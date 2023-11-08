package City;

import chip.CLCard;
import chip.Playerp;
import chip.Side;
import chipMiple.SuperMiple;
import com.sun.net.httpserver.Authenticator;
import entity.Player;

import java.util.*;

public class City extends  Infrastructure {

   // ArrayList<InfrastructurePart> sides ;
  //  ArrayList<InfrastructurePart> openParts;

  // private HashMap<Playerp,ArrayList<Side>> sidesWithMiples;
   // private int score =0;
    public City(Side side,Playerp playerp){

        pointOfOnePart=2;

        ArrayList<Side> arrayOfOneSide = new ArrayList<>(List.of(side));
        sidesWithMiples = new HashMap<>();
        sidesWithMiples.put(playerp,arrayOfOneSide);

        InfrastructurePart part = new CityPart( side, side.getConnections());
       //side.setCityPart(part);//?????????????? TODO
       sides = new ArrayList<>(List.of(part));
       openParts= new ArrayList<>(List.of(part));

       part.sidesAddToInfrastructure(this);
        score += pointOfOnePart;
        side.getFieldPoint().addInfrastructure(side.getInfrastructure());

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
@Override

    public synchronized  void addOnePart(Side side1, Side side2){
    InfrastructurePart part1 = side1.getInfrastructurePart();
       // part1.closeSide(side1);
        side1.connect();
        if(part1.isAllSidesConnected()) openParts.remove(part1);

    InfrastructurePart newpart;
        if(side2.getInfrastructurePart()==null){
            newpart = new CityPart(side2, side2.getConnections());
            sides.add(newpart);
            openParts.add(newpart);
            newpart.sidesAddToInfrastructure(this);
            System.out.println("Successfull added" + newpart+"with sides"+side2.getConnections());

            if(!side2.getFieldPoint().getInfrastructure().contains(this)) {
                score +=pointOfOnePart;
                side2.getFieldPoint().addInfrastructure(side2.getInfrastructure());
            }
        }
        else newpart=side2.getInfrastructurePart();


        newpart.closeSide(side2);
        System.out.println("close " + side2 );


        if(newpart.isAllSidesConnected()) openParts.remove(newpart);



        if(this.isFinished()&& !this.getSidesWithMiples().isEmpty()){
            this.finishInfrastructure();
        }
    }



    public int getScor() {
        return score;
    }

    public HashMap<Playerp, ArrayList<Side>> getSidesWithMiples() {
        return sidesWithMiples;
    }

    public void connectInfrastructure( Side side1, Infrastructure city2,  Side side2){
        InfrastructurePart part1= side1.getInfrastructurePart();
        part1.closeSide(side1);
        System.out.println("close " + side1 +"of the part"+ part1);

        if(part1.isAllSidesConnected()) this.getOpenParts().remove(part1);

        InfrastructurePart part2=side2.getInfrastructurePart();
        part2.closeSide(side2);
        System.out.println("close " + side2 +"of the part"+ part2);

        if(part2.isAllSidesConnected()) city2.getOpenParts().remove(part2);
/*
        for(Side side : side1.getConnections()){
            if (side.getOppositeSide()!=null && !side.isConnected()){
                part1.closeSide(side1);
                System.out.println("Why"+side+"has opposite but not connected");
                if(part1.isAllSidesConnected()) this.getOpenParts().remove(part1);
                side.getOppositeSide().getInfrastructurePart().closeSide(side.getOppositeSide());
                if( side.getOppositeSide().getInfrastructurePart().isAllSidesConnected()){
                    side.getOppositeSide().getInfrastructure().getOpenParts().remove(part1);
                }
            }
        } */// TODO why has i made this


        sides.addAll(city2.getSides());
        openParts.addAll(city2.getOpenParts());
        System.out.println(openParts);






    for(Playerp playerInCity2 : city2.getSidesWithMiples().keySet()){
        if(!sidesWithMiples.containsKey(playerInCity2)){
            sidesWithMiples.put(playerInCity2,new ArrayList<>());
            playerInCity2.removeInfrastructure(city2);
            playerInCity2.addInfrastructure(this);
        }
         sidesWithMiples.get(playerInCity2).addAll(city2.getSidesWithMiples().get(playerInCity2));
    }
    score+=city2.getScor();
    for(InfrastructurePart part: city2.getSides()){
        part.sidesAddToInfrastructure(this);
        part.getSides().get(0).getFieldPoint().removeInfrastructure(city2);
        part.getSides().get(0).getFieldPoint().addInfrastructure(this);
    }
    if(this.isFinished()&& !this.getSidesWithMiples().isEmpty()){
            this.finishInfrastructure();
    }
    }
    public City(ArrayList<InfrastructurePart> parts, ArrayList<InfrastructurePart> openPartss, ArrayList<Playerp> playerss){

        openParts.addAll(openPartss);
        this.sides.addAll(parts);

    }
    @Override
    public synchronized void addParts( Side side) {
        Iterator<Side> iterator = side.getInfrastructurePart().getOpensides().iterator();

        while(iterator.hasNext()){
            Side siddde = iterator.next();
            //System.out.println("iteration  "+side.getCityPart()+" "+siddde);

            if(siddde.getOppositeSide()!= null) {

                this.addOnePart(siddde, siddde.getOppositeSide()); //

                iterator.remove();
                 System.out.println("close " + siddde );

                addParts(siddde.getOppositeSide());
            }
            else System.out.println(siddde.getOppositeSide() +" is null");
        }
        if(side.getInfrastructurePart().isAllSidesConnected()) openParts.remove(side.getInfrastructurePart());
        if(this.isFinished()&& !this.getSidesWithMiples().isEmpty()){
            this.finishInfrastructure();
        }

    }


    
    public ArrayList<InfrastructurePart> getSides(){
        return this.sides;
    }
    public ArrayList<InfrastructurePart> getOpenParts(){
        return this.openParts;
    }



    @Override
    public boolean isFinished(){


        return openParts.isEmpty();
    }
    @Override
    public void finishInfrastructure()
    {
        if(openParts.isEmpty()) {
            int maxMiple = 1;
            for (ArrayList<Side> sides : sidesWithMiples.values()) {
                if (sides.size() >= maxMiple) {
                    maxMiple = sides.size();
                }
            }
            if(sidesWithMiples.isEmpty()) System.out.println("City have not player");
            for (Playerp playerp : sidesWithMiples.keySet()) {
                if (sidesWithMiples.get(playerp).size() == maxMiple) {
                    playerp.addPointsInfrastructure(score);
                   System.out.println( playerp+ " "+playerp.getScore());
                    playerp.removeInfrastructure(this);
                    for(Side side:sidesWithMiples.get(playerp) ){
                        playerp.addMiple(side.getMiple());
                        side.removeMiple();
                    }
                }
                else {

                    playerp.removeInfrastructure(this);
                    for(Side side:sidesWithMiples.get(playerp) ){
                        playerp.addMiple(side.getMiple());
                        side.removeMiple();
                    }
                }
            }
            System.out.println("city is finished");
            sidesWithMiples.clear();

        }
        else System.out.println("city is not finished");
    }






}
