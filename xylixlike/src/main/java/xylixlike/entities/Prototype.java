package xylixlike.entities;

import xylixlike.dimensions.Coordinates;

public class Prototype {
    String name;
    String kind;
    Coordinates coordinates;
    public Prototype(String name, String kind, Coordinates coordinates) {
        this.name = name;
        this.kind = kind;
        this.coordinates = coordinates;
    }
}
