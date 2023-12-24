package application.stickhero;



import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javafx.scene.image.ImageView;

import java.io.File;

import static org.testng.Assert.*;


public class GameScreenControllerTest {

    private GamePageController controller;
    @BeforeEach
    public void setUp() {
        controller = new GamePageController();
    }
    @Test
    public void testSetP1() {
        GamePageController controller = new GamePageController();
        controller.setP1();
        assertNotNull(controller.getP1());
        assertEquals(controller.getP1().platform.getWidth(), controller.plat.getWidth());
        assertEquals(controller.getP1().platform.getX(), controller.plat.getX());
        assertEquals(controller.getP1().platform.getY(), controller.plat.getY());
    }

    @Test
    public void testRotateBack() {
        GamePageController controller = new GamePageController();
        controller.stick.getTransforms().add(new Rotate(90));
        controller.rotateBack();
        assertTrue(controller.stick.getTransforms().isEmpty());
    }

    @Test
    public void testDisplayPlatform() {
        GamePageController controller = new GamePageController();
        controller.displayPlatform();
        assertNotNull(controller.getP2());
        assertTrue(controller.anchorPane.getChildren().contains(controller.getP2().platform));

    }

    @Test
    public void testDownHero() {
        GamePageController controller = new GamePageController();
        controller.downHero();
        assertEquals(controller.getPlayer().getScaleY(), -1);
        assertEquals(controller.getPlayer().getY(), controller.getPlayer().getFitHeight() - 20);
    }



}
