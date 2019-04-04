package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Tileset;

public class Corridor extends Structure {
    public Corridor(Coordinates startCoordinates, Coordinates endCoordinates, Tileset tileset) {
        super(tileset);
        if (startCoordinates.x == endCoordinates.x) {
            int length = startCoordinates.y - endCoordinates.y;
            for (int i = 0; i < length; i++) {
                placeTile("air", new Coordinates(startCoordinates.x, startCoordinates.y + i));
            }
        } else if (startCoordinates.y == endCoordinates.y) {
            int length = startCoordinates.x - endCoordinates.x;
            for (int i = 0; i < length; i++) {
                placeTile("air", new Coordinates(startCoordinates.x + i, startCoordinates.y));
            }
        }

    }
}

