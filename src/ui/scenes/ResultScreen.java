package ui.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultScreen{
    private final String resultText;
    private Stage parentScene;
    private Scene scene;
    public ResultScreen(Stage parentScene, boolean gameResult) {
        this.parentScene = parentScene;
        this.parentScene.setTitle("Hangman | Result");
        this.resultText = (gameResult) ? "Hey! You won the game you smart-ass!" : "You lost the game.. Sorry!";
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
            Menu menu = new Menu(this.parentScene);
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
