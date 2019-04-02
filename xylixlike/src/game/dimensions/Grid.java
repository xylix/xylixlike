package game.dimensions;

import game.entities.Entity;

import java.util.TreeSet;

public class Grid {
    private char[][] grid;
    private final int width;
    private final int height;

    public Grid(int height, int width, Tile filler, TreeSet<Entity> entities) {
        this.grid = new char[height][width];
        this.width = width;
        this.height = height;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                grid[x][y] = filler.getSymbol();
            }
        }

        for (Entity e: entities) {
            set(e);
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                grid[x][y] = filler.getSymbol();
            }
        }
    }

    public Grid (int width, int height, Tile filler) {
        this.grid = new char[height][width];
        this.width = width;
        this.height = height;
    }

    public char get(int x, int y) {
        return this.grid[x][y];
    }

    public boolean set(Entity e) {

        try {
            this.grid[e.getX()][e.getY()] = e.symbol();
            return true;
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(error);
            return false;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
