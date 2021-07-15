package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

public class Wizard extends Player {
        public Wizard(){
            setType("wizard");
            setImage(new Image("Game/wizard.png"));
            setHitSpeed(1.7);
            setSpeed("Medium");
            setTarget("Ground & Air");
            setRange("5");
            setAreaSplash(true);
            setCount(1);
            setCost(5);
            if (getLevel() == 1){
                setHP(340);
                setDamage(130);
            }else if (getLevel() == 2){
                setHP(174);
                setDamage(143);
            }else if (getLevel() == 3){
                setHP(411);
                setDamage(157);
            } else if (getLevel() == 4){
                setHP(452);
                setDamage(172);
            }else if (getLevel() == 5){
                setHP(496);
                setDamage(189);
            }
        }
    }


