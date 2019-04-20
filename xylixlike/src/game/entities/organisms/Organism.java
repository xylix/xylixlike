package game.entities.organisms;

import game.dimensions.Tile;
import javafx.geometry.Point2D;

public class Organism implements Comparable<Organism> {
    private final String name;
    private final Point2D coordinates;
    private final Tile tile;

    public Organism (String name, Point2D coordinates, Tile tile) {
        this.name = name;
        this.coordinates = coordinates;
        this.tile = tile;
    }

    public Point2D getCoordinates() {
        return this.coordinates;
    }

    public int getX() {
        return (int) this.coordinates.getX();
    }
    public int getY () {
        return (int) this.coordinates.getY();
    }

    public void transform(Point2D transformVector) {
        this.coordinates.add(transformVector);
    }

    public char getSymbol() {
        return this.tile.getSymbol();
    }

    public String getKind() {
        return this.tile.getKind();
    }
    @Override
    public int compareTo(Organism o) {
        int yComparison = this.getY() - o.getY();
        if (yComparison != 0)
            return yComparison;
        else
            return this.getX() - o.getX();
    }

}
