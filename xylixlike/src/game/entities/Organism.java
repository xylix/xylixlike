package game.entities;

import game.dimensions.Coordinates;
import game.dimensions.Direction;
import game.dimensions.Tile;

public class Organism extends Entity implements Comparable<Organism>  {
    private Tile tile;
    static private int defaultWidth = 15;
    static private int defaultHeight = 15;

    public Organism (Coordinates coordinates, Tile tile) {
        super(coordinates, defaultWidth, defaultWidth);
        this.tile = tile;
    }

    public Organism (Prototype prototype) {
        super(prototype.coordinates, defaultWidth, defaultHeight);
        this.tile = new Tile(prototype.symbol, prototype.kind);
    }

    public void transform(Coordinates transformVector) {
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

    public String getKind() {
        return this.tile.getKind();
    }
}
