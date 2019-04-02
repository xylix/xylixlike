package game.tiles;

import game.Coordinates;
import game.Entity;

public class HorizontalWall extends Entity {
    public HorizontalWall (Coordinates coordinates) {
        super(
                "hwall",
                coordinates,
                '|');
    }
}
