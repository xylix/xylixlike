package game.dimensions;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SymsetTest {
    @Test
    public void testLoadTiles() throws IOException {
        Symset t = new Symset(new File("xylixlike/Resources/Tilesets/default.json"));
        assertNotNull(t);
    }
}
