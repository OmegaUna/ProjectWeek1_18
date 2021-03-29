package ui.scenes;

import javafx.stage.Stage;

public class ResultScreen implements IScene{
    private final String resultText;
    private Stage parentScene;
    public ResultScreen(Stage parentScene, boolean gameResult) {
        this.resultText = (gameResult) ? "Hey! You won the game you smart-ass!" : "You lost the game.. Sorry!";
    }

    @Override
    public void Menu(Stage parentScene) {
        this.parentScene = parentScene;
    }

    @Override
    public void start() {
        System.out.println(this.resultText);
    }

    public void showScene() {
        this.parentScene.setScene(this.scene);
        this.parentScene.show();
    }
}
