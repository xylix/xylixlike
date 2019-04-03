package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Direction;
import game.dimensions.Tileset;

public class Corridor extends Structure {
    public Corridor(Coordinates coordinates, Tileset tileset, int length, Direction direction) {
        int x = direction.toVector().x;
        int y = direction.toVector().y;
        int xCoordinate = coordinates.x;
        int yCoordinate = coordinates.y;
        for (int i = xCoordinate; i < length + xCoordinate && i > 0; i += x) {
            for (int j = yCoordinate; j < length + yCoordinate && j > 0; j += y) {
                tiles.put(tileset.getSymbol("wall"), new Coordinates(i, j));
            }
            break;
        }
    }
}

