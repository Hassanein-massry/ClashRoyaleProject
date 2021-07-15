package Game;

import Members.Buildings.Cannon;
import Members.Buildings.InfernoTower;
import Members.Member;
import Members.Player;
import Members.Players.*;
import Members.Spells.Arrow;
import Members.Spells.FireBall;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    private TextField textField ;
    private Image tempImage ;
    private Model model = new Model();
    //all the image views of all images in the scene
    private ImageView [][] cells;
    //a temp variable for saving a cell value
    private Model.CellValue tempCellValue ;

    /**
     * constructor
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public View() throws FileNotFoundException, InterruptedException {
        //get all the images of players and buildings
        this.BlueKing = new Image("Game/blueKing.jpg");
        this.RedKing = new Image("Game/redKing.jpg");
        this.Princess = new Image("Game/princess.jpg");
        this.ground = new Image("Game/ground.jpg");
        this.limit = new Image("Game/limit.png");
        this.archer = new Image("Game/archer.png");
        this.Deck = new Image("Game/inferno.png");
        this.cannon = new Image("Game/cannon.jpeg");
        this.infernoTower = new Image("Game/inferno.png");
        this.babyDragon = new Image("Game/babyDragon.png");
        this.barbarian = new Image("Game/barbarian.jpg");
        this.giant = new Image("Game/giant.png");
        this.miniPekka = new Image("Game/mini.png");
        this.valkyrie = new Image("Game/valkirye.png");
        this.wizard = new Image("Game/wizard.png");
        this.arrow = new Image("Game/arrows.png");
        this.fireBall = new Image("Game/fireBall.png");
        this.tempImage = new Image("Game/arrows.png") ;
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

    }

    public void secondUpdate() throws InterruptedException {
        model.update();

    }

    /**
     * update of the map every second
     * @throws InterruptedException
     */
    public void update() throws InterruptedException {
        model.update();
        System.out.println("updating");
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Model.CellValue value = model.getCellValue(row,column);
                //   System.out.println(value);

                if (value == Model.CellValue.GROUND) {
                    cells[row][column].setImage(ground);
                    int row2 = row;
                    int column2 = column;
                    //on mouse click condition for the ground
                    cells[row][column].setCursor(Cursor.HAND );
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
                } if (value == Model.CellValue.BARBARIAN){
                    cells[row][column].setImage(barbarian);
                } if (value == Model.CellValue.GIANT ){
                    cells[row][column].setImage(giant);
                //    GoToTheTarget(row , column , new Giant());

                } if (value == Model.CellValue.FIREBALL){
                    cells[row][column].setImage(fireBall);
                } if (value == Model.CellValue.MINIPEKKA){
                    cells[row][column].setImage(miniPekka);
                } if (value == Model.CellValue.WIZARD){
                    cells[row][column].setImage(wizard);
                }
                if (value == Model.CellValue.VALKYRIE){
                    cells[row][column].setImage(valkyrie);
                } if (value == Model.CellValue.RAGE){
                    cells[row][column].setImage(cannon);
                } if (value == Model.CellValue.EMPTY){
                    cells[row][column].setImage(null);
                }
                if (value== Model.CellValue.BLUEKING)
                    cells[row][column].setImage(BlueKing);
                if (value == Model.CellValue.REDKING)
                    cells[row][column].setImage(RedKing);
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
                        System.out.println("                "+string);
                        System.out.println(existingCard);
                        cells[row][column].setCursor(Cursor.HAND );
                        //set the conditin on mouse click for the deck cards case
                        cells[row][column].setOnMouseClicked(mouseEvent -> {
                            this.tempCellValue = model.getCellValue(row1 ,column1);
                            cells[row1][column1].setImage(null);
                            System.out.println(" >>>>>> " + tempCellValue);
                            model.grid[row1][column1] = Model.CellValue.EMPTY;
                            existingCard--;
                        });
                        if (existingCard<4 && cells[row][column].getImage()==null)
                        {
                            System.out.println("A >> ...   "+a);
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
                        cells[row][column].setImage(ground);
                        cells[row+1][column].setImage(player.getImage());


                    }
                }else if (row >2){
                    Model.CellValue cellValue = model.grid[row][column];
                    if (model.grid[row-1][column] == Model.CellValue.GROUND){
                        cells[row][column].setImage(ground);
                        model.grid[row-1][column] = cellValue;
                        model.grid[row][column] = Model.CellValue.GROUND;
                        cells[row][column].setImage(ground);
                        cells[row-1][column].setImage(player.getImage());


                    }
                }else if (column+1<18 && column!=0){
                    Model.CellValue cellValue = model.grid[row][column];
                    if (model.grid[row][column+1] == Model.CellValue.GROUND){
                        cells[row][column].setImage(ground);
                        model.grid[row][column+1] = cellValue;
                        model.grid[row][column] = Model.CellValue.GROUND;
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
        final int X = location.getX() ;
        final int Y = location.getY();

        if (cellValue == Model.CellValue.ARCHER){
            Archer archer = new Archer();
            archer.setLocation(location);
            model.back[X][Y] = archer;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+model.back[X][Y].getType());
        }
        if (cellValue == Model.CellValue.ARROW){
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
             Cannon cannon = new Cannon();
            cannon.setLocation(location);
            model.back[X][Y] = cannon;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>."+model.back[X][Y].getType());
        }if (cellValue == Model.CellValue.FIREBALL){
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
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (Y +i< 20){
                    model.back[X][Y+i] = model.back[X][Y+i-1];
                    //  back[row][column] = null;
                    model.grid[X][Y+i-1] = Model.CellValue.GROUND;
                    model.back[X][Y+i-1] = null;
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        };
        new Thread(runnable).start();

model.update();
    }


}
