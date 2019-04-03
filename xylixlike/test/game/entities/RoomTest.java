package game.entities;

import game.dimensions.Coordinates;
import game.dimensions.Level;
import game.dimensions.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomTest {
    @Test
    public void RoomTest() {
        Level level = new Level(40, 80);
        Coordinates c = new Coordinates(1,1);
        Tile testTile = new Tile('.', "test");
        Entity testEntity = new Room("test", c);
        level.spawnEntity(testEntity);
        assertTrue(level.containsEntity(testEntity));
        assertEquals(testEntity.coordinates(), c);
    }
}
