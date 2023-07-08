package main;

import chip.CLCard;
import chip.CLField;
import chip.CLFieldPoint;
import chipCard.Chip_Card;
import chipCard.SuperChip;
import chipMiple.Red_Miple;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){this.gp=gp;}
    public void setObject(GamePanel gp){
        gp.chip[0]=new Chip_Card("City1");
        gp.chip[0].worldX= 23*gp.tileSize;
        gp.chip[0].worldY= 23*gp.tileSize;
        gp.chip[0].ont = gp.player.ont;

        gp.chip[1]=new Chip_Card("City1");
        gp.chip[1].worldX= 22*gp.tileSize;
        gp.chip[1].worldY= 22*gp.tileSize;
        gp.chip[1].ont = gp.player.ont;

        gp.chip[2]=new Chip_Card("City1");
        gp.chip[2].worldX= 35*gp.tileSize;
        gp.chip[2].worldY= 35*gp.tileSize;
        gp.chip[2].ont = gp.player.ont;

        gp.miple[0] = new Red_Miple();
        gp.miple[0].worldX= 22*gp.tileSize;
        gp.miple[0].worldY= 22*gp.tileSize;
        gp.miple[1] = new Red_Miple();
        gp.miple[1].worldX = 23*gp.tileSize;
        gp.miple[1].worldY = 23*gp.tileSize+gp.tileSize/2-gp.mipleSize/2;

      //  gp.clField.addCard(22*gp.tileSize,22*gp.tileSize,new CLCard().city1(), CLFieldPoint.Orientation.A);
        try {
            gp.images.put("Fieldd", ImageIO.read(getClass().getResource("/resField/Fieldd.png")));
            gp.images.put("City1_0", ImageIO.read(getClass().getResource("/resField/City1_0.png")));
            gp.images.put("City1_1", ImageIO.read(getClass().getResource("/resField/City1_1.png")));
            gp.images.put("City1_2", ImageIO.read(getClass().getResource("/resField/City1_2.png")));
            gp.images.put("City1_3", ImageIO.read(getClass().getResource("/resField/City1_3.png")));
            gp.images.put("City2_0", ImageIO.read(getClass().getResource("/resField/City2_0.png")));
            gp.images.put("City2_1", ImageIO.read(getClass().getResource("/resField/City2_1.png")));
            gp.images.put("City2_2", ImageIO.read(getClass().getResource("/resField/City2_2.png")));
            gp.images.put("City2_3", ImageIO.read(getClass().getResource("/resField/City2_3.png")));
            gp.images.put("City3_0", ImageIO.read(getClass().getResource("/resField/City3_0.png")));
            gp.images.put("City3_1", ImageIO.read(getClass().getResource("/resField/City3_1.png")));
            gp.images.put("City3_2", ImageIO.read(getClass().getResource("/resField/City3_2.png")));
            gp.images.put("City3_3", ImageIO.read(getClass().getResource("/resField/City3_3.png")));
            gp.images.put("City4_0", ImageIO.read(getClass().getResource("/resField/City4_0.png")));
            gp.images.put("City4_1", ImageIO.read(getClass().getResource("/resField/City4_1.png")));
            gp.images.put("City4_2", ImageIO.read(getClass().getResource("/resField/City4_2.png")));
            gp.images.put("City4_3", ImageIO.read(getClass().getResource("/resField/City4_3.png")));
            gp.images.put("City5_0", ImageIO.read(getClass().getResource("/resField/City5_0.png")));
            gp.images.put("City5_1", ImageIO.read(getClass().getResource("/resField/City5_1.png")));
            gp.images.put("City5_2", ImageIO.read(getClass().getResource("/resField/City5_2.png")));
            gp.images.put("City5_3", ImageIO.read(getClass().getResource("/resField/City5_3.png")));
            gp.images.put("CityCornerCHF_0", ImageIO.read(getClass().getResource("/resField/CityCornerCHF_0.png")));
            gp.images.put("CityCornerCHF_1", ImageIO.read(getClass().getResource("/resField/CityCornerCHF_1.png")));
            gp.images.put("CityCornerCHF_2", ImageIO.read(getClass().getResource("/resField/CityCornerCHF_2.png")));
            gp.images.put("CityCornerCHF_3", ImageIO.read(getClass().getResource("/resField/CityCornerCHF_3.png")));
            gp.images.put("Monastery_0", ImageIO.read(getClass().getResource("/resField/Monastery_0.png")));
            gp.images.put("Monastery_1", ImageIO.read(getClass().getResource("/resField/Monastery_1.png")));
            gp.images.put("Monastery_2", ImageIO.read(getClass().getResource("/resField/Monastery_2.png")));
            gp.images.put("Monastery_3", ImageIO.read(getClass().getResource("/resField/Monastery_3.png")));
            gp.images.put("Road1_0", ImageIO.read(getClass().getResource("/resField/Road1_0.png")));
            gp.images.put("Road1_1", ImageIO.read(getClass().getResource("/resField/Road1_1.png")));
            gp.images.put("Road1_2", ImageIO.read(getClass().getResource("/resField/Road1_2.png")));
            gp.images.put("Road1_3", ImageIO.read(getClass().getResource("/resField/Road1_3.png")));
            gp.images.put("Road2_0", ImageIO.read(getClass().getResource("/resField/Road2_0.png")));
            gp.images.put("Road2_1", ImageIO.read(getClass().getResource("/resField/Road2_1.png")));
            gp.images.put("Road2_2", ImageIO.read(getClass().getResource("/resField/Road2_2.png")));
            gp.images.put("Road2_3", ImageIO.read(getClass().getResource("/resField/Road2_3.png")));
            gp.images.put("Road3_0", ImageIO.read(getClass().getResource("/resField/Road3_0.png")));
            gp.images.put("Road3_1", ImageIO.read(getClass().getResource("/resField/Road3_1.png")));
            gp.images.put("Road3_2", ImageIO.read(getClass().getResource("/resField/Road3_2.png")));
            gp.images.put("Road3_3", ImageIO.read(getClass().getResource("/resField/Road3_3.png")));
            gp.images.put("Road4_0", ImageIO.read(getClass().getResource("/resField/Road4_0.png")));
            gp.images.put("Road4_1", ImageIO.read(getClass().getResource("/resField/Road4_1.png")));
            gp.images.put("Road4_2", ImageIO.read(getClass().getResource("/resField/Road4_2.png")));
            gp.images.put("Road4_3", ImageIO.read(getClass().getResource("/resField/Road4_3.png")));
            gp.images.put("Road5_0", ImageIO.read(getClass().getResource("/resField/Road5_0.png")));
            gp.images.put("Road5_1", ImageIO.read(getClass().getResource("/resField/Road5_1.png")));
            gp.images.put("Road5_2", ImageIO.read(getClass().getResource("/resField/Road5_2.png")));
            gp.images.put("Road5_3", ImageIO.read(getClass().getResource("/resField/Road5_3.png")));
            gp.images.put("RoadCity1_0", ImageIO.read(getClass().getResource("/resField/RoadCity1_0.png")));
            gp.images.put("RoadCity1_1", ImageIO.read(getClass().getResource("/resField/RoadCity1_1.png")));
            gp.images.put("RoadCity1_2", ImageIO.read(getClass().getResource("/resField/RoadCity1_2.png")));
            gp.images.put("RoadCity1_3", ImageIO.read(getClass().getResource("/resField/RoadCity1_3.png")));
            gp.images.put("RoadCity2_0", ImageIO.read(getClass().getResource("/resField/RoadCity2_0.png")));
            gp.images.put("RoadCity2_1", ImageIO.read(getClass().getResource("/resField/RoadCity2_1.png")));
            gp.images.put("RoadCity2_2", ImageIO.read(getClass().getResource("/resField/RoadCity2_2.png")));
            gp.images.put("RoadCity2_3", ImageIO.read(getClass().getResource("/resField/RoadCity2_3.png")));
            gp.images.put("RoadCity3_0", ImageIO.read(getClass().getResource("/resField/RoadCity3_0.png")));
            gp.images.put("RoadCity3_1", ImageIO.read(getClass().getResource("/resField/RoadCity3_1.png")));
            gp.images.put("RoadCity3_2", ImageIO.read(getClass().getResource("/resField/RoadCity3_2.png")));
            gp.images.put("RoadCity3_3", ImageIO.read(getClass().getResource("/resField/RoadCity3_3.png")));
            gp.images.put("RoadCity4_0", ImageIO.read(getClass().getResource("/resField/RoadCity4_0.png")));
            gp.images.put("RoadCity4_1", ImageIO.read(getClass().getResource("/resField/RoadCity4_1.png")));
            gp.images.put("RoadCity4_2", ImageIO.read(getClass().getResource("/resField/RoadCity4_2.png")));
            gp.images.put("RoadCity4_3", ImageIO.read(getClass().getResource("/resField/RoadCity4_3.png")));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }









    }
    /*public void setDeck(GamePanel gp){
        gp.deck.add(new Chip_Card("City1"));
        gp.deck.add(new Chip_Card("City1"));
    }*/

}
