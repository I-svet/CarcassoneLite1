package frames;

import chip.CLCard;
import chip.CLDeck;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DeckPanel extends JPanel  implements Runnable,KeyListener{
    Thread gameThread;
    int ont;
    private static final int FPS = 60;
    // JFrame frame;
    GamePanel gp;
    KeyHandler keyH= new KeyHandler();
   // MouseHandler mH = new MouseHandler();
    BufferedImage image;
    String name;
    CLDeck clDeck;
    CLCard upCard;

    public DeckPanel(GamePanel gp){
        this.gp=gp;

//this.clDeck=gp.clDeck;
//this.upCard=gp.upCard;
        this.setPreferredSize(new Dimension(216,216 ));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
     //   requestFocus();
     //   if(this.requestFocus(true)) {System.out.println("true");}else System.out.println("false");
        this.addKeyListener(keyH);
        this.addKeyListener(this);



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

            if(upCard!= null)
            draw(this.ont, g2, upCard);


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
            // System.out.println("The game loop is running");
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

        this.ont=gp.getPlayer().ont;
        this.clDeck=gp.getClDeck();
        this.upCard=gp.getUpCard();
    }
    public void draw(int ont, Graphics g, CLCard upCard){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        this.upCard=upCard;
        this.name = upCard.getType() + "";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/resField/"+name+"_"+ont+".png"));

        }catch(IOException e){
            e.printStackTrace();
        }
        this.ont=ont;
      /*  final double rads = Math.toRadians(90*this.ont);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
        final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(image,rotatedImage);


        g2.drawImage(rotatedImage, 0, 0,  (216 ),  (216 ), null);
        */
        g2.drawImage(image, 0, 0,  (216 ),  (216 ), null);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_P){
            this.ont+=1;
        }
    }
}
