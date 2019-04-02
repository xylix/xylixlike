/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.dimensions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import game.entities.Mob;
import game.entities.Spider;
import game.dimensions.Coordinates;
import game.dimensions.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author xylix
 */
public class LevelLayerTest {
    private Level level;
    @Before
    public void setUp() {
        level = new Level(40, 80);
    }
        
    @Test
    public void Level1FileTest() throws FileNotFoundException {
        File file = new File("Levels/TestLevel1.txt");
        Scanner fileReader = new Scanner(file);
        StringBuilder levelString = new StringBuilder(); 
        while(fileReader.hasNextLine()) {
            levelString.append(fileReader.nextLine()).append("\n");
        }
        Assert.assertTrue(levelString.length() > 0);
    }
    
    @Test
    public void NewLevelTest() {
        Assert.assertNotNull(level);
    }
    
    @Test
    public void LayerTest() {
        String row = level.floor.row(2);
        Assert.assertThat(row.length(), is(equalTo(80)));
    }
    @Test
    public void ColumnTest() {
        String column = level.floor.column(2);
        Assert.assertThat(column.length(), is(equalTo(40)));
    }

    @Test
    public void SpawnEntityLocationTest() {
        Mob mob = new Spider(new Coordinates(0,0));

    }
    
}
