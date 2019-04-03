package game.entities;

import game.dimensions.Tile;
import game.entities.Mob;
import game.dimensions.Coordinates;
import org.junit.Assert;
import org.junit.Test;

public class MobTest {
    @Test
    public void isNotAliveTest() {
        Mob mob = new Mob(
                "testMob",
                new Coordinates(0, 0),
                -1,
                new Tile(':', "semicolon"));
        Assert.assertFalse(mob.isAlive());
    }
}
