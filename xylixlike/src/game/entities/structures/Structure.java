package game.entities.structures;

import javafx.geometry.Point2D;

import java.util.Map;

public class Structure {
    private final Map<Point2D, Character> tiles;

    Structure(Map<Point2D, Character> tiles) {
        this.tiles = tiles;
    }

    public Map<Point2D, Character> tiles() {
        return tiles;
    }


}
