package chip;


import City.*;
import chipMiple.SuperMiple;
import main.GamePanel;
import City.Monaster;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static chip.CLCard.Type.Monastery;

public class CLField {
    private final CLFieldPoint[][] points;
    BufferedImage image;
    String name;
    CLDeck clDeck;
    CLCard upCard;
    GamePanel gp;

    public CLField(GamePanel gp) {
        points = new CLFieldPoint[72][72];
        points[35][35]=new CLFieldPoint(new CLCard().RoadCity4(),0);
        this.gp=gp;
    }

    public void resetF() {
        for (int y = 0; y < 72; y++) {
            for (int x = 0; x < 72; x++) {
                points[x][y] = new CLFieldPoint(null, null);
            }
        }

        CLCard StartGame = new CLCard().city1();
        points[36][36] = new CLFieldPoint(StartGame, 2);
    }

   /*public boolean isPointOkey(int x, int y, CLCard card, int ontt) {
        // TODO change this shit ( add upper, lower, left and right cards to each clFieldPoint)
        CLFieldPoint.Orientation ont = CLFieldPoint.Orientation.getOrientation(ontt);
        boolean t = true;
        if(points[x][y]!=null) t=false;
        if(points[x-1][y]==null && points[x+1][y]==null && points[x][y-1]==null && points[x][y+1]==null) t = false;
            if (points[x - 1][y] != null) {
            switch(points[x - 1][y].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.getC().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.getC().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.getC().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.getC().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.getB().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.getB().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.getB().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.getB().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.getA().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.getA().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.getA().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.getA().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x - 1][y].card.getD().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                        case B -> {if( points[x - 1][y].card.getD().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case C -> {if( points[x - 1][y].card.getD().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case D -> {if( points[x - 1][y].card.getD().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                    }
                }
            }



        }
        if (points[x + 1][y] != null) {
            switch(points[x + 1][y].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.getA().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.getA().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.getA().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.getA().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.getD().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.getD().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.getD().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.getD().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.getC().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.getC().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.getC().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.getC().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x + 1][y].card.getB().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                        case B -> {if( points[x + 1][y].card.getB().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case C -> {if( points[x + 1][y].card.getB().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case D -> {if( points[x + 1][y].card.getB().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                    }
                }
            }



        }
        if (points[x][y-1] != null) {
            switch (points[x ][y-1].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x][y - 1].card.getD().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case B -> {if( points[x][y - 1].card.getD().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case C -> {if( points[x][y - 1].card.getD().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                        case D -> {if( points[x][y - 1].card.getD().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x][y - 1].card.getC().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case B -> {if( points[x][y - 1].card.getC().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case C -> {if( points[x][y - 1].card.getC().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                        case D -> {if( points[x][y - 1].card.getC().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x][y - 1].card.getB().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case B -> {if( points[x][y - 1].card.getB().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case C -> {if( points[x][y - 1].card.getB().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                        case D -> {if( points[x][y - 1].card.getB().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x][y - 1].card.getA().getTypeEdge() != card.getA().getTypeEdge()) t=false;}
                        case B -> {if( points[x][y - 1].card.getA().getTypeEdge() != card.getB().getTypeEdge()) t=false;}
                        case C -> {if( points[x][y - 1].card.getA().getTypeEdge() != card.getC().getTypeEdge()) t=false;}
                        case D -> {if( points[x][y - 1].card.getA().getTypeEdge() != card.getD().getTypeEdge()) t=false;}
                    }
                }
            }
        }
        if (points[x][y+1] != null) {
            switch (points[x ][y+1].ont) {
                case B -> {
                    switch (ont) {
                        case A -> {if( points[x][y + 1].card.getB().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case B -> {if( points[x][y + 1].card.getB().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case C -> {if( points[x][y + 1].card.getB().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                        case D -> {if( points[x][y + 1].card.getB().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                    }
                }
                case A -> {
                    switch (ont) {
                        case A -> {if( points[x][y + 1].card.getA().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case B -> {if( points[x][y + 1].card.getA().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case C -> {if( points[x][y + 1].card.getA().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                        case D -> {if( points[x][y + 1].card.getA().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                    }
                }
                case D -> {
                    switch (ont) {
                        case A -> {if( points[x][y + 1].card.getD().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case B -> {if( points[x][y + 1].card.getD().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case C -> {if( points[x][y + 1].card.getD().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                        case D -> {if( points[x][y + 1].card.getD().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                    }
                }
                case C -> {
                    switch (ont) {
                        case A -> {if( points[x][y + 1].card.getC().getTypeEdge() != card.getC().getTypeEdge()) t =false;}
                        case B -> {if( points[x][y + 1].card.getC().getTypeEdge() != card.getD().getTypeEdge()) t =false;}
                        case C -> {if( points[x][y + 1].card.getC().getTypeEdge() != card.getA().getTypeEdge()) t =false;}
                        case D -> {if( points[x][y + 1].card.getC().getTypeEdge() != card.getB().getTypeEdge()) t =false;}
                    }
                }
            }
        }
        return t;
    }*/

