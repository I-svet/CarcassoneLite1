package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager{
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[10];
        mapTileNum=new int [gp.maxWorldCol] [gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/map144-144.txt");
    }
    public void loadMap(String map){
        try{
            InputStream is = getClass().getResourceAsStream(map);
            BufferedReader br = new BufferedReader((new InputStreamReader(is)));

            int col=0;
            int row=0;
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row]=num;
                    col++;
                }
                if(col ==gp.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }




    private void getTileImage() {
        try{ tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResource("/resField/Fieldd.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResource("/resField/City1.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResource("/resField/Road1.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResource("/resField/Monastery.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        int worldCol = (int) (gp.player.worldX - gp.player.screenX * 1.0 / gp.player.scale - gp.tileSize) / gp.tileSize + 1;
        if(worldCol<0) worldCol=0;
        int worldColl = (int) (gp.player.worldX - gp.player.screenX * 1.0 / gp.player.scale - gp.tileSize) / gp.tileSize + 1;
        if(worldColl<0) worldCol=0;


        int worldRow = (int) (gp.player.worldY - gp.player.screenY * 1.0 / gp.player.scale - gp.tileSize) / gp.tileSize + 1;
        if(worldRow<0) worldRow=0;
        int worldCol2 = (int) (gp.player.worldX + gp.player.screenX / gp.player.scale + gp.tileSize) / gp.tileSize ;
        if (worldCol2>71) worldCol2=71;
        int worldRow2 = (int) (gp.player.worldY + gp.player.screenY / gp.player.scale + gp.tileSize) / gp.tileSize;
        if(worldRow2>71) worldRow2=71;


       /* while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum=mapTileNum[worldCol][worldRow];
            int worldX = worldCol*gp.tileSize;
            int worldY = worldRow*gp.tileSize;
            int screenX=(int) ((worldX-gp.player.worldX)*gp.player.scale+gp.player.screenX) ;
            int screenY=(int) ((worldY-gp.player.worldY)*gp.player.scale+gp.player.screenY);

           if(worldX*1.0*gp.player.scale+gp.tileSize*gp.player.scale>gp.player.worldX*1.0*gp.player.scale-gp.player.screenX &&
                    worldX*1.0*gp.player.scale-gp.tileSize*gp.player.scale<gp.player.worldX*1.0*gp.player.scale+gp.player.screenX &&
                    worldY*1.0*gp.player.scale+gp.tileSize*gp.player.scale>gp.player.worldY*1.0*gp.player.scale-gp.player.screenY &&
                    worldY*1.0*gp.player.scale-gp.tileSize*gp.player.scale<gp.player.worldY*1.0*gp.player.scale+gp.player.screenY){
                g2.drawImage(tile[tileNum].image,screenX,screenY, (int) ((int) gp.tileSize*gp.player.scale), (int) (gp.tileSize*gp.player.scale),null);
            }

            worldCol++;

            if(worldCol==gp.maxWorldCol){
                worldCol=0;

                worldRow++;

            }
        }*/
        while (worldCol < worldCol2 && worldRow < worldRow2) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = (int) ((worldX - gp.player.worldX) * gp.player.scale + gp.player.screenX);
            int screenY = (int) ((worldY - gp.player.worldY) * gp.player.scale + gp.player.screenY);
            BufferedImage image = gp.images.get("Fieldd");

            g2.drawImage(image, screenX, screenY, (int) ((int) gp.tileSize * gp.player.scale), (int) (gp.tileSize * gp.player.scale), null);
           // offgc.drawImage(tile[tileNum].image, screenX, screenY, (int) ((int) gp.tileSize * gp.player.scale), (int) (gp.tileSize * gp.player.scale), null);
            worldCol++;
            if (worldCol == worldCol2) {
                worldCol = worldColl;
                worldRow++;
            }

        }



    }

}