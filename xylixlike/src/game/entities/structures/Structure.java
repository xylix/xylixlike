package game.entities.structures;

import game.dimensions.Coordinates;

import java.util.HashMap;

public class Structure {
    HashMap<Coordinates, Character> tiles;

    Structure() {
        this.tiles = new HashMap<>();
    }

    public HashMap<Coordinates, Character> tiles() {
        return tiles;
    }
}
