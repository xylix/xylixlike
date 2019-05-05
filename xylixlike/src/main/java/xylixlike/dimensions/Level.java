/*
 * The MIT License
 *
 * Copyright 2019 xylix.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package xylixlike.dimensions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import xylixlike.entities.*;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author xylix
 */
public class Level {
    private final LevelData data;

    public Level(String fileName) {
        File levelFile = new File(ClassLoader.getSystemClassLoader()
                .getResource("levels/" + fileName + ".json").getPath());
        this.data = parseLevelJson(loadJsonFile(levelFile));

        for (Blueprint blueprint : data.getBlueprints()) {
            spawnStructure(new Structure(blueprint));
        }

        for (Prototype prototype : data.getPrototypes()) {
            spawnOrganism(new Organism(prototype));
        }

    }

    public Collection<Structure> getStructures() {
        return data.getStructures();
    }

    public Map<String, Organism> getOrganisms() {
        return data.getOrganisms();
    }

    @SuppressWarnings("WeakerAccess")
    public void spawnStructure(Structure structure) {
        structure.setViewOrder(1.0);
        data.addStructure(structure);
    }
    @SuppressWarnings("WeakerAccess")
    public void spawnOrganism(Organism organism) {
        data.addOrganism(organism);
    }

    public Organism getPlayer() {
        if (getOrganisms().containsKey("player")) {
            return getOrganisms().get("player");
        } else {
            Logger.error("Level lacks player");
            return null;
        }
    }

    private static JsonObject loadJsonFile(File file) {
        try (FileReader fr = new FileReader(file)) {
            JsonParser parser = new JsonParser();
            return parser.parse(fr).getAsJsonObject();
        } catch (IOException e) {
            Logger.error(e);
            return new JsonObject();
        }
    }

    private static LevelData parseLevelJson(JsonObject levelJson) {
        Gson gson = new Gson();
        Type prototypeCollection = new TypeToken<HashSet<Prototype>>() {}.getType();
        Type blueprintCollection = new TypeToken<HashSet<Blueprint>>() {}.getType();

        return new LevelData(
                gson.fromJson(levelJson.get("prototypes"), prototypeCollection),
                gson.fromJson(levelJson.get("blueprints"), blueprintCollection)
        );
    }
}
