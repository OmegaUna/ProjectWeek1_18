package ui.scenes;

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
    private Game game;
    private Scene scene;
    private final Stage parentScene;
    private int MAXGUESSES = 14;

    public GameCycle(Stage parentScene) {
        this.parentScene = parentScene;
        this.parentScene.setTitle("Hangman");

        Player player = new Player("Speler1");
        this.game = new Game("polymorphism", player, MAXGUESSES);
        this.startCycle(this.game, this.parentScene, new Text(""));
    }
    public void startCycle(Game game, Stage parentScene, Text inputHintText) {
        boolean epicGamerMoment = true;

        VBox pane = new VBox();
        pane.getChildren().add(new Text("Dit is Hangman! Gok hieronder je letters!"));

        TextField field = new TextField();
        field.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("Player guesses on: " + field.getText());

                if ( game.isValidGuess(field.getText()) ) {
                    if (!game.guess(field.getText())) {
                        game.addWrongGuess();
                        inputHintText.setText("You guessed wrong LOL, " + (game.getMaxGuesses() - game.getWrongGuesses()) + " guesses left.");
                    }
                } else {
                    inputHintText.setText("Your guess is not valid, please try again.");
                }
                if ( !game.complete() && !game.lost() ) {
                    ResultScreen resultScreen = new ResultScreen(parentScene, false);
                    resultScreen.showScene();
                }
            }
        });
        Button submit_btn = new Button();
        submit_btn.setText("Try character");
        // can be replaced by a lambda
        submit_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(field.getText());
            }
        });
        pane.getChildren().add(field);
        pane.getChildren().add(submit_btn);
        this.scene = new Scene(pane, 640,480);
    }
    public void cycle() {
            do {
                System.out.println("Guess a character: ");
                guess = s.nextLine();
            } while (!game.isValidGuess(guess));
            if (!game.guess(guess)) {
                game.addWrongGuess();
            }
    }
    public void addWordToScreen() {
        System.out.println(game.getWordState("_"));
         return game.getWordState("_");
    }
    public void addGuessedCharsToScreen() {
        System.out.println(game.getGuessedChars());
         return game.getGuessedChars();
    }
    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }
}
