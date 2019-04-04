package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Level;
import game.dimensions.Tileset;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CorridorTest {
    @Test
    public void corridorConstructorTest() throws IOException {
        Coordinates startCoordinates = new Coordinates(1, 1);
        Coordinates endCoordinates = new Coordinates(4, 1);
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        Corridor corridor = new Corridor(startCoordinates, endCoordinates, t);
        assertEquals(corridor.getClass(), Corridor.class);
    }

    @Test
    public void corridorRenderingTest() throws IOException {
        Level level = new Level(40, 80);
        String levelPreStructure = level.render();
        Coordinates startCoordinates = new Coordinates(1, 1);
        Coordinates endCoordinates = new Coordinates(4, 1);
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        Corridor corridor = new Corridor(startCoordinates, endCoordinates, t);
        level.spawnStructure(corridor);
        String levelPostStructure = level.render();
        assertNotEquals(levelPreStructure, levelPostStructure);
    }
}
