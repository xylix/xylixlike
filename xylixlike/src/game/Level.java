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
package game;

import java.util.ArrayList;
import org.apache.commons.collections4.map.MultiKeyMap;

/**
 *
 * @author xylix
 */
public class Level {
    public final Layer floor;
    //private final ArrayList<Entity> entities;
    private final MultiKeyMap<Integer, Entity> entities;
    
    public Level(int h, int w) {
        this.floor = new Layer(h, w);
        entities = new MultiKeyMap<>();
    }
    
    //Create levels floor from a level file converted to a string. 
    //Generate an empty entitylist
    public Level(String s) {
        this.floor = new Layer(s);
        entities = new MultiKeyMap<>();
    }
    
    public Level(String s, ArrayList<Entity> e) {
        this.floor = new Layer(s);
        entities = new MultiKeyMap<>();
        e.forEach(l ->entities.put(l.x(), l.y(), l));
        
    }
    
    public char floorTile(Coordinates c) {
        return floor.tile(c.x, c.y);
    }
    
    public void spawnEntity(Entity e) {
        entities.put(e.x(), e.y(), e);
    }
    
    public MultiKeyMap<Integer, Entity> entities() {
        return entities;
    }
    
    public boolean moveEntity(Direction direction, Entity entity) {
        //returns false if entity can't move
        return floor.move(direction, entity);
    }
    
    //Starts drawing a room from specified top left corner
    /*public boolean generateRoom(int w, int h, Coordinates c) {
        //implement functionality using draw line functions in Layer
    }*/
    
    //Returns stringified version of the floor + entities
    public String render() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < floor.height; y++) {
            for (int x = 0; x < floor.width; x++) {
                if(entities.containsKey(x, y)) {
                    sb.append(entities.get(x, y).symbol());
                } else {
                    sb.append(floor.tile(x, y));
                }             
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
