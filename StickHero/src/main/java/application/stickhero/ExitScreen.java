package application.stickhero;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ExitScreen extends Application {
    @FXML
    private ImageView reviveButton;
    @FXML
    private ImageView restartButton;
    @FXML
    private ImageView homeButton;
    private static Stage stage1 = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("exitScreen.fxml")));
        //stage1 = new Stage();
        Scene scene = new Scene(root, Color.AQUA);
        stage1.setScene(scene);
        stage1.show();
    }

    public void reviveGame() throws IOException {
        GamePage.stage1.close();
        stage1.close();
        GamePage gp = new GamePage();
        try {
            gp.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void restartGame() throws IOException {
        GamePage.stage1.close();
        stage1.close();
        GamePage gp = new GamePage();
        gp.start(new Stage());
//        try {
//            gp.start(new Stage());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
    public void saveGame() {

    }
    public void goHome() {
        saveGame();
        GamePage.stage1.close();
        stage1.close();
        MainPage main = new MainPage();
        try {
            main.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
