package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

public class MiniPekka extends Player {
    public MiniPekka(){
        setImage(new Image("Game/mini.png"));
        setHitSpeed(1.8);
        setType("miniPekka");
        setSpeed("Fast");
        setTarget("Ground");
        setRange("Melee");
        setAreaSplash(false);
        setCount(1);
        setCost(4);
        if (getLevel() == 1){
            setHP(600);
            setDamage(325);
        }else if (getLevel() == 2){
            setHP(660);
            setDamage(357);
        }else if (getLevel() == 3){
            setHP(726);
            setDamage(393);
        } else if (getLevel() == 4){
            setHP(798);
            setDamage(432);
        }else if (getLevel() == 5){
            setHP(876);
            setDamage(474);
        }
    }
    }

