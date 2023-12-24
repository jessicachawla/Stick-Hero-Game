package application.stickhero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
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


public class PauseScreenController {
    @FXML
    private ImageView reviveButton;
    @FXML
    private ImageView restartButton;
    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView saveButton;

    @FXML
    Label highscorelabel;




    @FXML
    Label sc;
    private static Stage stage1;
    public static Stage getStage() {
        return stage1;
    }


    // setter
    public void setScore(String s) {
        this.sc.setText(s);
    }
        public void setHighscore(int highscore) {
        highscorelabel.setText("Highscore: " + highscore);
    }
//    public void reviveGame() throws Exception {
//        ImageView player = GamePage.getGpc().getPlayer();
//        Rectangle stick = GamePage.getGpc().getStick();
//        GamePage.getStickHero().reviveBack(player);
//        stick.setX(player.getLayoutX()+5);
//        stick.setHeight(1);
//        stick.getTransforms().clear();
//
//
//        ExitScreen.getStage1().close();
//
//    }
    public void restartGame() throws IOException {
        GamePage.getStage().close();
        PauseScreen.getStage1().close();
        GamePage gp = new GamePage();
        gp.start(new Stage());

    }
    public void backToGame() {
        PauseScreen.getStage1().close();
    }

    private static File getSerializedDirectory()
    {
        File serializedDir = new File("savedGames");
        if (!serializedDir.exists()) {
            serializedDir.mkdir();
        }
        return serializedDir;
    }
    public void saveGame() {
        GamePage gp = MainPageController.getGp();
        SavedGame sg = new SavedGame(gp.getScore(), gp.getCherries(),
                new Position(gp.getPlayer().getX(),gp.getPlayer().getY()),
                new Position(GamePageController.getP1().getX(), GamePageController.getP1().getY()),
                new Position(GamePageController.getP2().getX(), GamePageController.getP2().getY()),
                GamePageController.getP1().platform.getWidth(),GamePageController.getP2().platform.getWidth());

        Main.getSavedGamesList().add(sg);
        File saveGamedir = getSerializedDirectory();
        File[] files = saveGamedir.listFiles(File::isFile);

        int id=1;
        if (files.length > 0) {
            Arrays.sort(files);
            id = Integer.parseInt(""+files[files.length - 1].getName().charAt(0))+1;
        }


        String filename = getSerializedDirectory()+"/"+id+".save";
        System.out.println(filename);
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(sg);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        }
        id+=1;
        PauseScreen.getStage1().close();

    }
    public void goHome() {
        //saveGame();
        GamePage.getStage().close();
        PauseScreen.getStage1().close();
        MainPage main = MainPage.getInstance();
        try {
            main.start(MainPage.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
