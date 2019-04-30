package xylixlike.entities;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import xylixlike.dimensions.Coordinates;
import xylixlike.dimensions.Direction;
import xylixlike.dimensions.Tile;

public class Organism extends Entity implements Comparable<Organism>  {
    private final Tile tile;
    static private final int defaultWidth = 16;
    static private final int defaultHeight = 16;
    private Direction previousMove;

    public Organism (Prototype prototype) {
        super(prototype.coordinates, defaultWidth, defaultHeight);
        this.tile = new Tile(prototype.symbol, prototype.kind);
    }

    public String getKind() {
        return this.tile.getKind();
    }

    private void transform(Coordinates transformVector) {
        this.setTranslateX(this.getTranslateX() + transformVector.getX());
        this.setTranslateY(this.getTranslateY() + transformVector.getY());
    }

    public void move(Direction direction) {
        this.previousMove = direction;
        this.transform(direction.toVector());
    }

    public void undoMove() {
        this.transform(previousMove.getReverse().toVector());
    }

    public Coordinates getLocation() {
        return new Coordinates((int) (this.getTranslateX() + this.getX()), (int)(this.getTranslateY() + this.getY()));
    }
    @Override
    public int compareTo(Organism o) {
        double yComparison = this.getY() - o.getY();
        if (yComparison != 0)
            return (int) yComparison;
        else
            return (int) (this.getX() - o.getX());
    }

    public void bindMovement (Scene scene) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT)
                this.move(Direction.LEFT);
            else if (event.getCode() == KeyCode.RIGHT)
                this.move(Direction.RIGHT);
            else if (event.getCode() == KeyCode.UP)
                this.move(Direction.UP);
            else if (event.getCode() == KeyCode.DOWN)
                this.move(Direction.DOWN);
        });
    }
}
