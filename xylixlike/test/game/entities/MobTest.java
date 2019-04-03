package game.entities;

import game.dimensions.Tile;
import game.dimensions.Coordinates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MobTest {
    @Test
    public void isNotAliveTest() {
        Mob mob = new Mob(
                "testMob",
                new Coordinates(0, 0),
                -1,
                new Tile(':', "semicolon"));
        assertFalse(mob.isAlive());
    }
}
