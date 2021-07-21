package Members.Players;

import Members.Player;
import javafx.scene.image.Image;

public class Archer extends Player {
    /**
     * constructor of the archer player class
     */
    public Archer(){
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
            setHP(300);
            setDamage(30);
        }else if (getLevel() == 2){
            setHP(350);
            setDamage(44);
        }else if (getLevel() == 3){
            setHP(400);
            setDamage(48);
        } else if (getLevel() == 4){
            setHP(450);
            setDamage(53);
        }else if (getLevel() == 5){
            setHP(500);
            setDamage(58);
        }

    }

}
