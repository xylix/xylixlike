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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import game.entities.organisms.Organism;
import game.entities.structures.Structure;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author xylix
 */
public class Level {
    private final TreeSet<Organism> organisms;
    private final HashSet<Structure> structures;
    private final int height;
    private final int width;
    private final Tile filler;

    public Level(int h, int w) {
        this.height = h;
        this.width = w;
        this.organisms = new TreeSet<>();
        this.structures = new HashSet<>();
        this.filler = new Tile('#', "wall");
    }
    
    public void spawnOrganism(Organism o) {
        organisms.add(o);
    }

    public void spawnStructure(Structure s) {
        structures.add(s);
    }
    
    public TreeSet<Organism> organisms() {
        return organisms;
    }
    
    public void moveOrganism(Direction direction, Organism organism) {
        //Implement check if entity can move
        organism.transform(direction.toVector());
    }

    public boolean containsOrganism(Organism o) {
        return organisms.contains(o);
    }

    public String render() {
        Grid grid = new Grid(height, width, filler, structures, organisms);
        return grid.getStringRepresentation();
    }

    public void loadLevel(File file) {
        try {
            FileReader fr = new FileReader(file);
            TypeFactory factory = TypeFactory.defaultInstance();
            CollectionType type = factory.constructCollectionType(ArrayList.class, Entity.class);
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Entity> result = mapper.readValue(fr, type);

            for (Entity entry : result) {
                if (entry.getKind() == )
            }
            result.forEach((key, value) -> key.equals()
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
