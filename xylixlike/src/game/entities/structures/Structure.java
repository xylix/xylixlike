package game.entities.structures;

import game.dimensions.Coordinates;

import java.util.HashMap;

public class Structure {
    HashMap<Character, Coordinates> tiles;
    public HashMap<Character, Coordinates> tiles() {
        return tiles;
    }
}
