package ui.scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameCycle extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        //x
        VBox pane = new VBox();
        Scene scene = new Scene(pane, 640,480);

        //new Game(root);
        Text title = new Text();
        title.setText("Dit is Hangman!");
        //title.setFont(new Font.font("Sans serif", ));

        TextField field = new TextField();
        field.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER) System.out.println(field.getText());
            }
        });
        Button submit_btn = new Button();
        submit_btn.setText("Try character");
        submit_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(field.getText());
            }
        });
        pane.getChildren().add(title);
        pane.getChildren().add(field);
        pane.getChildren().add(submit_btn);

        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
