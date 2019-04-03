package game.entities.structures;

import game.dimensions.Coordinates;

import java.util.HashMap;

public class Structure {
    HashMap<Character, Coordinates> tiles;

    Structure() {
        this.tiles = new HashMap<>();
    }

    public HashMap<Character, Coordinates> tiles() {
        return tiles;
    }
}
