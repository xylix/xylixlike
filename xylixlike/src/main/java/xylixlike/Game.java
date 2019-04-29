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

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import xylixlike.dimensions.Direction;
import xylixlike.dimensions.Level;
import xylixlike.entities.Organism;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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
        pane.setPrefSize(720, 480);
        pane.setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));

        Level level = new Level("level0");

        pane.getChildren().addAll(level.getStructures());

        level.getOrganisms().values().forEach(organism -> {
            StackPane imageContainer = new StackPane();
            imageContainer.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
            imageContainer.getChildren().add(organism);
            ImageView sprite = new ImageView("https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
            sprite.setFitHeight(16);
            sprite.setFitWidth(16);
            imageContainer.getChildren().add(sprite);
            pane.getChildren().add(imageContainer);
        });

        Organism player = level.getPlayer();
        new CollisionHandler(player, level).start();

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

        stage.setScene(scene);
        stage.show();

    }
}
