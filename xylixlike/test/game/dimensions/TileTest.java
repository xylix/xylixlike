package game.dimensions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TileTest {

    @Test
    public void tileSymbolTest() {
        Tile testTile = new Tile('-', "vwall");
        assertEquals('-', testTile.getSymbol());
    }

    @Test
    public void tileIdTest() {
        Tile testTile = new Tile('-', "vwall");
        assertEquals("vwall", testTile.getKind());
    }
}
