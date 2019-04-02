package game.tiles;

import game.dimensions.Coordinates;
import game.entities.Entity;

public class HorizontalWall extends Entity {
    public HorizontalWall (Coordinates coordinates) {
        super(
                "hwall",
                coordinates,
                '|');
    }
}
