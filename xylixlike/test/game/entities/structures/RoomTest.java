package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Tileset;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static game.entities.structures.StructureTest.testRenderingStructure;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    @Test
    public void roomConstructorTest() throws IOException {
        Coordinates c = new Coordinates(1,1);
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        Room room = new Room(c, t, 4, 4);
        assertEquals(room.getClass(), Room.class);
    }

    @Test
    public void roomRenderingTest() throws IOException {
        Coordinates c = new Coordinates(1,1);
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        Room testStructure = new Room(c, t, 4, 4);

        testRenderingStructure(testStructure);

    }
}
