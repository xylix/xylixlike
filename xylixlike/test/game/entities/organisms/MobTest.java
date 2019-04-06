package game.entities.organisms;

import game.dimensions.Coordinates;
import game.dimensions.Tile;
import game.entities.organisms.Mob;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class MobTest {
    @Test
    void isNotAliveTest() {
        Mob mob = new Mob(
                "testMob",
                new Coordinates(0, 0),
                -1,
                new Tile(':', "semicolon"));
        assertFalse(mob.isAlive());
    }
}
