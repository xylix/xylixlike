package game.entities;

import game.dimensions.Symset;
import game.dimensions.Coordinates;
import org.tinylog.Logger;

import java.util.HashMap;
import java.util.Map;


public class StructureFactory {
    private final Symset symset;

    public StructureFactory(Symset symset) {
        this.symset = symset;
    }

    public Entity buildStructure(Blueprint bp) {
        if (bp.kind.equals("room")) {
            return buildRoom(bp);
        } else if (bp.kind.equals("corridor")) {
            return buildCorridor(bp);
        } else {
            Logger.error("Invalid structure blueprint");
            return null;
        }
    }

    static private Entity buildRoom(Blueprint bp) {
        return new Entity(bp.startCoordinates, bp.width, bp.height);
    }

    // Corridor is just a special case of room. Always drawn up->down or left->right
    static private Entity buildCorridor(Blueprint bp) {
        if (bp.width == 1)
            return new Entity(bp.startCoordinates, 1, bp.height);
        else if (bp.height == 1) {
            return new Entity(bp.startCoordinates, bp.width, 1);
        } else {
            Logger.error("Invalid corridor blueprint");
            return null;
        }
    }
    private void placeTile(Map<Coordinates, Character> tiles, String kind, Coordinates coordinates) {
        tiles.put(coordinates, symset.getSymbol(kind));
    }
}
