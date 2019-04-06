package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Symset;
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
        bp.startCoordinates = new Coordinates(1, 1);
        bp.endCoordinates = new Coordinates(4, 1);
        return bp;
    }

}
