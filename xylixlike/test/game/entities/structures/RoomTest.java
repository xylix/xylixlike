package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Level;
import game.dimensions.Tileset;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RoomTest {
    @Test
    public void roomTest() throws IOException {
        Level level = new Level(40, 80);
        String levelPreStructure = level.render();
        Coordinates c = new Coordinates(1,1);
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        Structure testStructure = new Room(c, t, 4, 4);
        level.spawnStructure(testStructure);
        String levelPostStructure = level.render();
        assertNotEquals(levelPreStructure, levelPostStructure);
    }
}
