package game.entities.structures;

import game.dimensions.Coordinates;
import game.dimensions.Symset;

import java.util.HashMap;
import java.util.Map;


public class StructureFactory {
    private final Symset symset;

    public StructureFactory(Symset symset) {
        this.symset = symset;
    }

    public Structure buildStructure(Blueprint bp) {
        if (bp.kind.equals("room")) {
            return new Structure(buildRoom(bp));
        } else if (bp.kind.equals("corridor")) {
            return new Structure(buildCorridor(bp));
        } else {
            return null;
        }
    }

    private Map<Coordinates, Character> buildRoom(Blueprint bp) {
        Map<Coordinates, Character> roomTiles = new HashMap<>();
        int xCoordinate = bp.startCoordinates.x;
        int yCoordinate = bp.startCoordinates.y;
        for (int x = 0; x < bp.width; x++) {
            for (int y = 0; y < bp.height; y++) {
                Coordinates coordinates = new Coordinates(x + xCoordinate, y + yCoordinate);
                if (y == 0 || y == bp.height - 1) {
                    placeTile(roomTiles, "vwall", coordinates);
                } else if (x == 0 || x == bp.width - 1) {
                    placeTile(roomTiles, "hwall", coordinates);
                } else {
                    placeTile(roomTiles, "air", coordinates);
                }
            }
        }
        return roomTiles;
    }

    private Map<Coordinates, Character> buildCorridor(Blueprint bp) {
        Map<Coordinates, Character> corridorTiles = new HashMap<>();
        if (bp.startCoordinates.x == bp.endCoordinates.x) {
            int length = bp.endCoordinates.y - bp.startCoordinates.y;
            for (int i = 0; i < length; i++) {
                placeTile(corridorTiles, "air",
                        new Coordinates(bp.startCoordinates.x, bp.startCoordinates.y + i));
            }
        } else if (bp.startCoordinates.y == bp.endCoordinates.y) {
            int length = bp.endCoordinates.x - bp.startCoordinates.x;
            for (int i = 0; i < length; i++) {
                placeTile(corridorTiles, "air",
                        new Coordinates(bp.startCoordinates.x + i, bp.startCoordinates.y));
            }
        }
        return corridorTiles;
    }
    private void placeTile(Map<Coordinates, Character> tiles, String kind, Coordinates coordinates) {
        tiles.put(coordinates, symset.getSymbol(kind));
    }
}
