package game.dimensions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.collections4.bidimap.TreeBidiMap;


public class Tileset {
    private final TreeBidiMap<String, Character> tileset;

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
        TypeFactory factory = TypeFactory.defaultInstance();
        MapType type = factory.constructMapType(HashMap.class, String.class, Character.class);
        ObjectMapper mapper  = new ObjectMapper();
        HashMap<String, Character>  result  = mapper.readValue(fr, type);

        result.forEach((key, value) -> tileset.put(key, value));
    }

}


