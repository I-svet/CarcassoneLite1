package chipCard;

import chip.CLCard;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperChip {
    public BufferedImage image;
    public String name;
    public boolean collision;
    public int worldX,worldY;
    public int ont=0;
    public CLCard cLCard;
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = (int) ((worldX - gp.player.worldX) * gp.player.scale + gp.player.screenX);
        int screenY = (int) ((worldY - gp.player.worldY) * gp.player.scale + gp.player.screenY);

        if(worldX*1.0*gp.player.scale+gp.tileSize*gp.player.scale>gp.player.worldX*1.0*gp.player.scale-gp.player.screenX &&
                worldX*1.0*gp.player.scale-gp.tileSize*gp.player.scale<gp.player.worldX*1.0*gp.player.scale+gp.player.screenX &&
                worldY*1.0*gp.player.scale+gp.tileSize*gp.player.scale>gp.player.worldY*1.0*gp.player.scale-gp.player.screenY &&
                worldY*1.0*gp.player.scale-gp.tileSize*gp.player.scale<gp.player.worldY*1.0*gp.player.scale+gp.player.screenY){
            final double rads = Math.toRadians(90*ont);
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


            g2.drawImage(rotatedImage, screenX, screenY, (int) ((int) gp.tileSize * gp.player.scale), (int) (gp.tileSize * gp.player.scale), null);
          }

    }

}
