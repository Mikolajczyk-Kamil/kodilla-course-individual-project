package com.kodilla.pacman;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;

public class PacmanData {
    private Point pacmanStartLocationLevelFirst = new Point(393, 93);
    private Point pacmanStartLocationLevelSecond = new Point(393, 133);
    private Point pacmanCurrentLocation;

    private ArrayList<Point> availableSteps;
    private Map<Point, Boolean> pointsToEat;

    private int pacmanLife = 3;
    private int pacmanSpeed = 1;
    private int pacmanCurrentDirection = KeyEvent.VK_RIGHT;
    private int pacmanNextDirection = KeyEvent.VK_RIGHT;

    public void pacmanMove() {
        findNextTurn();

        if (pacmanCurrentDirection == KeyEvent.VK_UP) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x, pacmanCurrentLocation.y - pacmanSpeed)))
                pacmanCurrentLocation.y -= pacmanSpeed;
        } else if (pacmanCurrentDirection == KeyEvent.VK_DOWN) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x, pacmanCurrentLocation.y + pacmanSpeed)))
                pacmanCurrentLocation.y += pacmanSpeed;
        } else if (pacmanCurrentDirection == KeyEvent.VK_RIGHT) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x + pacmanSpeed, pacmanCurrentLocation.y)))
                pacmanCurrentLocation.x += pacmanSpeed;
        } else if (pacmanCurrentDirection == KeyEvent.VK_LEFT) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x - pacmanSpeed, pacmanCurrentLocation.y)))
                pacmanCurrentLocation.x -= pacmanSpeed;
        }
    }

    public void findNextTurn() {
        if (pacmanCurrentDirection == KeyEvent.VK_RIGHT && pacmanNextDirection == KeyEvent.VK_DOWN) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x, pacmanCurrentLocation.y + 1)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_RIGHT && pacmanNextDirection == KeyEvent.VK_UP) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x, pacmanCurrentLocation.y - 1)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_LEFT && pacmanNextDirection == KeyEvent.VK_DOWN) {

            if (availableSteps.contains(new Point(pacmanCurrentLocation.x, pacmanCurrentLocation.y + 1)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_LEFT && pacmanNextDirection == KeyEvent.VK_UP) {

            if (availableSteps.contains(new Point(pacmanCurrentLocation.x, pacmanCurrentLocation.y - 1)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_UP && pacmanNextDirection == KeyEvent.VK_RIGHT) {

            if (availableSteps.contains(new Point(pacmanCurrentLocation.x + 1, pacmanCurrentLocation.y)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_UP && pacmanNextDirection == KeyEvent.VK_LEFT) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x - 1, pacmanCurrentLocation.y)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_DOWN && pacmanNextDirection == KeyEvent.VK_RIGHT) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x + 1, pacmanCurrentLocation.y)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_DOWN && pacmanNextDirection == KeyEvent.VK_LEFT) {
            if (availableSteps.contains(new Point(pacmanCurrentLocation.x - 1, pacmanCurrentLocation.y)))
                pacmanCurrentDirection = pacmanNextDirection;

        } else if (pacmanCurrentDirection == KeyEvent.VK_UP && pacmanNextDirection == KeyEvent.VK_DOWN)
            pacmanCurrentDirection = pacmanNextDirection;
        else if (pacmanCurrentDirection == KeyEvent.VK_DOWN && pacmanNextDirection == KeyEvent.VK_UP)
            pacmanCurrentDirection = pacmanNextDirection;
        else if (pacmanCurrentDirection == KeyEvent.VK_LEFT && pacmanNextDirection == KeyEvent.VK_RIGHT)
            pacmanCurrentDirection = pacmanNextDirection;
        else if (pacmanCurrentDirection == KeyEvent.VK_RIGHT && pacmanNextDirection == KeyEvent.VK_LEFT)
            pacmanCurrentDirection = pacmanNextDirection;
    }

    public void setAvailableSteps(ArrayList<Point> availableSteps) {
        this.availableSteps = availableSteps;
    }

    public void setPointsToEat(Map<Point, Boolean> pointsToEat) {
        this.pointsToEat = pointsToEat;
    }

    public Point getPacmanCurrentLocation() {
        return pacmanCurrentLocation;
    }

    public void setPacmanCurrentLocation(Point pacmanCurrentLocation) {
        this.pacmanCurrentLocation = pacmanCurrentLocation;
    }

    public int getPacmanLife() {
        return pacmanLife;
    }

    public void setPacmanLife(int pacmanLife) {
        this.pacmanLife = pacmanLife;
    }

    public int getPacmanSpeed() {
        return pacmanSpeed;
    }

    public int getPacmanCurrentDirection() {
        return pacmanCurrentDirection;
    }

    public void setPacmanCurrentDirection(int pacmanCurrentDirection) {
        this.pacmanCurrentDirection = pacmanCurrentDirection;
    }

    public int getPacmanNextDirection() {
        return pacmanNextDirection;
    }

    public void setPacmanNextDirection(int pacmanNextDirection) {
        this.pacmanNextDirection = pacmanNextDirection;
    }

    public Point getPacmanStartLocationLevelFirst() {
        return pacmanStartLocationLevelFirst;
    }

    public Point getPacmanStartLocationLevelSecond() {
        return pacmanStartLocationLevelSecond;
    }
}
