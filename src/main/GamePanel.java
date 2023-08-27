package main;

import chip.*;

import chipCard.SuperChip;
import chipMiple.SuperMiple;
import entity.Player;
import menu.AddPlayerNames;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;


public class GamePanel extends JPanel implements Runnable{
    JLabel jLabel1;
    public final int originalTileSize = 216;
    final int originalMipleSize = 16;
    final int scale=1;
    final int scaleM =3;
    public final int tileSize =originalTileSize*scale;//216
    public final int mipleSize =originalMipleSize*scaleM;//48
    public  final int maxScreenCol=4;
    public  final int maxScreenRow=3;
    public  final int screenWidth=tileSize*maxScreenCol;//856
    public final int screenHeight = tileSize*maxScreenRow;//648

    public final int maxWorldCol =72;
    public final int maxWorldRow =72;
    public final int maxWorldWidth =tileSize*maxWorldCol;
    public final int maxWorldHeight =tileSize*maxWorldRow;
     final int FPS = 60;



    MouseHandler mH = new MouseHandler();
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    TileManager tileM = new TileManager(this);
    CLField clField = new CLField(this);

     Player player = new Player(this,keyH,mH);

     CLDeck clDeck = new CLDeck();
     CLCard upCard=new CLCard();
     Game game;
     boolean putcard=false;
    ArrayList<String> temp;
    String[] pids;
    SuperChip[] chip =new SuperChip[72];
    SuperMiple[] miple = new SuperMiple[10];
    public HashMap<String, BufferedImage> images = new HashMap<>();


    public GamePanel(ArrayList<String> playerIds,JLabel jLabel1){
        super(true);
        upCard.city1();
        clDeck.reset();
        clDeck.shuffle();
        upCard=clDeck.drawCard();

        this.jLabel1=jLabel1;
        temp=playerIds;
        pids=temp.toArray(new String[temp.size()]);
        game=new Game(pids);
           setPidName(game);

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseWheelListener(mH);
        this.setFocusable(true);
        this.addMouseListener(mH);
    }
    public void setPidName(Game game) {
        String currentPlayer=game.getCurrentPlayer();
        jLabel1.setText(currentPlayer+"'s turn");
    }
    public void setPidName(String currentPlayer){
        jLabel1.setText(currentPlayer+"'s turn");
    }
    public void setUpCard(CLCard upCard,CLDeck clDeck){
        upCard=clDeck.drawCard();
}
    public void setupGame(GamePanel gp, AssetSetter aSetter){
        aSetter.setObject(gp);
    }


    public void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        long drawStart=0;
        long drawEnd1=0;
        if(keyH.checkDrawTime) {
             drawStart = System.nanoTime();
        }
        super.paintComponent(g2);
        setDoubleBuffered(true);
        tileM.draw(g2);
        if(keyH.checkDrawTime) {
            drawEnd1 = System.nanoTime();
        }
        clField.draw(g2,this);

// debug
        if(keyH.checkDrawTime) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd1 - drawStart;
            long passed2=drawEnd-drawEnd1;
            g2.setColor(Color.white);
            g2.drawString("Draw time1:" + passed/1000000+"Draw time1:" + passed2/1000000, 10, 400);
            System.out.println("Draw time:" + passed+"Draw time1:" + passed2);
        }
        g2.dispose();
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

   /* Alternative variant of ru function
   @Override
    public void run() {
        double drawInterval = 100000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread!=null){
            update();
            repaint();
            try{
                double remainingTime = nextDrawTime-System.nanoTime();
                remainingTime=remainingTime/1000000;
                if(remainingTime<0) remainingTime=0;
                Thread.sleep((long) remainingTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }*/
    @Override
    public void run(){
           double drawInterval =1000000000/FPS;
        double delta=0;
        long lastTime =System.nanoTime();
        long currentTime;
        long timer =0;
        int drawCount =0;

        while(gameThread !=null){
            currentTime= System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            timer+=(currentTime-lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
           if(timer >= 1000000000){
              // System.out.println(("FPS"+ drawCount));
               timer=0;
               drawCount=0;
           }
        }

    }

    public void update() {
        player.update();

        if (!mH.check) {
            int orientation = keyH.ont;

            int xOnMap = ((int) (player.worldX + (mH.x - player.screenX) * 1.0 / player.scale)) / this.tileSize;
            int yOnMap = ((int) (player.worldY + (mH.y - player.screenY) * 1.0 / player.scale)) / this.tileSize;

            if (clField.isPointOkey(xOnMap, yOnMap, upCard, orientation)) {
                game.setCurrentPoint(clField.addCard(xOnMap, yOnMap, upCard, orientation));
                mH.p = true;
                putcard=true;
            }
            if (clDeck.isEmpty()) {
                JLabel message4 = new JLabel("Game is over");
                message4.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message4);
                System.exit(0);
            }
            mH.check = true;
        }
            if ((keyH.skip)&&(putcard)) {
                keyH.skip = false;
                putcard=false;
                setPidName(game.changePlayer());
                upCard = clDeck.drawCard();
                mH.p = false;
            } else if ((!mH.check2) && (mH.p)) {

               // keyH.skip = false;
                int xOnMapCard = ((int) (player.worldX + (mH.x - player.screenX) * 1.0 / player.scale)) / this.tileSize;
                int yOnMapCard = ((int) (player.worldY + (mH.y - player.screenY) * 1.0 / player.scale)) / this.tileSize;
                int xOnMapPoint = ((int) (player.worldX + (mH.x - player.screenX) * 1.0 / player.scale)) % this.tileSize;
                int yOnMapPoint = ((int) (player.worldY + (mH.y - player.screenY) * 1.0 / player.scale)) % this.tileSize;
                if (game.isItCurrentPoint(clField.getClFieldPoint(xOnMapCard, yOnMapCard))) {
                    if (clField.isMipleOkey(xOnMapCard, yOnMapCard, xOnMapPoint, yOnMapPoint, this)) {
                        clField.addMiple(xOnMapCard, yOnMapCard, game.players[game.getCurrentPlayerIndex()].getHand().get(0), xOnMapPoint, yOnMapPoint, this,game.players[game.getCurrentPlayerIndex()]);

                        game.players[game.getCurrentPlayerIndex()].getHand().remove(0);
                        setPidName(game.changePlayer());
                        upCard = clDeck.drawCard();
                        mH.p = false;
                        putcard=false;

                    }
                }
                mH.check2 = true;
            }
        }


    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getOriginalMipleSize() {
        return originalMipleSize;
    }

    public int getScale() {
        return scale;
    }

    public int getScaleM() {
        return scaleM;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMipleSize() {
        return mipleSize;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getMaxWorldWidth() {
        return maxWorldWidth;
    }

    public int getMaxWorldHeight() {
        return maxWorldHeight;
    }

    public int getFPS() {
        return FPS;
    }

    public MouseHandler getmH() {
        return mH;
    }

    public KeyHandler getKeyH() {
        return keyH;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public TileManager getTileM() {
        return tileM;
    }

    public CLField getClField() {
        return clField;
    }

    public Player getPlayer() {
        return player;
    }

    public CLDeck getClDeck() {
        return clDeck;
    }

    public CLCard getUpCard() {
        return upCard;
    }

    public Game getGame() {
        return game;
    }

    public ArrayList<String> getTemp() {
        return temp;
    }

    public String[] getPids() {
        return pids;
    }

    public SuperChip[] getChip() {
        return chip;
    }

    public SuperMiple[] getMiple() {
        return miple;
    }

    public HashMap<String, BufferedImage> getImages() {
        return images;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

}

