package game.entities.structures;

import game.dimensions.Level;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StructureTest {

    public static void testRenderingStructure(Structure s) throws IOException {
        Level level = new Level(40, 80);
        String levelPreStructure = level.render();
        level.spawnStructure(s);
        String levelPostStructure = level.render();
        assertNotEquals(levelPreStructure, levelPostStructure);
    }
}
