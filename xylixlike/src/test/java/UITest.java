import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import xylixlike.CollisionHandler;
import xylixlike.dimensions.Direction;
import xylixlike.dimensions.Level;
import xylixlike.entities.Organism;

public class UITest extends ApplicationTest {
    @Override public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 100, 100);
        stage.setScene(scene);
        stage.show();
        Level level = new Level("level0");

        pane.getChildren().addAll(level.getStructures());
        pane.getChildren().addAll(level.getOrganisms().values());

        Organism player = level.getPlayer();
        new CollisionHandler(player, level).start();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT)
                player.move(Direction.LEFT);
            else if (event.getCode() == KeyCode.RIGHT)
                player.move(Direction.RIGHT);
            else if (event.getCode() == KeyCode.UP)
                player.move(Direction.UP);
            else if (event.getCode() == KeyCode.DOWN)
                player.move(Direction.DOWN);
        });
    }
    @Test
    void testMovement() {
        press(KeyCode.UP);
        press(KeyCode.DOWN);
    }
}
