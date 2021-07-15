package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        String css = Objects.requireNonNull(getClass().getResource("/Game/application.css")).toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
