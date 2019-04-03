package game.entities.structures;

import game.dimensions.Coordinates;

import game.dimensions.Tileset;

public class Room extends Structure {

    public Room(Coordinates coordinates, Tileset tileset, int width, int height) {
        int xCoordinate = coordinates.x;
        int yCooordinate = coordinates.y;
        for (int x = xCoordinate; x < (width + xCoordinate); x++) {
            for (int y = yCooordinate; y < (height + yCooordinate); y++) {
                if (y == 0 + yCooordinate || y == height - 1 + yCooordinate)
                    tiles.put(tileset.getSymbol("vwall"), new Coordinates(x, y));
                else if (x == 0 + xCoordinate || x == width - 1 + xCoordinate ) {
                    tiles.put(tileset.getSymbol("vwall"), new Coordinates(x, y));
                } else {
                    tiles.put(tileset.getSymbol("air"), new Coordinates(x, y));
                }

            }
        }

    }
}
