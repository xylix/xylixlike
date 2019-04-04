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

    public HashMap<Coordinates, Character> tiles() {
        return tiles;
    }

    void placeTile(String kind, Coordinates coordinates) {
        tiles.put(coordinates, tileset.getSymbol(kind));
    }
}
