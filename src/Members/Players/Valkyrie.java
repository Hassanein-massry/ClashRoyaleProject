package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

import java.io.IOException;

public class Valkyrie extends Player {
    public Valkyrie(){
        try {
            readFromFile("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\valkyrie.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setType("valkyrie");
        setImage(new Image("Game/valkirye.png"));
        setHitSpeed(1500);
        setSpeed("Medium");
        setTarget("Ground");
        setRange("Melee");
        setAreaSplash(true);
        setCount(1);
        setCost(4);
        if (getLevel() == 1){
            setHP(880);
            setDamage(120);
        }else if (getLevel() == 2){
            setHP(968);
            setDamage(132);
        }else if (getLevel() == 3){
            setHP(1064);
            setDamage(145);
        } else if (getLevel() == 4){
            setHP(1170);
            setDamage(159);
        }else if (getLevel() == 5){
            setHP(1284);
            setDamage(175);
        }
    }
    }
