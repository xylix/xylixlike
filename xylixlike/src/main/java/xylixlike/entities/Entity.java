package xylixlike.entities;

import javafx.scene.shape.Shape;
import xylixlike.dimensions.Coordinates;
import javafx.scene.shape.Rectangle;

public class Entity extends Rectangle {
    Entity(Coordinates coordinates, int width, int height) {
        super(coordinates.getX(), coordinates.getY(), width, height);
    }

    public boolean collide(Entity entity) {
        Shape collisionBox = Shape.intersect(this, entity);
        return collisionBox.getBoundsInLocal().getWidth() != -1;
    }
}
