package ui.scenes;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface IScene {

    Scene scene = null;
    Stage parentScene = null;

    default void Menu(Stage parentScene) {
        this.start();
    }
    void start();
    void showScene();

}






