package game;

import game.entities.Spider;
import game.dimensions.Coordinates;
import game.dimensions.Direction;
import game.dimensions.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;

public class LevelTest {
    private Level level;
    @Before
    public void SetUp() {
        level = new Level(40, 80);
    }

    @Test
    public void RenderMoveTest() {
        Spider spider = new Spider(new Coordinates(2, 2));
        level.spawnEntity(spider);
        String levelBeforeMove = level.render();
        level.moveEntity(Direction.RIGHT, spider);
        String levelAfterMove = level.render();
        Assert.assertThat(levelBeforeMove, is(not(equalTo(levelAfterMove))));
    }
}
