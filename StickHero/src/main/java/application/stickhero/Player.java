package application.stickhero;

import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Position {
    private String name;
    private static Player instance = null;

    public Position getLastKnownPosition() {
        return lastKnownPosition;
    }


    private Position lastKnownPosition = new Position();
    public static Player getInstance(){
        if(instance==null){
            instance= new Player();
        }
        return instance;
    }

    private Player() {
        name = "Stick Hero";
    }
    // getters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean moveForward(ImageView player, Platform p1, Platform p2, Rectangle stick, AnchorPane anchorPane) {


        double valStick = stick.getLayoutX() + stick.getHeight();
        TranslateTransition translatePlayer = new TranslateTransition(Duration.seconds(1), player);
        translatePlayer.setToX(valStick - 50);
        translatePlayer.play();


        if (valStick > p2.platform.getX() && valStick < p2.platform.getX() + p2.platform.getWidth()) {

            //p2.platform.setX(0);
            PauseTransition pt = new PauseTransition(Duration.seconds(1));
            pt.setOnFinished(event -> {
                //p2.platform.setTranslateX(0);

                stick.setX(player.getLayoutX()+15);
                stick.setHeight(1);
                stick.getTransforms().clear();
                anchorPane.getChildren().remove(p1.platform);

                TranslateTransition translatePlatform = new TranslateTransition(Duration.seconds(1), p2.platform);
                translatePlatform.setToX(-p2.platform.getX());
                translatePlatform.play();
                p1.platform = p2.platform;
//                Rectangle r = new Rectangle();
//                r.setWidth(10);
//                r.setHeight(10);
//                r.setFill(Color.BROWN);
//                r.setX(p2.platform.getTranslateX() + p2.getWidth()/2);
//                r.setY(300);
//                anchorPane.getChildren().add(r);

                TranslateTransition tp = new TranslateTransition(Duration.seconds(1), player);
                double init = player.getX();
                //tp.setToX(p2.platform.getTranslateX() + p2.getWidth()/2 - 50);
                tp.setToX(init);
                tp.play();

            });
            pt.play();
            return true;

        } else {
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
            pauseTransition.setOnFinished(event -> {
                try {
                    fallDown(player);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            pauseTransition.play();
            return false;
        }
    }

//        Platform p = platformList.get(0);
//
//        if (p.getX() > x) {
//
//            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1)); // 2 seconds delay
//            pauseTransition.setOnFinished(event -> {
//                try {
//                    fallDown(player);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }); // Start rotation after delay
//            pauseTransition.play();
//            return true;
//        } else if (p.getX()+p.getWidth() < x) {
//
//            double y = p.getX();
//            while (y < x) {
//                count += 1;
//                //Platform removed = platformList.remove(0);
//                PauseTransition pt = new PauseTransition(Duration.seconds(1));
//                pt.setOnFinished(event -> anchorPane.getChildren().remove(platformList.remove(0).platform));
//                p = platformList.get(0);
//                y = p.getX();
//                if (y < x && x < y + p.getWidth()) {
//                    System.out.println("ME IS HERE");
//                    return false;
//
//                }
//                pt.play();
//
//            }
//
//        } else {
//            count += 1;
//            return false;
//        }
//
//
//            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1)); // 2 seconds delay
//            pauseTransition.setOnFinished(event -> {
//                try {
//                    fallDown(player);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }); // Start rotation after delay
//            pauseTransition.play();
//        return true;






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


    }

    public void reviveBack(ImageView player) throws Exception {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(player);
        rotate.setByAngle(-180);
        rotate.play();
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1), player);
        translate.setNode(player);
        translate.setToY(lastKnownPosition.getY());
        translate.setToX(lastKnownPosition.getX());
        translate.play();


    }



}
