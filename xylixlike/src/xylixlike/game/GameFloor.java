/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
                sb.append(" ");
            yAxis.put(i, (sb));
        }
    }
    
    @Override
    public String row(int i) {
        return yAxis.get(i).toString();
    }
    
    @Override
    public String column(int i) {
        StringBuilder column = new StringBuilder();
        yAxis.forEach((k, v) -> column.append(v.charAt(i)));
        return column.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        yAxis.forEach((k, v) -> toString.append(v).append("\n"));
        return toString.toString();
    }
    
    public void place(Character c, int xCoord, int yCoord) {
        yAxis.get(xCoord).replace(xCoord, xCoord +1, c.toString());
    }
}
