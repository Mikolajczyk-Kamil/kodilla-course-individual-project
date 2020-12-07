package com.kodilla.pacman;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Map;

public class Draw {
    private GameRunner gameRunner;
    private Menus menus;
    private PacmanData pacmanData;
    private GhostsData ghostsData;
    private Images images;

    private Map<Point, Boolean> pointsToEat;

    private final int rectangle = 10;
    private final Point heartPosition = new Point(700, 320);

    private boolean booleanEntityVisibility = true;
    private int difficulty;

    private BufferedImage imageGhostOrangeCurrentImage;
    private BufferedImage imageGhostBlueCurrentImage;
    private BufferedImage imageGhostRedCurrentImage;

    public Draw(GameRunner gameRunner, Menus menus, PacmanData pacmanData, GhostsData ghostsData, Images images, int difficulty, Map<Point, Boolean> pointsToEat) {
        this.gameRunner = gameRunner;
        this.menus = menus;
        this.pacmanData = pacmanData;
        this.ghostsData = ghostsData;
        this.images = images;
        this.difficulty = difficulty;
        this.pointsToEat = pointsToEat;
    }

    public void levelFirstMap(Graphics2D g2d) {
        //frame
        g2d.setColor(Color.decode("#3468eb"));
        g2d.drawRoundRect(10, 10, 800, 300, rectangle, rectangle);

        //horizontal
        g2d.drawRoundRect(30, 30, 100, 20, rectangle, rectangle);
        g2d.drawRoundRect(150, 30, 100, 20, rectangle, rectangle);
        g2d.drawRoundRect(270, 30, 40, 20, rectangle, rectangle);
        g2d.drawRoundRect(490, 30, 140, 20, rectangle, rectangle);

        g2d.drawRoundRect(30, 70, 40, 20, rectangle, rectangle);
        g2d.drawRoundRect(90, 70, 100, 20, rectangle, rectangle);
        g2d.drawRoundRect(210, 70, 100, 20, rectangle, rectangle);
        g2d.drawRoundRect(460, 70, 170, 20, rectangle, rectangle);

        g2d.drawRoundRect(110, 110, 120, 20, rectangle, rectangle);
        g2d.drawRoundRect(250, 110, 90, 20, rectangle, rectangle);
        g2d.drawRoundRect(490, 110, 140, 20, rectangle, rectangle);

        g2d.drawRoundRect(490, 150, 140, 20, rectangle, rectangle);

        g2d.drawRoundRect(330, 190, 140, 20, rectangle, rectangle);
        g2d.drawRoundRect(490, 190, 140, 20, rectangle, rectangle);

        g2d.drawRoundRect(550, 230, 230, 20, rectangle, rectangle);

        g2d.drawRoundRect(330, 230, 200, 20, rectangle, rectangle);

        g2d.drawRoundRect(330, 270, 260, 20, rectangle, rectangle);


        //vertical
        g2d.drawRoundRect(30, 110, 20, 80, rectangle, rectangle);
        g2d.drawRoundRect(30, 210, 20, 80, rectangle, rectangle);

        g2d.drawRoundRect(70, 110, 20, 120, rectangle, rectangle);
        g2d.drawRoundRect(70, 250, 20, 40, rectangle, rectangle);

        g2d.drawRoundRect(110, 150, 20, 40, rectangle, rectangle);
        g2d.drawRoundRect(110, 210, 20, 80, rectangle, rectangle);

        g2d.drawRoundRect(330, 30, 20, 140, rectangle, rectangle);

        g2d.drawRoundRect(370, 30, 20, 140, rectangle, rectangle);

        g2d.drawRoundRect(410, 30, 20, 140, rectangle, rectangle);

        g2d.drawRoundRect(450, 30, 20, 140, rectangle, rectangle);

        g2d.drawRoundRect(610, 270, 140, 20, rectangle, rectangle);

        g2d.drawRoundRect(650, 30, 20, 120, rectangle, rectangle);

        g2d.drawRoundRect(770, 170, 20, 120, rectangle, rectangle);

        //special shapes
        g2d.drawRoundRect(150, 150, 160, 140, rectangle, rectangle);
        g2d.drawRoundRect(170, 170, 120, 100, rectangle, rectangle);
        g2d.drawRoundRect(190, 190, 80, 60, rectangle, rectangle);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(150, 200, 21, 40);
        g2d.fillRect(290, 200, 21, 40);

        g2d.setColor(Color.decode("#3468eb"));
        g2d.drawRoundRect(150, 190, 20, 20, rectangle, rectangle);
        g2d.drawRoundRect(150, 230, 20, 20, rectangle, rectangle);

        g2d.drawRoundRect(290, 190, 20, 20, rectangle, rectangle);
        g2d.drawRoundRect(290, 230, 20, 20, rectangle, rectangle);


        g2d.setColor(Color.BLACK);
        g2d.fillRect(151, 190, 19, 10);
        g2d.fillRect(151, 241, 19, 10);
        g2d.fillRect(291, 190, 19, 10);
        g2d.fillRect(291, 241, 19, 10);

        //squares
        g2d.setColor(Color.decode("#3468eb"));
        g2d.drawRoundRect(650, 170, 100, 40, rectangle, rectangle);

        g2d.drawRoundRect(690, 30, 40, 40, rectangle, rectangle);
        g2d.drawRoundRect(690, 90, 40, 60, rectangle, rectangle);

        g2d.drawRoundRect(750, 30, 40, 60, rectangle, rectangle);
        g2d.drawRoundRect(750, 110, 40, 40, rectangle, rectangle);

        //correctors
        g2d.setColor(Color.BLACK);
        g2d.fillRect(330, 110, 15, 21);
        g2d.fillRect(330, 110, 1, 20);

        g2d.fillRect(460, 70, 10, 21);
        g2d.fillRect(470, 70, 1, 20);

        g2d.fillRect(770, 230, 11, 21);
        g2d.fillRect(770, 230, 1, 20);

    }

