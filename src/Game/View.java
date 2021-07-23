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
import javafx.scene.shape.Arc;

import java.io.*;
import java.util.concurrent.TimeUnit;

import java.awt.*;
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
    private Image rightArcher;
    private Image Deck ;
    private Image cannon ;
    private Image rightCannon;
    private Image infernoTower;
    private Image rightInferno;
    private Image babyDragon ;
    private Image rightBabyDragon;
    private Image barbarian ;
    private Image rightBarbarian;
    private Image giant ;
    private Image rightGiant;
    private Image miniPekka;
    private Image rightMiniPekka;
    private Image valkyrie;
    private Image rightValkyrie;
    private Image wizard ;
    private Image rightWizard;
    private Image arrow;

    private Image rage ;
    private Image fireBall ;
    private Image BlueKing ;
    private Image RedKing ;
    private Image Princess;
    private Image rightPrincess;
    private Image HittingGiant;
    private Image rightHittingGiant;
    private Image HittingArcher ;
    private Image rightHittingArcher;
    private Image HittingWizard ;
    private Image rightHittingWizard;
    private Image HittingValk;
    private Image rightHittingValk;
    private Image HittingDragon;
    private Image rightHittingDragon;
    private Image HittingBarb;
    private Image rightHittingBarb;
    private Image HittingMini;
    private Image rightHittingMini;
    private Image princessRight ;
    private  Image rightHittingPrincessRight;
    private Image rightHittingCannon;
    private Image rightHittingInferno;
    private Image ExirOne;
    private Image ExirTwo;
    private Image ExirThree;
    private Image ExirFour;
    private Image ExirFive;
    private int exir2 = 0 ;
    private Image PrincessLeft;
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
    private int myFirstTowerHP = 0;
    private int mySecondTowerHp = 0;
    private int counter3 =0;
    private int counter4= 0;
    private int counter5 =0 ;

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
        this.rightArcher = new Image("Game/archer walking right.gif");
        this.rightPrincess = new Image("Game/archer tower right.gif");
        this.rightBabyDragon = new Image("Game/dragon flying right.gif");
        this.rightBarbarian = new Image("Game/barbarians walking right.gif");
        this.rightCannon = new Image("Game/cannon.jpeg");
        this.rightGiant = new Image("Game/gaint walking right.gif");
        this.rightInferno = new Image("Game/inferno.png");
        this.rightMiniPekka = new Image("Game/mini walking right.gif");
        this.rightValkyrie = new Image("Game/valk walking right.gif");
        this.rightWizard = new Image("Game/wizard walking right.gif");
        this.rightHittingArcher = new Image("Game/archer hitting right.gif");
        this.rightHittingBarb = new Image("Game/barb hitting right.gif");
        this.rightHittingDragon = new Image("Game/dragon  hitting right.gif");
        this.rightHittingGiant = new Image("Game/giant hitting right.gif");
        this.rightHittingMini = new Image("Game/mini hitting right.gif");
        this.rightHittingPrincessRight = new Image("Game/archer tower right.gif");
        this.rightHittingValk = new Image("Game/valk gitting right.gif");
        this.rightHittingWizard = new Image("Game/wizard hitting right.gif");
        this.rightHittingCannon = new Image("Game/cannon hitting right.gif");
        this.rightHittingInferno = new Image("Game/inferno hitting right.gif");
        this.PrincessLeft = new Image("Game/archer left tower.gif");

        //add all the names of cards to the cards array list
      //  myCards.add("cannon");
      //  myCards.add("inferno tower");
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
        new Thread(SecondExirRunnable).start();



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


        System.out.println("updating");
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Model.CellValue value = model.getCellValue(row,column);
                if(model.back[row][column]!=null)
                if (model.back[row][column].getHP()<=0){
                    model.back[row][column]=null;
                    model.grid[row][column] = Model.CellValue.GROUND;
                }
                //   System.out.println(value);

                if (value == Model.CellValue.GROUND) {
                    cells[row][column].setImage(ground);
                    int row2 = row;
                    int column2 = column;
                    //on mouse click condition for the ground
                    cells[row][column].setCursor(Cursor.HAND );
                    if(tempCellValue!=null && tempCellValue!= Model.CellValue.ARROW && tempCellValue!= Model.CellValue.FIREBALL){
                    if (column<11 && column >5){
                    cells[row][column].setOnMouseClicked(mouseEvent -> {
                        new Thread(makeEnnemieRunnable).start();
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
                    });}}else if (tempCellValue!=null && tempCellValue== Model.CellValue.ARROW || tempCellValue== Model.CellValue.FIREBALL){
                        cells[row][column].setOnMouseClicked(mouseEvent -> {
                            if (tempCellValue == null)
                                System.out.println("The temp value is null");
                            else{
                                   makeNewSpell(tempCellValue,new Location(row2,column2));
                            }

                        });
                        }

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
                }
                if (value == Model.CellValue.RIGHTARCHER){
                    cells[row][column].setImage(rightArcher);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingArcher);
                }
                if (value == Model.CellValue.RIGHTBABYDRAGON){
                    cells[row][column].setImage(rightBabyDragon);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingDragon);
                }
                if (value == Model.CellValue.BABYDRAGON){
                    cells[row][column].setImage(babyDragon);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(HittingDragon);
                }

                if (value == Model.CellValue.RIGHTBARBARIAN){
                    cells[row][column].setImage(rightBarbarian);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingBarb);
                }
                if (value == Model.CellValue.RIGHTCANNON){
                    cells[row][column].setImage(cannon);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingCannon);
                }
                if (value == Model.CellValue.RIGHTGIANT){
                    cells[row][column].setImage(rightGiant);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingGiant);
                }
                if (value == Model.CellValue.RIGHTINFERNO){
                    cells[row][column].setImage(rightInferno);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingInferno);
                }
                if (value == Model.CellValue.RIGHTMINIPEKKA){
                    cells[row][column].setImage(rightMiniPekka);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingMini);
                }
                if (value == Model.CellValue.RIGHTPRICESS){
                    cells[row][column].setImage(rightPrincess);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingPrincessRight);
                }
                if (value == Model.CellValue.RIGHTVALKYRIE){
                    cells[row][column].setImage(rightValkyrie);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingValk);
                }
                if (value == Model.CellValue.RIGHTWIZARD){
                    cells[row][column].setImage(rightWizard);
                    if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                        cells[row][column].setImage(rightHittingWizard);
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
                    model.back[row][column].setEsnemie(true);


                    //new Thread(runnable1).start();
                  //  ShlickTowerEnnemie(finalRow1,finalColumn1);
                }

                if (value== Model.CellValue.BLUEKING){
                    KingTower kingTower = new KingTower();
                    kingTower.setEsnemie(true);
                    model.back[row][column]=kingTower;
                    kingTower.setLocation(new Location(row,column));
                }
                if (value == Model.CellValue.REDKING){
                    //cells[row][column].setImage(kingRight);
                    //if (model.back[row][column]!=null && model.back[row][column].isHittingMode())
                      //  cells[row][column].setImage(HittingDragon);
                    KingTower kingTower = new KingTower();
                    kingTower.setEsnemie(true);
                    model.back[row][column]=kingTower;
                    kingTower.setLocation(new Location(row,column));

                }
                if (value == Model.CellValue.PRINCESS){

                    NormalTower normalTower = new NormalTower();
                    normalTower.setEsnemie(true);
                    model.back[row][column] = normalTower;
                    model.back[row][column].setEsnemie(false);

                }
                if (value == Model.CellValue.ARCHER) {
                    cells[row][column].setImage(archer);
                } if(column == 0){
                    if (row==0 ||row==2 |row==4 ||row==6){
                        final int row1 = row;
                        final int column1 = column;
                        int a=new Random().nextInt(myCards.size());
                        String string = myCards.get(a);
                        System.out.println("   >^             "+string);
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
    myFirstTowerHP = model.back[2][6].getHP();
    mySecondTowerHp = model.back[8][6].getHP();
    new Thread(TowerRunnable).start();
    new Thread(TowersecondRunnable).start();
    new Thread(myFirstTowerRunnable).start();
    new Thread(mySecondTowerRunnable).start();
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
Runnable KingRunnable = new Runnable() {
    @Override
    public void run() {
        try {
            ShlickMyKingTower(5,4);
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
if(model.back[2][6]==null || model.back[8][6]==null){
    if(counter5==0){
        new Thread(KingRunnable).start();
        counter5++;
    }
}

if(counter>0 || counter5>0){


    if(model.back[5][4] ==null){
        System.out.println("You lose");
        for(int i = 0 ; i < 12; i++)
            for (int j = 0 ;j < 22 ; j ++){
                model.back[i][j] = null;
                model.grid[i][j] = Model.CellValue.GROUND;
            }





    }
    if (model.back[5][19]==null){
        for(int i = 0 ; i < 12; i++)
            for (int j = 0 ;j < 22 ; j ++){
                model.back[i][j] = null;
                model.grid[i][j] = Model.CellValue.GROUND;

            }
        System.out.println("You win");


    }


}
        System.out.println("first tower" + myFirstTowerHP);
    }


    public  void makeNewPlayer(Model.CellValue cellValue , Location location) throws InterruptedException {
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
            flag=4;
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
            flag=3;
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
            flag=2;
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
        if (flag==0)
        new Thread(runnable).start();
        else if (flag==1){
            ShlickCannon(X,Y);
        }

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
            if (Math.abs(row-2)<=Math.abs(8-row)){
            moveToTheFirstTower(row,column,member);
            }
            else
                moveToTheSecondTower(row,column,member);

            moveToTheKingTower(member);
            if (member.getHP()<=0) { ;
                member.setAlive(false);
                System.out.println(member.getType()+"yes");
            }

        }


    }}


    public void moveTheEnnemiesPlayers(int temprow , int tempcolumn, Member member) throws InterruptedException {
        if (member!=null){
            int row = temprow ;
            int column = tempcolumn ;
            while (member.isAlive()) {
                if (Math.abs(row-2)<=Math.abs(8-row)){
                    moveToMyFirstTower(row,column,member);
                }
                else
                    moveToMySecondTower(row,column,member);
                moveToMyKingTower(member);
                if (member.getHP()<=0) { ;
                    member.setAlive(false);
                    System.out.println(member.getType()+"yes+");
                }

            }
    }
    }

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
        else if (row1==2 && column1 ==6){
            HP = myFirstTowerHP;
            flag=4;
        } else if (row1==8 && column1 ==6){
            HP = mySecondTowerHp;
            flag=5;
        }
        else {HP = model.back[row1][column1].getHP();
        flag=3;}
        if(model.back[row][column]!=null)
        model.back[row][column].setHittingMode(true);

        System.out.println(">   >   >  "+HP);
        int damage = model.back[row][column].getDamage();
        int speedOfHit = (int)model.back[row][column].getHitSpeed();
        while (model.back[row1][column1] !=null && model.back[row1][column1].getHP()>0 &&model.back[row][column]!=null &&HP>0){
            model.back[row1][column1].setHP(HP-damage);
            HP=HP-damage;
            switch (flag){
                case 1-> firstTowerHP = HP;
                case 2->SecondTowerHP =HP;
                case 4->myFirstTowerHP = HP;
                case 5->mySecondTowerHp=HP;
            }
            TimeUnit.MILLISECONDS.sleep(speedOfHit);
        }
        if (model.back[row][column]!=null){
        model.back[row][column].setHittingMode(false);
        model.back[row1][column1].setHP(HP);}
        //model.back[row1][column1] = model.back[row][column];
        //model.back[row][column]= null;
        //model.grid[row][column]= Model.CellValue.GROUND;
       // moveToTheFirstTower(row,column,model.back[row][column]);
        if(model.back[row][column].isEsnemie){
            if (model.back[2][6]!=null ){
                moveToMyFirstTower(row,column,model.back[row][column]);
            }
            else if(model.back[8][6]!=null){
                moveToMySecondTower(row,column,model.back[row][column]);
            }else if (model.back[5][4]!=null){
                moveToMyKingTower(model.back[row][column]);
            }

        }else {
            if (model.back[2][17]!=null ){
                moveToTheFirstTower(row,column,model.back[row][column]);
            }
            else if(model.back[8][17]!=null){
                moveToTheSecondTower(row,column,model.back[row][column]);
            }else if (model.back[5][4]!=null){
                moveToTheKingTower(model.back[row][column]);
            }

        }
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
    Runnable myFirstTowerRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                myShlickTower(2,6,myFirstTowerHP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    Runnable mySecondTowerRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                myShlickTower(8,6,mySecondTowerHp);
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

    public void myShlickTower(int row , int column , int HP) throws InterruptedException {

            System.out.println("BBBB1");
            while (model.back[row][column]!=null &&model.back[row][column].isAlive()){
                if (!model.back[row][column].isHittingMode())
                    cells[row][column].setImage(Princess);
                //else if (model.back[row][column]!=null && model.back[row][column].isHittingMode())


                int Damage = model.back[row][column].getDamage();

                for (int i = 0 ; i <row+2 ; i++ ){
                    for (int j =column ; j <column+5 ; j++){
                        System.out.println( "i>"+i+"j"+j);
                        if (model.back[i][j]!= null){
                            int speed = (int)model.back[row][column].getHitSpeed();
                            if (model.back[i][j].isInRight()){
                                cells[row][column].setImage(PrincessLeft);
                                model.back[row][column].setHittingMode(true);
                                while ( model.back[i][j]!=null &&model.back[i][j].getHP()>0 &&HP>0 ){

                                    model.back[i][j].setHP(model.back[i][j].getHP()-Damage);
                                    System.out.println(" ^^^^ "+model.back[i][j].getType()+" +"+ model.back[i][j].getHP());
                                    //  System.out.println("Speed "+model.back[row][column].getHitSpeed());
                                    //model.back[row][column].setHP(model.back[row][column].getHP()-100);
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

public void ShlickMyKingTower(int row , int column ) throws InterruptedException {
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
                    if (model.back[i][j].isEsnemie()){
                        cells[row][column].setImage(kingRight);
                        while ( model.back[i][j]!=null &&model.back[i][j].getHP()>0 ){
                            model.back[i][j].setHP(model.back[i][j].getHP()-Damage);
                            System.out.println(" ^^^^ "+model.back[i][j].getType()+" +"+ model.back[i][j].getHP());
                            //  System.out.println("Speed "+model.back[row][column].getHitSpeed());
                            TimeUnit.MILLISECONDS.sleep(speed);
                        }
                        try {
                            BufferedReader coinsReader = new BufferedReader(new FileReader("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\coins.txt"));
                            String line = null;
                            int coins = 0;
                            while ((line = coinsReader.readLine()) != null) {
                                System.out.println(line);
                                coins = Integer.parseInt(line);
                            }
                            int a = coins +30;
                            BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\coins.txt"));
                            wr.write(String.valueOf(a));
                            wr.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            BufferedReader troffiesReader = new BufferedReader(new FileReader("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\Trophies.txt"));
                            String line = null;
                            int vl = 0;
                            while ((line = troffiesReader.readLine()) != null) {
                                System.out.println(line);
                                vl = Integer.parseInt(line);
                            }
                            int a = vl +30;
                            BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\Trophies.txt"));
                            wr.write(String.valueOf(a));
                            wr.close();

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        StringBuilder s = new StringBuilder();
                        s.append(" ");
                        BufferedReader historyReader = null;
                        try {
                            historyReader = new BufferedReader(new FileReader("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\history.txt"));

                            String line = null ;

                            int vl = 0;
                            while (true) {
                                try {
                                    if (!((line = historyReader.readLine()) != null)) break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                s.append(" "+line);
                            }

                            s.append(" win");
                            try {
                                historyReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        try {

                            BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\history.txt"));

                            wr.write(s.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
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
                            try {
                                BufferedReader coinsReader = new BufferedReader(new FileReader("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\coins.txt"));
                                String line = null;
                                int coins = 0;
                                while ((line = coinsReader.readLine()) != null) {
                                    System.out.println(line);
                                    coins = Integer.parseInt(line);
                                }
                                int a = coins -30;
                                BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\coins.txt"));
                                wr.write(String.valueOf(a));
                                wr.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                BufferedReader troffiesReader = new BufferedReader(new FileReader("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\Trophies.txt"));
                                String line = null;
                                int vl = 0;
                                while ((line = troffiesReader.readLine()) != null) {
                                    System.out.println(line);
                                    vl = Integer.parseInt(line);
                                }
                                int a = vl -30;
                                BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\Trophies.txt"));
                                wr.write(String.valueOf(a));
                                wr.close();

                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            StringBuilder s = new StringBuilder();

                            BufferedReader historyReader = null;
                            try {
                                historyReader = new BufferedReader(new FileReader("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\history.txt"));
                                String line = null ;

                                int vl = 0;
                                while (true) {
                                    try {
                                        if (!((line = historyReader.readLine()) != null)) break;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    s.append(" ").append(line);
                                }
                                try {
                                    historyReader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();

                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }


                            try {

                                BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\Envy\\Clash-royale-first-pages-setup-master\\history.txt"));
                                wr.write(s.toString());
                            } catch (IOException e) {
                                e.printStackTrace();
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
            }else if (!model.back[row+1][column].isEsnemie){
                model.back[row + 2][column] = model.back[row][column];
                member = model.back[row+2][column];
                member.setLocation(new Location(row+2,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row + 2;
            }
            else
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
            }else if (!model.back[row-1][column].isEsnemie){
                model.back[row - 2][column] = model.back[row][column];
                member = model.back[row-2][column];
                member.setLocation(new Location(row-2,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row - 2;
            }
            else
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
                if (model.back[row][column].getTarget().equals("Ground")){
                    if(model.back[row][column+1].getType().equals("archer")||model.back[row][column+1].getType().equals("barbarian")||model.back[row][column+1].getType().equals("valkyrie")||model.back[row][column+1].getType().equals("wizard")||model.back[row][column+1].getType().equals("cannon")||model.back[row][column+1].getType().equals("infernoTower")||model.back[row][column+1].getType().equals("tower")||model.back[row][column+1].getType().equals("giant")){
                        Shlick(row, column, row, column + 1);
                    }
                }else if(model.back[row][column].getTarget().equals("Ground & Air")){
                    if(model.back[row][column+1].getType().equals("archer")||model.back[row][column+1].getType().equals("barbarian")||model.back[row][column+1].getType().equals("valkyrie")||model.back[row][column+1].getType().equals("wizard")||model.back[row][column+1].getType().equals("cannon")||model.back[row][column+1].getType().equals("infernoTower")||model.back[row][column+1].getType().equals("tower")||model.back[row][column+1].getType().equals("giant")||model.back[row][column+1].getType().equals("babyDragon")){
                        Shlick(row, column, row, column + 1);
                    }
                }else if (model.back[row][column].getTarget().equals("Buildings")){
                    if(model.back[row][column+1].getType().equals("tower")){
                        Shlick(row,column,row,column+1);
                    }else if(model.grid[row][column+1]!= Model.CellValue.GROUND){
                        model.back[row][column+2] = model.back[row][column];
                        model.back[row][column] =null;
                        model.grid[row][column]= Model.CellValue.GROUND;

                    }
                }



            }else if (!model.back[row][column+1].isEsnemie){
                model.back[row][column+2] = model.back[row][column];
                member = model.back[row][column+2];
                member.setLocation(new Location(row,column+2));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                column=column +2;
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
            }
            else if (!model.back[row+1][column].isEsnemie){
                model.back[row + 2][column] = model.back[row][column];
                member = model.back[row+2][column];
                member.setLocation(new Location(row+2,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row + 2;
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
            }
            else if (!model.back[row-1][column].isEsnemie){
                model.back[row - 2][column] = model.back[row][column];
                member = model.back[row-2][column];
                member.setLocation(new Location(row-2,column));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                row = row - 2;
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

                if (model.back[row][column].getTarget().equals("Ground")){
                    if(model.back[row][column+1].getType().equals("archer")||model.back[row][column+1].getType().equals("barbarian")||model.back[row][column+1].getType().equals("valkyrie")||model.back[row][column+1].getType().equals("wizard")||model.back[row][column+1].getType().equals("cannon")||model.back[row][column+1].getType().equals("infernoTower")||model.back[row][column+1].getType().equals("tower")||model.back[row][column+1].getType().equals("giant")){
                        Shlick(row, column, row, column + 1);
                    }
                }else if(model.back[row][column].getTarget().equals("Ground & Air")){
                    if(model.back[row][column+1].getType().equals("archer")||model.back[row][column+1].getType().equals("barbarian")||model.back[row][column+1].getType().equals("valkyrie")||model.back[row][column+1].getType().equals("wizard")||model.back[row][column+1].getType().equals("cannon")||model.back[row][column+1].getType().equals("infernoTower")||model.back[row][column+1].getType().equals("tower")||model.back[row][column+1].getType().equals("giant")||model.back[row][column+1].getType().equals("babyDragon")){
                        Shlick(row, column, row, column + 1);
                    }
                }else if (model.back[row][column].getTarget().equals("Buildings")){
                    if(model.back[row][column+1].getType().equals("tower")){
                        Shlick(row,column,row,column+1);
                    }
                    else if(model.grid[row][column+1]!= Model.CellValue.GROUND){
                        model.back[row][column+2] = model.back[row][column];
                        model.back[row][column] =null;
                        model.grid[row][column]= Model.CellValue.GROUND;

                    }}
            }else if (!model.back[row][column+1].isEsnemie){
                model.back[row][column+2] = model.back[row][column];
                member = model.back[row][column+2];
                member.setLocation(new Location(row,column+2));
                model.grid[row][column] = Model.CellValue.GROUND;
                model.back[row][column] = null;
                column=column +2;
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
                                    model.back[row][column].setHittingMode(true);
                                    model.back[i][j].setHP(model.back[i][j].getHP()-damage);
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
    };



    public void makeNewSpell(Model.CellValue cellValue , Location location){
        int row = location.getX();
        int column = location.getY();
        if (cellValue== Model.CellValue.FIREBALL){
            FireBall fireBall = new FireBall();
            int radius =(int) fireBall.getRadius();
            for (int i = row-radius ;i < row+radius ; i++){
                for (int j =column-radius ; j<column+radius ; j++) {
                    if (i >= 0 && i < 12 && j >= 0 && j < 22) {
                        if (model.back[i][j] != null) {
                            if (model.back[i][j].isEsnemie) {
                                System.out.println("I"+i+"J"+j);
                                model.back[i][j].setHP(model.back[i][j].getHP() - fireBall.getDamageArea());
                                System.out.println("hp .+" +model.back[i][j].getHP() +model.back[i][j].getType());

                            }

                        }
                    }
                }
            }
        }else  if (cellValue== Model.CellValue.ARROW){
            Arrow arrow = new Arrow();
            int radius =(int) arrow.getRadius();
            for (int i = row-radius ;i < row+radius ; i++){
                for (int j =column-radius ; j<column+radius ; j++) {
                    if (i >= 0 && i < 12 && j >= 0 && j < 22) {
                        if (model.back[i][j] != null) {
                            if (model.back[i][j].isEsnemie) {
                                System.out.println("I"+i+"J"+j);
                                model.back[i][j].setHittingMode(true);
                                model.back[i][j].setHP(model.back[i][j].getHP() - arrow.getDamageArea());
                                System.out.println("hp .+" +model.back[i][j].getHP() +model.back[i][j].getType());
                               // cells[i][j].setImage(arrow.getImage());
                            }

                        }
                    }
                }
            }
        }




    }


    Runnable SecondExirRunnable = new Runnable() {
        @Override
        public void run() {
            while (true){
                if (exir2<5) {
                    System.out.println("exir2"+exir2);
                    exir2+=5;
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
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





}

    }};



    public  void makeEnnemiePlayer() throws InterruptedException {
        System.out.println("making ennemie player ");
        int flag=0;
        Random random = new Random();
        int a = random.nextInt(11);
        String string = myCards.get(a);
        int cost =0 ;

        switch (string) {
            case "arrow" -> cost = new Arrow().getCost();
            case "cannon" -> cost = new Cannon().getCost();
            case "inferno tower" -> cost = new InfernoTower().getCost();
            case "archer" -> cost = new Archer().getCost();
            case "baby dragon" -> cost = new BabyDragon().getCost();
            case "barbarian" -> cost = new Barbarian().getCost();
            case "giant" -> cost = new Giant().getCost();
            case "mini pekka" -> cost = new MiniPekka().getCost();
            case "valkyrie" -> cost = new Valkyrie().getCost();
            case "wizard" -> cost = new Wizard().getCost();
            case "fireBall" -> cost = new FireBall().getCost();
        }
        if (exir2>=cost){
        int j = random.nextInt(5)+11;
        int i = random.nextInt(10)+1;
            System.out.println("String" + string +i+j);
        Location location = new Location(i,j);
        if (model.grid[i][j] == Model.CellValue.GROUND){
            switch (string) {
                case "arrow" -> {
                    Arrow arrow = new Arrow();
                    // arrow.setLocation(location);
                    //model.back[i][j]=arrow;
                    flag = 1;
                }
                case "cannon" -> {
               //     Cannon cannon = new Cannon();
                    //  cannon.setLocation(location);
                    //  model.back[i][j]=cannon;
                    flag = 1;
                }
                case "inferno tower" -> {
                    flag=1;
                 //   InfernoTower infernoTower = new InfernoTower();
                   // infernoTower.setLocation(location);
                    //model.back[i][j] = infernoTower;
                    //model.back[i][j].setEsnemie(true);
                }
                case "archer" -> {
                    Archer archer = new Archer();
                    archer.setLocation(location);
                    model.back[i][j] = archer;
                    model.back[i][j].setEsnemie(true);
                }
                case "baby dragon" -> {
                    BabyDragon babyDragon = new BabyDragon();
                    babyDragon.setLocation(location);
                    model.back[i][j] = babyDragon;
                    model.back[i][j].setEsnemie(true);
                }
                case "barbarian" -> {
                    Barbarian barbarian = new Barbarian();
                    barbarian.setLocation(location);
                    model.back[i][j] = barbarian;
                    model.back[i][j].setEsnemie(true);
                }
                case "giant" -> {
                    Giant giant = new Giant();
                    giant.setLocation(location);
                    model.back[i][j] = giant;
                    model.back[i][j].setEsnemie(true);
                }
                case "mini Pekka" -> {
                    MiniPekka miniPekka = new MiniPekka();
                    miniPekka.setLocation(location);
                    model.back[i][j] = miniPekka;
                    model.back[i][j].setEsnemie(true);
                }
                case "valkyrie" -> {
                    Valkyrie valkyrie = new Valkyrie();
                    valkyrie.setLocation(location);
                    model.back[i][j] = valkyrie;
                    model.back[i][j].setEsnemie(true);
                }
                case "wizard" -> {
                    Wizard wizard = new Wizard();
                    wizard.setLocation(location);
                    model.back[i][j] = wizard;
                    model.back[i][j].setEsnemie(true);
                }
                case "fireBall" -> {
                    flag=1;
                  //  FireBall fireBall = new FireBall();
                   // fireBall.setLocation(location);
                   // model.back[i][j] = fireBall;
                    //model.back[i][j].setEsnemie(true);
                }
            }
        }
        if (flag!=1){
        exir2-=cost;
        model.back[i][j].setInRight(true);
        moveTheEnnemiesPlayers(i,j,model.back[i][j]);
        }
       }

    }
    Runnable makeEnnemieRunnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
               try {
                   makeEnnemiePlayer();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    };




    public void moveToMyFirstTower(int row , int column, Member member) throws InterruptedException {
        while (row < 2 && member!=null) {
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
        }
        else if (model.back[row+1][column].isEsnemie){
            model.back[row + 2][column] = model.back[row][column];
            member = model.back[row+2][column];
            member.setLocation(new Location(row+2,column));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            row = row + 2;
        }else
            Thread.sleep(100);

    }
        while (row > 2&& member!=null) {
        System.out.println("its greater "+member.getType());
        if (model.grid[row - 1][column] == Model.CellValue.GROUND) {
            model.back[row - 1][column] = model.back[row][column];
            member = model.back[row-1][column];
            member.setLocation(new Location(row-1,column));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            row = row - 1;
            if (member.getSpeed()!=null)
            switch (member.getSpeed()) {
                case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
            }
        } else if (model.back[row-1][column].isEsnemie){
            model.back[row - 2][column] = model.back[row][column];
            member = model.back[row-2][column];
            member.setLocation(new Location(row-2,column));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            row = row - 2;
        }else
            Thread.sleep(100);
    }
       while (column >4  && member!=null) {
        if (model.grid[row][column - 1] == Model.CellValue.GROUND) {
            model.back[row][column - 1] = model.back[row][column];
            member = model.back[row][column - 1];
            member.setLocation(new Location(row,column-1));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            column--;

            switch (member.getSpeed()) {
                case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
            }
        } else if (model.back[row][column-1]!=null &&!model.back[row][column - 1].isEsnemie()) {
            System.out.println("i am here +");

            if (model.back[row][column].getTarget().equals("Ground")){
                System.out.println("!");
                if(model.back[row][column-1].getType().equals("archer")||model.back[row][column-1].getType().equals("barbarian")||model.back[row][column-1].getType().equals("valkyrie")||model.back[row][column-1].getType().equals("wizard")||model.back[row][column-1].getType().equals("cannon")||model.back[row][column-1].getType().equals("infernoTower")||model.back[row][column-1].getType().equals("tower")||model.back[row][column-1].getType().equals("giant")){
                    Shlick(row, column, row, column - 1);
                }
            }else if(model.back[row][column].getTarget().equals("Ground & Air")){
                System.out.println("!!");
                if(model.back[row][column-1].getType().equals("archer")||model.back[row][column-1].getType().equals("barbarian")||model.back[row][column-1].getType().equals("valkyrie")||model.back[row][column-1].getType().equals("wizard")||model.back[row][column-1].getType().equals("cannon")||model.back[row][column-1].getType().equals("infernoTower")||model.back[row][column-1].getType().equals("tower")||model.back[row][column-1].getType().equals("giant") ||model.back[row][column-1].getType().equals("babyDragon")){
                    Shlick(row, column, row, column - 1);
                }
            }else if (model.back[row][column].getTarget().equals("Buildings")){
                System.out.println("!!!");
                if(model.back[row][column-1].getType().equals("tower")){
                    Shlick(row,column,row,column-1);
                }else if(model.grid[row][column-1]!= Model.CellValue.GROUND){
                    model.back[row][column-2] = model.back[row][column];
                    model.back[row][column] =null;
                    model.grid[row][column]= Model.CellValue.GROUND;

                }
            }
        }else if (model.back[row][column+1].isEsnemie){
            model.back[row][column+2] = model.back[row][column];
            member = model.back[row][column+2];
            member.setLocation(new Location(row,column+2));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            column=column +2;
        }else {
            if(model.grid[row][column - 1] != Model.CellValue.GROUND){
                System.out.println("this is the case+");
                ShlickInRange(row,column,member);
                Thread.sleep(500);
            }
            Thread.sleep(500);
        }
        if(row==2 && column==4)
            break;


        //break;
    }

}

public void moveToMySecondTower(int row , int column ,Member member) throws InterruptedException {
    while (row < 8 && member!=null) {
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
        }
        else if (model.back[row+1][column].isEsnemie){
            model.back[row + 2][column] = model.back[row][column];
            member = model.back[row+2][column];
            member.setLocation(new Location(row+2,column));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            row = row + 2;
        }else {
            Thread.sleep(100);
        }

    }
    while (row > 8&& member!=null) {
        System.out.println("its greater "+member.getType());
        if (model.grid[row - 1][column] == Model.CellValue.GROUND) {
            model.back[row - 1][column] = model.back[row][column];
            member = model.back[row-1][column];
            member.setLocation(new Location(row-1,column));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            row = row - 1;
            if (member.getSpeed()!=null)
                switch (member.getSpeed()) {
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }
        } else if (model.back[row-1][column].isEsnemie){
            model.back[row - 2][column] = model.back[row][column];
            member = model.back[row-2][column];
            member.setLocation(new Location(row-2,column));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            row = row - 2;
        }else
            Thread.sleep(100);
    }
    while (column >4  && member!=null) {
        if (model.grid[row][column - 1] == Model.CellValue.GROUND) {
            model.back[row][column - 1] = model.back[row][column];
            member = model.back[row][column - 1];
            member.setLocation(new Location(row,column-1));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            column--;

            switch (member.getSpeed()) {
                case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
            }
        } else if (model.back[row][column-1]!=null &&!model.back[row][column - 1].isEsnemie()) {
            System.out.println("i am here +");

            if (model.back[row][column].getTarget().equals("Ground")){
                System.out.println("!");
                if(model.back[row][column-1].getType().equals("archer")||model.back[row][column-1].getType().equals("barbarian")||model.back[row][column-1].getType().equals("valkyrie")||model.back[row][column-1].getType().equals("wizard")||model.back[row][column-1].getType().equals("cannon")||model.back[row][column-1].getType().equals("infernoTower")||model.back[row][column-1].getType().equals("tower")||model.back[row][column-1].getType().equals("giant")){
                    Shlick(row, column, row, column - 1);
                }
            }else if(model.back[row][column].getTarget().equals("Ground & Air")){
                System.out.println("!!");
                if(model.back[row][column-1].getType().equals("archer")||model.back[row][column-1].getType().equals("barbarian")||model.back[row][column-1].getType().equals("valkyrie")||model.back[row][column-1].getType().equals("wizard")||model.back[row][column-1].getType().equals("cannon")||model.back[row][column-1].getType().equals("infernoTower")||model.back[row][column-1].getType().equals("tower")||model.back[row][column-1].getType().equals("giant") ||model.back[row][column-1].getType().equals("babyDragon")){
                    Shlick(row, column, row, column - 1);
                }
            }else if (model.back[row][column].getTarget().equals("Buildings")){
                System.out.println("!!!");
                if(model.back[row][column-1].getType().equals("tower")){
                    Shlick(row,column,row,column-1);
                }
                else if(model.grid[row][column-1]!= Model.CellValue.GROUND){
                    model.back[row][column-2] = model.back[row][column];
                    model.back[row][column] =null;
                    model.grid[row][column]= Model.CellValue.GROUND;

                }
            }
        }else if (model.back[row][column+1].isEsnemie){
            model.back[row][column+2] = model.back[row][column];
            member = model.back[row][column+2];
            member.setLocation(new Location(row,column+2));
            model.grid[row][column] = Model.CellValue.GROUND;
            model.back[row][column] = null;
            column=column +2;
        }else {
            if(model.grid[row][column - 1] != Model.CellValue.GROUND){
                System.out.println("this is the case+");
                ShlickInRange(row,column,member);
                Thread.sleep(500);
            }
            Thread.sleep(500);
        }
        if(row==2 && column==4)
            break;


        //break;
    }

}




    public void ShlickCannon(int row, int column){
        Runnable cannonRunnable = new Runnable( ) {
            @Override
            public void run() {

                boolean x=true;
                long displayMinutes=0;
                long starttime=System.currentTimeMillis();
                int range =(int) Double.parseDouble(model.back[row][column].getRange());
                int damage = model.back[row][column].getDamage();
                while(x)
                {
                    for (int i = row - range; i < row+range ; i++){
                        for(int j = column -range ; j <column +range ;j++){
                            if (i>0 && i <12 && j >0 && j <22){
                                if(model.back[i][j].isEsnemie)
                                if (model.back[i][j]!=null && model.back[i][j].getType().equals("archer")||model.back[i][j].getType().equals("barbarian")||model.back[i][j].getType().equals("valkyrie")||model.back[i][j].getType().equals("wizard")||model.back[i][j].getType().equals("cannon")||model.back[i][j].getType().equals("infernoTower")||model.back[i][j].getType().equals("tower")||model.back[i][j].getType().equals("giant")){
                                    while (model.back[row][column]!=null || model.back[i][j]!=null ){
                                        System.out.println("checked");
                                        model.back[row][column].setHittingMode(true);
                                        model.back[i][j].setHP(model.back[i][j].getHP()-damage);
                                        try {
                                            Thread.sleep((int)model.back[i][j].getHitSpeed());
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long timepassed=System.currentTimeMillis()-starttime;
                    long secondspassed=timepassed/1000;
                    if(secondspassed==60)
                    {
                        secondspassed=0;
                        starttime=System.currentTimeMillis();
                    }
                    if((secondspassed%60)==0)
                        displayMinutes++;

                    if (displayMinutes==0 && secondspassed ==30){
                        model.grid[row][column] = Model.CellValue.GROUND;
                        model.back[row][column]=null;
                        break;}
                }


            }
        };
    }

    public void moveToMyKingTower(Member member) throws InterruptedException {
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
            while (column  < 5&& member!=null) {
                if (model.grid[row][column - 1] == Model.CellValue.GROUND) {
                    model.back[row][column - 1] = model.back[row][column];
                    member = model.back[row][column + 1];
                    model.grid[row][column] = Model.CellValue.GROUND;
                    model.back[row][column] = null;
                    column = column - 1;

                    switch (member.getSpeed()) {
                        case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                        case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                        case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                    }
                } else if (model.back[row][column - 1].isEsnemie()) {
                    System.out.println("i am here ");
                    System.out.println("shlicking in king ");
                    Shlick(row, column, row, column + 1);
                    break;
                }else if(model.grid[row][column - 1] != Model.CellValue.GROUND){
                    System.out.println("this is the case");
                    ShlickInRange(row,column,member);
                    Thread.sleep(500);
                }

                //break;
            }
        }}
}
