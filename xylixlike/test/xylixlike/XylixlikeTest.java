/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xylixlike;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Before;
import org.junit.Test;
import xylixlike.game.Coordinates;
import xylixlike.game.Direction;
import xylixlike.game.Level;
import xylixlike.game.mobs.Spider;

/**
 *
 * @author xylix
 */
public class XylixlikeTest {
    @Before
    public void setUp() throws Exception {
    }
        
    @Test
    public void Level1FileTest() throws FileNotFoundException {
        File file = new File("Levels/TestLevel1.txt");
        Scanner fileReader = new Scanner(file);
        StringBuilder levelString = new StringBuilder(); 
        while(fileReader.hasNextLine()) {
            levelString.append(fileReader.nextLine()).append("\n");
        }
    }
    
    @Test
    public void NewLevelTest() {
        Level level = new Level(40, 80);
    }
    
    @Test
    public void GameFloorTest() {
    }
    
    @Test
    public void MoveEntityTest() {
        //Add code to move entity and assert that it has moved
        Level level = new Level(40, 80);
        Spider testSpider = new Spider(new Coordinates(1, 1));
        level.spawnEntity(testSpider);
        Coordinates coords = testSpider.coords();
        level.moveEntity(Direction.RIGHT, testSpider);
        assertNotSame(coords, testSpider.coords());      
    }
}
