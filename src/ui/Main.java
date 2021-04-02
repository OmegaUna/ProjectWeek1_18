package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.scenes.PlayerSettings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /*FXMLLoader root = new FXMLLoader();
        root.setLocation(getClass().getResource("ui.fxml"));*/
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        // window placeholder voor als er niks load
        Scene mainScene = new Scene(root, 640,480);
        //mainScene.getStylesheets().add("master.css");
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        Map<String, String> gameState = new HashMap<>();
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tabs.fxml"));*/
        PlayerSettings menu = new PlayerSettings(primaryStage, gameState);
        menu.showScene();

    }
}
