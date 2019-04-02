package game.tiles;

import game.dimensions.Coordinates;
import game.entities.Entity;

public class VerticalWall extends Entity {
    public VerticalWall (Coordinates coordinates) {
        super(
                "vwall",
                coordinates,
                '|');
    }
}
