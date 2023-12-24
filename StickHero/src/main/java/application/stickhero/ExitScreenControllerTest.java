package application.stickhero;


import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javafx.scene.image.ImageView;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExitScreenControllerTest {

    private ExitScreenController controller;

    @BeforeEach
    public void setUp() {
        controller = new ExitScreenController();
    }



    @Test
    public void testSetHighscorelabel() {
        MainPage mockMainPage = MainPage.getInstance();
        MainPage.setHighscore(15);
        controller.setHighscorelabel();
        assertEquals("Highscore: 15", controller.highscorelabel.getText());
    }
    @Test
    public void testSetScore() {
        Label mockScoreLabel = new Label();
        controller.setScore("100");
        assertEquals("100", mockScoreLabel.getText());
    }



}
