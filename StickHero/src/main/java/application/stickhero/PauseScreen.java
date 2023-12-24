package application.stickhero;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PauseScreen extends Application {


    private PauseScreenController pauseScreenController;
    private static Stage stage1;

    public static Stage getStage1() {
        return stage1;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage1 = new Stage();
        //System.out.println(sc.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pauseScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, Color.AQUA);
        pauseScreenController = loader.getController();
        //exitScreenController.setHighscore(GamePage.getHighscore());

        stage1.setScene(scene);
        stage1.show();
    }

    // setter
    public void setScore(String s) {
        pauseScreenController.setScore(s);
    }

}
