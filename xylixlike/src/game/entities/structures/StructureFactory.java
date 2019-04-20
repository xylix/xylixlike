package game.entities.structures;

import game.dimensions.Symset;
import javafx.geometry.Point2D;

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

    private Map<Point2D, Character> buildRoom(Blueprint bp) {
        Map<Point2D, Character> roomTiles = new HashMap<>();
        int xCoordinate = (int) bp.startCoordinates.getX();
        int yCoordinate = (int) bp.startCoordinates.getY();
        for (int x = 0; x < bp.width; x++) {
            for (int y = 0; y < bp.height; y++) {
                Point2D coordinates = new Point2D(x + xCoordinate, y + yCoordinate);
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

    private Map<Point2D, Character> buildCorridor(Blueprint bp) {
        Map<Point2D, Character> corridorTiles = new HashMap<>();
        if (bp.startCoordinates.getX() == bp.endCoordinates.getX()) {
            int length = (int) (bp.endCoordinates.getY() - bp.startCoordinates.getY());
            for (int i = 0; i < length; i++) {
                placeTile(corridorTiles, "air",
                        new Point2D(bp.startCoordinates.getX(), bp.startCoordinates.getY() + i));
            }
        } else if (bp.startCoordinates.getY() == bp.endCoordinates.getY()) {
            int length = (int) (bp.endCoordinates.getX() - bp.startCoordinates.getX());
            for (int i = 0; i < length; i++) {
                placeTile(corridorTiles, "air",
                        new Point2D(bp.startCoordinates.getX() + i, bp.startCoordinates.getY()));
            }
        }
        return corridorTiles;
    }
    private void placeTile(Map<Point2D, Character> tiles, String kind, Point2D coordinates) {
        tiles.put(coordinates, symset.getSymbol(kind));
    }
}
