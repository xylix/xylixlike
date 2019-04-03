package game.dimensions;

import game.entities.organisms.Organism;
import game.entities.organisms.Spider;
import game.entities.structures.Structure;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GridTest {

    @Test
    public void gridConstructorTest() {

        Organism testSpider = new Spider(new Coordinates(0, 0));
        TreeSet<Organism> testSet = new TreeSet<>();
        TreeSet<Structure> testStructureSet = new TreeSet<>();
        testSet.add(testSpider);
        Grid testGrid = new Grid(20, 20, new Tile(' ', "air"), testStructureSet, testSet);
        assertEquals(testGrid.get(0, 0), testSpider.getSymbol());
    }

    @Test
    public void placeStructureTest() {

    }
}
