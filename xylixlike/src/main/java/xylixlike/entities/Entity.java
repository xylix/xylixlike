package xylixlike.entities;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import org.tinylog.Logger;
import xylixlike.Event;
import xylixlike.EventLog;
import xylixlike.dimensions.Coordinates;

import java.net.URL;


public class Entity extends Rectangle {
    protected String kind;

    Entity(String kind, Coordinates coordinates, int width, int height) {
        super(coordinates.getX(), coordinates.getY(), width, height);
        this.kind = kind;
    }

    public boolean collide(Entity entity) {
        Shape collisionBox = Shape.intersect(this, entity);
        return collisionBox.getBoundsInLocal().getWidth() != -1;
    }

    public void interact(Organism collider) {
        EventLog.log(Event.Type.INTERACTION, collider.getName() + "collided with " + this.toString());
        collider.undoMove();
    }

    void loadSprite(String filename) {
        URL spriteUrl = ClassLoader.getSystemClassLoader().getResource("sprites/" + filename);
        if (spriteUrl != null) {
            Image sprite = new Image(spriteUrl.toString());
            this.setFill(new ImagePattern(sprite));
        } else {
            Logger.error("No sprite found for: " + filename);
            this.setFill(Color.GREEN);
        }
    }
}
