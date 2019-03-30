/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xylixlike.game;

/**
 *
 * @author xylix
 */
public class Entity {
    private int x, y;
    public Entity (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int yCoord () {
        return y;
    }
    public int xCoord() {
        return x;
    }
    
    public void setYCoord(int y) {
        this.y = y;
    }
    
    public void setXCoord(int x) {
        this.x = x;
    }
    
    public void setCoords(int x, int y) {
        setXCoord(x);
        setYCoord(y);
    }
}
