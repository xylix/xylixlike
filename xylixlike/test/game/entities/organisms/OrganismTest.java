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
package game.entities.organisms;

import game.dimensions.Direction;
import game.dimensions.Level;
import game.dimensions.Tile;
import game.dimensions.Coordinates;
import game.entities.Organism;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author xylix
 */
class OrganismTest {
    @Test
    void SpawnOrganismTest() {
        Level level = new Level(40, 80);
        Coordinates c = new Coordinates(1,1);
        Tile testTile = new Tile('.', "test");
        Organism testOrganism = new Organism(c, testTile);
        level.spawnEntity(testOrganism);
        assertTrue(level.containsEntity(testOrganism));
        assertEquals(c, testOrganism.getCoordinates());
    }

    @Test
    void MoveOrganismRightTest() {
        Direction d = Direction.RIGHT;
        MoveEntityTest(d);
    }

    @Test
    void MoveOrganismDownTest() {
        Direction d = Direction.DOWN;
        MoveEntityTest(d);  
    }

    @Test
    void MoveOrganismLEFTTest() {
        Direction d = Direction.LEFT;
        MoveEntityTest(d);
    }
    
    @Test
    void MoveOrganismUpTest() {
        Direction d = Direction.UP;
        MoveEntityTest(d);
    }
    
    private void MoveEntityTest(Direction d) {
        Level level = new Level(40, 80);
        Organism testSpider = new Organism(new Coordinates(1, 1), new Tile(':', "spider"));
        level.spawnEntity(testSpider);
        Coordinates coordinates = testSpider.getCoordinates();
        testSpider.move(d);
        coordinates.transform(d.toVector());
        assertEquals(testSpider.getCoordinates(), coordinates);
    }
}
