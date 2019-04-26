package game.dimensions;

import game.entities.Entity;
import game.entities.Blueprint;
import game.entities.Prototype;

import java.util.Collection;
import java.util.HashSet;

class LevelData {
    private final Collection<Prototype> prototypes;
    private final Collection<Blueprint> blueprints;
    private Collection<Entity> entities;

    LevelData(int height, int width) {
        this.prototypes = new HashSet<>();
        this.blueprints = new HashSet<>();
        this.entities = new HashSet<>();
    }

    LevelData(Collection<Prototype> prototypes, Collection<Blueprint> blueprints) {
        this.prototypes = prototypes;
        this.blueprints = blueprints;
        this.entities = new HashSet<>();

    }

    void addEntity(Entity e) {
        this.entities.add(e);
    }

    public Collection<Prototype> getPrototypes() {
        return prototypes;
    }
    public Collection<Blueprint> getBlueprints() {
        return blueprints;
    }
    Collection<Entity> getEntities() {
        return this.entities;
    }


}
