package game.dimensions;

import game.entities.Spider;
import game.dimensions.Coordinates;
import game.dimensions.Direction;
import game.dimensions.Level;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;

public class LevelTest {

    @Test
    public void RenderMoveTest() {
        Tile air = new Tile(' ', "air");
        Level level = new Level(40, 80, new TreeSet<>(), air);
        Spider spider = new Spider(new Coordinates(2, 2));
        level.spawnEntity(spider);
        String levelBeforeMove = level.render();
        level.moveEntity(Direction.DOWN, spider);
        String levelAfterMove = level.render();
        Assert.assertThat(levelBeforeMove, is(not(equalTo(levelAfterMove))));
    }
}
