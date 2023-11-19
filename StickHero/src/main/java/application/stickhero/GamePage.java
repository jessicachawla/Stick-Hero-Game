package application.stickhero;

import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class GamePage extends Application {
    private int cherries;
    private int score;
    private Player stickHero;

    static Stage stage1;

    private Scene scene1;

    public GamePage() {
        stage1 = new Stage();
        score = 0;
        cherries = 0;
        stickHero = new Player();
    }



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamePage.fxml"));
        Parent root = loader.load();
        scene1 = new Scene(root, 1000, 600);
        GamePageController gpc = loader.getController();
        //gpc.init(scene1);
        scene1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("gameStyle.css")).toExternalForm());
        scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                //System.out.println(keyEvent.getCode());
                gpc.extendStick(stickHero);
            }
        });
        scene1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                gpc.rotateStick(stickHero);
            }
        });
        // Set the title of the stage once
        stage1.setTitle("Stick Hero");
        stage1.setScene(scene1);
        stage1.show();
    }

    // getters

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
    }
    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
