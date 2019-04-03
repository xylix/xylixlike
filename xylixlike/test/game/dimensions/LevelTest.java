package game.dimensions;

import game.entities.organisms.Spider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LevelTest {

    @Test
    public void RenderMoveTest() {
        Level level = new Level(40, 80);
        Spider spider = new Spider(new Coordinates(2, 2));
        level.spawnOrganism(spider);
        String levelBeforeMove = level.render();
        level.moveOrganism(Direction.DOWN, spider);
        String levelAfterMove = level.render();
        assertNotEquals(levelBeforeMove, levelAfterMove);
    }
}
