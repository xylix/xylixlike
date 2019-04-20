package game.dimensions;


import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SymsetTest {
    @Test
    void testLoadTiles() {
        Symset t = new Symset(new File("xylixlike/Resources/Tilesets/default.json"));
        assertNotNull(t);
    }
}
