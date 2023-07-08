package chipCard;

import chip.CLCard;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chip_Card extends SuperChip {
    public Chip_Card(String name) {
        this.name=name;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resField/" + name + ".png"));

        } catch (IOException e) {
            e.printStackTrace();

        }
        switch (this.name) {
            case ("City1") :
                cLCard = new CLCard();
                cLCard.city1();
            case ("City2"):
                cLCard = new CLCard();
                cLCard.city2();






        }
    }


}
