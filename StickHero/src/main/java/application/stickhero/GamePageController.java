package application.stickhero;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.PatternSyntaxException;

public class GamePageController {
    @FXML
    Rectangle stick;
    @FXML
    private ImageView pauseButton;
    @FXML
    private ImageView player;

    public Rectangle getStick() {
        return stick;
    }

    public ImageView getPlayer() {
        return player;
    }

    @FXML
    private Label score;
    @FXML
    private Label cherries;
    private ImageView cherry;
    @FXML
    Rectangle plat;
    @FXML
    AnchorPane anchorPane;
    private static Platform p1;
    private boolean flag;

    private int n;
    public static Platform getP1() {
        return p1;
    }

    public static Platform getP2() {
        return p2;
    }

    private static Platform p2;

    double i = 1.0;
    public void setP1() {
        p1 = new Platform(0);
        p1.platform = plat;
        p1.setX(this.plat.getX());
        p1.setY(this.plat.getY());
        p1.setWidth(plat.getWidth());

    }

    public void extendStick(Player play) {

        //System.out.println(this.stick.getHeight() + " Height");
        if (this.stick.getHeight() == 1.0) {
            i = 1.0;
        }
        i = i + 5;
        this.stick.setHeight(i);
        double height = this.stick.getHeight();
        this.stick.setY(-height);


    }

    public ImageView getCherry() {
        return cherry;
    }

    public int rotateStick(Player hero ){
        //Stick s = new Stick(hero);
        double x = this.player.getLayoutX() + this.player.getFitWidth() + this.stick.getHeight() + this.player.getTranslateX();
        System.out.println(x);
        Rotate rotate = new Rotate();

        rotate.setPivotX(this.stick.getX());
        rotate.setPivotY(0);
        rotate.setAngle(90);

        this.stick.getTransforms().add(rotate);

        boolean result = hero.moveForward(this.player, p1, p2, this.stick, anchorPane);

        //    Rectangle r = new Rectangle();
        //    r.setWidth(10);
        //    r.setHeight(10);
        //    r.setX(p1.platform.getLayoutX());
        //    r.setY(p1.platform.getLayoutY());
        //    r.setFill(Color.CRIMSON);

        //    Rectangle r2 = new Rectangle();
        //    r2.setWidth(10);
        //    r2.setHeight(10);
        //    System.out.println(p2.platform.getX() + "DIffs " + p2.platform.getY());
        //    r2.setX(p2.getWidth());
        //    r2.setY(p2.platform.getY());
        //    r2.setFill(Color.YELLOW);

        //    Rectangle r3 = new Rectangle();
        //    r3.setWidth(10);
        //    r3.setHeight(10);
        //    System.out.println(this.stick.getLayoutX() + this.stick.getHeight());
        //    r3.setX(this.stick.getLayoutX() + this.stick.getHeight());
        //    r3.setY(this.stick.getLayoutY());
        //    r3.setFill(Color.BLACK);

        //    Rectangle r4 = new Rectangle();
        //    r4.setWidth(10);
        //    r4.setHeight(10);
        //    r4.setX(p2.platform.getX());
        //    r4.setY(300);
        //    r4.setFill(Color.BLACK);
        //    System.out.println("PEOIFJS getx" + p2.platform.getX());
        // //    System.out.println("PEOIFJS layout " + p2.platform.getLayoutX());
        // //    System.out.println("PEOIFJS translate" + p2.platform.getTranslateX());

        //     Rectangle r5 = new Rectangle();
        //    r5.setWidth(10);
        //    r5.setHeight(10);
        //    r5.setX( p1.platform.getLayoutX() + p1.platform.getWidth());
        //    r5.setY(300);
        //    r5.setFill(Color.GREEN);
        //    anchorPane.getChildren().add(r5);
        //    anchorPane.getChildren().add(r4);
        //    anchorPane.getChildren().add(r);
        //    anchorPane.getChildren().add(r2);
        //    anchorPane.getChildren().add(r3);

        if (result) {
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
            pauseTransition.setOnFinished(event -> {
//            rotateBack();
//            this.stick.setX(this.player.getLayoutX()+15);
//            this.stick.setHeight(1);
                anchorPane.getChildren().remove(cherry);
                flag = false;
                displayPlatform();
            });
            pauseTransition.play();
            return 1;
        } else {
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1)); // 2 seconds delay
            pauseTransition.setOnFinished(event -> {
                try {
                    exitGame();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }); // Start rotation after delay
            pauseTransition.play();
        }


//        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1)); // 2 seconds delay
//        pauseTransition.setOnFinished(event -> {
//            if (res) {
//                anchorPane.getChildren().remove(this.stick);
//            } else {
//                rotateBack();
//                this.stick.setX(this.stick.getX() + this.stick.getHeight());
//                this.stick.setHeight(1);
//            }
//        });
//        pauseTransition.play();// Start rotation after delay
//

