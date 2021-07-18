package Game;

import Members.Buildings.Cannon;
import Members.Buildings.InfernoTower;
import Members.Player;
import Members.Players.*;
import Members.Spells.Arrow;
import Members.Spells.FireBall;
import Members.Towers.KingTower;
import Members.Towers.NormalTower;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.concurrent.TimeUnit;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class View extends Group {
    public enum cards{
        CANNON ,INFERNOTOWER , ARCHER , BABYDRAGON, BARBARIAN , GIANT , MINIPEKKA , VALKYRIE , WIZARD , ARROW , FIREBALL ,RAGE
    }
    //the existing counter of cards in the hand of player
    private int existingCard = 0 ;
    //the list of cards
    private ArrayList<String> myCards= new ArrayList<>();
    //the width of every cell in the scene
    final static double CELL_WIDTH = 50;
    private int rowCount ;
    private int columnCount ;


    public int getExir() {
        return exir;
    }

    public void setExir(int exir) {
        this.exir = exir;
    }

     int exir = 0;
    //define all images
    private Image ground;
    private Image limit ;
    private Image archer ;
    private Image Deck ;
    private Image cannon ;
    private Image infernoTower;
    private Image babyDragon ;
    private Image barbarian ;
    private Image giant ;
    private Image miniPekka;
    private Image valkyrie;
    private Image wizard ;
    private Image arrow;
    private Image rage ;
    private Image fireBall ;
    private Image BlueKing ;
    private Image RedKing ;
    private Image Princess;
    private Image HittingGiant;
    private Image HittingArcher ;
    private Image HittingWizard ;
    private Image HittingValk;
    private Image HittingDragon;
    private Image HittingBarb;
    private Image HittingMini;
    private Image princessRight ;
    private Image ExirOne;
    private Image ExirTwo;
    private Image ExirThree;
    private Image ExirFour;
    private Image ExirFive;

    private TextField textField ;
    private Image tempImage ;
    private Image kingRight ;
    private Model model = new Model();
    //all the image views of all images in the scene
    private ImageView [][] cells;
    //a temp variable for saving a cell value
    private Model.CellValue tempCellValue ;
    private GridPane gridPane ;
    private int counter = 0 ;
    private int counter2=0 ;
    private int firstTowerHP=0 ;
    private int SecondTowerHP =0;
    private int counter3 =0;

    /**
     * constructor
     * @throws FileNotFoundException
     * @throws InterruptedException
     */

    public View() throws FileNotFoundException, InterruptedException {
        //get all the images of players and buildings
        this.BlueKing = new Image("Game/king left.gif");
        this.RedKing = new Image("Game/redKing.jpg");
        this.Princess = new Image("Game/princess.jpg");
        this.ground = new Image("Game/ground.jpg");
        this.limit = new Image("Game/limit.png");
        this.archer = new Image("Game/archer walking left.gif");
        this.Deck = new Image("Game/inferno.png");
        this.cannon = new Image("Game/cannon.jpeg");
        this.infernoTower = new Image("Game/inferno.png");
        this.babyDragon = new Image("Game/dragon flying left.gif");
        this.barbarian = new Image("Game/barb walking left.gif");
        this.giant = new Image("Game/giant walking left.gif");
        this.miniPekka = new Image("Game/mini walking left.gif");
        this.valkyrie = new Image("Game/valk walking left.gif");
        this.wizard = new Image("Game/wizard walking left.gif");
        this.arrow = new Image("Game/arrows.png");
        this.fireBall = new Image("Game/fireBall.png");
        this.tempImage = new Image("Game/arrows.png") ;
        this.HittingGiant =  new Image("Game/giant hiting left.gif");
        this.HittingValk = new Image("Game/valk hitting left.gif");
        this.HittingArcher = new Image("Game/archer hitting left.gif");
        this.HittingBarb = new Image("Game/barb hitting left.gif");
        this.HittingDragon = new Image("Game/dragon hitting left.gif");
        this.HittingWizard = new Image("Game/wizard hitting left.gif");
        this.HittingMini = new Image("Game/mini hitting left.gif");
        this.princessRight = new Image("Game/archer tower right.gif");
        this.kingRight = new Image("Game/king right.gif");
        this.ExirOne = new Image("Game/first.jpg");
        this.ExirTwo = new Image("Game/second.jpg");
        this.ExirThree = new Image("Game/three.jpg");
        this.ExirFour = new Image("Game/four.jpg");
        this.ExirFive = new Image("Game/five.jpg");
        //add all the names of cards to the cards array list
        myCards.add("cannon");
        myCards.add("inferno tower");
        myCards.add("archer");
        myCards.add("baby dragon");
        myCards.add("barbarian");
        myCards.add("giant");
        myCards.add("mini pekka");
        myCards.add("valkyrie");
        myCards.add("wizard");
        myCards.add("arrow");
        myCards.add("fireBall");
        //this.king = new Image("Game/king.jpg");
        initialize();
        // cells[0][0].setImage(image);
    }

    public void initialize (){
        System.out.println("initializing");
        //the count of the rows and columns of the images
        rowCount = 13;
        columnCount = 22 ;
        //make the array of the images view
        cells = new ImageView[rowCount][columnCount];
       // gridPane = new GridPane();
       // Label label = new Label();
       // javafx.scene.control.TextField textField = new javafx.scene.control.TextField();
       // gridPane.add(textField,100,120);
        //setting upp the initial conditions
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                ImageView imageView = new ImageView();
                imageView.setX(column * CELL_WIDTH);
                imageView.setY(row * CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                cells[row][column] = imageView;
                this.getChildren().add(imageView);
            }
        }
        new Thread(ExirRunnable).start();


    }

    public void secondUpdate() throws InterruptedException {
        model.update();

    }

    /**
     * update of the map every second
     * @throws InterruptedException
     */
    public void update() throws InterruptedException {

        //new Thread(ExirRunnable).start();
        model.update();
        System.out.println("updating");
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Model.CellValue value = model.getCellValue(row,column);
                if(model.back[row][column]!=null)
                if (model.back[row][column].getHP()<=0){
                    model.back[row][column]=null;
                    model.grid[row][column] = Model.CellValue.GROUND;
                    model.grid[row][column] = Model.CellValue.GROUND;
                }
                //   System.out.println(value);


                if (value == Model.CellValue.GROUND) {
                    cells[row][column].setImage(ground);
                    int row2 = row;
                    int column2 = column;
                    //on mouse click condition for the ground
                    cells[row][column].setCursor(Cursor.HAND );
                    if (column<11 && column >5)
                    cells[row][column].setOnMouseClicked(mouseEvent -> {
                        if (tempCellValue == null)
                            System.out.println("kaka");
                        else{
                            model.grid[row2][column2] = tempCellValue;
                           // System.out.println(":><   " +model.grid[row2][column2]);
                            try {
                                makeNewPlayer(tempCellValue , new Location(row2,column2));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            tempCellValue = null;
                        }
                    });
                }
                model.update();
                if (value == Model.CellValue.LIMIT) {
                    cells[row][column].setImage(limit);
                } if (value == Model.CellValue.CANNON){
                    cells[row][column].setImage(cannon);
                } if (value == Model.CellValue.INFERNO){
                    cells[row][column].setImage(infernoTower);
                } if (value == Model.CellValue.ARROW){
                    cells[row][column].setImage(arrow);
                } if (value == Model.CellValue.BABYDRAGON){
                    cells[row][column].setImage(babyDragon);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(HittingDragon);
                } if (value == Model.CellValue.BARBARIAN){
                    cells[row][column].setImage(barbarian);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(HittingBarb);
                } if (value == Model.CellValue.GIANT ){
                    cells[row][column].setImage(giant);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(HittingGiant);
                //    GoToTheTarget(row , column , new Giant());

                } if (value == Model.CellValue.FIREBALL){
                    cells[row][column].setImage(fireBall);
                } if (value == Model.CellValue.MINIPEKKA){
                    cells[row][column].setImage(miniPekka);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(HittingMini);
                } if (value == Model.CellValue.WIZARD){
                    cells[row][column].setImage(wizard);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(HittingWizard);
                }
                if (value == Model.CellValue.VALKYRIE){
                    cells[row][column].setImage(valkyrie);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(HittingValk);
                } if (value == Model.CellValue.RAGE){
                    cells[row][column].setImage(cannon);
                } if (value == Model.CellValue.EMPTY){
                    cells[row][column].setImage(null);
                }
                if(value == Model.CellValue.ENNEMIEPRINCESS){
                   // cells[row][column].setImage(Princess);
                   // if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                      //  cells[row][column].setImage(princessRight);
                    NormalTower normalTower = new NormalTower();
                    normalTower.setEsnemie(true);
                    model.back[row][column] = normalTower;

                    //new Thread(runnable1).start();
                  //  ShlickTowerEnnemie(finalRow1,finalColumn1);
                }

                if (value== Model.CellValue.BLUEKING)
                    cells[row][column].setImage(BlueKing);
                if (value == Model.CellValue.REDKING){
                    //cells[row][column].setImage(kingRight);
                    //if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                      //  cells[row][column].setImage(HittingDragon);
                    KingTower kingTower = new KingTower();
                    kingTower.setEsnemie(true);
                    model.back[row][column]=kingTower;
                    kingTower.setLocation(new Location(row,column));

                }
                if (value == Model.CellValue.PRINCESS)
                    cells[row][column].setImage(Princess);
                if (value == Model.CellValue.ARCHER) {
                    cells[row][column].setImage(archer);
                } if(column == 0){
                    if (row==0 ||row==2 |row==4 ||row==6){
                        final int row1 = row;
                        final int column1 = column;
                        int a=new Random().nextInt(myCards.size());
                        String string = myCards.get(a);
                      //  System.out.println("                "+string);
                    //    System.out.println(existingCard);
                        cells[row][column].setCursor(Cursor.HAND );
                        //set the conditin on mouse click for the deck cards case
                        cells[row][column].setOnMouseClicked(mouseEvent -> {
                            int cost = 0;
                            switch (model.getCellValue(row1, column1)) {
                                case ARROW -> cost = new Arrow().getCost();
                                case CANNON -> cost = new Cannon().getCost();
                                case INFERNO -> cost = new InfernoTower().getCost();
                                case ARCHER -> cost = new Archer().getCost();
                                case BABYDRAGON -> cost = new BabyDragon().getCost();
                                case BARBARIAN -> cost = new Barbarian().getCost();
                                case GIANT -> cost = new Giant().getCost();
                                case MINIPEKKA -> cost = new MiniPekka().getCost();
                                case VALKYRIE -> cost = new Valkyrie().getCost();
                                case WIZARD -> cost = new Wizard().getCost();
                                case FIREBALL -> cost = new FireBall().getCost();

                            }
                            System.out.println(cost+" exir "+ exir);
                            if (cost <= exir){
                                exir-=cost;
                                this.tempCellValue = model.getCellValue(row1, column1);
                            cells[row1][column1].setImage(null);
                            //   System.out.println(" >>>>>> " + tempCellValue);
                            model.grid[row1][column1] = Model.CellValue.EMPTY;
                            existingCard--;
                        } });
                        if (existingCard<4 && cells[row][column].getImage()==null)
                        {
                          //  System.out.println("A >> ...   "+a);
                            if (string.equals("cannon"))
                                //cells[row][column].setImage(cannon);
                                model.grid[row][column] = Model.CellValue.CANNON;
                            if (string.equals("inferno tower"))
                                model.grid[row][column] = Model.CellValue.INFERNO;
                            if (string.equals("archer"))
                                model.grid[row][column] = Model.CellValue.ARCHER;
                            if (string.equals("baby dragon"))
                                model.grid[row][column] = Model.CellValue.BABYDRAGON;
                            if (string.equals("barbarian"))
                                model.grid[row][column] = Model.CellValue.BARBARIAN;
                            if (string.equals("giant"))
                                model.grid[row][column] = Model.CellValue.GIANT;
                            if (string.equals("mini pekka"))
                                model.grid[row][column] = Model.CellValue.MINIPEKKA;
                            if (string.equals("valkyrie"))
                                model.grid[row][column] = Model.CellValue.VALKYRIE;
                            if (string.equals("wizard"))
                                model.grid[row][column] = Model.CellValue.WIZARD;
                            if (string.equals("arrow"))
                                model.grid[row][column] = Model.CellValue.ARROW;
                            if (string.equals("fireBall"))
                                model.grid[row][column] = Model.CellValue.FIREBALL;
                            if (string.equals("Rage"))
                                model.grid[row][column] = Model.CellValue.RAGE;
                            existingCard++;}

                    }}

            }


        }
