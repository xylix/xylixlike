package game;

import game.dimensions.Tile;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static game.Utilities.loadTiles;

public class UtilitiesTest {
    @Test
    public void loadTilesTest() {
        ArrayList<Tile> tileList = loadTiles(new File("TestTileSet.tiles"));
        for (Tile t: tileList) {
            t.getSymbol();
            t.getId();
        }
    }
}
