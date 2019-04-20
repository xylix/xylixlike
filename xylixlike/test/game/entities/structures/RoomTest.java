package game.entities.structures;

import game.dimensions.Symset;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static game.entities.structures.StructureTest.testRenderingStructure;

class RoomTest {

    @Test
    void roomConstructorTest() {
        createRoom();
    }

    @Test
    void roomRenderingTest() throws IOException {
        testRenderingStructure(createRoom());
    }

    Blueprint createRoom() {
        Blueprint bp = new Blueprint();
        bp.kind = "room";
        bp.startCoordinates = new Point2D(1, 1);
        bp.endCoordinates = new Point2D(4, 1);
        return bp;
    }

}
