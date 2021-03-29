package ui;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;

public class Menu extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300,275);

        //new SpelerApp(root);
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        VBox pane = new VBox();
        Scene scene = new Scene(pane, 640,480);

        //new SpelerApp(root);
        Text title = new Text();
        title.setText("Dit is Hangman!");
        //title.setFont(new Font.font("Sans serif", ));

        pane.getChildren().add(title);

        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
