package ui.scenes;

import domain.exceptions.DomainException;
import javafx.application.Application;

import javafx.stage.Stage;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;
import java.util.Map;


public class Menu {
    private FXMLLoader loader;
    public Scene scene;
    private final Stage parentScene;
    private final Map<String, String> gameState;

    public Menu(Stage parentScene, Map<String, String> gameState) {
        //this.loader = loader;
        this.gameState = gameState;
        this.parentScene = parentScene;
        this.parentScene.setTitle("Hangman | Menu");
        this.parentScene.setTitle("Hey, " + gameState.get("playerName") + "!");

        this.start();
    }
    public void start() {
        VBox pane = new VBox();
        pane.getChildren().add(new Text("Dit is Hangman! Klik hieronder om de game te beginnen!"));

        Button btn_go_game = new Button();
        btn_go_game.setStyle("" +
                "--fx-margin-bottom: 120px;-fx-padding: 5px;" +
                "-fx-border-insets: 5px;-fx-background-insets: 5px;" +
                "-fx-background-color: #39f;");
        btn_go_game.getStyleClass().add("btn-primary");
        btn_go_game.setText("Hangman spelen");
        btn_go_game.setOnAction(event -> {
            System.out.println("User went to game scene.");
            GameCycle gameCycle = null;
            try {
                gameCycle = new GameCycle(this.parentScene, this.gameState);
            } catch (DomainException e) {
                e.getMessage();
            }
            //GameCycle gameCycle = new GameCycle(this.parentScene, this.loader);
            assert gameCycle != null;
            gameCycle.showScene();
        });
        
        Button btn_go_back = new Button();
        btn_go_back.setStyle("" +
                "--fx-margin-bottom: 120px;-fx-padding: 5px;" +
                "-fx-border-insets: 5px;-fx-background-insets: 5px;" +
                "-fx-background-color: #39f;");
        btn_go_back.getStyleClass().add("btn-primary");
        btn_go_back.setText("Ga terug");
        btn_go_back.setOnAction(event -> {
            System.out.println("User went back.");
            PlayerSettings playerSettings = null;
            playerSettings = new PlayerSettings(this.parentScene, this.gameState);
            playerSettings.showScene();
        });
        pane.getChildren().add(btn_go_back);
        pane.getChildren().add(btn_go_settings);
        pane.getChildren().add(btn_go_game);
        this.scene = new Scene(pane, 640,480);
    }
    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }

}
