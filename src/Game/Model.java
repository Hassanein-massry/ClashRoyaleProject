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
      ENNEMIEPRINCESS, BLUEKING ,REDKING , PRINCESS,RIGHTPRICESS, EMPTY ,DECKS , GROUND , LIMIT , ARCHER ,RIGHTARCHER, DECK , CANNON ,RIGHTCANNON, INFERNO ,RIGHTINFERNO,RIGHTBABYDRAGON,BABYDRAGON ,RIGHTBARBARIAN, BARBARIAN ,RIGHTGIANT ,GIANT,RIGHTMINIPEKKA, MINIPEKKA ,RIGHTVALKYRIE, VALKYRIE ,RIGHTWIZARD, WIZARD , ARROW , FIREBALL ,RAGE
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
                updateHelper(row,column,Arrow,CellValue.ARROW , CellValue.ARROW);
                updateHelper(row,column,Cannon,CellValue.CANNON,CellValue.RIGHTCANNON);
                updateHelper(row,column,InfernoTower,CellValue.INFERNO,CellValue.RIGHTINFERNO);
                updateHelper(row,column,Archer,CellValue.ARCHER,CellValue.RIGHTARCHER);
                updateHelper(row,column,BabyDragon,CellValue.BABYDRAGON,CellValue.RIGHTBABYDRAGON);
                updateHelper(row,column,Barbarian,CellValue.BARBARIAN,CellValue.RIGHTBARBARIAN);
                updateHelper(row,column,Giant,CellValue.GIANT,CellValue.RIGHTGIANT);
                updateHelper(row,column,MiniPekka,CellValue.MINIPEKKA,CellValue.RIGHTMINIPEKKA);
                updateHelper(row,column,Valkyrie,CellValue.VALKYRIE,CellValue.RIGHTVALKYRIE);
                updateHelper(row,column,Wizard,CellValue.WIZARD,CellValue.RIGHTWIZARD);
                updateHelper(row,column,FireBall,CellValue.FIREBALL,CellValue.FIREBALL);
            }
        }
    }

    public void updateHelper(int row , int column , String type , CellValue cellValue , CellValue rightCellValue) throws InterruptedException {
    //  new Thread(runnable).start();
        if (back[row][column]!=null)
            if (back[row][column].getType()!=null)
              if (back[row][column].getType().equals(type)) {
                 //   System.out.println("))))))))))))))))))))))))))))"+back[row][column]);
                  if (!back[row][column].isInRight())
                  grid[row][column] = cellValue;
                  else
                      grid[row][column]=rightCellValue;
            }

        }




        }







