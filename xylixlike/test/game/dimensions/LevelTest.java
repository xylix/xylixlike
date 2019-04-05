package game.dimensions;

import game.entities.organisms.Spider;
import org.junit.jupiter.api.Test;

import java.io.File;

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
    @Test
    public void LevelLoadTest() {
        File level1 = new File("xylixlike/Resources/Levels/level1.json");
        File symFile = new File("xylixlike/Resources/Tilesets/default.json");
        Symset symset = new Symset(symFile);
        Level level = new Level(level1);
        System.out.println(level.render());
    }
}
