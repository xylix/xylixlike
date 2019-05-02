package xylixlike.entities;

public class Structure extends Entity {
    public Structure(Blueprint blueprint) {
        super(blueprint.kind, blueprint.startCoordinates.toPixels(),
                blueprint.width * 16, blueprint.height * 16);
        loadSprite("floor.png");
    }
}
