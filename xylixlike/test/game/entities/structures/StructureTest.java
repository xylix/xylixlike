package game.entities.structures;

import game.dimensions.Level;
import game.dimensions.Symset;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StructureTest {
    @Test
    public static void testRenderingStructure(Blueprint bp) throws FileNotFoundException {
        StructureFactory structureFactory = new StructureFactory(Symset.defaultSymset());
        Level level = new Level(40, 80);
        String levelPreStructure = level.render();
        level.spawnStructure(bp);
        String levelPostStructure = level.render();
        assertNotEquals(levelPreStructure, levelPostStructure);
    }
}
