package ui.scenes;

import domain.exceptions.DomainException;
import domain.game.HintWoord;
import domain.game.Woordlijst;
import javafx.fxml.FXMLLoader;
import domain.game.Speler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Map;

public class GameCycle {

    private FXMLLoader loader;
    private HintWoord hintWoord;
    private Scene scene;
    private final Stage parentScene;
    private int MAXGUESSES = 14;
    private Text inputHintText = new Text("");
    private Text gameToPlayerText = new Text("");
    private Map<String, String> gameState;
    private int guesses = 0;

    public GameCycle(Stage parentScene, Map<String, String> gameState) throws DomainException {
        this.parentScene = parentScene;
        this.gameState = gameState;
        this.parentScene.setTitle("Hangman | The Game");
        this.parentScene.setTitle("Hey, " + gameState.get("playerName") + "!");
        this.hintWoord = new HintWoord(Woordlijst.getRandomWord());
        this.startCycle(this.hintWoord, this.parentScene, inputHintText);
        this.guesses = 0;
    }

    public void startCycle(HintWoord hintWoord, Stage parentScene, Text inputHintText) {
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
        stop_game_btn.setOnAction(actionEvent -> {
            Menu menuScreen = new Menu(parentScene, this.gameState);
            //Menu menuScreen = new Menu(parentScene, this.loader);
            menuScreen.showScene();
        });

        pane.getChildren().add(field);
        pane.getChildren().add(inputHintText);
        pane.getChildren().add(submit_btn);
        pane.getChildren().add(stop_game_btn);
        pane.getChildren().add(gameToPlayerText);
        this.scene = new Scene(pane, 640, 480);

        this.gameToPlayerText.setText(hintWoord.toString());
    }

    public void uiExecuteGuess(String guess, Stage parentScene) {
        System.out.println("Player guesses: " + guess);
        char charGuess = guess.length() == 1 ? guess.toCharArray()[0] : '*';

        if (!hintWoord.raad(charGuess)) {
            this.guesses++;
            inputHintText.setText(String.format("You guessed wrong LOL XD %d guesses left.", hintWoord.MAXGUESSES - this.guesses));
        } else {
            inputHintText.setText("You guessed right!");
        }
        addWordToScreen();

        if (hintWoord.isGeraden()) {
            // parentScene is empty
            System.out.println("You won the game!");
            ResultScreen resultScreen = new ResultScreen(parentScene, true, hintWoord.getWoord(), this.gameState);
            resultScreen.showScene();
        }
        if (this.guesses == hintWoord.MAXGUESSES) {
            System.out.println("You lost the game!");
            ResultScreen resultScreen = new ResultScreen(parentScene, false, hintWoord.getWoord(), this.gameState);
            resultScreen.showScene();
        }
    }

    public void addWordToScreen() {
        System.out.println(hintWoord.toString());
        this.gameToPlayerText.setText(hintWoord.toString());
    }

    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }
}
