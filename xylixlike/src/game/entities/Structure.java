package game.entities;

import game.dimensions.Coordinates;

import java.util.HashMap;

public interface Structure {
    HashMap<Character, Coordinates> tiles();
}
