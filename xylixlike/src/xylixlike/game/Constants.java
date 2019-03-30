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

import java.util.HashMap;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

/**
 *
 * @author xylix
 */
public class Constants {
    static final BidiMap<String, Character> SYMSET = new TreeBidiMap();
    static {
        SYMSET.put("air", " ".charAt(0));
        SYMSET.put("vwall", "|".charAt(0));
        SYMSET.put("hwall", "-".charAt(0));
    }
    
        
    static char getSymbol(String name) {
        return SYMSET.get(name);
    }
    
    static String getName(Character symbol) {
        return SYMSET.getKey(symbol);
    }
    
    static final HashMap<String, Boolean> PASSABILITY = new HashMap<>();
    static {
        PASSABILITY.put("air", Boolean.TRUE);
        PASSABILITY.put("vwall", Boolean.FALSE);
        PASSABILITY.put("hwall", Boolean.FALSE);
    }

    
    static boolean isPassable(String name) {
        return PASSABILITY.get(name);
    }
    
            
}
