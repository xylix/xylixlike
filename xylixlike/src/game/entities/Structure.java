package game.entities;


public class Structure extends Entity {
    public Structure(Blueprint blueprint) {
        super(blueprint.startCoordinates, blueprint.width, blueprint.height);
    }
}
