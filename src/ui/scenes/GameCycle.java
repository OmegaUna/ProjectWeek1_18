package ui.scenes;

import domain.exceptions.DomainException;
import javafx.fxml.FXMLLoader;
import domain.game.Game;
import domain.game.Speler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameCycle {
    private FXMLLoader loader;
    private Game game;
    private Scene scene;
    private final Stage parentScene;
    private int MAXGUESSES = 14;
    private Text inputHintText = new Text("");
    private Text gameToPlayerText = new Text("");
    private Text guessedCharsText = new Text("");

    public GameCycle(Stage parentScene) throws DomainException {
        //this.loader = loader;
        this.parentScene = parentScene;
        this.parentScene.setTitle("Hangman | The Game");

        Speler speler = new Speler("Speler1");
        this.game = new Game("polymorphism", speler, MAXGUESSES);
        this.startCycle(this.game, this.parentScene, inputHintText);
    }
    public void startCycle(Game game, Stage parentScene, Text inputHintText) {
        boolean epicGamerMoment = true;

        VBox pane = new VBox();
        pane.getChildren().add(new Text("Dit is Hangman! Gok hieronder je letters!"));

        TextField field = new TextField();
        field.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                uiExecuteGuess(field.getText(), parentScene);
                field.setText("");
            }
        });

        Button submit_btn = new Button();
        submit_btn.setText("Try character");
        submit_btn.getStyleClass().add("btn-primary");
        submit_btn.setOnAction(actionEvent -> {
            uiExecuteGuess(field.getText(), parentScene);
            field.setText("");
        });

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
        pane.getChildren().add(guessedCharsText);
        this.scene = new Scene(pane, 640,480);
    }
    public void uiExecuteGuess(String guess, Stage parentScene) {
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
        if ( game.lost() ) {
            // parentScene is empty
            System.out.println("User lost the game!");
            ResultScreen resultScreen = new ResultScreen(parentScene, false);
            resultScreen.showScene();
        } else if ( game.complete() ) {
            // parentScene is empty
            System.out.println("User won the game!");
            ResultScreen resultScreen = new ResultScreen(parentScene, true);
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
        this.guessedCharsText.setText("Gegokte letters: " + guessedChars.toString());

    }
    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }
}
