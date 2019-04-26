package game.dimensions;

import game.entities.Entity;
import game.entities.Blueprint;

import java.util.Collection;
import java.util.HashSet;

class LevelData {
    private final int width;
    private final int height;
    private final Collection<Blueprint> blueprints;
    private Collection<Entity> entities;
    private final char filler;

    LevelData(int height, int width) {
        this.width = width;
        this.height = height;
        this.blueprints = new HashSet<>();
        this.entities = new HashSet<>();
        this.filler = '#';
    }

    LevelData(int height, int width, char filler, Collection<Entity> entities, Collection<Blueprint> blueprints) {
        this.width = width;
        this.height = height;
        this.filler = filler;
        this.blueprints = blueprints;
        this.entities = new HashSet<>();

    }

    public void addEntity(Entity e) {
        this.entities.add(e);
    }

    public Collection<Entity> getEntities() {
        return this.entities;
    }
}
