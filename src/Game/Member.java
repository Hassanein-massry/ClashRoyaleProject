package Game;

import Game.Location;
import Game.Model;
import javafx.scene.image.Image;

import java.util.concurrent.TimeUnit;

public class Member {
    public Member(){
        setLevel(1);
        setAlive(true);
        setHittingMode(false);
        setInRight(false);
    }

    public boolean isHittingMode() {
        return isHittingMode;
    }

    public void setHittingMode(boolean hittingMode) {
        isHittingMode = hittingMode;
    }

    private boolean isHittingMode;

    public boolean isTower() {
        return isTower;
    }

    public void setTower(boolean tower) {
        isTower = tower;
    }

    private boolean isTower ;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private boolean isAlive ;

    public boolean isInRight() {
        return inRight;
    }

    public void setInRight(boolean inRight) {
        this.inRight = inRight;
    }

    private boolean inRight ;


    private String type ;
    //define the speed of hit
    private double hitSpeed ;
    //define the target type
    private String target ;

    public boolean isEsnemie() {
        return isEsnemie;
    }

    public void setEsnemie(boolean esnemie) {
        isEsnemie = esnemie;
    }

    //define the case of ennemie in players
    boolean isEsnemie ;

    //define the range
    private String Range ;
    //define the life time of the spell
    private int lifeTime ;
    //define the cost of the spell
    private int cost ;
    //define the HP
    private int HP;
    //define the damage
    private int damage ;
    //define the level
    private int level = 0 ;
    //define the location
    private Location location ;
    //define the Image
    private Image image ;
    //the approximate speed
    private String speed ;
    //the target type
    private String Target ;
    //damage in a circle of radius 1
    private boolean isAreaSplash ;
    //the count of the player
    private int count ;
    //define the radius of damage
    private double radius ;
    //define the damage area
    private int  damageArea ;


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getDamageArea() {
        return damageArea;
    }

    public void setDamageArea(int damageArea) {
        this.damageArea = damageArea;
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    //define the image


    /**
     * get the level of spell
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

    public void setTheLocation (Location oldlocation ,Location newLocation, Model model){
        int oldRow = oldlocation.getX();
        int oldColumn = oldlocation.getY();
        int newRow = newLocation.getX();
        int newColumn = newLocation.getY();
            model.back[newRow][newColumn] = this;
            model.back[oldRow][oldColumn] = null;
         //   model.grid[oldRow][oldColumn] = Model.CellValue.GROUND;
            setLocation(newLocation);

        }


    /**
     * 'get the speed of hit
     * @return hitspeed
     */
    public double getHitSpeed() {
        return hitSpeed;
    }

    /**
     * set the speed of hit
     * @param hitSpeed
     */
    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    /**
     * get the target type
     * @return target
     */
    public String getTarget() {
        return target;
    }

    /**
     * set the target type
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * get the range
     * @return range
     */
    public String getRange() {
        return Range;
    }

    /**
     * set the range
     * @param range
     */
    public void setRange(String range) {
        Range = range;
    }

    /**
     * get the  life time
     * @return lifetime
     */
    public int getLifeTime() {
        return lifeTime;
    }

    /**
     * set the life time
     * @param lifeTime
     */
    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
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
     * get the HP
     * @return HP
     */
    public int getHP() {
        return HP;
    }

    /**
     * set the HP
     * @param HP
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * get the damage
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * set the damage
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }



    /**
     * getting the speed
     * @return speed
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * setting the speed
     * @param speed
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }




    /**
     * getting the area splash state
     * @return true or false
     */
    public boolean isAreaSplash() {
        return isAreaSplash;
    }

    /**
     * setting the area splash state
     * @param areaSplash
     */
    public void setAreaSplash(boolean areaSplash) {
        isAreaSplash = areaSplash;
    }

    /**
     * getting the count of the player
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * setting the count of the player
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * getting the cost of the player
     * @return cost
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void StartMyTurn(Model model) throws InterruptedException {
        while (isAlive==true){
            while (location.getX()<2) {
                int row = location.getX();
                int column = location.getY();
                if (model.grid[row + 1][column] == Model.CellValue.GROUND) {
                    setTheLocation(new Location(row,column) , new Location(row+1 , column) ,model);
                    row = row + 1;
                    switch (getSpeed()) {
                        case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                        case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                        case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);

                    }
                    break;
                }

            }

            while (location.getX() > 2) {
                int row = location.getX();
                int column = location.getY();
                if (model.grid[row - 1][column] == Model.CellValue.GROUND) {
                 setTheLocation(new Location(row-1,column) , new Location(row,column) ,model);
                    row = row - 1;

                    switch (getSpeed()) {
                        case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                        case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                        case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                    }
                }
            }
            break;
        }
    }


}

