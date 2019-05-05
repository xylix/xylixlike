package xylixlike;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static xylixlike.Game.loadLevel;

class GameIntegrationTest extends ApplicationTest {
    @Override public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(720, 480);
        stage.setScene(loadLevel(pane, "testLevel0"));
        stage.show();
    }
    @Test
    void testMovementProcessing() {
        assertTimeout(ofSeconds(5), () -> {
            for (int i = 0; i < 5; i++){
                push(KeyCode.UP);
                push(KeyCode.LEFT);
                push(KeyCode.DOWN);
                push(KeyCode.RIGHT);
                sleep(250);
            }
        }, "When this fails, all hell has broken loose or something is hanging");
    }

    @Test
    void testCollisionToStructure() {
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        push(KeyCode.RIGHT);
        push(KeyCode.RIGHT);
        push(KeyCode.RIGHT);
        assertEquals(Event.Type.INTERACTION, EventLog.getLastEvent().type);
    }

    @Test
    void testCollisionToOrganism() {
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        assertEquals(Event.Type.INTERACTION, EventLog.getLastEvent().type);
    }
}
