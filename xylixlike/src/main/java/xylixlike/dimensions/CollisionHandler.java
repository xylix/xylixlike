package xylixlike.dimensions;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import org.tinylog.Logger;
import xylixlike.dimensions.Direction;
import xylixlike.dimensions.Level;
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
                Logger.info("Organism '" + organism.getName() + "' collided with structure");
            }
        }

        for (Organism collided : level.getOrganisms().values()) {
            if (!organism.equals(collided)) {
                if (organism.collide(collided)) {
                    collided.interact(organism);
                    Logger.info("Organism " + organism.getName() + "collided with organism: " + collided);
                }
            }
        }
    }
}
