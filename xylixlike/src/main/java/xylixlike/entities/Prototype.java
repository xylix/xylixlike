package xylixlike.entities;

import xylixlike.dimensions.Coordinates;

public class Prototype {
    String kind;
    Character symbol;
    Coordinates coordinates;
    public Prototype(String kind, Character symbol, Coordinates coordinates) {
        this.kind = kind;
        this.symbol = symbol;
        this.coordinates = coordinates;
    }
}
