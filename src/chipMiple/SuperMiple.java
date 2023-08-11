package chipMiple;

import chip.CLFieldPoint;
import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class SuperMiple {
    public BufferedImage image;
    public String name;
    public boolean collision;
    public int worldX,worldY;
    public int ont;
    public SuperMiple(){

    }

    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = (int) ((worldX - gp.getPlayer().worldX) * gp.getPlayer().scale + gp.getPlayer().screenX);
        int screenY = (int) ((worldY - gp.getPlayer().worldY) * gp.getPlayer().scale + gp.getPlayer().screenY);

        if(worldX*1.0*gp.getPlayer().scale+gp.tileSize*gp.getPlayer().scale>gp.getPlayer().worldX*1.0*gp.getPlayer().scale-gp.getPlayer().screenX &&
                worldX*1.0*gp.getPlayer().scale-gp.tileSize*gp.getPlayer().scale<gp.getPlayer().worldX*1.0*gp.getPlayer().scale+gp.getPlayer().screenX &&
                worldY*1.0*gp.getPlayer().scale+gp.tileSize*gp.getPlayer().scale>gp.getPlayer().worldY*1.0*gp.getPlayer().scale-gp.getPlayer().screenY &&
                worldY*1.0*gp.getPlayer().scale-gp.tileSize*gp.getPlayer().scale<gp.getPlayer().worldY*1.0*gp.getPlayer().scale+gp.getPlayer().screenY){
            Graphics2D g = (Graphics2D) g2;

        g2.drawImage(image, screenX, screenY, (int) ( gp.mipleSize * gp.getPlayer().scale), (int) (gp.mipleSize * gp.getPlayer().scale), null);

          }
    }
  /*  public static BufferedImage rotate(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - w) / 2, (newh - h) / 2);
        g.rotate(angle, w / 2, h / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return result;
    }
    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }*/
}
