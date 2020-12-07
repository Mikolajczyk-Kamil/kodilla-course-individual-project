package com.kodilla.pacman;

import java.awt.*;

public class GameOverChecker {
    private GameRunner gameRunner;
    private Timers timers;

    private int pointsToWin;

    public GameOverChecker(GameRunner gameRunner, int currentGameLevel) {
        this.gameRunner = gameRunner;

        if (currentGameLevel == 1) this.pointsToWin = 3530;
        else this.pointsToWin = 3570;
    }

    public void checkGameOver(Point ghostCurrentLocation) {
        if (gameRunner.getPoints() == pointsToWin) gameRunner.getMenus().setBooleanWin(true);

        if (gameRunner.getPacmanData().getPacmanCurrentLocation().x == ghostCurrentLocation.x && gameRunner.getPacmanData().getPacmanCurrentLocation().y == ghostCurrentLocation.y ||
                gameRunner.getPacmanData().getPacmanCurrentLocation().y + 1 == ghostCurrentLocation.y && gameRunner.getPacmanData().getPacmanCurrentLocation().x == ghostCurrentLocation.x ||
                gameRunner.getPacmanData().getPacmanCurrentLocation().y == ghostCurrentLocation.y && gameRunner.getPacmanData().getPacmanCurrentLocation().x + 1 == ghostCurrentLocation.x) {
            gameRunner.getPacmanData().setPacmanLife(gameRunner.getPacmanData().getPacmanLife() - 1);

            if (gameRunner.getPacmanData().getPacmanLife() > 0) {
                resetEntityPosition();
            } else if (gameRunner.getPacmanData().getPacmanLife() == 0)
                gameRunner.getMenus().setBooleanMenuGameOver(true);

        }
    }

    public void resetEntityPosition() {
        timers.setCounterTransitionAnimation(0);
        timers.startEntityVisibilityAnimation();
        timers.stopMainGameTimer();
    }

    public void setTimers(Timers timers) {
        this.timers = timers;
    }
}