    public boolean isPointOkey(int x, int y, CLCard card, int orientation) {
        ArrayList<Side> sides = new ArrayList<>(List.of(card.getA(), card.getD(), card.getC(),card.getB() ));
       Side upSide = sides.get(orientation);
       Side rightSide = sides.get((orientation + 3) % 4);
       Side downSide = sides.get((orientation + 2) % 4);
       Side leftSide = sides.get((orientation + 1) % 4);
        boolean t = true;
        if(points[x][y]!=null) t=false;
        if(points[x-1][y]==null && points[x+1][y]==null && points[x][y-1]==null && points[x][y+1]==null) t = false;

        if (points[x - 1][y] != null) {
           if (points[x - 1][y].getRightSide().getTypeEdge() != leftSide.getTypeEdge()) t = false;
        }
        if (points[x + 1][y] != null) {
            if( points[x + 1][y].getLeftSide().getTypeEdge() != rightSide.getTypeEdge()) t=false;
        }
        if (points[x][y-1] != null) {
            if( points[x][y-1].getDownSide().getTypeEdge() != upSide.getTypeEdge()) t=false;
        }
        if (points[x][y+1] != null) {
            if( points[x][y+1].getUpSide().getTypeEdge() != downSide.getTypeEdge()) t=false;
        }
        return t;
    }




    public CLCard getCard(int x,int y){
        return points[x][y].getCard();
    }
    public CLFieldPoint getClFieldPoint(int x,int y){return points[x][y];}
    public CLFieldPoint addCard(int x, int y, CLCard card, int orientation){


        points[x][y] = new CLFieldPoint(card, orientation);
        if (points[x - 1][y] != null) {

            points[x][y].getLeftSide().setOppositeSide(points[x - 1][y].getRightSide());
          //  points[x-1][y].getRightSide().setOppositeSide(points[x][y].getLeftSide()); //TODO i should remade this


        }
        if (points[x + 1][y] != null) {
            points[x][y].getRightSide().setOppositeSide(points[x + 1][y].getLeftSide());
          //  points[x+1][y].getLeftSide().setOppositeSide(points[x][y].getRightSide());
        }
        if (points[x][y-1] != null) {
            points[x][y].getUpSide().setOppositeSide(points[x][y-1].getDownSide());
            //points[x][y-1].getDownSide().setOppositeSide(points[x][y].getUpSide());
        }
        if (points[x][y+1] != null) {
            points[x][y].getDownSide().setOppositeSide(points[x][y+1].getUpSide());
            //points[x][y+1].getUpSide().setOppositeSide(points[x][y].getDownSide());
        }

        for(Monaster monastery: gp.getMonasteries()){
            if (!monastery.isFinished()) {
                monastery.addParts(this);
            }
        }

        return points[x][y];

    }
    public boolean isMipleOkey(int x, int y,int x0,int y0,GamePanel gp){
        int a= gp.tileSize;
        boolean t =false;
        int ont1 =0;

        boolean b = (y0 >= a / 3) && (y0 <= 2 * a / 3);
        if(points[x][y]!=null) {
           ont1= points[x][y].getOrientation();

            if (x0 > a / 3) {
                if (x0 <= 2 * a / 3) {
                    if (y0 < a / 3) {
                        t = points[x][y].card.getSideM()[(4 - ont1) % 4].getMiple() == null && points[x][y].card.getSideM()[(4 - ont1) % 4].getInfrastructure() == null;

                    } else {
                        if (y0 > 2 * a / 3) {
                            t = points[x][y].card.getSideM()[(6 - ont1) % 4].getMiple() == null && points[x][y].card.getSideM()[(6 - ont1) % 4].getInfrastructure() == null;
                        } else {
                            if(points[x][y].card.getCenter() != null)
                            t = points[x][y].card.getCenter().miple == null;
                        }
                    }
                } else {
                    if (b) {
                        t = points[x][y].card.getSideM()[(5 - ont1) % 4].getMiple() == null && points[x][y].card.getSideM()[(5 - ont1) % 4].getInfrastructure() == null;
                    }
                }

            } else {
                if (b) {
                    t = points[x][y].card.getSideM()[(7 - ont1) % 4].getMiple() == null && points[x][y].card.getSideM()[(7 - ont1) % 4].getInfrastructure() == null;

                }
            }
        }

        return t;
    }

