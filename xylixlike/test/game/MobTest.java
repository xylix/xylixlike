package game;

import game.entities.Mob;
import game.dimensions.Coordinates;
import org.junit.Assert;
import org.junit.Test;

public class MobTest {
    @Test
    public void isNotAliveTest() {
        Mob mob = new Mob(
                "Testmob",
                new Coordinates(0, 0),
                -1,
                0,
                't');
        Assert.assertFalse(mob.isAlive());
    }
}
