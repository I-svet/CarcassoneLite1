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

   /* public void draw(Graphics2D g2, int gpPlayerWorldX,int gpPlayerWorldY,int gpPlayerScreenX,int gpPlayerScreenY, int gpPlayerScale,GamePanel gp) {

        int screenX = (int) ((worldX - gpPlayerWorldX) * gpPlayerScale + gpPlayerScreenX);
        int screenY = (int) ((worldY - gpPlayerWorldY) * gpPlayerScale + gpPlayerScreenY);

        if (worldX * 1.0 * gpPlayerScale + gp.tileSize * gpPlayerScale > gpPlayerWorldX * 1.0 * gpPlayerScale - gpPlayerScreenX &&
                worldX * 1.0 * gpPlayerScale - gp.tileSize * gpPlayerScale < gpPlayerWorldX * 1.0 * gpPlayerScale + gpPlayerScreenX &&
                worldY * 1.0 * gpPlayerScale + gp.tileSize * gpPlayerScale > gpPlayerWorldY * 1.0 * gpPlayerScale - gpPlayerScreenY &&
                worldY * 1.0 * gpPlayerScale - gp.tileSize * gpPlayerScale < gpPlayerWorldY * 1.0 * gpPlayerScale + gpPlayerScreenY) {
            final double rads = Math.toRadians(90 * ont);
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
            rotateOp.filter(image, rotatedImage);


            g2.drawImage(rotatedImage, screenX, screenY, (int) ((int) gp.tileSize * gpPlayerScale), (int) (gp.tileSize * gpPlayerScale), null);
        }


    }*/


}
