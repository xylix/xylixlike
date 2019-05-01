package xylixlike.entities;

import xylixlike.dimensions.Coordinates;

public class Prototype {
    final String name;
    final String kind;
    final Coordinates coordinates;
    public Prototype(String name, String kind, Coordinates coordinates) {
        this.name = name;
        this.kind = kind;
        this.coordinates = coordinates;
    }
}
