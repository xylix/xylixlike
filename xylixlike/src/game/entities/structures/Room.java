package game.entities.structures;

import game.dimensions.Coordinates;

import game.dimensions.Tileset;

public class Room extends Structure {

    public Room(Coordinates startCoordinates, Tileset tileset, int width, int height) {
        super(tileset);
        int xCoordinate = startCoordinates.x;
        int yCoordinate = startCoordinates.y;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Coordinates coordinates = new Coordinates(x + xCoordinate, y + yCoordinate);
                if (y == 0 || y == height - 1) {
                    placeTile("vwall", coordinates);
                } else if (x == 0 || x == width - 1) {
                    placeTile("hwall", coordinates);
                } else {
                    placeTile("air", coordinates);
                }
            }
        }
    }
}
