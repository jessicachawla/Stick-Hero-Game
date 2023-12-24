package application.stickhero;

import javafx.application.Application;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends Application {
    private static ArrayList<SavedGame> savedGamesList;
    public static void main(String[] args) {
        savedGamesList = new ArrayList<>();
        launch(args); // Launch the JavaFX application
    }
    public static ArrayList<SavedGame> getSavedGamesList() {
        return savedGamesList;
    }

    @Override
    public void start(Stage primaryStage) {
        // Instantiate and show your main page or initial UI here
        MainPage mainPage = MainPage.getInstance();
        try {
            mainPage.start(primaryStage);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
