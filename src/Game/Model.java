package Game;

import Members.Players.Archer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Model {
    private int rowCount;
    private int columnCount;
    public CellValue grid[][];
    public Member back[][];
    enum CellValue{
      ENNEMIEPRINCESS, BLUEKING ,REDKING , PRINCESS, EMPTY ,DECKS , GROUND , LIMIT , ARCHER , DECK , CANNON , INFERNO ,BABYDRAGON , BARBARIAN ,GIANT , MINIPEKKA , VALKYRIE , WIZARD , ARROW , FIREBALL ,RAGE
    }
    public Model() throws InterruptedException {
        this.intializeTheGame("C:\\Users\\Envy\\FinalProject\\src\\Game\\text");
    }
    public void intializeTheGame(String fileName) throws InterruptedException {
        back = new Member[13][22];
        System.out.println("Initialize2");
        rowCount = 13;
        columnCount = 22;

        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int row = 0 ;
        grid = new CellValue[rowCount][columnCount];
        while(sc.hasNextLine()){
            System.out.println("iam here now");
            int column = 0;
            String line= sc.nextLine();
            System.out.println(line);
            Scanner lineScanner = new Scanner(line);
            int counter = 0 ;
            while (true){
                if (counter==line.length())
                    break;
                char value = line.charAt(counter);
                CellValue thisValue = null;
                switch (value) {
                    case 'G':
                        thisValue = CellValue.GROUND;
                    //    System.out.println("ground");
                        break;
                    case 'L':
                        thisValue = CellValue.LIMIT;
                      //  System.out.println("limit");
                        break;
                    case 'A':
                        thisValue = CellValue.ARCHER;
                        Archer archer= new Archer();
                        archer.setLocation(new Location(row , column));
                       // System.out.println("arcker");
                        break;
                    case 'D':
                        thisValue = CellValue.DECK;
                        //System.out.println("deck");
                        break;
                    case 'Q':
                        thisValue = CellValue.DECKS;
                       // System.out.println("deck2");
                        break;
                    case 'B':
                        thisValue = CellValue.BLUEKING;
                        break;
                    case'R':
                        thisValue = CellValue.REDKING;
                        break;
                    case'P':
                        thisValue = CellValue.PRINCESS;
                        break;
                    case '!':
                        thisValue = CellValue.ENNEMIEPRINCESS;
                        break;

                }
                grid[row][column] = thisValue;
                counter++;
                column ++;
            }
            row++;
        }
    }
    public CellValue getCellValue(int row, int column) {
        assert row >= 0 && row < this.grid.length && column >= 0 && column < this.grid[0].length;
        return this.grid[row][column];
    }
    public void move(Location oldLocation , Location newLocation ){
        CellValue tempCellVaue = grid[oldLocation.getX()][oldLocation.getY()];
        grid[oldLocation.getX()][oldLocation.getY()]= CellValue.GROUND;
        grid[newLocation.getX()][newLocation.getY()] = tempCellVaue;

    }
    public void SetInGrid(CellValue cellValue, int row  , int column){
        grid[row][column] = cellValue;
    }
    public void update () throws InterruptedException {
        String Arrow = "arrow";
        String Cannon = "cannon";
        String InfernoTower ="infernoTower";
        String Archer = "archer";
        String BabyDragon = "babyDragon";
        String Barbarian ="barbarian";
        String Giant = "giant";
        String MiniPekka = "miniPekka";
        String Valkyrie = "valkyrie";
        String Wizard = "wizard" ;
        String FireBall = "fireBall";
        String Rage = "rage";
        String KingTower = "kingTower";
        String NormalTower = "normalTower";
        for (int row  = 0 ; row < rowCount ; row ++){
            for (int column = 0 ; column < columnCount ; column++){
                updateHelper(row,column,Arrow,CellValue.ARROW);
                updateHelper(row,column,Cannon,CellValue.CANNON);
                updateHelper(row,column,InfernoTower,CellValue.INFERNO);
                updateHelper(row,column,Archer,CellValue.ARCHER);
                updateHelper(row,column,BabyDragon,CellValue.BABYDRAGON);
                updateHelper(row,column,Barbarian,CellValue.BARBARIAN);
                updateHelper(row,column,Giant,CellValue.GIANT);
                updateHelper(row,column,MiniPekka,CellValue.MINIPEKKA);
                updateHelper(row,column,Valkyrie,CellValue.VALKYRIE);
                updateHelper(row,column,Wizard,CellValue.WIZARD);
                updateHelper(row,column,FireBall,CellValue.FIREBALL);
            }
        }
    }

    public void updateHelper(int row , int column , String type , CellValue cellValue) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    moveThePlayer(row,column,back[row][column]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    //  new Thread(runnable).start();
        if (back[row][column]!=null)
            if (back[row][column].getType()!=null)
              if (back[row][column].getType().equals(type)) {
                 //   System.out.println("))))))))))))))))))))))))))))"+back[row][column]);
                  grid[row][column] = cellValue;


            }

        }

    public void moveThePlayer(int row , int column , Member member) throws InterruptedException {
        if (member!=null){
        int i = 1 ;
        int j = 1;
        int z = 1 ;
        if (row <= 2){
            while(row+i <=2){
                back[row+i][column] =back[row+i-1][column];
               grid[row+i-1][column]= CellValue.GROUND;
                back[row+i-1][column] = null;
                i++;
              /*  switch (member.getSpeed()){
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }*/}
            while (column+z<18){
                back[row][column+z] = back[row][column+z-1];
                grid[row][column+z-1]= CellValue.GROUND;
                back[row][column+z-1] = null;
                z++;
                switch (member.getSpeed()){
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }

            }
            z=1;

        }else if (row > 2){
            while(row-j >=2){
                back[row-j][column] =back[row-j+1][column];
              grid[row-j+1][column]= CellValue.GROUND;
                back[row-j+1][column] = null;

                j++;

                switch (member.getSpeed()){
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }}

            while (column+z<18){
                back[row][column+z] = back[row][column+z-1];
                grid[row][column+z-1]= CellValue.GROUND;
                back[row][column+z-1] = null;
                z++;
                switch (member.getSpeed()){
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }

            }


        }else if (row==2){
            while (column+z<18){
               back[row][column+z] = back[row][column+z-1];
                grid[row][column+z-1]= CellValue.GROUND;
               back[row][column+z-1] = null;
                z++;
                switch (member.getSpeed()){
                    case "Slow" -> TimeUnit.MILLISECONDS.sleep(500);
                    case "Medium" -> TimeUnit.MILLISECONDS.sleep(300);
                    case "Fast" -> TimeUnit.MILLISECONDS.sleep(150);
                }

            }
        }
    }
    }}





