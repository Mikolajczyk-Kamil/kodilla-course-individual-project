package com.kodilla.pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Timers {
    private GameRunner gameRunner;
    private Menus menus;
    private PacmanData pacmanData;
    private GhostsData ghostsData;
    private Draw draw;
    private GameOverChecker gameOverChecker;

    private int difficulty;

    private int counterMapUnhide = 255;
    private int counterMapHide = 0;
    private int counterVisibilityAnimation = 0;

    private int counterTransitionAnimation = 0;
    private int counterTextHigher = 40;
    private int counterTransitionAnimation2 = 0;

    public Timers(GameRunner gameRunner, Menus menus, PacmanData pacmanData, GhostsData ghostsData, Draw draw, int difficulty, GameOverChecker gameOverChecker) {
        this.gameRunner = gameRunner;
        this.menus = menus;
        this.pacmanData = pacmanData;
        this.ghostsData = ghostsData;
        this.draw = draw;
        this.difficulty = difficulty;
        this.gameOverChecker = gameOverChecker;

        gameOverChecker.setTimers(this);
    }

    private Timer timerMainGame = new Timer(7, (a) -> {
        this.pacmanData.pacmanMove();
        this.draw.eatPoints();

        this.ghostsData.ghostMove(difficulty);

        this.gameOverChecker.checkGameOver(this.ghostsData.getGhostOrangeCurrentLocation());
        this.gameOverChecker.checkGameOver(this.ghostsData.getGhostBlueCurrentLocation());
        if (difficulty == 2 || difficulty == 3)
            this.gameOverChecker.checkGameOver(this.ghostsData.getGhostRedCurrentLocation());

        gameRunner.repaint();

        if (this.menus.isBooleanWin()) {
            this.menus.getLabels().prepareLabels();
            this.menus.getButtons().prepareButtonsForGameWin();

            this.timerMenuAnimation.start();
            this.timerMainGame.stop();
        } else if (this.menus.isBooleanMenuGameOver()) {
            this.menus.getLabels().prepareLabels();
            this.menus.getButtons().prepareButtonsForGameOver();

            counterTransitionAnimation = 0;

            this.timerMenuAnimation.start();
            this.timerMainGame.stop();
        }
    });

    private Timer timerMenuAnimation = new Timer(1, (a) -> {
        if (counterTransitionAnimation < 255) {
            counterTransitionAnimation++;
        } else if (counterTransitionAnimation == 255 && counterTextHigher > -20) {
            counterTextHigher--;
        } else if (counterTextHigher == -20 && counterTransitionAnimation2 < 255) {
            counterTransitionAnimation2 += 5;
        } else if (counterTransitionAnimation2 == 255)
            this.timerMenuAnimation.stop();

        gameRunner.repaint();
    });

    private Timer timerVisibilityAnimation = new Timer(2, (a) -> {
        counterVisibilityAnimation--;

        if (counterVisibilityAnimation == 0) {
            this.timerVisibilityAnimation.stop();
            counterVisibilityAnimation = 0;
            timerMainGame.start();
        }
        gameRunner.repaint();
    });

    private Timer timerEntityVisibility = new Timer(500, (a) -> {
        if (counterVisibilityAnimation % 2 == 0 && counterVisibilityAnimation < 3) {
            this.draw.setBooleanEntityVisibility(false);
        } else if (counterVisibilityAnimation % 2 == 1 && counterVisibilityAnimation < 3) {
            this.draw.setBooleanEntityVisibility(true);
        } else {
            this.timerEntityVisibility.stop();
            this.draw.setBooleanEntityVisibility(true);
            counterVisibilityAnimation = 0;

            this.pacmanData.setPacmanCurrentLocation(new Point(393, 93));
            this.pacmanData.setPacmanCurrentDirection(KeyEvent.VK_RIGHT);
            this.pacmanData.setPacmanNextDirection(KeyEvent.VK_RIGHT);

            this.ghostsData.setGhostOrangeCurrentLocation(new Point(13, 13));
            this.ghostsData.setGhostBlueCurrentLocation(new Point(13, 13));
            this.ghostsData.setGhostRedCurrentLocation(new Point(13, 13));

            timerMainGame.start();
        }
        gameRunner.repaint();
        counterVisibilityAnimation++;
    });

    private Timer timerAnimationUnhideMap = new Timer(1, (a) -> {
        counterMapUnhide--;

        if (counterMapUnhide == 0) {
            this.timerAnimationUnhideMap.stop();
            timerMainGame.start();
        }

        gameRunner.repaint();
    });

    private Timer timerAnimationHideMap = new Timer(1, (a) -> {
        counterMapHide++;

        if (counterMapHide == 255) {
            this.timerAnimationHideMap.stop();
            gameRunner.getChangePanelListener().nextLevel(this.pacmanData.getPacmanLife());
        }

        gameRunner.repaint();
    });

    public void prepareDifficulty() {
        if (difficulty == 0)
            setMainGameTimerDelay(7);
        else if (difficulty == 1)
            setMainGameTimerDelay(5);
        else if (difficulty == 2)
            setMainGameTimerDelay(3);
        else if (difficulty == 3)
            setMainGameTimerDelay(1);
    }

    public void setCounterTransitionAnimation(int counterTransitionAnimation) {
        this.counterTransitionAnimation = counterTransitionAnimation;
    }

    public int getCounterTransitionAnimation() {
        return counterTransitionAnimation;
    }

    public int getCounterTransitionAnimation2() {
        return counterTransitionAnimation2;
    }

    public int getCounterTextHigher() {
        return counterTextHigher;
    }

    public void startMainGameTimer() {
        timerMainGame.start();
    }

    public void stopMainGameTimer() {
        timerMainGame.stop();
    }


    public void startAnimationHideMap() {
        timerAnimationHideMap.start();
    }

    public void startAnimationUnhideMap(){
        timerAnimationUnhideMap.start();
    }

    public void startEntityVisibilityAnimation() {
        timerEntityVisibility.start();
    }

    public GameRunner getGameRunner() {
        return gameRunner;
    }

    public int getCounterMapUnhide() {
        return counterMapUnhide;
    }

    public int getCounterMapHide() {
        return counterMapHide;
    }

    public int getCounterVisibilityAnimation() {
        return counterVisibilityAnimation;
    }

    public void setMainGameTimerDelay(int delay){
        timerMainGame.setDelay(delay);
    }
}
