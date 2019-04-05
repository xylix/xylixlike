package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Symset;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static game.entities.structures.StructureTest.testRenderingStructure;

public class RoomTest {
    @Test
    public void roomConstructorTest() throws IOException {
        Coordinates c = new Coordinates(1,1);
        Symset t = new Symset(new File("xylixlike/Resources/Tilesets/default.json"));
        Structure testRoom = new Structure(c, t, 4, 4);
    }

    @Test
    public void roomRenderingTest() throws IOException {
        Coordinates c = new Coordinates(1,1);
        Symset t = new Symset(new File("xylixlike/Resources/Tilesets/default.json"));
        Structure testRoom = new Structure(c, t, 4, 4);

        testRenderingStructure(testRoom);

    }
}
