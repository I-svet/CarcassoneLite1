package chip;


import chipMiple.SuperMiple;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static chip.CLFieldPoint.Orientation.A;

public class CLField {
    private CLFieldPoint[][] points;
    BufferedImage image;
    String name;
    CLDeck clDeck;
    CLCard upCard;
    GamePanel gp;

    public CLField(GamePanel gp) {
        points = new CLFieldPoint[72][72];
        points[35][35]=new CLFieldPoint(new CLCard().RoadCity4(),A);
        this.gp=gp;
    }

    public void resetF() {
        for (int y = 0; y < 72; y++) {
            for (int x = 0; x < 72; x++) {
                points[x][y] = new CLFieldPoint(null, null);
            }
        }

        CLCard StartGame = new CLCard().city1();
        points[36][36] = new CLFieldPoint(StartGame, CLFieldPoint.Orientation.B);
    }

    public boolean isPointOkey(int x, int y, CLCard card, CLFieldPoint.Orientation ont) {
        // TODO change this shit ( add upper, lower, left and right cards to each clFieldPoint)
        boolean t = true;
        if(points[x][y]!=null) t=false;
        if(points[x-1][y]==null && points[x+1][y]==null && points[x][y-1]==null && points[x][y+1]==null) t = false;
            if (points[x - 1][y] != null) {
            switch(points[x - 1][y].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.C.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.C.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.C.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.C.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.B.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.B.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.B.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.B.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.A.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.A.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.A.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.A.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.D.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.D.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.D.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.D.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                    }
                }
            }



        }
        if (points[x + 1][y] != null) {
            switch(points[x + 1][y].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.A.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.A.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.A.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.A.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.D.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.D.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.D.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.D.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.C.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.C.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.C.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.C.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.B.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.B.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.B.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.B.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                    }
                }
            }



        }
        if (points[x][y-1] != null) {
            switch (points[x ][y-1].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x ][y-1].card.D.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case B -> {if( points[x ][y-1].card.D.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case C -> {if( points[x ][y-1].card.D.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                        case D -> {if( points[x ][y-1].card.D.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x ][y-1].card.C.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case B -> {if( points[x ][y-1].card.C.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case C -> {if( points[x ][y-1].card.C.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                        case D -> {if( points[x ][y-1].card.C.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x ][y-1].card.B.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case B -> {if( points[x ][y-1].card.B.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case C -> {if( points[x ][y-1].card.B.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                        case D -> {if( points[x ][y-1].card.B.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x ][y-1].card.A.getTypeEdge() != card.A.getTypeEdge()) t=false;}
                        case B -> {if( points[x ][y-1].card.A.getTypeEdge() != card.B.getTypeEdge()) t=false;}
                        case C -> {if( points[x ][y-1].card.A.getTypeEdge() != card.C.getTypeEdge()) t=false;}
                        case D -> {if( points[x ][y-1].card.A.getTypeEdge() != card.D.getTypeEdge()) t=false;}
                    }
                }
            }
        }
        if (points[x][y+1] != null) {
            switch (points[x ][y+1].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x ][y+1].card.B.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case B -> {if( points[x ][y+1].card.B.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case C -> {if( points[x ][y+1].card.B.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                        case D -> {if( points[x ][y+1].card.B.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x ][y+1].card.A.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case B -> {if( points[x ][y+1].card.A.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case C -> {if( points[x ][y+1].card.A.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                        case D -> {if( points[x ][y+1].card.A.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x ][y+1].card.D.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case B -> {if( points[x ][y+1].card.D.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case C -> {if( points[x ][y+1].card.D.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                        case D -> {if( points[x ][y+1].card.D.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x ][y+1].card.C.getTypeEdge() != card.C.getTypeEdge()) t =false;}
                        case B -> {if( points[x ][y+1].card.C.getTypeEdge() != card.D.getTypeEdge()) t =false;}
                        case C -> {if( points[x ][y+1].card.C.getTypeEdge() != card.A.getTypeEdge()) t =false;}
                        case D -> {if( points[x ][y+1].card.C.getTypeEdge() != card.B.getTypeEdge()) t =false;}
                    }
                }
            }
        }
        return t;
    }

    public Side.TypeEdge getLeftEdge(int x,int y){
        CLCard card = points[x][y].getCard();
        CLFieldPoint.Orientation ont =points[x][y].getOnt();
        Side.TypeEdge t=null;
        if(card!= null) {
            switch (ont) {
                case A -> t = card.D.getTypeEdge();
                case B -> t = card.A.getTypeEdge();
                case C -> t = card.B.getTypeEdge();
                case D -> t = card.C.getTypeEdge();
            }
        }
        return t;
    }
    public Side.TypeEdge getRightEdge(int x,int y){
        CLCard card = points[x][y].getCard();
        CLFieldPoint.Orientation ont =points[x][y].getOnt();
        Side.TypeEdge t=null;
        if(card!= null) {
            switch (ont) {
                case A -> t = card.B.getTypeEdge();
                case B -> t = card.C.getTypeEdge();
                case C -> t = card.D.getTypeEdge();
                case D -> t = card.A.getTypeEdge();
            }
        }
        return t;
    }
    public Side.TypeEdge getUpperEdge(int x,int y){
        CLCard card = points[x][y].getCard();
        CLFieldPoint.Orientation ont =points[x][y].getOnt();
        Side.TypeEdge t=null;
        if(card!= null) {
            switch (ont) {
                case A -> t = card.A.getTypeEdge();
                case B -> t = card.B.getTypeEdge();
                case C -> t = card.C.getTypeEdge();
                case D -> t = card.D.getTypeEdge();
            }
        }
        return t;
    }
    public Side.TypeEdge getLowerEdge(int x,int y){
        CLCard card = points[x][y].getCard();
        CLFieldPoint.Orientation ont =points[x][y].getOnt();
        Side.TypeEdge t=null;
        if(card!= null) {
            switch (ont) {
                case A -> t = card.C.getTypeEdge();
                case B -> t = card.D.getTypeEdge();
                case C -> t = card.A.getTypeEdge();
                case D -> t = card.B.getTypeEdge();
            }
        }
        return t;
    }
    public CLCard getCard(int x,int y){
        return points[x][y].getCard();
    }
    public void addCard(int x, int y, CLCard card, CLFieldPoint.Orientation ont){
        points[x][y] = new CLFieldPoint(card, ont);
    }
    public boolean iiMipleOkey(int x, int y,int x0,int y0,GamePanel gp){
        int a= gp.tileSize;
        boolean t =false;
        int ont1 =0;

        boolean b = (y0 >= a / 3) && (y0 <= 2 * a / 3);
        if(points[x][y]!=null) {
            switch (points[x][y].ont) {
                case A -> ont1 = 0;
                case D -> ont1 = 1;
                case C -> ont1 = 2;
                case B -> ont1 = 3;
            }
            if (x0 > a / 3) {
                if (x0 <= 2 * a / 3) {
                    if (y0 < a / 3) {
                        t = points[x][y].card.SideM[(4 - ont1) % 4].miple == null;
                    } else {
                        if (y0 > 2 * a / 3) {
                            t = points[x][y].card.SideM[(6 - ont1) % 4].miple == null;
                        } else {
                            if(points[x][y].card.center != null)
                            t = points[x][y].card.center.miple == null;
                        }
                    }
                } else {
                    if (b) {
                        t = points[x][y].card.SideM[(5 - ont1) % 4].miple == null;
                    }
                }

            } else {
                if (b) {
                    t = points[x][y].card.SideM[(7 - ont1) % 4].miple == null;

                }
            }
        }

        return t;
    }

    public void addMiple(int x, int y, SuperMiple miple,int x0,int y0,GamePanel gp){
        int ont1=0;
        int a= gp.tileSize;
        switch (points[x][y].ont) {
            case A -> ont1 = 0;
            case D -> ont1 = 1;
            case C -> ont1 = 2;
            case B -> ont1 = 3;
        }
        boolean b = (y0 >= a / 3) && (y0 <= 2 * a / 3);
        if(x0>a/3){
           if(x0<=2*a/3) {
               if(y0<a/3){
                   points[x][y].card.SideM[(4-ont1)%4].miple=miple;
               }
               else{
                   if(y0>2*a/3){
                       points[x][y].card.SideM[(6-ont1)%4].miple=miple;
                   }
                   else{
if(points[x][y].card.center!=null){
    points[x][y].card.center.miple=miple;
}
                   }
               }
           }
           else {
               if(b)
               {
                   points[x][y].card.SideM[(5-ont1)%4].miple=miple;
               }
           }

        }
        else{
            if(b)
            {
                points[x][y].card.SideM[(7-ont1)%4].miple=miple;
            }
        }

    }


    public void draw(Graphics2D g2,GamePanel gp) {
        int worldCol = (int) (gp.player.worldX - gp.player.screenX * 1.0 / gp.player.scale - gp.tileSize) / gp.tileSize + 1;
        if(worldCol<0) worldCol=0;
        int worldColl = worldCol;
        int worldRow = (int) (gp.player.worldY - gp.player.screenY * 1.0 / gp.player.scale - gp.tileSize) / gp.tileSize + 1;
        if(worldRow<0) worldRow=0;
        int worldCol2 = (int) (gp.player.worldX + gp.player.screenX / gp.player.scale + gp.tileSize) / gp.tileSize ;
        if (worldCol2>71) worldCol2=71;
        int worldRow2 = (int) (gp.player.worldY + gp.player.screenY / gp.player.scale + gp.tileSize) / gp.tileSize;
        if(worldRow2>71) worldRow2=71;
        while(worldCol < worldCol2 && worldRow <worldRow2 ){
            if(points[worldCol][worldRow]!=null) {
                    int worldX = worldCol * gp.tileSize;
                    int worldY = worldRow * gp.tileSize;
                    int screenX = (int) ((worldX - gp.player.worldX) * gp.player.scale + gp.player.screenX);
                    int screenY = (int) ((worldY - gp.player.worldY) * gp.player.scale + gp.player.screenY);


                        int ont = 0;
                        switch (points[worldCol][worldRow].ont) {
                            case A -> ont = 0;
                            case D -> ont = 1;
                            case C -> ont = 2;
                            case B -> ont = 3;
                        }
                        name = points[worldCol][worldRow].card.type + "";
                            image = gp.images.get(name+"_"+ont);
                        /*final double rads = Math.toRadians(90 * ont);
                        final double sin = Math.abs(Math.sin(rads));
                        final double cos = Math.abs(Math.cos(rads));
                        final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
                        final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
                        final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
                        final AffineTransform at = new AffineTransform();
                        at.translate(w / 2, h / 2);
                        at.rotate(rads, 0, 0);
                        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
                        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                        rotateOp.filter(image, rotatedImage);*/
                       // g2.drawImage(rotatedImage, screenX, screenY, (int) ((int) gp.tileSize * gp.player.scale), (int) (gp.tileSize * gp.player.scale), null);

                g2.drawImage(image, screenX, screenY, (int) ((int) gp.tileSize * gp.player.scale), (int) (gp.tileSize * gp.player.scale), null);

                if(points[worldCol][worldRow].card!=null){
                        points[worldCol][worldRow].drawMiple(screenX,screenY,g2,gp);
                        }

                }
            worldCol++;

            if(worldCol==worldCol2){
                worldCol=worldColl;

                worldRow++;

            }



        }



    }

}

