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

/**
 *
 * @author xylix
 */
public class Entity {
    private Coordinates c;
    private final String name;
    public Entity (String name, Coordinates coords) {
        this.c = coords;
        this.name = name;
    }
    
    public Coordinates coords() {
        return c;
    }

    public int xCoord() {
        return c.x;
    }
    public int yCoord () {
        return c.y;
    }
    
    public void setXCoord(int x) {
        this.c.x = x;
    }
    
    public void setYCoord(int y) {
        this.c.y = y;
    }
    
    public void setCoords(int x, int y) {
        this.c = new Coordinates(x, y);
    }
    
    public String getName() {
        return name;
    }
    
    public char symbol() {
        return Constants.getSymbol(name);
    }
}
