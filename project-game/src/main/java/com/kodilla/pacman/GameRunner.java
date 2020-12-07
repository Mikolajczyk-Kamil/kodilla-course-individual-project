package com.kodilla.pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class GameRunner extends JComponent implements KeyListener {
    private JFrame frame;
    private ChangePanelListener changePanelListener;
    private final KeyListener keyListener = this;

    private PacmanData pacmanData = new PacmanData();
    private GhostsData ghostsData = new GhostsData();
    private GhostMoveResult ghostMoveResult = new GhostMoveResult();
    private Menus menus;
    private GameOverChecker gameOverChecker = new GameOverChecker(this, this.currentGameLevel);
    private Images images = new Images();
    private Draw draw;
    private Timers timers;
    private LevelsMapDataPreparation levelsMapDataPreparation = new LevelsMapDataPreparation();

    private ArrayList<Point> availableSteps;
    private Map<Point, Boolean> pointsToEat;

    private boolean hideMap = false;

    private int difficulty;
    private int currentGameLevel;
    private int points = 0;

    public void startGame(JFrame frame, int currentGameLevel, int difficulty) {
        this.changePanelListener = new ChangePanelListener(frame);
        changePanelListener.setKeyListener(this);
        changePanelListener.setDifficulty(difficulty);

        this.frame = frame;
        this.currentGameLevel = currentGameLevel;
        this.difficulty = difficulty;

        levelsMapDataPreparation.preparePathway(currentGameLevel, pacmanData);
        availableSteps = levelsMapDataPreparation.getAvailableSteps();
        pointsToEat = levelsMapDataPreparation.getPointsToEat();

        preparePacmanData();
        prepareGhostsData();

        menus = new Menus(this, changePanelListener);
        draw = new Draw(this, menus, pacmanData, ghostsData, images, difficulty, this.pointsToEat);
        timers = new Timers(this, menus, pacmanData, ghostsData, draw,  difficulty, gameOverChecker);

        images.prepareImages(difficulty);
        menus.getButtons().prepareButtonsForPause();
        menus.getLabels().prepareLabels();

        timers.prepareDifficulty();
        timers.startAnimationUnhideMap();
    }

    public GameRunner(JFrame frame, int currentGameLevel, int difficulty) {
        startGame(frame, currentGameLevel, difficulty);
    }

    public GameRunner(JFrame frame, int currentGameLevel, int difficulty, int pacmanLife) {
        pacmanData.setPacmanLife(pacmanLife);

        startGame(frame, currentGameLevel, difficulty);
    }

    public GameRunner(JFrame frame,
                      int pacmanLife,
                      int points,
                      int difficulty,
                      int currentGameLevel,
                      int pacmanCurrentDirection,
                      int ghostOrangeCurrentDirection,
                      int ghostBlueCurrentDirection,
                      int ghostRedCurrentDirection,
                      Point pacmanCurrentLocation,
                      Point ghostOrangeCurrentLocation,
                      Point ghostBlueCurrentLocation,
                      Point ghostRedCurrentLocation,
                      Map<Point, Boolean> pointsToEat) {

        this.frame = frame;
        this.points = points;
        this.difficulty = difficulty;
        this.currentGameLevel = currentGameLevel;

        ghostsData.setGhostOrangeCurrentLocation(ghostOrangeCurrentLocation);
        ghostsData.setGhostBlueCurrentLocation(ghostBlueCurrentLocation);
        ghostsData.setGhostRedCurrentLocation(ghostRedCurrentLocation);

        ghostsData.setGhostOrangeCurrentDirection(ghostOrangeCurrentDirection);
        ghostsData.setGhostBlueCurrentDirection(ghostBlueCurrentDirection);
        ghostsData.setGhostRedCurrentDirection(ghostRedCurrentDirection);

        pacmanData.setPacmanLife(pacmanLife);

        this.changePanelListener = new ChangePanelListener(frame);
        changePanelListener.setKeyListener(this);
        changePanelListener.setDifficulty(difficulty);

        levelsMapDataPreparation.preparePathway(currentGameLevel, pacmanData);
        availableSteps = levelsMapDataPreparation.getAvailableSteps();

        preparePacmanData();
        prepareGhostsData();

        pacmanData.setPacmanCurrentLocation(pacmanCurrentLocation);
        pacmanData.setPacmanCurrentDirection(pacmanCurrentDirection);

        this.pointsToEat = pointsToEat;

        menus = new Menus(this, changePanelListener);
        draw = new Draw(this, menus, pacmanData, ghostsData, images, difficulty, this.pointsToEat);
        timers = new Timers(this, menus, pacmanData, ghostsData, draw,  difficulty, gameOverChecker);

        menus.getLabels().getLabelPoints().setText(String.valueOf(points));
        this.menus.setBooleanMenuPause(false);

        images.prepareImages(difficulty);
        menus.getButtons().prepareButtonsForPause();
        menus.getLabels().prepareLabels();

        timers.prepareDifficulty();
        timers.startAnimationUnhideMap();
    }

    public void preparePacmanData() {
        pacmanData.setAvailableSteps(availableSteps);
        pacmanData.setPointsToEat(pointsToEat);
    }

    public void prepareGhostsData() {
        ghostsData.setAvailableSteps(availableSteps);
        ghostsData.setPointsToEat(pointsToEat);
        ghostsData.setPacmanData(pacmanData);
        ghostsData.setGhostMoveResult(ghostMoveResult);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (currentGameLevel == 1)
            draw.levelFirstMap(g2d);
        else if (currentGameLevel == 2)
            draw.levelSecondMap(g2d);

        //DRAW OTHER STUFF
        g2d.setColor(Color.decode("#3468eb"));

        draw.drawPointsToEat(g2d);
        draw.drawEntity(g2d);


        if (menus.isBooleanWin()) g2d = menus.drawWinMenu(g2d);

        if (menus.isBooleanMenuGameOver()) g2d = menus.drawGameOverMenu(g2d);

        if (menus.isBooleanMenuPause()) g2d = menus.drawPauseMenu(g2d);

        draw.drawLife(g2d);

        if (!hideMap)
            g2d.setColor(new Color(0, 0, 0, timers.getCounterMapUnhide()));
        else {
            g2d.setColor(new Color(0, 0, 0, timers.getCounterMapHide()));
            menus.setColorWinText(new Color(235, 213, 52, 255 - timers.getCounterMapHide()));
        }

        g2d.fillRect(0, 0, getWidth(), getHeight());
    }


    //KEY LISTENER
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("MENU PAUSE " + menus.isBooleanMenuPause());
        System.out.println("MENU WIN " + menus.isBooleanWin());
        System.out.println("MENU OVER " + menus.isBooleanMenuGameOver());

        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!menus.isBooleanMenuPause())
                pacmanData.setPacmanNextDirection(e.getKeyCode());
            else menus.changeCurrentButton(e);
        } else if (e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            menus.pause();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && menus.isBooleanMenuPause()) {
            menus.enter();
            menus.changeCurrentButton(e);
        }

        if (menus.isBooleanWin() || menus.isBooleanMenuGameOver()) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                menus.enter();
                menus.changeCurrentButton(e);
            } else menus.changeCurrentButton(e);
        }

        repaint();
    }



    public JFrame getFrame() {
        return frame;
    }

    public ChangePanelListener getChangePanelListener() {
        return changePanelListener;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getPoints() {
        return points;
    }

    public Menus getMenus() {
        return menus;
    }

    public GhostsData getGhostsData() {
        return ghostsData;
    }

    public Map<Point, Boolean> getPointsToEat() {
        return pointsToEat;
    }

    public PacmanData getPacmanData() {
        return pacmanData;
    }

    public KeyListener getKeyListener() {
        return keyListener;
    }

    public int getCurrentGameLevel() {
        return currentGameLevel;
    }

    public boolean isHideMap() {
        return hideMap;
    }

    public Timers getTimers() {
        return timers;
    }

    public void setHideMap(boolean hideMap) {
        this.hideMap = hideMap;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    //IMPLEMENTATION TRASH
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
