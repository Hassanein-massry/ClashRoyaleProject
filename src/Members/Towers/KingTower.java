package Members.Towers;

import Members.Tower;

public class KingTower extends Tower {
    public KingTower(){
        //setImage()
        setRange("7");
        setHitSpeed(1);
        if (getLevel() == 1){
            setHP(2400);
            setDamage(50);
        }else if (getLevel() == 2){
            setHP(2568);
            setDamage(53);
        }else if (getLevel() == 3){
            setHP(2736);
            setDamage(57);
        }else if (getLevel() == 4){
            setHP(2904);
            setDamage(60);
        }else if (getLevel() == 5){
            setHP(3096);
            setDamage(64);
        }
    }
}
