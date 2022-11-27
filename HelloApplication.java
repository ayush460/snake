package com.example.snakladder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;
    @Override

    public void start(Stage primaryStage) throws IOException {

root=new Group();
        //primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.setTitle("Snake And Ladder");
        StartGame start=new StartGame();
        root.getChildren().add(start.root);
Scene ok=new Scene(root,800,500);
ok.setFill(Color.web("RED"));
primaryStage.setScene(ok);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}