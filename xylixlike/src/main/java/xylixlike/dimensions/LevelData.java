package xylixlike.dimensions;

import xylixlike.entities.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class LevelData {
    private final Collection<Prototype> prototypes;
    private final Collection<Blueprint> blueprints;
    private final Collection<Structure> structures;
    private final Map<String, Organism> organisms;

    LevelData(Collection<Prototype> prototypes, Collection<Blueprint> blueprints) {
        this.prototypes = prototypes;
        this.blueprints = blueprints;
        this.structures = new HashSet<>();
        this.organisms = new HashMap<String, Organism>();

    }

    void addStructure(Structure structure) {
        this.structures.add(structure);
    }

    void addOrganism(Organism organism) {
        this.organisms.put(organism.getKind(), organism);
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
    Map<String, Organism> getOrganisms() {
        return this.organisms;
    }

}
