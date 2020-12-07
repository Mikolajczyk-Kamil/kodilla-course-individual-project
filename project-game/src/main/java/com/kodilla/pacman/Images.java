package com.kodilla.pacman;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Images {
    private BufferedImage imagePacmanUp;
    private BufferedImage imagePacmanDown;
    private BufferedImage imagePacmanLeft;
    private BufferedImage imagePacmanRight;

    private BufferedImage imageGhostOrangeRight;
    private BufferedImage imageGhostOrangeLeft;

    private BufferedImage imageGhostBlueRight;
    private BufferedImage imageGhostBlueLeft;


    private BufferedImage imageGhostRedRight;
    private BufferedImage imageGhostRedLeft;


    private BufferedImage imageHeartRed;
    private BufferedImage imageHeartGrey;

    public void prepareImages(int difficulty) {
        try {
            imagePacmanLeft = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/pacmanLeft.png")));
            imagePacmanRight = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/pacmanRight.png")));
            imagePacmanUp = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/pacmanUp.png")));
            imagePacmanDown = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/pacmanDown.png")));

            imageHeartRed = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/heartRed.png")));
            imageHeartGrey = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/heartGrey.png")));

            imageGhostOrangeRight = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/ghostOrangeRight.png")));
            imageGhostOrangeLeft = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/ghostOrangeLeft.png")));

            imageGhostBlueRight = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/ghostBlueRight.png")));
            imageGhostBlueLeft = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/ghostBlueLeft.png")));

            if (difficulty == 2 || difficulty == 3) {
                imageGhostRedRight = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/ghostRedRight.png")));
                imageGhostRedLeft = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("game_images/ghostRedLeft.png")));
            }


        } catch (IOException e) {
            System.err.println("Error while reading image");
            e.printStackTrace();
        }
    }

    public BufferedImage getImagePacmanUp() {
        return imagePacmanUp;
    }

    public BufferedImage getImagePacmanDown() {
        return imagePacmanDown;
    }

    public BufferedImage getImagePacmanLeft() {
        return imagePacmanLeft;
    }

    public BufferedImage getImagePacmanRight() {
        return imagePacmanRight;
    }

    public BufferedImage getImageGhostOrangeRight() {
        return imageGhostOrangeRight;
    }

    public BufferedImage getImageGhostOrangeLeft() {
        return imageGhostOrangeLeft;
    }

    public BufferedImage getImageGhostBlueRight() {
        return imageGhostBlueRight;
    }

    public BufferedImage getImageGhostBlueLeft() {
        return imageGhostBlueLeft;
    }

    public BufferedImage getImageGhostRedRight() {
        return imageGhostRedRight;
    }

    public BufferedImage getImageGhostRedLeft() {
        return imageGhostRedLeft;
    }

    public BufferedImage getImageHeartRed() {
        return imageHeartRed;
    }

    public BufferedImage getImageHeartGrey() {
        return imageHeartGrey;
    }
}
