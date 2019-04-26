package game.entities;

import game.dimensions.Coordinates;
import game.dimensions.Tile;
import javafx.scene.shape.Rectangle;

public class Entity extends Rectangle {

    public Entity(Coordinates coordinates, int width, int height) {
        super(coordinates.getX(), coordinates.getY(), width, height);
    }

    public Entity(Coordinates coordinates) {
        super(coordinates.getX(), coordinates.getY(), 15, 15);
    }

    public Coordinates getCoordinates() {
        return new Coordinates((int) (this.getTranslateX() + this.getY()), (int) (this.getTranslateY() + this.getY()));
    }


}
