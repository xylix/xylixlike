package game.dimensions;

import game.entities.organisms.Organism;
import game.entities.structures.Blueprint;
import game.entities.structures.Structure;

import java.util.Collection;
import java.util.HashSet;

class LevelData {
    final int width;
    final int height;
    final Collection<Organism> organisms;
    final Collection<Blueprint> blueprints;
    final Collection<Structure> structures;
    final char filler;

    LevelData(int height, int width) {
        this.width = width;
        this.height = height;
        this.organisms = new HashSet<>();
        this.blueprints = new HashSet<>();
        this.structures = new HashSet<>();
        this.filler = '#';
    }

    LevelData(int height, int width, char filler, Collection organisms, Collection blueprints) {
        this.width = width;
        this.height = height;
        this.filler = filler;
        this.organisms = organisms;
        this.blueprints = blueprints;
        this.structures = new HashSet<>();

    }
}
