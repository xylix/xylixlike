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
import javafx.scene.paint.Color;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author xylix
 */
public class Level {
    private final LevelData data;

    public Level(String fileName) {
        File levelFile = new File("src/main/resources/levels/" + fileName + ".json");
        this.data = parseJson(loadLevel(levelFile));
        for (Prototype prototype : data.getPrototypes()) {
            Logger.info(prototype);
            spawnEntity(new Organism(prototype));
        }

        for (Blueprint blueprint : data.getBlueprints()) {
            Logger.info(blueprint);
            Structure structure = new Structure(blueprint);
            structure.setFill(Color.WHITE);
            spawnEntity(structure);
        }

    }

    public Collection<Entity> getEntities() {
        return data.getEntities();
    }

    @SuppressWarnings("WeakerAccess")
    public void spawnEntity(Entity e) {
        data.addEntity(e);
    }

    static private JsonObject loadLevel(File file) {
        try {
            FileReader fr = new FileReader(file);
            JsonParser parser = new JsonParser();
            return parser.parse(fr).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonObject();
        }
    }

    static private LevelData parseJson(JsonObject levelJson) {
        Gson gson = new Gson();
        Type prototypeCollection = new TypeToken<HashSet<Prototype>>() {}.getType();
        Type blueprintCollection = new TypeToken<HashSet<Blueprint>>() {}.getType();

        return new LevelData(
                gson.fromJson(levelJson.get("prototypes"), prototypeCollection),
                gson.fromJson(levelJson.get("blueprints"), blueprintCollection)
        );
    }
}