if (counter==0){
    firstTowerHP = model.back[2][17].getHP();
    SecondTowerHP = model.back[8][17].getHP();
    new Thread(TowerRunnable).start();
    new Thread(TowersecondRunnable).start();
    counter++;
}

Runnable runnable =  new Runnable() {
    @Override
    public void run() {
        try {
            ShlickKingTowerEnnemie(5,19);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};

if (model.back[2][17]==null || model.back[8][17]==null){
    if (counter2==0){
    new Thread(runnable).start();
    counter2++;}
}
    }




    public void GoToTheTarget(int row , int column , Player player) throws InterruptedException {
        switch (player.getSpeed()) {
            case "Fast" -> Thread.sleep(50);
            case "Medium" -> Thread.sleep(100);
            case "Slow" -> Thread.sleep(200);
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if (row < 2){
                    Model.CellValue cellValue = model.grid[row][column];
                    if (model.grid[row+1][column] == Model.CellValue.GROUND){
                        model.grid[row+1][column] = cellValue;
                        model.grid[row][column] = Model.CellValue.GROUND;
                        model.grid[row][column] = Model.CellValue.GROUND;
                        cells[row][column].setImage(ground);
                        cells[row][column].setImage(ground);
                        cells[row+1][column].setImage(player.getImage());


                    }
                }else if (row >2){
                    Model.CellValue cellValue = model.grid[row][column];
                    if (model.grid[row-1][column] == Model.CellValue.GROUND){
                        cells[row][column].setImage(ground);
                        cells[row][column].setImage(ground);
                        model.grid[row-1][column] = cellValue;
                        model.grid[row][column] = Model.CellValue.GROUND;
                        model.grid[row][column] = Model.CellValue.GROUND;
                        cells[row][column].setImage(ground);
                        cells[row-1][column].setImage(player.getImage());


                    }
                }else if (column+1<18 && column!=0){
                    Model.CellValue cellValue = model.grid[row][column];
                    if (model.grid[row][column+1] == Model.CellValue.GROUND){
                        cells[row][column].setImage(ground);
                        cells[row][column].setImage(ground);
                        model.grid[row][column+1] = cellValue;
                        model.grid[row][column] = Model.CellValue.GROUND;
                        cells[row][column].setImage(ground);
                        cells[row][column].setImage(ground);
                        cells[row][column+1].setImage(player.getImage());

                    }
                }
                Thread.currentThread().stop();
            }

        };
       // Thread.sleep(100);
        Thread thread =new Thread(runnable);
        thread.start();
     //   TimeUnit.SECONDS.sleep(1);
       // Thread.sleep(100);



    }
    public void copyTheInfo(ImageView imageView){
        this.tempImage = null;
        tempImage = imageView.getImage();
        if (tempImage == null)
            System.out.println("kaka");
        imageView.setImage(null);
        existingCard--;
    }

    public void makeNewPlayer(Model.CellValue cellValue , Location location) throws InterruptedException {
        int flag = 0;
        final int X = location.getX() ;
        final int Y = location.getY();
      //  model.back[X][Y].setEsnemie(false);
        if (cellValue == Model.CellValue.ARCHER){
            Archer archer = new Archer();
            archer.setLocation(location);
            model.back[X][Y] = archer;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+model.back[X][Y].getType());
        }
        if (cellValue == Model.CellValue.ARROW){
            flag=1;
            Arrow arrow = new Arrow();
            arrow.setLocation(location);
            model.back[X][Y] = arrow;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }
        if (cellValue == Model.CellValue.BABYDRAGON){
             BabyDragon babyDragon = new BabyDragon();
            babyDragon.setLocation(location);
            model.back[X][Y] = babyDragon;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }
        if (cellValue == Model.CellValue.BARBARIAN){
            Barbarian barbarian = new Barbarian();
            barbarian.setLocation(location);
            model.back[X][Y] = barbarian;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }
        if (cellValue == Model.CellValue.CANNON){
            flag=1;
             Cannon cannon = new Cannon();
            cannon.setLocation(location);
            model.back[X][Y] = cannon;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }if (cellValue == Model.CellValue.FIREBALL){
            flag=1;
            FireBall fireBall = new FireBall();
            fireBall.setLocation(location);
            model.back[X][Y] = fireBall;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }if (cellValue == Model.CellValue.GIANT){
            Giant giant = new Giant();
            giant.setLocation(location);
            model.back[X][Y] = giant;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }if (cellValue == Model.CellValue.INFERNO){
            flag=1;
            InfernoTower infernoTower = new InfernoTower();
            infernoTower.setLocation(location);
            model.back[X][Y] = infernoTower;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }if (cellValue == Model.CellValue.MINIPEKKA){
            MiniPekka miniPekka = new MiniPekka();
            miniPekka.setLocation(location);
            model.back[X][Y] = miniPekka;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }if (cellValue == Model.CellValue.VALKYRIE){
            Valkyrie valkyrie = new Valkyrie();
            valkyrie.setLocation(location);
            model.back[X][Y] = valkyrie;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }if (cellValue == Model.CellValue.WIZARD){
            Wizard wizard = new Wizard();
            wizard.setLocation(location);
            model.back[X][Y] = wizard;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }
    //    model.back[X][Y].StartMyTurn(model);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    moveThePlayer(X , Y, model.back[X][Y]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        if (flag!=1)
        new Thread(runnable).start();


        model.update();
    }

 public void moveThePlayer(int temprow , int tempcolumn , Member member) throws InterruptedException {
        if (member!=null){
            int row = temprow ;
            int column = tempcolumn ;
        int i = 1 ;
        int j = 1;
        int z = 1 ;
        int currentX = 0 , currentY = 0 ;
            System.out.println("Alive" + member.isAlive());
        while (member.isAlive()) {
            if (Math.abs(row-2)<=Math.abs(8-row))
            moveToTheFirstTower(row,column,member);
            else
                moveToTheSecondTower(row,column,member);
            moveToTheKingTower(member);
            if (member.getHP()<=0) { ;
                member.setAlive(false);
                System.out.println(member.getType()+"yes");
            }

        }


    }}

    public void Shlick(int row , int column , int row1 , int column1 ) throws InterruptedException {
        int HP = 0;
        int flag = 0;
        if (row1==2 && column1==17){
            HP = firstTowerHP;
            flag=1;
        }
        else if (row1==8 && column1 ==17){
            HP =SecondTowerHP;
        flag=2;}
        else {HP = model.back[row1][column1].getHP();
        flag=3;}
        model.back[row][column].setHittingMode(true);

        System.out.println(">   >   >  "+HP);
        int damage = model.back[row][column].getDamage();
        int speedOfHit = (int)model.back[row][column].getHitSpeed();
        while (model.back[row1][column1] !=null && model.back[row1][column1].getHP()>0 &&model.back[row][column]!=null &&HP>0){
            model.back[row1][column1].setHP(HP-damage);
            System.out.println("fuck"+model.back[row1][column1].getHP());
            HP=HP-damage;
            switch (flag){
                case 1-> firstTowerHP = HP;
                case 2->SecondTowerHP =HP;
            }
            TimeUnit.MILLISECONDS.sleep(speedOfHit);
        }
        if (model.back[row][column]!=null)
        model.back[row][column].setHittingMode(false);
        model.back[row1][column1].setHP(HP);
        //model.back[row1][column1] = model.back[row][column];
        //model.back[row][column]= null;
        //model.grid[row][column]= Model.CellValue.GROUND;
    }
    public void moveToY(int row , int column ,Member member) throws InterruptedException {
        int z=1;
        if (member!=null){
        while (column+z<18){
            if (model.grid[row][column+1] == Model.CellValue.GROUND){
            model.back[row][column+z] = model.back[row][column+z-1];
            model.grid[row][column+z-1]= Model.CellValue.GROUND;
            model.back[row][column+z-1] = null;
            z++;
            switch (member.getSpeed()){
                case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
            }
    }
        else
        break;}}
    }

