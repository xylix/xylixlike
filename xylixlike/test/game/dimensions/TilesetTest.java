package game.dimensions;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TilesetTest {
    @Test
    public void testLoadTiles() throws IOException {
        Tileset t = new Tileset(new File("xylixlike/Resources/Tilesets/default.json"));
        assertNotNull(t);
    }
}
