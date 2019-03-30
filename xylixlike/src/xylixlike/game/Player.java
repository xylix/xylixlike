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
public class Player extends Entity {
    public Inventory inventory;
    
    public Player(int x, int y) {
        super(x, y);
        this.inventory = new Inventory();
    }

    
}
