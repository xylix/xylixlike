package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Tileset;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static game.entities.structures.StructureTest.testRenderingStructure;
import static org.junit.jupiter.api.Assertions.*;

public class CorridorTest {
    @Test
    public void corridorConstructorTest() throws IOException {
        Coordinates startCoordinates = new Coordinates(1, 1);
        Coordinates endCoordinates = new Coordinates(4, 1);
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        Structure corridor = new Structure(startCoordinates, endCoordinates, t);
    }

    @Test
    public void corridorRenderingTest() throws IOException {
        Coordinates startCoordinates = new Coordinates(1, 1);
        Coordinates endCoordinates = new Coordinates(4, 1);
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        Structure corridor = new Structure(startCoordinates, endCoordinates, t);
        testRenderingStructure(corridor);
    }
}
