package game.entities;

import game.dimensions.Coordinates;
import game.dimensions.Tile;
import javafx.scene.shape.Rectangle;

public class Organism extends Entity implements Comparable<Organism>  {
    public Organism (Coordinates coordinates, Tile tile) {
        super(coordinates, 15, 15);
        this.tile = tile;
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
