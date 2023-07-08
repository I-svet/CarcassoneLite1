package chip;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class CLFieldPoint {
    public enum Orientation
    {
        A,B,C,D;
        private static final CLFieldPoint.Orientation[] ont = CLFieldPoint.Orientation.values();
        public static CLFieldPoint.Orientation getOrientation(int i)
        {
            return Orientation.ont[i];
        }
    }

    public CLCard card;
    public Orientation ont;

    public void drawMiple(int screenX,int screenY, Graphics2D g2,GamePanel gp){
        int ont1=0;
        switch (ont) {
            case A -> ont1 = 0;
            case D -> ont1 = 1;
            case C -> ont1 = 2;
            case B -> ont1 = 3;
        }

        int x0= (int) (screenX+(gp.tileSize/2-gp.mipleSize/2)* gp.player.scale);
        int x1= (int) (screenX+(gp.tileSize-gp.mipleSize)* gp.player.scale);
        int x2= (int) (screenX+(gp.tileSize/2-gp.mipleSize/2)* gp.player.scale);
        int x3=screenX;
        int y1= (int) (screenY+(gp.tileSize/2-gp.mipleSize/2)* gp.player.scale);
        int y2= (int) (screenY+(gp.tileSize-gp.mipleSize)* gp.player.scale);
        int y3= (int) (screenY+(gp.tileSize/2-gp.mipleSize/2)* gp.player.scale);
        int y0=screenY;
        Point[] a = new Point[4];
        a[0]=new Point(x0,y0);
        a[1]=new Point(x1,y1);
        a[2]=new Point(x2,y2);
        a[3]=new Point(x3,y3);
        for(int i=0;i<4;i++) {
            if (card.SideM[i % 4].miple != null) {
                g2.drawImage(card.SideM[i % 4].miple.image, a[(i + ont1) % 4].x, a[(i + ont1) % 4].y, (int) ((int) gp.mipleSize * gp.player.scale), (int) (gp.mipleSize * gp.player.scale), null);
            }
        }
        if(card.center!=null){
            if(card.center.miple!= null)
            g2.drawImage(card.center.miple.image, (int) ( screenX+(gp.tileSize/2-gp.mipleSize/2)* gp.player.scale), (int) (screenY+(gp.tileSize/2-gp.mipleSize/2)* gp.player.scale), (int) ((int) gp.mipleSize * gp.player.scale), (int) (gp.mipleSize * gp.player.scale), null);

        }
    }


    public CLFieldPoint( CLCard card, Orientation ont){

        this.card=card;
        this.ont=ont;
    }
    public CLCard getCard(){
        return this.card;
    }
    public Orientation getOnt(){
        return this.ont;
    }

}
