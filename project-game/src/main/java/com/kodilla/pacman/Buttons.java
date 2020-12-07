package com.kodilla.pacman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Buttons {
    private Menus menus;
    private GameRunner gameRunner;
    private ChangePanelListener changePanelListener;
    private Labels labels;

    private ArrayList<JButton> pauseButtonsList = new ArrayList<>();
    private ArrayList<JButton> yesOrNoButtonList = new ArrayList<>();
    private ArrayList<JButton> winButtonsList = new ArrayList<>();
    private ArrayList<JButton> gameOverButtonsList = new ArrayList<>();

    private JButton nextLevelButton = new JButton("NEXT LEVEL");
    private JButton resumeButton = new JButton("RESUME");
    private JButton saveGameButton = new JButton("SAVE AND EXIT");
    private JButton restartButton = new JButton("RESTART");
    private JButton mainMenuButton = new JButton("MAIN MENU");
    private JButton exitButton = new JButton("EXIT");

    private JButton yesButton = new JButton("YES");
    private JButton noButton = new JButton("NO");

    private final String GAME_BUTTONS_FONT = "Monospaced";

    public Buttons(Menus menus, GameRunner gameRunner, ChangePanelListener changePanelListener, Labels labels){
        this.menus = menus;
        this.gameRunner = gameRunner;
        this.changePanelListener = changePanelListener;
        this.labels = labels;
    }

    public void prepareButtonsForPause() {
        resumeButton.setBounds(350, 50, 100, 20);
        resumeButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        resumeButton.setOpaque(false);
        resumeButton.setContentAreaFilled(false);
        resumeButton.setForeground(Color.decode("#3468eb"));
        resumeButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));

        saveGameButton.setBounds(320, 90, 160, 20);
        saveGameButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        saveGameButton.setOpaque(false);
        saveGameButton.setContentAreaFilled(false);
        saveGameButton.setForeground(Color.decode("#3468eb"));
        saveGameButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        saveGameButton.setBorderPainted(false);

        restartButton.setBounds(340, 130, 120, 20);
        restartButton.setForeground(Color.decode("#3468eb"));
        restartButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        restartButton.setOpaque(false);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        restartButton.setBorderPainted(false);

        mainMenuButton.setBounds(340, 170, 120, 20);
        mainMenuButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        mainMenuButton.setOpaque(false);
        mainMenuButton.setContentAreaFilled(false);
        mainMenuButton.setForeground(Color.decode("#3468eb"));
        mainMenuButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        mainMenuButton.setBorderPainted(false);

        exitButton.setBounds(350, 210, 100, 20);
        exitButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setForeground(Color.decode("#3468eb"));
        exitButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        exitButton.setBorderPainted(false);

        yesButton.setBounds(350, 140, 100, 20);
        yesButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        yesButton.setOpaque(false);
        yesButton.setContentAreaFilled(false);
        yesButton.setForeground(Color.decode("#3468eb"));
        yesButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        yesButton.setBorderPainted(false);

        noButton.setBounds(350, 180, 100, 20);
        noButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        noButton.setOpaque(false);
        noButton.setContentAreaFilled(false);
        noButton.setForeground(Color.decode("#3468eb"));
        noButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        noButton.setBorderPainted(false);

        resumeButton.addActionListener((a) -> menus.pause());

        saveGameButton.addActionListener((a) -> {
            menus.setBooleanMenuSaveGame(true);
            menus.yesOrNoMenu();
        });

        restartButton.addActionListener((a) -> {
            if (menus.isBooleanMenuGameOver())
                changePanelListener.startGame();
            else if (menus.isBooleanMenuPause() || menus.isBooleanWin()) {
                menus.setBooleanRestartGame(true);
                menus.yesOrNoMenu();
            }
        });

        mainMenuButton.addActionListener((a) -> {
            if (menus.isBooleanMenuGameOver()) {
                gameRunner.getFrame().removeKeyListener(gameRunner.getKeyListener());
                changePanelListener.mainMenu();
            } else if (menus.isBooleanMenuPause() || menus.isBooleanWin()) {
                menus.setBooleanExitToMainMenu(true);
                menus.yesOrNoMenu();
            }
        });

        exitButton.addActionListener((a) -> {
            menus.setCurrentButton(0);
            menus.setBooleanMenuExit(true);

            menus.yesOrNoMenu();
        });

        yesButton.addActionListener((a) -> {
            if (menus.isBooleanMenuExit())
                System.exit(0);
            else if (menus.isBooleanRestartGame())
                changePanelListener.startGame();
            else if (menus.isBooleanExitToMainMenu()) {
                gameRunner.getFrame().removeKeyListener(gameRunner.getKeyListener());
                changePanelListener.mainMenu();
            } else if (menus.isBooleanMenuSaveGame()) {
                GameSaver gameSaver = new GameSaver();
                gameSaver.setData(gameRunner.getPacmanData().getPacmanLife(),
                        gameRunner.getPoints(),
                        gameRunner.getDifficulty(),
                        gameRunner.getCurrentGameLevel(),
                        gameRunner.getPacmanData().getPacmanCurrentDirection(),
                        gameRunner.getGhostsData().getGhostOrangeCurrentDirection(),
                        gameRunner.getGhostsData().getGhostBlueCurrentDirection(),
                        gameRunner.getGhostsData().getGhostRedCurrentDirection(),
                        gameRunner.getPacmanData().getPacmanCurrentLocation(),
                        gameRunner.getGhostsData().getGhostOrangeCurrentLocation(),
                        gameRunner.getGhostsData().getGhostBlueCurrentLocation(),
                        gameRunner.getGhostsData().getGhostRedCurrentLocation(),
                        gameRunner.getPointsToEat());

                gameSaver.saveGameData();
            }

        });

        noButton.addActionListener((a) -> {
            menus.setBooleanMenuYesOrNo(false);
            menus.setBooleanRestartGame(false);
            menus.setBooleanExitToMainMenu(false);
            menus.setBooleanMenuExit(false);
            menus.setBooleanMenuSaveGame(false);
            menus.setCurrentButton(0);

            gameRunner.remove(labels.getLabelInfo());
            gameRunner.remove(yesButton);
            gameRunner.remove(noButton);

            if (!menus.isBooleanWin() && !menus.isBooleanMenuGameOver()) {
                for (JButton button : pauseButtonsList)
                    gameRunner.add(button);
            } else if (menus.isBooleanWin()) {
                gameRunner.add(labels.getLabelWin());

                for (JButton button : winButtonsList)
                    gameRunner.add(button);

            } else if (menus.isBooleanMenuGameOver()) {
                gameRunner.add(labels.getLabelGameOver());

                for (JButton button : gameOverButtonsList)
                    gameRunner.add(button);

            }
        });

        pauseButtonsList.add(resumeButton);
        pauseButtonsList.add(saveGameButton);
        pauseButtonsList.add(restartButton);
        pauseButtonsList.add(mainMenuButton);
        pauseButtonsList.add(exitButton);

        yesOrNoButtonList.add(yesButton);
        yesOrNoButtonList.add(noButton);

    }

    public void prepareButtonsForGameWin() {
        nextLevelButton.setBounds(330, 140, 140, 20);
        nextLevelButton.setFont(new Font(GAME_BUTTONS_FONT, Font.PLAIN, 18));
        nextLevelButton.setOpaque(false);
        nextLevelButton.setContentAreaFilled(false);
        nextLevelButton.setBorderPainted(true);

        mainMenuButton.setForeground(new Color(235, 213, 52));

        mainMenuButton.setBorder(BorderFactory.createLineBorder(new Color(235, 213, 52)));
        if (gameRunner.getCurrentGameLevel() == 1) {
            mainMenuButton.setBounds(330, 180, 140, 20);
            exitButton.setBounds(350, 220, 100, 20);
        } else if (gameRunner.getCurrentGameLevel() == 2) {
            mainMenuButton.setBounds(330, 140, 140, 20);
            exitButton.setBounds(350, 180, 100, 20);
        }

        nextLevelButton.addActionListener((a) -> {
            gameRunner.setHideMap(true);
            gameRunner.getTimers().startAnimationHideMap();
        });

        yesButton.setBorder(BorderFactory.createLineBorder(new Color(235, 213, 52)));
        yesButton.setForeground(new Color(235, 213, 52));
        yesButton.setBorderPainted(true);

        noButton.setBorder(BorderFactory.createLineBorder(new Color(235, 213, 52)));
        noButton.setForeground(new Color(235, 213, 52));

        if (gameRunner.getCurrentGameLevel() == 1) {
            winButtonsList.add(nextLevelButton);
            gameRunner.add(nextLevelButton);
        }

        winButtonsList.add(mainMenuButton);
        winButtonsList.add(exitButton);

        gameRunner.add(labels.getLabelWin());
        gameRunner.add(mainMenuButton);
        gameRunner.add(exitButton);
    }

    public void prepareButtonsForGameOver() {
        restartButton.setBorder(BorderFactory.createLineBorder(new Color(230, 0, 0, 0)));
        restartButton.setBorderPainted(true);

        mainMenuButton.setBorder(BorderFactory.createLineBorder(menus.getColorGameOverText()));

        exitButton.setBounds(350, 220, 100, 20);
        exitButton.setForeground(new Color(0, 0, 0, 0));
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(230, 0, 0)));
        exitButton.setBorderPainted(false);

        yesButton.setBorder(BorderFactory.createLineBorder(new Color(230, 0, 0)));
        yesButton.setForeground(new Color(230, 0, 0));
        yesButton.setBorderPainted(true);

        noButton.setBorder(BorderFactory.createLineBorder(new Color(230, 0, 0)));
        noButton.setForeground(new Color(230, 0, 0));

        gameOverButtonsList.add(restartButton);
        gameOverButtonsList.add(mainMenuButton);
        gameOverButtonsList.add(exitButton);

        gameRunner.add(restartButton);
        gameRunner.add(mainMenuButton);
        gameRunner.add(exitButton);
    }

    public ArrayList<JButton> getPauseButtonsList() {
        return pauseButtonsList;
    }

    public ArrayList<JButton> getYesOrNoButtonList() {
        return yesOrNoButtonList;
    }

    public ArrayList<JButton> getWinButtonsList() {
        return winButtonsList;
    }

    public ArrayList<JButton> getGameOverButtonsList() {
        return gameOverButtonsList;
    }

    public JButton getNextLevelButton() {
        return nextLevelButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getYesButton() {
        return yesButton;
    }

    public JButton getNoButton() {
        return noButton;
    }
}