    public synchronized  void addMiple(int x, int y, SuperMiple miple,int x0,int y0,GamePanel gp,Playerp player){
        int ont1=0;
        int a= gp.tileSize;
        ont1 =points[x][y].getOrientation();

        boolean b = (y0 >= a / 3) && (y0 <= 2 * a / 3);
        if(x0>a/3){
           if(x0<=2*a/3) {
               if(y0<a/3){
                   points[x][y].card.getSideM()[(4-ont1)%4].setMiple(miple);
                   if(points[x][y].card.getSideM()[(4-ont1)%4].getTypeEdge()== Side.TypeEdge.City) {
                       Infrastructure newCity = new City(points[x][y].card.getSideM()[(4-ont1)%4],player);
                       player.addInfrastructure(newCity);
                       newCity.addParts(points[x][y].card.getSideM()[(4-ont1)%4]);
                   }else
                   if(points[x][y].card.getSideM()[(4-ont1)%4].getTypeEdge()== Side.TypeEdge.road) {
                       Infrastructure newRoad = new Road(points[x][y].card.getSideM()[(4-ont1)%4],player);
                       player.addInfrastructure(newRoad);
                       newRoad.addParts(points[x][y].card.getSideM()[(4-ont1)%4]);
                   }
               }
               else{
                   if(y0>2*a/3){
                       points[x][y].card.getSideM()[(6-ont1)%4].setMiple(miple);
                       if(points[x][y].card.getSideM()[(6-ont1)%4].getTypeEdge()== Side.TypeEdge.City) {
                           Infrastructure newCity = new City(points[x][y].card.getSideM()[(6 - ont1) % 4], player);
                           player.addInfrastructure(newCity);
                           newCity.addParts(points[x][y].card.getSideM()[(6-ont1)%4]);
                       }else
                       if(points[x][y].card.getSideM()[(6-ont1)%4].getTypeEdge()== Side.TypeEdge.road) {
                           Infrastructure newRoad = new Road(points[x][y].card.getSideM()[(6-ont1)%4],player);
                           player.addInfrastructure(newRoad);
                           newRoad.addParts(points[x][y].card.getSideM()[(6-ont1)%4]);
                       }
                   }
                   else{
                        if(points[x][y].card.getCenter() !=null){
                            points[x][y].card.getCenter().miple=miple;
                            Monaster newMonestery =new Monaster(points[x][y].card.getCenter(),player,x,y);
                            gp.addMonastery(newMonestery);
                            player.addMonastery(newMonestery);
                            newMonestery.addParts(this);

                        }
                   }
               }
           }
           else {
               if(b)
               {
                   points[x][y].card.getSideM()[(5-ont1)%4].setMiple(miple);
                   if(points[x][y].card.getSideM()[(5-ont1)%4].getTypeEdge()== Side.TypeEdge.City) {
                       Infrastructure newCity = new City(points[x][y].card.getSideM()[(5 - ont1) % 4], player);
                       player.addInfrastructure(newCity);
                       newCity.addParts(points[x][y].card.getSideM()[(5-ont1)%4]);
                   }
                   if(points[x][y].card.getSideM()[(5-ont1)%4].getTypeEdge()== Side.TypeEdge.road) {
                       Infrastructure newRoad = new Road(points[x][y].card.getSideM()[(5-ont1)%4],player);
                       player.addInfrastructure(newRoad);
                       newRoad.addParts(points[x][y].card.getSideM()[(5-ont1)%4]);
                   }
               }
           }

        }
        else{
            if(b)
            {
                points[x][y].card.getSideM()[(7-ont1)%4].setMiple(miple);
                if(points[x][y].card.getSideM()[(7-ont1)%4].getTypeEdge()== Side.TypeEdge.City) {
                    Infrastructure newCity = new City(points[x][y].card.getSideM()[(7 - ont1) % 4], player);
                    player.addInfrastructure(newCity);
                    newCity.addParts(points[x][y].card.getSideM()[(7-ont1)%4]);
                }
                if(points[x][y].card.getSideM()[(7-ont1)%4].getTypeEdge()== Side.TypeEdge.road) {
                    Infrastructure newRoad = new Road(points[x][y].card.getSideM()[(7-ont1)%4],player);
                    player.addInfrastructure(newRoad);
                    newRoad.addParts(points[x][y].card.getSideM()[(7-ont1)%4]);
                }
            }
        }

    }


