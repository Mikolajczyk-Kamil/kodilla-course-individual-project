package com.kodilla.pacman;

import java.awt.*;

public class GhostMoveResult {
    private Point ghostCurrentLocation;
    private int ghostCurrentDirection;

    public void setGhostCurrentLocation(Point ghostCurrentLocation) {
        this.ghostCurrentLocation = ghostCurrentLocation;
    }

    public void setGhostCurrentDirection(int ghostCurrentDirection) {
        this.ghostCurrentDirection = ghostCurrentDirection;
    }

    public Point getGhostCurrentLocation() {
        return ghostCurrentLocation;
    }

    public int getGhostCurrentDirection() {
        return ghostCurrentDirection;
    }
}
