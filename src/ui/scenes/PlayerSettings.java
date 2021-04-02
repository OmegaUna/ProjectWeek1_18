package ui.scenes;

import domain.exceptions.DomainException;
import javafx.application.Application;
import domain.game.Speler;
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

public class PlayerSettings {

    private FXMLLoader loader;
    public Scene scene;
    private final Stage parentScene;
    private final Map<String, String> gameState;
    private final Text errorLabel = new Text();

    public PlayerSettings(Stage parentScene, Map<String, String> gameState) {
        //this.loader = loader;
        this.gameState = gameState;
        this.parentScene = parentScene;
        this.parentScene.setTitle("Hangman | Player Settings");

        this.start();
    }
    public void start() {
        VBox pane = new VBox();
        pane.getChildren().add(new Text("Voor dat je begint, typ je hieronder je spelersnaam!"));

        TextField field = new TextField();

        Button btn_go_game = new Button();
        btn_go_game.setStyle("-fx-padding: 5px;" +
                "-fx-border-insets: 5px;-fx-background-insets: 5px;" +
                "-fx-background-color: #39f;");
        btn_go_game.getStyleClass().add("btn-primary");
        btn_go_game.setText("Ja, ik wil Hangman spelen!");
        btn_go_game.setOnAction(event -> {
            if ( field.getText().trim().isEmpty() ) {
                errorLabel.setText("Je moet een gebruikersnaam invullen!");
            } else {
                this.gameState.put("playerName", field.getText());
                    this.gameState.put("playerObj", this.gameState.get("playerName"));
                this.parentScene.setTitle("Hey, " + field.getText() + "!");
                System.out.println("User " + field.getText() + " went to game scene.");
                Menu menuScene = new Menu(this.parentScene, this.gameState);
                menuScene.showScene();
            }

            /* PlayerSettings straight to game
            GameCycle gameCycle = new GameCycle(this.parentScene, this.gameState);
            gameCycle.showScene(); */
        });
        pane.getChildren().add(field);
        pane.getChildren().add(this.errorLabel);
        pane.getChildren().add(btn_go_game);
        this.scene = new Scene(pane, 640,480);
    }
    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }

}
