package game.dimensions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Symset {
    private final TreeBidiMap<String, Character> tileset;

    public Symset(File f) {
        this.tileset = new TreeBidiMap<>();
        loadTiles(f);
    }

    public char getSymbol(String kind) {
        return this.tileset.get(kind);
    }

    public String getKind(char symbol) {
        return this.tileset.getKey(symbol);
    }

    public void loadTiles(File file) {
        try {
            FileReader fr = new FileReader(file);
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject result = parser.parse(fr).getAsJsonObject();

            HashMap<String, String> mappings = gson.fromJson(result, HashMap.class);
            mappings.forEach((key, value) -> tileset.put(key, value.charAt(0)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Symset defaultSymset() {
        try {
            File symsetFile = new File("xylixlike/Resources/Tilesets/default.json");
            return new Symset(symsetFile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


