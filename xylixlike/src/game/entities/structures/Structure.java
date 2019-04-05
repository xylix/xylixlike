package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Symset;

import java.util.HashMap;

public class Structure {
    HashMap<Coordinates, Character> tiles;
    Symset symset;

    Structure(Symset symset) {
        this.tiles = new HashMap<>();
        this.symset = symset;
    }

    public Structure(Coordinates coordinates, Symset symset, int width, int height) {
        this.symset = symset;
        this.tiles = buildRoom(coordinates, width, height);
    }

    public Structure(Coordinates startCoordinates, Coordinates endCoordinates, Symset symset) {
        this.symset = symset;
        this.tiles = buildCorridor(startCoordinates, endCoordinates);
    }


    public HashMap<Coordinates, Character> tiles() {
        return tiles;
    }

    void placeTile(HashMap<Coordinates, Character> tiles, String kind, Coordinates coordinates) {
        tiles.put(coordinates, symset.getSymbol(kind));
    }

    public HashMap<Coordinates, Character> buildRoom(Coordinates startCoordinates, int width, int height) {
        HashMap<Coordinates, Character> roomTiles = new HashMap<>();
        int xCoordinate = startCoordinates.x;
        int yCoordinate = startCoordinates.y;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Coordinates coordinates = new Coordinates(x + xCoordinate, y + yCoordinate);
                if (y == 0 || y == height - 1) {
                    placeTile(roomTiles, "vwall", coordinates);
                } else if (x == 0 || x == width - 1) {
                    placeTile(roomTiles, "hwall", coordinates);
                } else {
                    placeTile(roomTiles, "air", coordinates);
                }
            }
        }
        return roomTiles;
    }

    public HashMap<Coordinates, Character> buildCorridor(Coordinates startCoordinates, Coordinates endCoordinates) {
        HashMap<Coordinates, Character> corridorTiles = new HashMap<>();
        if (startCoordinates.x == endCoordinates.x) {
            int length = endCoordinates.y - startCoordinates.y;
            for (int i = 0; i < length; i++) {
                placeTile(corridorTiles, "air",
                        new Coordinates(startCoordinates.x, startCoordinates.y + i));
            }
        } else if (startCoordinates.y == endCoordinates.y) {
            int length = endCoordinates.x - startCoordinates.x;
            for (int i = 0; i < length; i++) {
                placeTile(corridorTiles, "air",
                        new Coordinates(startCoordinates.x + i, startCoordinates.y));
            }
        }
        return corridorTiles;
    }
}
