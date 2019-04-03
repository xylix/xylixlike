package game.dimensions;

import org.junit.Test;

import java.io.File;

public class TileSetTest {
    @Test
    public void testLoadTiles() {
        TileSet t = new TileSet(new File("testTileSet.tiles"));
    }
}
