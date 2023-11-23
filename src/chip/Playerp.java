package chip;

import City.*;
import City.CityPart;
import chipMiple.SuperMiple;
import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Playerp {
    private ArrayList<Infrastructure> infrastructures ;
    private ArrayList<Monaster> monasteries;
    private String name;
    private int score=0;

    private ArrayList<SuperMiple> hand;
    public Playerp(String nameIds, String namecolor ){
        this.name=nameIds;
        infrastructures = new ArrayList<>();
        monasteries = new ArrayList<>();
        setHand(namecolor);

    }
    public void setHand(String namecolor){
        SuperMiple[] miple = new SuperMiple[8];
        for(int k=0;k<8;k++){
            miple[k]=new SuperMiple();

        }

        for (int j = 0; j < 8; j++) {
            miple[j].name =namecolor;
            try{
                miple[j].image = ImageIO.read(getClass().getResourceAsStream("/resPlayer/"+namecolor+".png"));

            }catch(IOException e){
                e.printStackTrace();;
            }

        }

         hand = new ArrayList<SuperMiple>(Arrays.asList(miple));
    }
    /*public void finishCity(City city){
        scor+=city.getScor();
        hand.addAll(city.getMiples());
        cities.remove(city);
    }*/
    public ArrayList<SuperMiple> getHand(){
        return this.hand;
    }


    public void addInfrastructure(Infrastructure infrastructure){
        infrastructures.add(infrastructure);
    }
    public void addMonastery(Monaster monastery){ this.monasteries.add(monastery);}
    public void addPointsInfrastructure(int score){

        this.score+=score;
        System.out.println(this+" "+ score);

    }
    public void addPointsMonastery(int score){

        this.score+=score;
        System.out.println(this+" "+ score);

    }
    public void addMiple(ArrayList<SuperMiple> miples){
        hand.addAll(miples);
    }
    public void addMiple(SuperMiple miple){
        hand.add(miple);
    }
    public void removeInfrastructure(Infrastructure infrastructure){
        infrastructures.remove(infrastructure);
    }

    public ArrayList<Monaster> getMonasteries() {
        return monasteries;
    }

    public void removeMonastery(Monaster monastery){
        monasteries.remove(monastery);
    }
    public int getScore()
    {
        return score;
    }




}
