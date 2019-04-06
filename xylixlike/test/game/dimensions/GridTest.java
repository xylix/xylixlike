package game.dimensions;

import game.entities.organisms.Organism;
import game.entities.organisms.Spider;
import game.entities.structures.Structure;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GridTest {

    @Test
    void gridConstructorTest() {

        Organism testSpider = new Spider(new Coordinates(0, 0));
        HashSet<Organism> testOrganismSet = new HashSet<>();
        HashSet<Structure> testStructureSet = new HashSet<>();
        testOrganismSet.add(testSpider);
        Grid testGrid = new Grid(new LevelData(20, 20, ' ', testOrganismSet, testStructureSet));
        assertEquals(testGrid.get(0, 0), testSpider.getSymbol());
    }

    @Test
    void placeStructureTest() {
    }
}
