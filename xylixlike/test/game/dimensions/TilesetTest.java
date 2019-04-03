package game.dimensions;


import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TilesetTest {
    @Test
    public void testLoadTiles() {
        Tileset t = new Tileset(new File("testTileset.tiles"));
        assertNotNull(t);
    }
}
