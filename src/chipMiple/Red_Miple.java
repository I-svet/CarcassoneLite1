package chipMiple;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Red_Miple extends SuperMiple {
    public Red_Miple(){
        name = "red";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/resPlayer/red.png"));

        }catch(IOException e){
            e.printStackTrace();;
        }
    }
}
