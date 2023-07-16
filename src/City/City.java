package City;

import chip.Side;
import entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
    public ArrayList<Player> players;
    public ArrayList<CityPart> sides;
    ArrayList<CityPart> closeParts;
    boolean open = true;
    public int scor =0;
    public City(Side side, Player player){
       players.add(player);
       CityPart part = new CityPart(side.connections,player);
       sides.add(part);
       scor += 1;
    }


}
