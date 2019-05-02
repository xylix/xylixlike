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

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import xylixlike.dimensions.CollisionHandler;
import xylixlike.dimensions.Level;
import xylixlike.entities.Organism;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
        stage.setScene(loadLevel("level1"));
        stage.show();
    }

    public static Scene loadLevel(String levelName) {
        Pane pane = new Pane();
        pane.setPrefSize(720, 480);
        pane.setBackground(new Background(new BackgroundImage(new Image("sprites/background.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        Level level = new Level(levelName);

        pane.getChildren().addAll(level.getStructures());
        pane.getChildren().addAll(level.getOrganisms().values());

        Organism player = level.getPlayer();
        new CollisionHandler(player, level).start();

        Scene loadedLevel = new Scene(pane);
        player.bindMovement(loadedLevel);

        return loadedLevel;
    }
}
