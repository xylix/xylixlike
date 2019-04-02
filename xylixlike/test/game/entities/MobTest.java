package game.entities;

import game.entities.Mob;
import game.dimensions.Coordinates;
import org.junit.Assert;
import org.junit.Test;

public class MobTest {
    @Test
    public void isNotAliveTest() {
        Mob mob = new Spider(new Coordinates(0, 0));
        Assert.assertFalse(mob.isAlive());
    }
}
