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
package game;

import game.dimensions.Coordinates;
import game.dimensions.Level;
import game.dimensions.Symset;
import game.entities.organisms.Spider;
import game.entities.structures.Structure;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author xylix
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File level1 = new File("xylixlike/Resources/Levels/level1.json");
        File symFile = new File("xylixlike/Resources/Tilesets/default.json");
        Symset symset = new Symset(symFile);
        Level level = new Level(level1);

        //Spider spider = new Spider(new Coordinates(2, 2));
        //level.spawnOrganism(spider);
        //Structure room1 = new Structure(new Coordinates (0,0), symset, 10, 8);
        //level.spawnStructure(room1);
        //Structure corridor = new Structure(new Coordinates(10, 1), new Coordinates(20, 1), symset);
        //level.spawnStructure(corridor);
        System.out.println(level.render());
    }
}
