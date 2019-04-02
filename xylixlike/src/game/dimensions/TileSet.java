package game.dimensions;

import org.apache.commons.collections4.BidiMap;

import java.io.File;
import java.util.Set;

public class TileSet {
    private BidiMap<String, Character> tileSet;
    public TileSet (Set<Tile> s) {
        for (Tile t: s) {
            tileSet.put(t.getKind(), t.getSymbol());
        }
    }

    public TileSet (File f) {
        loadTiles(f);
    }

    public char getSymbol(String kind) {
        return this.tileSet.get(kind);
    }

    public String getKind(char symbol) {
        return this.tileSet.getKey(symbol);
    }

    public boolean loadTiles(File file) {
        return false;
    }

}


