package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.scenes.Menu;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        // window placeholder voor als er niks load
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(new Scene(root, 640,480));
        primaryStage.show();


        Menu menu = new Menu(primaryStage);
        menu.showScene();

    }
}
