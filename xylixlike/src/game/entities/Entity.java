package game.entities;

import game.dimensions.Coordinates;
import javafx.scene.shape.Rectangle;

public class Entity extends Rectangle {
    Entity(Coordinates coordinates, int width, int height) {
        super(coordinates.getX(), coordinates.getY(), width, height);
    }
}
