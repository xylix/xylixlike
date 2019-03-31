package game;

import game.mobs.Mob;
import org.junit.Assert;
import org.junit.Test;

public class MobTest {
    @Test
    public void isAliveTest() {
        Level level = new Level(40, 80);
        Mob mob = new Mob("Testmob", new Coordinates(0,0), -1, 0);
        Assert.assertFalse(mob.isAlive());
    }
}
