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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import game.mobs.Spider;

/**
 *
 * @author xylix
 */
public class Game {
    public Game() {

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("xylixlike/Levels/Level1Map.txt");
        System.out.println(System.getProperty("user.dir"));

        Scanner fileReader = new Scanner(file);
        StringBuilder levelString = new StringBuilder(); 
        while(fileReader.hasNextLine()) {
            levelString.append(fileReader.nextLine()).append("\n");
        }
        Level level = new Level(levelString.toString());
        //Level level = new Level(40, 40);
        Spider spider = new Spider(new Coordinates(2, 2));
        level.spawnEntity(spider);
        System.out.println(level.render());
        System.out.println(spider.coords());
        System.out.println(level.moveEntity(Direction.DOWN, spider));
        System.out.println(spider.coords());
        System.out.println(level.render());
        System.out.println(level.moveEntity(Direction.RIGHT, spider));
        System.out.println(level.moveEntity(Direction.RIGHT, spider));
        System.out.println(level.render());
    }
}
