package Members.Spells;

import Game.Location;
import javafx.scene.image.Image;

public class Rage {
    //define the level
    private int level = 0 ;
    private double radius ;
    private int cost ;
    private double duration ;

    /**
     * get the image
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     * set the image
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    private Image image ;

    /**
     * get the location
     * @return location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * set the location
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    private Location location;

    /**
     * get the level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * set the level
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * get the radius of damage
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * set the radius of damage
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * get the cost
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * set the cost
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * get the area of damage
     * @return aera of damage
     */
    public double getDuration() {
        return duration;
    }

    /**
     * set the area of damage
     * @param Duration
     */
    public void setDuration(double Duration) {
        duration = Duration;
    }


    /**
     * the constructor
     */
    public Rage(){

      //  setImage(new Image("Game/"));
        setRadius(2.5);
        setCost(4);
        if (level ==1 ){
            setDuration(6);
        }else if (level == 2){
            setDuration(6.5);
        }else if(level==3){
            setDuration(7);
        }else if (level==4){
            setDuration(7.5);
        }else if(level==5){
            setDuration(8);
        }
    }

}