    public void levelSecondMap(Graphics2D g2d) {
        //frame
        g2d.setColor(Color.decode("#3468eb"));
        g2d.drawRoundRect(10, 10, 800, 300, rectangle, rectangle);

        //OBJECT1
        g2d.drawRoundRect(30, 30, 20, 80, rectangle, rectangle);
        g2d.drawRoundRect(40, 70, 60, 20, rectangle, rectangle);
        g2d.drawRoundRect(90, 30, 20, 60, rectangle, rectangle);
        g2d.drawRoundRect(70, 30, 30, 20, rectangle, rectangle);

        g2d.drawRoundRect(410, 30, 20, 80, rectangle, rectangle);
        g2d.drawRoundRect(420, 70, 60, 20, rectangle, rectangle);
        g2d.drawRoundRect(470, 30, 20, 60, rectangle, rectangle);
        g2d.drawRoundRect(450, 30, 30, 20, rectangle, rectangle);

        //OBJECT2
        g2d.drawRoundRect(130, 30, 20, 100, rectangle, rectangle);
        g2d.drawRoundRect(140, 30, 30, 20, rectangle, rectangle);
        g2d.drawRoundRect(140, 70, 30, 40, rectangle, rectangle);
        g2d.drawRoundRect(160, 70, 30, 20, rectangle, rectangle);

        g2d.drawRoundRect(510, 30, 20, 100, rectangle, rectangle);
        g2d.drawRoundRect(520, 30, 30, 20, rectangle, rectangle);
        g2d.drawRoundRect(520, 70, 30, 40, rectangle, rectangle);
        g2d.drawRoundRect(540, 70, 30, 20, rectangle, rectangle);

        //OBJECT3
        g2d.drawRoundRect(190, 30, 30, 20, rectangle, rectangle);
        g2d.drawRoundRect(210, 30, 40, 40, rectangle, rectangle);
        g2d.drawRoundRect(230, 60, 20, 50, rectangle, rectangle);
        g2d.drawRoundRect(210, 90, 40, 20, rectangle, rectangle);
        g2d.drawRoundRect(210, 90, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(190, 110, 40, 40, rectangle, rectangle);
        g2d.drawRoundRect(170, 130, 30, 20, rectangle, rectangle);

        g2d.drawRoundRect(570, 30, 30, 20, rectangle, rectangle);
        g2d.drawRoundRect(590, 30, 40, 40, rectangle, rectangle);
        g2d.drawRoundRect(610, 60, 20, 50, rectangle, rectangle);
        g2d.drawRoundRect(590, 90, 40, 20, rectangle, rectangle);
        g2d.drawRoundRect(590, 90, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(570, 110, 40, 40, rectangle, rectangle);
        g2d.drawRoundRect(550, 130, 30, 20, rectangle, rectangle);

        //OBJECT4
        g2d.drawRoundRect(130, 150, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(130, 170, 140, 20, rectangle, rectangle);

        g2d.drawRoundRect(510, 150, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(510, 170, 160, 20, rectangle, rectangle);

        //OBJECT5
        g2d.drawRoundRect(270, 30, 70, 20, rectangle, rectangle);
        g2d.drawRoundRect(270, 40, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(310, 70, 40, 20, rectangle, rectangle);
        g2d.drawRoundRect(310, 70, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(330, 60, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(270, 90, 60, 20, rectangle, rectangle);
        g2d.drawRoundRect(330, 30, 60, 40, rectangle, rectangle);

        g2d.drawRoundRect(650, 30, 90, 20, rectangle, rectangle);
        g2d.drawRoundRect(650, 40, 40, 30, rectangle, rectangle);
        g2d.drawRoundRect(710, 70, 40, 20, rectangle, rectangle);
        g2d.drawRoundRect(710, 70, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(730, 60, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(650, 90, 80, 20, rectangle, rectangle);
        g2d.drawRoundRect(730, 30, 60, 40, rectangle, rectangle);

        //OBJECT6
        g2d.drawRoundRect(250, 130, 60, 20, rectangle, rectangle);
        g2d.drawRoundRect(290, 140, 20, 40, rectangle, rectangle);
        g2d.drawRoundRect(290, 170, 100, 20, rectangle, rectangle);

        g2d.drawRoundRect(630, 130, 80, 20, rectangle, rectangle);
        g2d.drawRoundRect(690, 140, 20, 40, rectangle, rectangle);
        g2d.drawRoundRect(690, 170, 100, 20, rectangle, rectangle);

        //OBJECT7
        g2d.drawRoundRect(370, 90, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(350, 110, 40, 40, rectangle, rectangle);
        g2d.drawRoundRect(330, 130, 30, 20, rectangle, rectangle);

        g2d.drawRoundRect(770, 90, 20, 30, rectangle, rectangle);
        g2d.drawRoundRect(750, 110, 40, 40, rectangle, rectangle);
        g2d.drawRoundRect(730, 130, 30, 20, rectangle, rectangle);

        //OBJECT
        g2d.drawRoundRect(30, 130, 20, 60, rectangle, rectangle);

        g2d.drawRoundRect(410, 130, 20, 60, rectangle, rectangle);

        //OBJECT
        g2d.drawRoundRect(70, 110, 40, 20, rectangle, rectangle);

        g2d.drawRoundRect(450, 110, 40, 20, rectangle, rectangle);

        //OBJECT
        g2d.drawRoundRect(70, 150, 40, 40, rectangle, rectangle);

        g2d.drawRoundRect(450, 150, 40, 40, rectangle, rectangle);


        //HORIZONTAL
        g2d.drawRoundRect(30, 270, 80, 20, rectangle, rectangle);

        g2d.drawRoundRect(430, 270, 80, 20, rectangle, rectangle);

        g2d.drawRoundRect(230, 270, 80, 20, rectangle, rectangle);

        g2d.drawRoundRect(530, 270, 80, 20, rectangle, rectangle);

        g2d.drawRoundRect(730, 270, 60, 20, rectangle, rectangle);

        g2d.drawRoundRect(130, 210, 80, 20, rectangle, rectangle);

        g2d.drawRoundRect(330, 210, 80, 20, rectangle, rectangle);

        g2d.drawRoundRect(630, 210, 80, 20, rectangle, rectangle);

        //VERTICAL
        g2d.drawRoundRect(30, 210, 20, 40, rectangle, rectangle);

        g2d.drawRoundRect(430, 210, 20, 40, rectangle, rectangle);

        g2d.drawRoundRect(290, 210, 20, 40, rectangle, rectangle);

        g2d.drawRoundRect(590, 210, 20, 40, rectangle, rectangle);

        g2d.drawRoundRect(190, 250, 20, 40, rectangle, rectangle);

        g2d.drawRoundRect(390, 250, 20, 40, rectangle, rectangle);

        g2d.drawRoundRect(690, 250, 20, 40, rectangle, rectangle);

        //SQUARE
        g2d.drawRoundRect(70, 210, 40, 40, rectangle, rectangle);

        g2d.drawRoundRect(470, 210, 40, 40, rectangle, rectangle);

        g2d.drawRoundRect(230, 210, 40, 40, rectangle, rectangle);

        g2d.drawRoundRect(530, 210, 40, 40, rectangle, rectangle);

        g2d.drawRoundRect(730, 210, 60, 40, rectangle, rectangle);

        g2d.drawRoundRect(130, 250, 40, 40, rectangle, rectangle);

        g2d.drawRoundRect(330, 250, 40, 40, rectangle, rectangle);

        g2d.drawRoundRect(630, 250, 40, 40, rectangle, rectangle);


        //CORRECTORS
        g2d.setColor(Color.BLACK);

        //OBJECT1
        g2d.fillRect(40, 71, 61, 19);
        g2d.fillRect(40, 69, 9, 22);
        g2d.fillRect(91, 31, 10, 40);
        g2d.fillRect(89, 31, 2, 19);

        g2d.fillRect(420, 71, 61, 19);
        g2d.fillRect(420, 69, 9, 22);
        g2d.fillRect(471, 31, 10, 40);
        g2d.fillRect(469, 31, 2, 19);

        //OBJECT2
        g2d.fillRect(140, 31, 11, 20);
        g2d.fillRect(140, 70, 11, 41);
        g2d.fillRect(160, 71, 11, 20);

        g2d.fillRect(520, 31, 11, 20);
        g2d.fillRect(520, 70, 11, 41);
        g2d.fillRect(540, 71, 11, 20);

        //OBJECT3
        g2d.fillRect(210, 31, 11, 20);
        g2d.fillRect(230, 60, 20, 11);
        g2d.fillRect(230, 90, 20, 10);
        g2d.fillRect(220, 91, 20, 19);
        g2d.fillRect(211, 100, 19, 30);
        g2d.fillRect(210, 110, 10, 19);
        g2d.fillRect(189, 130, 14, 20);

        g2d.fillRect(590, 31, 11, 20);
        g2d.fillRect(610, 60, 20, 11);
        g2d.fillRect(610, 90, 20, 10);
        g2d.fillRect(600, 91, 20, 19);
        g2d.fillRect(591, 100, 19, 30);
        g2d.fillRect(590, 110, 10, 19);
        g2d.fillRect(569, 130, 14, 20);

        //OBJECT4
        g2d.fillRect(131, 170, 20, 11);

        g2d.fillRect(511, 170, 20, 11);

        //OBJECT5
        g2d.fillRect(330, 31, 11, 20);
        g2d.fillRect(271, 40, 20, 11);
        g2d.fillRect(320, 71, 20, 19);
        g2d.fillRect(311, 80, 19, 21);
        g2d.fillRect(310, 90, 19, 11);
        g2d.fillRect(331, 60, 19, 20);
        g2d.fillRect(331, 60, 20, 10);

        g2d.fillRect(730, 31, 11, 20);
        g2d.fillRect(651, 40, 40, 11);
        g2d.fillRect(720, 71, 20, 19);
        g2d.fillRect(711, 80, 19, 21);
        g2d.fillRect(710, 90, 19, 11);
        g2d.fillRect(731, 60, 19, 20);
        g2d.fillRect(731, 60, 20, 10);

        //OBJECT6
        g2d.fillRect(290, 140, 20, 11);
        g2d.fillRect(291, 170, 20, 11);

        g2d.fillRect(690, 140, 20, 11);
        g2d.fillRect(691, 170, 20, 11);

        //OBJECT7
        g2d.fillRect(370, 110, 20, 11);
        g2d.fillRect(350, 130, 11, 20);

        g2d.fillRect(770, 110, 20, 11);
        g2d.fillRect(750, 130, 11, 20);

    }

    public void drawEntity(Graphics2D g2d) {
        if (booleanEntityVisibility) {
            if (ghostsData.getGhostOrangeCurrentDirection() == KeyEvent.VK_RIGHT)
                imageGhostOrangeCurrentImage = images.getImageGhostOrangeRight();
            else if (ghostsData.getGhostOrangeCurrentDirection() == KeyEvent.VK_LEFT)
                imageGhostOrangeCurrentImage = images.getImageGhostOrangeLeft();

            if (ghostsData.getGhostBlueCurrentDirection() == KeyEvent.VK_RIGHT)
                imageGhostBlueCurrentImage = images.getImageGhostBlueRight();
            else if (ghostsData.getGhostBlueCurrentDirection() == KeyEvent.VK_LEFT)
                imageGhostBlueCurrentImage = images.getImageGhostBlueLeft();

            g2d.drawImage(imageGhostOrangeCurrentImage, ghostsData.getGhostOrangeCurrentLocation().x, ghostsData.getGhostOrangeCurrentLocation().y, null);
            g2d.drawImage(imageGhostBlueCurrentImage, ghostsData.getGhostBlueCurrentLocation().x, ghostsData.getGhostBlueCurrentLocation().y, null);


            if (difficulty == 2 || difficulty == 3) {
                g2d.drawImage(imageGhostRedCurrentImage, ghostsData.getGhostRedCurrentLocation().x, ghostsData.getGhostRedCurrentLocation().y, null);

                if (ghostsData.getGhostRedCurrentDirection() == KeyEvent.VK_RIGHT)
                    imageGhostRedCurrentImage = images.getImageGhostRedRight();
                else if (ghostsData.getGhostRedCurrentDirection() == KeyEvent.VK_LEFT)
                    imageGhostRedCurrentImage = images.getImageGhostRedLeft();
            }


            if (pacmanData.getPacmanCurrentDirection() == KeyEvent.VK_LEFT)
                g2d.drawImage(images.getImagePacmanLeft(), pacmanData.getPacmanCurrentLocation().x, pacmanData.getPacmanCurrentLocation().y, null);
            else if (pacmanData.getPacmanCurrentDirection() == KeyEvent.VK_RIGHT)
                g2d.drawImage(images.getImagePacmanRight(), pacmanData.getPacmanCurrentLocation().x, pacmanData.getPacmanCurrentLocation().y, null);
            else if (pacmanData.getPacmanCurrentDirection() == KeyEvent.VK_UP)
                g2d.drawImage(images.getImagePacmanUp(), pacmanData.getPacmanCurrentLocation().x, pacmanData.getPacmanCurrentLocation().y, null);
            else if (pacmanData.getPacmanCurrentDirection() == KeyEvent.VK_DOWN)
                g2d.drawImage(images.getImagePacmanDown(), pacmanData.getPacmanCurrentLocation().x, pacmanData.getPacmanCurrentLocation().y, null);
        }

    }

    public void drawLife(Graphics2D g2d) {
        BufferedImage imageHeartRed = images.getImageHeartRed();
        BufferedImage imageHeartGrey = images.getImageHeartGrey();

        if (pacmanData.getPacmanLife() == 3) {
            g2d.drawImage(imageHeartRed, heartPosition.x, heartPosition.y, null);
            g2d.drawImage(imageHeartRed, heartPosition.x + 25, heartPosition.y, null);
            g2d.drawImage(imageHeartRed, heartPosition.x + 50, heartPosition.y, null);
        } else if (pacmanData.getPacmanLife() == 2) {
            g2d.drawImage(imageHeartRed, heartPosition.x, heartPosition.y, null);
            g2d.drawImage(imageHeartRed, heartPosition.x + 25, heartPosition.y, null);
            g2d.drawImage(imageHeartGrey, heartPosition.x + 50, heartPosition.y, null);

            if (!booleanEntityVisibility)
                g2d.drawImage(imageHeartRed, heartPosition.x + 50, heartPosition.y, null);
        } else if (pacmanData.getPacmanLife() == 1) {
            g2d.drawImage(imageHeartRed, heartPosition.x, heartPosition.y, null);
            g2d.drawImage(imageHeartGrey, heartPosition.x + 25, heartPosition.y, null);
            g2d.drawImage(imageHeartGrey, heartPosition.x + 50, heartPosition.y, null);

            if (!booleanEntityVisibility)
                g2d.drawImage(imageHeartRed, heartPosition.x + 25, heartPosition.y, null);
        } else {
            g2d.drawImage(imageHeartGrey, heartPosition.x, heartPosition.y, null);
            g2d.drawImage(imageHeartGrey, heartPosition.x + 25, heartPosition.y, null);
            g2d.drawImage(imageHeartGrey, heartPosition.x + 50, heartPosition.y, null);
        }

    }

    public void drawPointsToEat(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        for (Map.Entry<Point, Boolean> point : pointsToEat.entrySet()) {
            if (point.getValue())
                g2d.fillOval(point.getKey().x + 5, point.getKey().y + 5, 4, 4);
        }
    }

    public void eatPoints() {
        if (pointsToEat.get(new Point(pacmanData.getPacmanCurrentLocation().x, pacmanData.getPacmanCurrentLocation().y)).equals(true)) {
            pointsToEat.replace(new Point(pacmanData.getPacmanCurrentLocation().x, pacmanData.getPacmanCurrentLocation().y), false);
            gameRunner.setPoints(gameRunner.getPoints() + 10);
            menus.getLabels().getLabelPoints().setText(String.valueOf(gameRunner.getPoints()));
        }
    }

    public void setBooleanEntityVisibility(boolean booleanEntityVisibility) {
        this.booleanEntityVisibility = booleanEntityVisibility;
    }
}
