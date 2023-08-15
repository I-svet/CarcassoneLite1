package chip;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class CLFieldPoint {
    public enum Orientation
    {
        A,D,C,B;
        private static final ArrayList<CLFieldPoint.Orientation> onts = new ArrayList<>(List.of(Orientation.values()));
        public static CLFieldPoint.Orientation getOrientation(int i)
        {
            return Orientation.onts.get(i);
        }

        int getOrientationIndex()
        {
            return onts.indexOf(this);
        }
    }

     CLCard card;
     Side upSide;
     Side downSide;
     Side leftSide;
     Side rightSide;

     Orientation ont;
   //  HashMap<Side,Side> oppositeSides;
    int orientation;

    public void drawMiple(int screenX,int screenY, Graphics2D g2,GamePanel gp){
        int ont1=orientation;

        int x0= (int) (screenX+(gp.tileSize/2-gp.mipleSize/2)* gp.getPlayer().scale);
        int x1= (int) (screenX+(gp.tileSize-gp.mipleSize)* gp.getPlayer().scale);
        int x2= (int) (screenX+(gp.tileSize/2-gp.mipleSize/2)* gp.getPlayer().scale);
        int x3=screenX;
        int y1= (int) (screenY+(gp.tileSize/2-gp.mipleSize/2)* gp.getPlayer().scale);
        int y2= (int) (screenY+(gp.tileSize-gp.mipleSize)* gp.getPlayer().scale);
        int y3= (int) (screenY+(gp.tileSize/2-gp.mipleSize/2)* gp.getPlayer().scale);
        int y0=screenY;
        Point[] a = new Point[4];
        a[0]=new Point(x0,y0);
        a[1]=new Point(x1,y1);
        a[2]=new Point(x2,y2);
        a[3]=new Point(x3,y3);
        for(int i=0;i<4;i++) {
            if (card.getSideM()[i % 4].getMiple() != null) {
                g2.drawImage(card.getSideM()[i % 4].getMiple().image, a[(i + ont1) % 4].x, a[(i + ont1) % 4].y, (int) ((int) gp.mipleSize * gp.getPlayer().scale), (int) (gp.mipleSize * gp.getPlayer().scale), null);
            }
        }
        if(card.getCenter() !=null){
            if(card.getCenter().miple!= null)
            g2.drawImage(card.getCenter().miple.image, (int) ( screenX+(gp.tileSize/2-gp.mipleSize/2)* gp.getPlayer().scale), (int) (screenY+(gp.tileSize/2-gp.mipleSize/2)* gp.getPlayer().scale), (int) ((int) gp.mipleSize * gp.getPlayer().scale), (int) (gp.mipleSize * gp.getPlayer().scale), null);

        }
    }


    public Side getUpSide() {
        return upSide;
    }

    public Side getDownSide() {
        return downSide;
    }

    public Side getLeftSide() {
        return leftSide;
    }

    public Side getRightSide() {
        return rightSide;
    }

    public CLFieldPoint(CLCard card, Integer orientation){
        this.ont = Orientation.getOrientation(orientation);
        this.card=card;
        this.orientation = orientation;
        ArrayList<Side> sides = new ArrayList<>(List.of(card.getA(), card.getD(), card.getC(),card.getB() ));
        upSide = sides.get(orientation);
        rightSide = sides.get((orientation + 3) % 4);
        downSide = sides.get((orientation + 2) % 4);
        leftSide = sides.get((orientation + 1) % 4);
        /*oppositeSides.put(upSide,null);
        oppositeSides.put(downSide,null);
        oppositeSides.put(rightSide,null);
        oppositeSides.put(leftSide,null);*/
    }
    public CLCard getCard(){
        return this.card;
    }
    public int getOrientation(){
        return this.orientation;
    }

}
