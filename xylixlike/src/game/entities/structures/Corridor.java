package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Direction;
import game.dimensions.Tileset;

public class Corridor extends Structure {
    public Corridor(Coordinates coordinates, Tileset tileset, int length, Direction direction) {
        int x = direction.toVector().x;
        int y = direction.toVector().y;
        for (int i = x; i < length; i++) {
            for (int j = y; j < length; j++) {
                tiles.put(tileset.getSymbol("wall"), new Coordinates(x, y));
            }
        }
    }
}

