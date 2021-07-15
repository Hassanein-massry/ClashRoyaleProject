package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

public class Giant extends Player {
    public Giant(){
        setType("giant");
        setImage(new Image("Game/giant.png"));
        setHitSpeed(1.5);
        setSpeed("Slow");
        setTarget("Buildings");
        setRange("Melee");
        setAreaSplash(false);
        setCount(1);
        setCost(5);
        if (getLevel() == 1){
            setHP(2000);
            setDamage(126);
        }else if (getLevel() == 2){
            setHP(2200);
            setDamage(138);
        }else if (getLevel() == 3){
            setHP(2420);
            setDamage(152);
        } else if (getLevel() == 4){
            setHP(2660);
            setDamage(167);
        }else if (getLevel() == 5){
            setHP(2920);
            setDamage(189);
        }
    }
    }


