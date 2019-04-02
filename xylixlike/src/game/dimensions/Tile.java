package game.dimensions;

public class Tile {
    private char symbol;
    private String tileId;
    public Tile (char symbol, String kind) {
        this.symbol = symbol;
        this.tileId = kind;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getKind() {
        return this.tileId;
    }
}
