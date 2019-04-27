package xylixlike.entities;


public class Structure extends Entity {
    public Structure(Blueprint blueprint) {
        super(blueprint.startCoordinates.toPixels(), blueprint.width * 16, blueprint.height * 16);
    }
}
