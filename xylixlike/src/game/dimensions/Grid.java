package game.dimensions;

import game.entities.organisms.Organism;
import game.entities.structures.Structure;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Grid {
    private final char[][] grid;
    private final String stringRepresentation;

    public Grid(int height, int width, Tile filler, HashSet<Structure> structures, TreeSet<Organism> organisms) {
        this.grid = new char[width][height];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                grid[x][y] = filler.getSymbol();
            }
        }

        for(Structure s: structures) {
            placeStructure(s);
        }

        for (Organism o: organisms) {
            placeOrganism(o);
        }

        this.stringRepresentation = stringify(height, width, grid);
    }

    public char get(int x, int y) {
        return this.grid[x][y];
    }

    public void placeOrganism(Organism o) {
        this.grid[o.getX()][o.getY()] = o.getSymbol();
    }

    public void placeStructure(Structure s) {
        for (Entry<Character, Coordinates> e: s.tiles().entrySet()) {
            this.grid[e.getValue().x][e.getValue().y] = e.getKey();
        }
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    private static String stringify (int h, int w, char[][] g) {
        StringBuilder sb = new StringBuilder();
        for(int y = h - 1; y >= 0; y--) {
            for(int x = 0; x < w; x++) {
                sb.append(g[x][y]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
