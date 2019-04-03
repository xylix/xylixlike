package game.entities.structures;

import game.dimensions.Coordinates;

import game.dimensions.Tileset;

public class Room extends Structure {

    public Room(Coordinates coordinates, Tileset tileset, int width, int height) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (y == 0 || y == height - 1)
                    tiles.put(tileset.getSymbol("vwall"), new Coordinates(x, y));
                else if (x == 0 || x == width - 1 ) {
                    tiles.put(tileset.getSymbol("vwall"), new Coordinates(x, y));
                } else {
                    tiles.put(tileset.getSymbol("filler"), new Coordinates(x, y));
                }

            }
        }

    }
}
