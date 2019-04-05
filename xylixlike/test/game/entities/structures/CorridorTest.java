package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Symset;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static game.entities.structures.StructureTest.testRenderingStructure;

public class CorridorTest {
    @Test
    public void corridorConstructorTest() throws IOException {
        Coordinates startCoordinates = new Coordinates(1, 1);
        Coordinates endCoordinates = new Coordinates(4, 1);
        Structure corridor = new Structure(startCoordinates, endCoordinates);
    }

    @Test
    public void corridorRenderingTest() throws IOException {
        Coordinates startCoordinates = new Coordinates(1, 1);
        Coordinates endCoordinates = new Coordinates(4, 1);
        Structure corridor = new Structure(startCoordinates, endCoordinates);
        testRenderingStructure(corridor);
    }
}
