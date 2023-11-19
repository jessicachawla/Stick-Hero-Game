package application.stickhero;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainPageController {
    @FXML
    private ImageView volumeButton;
    @FXML
    private ImageView questionButton;
    @FXML
    private ImageView leaderBoardButton;
    @FXML
    private ImageView viewSavedButton;

    @FXML
    private Rectangle questionBox;
    @FXML
    private Text questionText;


    int buttonID = 1;
    int questionID = 1;
    public void ques() {
        System.out.println("questionMark pressed");
        if (questionID == 1) {
            questionBox.setOpacity(1.0);
            questionText.setOpacity(1.0);
            questionID = 2;
        } else {
            questionBox.setOpacity(0.0);
            questionText.setOpacity(0.0);
            questionID = 1;
        }

    }
    public void leaderBoard() throws IOException {
        // get from saved games
        System.out.println("leaderboard pressed");
        if (questionID != 1) {
            questionBox.setOpacity(0.0);
            questionText.setOpacity(0.0);
            questionID = 1;
        }

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("leaderBoard.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void volume() {
        //System.out.println(volumeButton.getX());
        System.out.println("volume button pressed");
        if (questionID != 1) {
            questionBox.setOpacity(0.0);
            questionText.setOpacity(0.0);
            questionID = 1;
        }
        if (buttonID == 1) {
            Image mute = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Assets/muteButton.png")));
            volumeButton.setImage(mute);
            buttonID = 2;
        } else {
            Image mute = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Assets/volumeButton2.png")));
            volumeButton.setImage(mute);
            buttonID = 1;
        }

    }

    public void play() throws IOException {
        System.out.println("Play button was pressed");
        if (questionID != 1) {
            questionBox.setOpacity(0.0);
            questionText.setOpacity(0.0);
            questionID = 1;
        }
        MainPage.stage1.close();
        GamePage gp = new GamePage();
        try {
            gp.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public void viewSavedGames() {
        // get all saved games and list them in the scene
    }

}
