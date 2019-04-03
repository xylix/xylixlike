package game.dimensions;

import game.entities.Entity;
import game.entities.Room;
import game.entities.Structure;

import java.util.Map;
import java.util.TreeSet;

public class Grid {
    private final char[][] grid;
    private final String stringRepresentation;

    public Grid(int height, int width, Tile filler, TreeSet<Entity> entities, TreeSet<Structure> structures) {
        this.grid = new char[width][height];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                grid[x][y] = filler.getSymbol();
            }
        }

        for(Structure s: structures) {
            placeStructure(s);
        }

        for (Entity e: entities) {
            place(e);
        }

        this.stringRepresentation = stringify(height, width, grid);
    }

    public char get(int x, int y) {
        return this.grid[x][y];
    }

    public void place(Entity e) {
        this.grid[e.getX()][e.getY()] = e.symbol();
    }

    public void placeStructure(Structure s) {
        for (Map.Entry<Character, Coordinates> e: s.tiles().entrySet()) {
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
