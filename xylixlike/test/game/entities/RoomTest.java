package game.entities;

import game.dimensions.Coordinates;
import game.dimensions.Level;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RoomTest {
    @Test
    public void RoomTest() {
        Level level = new Level(40, 80);
        String levelPreStructure = level.render();
        Coordinates c = new Coordinates(1,1);
        Structure testStructure = new Room(c);
        level.spawnStructure(testStructure);
        String levelPostStructure = level.render();
        assertNotEquals(levelPreStructure, levelPostStructure);
    }
}
