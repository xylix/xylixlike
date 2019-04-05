package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Symset;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static game.entities.structures.StructureTest.testRenderingStructure;

public class RoomTest {
    @Test
    public void roomConstructorTest() {
        Coordinates c = new Coordinates(1,1);
        Structure testRoom = new Structure(c, 4, 4);
    }

    @Test
    public void roomRenderingTest() throws IOException {
        Coordinates c = new Coordinates(1,1);
        Structure testRoom = new Structure(c, 4, 4);

        testRenderingStructure(testRoom);

    }
}
