package Members.Players;
import Members.Player;
import javafx.scene.image.Image;

public class Barbarian extends Player {
    /**
     * constructor of the barbarian player card
     */
    public Barbarian() {
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
            setHP(300);
            setDamage(75);
        }else if (getLevel() == 2){
            setHP(330);
            setDamage(82);
        }else if (getLevel() == 3){
            setHP(363);
            setDamage(90);
        } else if (getLevel() == 4){
            setHP(438);
            setDamage(99);
        }else if (getLevel() == 5){
            setHP(480);
            setDamage(109);
        }

    }
}
