package Members.Spells;

import Members.Spell;
import javafx.scene.image.Image;

import java.io.IOException;

public class FireBall extends Spell {
    public FireBall(){
        try {
            readFromFile("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\fireball.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setHP(1);
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
