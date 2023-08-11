package entity;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    MouseHandler mH;
    public final int screenX;
    public final int screenY;
    public double scale;
    public int ont;
    public Point point;


    public Player(GamePanel gp, KeyHandler keyH,MouseHandler mH){
        this.gp=gp;
        this.keyH=keyH;
        this.mH=mH;
        screenX=gp.screenWidth/2;
        screenY=gp.screenHeight/2;

        setdefaultValues();
        getPlayerImage();
    }
    public void setdefaultValues(){
        worldX=gp.tileSize*36-gp.mipleSize/2;
        worldY=gp.tileSize*36-gp.mipleSize/2-100;
        speed=10;
        color ="blue";
    }
    public void getPlayerImage(){
        try{
            green = ImageIO.read(getClass().getResourceAsStream("/resplayer/green.png"));
            red = ImageIO.read(getClass().getResourceAsStream("/resplayer/red.png"));
            blue = ImageIO.read(getClass().getResourceAsStream("/resplayer/blue.png"));
            yellow = ImageIO.read(getClass().getResourceAsStream("/resplayer/yellow.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public void update(){
        if(worldY>(gp.tileSize*2)/gp.getPlayer().scale-100/gp.getPlayer().scale-gp.mipleSize/2){
        if (keyH.upPressed==true){
            worldY-=(speed*1.0/gp.getPlayer().scale);
        }}
        if(worldY< gp.maxWorldHeight+100/gp.getPlayer().scale-gp.mipleSize/2-( gp.tileSize*2)/gp.getPlayer().scale) {
            if (keyH.downPressed == true) {
                worldY +=  (speed*1.0/gp.getPlayer().scale);
            }
        }if(worldX< gp.maxWorldWidth-( gp.tileSize*2)/gp.getPlayer().scale
                +gp.mipleSize/2) {
            if (keyH.rightPressed == true) {
                worldX += (speed*1.0/gp.getPlayer().scale);
            }
        }
        if(worldX>(gp.tileSize*2)/gp.getPlayer().scale-gp.mipleSize/2){
        if (keyH.leftPressed==true){
            worldX-= (speed*1.0/gp.getPlayer().scale);
        }}
        ont=keyH.ont;
        scale=mH.scale;
        point=mH.point;




    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(color){
            case "green":
                image = green;
                break;
            case "blue":
                image = blue;
                break;
            case "red":
                image = red;
                break;
            case "yellow":
                image = yellow;
                break;
        }
        g2.drawImage(image,screenX-gp.mipleSize/2,screenY-gp.mipleSize/2,gp.mipleSize,gp.mipleSize,null);
    }

}
