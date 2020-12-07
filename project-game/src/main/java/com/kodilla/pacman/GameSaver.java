package com.kodilla.pacman;

import java.awt.*;
import java.io.*;
import java.util.Map;

public class GameSaver implements Serializable {
    private File settingsFile = new File("settings.txt");
    private File saveGameFile = new File("savegame.file");

    private Object loadGameData;

    private boolean startAnimation;

    private int points;
    private int difficulty;
    private int currentGameLevel;
    private int pacmanLife;
    private int pacmanCurrentDirection;
    private int ghostOrangeCurrentDirection;
    private int ghostBlueCurrentDirection;
    private int ghostRedCurrentDirection;

    private Point pacmanCurrentLocation;
    private Point ghostOrangeCurrentLocation;
    private Point ghostBlueCurrentLocation;
    private Point ghostRedCurrentLocation;

    private Map<Point, Boolean> pointsToEat;

    public void setData (int pacmanLife,
                     int points, int difficulty,
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
        this.points = points;
        this.difficulty = difficulty;
        this.currentGameLevel = currentGameLevel;
        this.pacmanCurrentLocation = pacmanCurrentLocation;
        this.pacmanCurrentDirection = pacmanCurrentDirection;
        this.ghostOrangeCurrentLocation = ghostOrangeCurrentLocation;
        this.ghostBlueCurrentLocation = ghostBlueCurrentLocation;
        this.ghostRedCurrentLocation = ghostRedCurrentLocation;
        this.pointsToEat = pointsToEat;
        this.pacmanLife = pacmanLife;
        this.ghostOrangeCurrentDirection = ghostOrangeCurrentDirection;
        this.ghostBlueCurrentDirection = ghostBlueCurrentDirection;
        this.ghostRedCurrentDirection = ghostRedCurrentDirection;
    }

    public void saveSettings(boolean settings) {
        System.out.println("Saving data...");

        try (FileOutputStream fileOut = new FileOutputStream(settingsFile)) {
            fileOut.write(("").getBytes());

            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(settings);

            System.out.println("DONE");

        } catch (Exception e) {
            System.out.println("Error while saving data " + e);
        }
    }

    public void loadSaveGame() {
        System.out.println("Loading data...");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveGameFile))) {
            loadGameData = ois.readObject();

        } catch (Exception e) {
            System.out.println("Error while loading game..." + e);
        }
    }

    public void readSettings() {
        System.out.println("Reading data...");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(settingsFile))) {
            Object readSettings = ois.readObject();
            startAnimation = (boolean) readSettings;

            System.out.println("STATE: " + startAnimation);

        } catch (Exception e) {
            System.out.println("Error while reading data" + e);
            System.out.println("Trying to fix...");

            saveSettings(true);

        }
    }

    public void saveGameData() {
        try (FileOutputStream fileOut = new FileOutputStream(new File("savegame.file"))) {
            fileOut.write(("").getBytes());

            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);

            System.out.println("DATA SAVED");

            System.exit(0);

        } catch (Exception ex) {
            System.out.println("Error while saving data" + ex);
        }

    }


    public Object getLoadGameData() {
        return loadGameData;
    }

    public File getSaveGameFile() {
        return saveGameFile;
    }

    public boolean isStartAnimation() {
        return startAnimation;
    }

    public int getPacmanLife() {
        return pacmanLife;
    }

    public int getPoints() {
        return points;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getCurrentGameLevel() {
        return currentGameLevel;
    }

    public int getPacmanCurrentDirection() {
        return pacmanCurrentDirection;
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

    public Point getPacmanCurrentLocation() {
        return pacmanCurrentLocation;
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

    public Map<Point, Boolean> getPointsToEat() {
        return pointsToEat;
    }

}