Runnable TowerRunnable = new Runnable() {
    @Override
    public void run() {
        try {
            ShlickTowerEnnemie(2,17,firstTowerHP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};
    Runnable TowersecondRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                ShlickTowerEnnemie(8,17,SecondTowerHP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public void ShlickTowerEnnemie(int row , int column ,int HP) throws InterruptedException {
        System.out.println("BBBB");
        while (model.back[row][column]!=null &&model.back[row][column].isAlive()){
            if (!model.back[row][column].isHittingMode())
             cells[row][column].setImage(Princess);
             //else if (model.back[row][column]!=null && model.back[row][column].isHittingMode())


        int Damage = model.back[row][column].getDamage();

        for (int i = 0 ; i <row+2 ; i++ ){
            for (int j =column ; j >column-5 ; j--){
                //System.out.println( "i>"+i+"j"+j);
                if (model.back[i][j]!= null){
                    int speed = (int)model.back[row][column].getHitSpeed();
                    if (!model.back[i][j].isEsnemie()){
                        model.back[row][column].setHittingMode(true);
                        cells[row][column].setImage(princessRight);
                        while ( model.back[i][j]!=null &&model.back[i][j].getHP()>0 &&HP>0 ){

                        model.back[i][j].setHP(model.back[i][j].getHP()-Damage);
                        System.out.println(" ^^^^ "+model.back[i][j].getType()+" +"+ model.back[i][j].getHP());
                          //  System.out.println("Speed "+model.back[row][column].getHitSpeed());
                            TimeUnit.MILLISECONDS.sleep(speed);
                        }
                        model.back[row][column].setHittingMode(false);
                        System.out.println("111111111111111" + model.back[row][column].getHP());
                    }
                }

            }
        }
        if(model.back[row][column]!=null)
        if (model.back[row][column].getHP()<=0)
            model.back[row][column].setAlive(false);
    }


    }

    public void ShlickKingTowerEnnemie(int row , int column) throws InterruptedException {
        //model.back[row][column].setHittingMode(true);
            if (!model.back[row][column].isHittingMode())
                cells[row][column].setImage(RedKing);
        System.out.println("start chlicking  ");
        while (model.back[row][column]!=null &&model.back[row][column].isAlive()){

            // System.out.println("<><>");
            int Damage = model.back[row][column].getDamage();

            for (int i = 0 ; i < 12 ; i++ ){
                for (int j =column ; j >column-6 ; j--){
                    //System.out.println( "i>"+i+"j"+j);
                    if (model.back[i][j]!= null){
                        int speed = (int)model.back[row][column].getHitSpeed();
                        if (!model.back[i][j].isEsnemie()){
                            cells[row][column].setImage(kingRight);
                            while ( model.back[i][j]!=null &&model.back[i][j].getHP()>0 ){
                                model.back[i][j].setHP(model.back[i][j].getHP()-Damage);
                                System.out.println(" ^^^^ "+model.back[i][j].getType()+" +"+ model.back[i][j].getHP());
                                //  System.out.println("Speed "+model.back[row][column].getHitSpeed());
                                TimeUnit.MILLISECONDS.sleep(speed);
                            }
                        }
                    }
                }
            }
            if(model.back[row][column]!=null)
                if (model.back[row][column].getHP()<=0)
                    model.back[row][column].setAlive(false);
        }
    }

    public void moveToTheFirstTower(int row , int column , Member member) throws InterruptedException {
        while (row < 2) {
            if (model.grid[row + 1][column] == Model.CellValue.GROUND) {
                model.back[row + 1][column] = model.back[row][column];
                member = model.back[row+1][column];
                member.setLocation(new Location(row+1,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row + 1;
                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            }else
                Thread.sleep(100);

        }
        while (row > 2) {
            System.out.println("its greater "+member.getType());
            if (model.grid[row - 1][column] == Model.CellValue.GROUND) {
                model.back[row - 1][column] = model.back[row][column];
                member = model.back[row-1][column];
                member.setLocation(new Location(row-1,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row - 1;


                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            }else
                Thread.sleep(100);
        }
        while (column < 18) {
            if (model.grid[row][column + 1] == Model.CellValue.GROUND) {
                model.back[row][column + 1] = model.back[row][column];
                member = model.back[row][column + 1];
                member.setLocation(new Location(row,column+1));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                column = column + 1;

                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            } else if (model.back[row][column+1]!=null &&model.back[row][column + 1].isEsnemie()) {
                System.out.println("i am here ");
                Shlick(row, column, row, column + 1);
                break;
            }else {
                 if(model.grid[row][column + 1] != Model.CellValue.GROUND){
                    System.out.println("this is the case");
                    ShlickInRange(row,column,member);
                    Thread.sleep(500);
                }
                Thread.sleep(500);
            }
            if(row==2 && column==18)
                break;


            //break;
        }
    }
    public void moveToTheSecondTower(int row , int column , Member member) throws InterruptedException {
        while (row < 8) {
            if (model.grid[row + 1][column] == Model.CellValue.GROUND) {
                model.back[row + 1][column] = model.back[row][column];
                member = model.back[row+1][column];
                member.setLocation(new Location(row+1,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row + 1;
                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            }else
                Thread.sleep(100);

        }
        while (row > 8) {
            System.out.println("its greater "+member.getType());
            if (model.grid[row - 1][column] == Model.CellValue.GROUND) {
                model.back[row - 1][column] = model.back[row][column];
                member = model.back[row-1][column];
                member.setLocation(new Location(row-1,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row - 1;


                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            }else
                Thread.sleep(100);
        }
        while (column < 18) {
            if (model.grid[row][column + 1] == Model.CellValue.GROUND) {
                model.back[row][column + 1] = model.back[row][column];
                member = model.back[row][column + 1];
                member.setLocation(new Location(row,column+1));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                column = column + 1;

                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            } else if (model.back[row][column+1]!=null &&model.back[row][column + 1].isEsnemie()) {
                System.out.println("i am here ");
                Shlick(row, column, row, column + 1);
                break;
            }else {
                if(model.grid[row][column + 1] != Model.CellValue.GROUND){
                    System.out.println("this is the case");
                    ShlickInRange(row,column,member);
                    Thread.sleep(500);
                }
                Thread.sleep(500);
            }
            if(row==8 && column==18)
                break;


            //break;
        }
    }
    public void moveToTheKingTower(Member member) throws InterruptedException {
        if(member!=null){
        int row = member.getLocation().getX();
        int column = member.getLocation().getY();
        System.out.println("to thr king");
        while (row < 5 &&member!=null) {
            if (model.grid[row + 1][column] == Model.CellValue.GROUND) {
                model.back[row + 1][column] = model.back[row][column];
                member = model.back[row+1][column];
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row + 1;
                if (member!=null)
                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            }else
                Thread.sleep(100);

        }
        while (row > 5 &&member!=null) {
            System.out.println("its greater "+member.getType());
            if (model.grid[row - 1][column] == Model.CellValue.GROUND) {
                model.back[row - 1][column] = model.back[row][column];
                member = model.back[row-1][column];
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row - 1;

                if(member!=null)
                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            }else
                Thread.sleep(100);
        }
        while (column  < 19 && member!=null) {
            if (model.grid[row][column + 1] == Model.CellValue.GROUND) {
                model.back[row][column + 1] = model.back[row][column];
                member = model.back[row][column + 1];
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                column = column + 1;

                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
            } else if (model.back[row][column + 1].isEsnemie()) {
                System.out.println("i am here ");
                System.out.println("shlicking in ing ");
                Shlick(row, column, row, column + 1);
                break;
            }else if(model.grid[row][column + 1] != Model.CellValue.GROUND){
                System.out.println("this is the case");
                ShlickInRange(row,column,member);
                Thread.sleep(500);
            }

            //break;
        }
    }}


    public void ShlickInRange(int row , int column , Member member) throws InterruptedException {
        System.out.println("fu  ");
        if (member!=null){
            int damage = member.getDamage();
            int speedOfHit = (int )member.getHitSpeed();
            int Range =0 ;
            switch (member.getRange()){
               case "Melee" -> Range=1;
               case "2" -> Range=2;
               case "3" -> Range =3;
               case "4" ->Range =4;
               case "5" ->Range =5;
               case "15" ->Range = 15;
            }
            int index = Range/2+1;
            for (int i = row-index ; i<row+index ; i++){
                for (int j = column -index ; j <column+index ;j++){
                    if (i>=0 && i<12 && j>=0 &&j<22){
                        System.out.println("i"+ i +"j"+j);
                        if (model.back[i][j]!=null){
                            if(model.back[i][j].isEsnemie){
                                while (model.back[i][j] !=null && model.back[i][j].getHP()>0){
                                    model.back[i][j].setHP(model.back[i][j].getHP()-damage);
                                    System.out.println("fucked"+model.back[i][j].getHP());
                                    TimeUnit.MILLISECONDS.sleep(speedOfHit);
                                }
                            }
                        }
                    }
                }
            }

        }
    }
    Runnable ExirRunnable = new Runnable() {
        @Override
        public void run() {
            while (true){
            if (exir<5) {
                System.out.println("exir"+exir);
                exir++;
                switch (exir){
                    case 1 ->cells[10][0].setImage(ExirOne);
                    case 2 ->cells[10][0].setImage(ExirTwo);
                    case 3 ->cells[10][0].setImage(ExirThree);
                    case 4 ->cells[10][0].setImage(ExirFour);
                    case 5 ->cells[10][0].setImage(ExirFive);

                }

                try {
                    TimeUnit.MILLISECONDS.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }}
    };;
}
