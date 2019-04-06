package game.dimensions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Symset {
    private final TreeBidiMap<String, Character> symset;

    public Symset(File f) {
        this.symset = new TreeBidiMap<>();
        loadTiles(f);
    }

    public char getSymbol(String kind) {
        return this.symset.get(kind);
    }

    public String getKind(char symbol) {
        return this.symset.getKey(symbol);
    }

    private void loadTiles(File file) {
        try {
            FileReader fr = new FileReader(file);
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject result = parser.parse(fr).getAsJsonObject();

            Map<String, String> mappings = gson.fromJson(result, HashMap.class);
            mappings.forEach((key, value) -> symset.put(key, value.charAt(0)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Symset defaultSymset() throws FileNotFoundException {
        File symsetFile = new File("xylixlike/Resources/Tilesets/default.json");
        if (symsetFile.exists())
            return new Symset(symsetFile);
        else
            throw new FileNotFoundException("Symset default file not found");
    }
}


