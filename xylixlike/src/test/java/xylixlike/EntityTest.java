package xylixlike;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testfx.framework.junit5.ApplicationTest;
import xylixlike.dimensions.Coordinates;
import xylixlike.entities.Organism;
import xylixlike.entities.Prototype;

class EntityTest extends ApplicationTest {
    @Test
    void getOrganismLocationTest()  {
        Coordinates location = new Coordinates(0, 0);
        Organism organism = new Organism(new Prototype("spider", "spider", location));
        assertEquals(location, organism.getLocation());
    }
}
