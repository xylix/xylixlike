package game.tiles;

import game.Coordinates;
import game.Entity;

public class VerticalWall extends Entity {
    public VerticalWall (Coordinates coordinates) {
        super(
                "vwall",
                coordinates,
                '|');
    }
}
