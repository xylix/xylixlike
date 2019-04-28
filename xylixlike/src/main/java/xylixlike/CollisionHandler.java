package xylixlike;

import javafx.animation.AnimationTimer;
import org.tinylog.Logger;
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
        for (Structure structure : level.getStructures()) {
            if (organism.collide(structure)) {
                organism.undoMove();
            }
        }

        for (Organism o : level.getOrganisms().values()) {
            if (!organism.equals(o)) {
                if (organism.collide(o)) {
                    organism.undoMove();
                    Logger.info("Moving organism interacting with another one");
                }
            }
        }
    }
}
