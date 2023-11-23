package City;

import chip.*;

import java.util.Arrays;

public class Monaster{

    Playerp playerp;
    int pointOfOnePart;
    Center center;
    CLFieldPoint point;
    Boolean finished= false;
    int x;
    int y;
    int parts[][]= new int[3][3];

    int score =0;
    public Monaster (Center center, Playerp playerp,int x, int y){
        this.x=x;
        this.y=y;
        this.center= center;
        point=center.clFieldPoint;
        pointOfOnePart=1;
        this.playerp = playerp;
        score += pointOfOnePart;
        center.getClFieldPoint().addMonastery(this);
        parts[1][1]=1;

        System.out.print(Arrays.stream(parts).count());

    }
    public void addParts(CLField field){
        finished=true;
        for(int i=x-1; i<=x+1;i++){
            for(int j=y-1; j<=y+1;j++){
                if (field.getClFieldPoint(i,j)!=null){
                    if (parts[x+1-i][y+1-j] == 0){
                            parts[x + 1 - i][y + 1 - j] = 1;
                            score += 1;
                        }
                }
                else finished=false;
            }
        }

    }
    public void finishMonastery()
    {
        playerp.addPointsMonastery(score);
        System.out.println( playerp+ " "+playerp.getScore());
        playerp.removeMonastery(this);
        playerp.addMiple(center.getMiple());
        center.removeMiple();
        System.out.println("Monastery is finished");
        point.removeMonastery();

    }

}
