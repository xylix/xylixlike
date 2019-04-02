package game.dimensions;

public class Tile {
    private char symbol;
    private String id;
    public Tile (char symbol, String id) {
        this.symbol = symbol;
        this.id = id;
    }

    public char getSymbol() {
        return this.symbol;
    }


    public String getId() {
        return this.id;
    }
}