    public void draw(Graphics2D g2,GamePanel gp) {
        int worldCol = (int) (gp.getPlayer().worldX - gp.getPlayer().screenX * 1.0 / gp.getPlayer().scale - gp.tileSize) / gp.tileSize + 1;
        if(worldCol<0) worldCol=0;
        int worldColl = worldCol;
        int worldRow = (int) (gp.getPlayer().worldY - gp.getPlayer().screenY * 1.0 / gp.getPlayer().scale - gp.tileSize) / gp.tileSize + 1;
        if(worldRow<0) worldRow=0;
        int worldCol2 = (int) (gp.getPlayer().worldX + gp.getPlayer().screenX / gp.getPlayer().scale + gp.tileSize) / gp.tileSize ;
        if (worldCol2>71) worldCol2=71;
        int worldRow2 = (int) (gp.getPlayer().worldY + gp.getPlayer().screenY / gp.getPlayer().scale + gp.tileSize) / gp.tileSize;
        if(worldRow2>71) worldRow2=71;
        while(worldCol < worldCol2 && worldRow <worldRow2 ){
            if(points[worldCol][worldRow]!=null) {
                    int worldX = worldCol * gp.tileSize;
                    int worldY = worldRow * gp.tileSize;
                    int screenX = (int) ((worldX - gp.getPlayer().worldX) * gp.getPlayer().scale + gp.getPlayer().screenX);
                    int screenY = (int) ((worldY - gp.getPlayer().worldY) * gp.getPlayer().scale + gp.getPlayer().screenY);


                        int ont =points[worldCol][worldRow].getOrientation();

                        name = points[worldCol][worldRow].card.getType() + "";
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
                       // g2.drawImage(rotatedImage, screenX, screenY, (int) ((int) gp.tileSize * gp.getPlayer().scale), (int) (gp.tileSize * gp.getPlayer().scale), null);

                g2.drawImage(image, screenX, screenY, (int) (gp.tileSize * gp.getPlayer().scale), (int) (gp.tileSize * gp.getPlayer().scale), null);

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

