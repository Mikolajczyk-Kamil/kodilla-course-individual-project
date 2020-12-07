package com.kodilla.pacman;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GhostsData {
    private Random random = new Random();

    private GhostMoveResult ghostMoveResult;
    private PacmanData pacmanData;
    private ArrayList<Point> availableSteps;
    private Map<Point, Boolean> pointsToEat;

    private Point ghostOrangeCurrentLocation = new Point(33, 13);
    private Point ghostBlueCurrentLocation = new Point(693, 293);
    private Point ghostRedCurrentLocation = new Point(113, 193);

    private int ghostSpeed = 1;
    private int ghostOrangeCurrentDirection = KeyEvent.VK_RIGHT;
    private int ghostBlueCurrentDirection = KeyEvent.VK_LEFT;
    private int ghostRedCurrentDirection = KeyEvent.VK_RIGHT;

    public void ghostMove(int difficulty){
        move(ghostOrangeCurrentLocation, ghostOrangeCurrentDirection);
        ghostOrangeCurrentDirection = ghostMoveResult.getGhostCurrentDirection();

        move(ghostBlueCurrentLocation, ghostBlueCurrentDirection);
        ghostBlueCurrentDirection = ghostMoveResult.getGhostCurrentDirection();

        if (difficulty == 2 || difficulty == 3) {
            move(ghostRedCurrentLocation, ghostRedCurrentDirection);
            ghostRedCurrentDirection = ghostMoveResult.getGhostCurrentDirection();
        }
    }

    public void move(Point ghostCurrentLocation, int ghostCurrentDirection) {
        ghostCurrentDirection = ghostFindNextTurn(ghostCurrentLocation, ghostCurrentDirection, random.nextInt(4) + 37);


        if (ghostCurrentDirection == KeyEvent.VK_UP) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y - pacmanData.getPacmanSpeed())))
                ghostCurrentLocation.y -= ghostSpeed;
        } else if (ghostCurrentDirection == KeyEvent.VK_DOWN) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y + pacmanData.getPacmanSpeed())))
                ghostCurrentLocation.y += ghostSpeed;
        } else if (ghostCurrentDirection == KeyEvent.VK_RIGHT) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x + pacmanData.getPacmanSpeed(), ghostCurrentLocation.y)))
                ghostCurrentLocation.x += ghostSpeed;
        } else if (ghostCurrentDirection == KeyEvent.VK_LEFT) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x - pacmanData.getPacmanSpeed(), ghostCurrentLocation.y)))
                ghostCurrentLocation.x -= ghostSpeed;
        }

        ghostMoveResult.setGhostCurrentLocation(ghostCurrentLocation);
        ghostMoveResult.setGhostCurrentDirection(ghostCurrentDirection);

    }

    public int ghostFindNextTurn(Point ghostCurrentLocation, int ghostCurrentDirection, int ghostNextDirection) {
        if (ghostCurrentDirection == KeyEvent.VK_RIGHT && ghostNextDirection == KeyEvent.VK_DOWN) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y + 1)))
                ghostCurrentDirection = ghostNextDirection;

        } else if (ghostCurrentDirection == KeyEvent.VK_RIGHT && ghostNextDirection == KeyEvent.VK_UP) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y - 1)))
                ghostCurrentDirection = ghostNextDirection;

        } else if (ghostCurrentDirection == KeyEvent.VK_LEFT && ghostNextDirection == KeyEvent.VK_DOWN) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y + 1)))
                ghostCurrentDirection = ghostNextDirection;

        } else if (ghostCurrentDirection == KeyEvent.VK_LEFT && ghostNextDirection == KeyEvent.VK_UP) {

            if (availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y - 1)))
                ghostCurrentDirection = ghostNextDirection;

        } else if (ghostCurrentDirection == KeyEvent.VK_UP && ghostNextDirection == KeyEvent.VK_RIGHT) {

            if (availableSteps.contains(new Point(ghostCurrentLocation.x + 1, ghostCurrentLocation.y)))
                ghostCurrentDirection = ghostNextDirection;

        } else if (ghostCurrentDirection == KeyEvent.VK_UP && ghostNextDirection == KeyEvent.VK_LEFT) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x - 1, ghostCurrentLocation.y)))
                ghostCurrentDirection = ghostNextDirection;

        } else if (ghostCurrentDirection == KeyEvent.VK_DOWN && ghostNextDirection == KeyEvent.VK_RIGHT) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x + 1, ghostCurrentLocation.y)))
                ghostCurrentDirection = ghostNextDirection;

        } else if (ghostCurrentDirection == KeyEvent.VK_DOWN && ghostNextDirection == KeyEvent.VK_LEFT) {
            if (availableSteps.contains(new Point(ghostCurrentLocation.x - 1, ghostCurrentLocation.y)))
                ghostCurrentDirection = ghostNextDirection;
        }

        if (ghostCurrentDirection == KeyEvent.VK_RIGHT) {
            if (!availableSteps.contains(new Point(ghostCurrentLocation.x + 1, ghostCurrentLocation.y)) &&
                    !availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y - 1)) &&
                    !availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y + 1)))
                ghostCurrentDirection = KeyEvent.VK_LEFT;
        } else if (ghostCurrentDirection == KeyEvent.VK_LEFT) {
            if (!availableSteps.contains(new Point(ghostCurrentLocation.x - 1, ghostCurrentLocation.y)) &&
                    !availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y - 1)) &&
                    !availableSteps.contains(new Point(ghostCurrentLocation.x, ghostCurrentLocation.y + 1)))
                ghostCurrentDirection = KeyEvent.VK_RIGHT;
        }

        return ghostCurrentDirection;
    }

    public void setPacmanData(PacmanData pacmanData) {
        this.pacmanData = pacmanData;
    }

    public void setAvailableSteps(ArrayList<Point> availableSteps) {
        this.availableSteps = availableSteps;
    }

    public void setPointsToEat(Map<Point, Boolean> pointsToEat) {
        this.pointsToEat = pointsToEat;
    }

    public void setGhostOrangeCurrentLocation(Point ghostOrangeCurrentLocation) {
        this.ghostOrangeCurrentLocation = ghostOrangeCurrentLocation;
    }

    public void setGhostBlueCurrentLocation(Point ghostBlueCurrentLocation) {
        this.ghostBlueCurrentLocation = ghostBlueCurrentLocation;
    }

    public void setGhostRedCurrentLocation(Point ghostRedCurrentLocation) {
        this.ghostRedCurrentLocation = ghostRedCurrentLocation;
    }

    public void setGhostOrangeCurrentDirection(int ghostOrangeCurrentDirection) {
        this.ghostOrangeCurrentDirection = ghostOrangeCurrentDirection;
    }

    public void setGhostBlueCurrentDirection(int ghostBlueCurrentDirection) {
        this.ghostBlueCurrentDirection = ghostBlueCurrentDirection;
    }

    public void setGhostRedCurrentDirection(int ghostRedCurrentDirection) {
        this.ghostRedCurrentDirection = ghostRedCurrentDirection;
    }

    public Point getGhostOrangeCurrentLocation() {
        return ghostOrangeCurrentLocation;
    }

    public Point getGhostBlueCurrentLocation() {
        return ghostBlueCurrentLocation;
    }

    public Point getGhostRedCurrentLocation() {
        return ghostRedCurrentLocation;
    }

    public int getGhostOrangeCurrentDirection() {
        return ghostOrangeCurrentDirection;
    }

    public int getGhostBlueCurrentDirection() {
        return ghostBlueCurrentDirection;
    }

    public int getGhostRedCurrentDirection() {
        return ghostRedCurrentDirection;
    }

    public void setGhostMoveResult(GhostMoveResult ghostMoveResult) {
        this.ghostMoveResult = ghostMoveResult;
    }
}
