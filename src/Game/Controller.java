package Game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label scoreLabel;
    @FXML private Label levelLabel;
    @FXML private Label gameOverLabel;
    @FXML private View gameView;
    private Model myModel ;

    public void initialize() throws InterruptedException {
        System.out.println("controller orking");
         this.myModel = new Model();
        this.gameView.update();
        Thread thread = new Thread(myTask);
        thread.start();
       // new Thread(modelUpdate).start();
    }
    Runnable myTask = new Runnable() {
        @Override
        public void run() {
          while (true){
              try {
                  gameView.update();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }
    };
    Runnable modelUpdate = new Runnable() {
        @Override
        public void run() {
            try {
                gameView.secondUpdate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };




}
