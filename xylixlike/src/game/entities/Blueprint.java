package game.entities;

import game.dimensions.Coordinates;

public class Blueprint {
    String kind;
    Coordinates startCoordinates;
    int width;
    int height;

    public boolean isValid() {
        return false;
    }
}
