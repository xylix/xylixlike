package game.dimensions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.bidimap.TreeBidiMap;


public class Tileset {
    private TreeBidiMap<String, Character> tileset;

    public Tileset (Set<Tile> s) {
        for (Tile t: s) {
            tileset.put(t.getKind(), t.getSymbol());
        }
    }

    public Tileset (File f) throws IOException {
        this.tileset = new TreeBidiMap<>();
        loadTiles(f);
    }

    public char getSymbol(String kind) {
        return this.tileset.get(kind);
    }

    public String getKind(char symbol) {
        return this.tileset.getKey(symbol);
    }

    public void loadTiles(File file) throws IOException {
        FileReader fr = new FileReader(file);
        HashMap<String,Character> result =
                new ObjectMapper().readValue(fr, HashMap.class);

        result.entrySet().forEach(s ->
                tileset.put(s.getKey(), s.getValue()));
    }

}


