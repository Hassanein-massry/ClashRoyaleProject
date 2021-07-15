package Members.Buildings;

import Members.Building;
import javafx.scene.image.Image;

public class InfernoTower extends Building {
    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    private int damageMax ;
    public InfernoTower(){
        setType("infernoTower");
        setImage(new Image("Game/inferno.png"));
        setHitSpeed(0.4);
        setTarget("Ground & Air");
        setRange("6");
        setLifeTime(40);
        setCost(5);
        if (getLevel()==1){
            setHP(800);
            setDamage(20);
            setDamageMax(400);
        }else  if (getLevel()==2){
            setHP(880);
            setDamage(22);
            setDamageMax(440);
        }
        else  if (getLevel()==3){
            setHP(968);
            setDamage(24);
            setDamageMax(484);
        }
        else  if (getLevel()==4){
            setHP(1064);
            setDamage(26);
            setDamageMax(532);
        }
        else  if (getLevel()==5){
            setHP(1168);
            setDamage(29);
            setDamageMax(584);
        }
    }

}
