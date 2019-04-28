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
package xylixlike;

import javafx.animation.AnimationTimer;
import xylixlike.dimensions.Coordinates;
import xylixlike.dimensions.Direction;
import xylixlike.dimensions.Level;
import xylixlike.dimensions.Tile;
import xylixlike.entities.Organism;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author xylix
 */
public class Game extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(Game.class);
    }

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();
        pane.setPrefSize(1280, 640);
        pane.setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));

        Organism player = new Organism(new Coordinates(16, 16), new Tile('@', "player"));
        Scene scene = new Scene(pane);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT)
                player.move(Direction.LEFT);
            else if (event.getCode() == KeyCode.RIGHT)
                player.move(Direction.RIGHT);
            else if (event.getCode() == KeyCode.UP)
                player.move(Direction.UP);
            else if (event.getCode() == KeyCode.DOWN)
                player.move(Direction.DOWN);
        });

        /*new AnimationTimer() {
            @Override
            public void handle(long current) {
                if(player.collide())
            }
        }
        .start();
         */

        Level level = new Level("level0");

        pane.getChildren().addAll(level.getStructures());
        pane.getChildren().addAll(level.getOrganisms());
        pane.getChildren().add(player);

        stage.setScene(scene);
        stage.show();

    }
}
