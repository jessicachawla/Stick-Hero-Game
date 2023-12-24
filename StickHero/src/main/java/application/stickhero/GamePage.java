package application.stickhero;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;


public class GamePage extends Application {
    private static boolean cherriesInitialized = false;
    private int cherries;
    private int score;

    private static Player stickHero;

    private static GamePageController gpc;

    public static GamePageController getGpc() {
        return gpc;
    }

    public static Player getStickHero() {
        return stickHero;
    }

    private static Stage stage1;
    private Scene scene1;

    public GamePage() {
        stage1 = new Stage();
        score = 0;
        stickHero = Player.getInstance();
        if (!cherriesInitialized) {
            cherries = 0;
            cherriesInitialized = true;
        }
    }



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamePage.fxml"));
        Parent root = loader.load();
        scene1 = new Scene(root, 400, 600);
        gpc = loader.getController();

        scene1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("gameStyle.css")).toExternalForm());
        gpc.setP1();
        gpc.displayPlatform();
        gpc.initCherries();
        scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                getPlayer().getLastKnownPosition().setX(getPlayer().getX());
                getPlayer().getLastKnownPosition().setY(getPlayer().getY());

                if (keyEvent.getCode() == KeyCode.SPACE) {
                    gpc.extendStick(stickHero);
                }
                if (keyEvent.getCode() == KeyCode.DOWN) {
                    gpc.downHero();
                }

            }
        });
        scene1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE) {
                    int val = gpc.rotateStick(stickHero);
                    score += val;
                    PauseTransition pt = new PauseTransition(Duration.seconds(1));
                    pt.setOnFinished(event -> {
                        gpc.updateScore(score);
                        gpc.checkCherryCollision(); // Check for cherry collision after rotation
                    });
                    pt.play();
                }

                if (keyEvent.getCode() == KeyCode.DOWN) {
                    gpc.upHero();
                }
            }
        });

        // Set the title of the stage once
        stage1.setTitle("Stick Hero");
        stage1.setScene(scene1);
        stage1.show();
    }

    // getters
    public static Stage getStage() {
        return stage1;
    }

    public Player getPlayer() {
        return this.stickHero;
    }
    public int getScore() {
        return this.score;
    }
    public int getCherries() {
        return this.cherries;
    }

    public void setStickHero(Player player) {
        this.stickHero = player;
    }
    public void setScore(int score) {
        this.score = score;
        gpc.updateScore(score);
    }
    public void setCherries(int cherries) {
        this.cherries += cherries;
        //gpc.setCherries(cherries);
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
