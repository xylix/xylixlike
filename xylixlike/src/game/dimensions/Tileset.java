package game.dimensions;

import org.apache.commons.collections4.BidiMap;


import java.io.File;
import java.util.Set;

public class Tileset {
    private BidiMap<String, Character> tileset;
    public Tileset (Set<Tile> s) {
        for (Tile t: s) {
            tileset.put(t.getKind(), t.getSymbol());
        }
    }

    public Tileset (File f) {
        loadTiles(f);
    }

    public char getSymbol(String kind) {
        return this.tileset.get(kind);
    }

    public String getKind(char symbol) {
        return this.tileset.getKey(symbol);
    }

    public boolean loadTiles(File file) {
        return false;
    }

}


