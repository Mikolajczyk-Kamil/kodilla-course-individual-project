package com.kodilla.pacman;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.*;

public class ChangePanelListener implements Serializable {
    private final JFrame frame;
    private GameSaver gameSaver = new GameSaver();
    private KeyListener keyListener;

    private int difficulty;

    public ChangePanelListener(JFrame frame) {
        this.frame = frame;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void startGame() {
        GameRunner gameRunner = new GameRunner(frame, 1, difficulty);

        frame.removeKeyListener(keyListener);
        frame.getContentPane().removeAll();

        frame.add(gameRunner);
        frame.addKeyListener(gameRunner);

        frame.validate();
    }

    public void nextLevel(int pacmanLife) {
        GameRunner gameRunner = new GameRunner(frame, 2, difficulty, pacmanLife);

        frame.removeKeyListener(keyListener);
        frame.getContentPane().removeAll();

        frame.add(gameRunner);
        frame.addKeyListener(gameRunner);

        frame.validate();

    }

    public void mainMenu() {
        MainMenu mainMenu = new MainMenu(this, false);

        frame.removeKeyListener(keyListener);
        frame.getContentPane().removeAll();

        frame.add(mainMenu);
        frame.addKeyListener(mainMenu);

        frame.validate();
    }

    public void loadSavegame() {
        gameSaver.loadSaveGame();

        gameSaver = (GameSaver) gameSaver.getLoadGameData();

        GameRunner gameRunner = new GameRunner(frame, gameSaver.getPacmanLife(),
                gameSaver.getPoints(), gameSaver.getDifficulty(),
                gameSaver.getCurrentGameLevel(),
                gameSaver.getPacmanCurrentDirection(),
                gameSaver.getGhostOrangeCurrentDirection(),
                gameSaver.getGhostBlueCurrentDirection(),
                gameSaver.getGhostRedCurrentDirection(),
                gameSaver.getPacmanCurrentLocation(),
                gameSaver.getGhostOrangeCurrentLocation(),
                gameSaver.getGhostBlueCurrentLocation(),
                gameSaver.getGhostRedCurrentLocation(),
                gameSaver.getPointsToEat());

        frame.removeKeyListener(keyListener);
        frame.getContentPane().removeAll();

        frame.add(gameRunner);
        frame.addKeyListener(gameRunner);

        gameSaver.getSaveGameFile().delete();

        frame.validate();

    }

    public boolean isSaveGameFileExist() {
        return gameSaver.getSaveGameFile().exists();
    }

}
