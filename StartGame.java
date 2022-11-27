package com.example.snakladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StartGame {
public AnchorPane root;
StartGame() throws IOException{
    root= FXMLLoader.load(getClass().getResource("StartGame.fxml"));

}
}
