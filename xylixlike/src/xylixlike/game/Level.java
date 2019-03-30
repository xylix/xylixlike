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
public class Level {
    GameFloor gamefloor;
    
    Level(int h, int w) {
        this.gamefloor = new GameFloor(h, w);
    }
    
    String currentState() {
        return gamefloor.toString();
    }
    
    boolean moveEntity(Direction direction, Entity entity) {
        //returns false if entity can't move
        return gamefloor.move(direction, entity);
    }
}
