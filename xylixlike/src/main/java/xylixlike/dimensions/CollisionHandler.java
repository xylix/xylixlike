package xylixlike.dimensions;

import javafx.animation.AnimationTimer;
import xylixlike.entities.Organism;
import xylixlike.entities.Structure;

public class CollisionHandler extends AnimationTimer {
    private final Organism organism;
    private final Level level;

    public CollisionHandler(Organism organism, Level level) {
        this.organism = organism;
        this.level = level;
    }

    @Override
    public void handle(long current) {
        for (Structure collided : level.getStructures()) {
            if (organism.collide(collided)) {
                collided.interact(organism);
            }
        }

        for (Organism collided : level.getOrganisms().values()) {
            if (!organism.equals(collided) && organism.collide(collided)) {
                    collided.interact(organism);
            }
        }
    }
}

