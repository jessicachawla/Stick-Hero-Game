package application.stickhero;

import javafx.scene.transform.Rotate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavedGameScreenControllerTest {

    private GamePageController controller;

    @BeforeEach
    public void setUp() {
        controller = new GamePageController();
    }

    @Test
    public void testSetP1() {
        controller.setP1();
        assertNotNull(controller.getP1());
        assertEquals(controller.getP1().platform.getWidth(), controller.plat.getWidth());
        assertEquals(controller.getP1().platform.getX(), controller.plat.getX());
        assertEquals(controller.getP1().platform.getY(), controller.plat.getY());
    }

    @Test
    public void testRotateBack() {
        controller.stick.getTransforms().add(new Rotate(90));
        controller.rotateBack();
        assertTrue(controller.stick.getTransforms().isEmpty());
    }

    @Test
    public void testDisplayPlatform() {
        controller.displayPlatform();
        assertNotNull(controller.getP2());
        assertTrue(controller.anchorPane.getChildren().contains(controller.getP2().platform));
    }

    @Test
    public void testDownHero() {
        controller.downHero();
        assertEquals(-1, controller.getPlayer().getScaleY());
        assertEquals(controller.getPlayer().getFitHeight() - 20, controller.getPlayer().getY());
    }
}
