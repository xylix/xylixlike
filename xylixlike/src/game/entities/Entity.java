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
package game.entities;

import game.dimensions.Coordinates;
import game.dimensions.Tile;

/**
 *
 * @author xylix
 */
public class Entity implements Comparable<Entity>{
    private String name;
    private Coordinates coordinates;
    private Tile tile;

    public Entity (String name, Coordinates coordinates, Tile tile) {
        this.name = name;
        this.coordinates = coordinates;
        this.tile = tile;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates coordinates() {
        return this.coordinates;
    }

    public int getX() {
        return this.coordinates.x;
    }
    public int getY () {
        return this.coordinates.y;
    }

    public void transform(Coordinates transformVector) {
        this.coordinates.transform(transformVector);
    }

    public char symbol() {
        return this.tile.getSymbol();
    }

    public String getKind() {
        return this.tile.getKind();
    }

    @Override
    public int compareTo(Entity o) {
        int yComparison = this.getY() - o.getY();
        if (yComparison != 0)
            return yComparison;
        else
            return this.getX() - o.getX();
    }
}