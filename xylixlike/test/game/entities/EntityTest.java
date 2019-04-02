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
package game.entities;

import game.dimensions.Tile;
import game.entities.Entity;
import game.entities.Spider;
import game.dimensions.Coordinates;
import game.dimensions.Direction;
import game.dimensions.Level;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author xylix
 */
public class EntityTest {
    @Test
    public void SpawnEntityTest() {
        Tile air = new Tile(' ', "air");
        Level level = new Level(40, 80, new TreeSet<>(), air);
        Coordinates c = new Coordinates(1,1);
        Tile testTile = new Tile('.', "test");
        Entity testEntity = new Entity("test", c, testTile);
        level.spawnEntity(testEntity);
        assertTrue(level.containsEntity(testEntity));
        assertEquals(testEntity.coordinates(), c);
    }
    
    @Test
    public void MoveEntityDownTest() {
        Direction d = Direction.DOWN;
        MoveEntityTest(d);  
    }
    
    @Test
    public void MoveEntityRightTest() {
        Direction d = Direction.RIGHT;
        MoveEntityTest(d);
    }
    
    @Test
    public void MoveEntityUpTest() {
        Direction d = Direction.UP;
        MoveEntityTest(d);
    }
    
    @Test
    public void MoveEntityLEFTTest() {
        Direction d = Direction.LEFT;
        MoveEntityTest(d);
    }
    
    
    private void MoveEntityTest(Direction d) {
        Tile air = new Tile(' ', "air");
        Level level = new Level(40, 80, new TreeSet<>(), air);
        Spider testSpider = new Spider(new Coordinates(1, 1));
        level.spawnEntity(testSpider);
        Coordinates coordinates = testSpider.coordinates();
        level.moveEntity(d, testSpider);
        Coordinates transformVector = d.toVector();
        coordinates.transform(transformVector);
        Assert.assertThat(testSpider.coordinates(), is(equalTo(coordinates)));
    }
}
