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
public class Constants {
    static final HashMap<String, Character> SYMSET = new HashMap<>();
    static {
        SYMSET.put("air", " ".charAt(0));
        SYMSET.put("vwall", "|".charAt(0));
        SYMSET.put("hwall", "-".charAt(0));
    }
    
    static final HashMap<String, Boolean> PASSABILITY = new HashMap<>();
    static {
        PASSABILITY.put("air", Boolean.TRUE);
        PASSABILITY.put("vwall", Boolean.FALSE);
        PASSABILITY.put("hwall", Boolean.FALSE);
    }
    
    static char getSymbol(String name) {
        return SYMSET.get(name);
    }
    
    static boolean isPassable(String name) {
        return PASSABILITY.get(name);
    }
            
}
