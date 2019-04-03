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

import game.dimensions.Coordinates;
import game.dimensions.Direction;
import game.dimensions.Level;
import game.dimensions.Tile;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author xylix
 */
public class OrganismTest {
    @Test
    public void SpawnOrganismTest() {
        Level level = new Level(40, 80);
        Coordinates c = new Coordinates(1,1);
        Tile testTile = new Tile('.', "test");
        Organism testOrganism = new Organism("test", c, testTile);
        level.spawnOrganism(testOrganism);
        assertTrue(level.containsOrganism(testOrganism));
        assertEquals(testOrganism.getCoordinates(), c);
    }
    
    @Test
    public void MoveOrganismDownTest() {
        Direction d = Direction.DOWN;
        MoveEntityTest(d);  
    }
    
    @Test
    public void MoveOrganismRightTest() {
        Direction d = Direction.RIGHT;
        MoveEntityTest(d);
    }
    
    @Test
    public void MoveOrganismUpTest() {
        Direction d = Direction.UP;
        MoveEntityTest(d);
    }
    
    @Test
    public void MoveOrganismLEFTTest() {
        Direction d = Direction.LEFT;
        MoveEntityTest(d);
    }
    
    
    private void MoveEntityTest(Direction d) {
        Level level = new Level(40, 80);
        Spider testSpider = new Spider(new Coordinates(1, 1));
        level.spawnOrganism(testSpider);
        Coordinates coordinates = testSpider.getCoordinates();
        level.moveOrganism(d, testSpider);
        Coordinates transformVector = d.toVector();
        coordinates.transform(transformVector);
        assertEquals(testSpider.getCoordinates(), coordinates);
    }
}
