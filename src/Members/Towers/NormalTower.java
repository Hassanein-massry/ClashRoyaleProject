package Members.Towers;

import Members.Tower;

public class NormalTower extends Tower {
    public NormalTower(){
        //setImage()
        setRange("7.5");
        setHitSpeed(0.8);
        if (getLevel() == 1){
            setHP(1400);
            setDamage(50);
        }else if (getLevel() == 2){
            setHP(1512);
            setDamage(54);
        }else if (getLevel() == 3){
            setHP(1624);
            setDamage(58);
        }else if (getLevel() == 4){
            setHP(1750);
            setDamage(62);
        }else if (getLevel() == 5){
            setHP(1890);
            setDamage(69);
        }
    }
}
