package game.entities.organisms;

import game.dimensions.Coordinates;
import game.dimensions.Tile;
import javafx.scene.shape.Rectangle;

public class Organism extends Rectangle implements Comparable<Organism>  {
    private final String name;
    private final Tile tile;

    public Organism (String name, Coordinates coordinates, Tile tile) {
        super(coordinates.getX(), coordinates.getY(), 15, 15);
        this.name = name;
        this.tile = tile;
    }

    public void transform(Coordinates transformVector) {
        this.setTranslateX(this.getTranslateX() + transformVector.getX());
        this.setTranslateY(this.getTranslateY() + transformVector.getY());
    }

    public Coordinates getCoordinates() {
        return new Coordinates((int) this.getTranslateX(), (int) this.getTranslateY());
    }

    public String getKind() {
        return this.tile.getKind();
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
