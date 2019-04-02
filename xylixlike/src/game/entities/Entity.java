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

/**
 *
 * @author xylix
 */
public class Entity implements Comparable<Entity>{
    private String kind;
    private String name;
    private Coordinates c;
    private char symbol;
    public Entity (String kind, Coordinates coordinates, char Symbol) {
        this.kind = kind;
        this.c = coordinates;
        this.symbol = symbol();
    }

    public Entity (String name, String kind, Coordinates coordinates) {
        this.name = name;
        this.kind = kind;
        this.c = coordinates;
    }
    public Coordinates coordinates() {
        return c;
    }

    public int x() {
        return c.x;
    }
    public int y () {
        return c.y;
    }

    public void transform(Coordinates transformVector) {
        this.c.transform(transformVector);
    }

    public char symbol() {
        return symbol;
    }

    @Override
    public int compareTo(Entity o) {
        return false;
    }
}
