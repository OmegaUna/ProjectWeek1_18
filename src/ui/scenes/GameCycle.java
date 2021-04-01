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

    public GameCycle(Stage parentScene, Map<String, String> gameState) throws DomainException {
        //this.loader = loader;
        this.parentScene = parentScene;
        this.gameState = gameState;
        this.parentScene.setTitle("Hangman | The Game");
        this.parentScene.setTitle("Hey, " + gameState.get("playerName") + "!");

        this.hintWoord = new HintWoord(Woordlijst.getRandomWord());
        this.startCycle(this.hintWoord, this.parentScene, inputHintText);
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

        /*MainScreenController mainScreenController = (MainScreenController) this.loader.getController();
        mainScreenController.btnGo.setOnAction(actionEvent -> {
            Menu menuScreen = new Menu(parentScene, this.loader);
            menuScreen.showScene();
        });*/
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
    }

    public void uiExecuteGuess(String guess, Stage parentScene) {
        System.out.println("Player guesses: " + guess);
        char charGuess = guess.length() == 1 ? guess.toCharArray()[0] : '*';

        if (!hintWoord.raad(charGuess)) {
            inputHintText.setText("You guessed wrong LOL, idfk how much guesses left, because someone fucked up the domain classes.");
        } else {
            inputHintText.setText("You guessed right!");
        }
        //inputHintText.setText("Your guess is not valid or has already been guessed, please try again.");
        addWordToScreen();
//        addGuessedCharsToScreen();
//        if (game.lost()) {
//            // parentScene is empty
//            System.out.println("User lost the game!");
//            ResultScreen resultScreen = new ResultScreen(parentScene, false);
//            resultScreen.showScene();

        if (hintWoord.isGeraden()) {
            // parentScene is empty
            System.out.println("You won the game!");
            ResultScreen resultScreen = new ResultScreen(parentScene, true, hintWoord.getWoord(), this.gameState);
            resultScreen.showScene();
        }
        if (hintWoord.lost()) {
            System.out.println("You lost the game!");
            ResultScreen resultScreen = new ResultScreen(parentScene, false, hintWoord.getWoord(), this.gameState);
            resultScreen.showScene();
        }
    }

    public void addWordToScreen() {
        System.out.println(hintWoord.toString());
        this.gameToPlayerText.setText(hintWoord.toString());
    }

    //    public void addGuessedCharsToScreen() {
//        System.out.println(game.getGuessedChars());
//        StringBuilder guessedChars = new StringBuilder();
//        for (String guessedChar : game.getGuessedChars()) {
//            guessedChars.append(guessedChar).append(", ");
//        }
//
//    }
    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }
}
