package game.dimensions;

import game.entities.Entity;
import game.entities.Spider;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class GridTest {
    @Test
    public void gridSetTest() {
        Grid testGrid = new Grid(20, 20, new Tile(' ', "air"));
        Entity testSpider = new Spider(new Coordinates(0, 0));
        testGrid.set(testSpider);
        Assert.assertThat(testGrid.get(0, 0), is(equalTo(testSpider)));
    }

    public void gridConstructorTest() {

    }


}
