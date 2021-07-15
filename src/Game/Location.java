package Game;

/**
 * the location class is the class that specify the current locstion of some member of the game
 * it has 2 parameter
 * x that implie to the row number of the member
 * y that imply to the column number of the member
 */
public class Location {
    //define the row number
    private int x ;
    //defeine the column number
    private int y ;

    /**
     * get the row number
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * set the row number of the member
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get the column number
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * set the column number
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    public Location(int x, int y){
        this.x=x ;
        this.y=y;
    }

    /**
     * check if two location are equals
     * @param location
     * @return true or false
     */
    public boolean equals(Location location){
    if (location.getX() == x  && location.getY() ==y)
        return true ;
    else
        return false;

    }
}
