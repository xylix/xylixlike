package game.entities;

import org.tinylog.Logger;



public class EntityFactory {

    static public Organism buildOrganism(Prototype prototype) {
        return new Organism(prototype);
    }

    static public Entity buildStructure(Blueprint blueprint) {
        if (blueprint.kind.equals("room")) {
            return buildRoom(blueprint);
        } else if (blueprint.kind.equals("corridor")) {
            if (blueprint.width == 1|| blueprint.height == 1) {
                return buildRoom(blueprint);
            } else {
                Logger.error("Invalid corridor blueprint");
                return null;
            }
        } else {
            Logger.error("Invalid structure blueprint");
            return null;
        }
    }

    static private Entity buildRoom(Blueprint blueprint) {
        return new Entity(blueprint.startCoordinates, blueprint.width, blueprint.height);
    }
}
