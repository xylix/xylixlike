package game.entities.organisms;

import game.dimensions.Coordinates;
import game.dimensions.Tile;

public class Organism {
    private final String name;
    private final Coordinates coordinates;
    private final Tile tile;

    public Organism (String name, Coordinates coordinates, Tile tile) {
        this.name = name;
        this.coordinates = coordinates;
        this.tile = tile;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public int getX() {
        return this.coordinates.x;
    }
    public int getY () {
        return this.coordinates.y;
    }

    public void transform(Coordinates transformVector) {
        this.coordinates.transform(transformVector);
    }

    public char getSymbol() {
        return this.tile.getSymbol();
    }

    public String getKind() {
        return this.tile.getKind();
    }
}
