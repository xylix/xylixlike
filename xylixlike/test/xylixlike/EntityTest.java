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
package xylixlike;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import xylixlike.game.Coordinates;
import xylixlike.game.Direction;
import xylixlike.game.Entity;
import xylixlike.game.Level;
import xylixlike.game.mobs.Spider;

/**
 *
 * @author xylix
 */
public class EntityTest {
    
        
    @Test
    public void SpawnEntityTest() {
        Level level = new Level(40, 80);
        Coordinates c = new Coordinates(1,1);
        Entity testEntity = new Entity("test", c);
        level.spawnEntity(testEntity);
        assertTrue(level.entities().values().contains(testEntity));
        assertTrue(testEntity.coords().equals(c));
    }
    
    @Test
    public void MoveEntityDownTest() {
        //Add code to move entity and assert that it has moved
        MoveEntityTest(Direction.DOWN);  
    }
    
    @Test
    public void MoveEntityRightTest() {
        MoveEntityTest(Direction.RIGHT);
    }
    
    @Test
    public void MoveEntityUpTest() {
        MoveEntityTest(Direction.UP);
    }
    
    @Test
    public void MoveEntityLEFTTest() {
        MoveEntityTest(Direction.LEFT);
    }
    
    
    public void MoveEntityTest(Direction d) {
        Level level = new Level(40, 80);
        Spider testSpider = new Spider(new Coordinates(1, 1));
        level.spawnEntity(testSpider);
        Coordinates coords = testSpider.coords();
        level.moveEntity(d, testSpider);
        Assert.assertFalse((coords.x == testSpider.coords().x)); 
    }
}
