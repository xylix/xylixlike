package game.dimensions;

import game.dimensions.Tile;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class TileTest {

    @Test
    public void tileSymbolTest() {
        Tile testTile = new Tile('-', "vwall");
        Assert.assertThat('-', is(equalTo(testTile.getSymbol())));
    }

    @Test
    public void tileIdTest() {
        Tile testTile = new Tile('-', "vwall");
        Assert.assertThat("vwall", is(equalTo(testTile.getKind())));
    }
}
