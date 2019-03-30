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
package xylixlike.game;

import java.util.ArrayList;

/**
 *
 * @author xylix
 */
public class Level {
    GameFloor gamefloor;
    private final ArrayList<Entity> entities;
    
    Level(int h, int w) {
        this.gamefloor = new GameFloor(h, w);
        entities = new ArrayList<>();
    }
    
    Level(String s) {
        this.gamefloor = new GameFloor(s);
        entities = new ArrayList<>();
    }
    
    String currentState() {
        return gamefloor.toString();
    }
    
    public void spawnEntity(Entity e) {
        entities.add(e);
    }
    
    public boolean moveEntity(Direction direction, Entity entity) {
        //returns false if entity can't move
        return gamefloor.move(direction, entity);
    }
    
    public String render() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gamefloor.height; i++) {
            sb.append(gamefloor.row(i));
            sb.append("\n");
            for (Entity e: entities) {
                if (e.yCoord() == i) {
                    sb.replace(i, i+1, Character.toString(e.symbol()));
                }
            }
        }
        return sb.toString();
    }
}
