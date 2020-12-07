package com.kodilla.pacman;

import javax.swing.*;
import java.awt.*;

public class Labels {
    private Menus menus;
    private GameRunner gameRunner;

    private final String GAME_FONT = "Monospaced";

    private JLabel labelPoints = new JLabel("00");
    private JLabel labelInfo = new JLabel("ARE YOU SURE?");
    private JLabel labelWin = new JLabel("WINNER");
    private JLabel labelGameOver = new JLabel("GAME OVER");

    public Labels(Menus menus, GameRunner gameRunner){
        this.menus = menus;
        this.gameRunner = gameRunner;
    }

    public void prepareLabels() {
        labelPoints.setForeground(Color.white);
        labelPoints.setBounds(30, 320, 100, 15);
        labelPoints.setFont(new Font(GAME_FONT, Font.BOLD, 15));

        if (!menus.isBooleanWin()) {
            labelInfo.setForeground(Color.decode("#3468eb"));
        } else {
            labelInfo.setForeground(new Color(235, 213, 52));
        }

        labelInfo.setFont(new Font(GAME_FONT, Font.BOLD, 18));
        labelInfo.setBounds(330, 80, 200, 50);

        if (menus.isBooleanMenuGameOver()) {
            labelGameOver.setForeground(new Color(230, 27, 27));
            labelGameOver.setFont(new Font(GAME_FONT, Font.BOLD, 100));
            labelGameOver.setBounds(60, 40, 800, 200);

            labelInfo.setForeground(new Color(230, 0, 0));
            labelInfo.setBounds(330, 80, 200, 50);

            gameRunner.add(labelGameOver);
        }

        labelWin.setForeground(new Color(255, 255, 255, 0));
        labelWin.setBounds(220, 40, 800, 200);
        labelWin.setFont(new Font(GAME_FONT, Font.BOLD, 100));

        gameRunner.add(labelPoints);
    }

    public JLabel getLabelPoints() {
        return labelPoints;
    }

    public void setLabelPoints(JLabel labelPoints) {
        this.labelPoints = labelPoints;
    }

    public JLabel getLabelInfo() {
        return labelInfo;
    }

    public void setLabelInfo(JLabel labelInfo) {
        this.labelInfo = labelInfo;
    }

    public JLabel getLabelWin() {
        return labelWin;
    }

    public void setLabelWin(JLabel labelWin) {
        this.labelWin = labelWin;
    }

    public JLabel getLabelGameOver() {
        return labelGameOver;
    }

    public void setLabelGameOver(JLabel labelGameOver) {
        this.labelGameOver = labelGameOver;
    }


}
