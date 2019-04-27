package xylixlike.entities;

import xylixlike.dimensions.Coordinates;
import xylixlike.dimensions.Direction;
import xylixlike.dimensions.Tile;

public class Organism extends Entity implements Comparable<Organism>  {
    private final Tile tile;
    static private final int defaultWidth = 15;
    static private final int defaultHeight = 15;

    public Organism (Coordinates coordinates, Tile tile) {
        super(coordinates, defaultWidth, defaultHeight);
        this.tile = tile;
    }

    public Organism (Prototype prototype) {
        super(prototype.coordinates, defaultWidth, defaultHeight);
        this.tile = new Tile(prototype.symbol, prototype.kind);
    }

    private void transform(Coordinates transformVector) {
        this.setTranslateX(this.getTranslateX() + transformVector.getX());
        this.setTranslateY(this.getTranslateY() + transformVector.getY());
    }

    public void move(Direction direction) {
        //Implement check if entity can move
        this.transform(direction.toVector());
    }

    @Override
    public int compareTo(Organism o) {
        double yComparison = this.getY() - o.getY();
        if (yComparison != 0)
            return (int) yComparison;
        else
            return (int) (this.getX() - o.getX());
    }
}
