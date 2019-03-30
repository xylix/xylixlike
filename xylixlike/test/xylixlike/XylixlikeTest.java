/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xylixlike;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import xylixlike.game.Level;

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
    
    public void NewLevelTest() {
        Level level = new Level(40, 80);
        
    }
    @Test
    public void GameFloorTest() {
        
    }
}
