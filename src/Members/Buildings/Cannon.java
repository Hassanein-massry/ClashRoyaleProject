package Members.Buildings;

import Members.Building;
import javafx.scene.image.Image;

import javax.imageio.IIOImage;

public class Cannon extends Building {
    public Cannon(){
        setType("cannon");
        setImage(new Image("Game/cannon.jpeg"));
        setHitSpeed(0.8);
        setTarget("Ground");
        setRange("5.5");
        setLifeTime(30);
        setCost(6);
        if (getLevel()==1){
            setHP(380);
            setDamage(60);
        }else  if (getLevel()==2){
            setHP(418);
            setDamage(66);
        }
        else  if (getLevel()==3){
            setHP(549);
            setDamage(72);
        }
        else  if (getLevel()==4){
            setHP(505);
            setDamage(79);
        }
        else  if (getLevel()==5){
            setHP(554);
            setDamage(87);
        }

    }
}
