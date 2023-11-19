package application.stickhero;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePageController {
    @FXML
    Rectangle stick;
    @FXML
    private ImageView pauseButton;
    @FXML
    private ImageView player;
    @FXML
    private Label score;
    @FXML
    private Label cherries;
    double i = 1.0;
    public void extendStick(Player play) {
        //stick.setOpacity(1.0);
        Stick s = new Stick(play);
        // we create stick near the player using its position information
        i = i + 0.5;
        stick.setScaleY(i);
        //stick.setHeight(stick.getHeight() + 1);
        double x = stick.getX();
        double y = stick.getY();

//        System.out.println(x);
//        System.out.println(y);


    }
    public void rotateStick(Player hero) {
        this.stick.setTranslateX(this.player.getX() + this.stick.getHeight());
        this.stick.setTranslateY(this.stick.getY() + this.stick.getHeight() / 2);

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(this.stick);
        rotate.setDuration(Duration.millis(1000));
        rotate.setByAngle(90);
        rotate.play();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1)); // 2 seconds delay
        pauseTransition.setOnFinished(event -> hero.moveForward(this.player)); // Start rotation after delay
        pauseTransition.play();
    }

    public void exitGame() throws Exception {
        ExitScreen exitScreen = new ExitScreen();
        exitScreen.start(new Stage());
    }

    public void displayPlatform() {
        // Platform platform = new Platform();
        // creates rectangle and positions the platform accordingly
        // as gets (x,y) and length and width from the platform object
    }

    public void displayCherry() {
        // Cherry cherry = new Cherry()
        // creates imageview to display cherry at sent position
        // as gets (x,y) from the cherry object
    }

    public void disappearCherry() {
        // checks if cherry present
        // if stickhero position == cherry position then removes it and updates cherry count
        // remove it
    }

    public void setScore() {
        // update score in label
        // update score in gamepage
        // update for the player also
    }
    public void setCherries() {
        // update cherry in label
        // update cherry in gamepage
        // update for the player also
    }
}
