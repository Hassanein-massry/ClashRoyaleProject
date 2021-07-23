package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

import java.io.IOException;

public class BabyDragon extends Player {
    public BabyDragon(){
        try {
            readFromFile("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\dragon.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setType("babyDragon");
        setImage(new Image("Game/babyDragon.png"));
        setHitSpeed(1800);
        setSpeed("Fast");
        setTarget("Ground & Air");
        setRange("3");
        setAreaSplash(true);
        setCount(1);
        setCost(4);
        if (getLevel() == 1){
            setHP(800);
            setDamage(100);
        }else if (getLevel() == 2){
            setHP(880);
            setDamage(110);
        }else if (getLevel() == 3){
            setHP(968);
            setDamage(121);
        } else if (getLevel() == 4){
            setHP(1064);
            setDamage(133);
        }else if (getLevel() == 5){
            setHP(1168);
            setDamage(146);
        }
    }
}
