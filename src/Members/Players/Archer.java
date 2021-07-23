package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

import java.io.IOException;

public class Archer extends Player {
    /**
     * constructor of the archer player class
     */
    public Archer()  {
        try {
            readFromFile("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\archer.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setType("archer");
        //setting all the proprieties of the archer player
        setImage(new Image("Game/archer.png"));
        setHitSpeed(1200);
        setSpeed("Medium");
        setTarget("Ground & Air");
        setRange("5");
        setAreaSplash(false);
        setCost(3);
        setCount(2);
        if (getLevel() == 1){
            setHP(400);
            setDamage(60);
        }else if (getLevel() == 2){
            setHP(450);
            setDamage(80);
        }else if (getLevel() == 3){
            setHP(500);
            setDamage(100);
        } else if (getLevel() == 4){
            setHP(550);
            setDamage(120);
        }else if (getLevel() == 5){
            setHP(600);
            setDamage(125);
        }

    }

}
