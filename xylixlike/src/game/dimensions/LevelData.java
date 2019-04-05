package game.dimensions;

import game.entities.organisms.Organism;
import game.entities.structures.Structure;

import java.util.HashSet;
import java.util.TreeSet;

public class LevelData {
    final int width;
    final int height;
    final TreeSet<Organism> organisms;
    final HashSet<Structure> structures;
    final char filler;

    public LevelData(int height, int width) {
        this.width = width;
        this.height = height;
        this.organisms = new TreeSet<>();
        this.structures = new HashSet<>();
        this.filler = '#';
    }

    public LevelData(int height, int width, char filler, TreeSet organisms, HashSet structures) {
        this.width = width;
        this.height = height;
        this.filler = filler;
        this.organisms = organisms;
        this.structures = structures;

    }
}
