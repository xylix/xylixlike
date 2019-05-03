package xylixlike.entities;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.testfx.framework.junit5.ApplicationTest;
import xylixlike.dimensions.Coordinates;

class EntityTest extends ApplicationTest {
    @Test
    void getOrganismLocationTest()  {
        Coordinates location = new Coordinates(0, 0);
        Organism organism = new Organism(new Prototype("spider", "spider", location));
        assertEquals(location, organism.getLocation());
    }
    @Test
    void loadOrganismSpriteTest() {
        Coordinates location = new Coordinates(0, 0);
        Organism organism = new Organism(new Prototype("spider", "spider", location));
        organism.setFill(Color.GREEN);
        assertEquals(organism.getFill(), Color.GREEN);
        organism.loadSprite("player.jpg");
        // Ensure sprite loaded by checking that it isn't fallback color now
        assertNotEquals(organism.getFill(), Color.GREEN);
    }

    @Test
    void loadStructureSpriteTest() {
        Coordinates location = new Coordinates(0, 0);
        Structure structure = new Structure(new Blueprint("room", location, 2, 2));
        structure.setFill(Color.GREEN);
        assertEquals(structure.getFill(), Color.GREEN);
        structure.loadSprite("floor.png");
        // Ensure sprite loaded by checking that it isn't fallback color now
        assertNotEquals(structure.getFill(), Color.GREEN);
    }
}
