package frames;


import chip.CLCard;
import chip.CLDeck;
import chip.Game;
import chipCard.Chip_Card;
import chipCard.SuperChip;
import chipMiple.SuperMiple;
import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class MiplePanel extends JPanel implements Runnable{
    Thread gameThread;

    private static final int FPS =60;
    // JFrame frame;
    GamePanel gp;
    KeyHandler keyH= new KeyHandler();
    // MouseHandler mH = new MouseHandler();
    BufferedImage image;
    String name;
    CLDeck clDeck;

    Game game;
ArrayList<SuperMiple> hand;
    public MiplePanel(GamePanel gp){
        this.gp=gp;
this.game=gp.getGame();
        this.hand=game.players[game.getCurrentPlayerIndex()].getHand();

        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);






    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        name = "City1";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/resField/"+name+".png"));

        }catch(IOException e){
            e.printStackTrace();
        }


        draw(hand, g2);


        g2.dispose();
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval =1000000000/FPS;
        double delta=0;
        long lastTime =System.nanoTime();
        long currentTime;

        while(gameThread !=null){

            currentTime= System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime = currentTime;
            if(delta>=1){
                update();

                repaint();
                delta--;
            }

        }

    }

    private void update() {
        this.game=gp.getGame();
        this.hand=game.players[game.getCurrentPlayerIndex()].getHand();

    }
    public void draw(ArrayList<SuperMiple> hand, Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
int i=hand.size();

int x=0;
int y=0;
while(i>0) {
    SuperMiple miple = hand.get(0) ;
    this.image=miple.image;


    g2.drawImage(image, x* gp.mipleSize, y* gp.mipleSize, gp.mipleSize, gp.mipleSize, null);
    i--;
    if(y==1) {y=0; x++;}

    else
    y++;
}
    }





}

