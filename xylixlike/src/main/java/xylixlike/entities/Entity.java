package xylixlike.entities;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import xylixlike.Event;
import xylixlike.EventLog;
import xylixlike.dimensions.Coordinates;


public class Entity extends Rectangle {
    Entity(Coordinates coordinates, int width, int height) {
        super(coordinates.getX(), coordinates.getY(), width, height);
    }

    public boolean collide(Entity entity) {
        Shape collisionBox = Shape.intersect(this, entity);
        return collisionBox.getBoundsInLocal().getWidth() != -1;
    }

    public void interact(Organism collider) {
        EventLog.log(Event.Type.INTERACTION, collider.getName() + "collided with " + this.toString());
        collider.undoMove();
    }
}
