package application.stickhero;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SavedGameScreenController extends Application implements Initializable{

  @FXML
  private ImageView backButton;

  @FXML
  private ImageView loadButton;

  @FXML
  private ChoiceBox<String> choices;

  private static Stage stage1;

  public static Stage getStage() {
    return stage1;
  }

  private ArrayList<String> getLoadableGamesList() {
    ArrayList<String> loadableGames = new ArrayList<>();
    File [] directory = new File("savedGames").listFiles();

    for(File file : directory) {
      loadableGames.add(file.getName());
    }
    return loadableGames;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    choices.setItems(FXCollections.observableList(getLoadableGamesList()));
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage1 = new Stage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("savedGamesScreen.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, Color.AQUA);
    stage1.setScene(scene);
    stage1.show();
  }

  public void closeWindow(MouseEvent mouseEvent) {
    stage1.close();
  }


  public void loadGame(MouseEvent mouseEvent) throws IOException {

    String selectedGame = choices.getValue();
    if(selectedGame == null) {
      stage1.close();
      return;
    }
    SavedGame sg = SavedGame.loadFromFile("savedGames/" + selectedGame);
    if(sg == null) {
      stage1.close();
      return;
    }
    restartGame(sg);

    stage1.close();
  }

  private void restartGame(SavedGame savedGame) throws IOException {
    if(GamePage.getStage() != null) GamePage.getStage().close();
    if(ExitScreen.getStage() != null) ExitScreen.getStage().close();
    if(MainPage.getStage() != null) MainPage.getStage().close();
    GamePage gp = new GamePage();
    gp.start(new Stage());
    gp.setScore(savedGame.getScore());
    GamePage.getGpc().getPlayer().setX(savedGame.getPlayerPosition().getX());
    GamePage.getGpc().getPlayer().setY(savedGame.getPlayerPosition().getY());
    GamePageController.getP1().setY(savedGame.getCurrentPlatformPosition().getY());
    GamePageController.getP2().setY(savedGame.getNextPlatformPosition().getY());
    GamePageController.getP1().setX(savedGame.getCurrentPlatformPosition().getX());
    GamePageController.getP2().setX(savedGame.getNextPlatformPosition().getX());
    GamePageController.getP1().platform.setY(savedGame.getCurrentPlatformPosition().getY());
    GamePageController.getP2().platform.setY(savedGame.getNextPlatformPosition().getY());
    GamePageController.getP1().platform.setX(savedGame.getCurrentPlatformPosition().getX());
    GamePageController.getP2().platform.setX(savedGame.getNextPlatformPosition().getX());
    GamePageController.getP1().platform.setWidth(savedGame.getCurrentPlatformWidth());
    GamePageController.getP2().platform.setWidth(savedGame.getNextPlatformWidth());
    gp.setCherries(savedGame.getCherries());
    MainPageController.setGp(gp);
    GamePage.getGpc().getStick().setX(GamePage.getGpc().getPlayer().getX());
    GamePage.getGpc().getStick().setHeight(1);
    GamePage.getGpc().getStick().getTransforms().clear();







  }
}
