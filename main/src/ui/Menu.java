package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300,275);

        //new SpelerApp(root);

        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
