package game.entities.structures;

import game.dimensions.Coordinates;

import game.dimensions.Tileset;

public class Room extends Structure {

    public Room(Coordinates coordinates, Tileset tileset, int width, int height) {
        int xCoordinate = coordinates.x;
        int yCoordinate = coordinates.y;
        for (int x = xCoordinate; x < (width + xCoordinate); x++) {
            for (int y = yCoordinate; y < (height + yCoordinate); y++) {
                if (y == yCoordinate || y == height - 1 + yCoordinate) {
                    tiles.put(tileset.getSymbol("vwall"), new Coordinates(x, y));
                } else if (x == xCoordinate || x == width - 1 + xCoordinate ) {
                    tiles.put(tileset.getSymbol("hwall"), new Coordinates(x, y));
                } else {
                    tiles.put(tileset.getSymbol("air"), new Coordinates(x, y));
                }

            }
        }

    }
}
