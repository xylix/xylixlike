/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xylixlike.game;

import java.util.HashMap;

/**
 *
 * @author xylix
 */
public class Inventory {
    private final HashMap<Item, Integer> inventory;
    public Inventory () {
        this.inventory = new HashMap<>();
    }
    public void clearInventory() {
        inventory.clear();
    }
    
    public boolean containsItem(Item item) {
        return inventory.containsKey(item);
    }
    
    public boolean adjustItem(Item item, int amount) {
        if(containsItem(item)){
            inventory.put(item, inventory.get(item) + amount);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean reduceItem(Item item) {
        return adjustItem(item, -1);
    }
    
    public void addItem(Item item) {
        adjustItem(item, +1);
    }
}
