package game.dimensions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TileTest {

    @Test
    void tileSymbolTest() {
        Tile testTile = new Tile('-', "vwall");
        assertEquals('-', testTile.getSymbol());
    }

    @Test
    void tileIdTest() {
        Tile testTile = new Tile('-', "vwall");
        assertEquals("vwall", testTile.getKind());
    }
}
