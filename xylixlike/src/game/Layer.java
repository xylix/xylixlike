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

import game.rendering.Renderable;
import org.apache.commons.collections4.map.MultiKeyMap;


/**
 *
 * @author xylix
 */
public class Layer implements Renderable{
    private final MultiKeyMap<Integer, Character> grid;

    public final int height;
    public final int width;
    
    public Layer(int height, int width) {
        grid = new MultiKeyMap<>();
        this.height = height;
        this.width = width;
        
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid.put(x, y, Constants.getSymbol("air"));
            }
        }
    }
    
    public Layer(String floorDesign) {
        grid = new MultiKeyMap<>();
        String[] osat = floorDesign.split("\n");
        this.height = osat.length;
        width = osat[0].length();
        for (int y = 0; y < osat.length; y++) {
            for(int x = 0; x < osat[y].length(); x++) {
                grid.put(x, y, osat[y].charAt(x));
                
            }
        }
    }
    
    @Override
    public String row(int y) {
        StringBuilder row = new StringBuilder();
        for (int x = 0; x < width; x++) {
            row.append(tile(x, y));
        }
        return row.toString();
    }
    
    @Override
    public String column(int x) {
        StringBuilder column = new StringBuilder();
        for (int y = 0; y < height; y++) {
            column.append(tile(x, y));
        }
        return column.toString();
    }
    
    @Override
    public Character tile(int x, int y) {
        return grid.get(x, y);
    }
     
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                sb.append(tile(x, y));
            }
        }
        return sb.toString();
    }
    
    public void draw(Character c, int x, int y) {
        grid.put(x, y, c);
    }
    
    /*public boolean drawHorizontalLine(Coordinates startCoords, int length) {
        for(int i = 0; i < length; i++) {
            //implement functionality
            
        }
    }
    
    public boolean drawVerticalLine(Coordinates startCoords, int length) {
        for(int i = 0; i < length; i++) { 
        
        }
        //implement functionality
    }*/
    
    /*public boolean move(Direction d, Entity e) {
        Coordinates transform = d.toVector();
        int nextX = e.x() + transform.x;
        int nextY = e.y() + transform.y;
        if (Constants.isPassable(Constants.getName(tile(nextX, nextY)))) {
            e.transform(transform);
            return true;
        } else {
            return false;
        }

    }*/

    public boolean move(Direction d, Entity e) {
        //Lacks legality check
        Coordinates transformVector = d.toVector();
        e.transform(transformVector);
        return tru e;

    }
}
