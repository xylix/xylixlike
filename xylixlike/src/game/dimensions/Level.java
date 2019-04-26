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
package game.dimensions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import game.entities.organisms.Organism;
import game.entities.structures.Blueprint;
import game.entities.structures.Structure;
import game.entities.structures.StructureFactory;

import java.io.File;
import java.io.FileNotFoundException;
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
    private StructureFactory structureFactory;

    public Level(int h, int w) {
        this.data = new LevelData(h, w);
        try { structureFactory = new StructureFactory(Symset.defaultSymset());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Level(String fileName) {
        File levelFile = new File("xylixlike/Resources/Levels/" + fileName + ".json");
        this.data = parseJson(loadLevel(levelFile));
        try { structureFactory = new StructureFactory(Symset.defaultSymset());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    public void spawnOrganism(Organism o) {
        data.organisms.add(o);
    }

    public void spawnStructure(Blueprint s) {
        data.structures.add(structureFactory.buildStructure(s));
    }

    public Collection<Structure> getStructures() {
        return data.structures;
    }

    public Collection<Organism> getOrganisms() {
        return data.organisms;
    }
    
    public void moveOrganism(Direction direction, Organism organism) {
        //Implement check if entity can move
        organism.transform(direction.toVector());
    }

    public boolean containsOrganism(Organism o) {
        return data.organisms.contains(o);
    }

    private JsonObject loadLevel(File file) {
        try {
            FileReader fr = new FileReader(file);
            JsonParser parser = new JsonParser();
            return parser.parse(fr).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonObject();
        }
    }

    private LevelData parseJson(JsonObject levelJson) {
        Gson gson = new Gson();
        Type organismCollection = new TypeToken<HashSet<Organism>>() {}.getType();
        Type blueprintCollection = new TypeToken<HashSet<Blueprint>>() {}.getType();

        return new LevelData(
                gson.fromJson(levelJson.get("height"), Integer.class),
                gson.fromJson(levelJson.get("width"), Integer.class),
                gson.fromJson(levelJson.get("filler"), Character.class),
                gson.fromJson(levelJson.get("organisms"), organismCollection),
                gson.fromJson(levelJson.get("blueprints"), blueprintCollection)
        );
    }
}
