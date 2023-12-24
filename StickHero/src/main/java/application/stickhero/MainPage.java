package application.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

//this class is singleton

public class MainPage extends Application {
    private static int cherr;
    private static int highscore;
    private static MainPage mainPage = null;
    public static MainPage getInstance() {
        if (mainPage == null) {
            return new MainPage();
        }
        return mainPage;
    }
    private MainPage() {
        highscore = 0;
        cherr = 0;
    }

    private static Stage stage1;
    public static Stage getStage() {
        return stage1;
    }
    public static void setCherr(int c) {cherr = c;}
    public static int getCherr() {return cherr;}
    public static void setHighscore(int score) {highscore = score;}
    public static int getHighscore() {return highscore;}
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        stage1 = stage;
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage1.setTitle("Hello!");
        stage1.setScene(scene);
        stage1.show();

    }


//    //public static void main(String[] args) {
//        launch(args);
//    }

}