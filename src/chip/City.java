package chip;

import entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
    public ArrayList<Player> players;
    public ArrayList<ArrayList<Side>> sides;
    boolean open = true;
    public int scor =0;
    public City(Side side, Player player){
       players.add(player);
       sides.add(side.connections);
       scor += 1;
    }


}
