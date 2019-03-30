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

import xylixlike.rendering.Renderable;
import java.util.HashMap;


/**
 *
 * @author xylix
 */
public class GameFloor implements Renderable{
    private final HashMap<Integer, StringBuilder> yAxis;
    
    public GameFloor(int height, int width) {
        yAxis = new HashMap<>();
        for(int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++)  
                sb.append(Constants.getSymbol("vwall"));
            yAxis.put(i, (sb));
        }
    }
    
    public GameFloor(String map) {
        yAxis = new HashMap<>();
        String[] osat = map.split("\n");
        for (int i = 0; i < osat.length; i++) {
            yAxis.put(i, new StringBuilder(osat[i]));
        }
    }
    
    @Override
    public String row(int y) {
        return yAxis.get(y).toString();
    }
    
    @Override
    public String column(int x) {
        StringBuilder column = new StringBuilder();
        yAxis.forEach((k, v) -> column.append(v.charAt(x)));
        return column.toString();
    }
    
    @Override
    public Character tile(int x, int y) {
        return yAxis.get(x).charAt(y);
    }
     
    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        yAxis.forEach((k, v) -> toString.append(v.toString()).append("\n"));
        yAxis.forEach((k, v) -> System.out.println(v.toString()));
        return toString.toString();
    }
    
    public void place(Character c, int xCoord, int yCoord) {
        yAxis.get(xCoord).replace(xCoord, xCoord +1, c.toString());
    }
    
    public boolean move(Direction d, Entity e) {
        int x = e.xCoord();
        int y = e.yCoord();
        int xDirection = 0; 
        int yDirection = 0;
        switch (d) {
            case UP:
                xDirection = 0;
                yDirection = 1;
                break;
            case RIGHT:
                xDirection = 1;
                yDirection = 0;
                break;
            case DOWN:
                xDirection = 0;
                yDirection = -1;
                break; 
            case LEFT:
                xDirection = -1;
                yDirection = 0;
                break;
            default:
                break;
        }
        int nextX = x + xDirection;
        int nextY = y + yDirection;
        if (Constants.isPassable(Constants.getName(tile(nextX, nextY)))) {
            e.setCoords(nextX, nextY);
            return true;
        } else {
            return false;
        }
    }
}
