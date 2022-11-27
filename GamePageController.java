package com.example.snakladder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static com.example.snakladder.HelloApplication.root;

public class GamePageController {
    @FXML
    Text number;
    @FXML
    Text turnnumber;
    @FXML
    ImageView player1;
    @FXML
    ImageView player2;

    int turn = 1;
    HashMap<Pair<Double, Double>, Pair<Double, Double>> snakeLadderCoordinatesChanges;

    @FXML
    public void rolldice(MouseEvent event) throws IOException {
        getSnakeLadderCooardinates();
        Random random = new Random();
        int randomnumber = random.nextInt(6) + 1;

        number.setText("" + randomnumber);
        if (turn == 1) {
            double moveX = player1.getTranslateX();
            System.out.println(moveX);
            double moveY = player1.getTranslateY();
            Pair<Double, Double> movementcoardinant = movement(moveX, moveY, randomnumber);
            player1.setTranslateX(movementcoardinant.getKey());
            player1.setTranslateY(movementcoardinant.getValue());
            if (snakeLadderCoordinatesChanges.containsKey(movementcoardinant)) {
                player1.setTranslateX(snakeLadderCoordinatesChanges.get(movementcoardinant).getKey());
                player1.setTranslateY(snakeLadderCoordinatesChanges.get(movementcoardinant).getValue());
            }
            checkwint(player1.getTranslateX(), player1.getTranslateY());

        } else {
            double moveX = player2.getTranslateX();
            System.out.println(moveX);
            double moveY = player2.getTranslateY();
            Pair<Double, Double> movementcoardinant = movement(moveX, moveY, randomnumber);
            player2.setTranslateX(movementcoardinant.getKey());
            player2.setTranslateY(movementcoardinant.getValue());
            if (snakeLadderCoordinatesChanges.containsKey(movementcoardinant)) {
                player2.setTranslateX(snakeLadderCoordinatesChanges.get(movementcoardinant).getKey());
                player2.setTranslateY(snakeLadderCoordinatesChanges.get(movementcoardinant).getValue());
            }
            checkwint(player2.getTranslateX(), player2.getTranslateY());

        }
        if (randomnumber != 6) {
            if (turn == 1) {
                turnnumber.setText("Player 2 Turn");
                turn = 2;
            } else {
                turnnumber.setText("Player 1 Turn");
                turn = 1;
            }
        }
    }

    Pair<Double, Double> movement(double moveX, double moveY, int randomnumber) {
        double x=moveX;
        double y=moveY;
        if (moveY % 100 == 0) {
            moveX += randomnumber * 50;
            if (moveX > 500) {
                moveX = 500 * 2 - moveX + 50;
                moveY -= 50;
            }
        } else {
            moveX -= randomnumber * 50;
            if (moveX < 50) {
                if(moveY==-450){
                    return new Pair<>(x,y);
                }
                moveX = -1 * (moveX - 50);
                moveY -= 50;
            }
        }
        return new Pair<>(moveX, moveY);
    }

    void getSnakeLadderCooardinates() {
        snakeLadderCoordinatesChanges = new HashMap<>();
        snakeLadderCoordinatesChanges.put(new Pair<>(50.0, 0.0), new Pair<>(150.0, -150.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(50.0, 0.0), new Pair<>(150.0, -150.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(200.0, -50.0), new Pair<>(350.0, -50.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(200.0, 0.0), new Pair<>(350.0, 0.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(450.0, 0.0), new Pair<>(500.0, -150.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(50.0, -100.0), new Pair<>(150.0, -150.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(400.0, -100.0), new Pair<>(200.0, -400.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(100.0, -300.0), new Pair<>(100.0, -50.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(50.0, 0.0), new Pair<>(150.0, -150.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(500.0, -250.0), new Pair<>(350.0, -300.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(500.0, -350.0), new Pair<>(500.0, -450.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(50.0, -350.0), new Pair<>(50.0, -450.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(200.0, -300.0), new Pair<>(20.0, -250.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(350.0, -250.0), new Pair<>(350.0, -150.0));
        snakeLadderCoordinatesChanges.put(new Pair<>(150.0, -450.0), new Pair<>(100.0, -350.0));



    }

    void checkwint(Double X, Double Y)  throws IOException
    {
        if (X == 50.0 && Y == -450.0) {
            Alert resultalert = new Alert(Alert.AlertType.INFORMATION);
            resultalert.setHeaderText("RESULT");
            if (turn == 1) {
                resultalert.setContentText("1 is winner");
                resultalert.showAndWait();

            } else {
                resultalert.setContentText("2 is winner");
                resultalert.showAndWait();
            }
            StartGame start=new StartGame();
            HelloApplication.root.getChildren().setAll(start.root);
        }
    }
}