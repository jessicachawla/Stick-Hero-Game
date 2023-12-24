package application.stickhero;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainPageController {
    @FXML
    private ImageView volumeButton;
    @FXML
    private ImageView questionButton;

    public static void setGp(GamePage gp) {
        MainPageController.gp = gp;
    }

    @FXML
    private ImageView viewSavedButton;

    @FXML
    private Rectangle questionBox;
    @FXML
    private Text questionText;

    private static GamePage gp;

    public static GamePage getGp() {
        return gp;
    }

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

    public void playBackgroundMusic() {
//        String mp3FilePath = "path/to/your/file.mp3";
//
//        Media media = new Media(new File(mp3FilePath).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//
//        mediaPlayer.setOnReady(() -> {
//            // Print duration of the audio file
//            System.out.println("Duration: " + mediaPlayer.getTotalDuration().toSeconds() + " seconds");
//        });
//
//        mediaPlayer.setOnEndOfMedia(() -> {
//            // When the audio finishes playing, stop the player
//            mediaPlayer.stop();
//        });
//
//        mediaPlayer.play();
    }

    public void play() throws IOException {
        System.out.println("Play button was pressed");
        if (questionID != 1) {
            questionBox.setOpacity(0.0);
            questionText.setOpacity(0.0);
            questionID = 1;
        }
        MainPage.getStage().close();
        gp = new GamePage();
        try {
            gp.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public void viewSavedGames() throws Exception {
        // get all saved games and list them in the scene
        SavedGameScreenController savedGameScreenController = new SavedGameScreenController();
        savedGameScreenController.start(SavedGameScreenController.getStage());

    }

    public void exit() {
        MainPage.getStage().close();
        System.out.println("logeed out");
    }
}
