package xylixlike;

import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import org.tinylog.Logger;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static xylixlike.Game.loadLevel;

public class UITest extends ApplicationTest {
    @Override public void start(Stage stage) {
        stage.setScene(loadLevel("testLevel0"));
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
    void testCollision() {
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);
        push(KeyCode.DOWN);

        fail();
    }
}
