/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author xylix
 */
public class LevelLayerTest {
    public Level level;
    @Before
    public void setUp() throws Exception {
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

    
}
