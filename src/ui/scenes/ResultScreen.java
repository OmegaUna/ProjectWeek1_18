package ui.scenes;

import domain.game.HintWoord;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Map;

public class ResultScreen{

    private final String resultText;
    private final Stage parentScene;
    private Scene scene;
    private final Map<String, String> gameState;

    public ResultScreen(Stage parentScene, boolean gameResult, String woord, Map<String, String> gameState) {
        this.parentScene = parentScene;
        this.gameState = gameState;
        this.parentScene.setTitle("Hangman | Result");
        this.parentScene.setTitle("Hey, " + gameState.get("playerName") + "!");
        this.resultText = String.format("Het woord was %s. ", woord).concat((gameResult) ? "You won the game you smart-ass!" : "You lost the game.. Sorry!");
        start();
    }

    public void start() {
        System.out.println(this.resultText);
        VBox pane = new VBox();
        pane.getChildren().add(new Text(this.resultText));

        Button btn_go_menu = new Button();
        btn_go_menu.getStyleClass().add("btn-primary");
        btn_go_menu.setText("Menu");
        btn_go_menu.setOnAction(event -> {
            System.out.println("User went to menu.");
            Menu menu = new Menu(this.parentScene, this.gameState);
            menu.showScene();
        });
        pane.getChildren().add(btn_go_menu);
        this.scene = new Scene(pane, 640,480);
    }

    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }
}
