package game.dimensions;

import game.entities.organisms.Organism;
import game.entities.structures.Structure;

import java.util.Collection;
import java.util.HashSet;

public class LevelData {
    final int width;
    final int height;
    final Collection<Organism> organisms;
    final Collection<Structure> structures;
    final char filler;

    public LevelData(int height, int width) {
        this.width = width;
        this.height = height;
        this.organisms = new HashSet<>();
        this.structures = new HashSet<>();
        this.filler = '#';
    }

    public LevelData(int height, int width, char filler, Collection organisms, Collection structures) {
        this.width = width;
        this.height = height;
        this.filler = filler;
        this.organisms = organisms;
        this.structures = structures;

    }
}
