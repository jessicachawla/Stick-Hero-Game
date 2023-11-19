package application.stickhero;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Player extends Position {
    private String name;

    public Player() {
        name = "Stick Hero";
    }
    // getters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void moveForward(ImageView player) {
        // set the position for hero object also this.___ karke
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1), player);
        translate.setNode(player);
        translate.setToX(100);
        translate.play();
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1)); // 2 seconds delay
        pauseTransition.setOnFinished(event -> {
            try {
                fallDown(player);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }); // Start rotation after delay
        pauseTransition.play();
    }

    public void collectCherry() {

    }
    public void fallDown(ImageView player) throws Exception {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(player);
        rotate.setByAngle(180);
        rotate.play();
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1), player);
        translate.setNode(player);
        translate.setToY(400);
        translate.play();
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1)); // 2 seconds delay
        pauseTransition.setOnFinished(event -> {
            ExitScreen exitScreen = new ExitScreen();
            try {
                exitScreen.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }); // Start rotation after delay
        pauseTransition.play();

    }


}
