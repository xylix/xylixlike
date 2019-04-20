package game.entities.structures;

import game.dimensions.Coordinates;

import java.util.Map;

public class Structure {
    private final Map<Coordinates, Character> tiles;

    Structure(Map<Coordinates, Character> tiles) {
        this.tiles = tiles;
    }

    public Map<Coordinates, Character> tiles() {
        return tiles;
    }


}
