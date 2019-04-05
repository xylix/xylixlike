package game.dimensions;

import game.entities.organisms.Organism;
import game.entities.structures.Structure;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Grid {
    private final char[][] grid;
    private final String stringRepresentation;

    public Grid(LevelData data) {
        this.grid = new char[data.width][data.height];

        for(int y = 0; y < data.height; y++) {
            for(int x = 0; x < data.width; x++) {
                grid[x][y] = data.filler;
            }
        }

        data.structures.forEach(this::placeStructure);

        data.organisms.forEach(this::placeOrganism);


        this.stringRepresentation = stringify(data.height, data.width, grid);
    }

    public char get(int x, int y) {
        return this.grid[x][y];
    }

    public void placeOrganism(Organism o) {
        this.grid[o.getX()][o.getY()] = o.getSymbol();
    }

    public void placeStructure(Structure s) {
        for (Entry<Coordinates, Character> e: s.tiles().entrySet()) {
            this.grid[e.getKey().x][e.getKey().y] = e.getValue();
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
