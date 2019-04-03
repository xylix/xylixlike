package game.dimensions;

import game.entities.Entity;
import game.entities.organisms.Spider;
import game.entities.structures.Structure;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GridTest {

    @Test
    public void gridConstructorTest() {

        Entity testSpider = new Spider(new Coordinates(0, 0));
        TreeSet<Entity> testSet = new TreeSet<>();
        TreeSet<Structure> testStructureSet = new TreeSet<>();
        testSet.add(testSpider);
        Grid testGrid = new Grid(20, 20, new Tile(' ', "air"), testSet, testStructureSet);
        assertEquals(testGrid.get(0, 0), testSpider.symbol());
    }

    @Test
    public void placeStructureTest() {

    }
}
