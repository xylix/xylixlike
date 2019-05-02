package xylixlike.entities;

import xylixlike.dimensions.Coordinates;

public class Blueprint {
    final String kind;
    final Coordinates startCoordinates;
    final int width;
    final int height;
    public Blueprint(String kind, Coordinates startCoordinates, int width, int height) {
        this.kind = kind;
        this.startCoordinates = startCoordinates;
        this.width = width;
        this.height = height;
    }
}
