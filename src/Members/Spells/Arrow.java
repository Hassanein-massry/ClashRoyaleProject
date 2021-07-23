package Members.Spells;

import Members.Spell;
import javafx.scene.image.Image;

import java.io.IOException;

public class Arrow extends Spell {
    public Arrow(){
        try {
            readFromFile("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\arrows.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setHP(1);
        setType("arrow");
        setRadius(4);
        setCost(3);
        setImage(new Image("Game/fireBall.png"));
        if (getLevel()==1){
            setDamageArea(144);
        }else if (getLevel()==2){
            setDamageArea(156);
        }
        else if (getLevel()==3){
            setDamageArea(174);
        }
        else if (getLevel()==4){
            setDamageArea(189);
        }
        else if (getLevel()==5){
            setDamageArea(210);
        }
    }
}
