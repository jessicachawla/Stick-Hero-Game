package application.stickhero;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.stage.Stage;

import static org.testng.Assert.assertEquals;

public class PauseScreenControllerTest {

    @BeforeEach
    public void setUp() {
        controller = new PauseScreenController();
        // Initialize other mock objects if needed
    }

    private PauseScreenController controller;
    private GamePage mockGamePage;
    private MainPageController mockMainPageController;


    @Test
    public void testSetAndGetScore() {
        String expectedScore = "100";
        controller.setScore(expectedScore);
        String actualScore = controller.sc.getText();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testSetAndGetHighscore() {
        int expectedHighscore = 1000;
        controller.setHighscore(expectedHighscore);
        String expectedHighscoreText = "Highscore: " + expectedHighscore;
        String actualHighscoreText = controller.highscorelabel.getText();
        assertEquals(expectedHighscoreText, actualHighscoreText);
    }



}
