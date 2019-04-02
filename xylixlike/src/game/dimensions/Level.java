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

import game.entities.Entity;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author xylix
 */
public class Level {
    private final TreeSet<Entity> entities;
    private final int height;
    private final int width;
    private final Tile filler;

    public Level(int h, int w, TreeSet<Entity> entities, Tile filler) {
        this.height = h;
        this.width = w;
        this.entities = entities;
        this.filler = filler;
    }
    
    public boolean spawnEntity(Entity e) {
        if (entities.contains(e)) {
            return false;
        } else {
            entities.add(e);
            return true;
        }
    }
    
    public TreeSet<Entity> entities() {
        return entities;
    }
    
    public void moveEntity(Direction direction, Entity entity) {
        //Implement check if entity can move
        entity.transform(direction.toVector());
    }

    public boolean containsEntity(Entity e) {
        return entities.contains(e);
    }

    public String render() {
        Grid grid = new Grid(height, width, filler, entities);
        return grid.getStringRepresentation();
    }

}
