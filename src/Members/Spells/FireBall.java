package Members.Spells;

import Members.Spell;
import javafx.scene.image.Image;

public class FireBall extends Spell {
    public FireBall(){
        setType("fireBall");
        setRadius(2.5);
        setCost(4);
        setImage(new Image("Game/fireBall.png"));
        if (getLevel()==1){
            setDamageArea(325);
        }else if (getLevel()==2){
            setDamageArea(357);
        }
        else if (getLevel()==3){
            setDamageArea(393);
        }
        else if (getLevel()==4){
            setDamageArea(432);
        }
        else if (getLevel()==5){
            setDamageArea(474);
        }

    }
}
