package application.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainPage extends Application {
    static Stage stage1;

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