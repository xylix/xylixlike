package game.dimensions;

import game.entities.Entity;

import java.util.TreeSet;

public class Grid {
    private final char[][] grid;
    private final String stringRepresentation;

    public Grid(int height, int width, Tile filler, TreeSet<Entity> entities) {
        this.grid = new char[width][height];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                grid[x][y] = filler.getSymbol();
            }
        }

        for (Entity e: entities) {
            set(e);
        }

        this.stringRepresentation = stringify(height, width, grid);
    }

    public char get(int x, int y) {
        return this.grid[x][y];
    }

    public void set(Entity e) {
        this.grid[e.getX()][e.getY()] = e.symbol();
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
        }
        return sb.toString();
    }
}
