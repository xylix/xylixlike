package game.entities;

import game.dimensions.Coordinates;
import game.dimensions.Tile;
import javafx.scene.shape.Rectangle;

public class Entity extends Rectangle {
    public Tile tile;

    public Entity(Coordinates coordinates, int width, int height) {
        super(coordinates.getX(), coordinates.getY(), width, height);
    }

    public Entity(Coordinates coordinates, Tile t) {
        super(coordinates.getX(), coordinates.getY(), 15, 15);
        this.tile = t;
    }

    public void transform(Coordinates transformVector) {
        this.setTranslateX(this.getTranslateX() + transformVector.getX());
        this.setTranslateY(this.getTranslateY() + transformVector.getY());
    }

    public Coordinates getCoordinates() {
        return new Coordinates((int) (this.getTranslateX() + this.getY()), (int) (this.getTranslateY() + this.getY()));
    }

    public String getKind() {
        return this.tile.getKind();
    }
}