        return 0;
    }
    public void rotateBack() {
        this.stick.getTransforms().clear();


    }

    public void pauseScreen() throws Exception {
        PauseScreen pauseScreen= new PauseScreen();
        pauseScreen.start(PauseScreen.getStage1());
        pauseScreen.setScore(this.score.getText());

    }
    public void exitGame() throws Exception {
        int score = Integer.parseInt(this.score.getText());
        if (score > MainPage.getHighscore()) {
            MainPage.setHighscore(score);
            System.out.println("High score: " + MainPage.getHighscore());
        }
        ExitScreen exitScreen = new ExitScreen();

        exitScreen.start(ExitScreen.getStage());
        System.out.println("THE SCORE IS : " + this.score.getText());
        exitScreen.setScore(this.score.getText());


    }



    public void displayPlatform() {
        n++;


        Random r = new Random();
        double x = r.nextInt(250);
        if (x<p1.platform.getWidth() + p1.platform.getLayoutX()) {
            x = p1.platform.getWidth() + 100 + p1.platform.getLayoutX();
        }

        int y = r.nextInt(100);
        p2 = new Platform(x);
        Rectangle platform = new Rectangle();
        platform.setWidth(p2.getWidth());
        platform.setHeight(300);
        platform.setX(200+y);
        platform.setY(p2.getY());
        System.out.println("p.setX value : " + x + " platfrom x: " + platform.getX());
        platform.setFill(Color.BLACK);
        p2.platform = platform;
        if (n == 2) {
            flag = displayCherry();
            n = 0;
        }


        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), platform);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        anchorPane.getChildren().add(platform);
        fadeIn.play();


        //disappearCherry(i);
    }

    public void downHero() {
        this.player.setScaleY(-1);
        this.player.setY(this.player.getFitHeight()-20);
//
    }
    public void upHero() {
        this.player.setScaleY(1);
        this.player.setY(-5);
    }

    public boolean displayCherry() {
        // Cherry cherry = new Cherry()
        // creates imageview to display cherry at sent position
        // as gets (x,y) from the cherry object
        Random r = new Random();
        double start = p1.platform.getLayoutX() + p1.platform.getWidth();
        double end = p2.platform.getX();

        if ((end - start) < 50) {
            System.out.println("no space" + (start-end));
            return false;
        }
        double x = r.nextInt((int) end - 30);


        Image i = new Image("C:\\Users\\91989\\Documents\\herouncle\\StickHero\\src\\main\\resources\\application\\stickhero\\Assets\\cherry2.png");
        cherry = new ImageView(i);
        cherry.setFitHeight(30);
        cherry.setFitWidth(30);

        cherry.setX(x);
        cherry.setY(310);
        anchorPane.getChildren().add(cherry);
        return true;
    }

    public void disappearCherry(ImageView i) {

        anchorPane.getChildren().remove(i);
    }

    public void updateScore(int score) {

        System.out.println(score);
        this.score.setText(String.valueOf(score));

    }
    public void setCherries() {

        int val = Integer.parseInt(cherries.getText());
        MainPage.setCherr(val+1);
        this.cherries.setText(String.valueOf(val + 1));
    }

    public void initCherries() {
        this.cherries.setText(String.valueOf(MainPage.getCherr()));
    }

    public void checkCherryCollision() {

        //System.out.println(flag);
        if (this.cherry != null) {
            Bounds playerBounds = this.player.getBoundsInParent();
            Bounds cherryBounds = this.cherry.getBoundsInParent();
            System.out.println("Fijdojs");
            System.out.println("PLayerBounds: " + playerBounds);
            System.out.println("CHerry Bounds: " + cherryBounds);
            System.out.println(playerBounds.intersects(cherryBounds));
            if (playerBounds.intersects(cherryBounds)) {
                System.out.println("hellllllll");
                this.setCherries();

            }


        }

    }
}
