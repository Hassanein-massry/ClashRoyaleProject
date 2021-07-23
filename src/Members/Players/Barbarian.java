package Members.Players;
import Members.Player;
import javafx.scene.image.Image;

import java.io.IOException;

public class Barbarian extends Player {
    /**
     * constructor of the barbarian player card
     */
    public Barbarian() {
        try {
            readFromFile("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\barbarian.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        setType("barbarian");
        //setting all the information of the barbariana
        setImage(new Image("/Game/barbarian.jpg"));
        setHitSpeed(1500);
        setSpeed("Medium");
        setTarget("Ground");
        setRange("Melee");
        setAreaSplash(false);
        setCost(5);
        setCount(4);
        if (getLevel() == 1){
            setHP(900);
            setDamage(90);
        }else if (getLevel() == 2){
            setHP(1000);
            setDamage(95);
        }else if (getLevel() == 3){
            setHP(1100);
            setDamage(100);
        } else if (getLevel() == 4){
            setHP(1200);
            setDamage(120);
        }else if (getLevel() == 5){
            setHP(1300);
            setDamage(150);
        }

    }
}
