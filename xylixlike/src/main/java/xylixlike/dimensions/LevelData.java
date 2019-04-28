package xylixlike.dimensions;

import xylixlike.entities.*;

import java.util.Collection;
import java.util.HashSet;

class LevelData {
    private final Collection<Prototype> prototypes;
    private final Collection<Blueprint> blueprints;
    private final Collection<Structure> structures;
    private final Collection<Organism> organisms;

    LevelData(Collection<Prototype> prototypes, Collection<Blueprint> blueprints) {
        this.prototypes = prototypes;
        this.blueprints = blueprints;
        this.structures = new HashSet<>();
        this.organisms = new HashSet<>();

    }

    void addStructure(Structure structure) {
        this.structures.add(structure);
    }

    void addOrganism(Organism organism) {
        this.organisms.add(organism);
    }

    Collection<Prototype> getPrototypes() {
        return prototypes;
    }
    Collection<Blueprint> getBlueprints() {
        return blueprints;
    }
    Collection<Structure> getStructures() {
        return this.structures;
    }
    Collection<Organism> getOrganisms() {
        return this.organisms;
    }

}
