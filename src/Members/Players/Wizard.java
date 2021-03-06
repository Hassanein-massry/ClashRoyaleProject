package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

import java.io.IOException;

public class Wizard extends Player {
        public Wizard(){
            try {
                readFromFile("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\wizard.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            setType("wizard");
            setImage(new Image("Game/wizard.png"));
            setHitSpeed(1700);
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


