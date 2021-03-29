package ui.scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;
import ui.MainScreenController;
import ui.logic.Game;
import ui.logic.Player;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameCycle {
    private FXMLLoader loader;
    private Game game;
    private Scene scene;
    private final Stage parentScene;
    private int MAXGUESSES = 14;
    private Text inputHintText = new Text("");
    private Text gameToPlayerText = new Text("");

    public GameCycle(Stage parentScene) {
        //this.loader = loader;
        this.parentScene = parentScene;
        this.parentScene.setTitle("Hangman");

        Player player = new Player("Speler1");
        this.game = new Game("polymorphism", player, MAXGUESSES);
        this.startCycle(this.game, this.parentScene, inputHintText);
    }
    public void startCycle(Game game, Stage parentScene, Text inputHintText) {
        boolean epicGamerMoment = true;

        VBox pane = new VBox();
        pane.getChildren().add(new Text("Dit is Hangman! Gok hieronder je letters!"));

        TextField field = new TextField();
        field.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                uiExecuteGuess(field.getText());
                field.setText("");
            }
        });

        Button submit_btn = new Button();
        submit_btn.setText("Try character");
        submit_btn.getStyleClass().add("btn-primary");
        submit_btn.setOnAction(actionEvent -> uiExecuteGuess(field.getText()));

        Button stop_game_btn = new Button();
        stop_game_btn.getStyleClass().add("btn-danger");
        stop_game_btn.setText("Stop game");

        /*MainScreenController mainScreenController = (MainScreenController) this.loader.getController();
        mainScreenController.btnGo.setOnAction(actionEvent -> {
            Menu menuScreen = new Menu(parentScene, this.loader);
            menuScreen.showScene();
        });*/
        stop_game_btn.setOnAction(actionEvent -> {
            Menu menuScreen = new Menu(parentScene);
            //Menu menuScreen = new Menu(parentScene, this.loader);
            menuScreen.showScene();
        });

        pane.getChildren().add(field);
        pane.getChildren().add(inputHintText);
        pane.getChildren().add(submit_btn);
        pane.getChildren().add(stop_game_btn);
        pane.getChildren().add(gameToPlayerText);
        this.scene = new Scene(pane, 640,480);
    }
    public void uiExecuteGuess(String guess) {
        System.out.println("Player guesses on: " + guess);

        if ( game.isValidGuess(guess) ) {
            if (!game.guess(guess)) {
                game.addWrongGuess();
                inputHintText.setText("You guessed wrong LOL, " + (game.getMaxGuesses() - game.getWrongGuesses()) + " guesses left.");
            } else {
                inputHintText.setText("You guessed right!");
            }
        } else {
            inputHintText.setText("Your guess is not valid or has already been guessed, please try again.");
        }
        addWordToScreen();
        addGuessedCharsToScreen();
        if ( game.complete() && game.lost() ) {
            // parentScene is empty
            ResultScreen resultScreen = new ResultScreen(parentScene, false);
            resultScreen.showScene();
        }
    }
    public void addWordToScreen() {
        System.out.println(game.getWordState("_"));
        this.gameToPlayerText.setText(game.getWordState("_"));
    }
    public void addGuessedCharsToScreen() {
        System.out.println(game.getGuessedChars());
        StringBuilder guessedChars = new StringBuilder();
        for (String guessedChar : game.getGuessedChars()) {
            guessedChars.append(guessedChar).append(", ");
        }
        this.gameToPlayerText.setText("Gegokte letters: " + guessedChars.toString());

    }
    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }
}
