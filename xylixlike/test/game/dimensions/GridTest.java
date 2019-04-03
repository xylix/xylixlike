package game.dimensions;

import game.entities.Entity;
import game.entities.Spider;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class GridTest {

    @Test
    public void gridConstructorTest() {

        Entity testSpider = new Spider(new Coordinates(0, 0));
        TreeSet<Entity> testSet = new TreeSet<>();
        testSet.add(testSpider);
        Grid testGrid = new Grid(20, 20, new Tile(' ', "air"), testSet);
        Assert.assertThat(testGrid.get(0, 0), is(equalTo(testSpider.symbol())));
    }
}
