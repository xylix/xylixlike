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
import game.dimensions.Direction;
import game.dimensions.Level;
import game.entities.organisms.Player;
import game.entities.structures.Structure;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author xylix
 */
public class Game extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //File level1 = new File("xylixlike/Resources/Levels/level1.json");
        //Level level = new Level(level1);

        //Spider spider = new Spider(new Coordinates(2, 2));
        //level.spawnOrganism(spider);
        //Structure room1 = new Structure(new Coordinates (0,0), symset, 10, 8);
        //level.spawnStructure(room1);
        //Structure corridor = new Structure(new Coordinates(10, 1), new Coordinates(20, 1), symset);
        //level.spawnStructure(corridor);
        launch(Game.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Pane pane = new Pane();
        pane.setPrefSize(1280, 640);

        Player player = new Player(new Coordinates(16, 16));
        Scene scene = new Scene(pane);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT)
                    player.transform(Direction.LEFT.toVector());
            else if (event.getCode() == KeyCode.RIGHT)
                    player.transform(Direction.RIGHT.toVector());
            else if (event.getCode() == KeyCode.UP)
                    player.transform(Direction.UP.toVector());
            else if (event.getCode() == KeyCode.DOWN)
                    player.transform(Direction.DOWN.toVector());

        });

        pane.getChildren().add(player);

        Level level = new Level("level0");

        pane.getChildren().addAll(level.getOrganisms());

        stage.setScene(scene);
        stage.show();

    }
}
