package game.entities.structures;

import game.dimensions.Symset;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static game.entities.structures.StructureTest.testRenderingStructure;

class CorridorTest {
    @Test
    void corridorConstructorTest()  {
        createCorridor();
    }

    @Test
    void corridorRenderingTest() throws IOException {
        testRenderingStructure(createCorridor());
    }

    static Blueprint createCorridor () {
        Blueprint bp = new Blueprint();
        bp.kind = "corridor";
        bp.startCoordinates = new Point2D(1, 1);
        bp.endCoordinates = new Point2D(4, 1);
        return bp;
    }
}
