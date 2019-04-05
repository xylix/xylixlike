package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Tileset;

import java.util.HashMap;

public class Structure {
    HashMap<Coordinates, Character> tiles;
    Tileset tileset;

    Structure(Tileset tileset) {
        this.tiles = new HashMap<>();
        this.tileset = tileset;
    }

    public Structure(Coordinates coordinates, Tileset tileset, int width, int height) {
        this.tileset = tileset;
        this.tiles = buildRoom(coordinates, width, height);
    }

    public Structure(Coordinates startCoordinates, Coordinates endCoordinates, Tileset tileset) {
        this.tileset = tileset;
        this.tiles = buildCorridor(startCoordinates, endCoordinates);
    }


    public HashMap<Coordinates, Character> tiles() {
        return tiles;
    }

    void placeTile(HashMap<Coordinates, Character> tiles, String kind, Coordinates coordinates) {
        tiles.put(coordinates, tileset.getSymbol(kind));
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
