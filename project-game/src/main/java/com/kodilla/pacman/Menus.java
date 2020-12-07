package com.kodilla.pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Menus {
    private GameRunner gameRunner;
    private Buttons buttons;
    private Labels labels;

    private boolean booleanWin = false;
    private boolean booleanMenuGameOver = false;
    private boolean booleanMenuSaveGame = false;
    private boolean booleanMenuExit = false;
    private boolean booleanMenuPause = false;
    private boolean booleanRestartGame = false;
    private boolean booleanExitToMainMenu = false;
    private boolean booleanMenuYesOrNo = false;

    private Color colorWinText;
    private Color colorGameOverText;

    private int currentButton = 0;

    public Menus(GameRunner gameRunner, ChangePanelListener changePanelListener) {
        this.gameRunner = gameRunner;
        this.labels = new Labels(this, gameRunner);
        this.buttons = new Buttons(this, gameRunner, changePanelListener, labels);
    }

    public Graphics2D drawPauseMenu(Graphics2D g2d) {
        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fillRect(0, 0, 836, 390);

        g2d.setColor(Color.decode("#3468eb"));
        g2d.fillRoundRect(299, 39, 202, 202, 10, 10);

        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRoundRect(300, 40, 200, 200, 10, 10);

        return g2d;
    }

    public Graphics2D drawWinMenu(Graphics2D g2d) {
        if (!gameRunner.isHideMap())
            colorWinText = new Color(235, 213, 52, gameRunner.getTimers().getCounterTransitionAnimation());

        labels.getLabelPoints().setForeground(colorWinText);

        labels.getLabelWin().setForeground(colorWinText);
        labels.getLabelWin().setBounds(220, gameRunner.getTimers().getCounterTextHigher(), 800, 200);

        if (!gameRunner.isHideMap())
            colorWinText = new Color(235, 213, 52, gameRunner.getTimers().getCounterTransitionAnimation2());

        buttons.getNextLevelButton().setBorder(BorderFactory.createLineBorder(colorWinText));
        buttons.getNextLevelButton().setForeground(colorWinText);

        buttons.getMainMenuButton().setForeground(colorWinText);
        buttons.getMainMenuButton().setBorder(BorderFactory.createLineBorder(colorWinText));

        buttons.getExitButton().setForeground(colorWinText);
        buttons.getExitButton().setBorder(BorderFactory.createLineBorder(colorWinText));


        g2d.setColor(new Color(0, 0, 0, 190));

        if (gameRunner.getTimers().getCounterTransitionAnimation() < 190)
            g2d.setColor(new Color(0, 0, 0, gameRunner.getTimers().getCounterTransitionAnimation()));

        g2d.fillRect(0, 0, 836, 320);

        return g2d;

    }

    public Graphics2D drawGameOverMenu(Graphics2D g2d) {
        colorGameOverText = new Color(230, 0, 0, gameRunner.getTimers().getCounterTransitionAnimation());

        labels.getLabelGameOver().setForeground(colorGameOverText);
        labels.getLabelGameOver().setBounds(125, gameRunner.getTimers().getCounterTextHigher(), 800, 200);

        colorGameOverText = new Color(230, 0, 0, gameRunner.getTimers().getCounterTransitionAnimation2());

        buttons.getRestartButton().setBorder(BorderFactory.createLineBorder(colorGameOverText));
        buttons.getRestartButton().setForeground(colorGameOverText);

        buttons.getMainMenuButton().setForeground(colorGameOverText);

        buttons.getExitButton().setForeground(colorGameOverText);


        g2d.setColor(new Color(0, 0, 0, 190));

        if (gameRunner.getTimers().getCounterTransitionAnimation() < 190)
            g2d.setColor(new Color(0, 0, 0, gameRunner.getTimers().getCounterTransitionAnimation()));

        g2d.fillRect(0, 0, 836, 390);

        return g2d;
    }


    public void pause() {
        currentButton = 0;
        System.out.println(currentButton);

        booleanMenuPause = !booleanMenuPause;

        if (booleanMenuPause) {
            gameRunner.getTimers().stopMainGameTimer();

            for (JButton button : buttons.getPauseButtonsList()) {
                gameRunner.add(button);
            }

            gameRunner.repaint();
        } else {
            for (JButton button : buttons.getPauseButtonsList()) {
                gameRunner.remove(button);
            }

            gameRunner.getFrame().requestFocusInWindow();
            gameRunner.getTimers().startMainGameTimer();
        }
    }

    public void yesOrNoMenu() {
        booleanMenuYesOrNo = true;
        currentButton = 0;

        System.out.println(booleanExitToMainMenu);

        if (booleanMenuPause) {
            for (JButton button : buttons.getPauseButtonsList())
                gameRunner.remove(button);
        } else if (booleanWin) {
            gameRunner.remove(labels.getLabelWin());

            for (JButton button : buttons.getWinButtonsList())
                gameRunner.remove(button);
        } else if (booleanMenuGameOver) {
            gameRunner.remove(labels.getLabelGameOver());

            for (JButton button : buttons.getGameOverButtonsList())
                gameRunner.remove(button);
        }

        gameRunner.add(labels.getLabelInfo());
        gameRunner.add(buttons.getYesButton());
        gameRunner.add(buttons.getNoButton());

        gameRunner.repaint();
    }

    public void enter() {
        if (booleanMenuPause && !booleanMenuYesOrNo) {
            System.out.println("Pause buttons");
            buttons.getPauseButtonsList().get(currentButton).doClick();
        } else if (booleanWin && !booleanMenuYesOrNo) {
            System.out.println("Win buttons");
            buttons.getWinButtonsList().get(currentButton).doClick();
        } else if (booleanMenuGameOver && !booleanMenuYesOrNo && !booleanRestartGame) {
            System.out.println("GameOver buttons");
            buttons.getGameOverButtonsList().get(currentButton).doClick();
        } else if (booleanMenuYesOrNo || booleanRestartGame) {
            System.out.println("YesOrNo buttons");
            buttons.getYesOrNoButtonList().get(currentButton).doClick();
        }
    }


    public void changeCurrentButton(KeyEvent e) {
        if (booleanMenuPause) {
            if (!booleanMenuYesOrNo) {
                if (e.getKeyCode() == KeyEvent.VK_UP && currentButton != 0)
                    currentButton--;
                else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton != buttons.getPauseButtonsList().size() - 1)
                    currentButton++;

                for (JButton button : buttons.getPauseButtonsList()) {
                    button.setBorderPainted(buttons.getPauseButtonsList().get(currentButton) == button);
                }
            } else {
                currentButton = 0;

                if (e.getKeyCode() == KeyEvent.VK_UP && currentButton != 0)
                    currentButton--;
                else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton != 1)
                    currentButton++;

                for (JButton button : buttons.getYesOrNoButtonList()) {
                    button.setBorderPainted(buttons.getYesOrNoButtonList().get(currentButton) == button);
                }
            }
        } else if (booleanWin || booleanMenuGameOver) {
            if (!booleanMenuYesOrNo) {
                if (e.getKeyCode() == KeyEvent.VK_UP && currentButton != 0)
                    currentButton--;
                else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton < buttons.getWinButtonsList().size() - 1 && booleanWin ||
                        e.getKeyCode() == KeyEvent.VK_DOWN && currentButton < buttons.getGameOverButtonsList().size() - 1 && booleanMenuGameOver)
                    currentButton++;

                paintCurrentButtonFrame();

            } else {
                if (e.getKeyCode() == KeyEvent.VK_UP && currentButton != 0)
                    currentButton--;
                else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton != 1)
                    currentButton++;

                paintCurrentButtonFrame();
            }
        }

        gameRunner.repaint();
        System.out.println(currentButton);
    }

    public void paintCurrentButtonFrame() {
        if (booleanWin && !booleanMenuYesOrNo) {
            for (JButton button : buttons.getWinButtonsList()) {
                button.setBorderPainted(buttons.getWinButtonsList().get(currentButton) == button);
            }
        } else if (booleanMenuGameOver && !booleanMenuYesOrNo) {
            for (JButton button : buttons.getGameOverButtonsList()) {
                button.setBorderPainted(buttons.getGameOverButtonsList().get(currentButton) == button);
            }
        } else if (booleanWin && booleanMenuYesOrNo || booleanMenuGameOver && booleanMenuYesOrNo) {
            for (JButton button : buttons.getYesOrNoButtonList()) {
                button.setBorderPainted(buttons.getYesOrNoButtonList().get(currentButton) == button);
            }
        }
    }


    public void setCurrentButton(int currentButton) {
        this.currentButton = currentButton;
    }

    public boolean isBooleanWin() {
        return booleanWin;
    }

    public void setBooleanWin(boolean booleanWin) {
        this.booleanWin = booleanWin;
    }

    public boolean isBooleanMenuGameOver() {
        return booleanMenuGameOver;
    }

    public void setBooleanMenuGameOver(boolean booleanMenuGameOver) {
        this.booleanMenuGameOver = booleanMenuGameOver;
    }

    public boolean isBooleanMenuSaveGame() {
        return booleanMenuSaveGame;
    }

    public void setBooleanMenuSaveGame(boolean booleanMenuSaveGame) {
        this.booleanMenuSaveGame = booleanMenuSaveGame;
    }

    public boolean isBooleanMenuExit() {
        return booleanMenuExit;
    }

    public void setBooleanMenuExit(boolean booleanMenuExit) {
        this.booleanMenuExit = booleanMenuExit;
    }

    public boolean isBooleanMenuPause() {
        return booleanMenuPause;
    }

    public void setBooleanMenuPause(boolean booleanMenuPause) {
        this.booleanMenuPause = booleanMenuPause;
    }

    public boolean isBooleanRestartGame() {
        return booleanRestartGame;
    }

    public void setBooleanRestartGame(boolean booleanRestartGame) {
        this.booleanRestartGame = booleanRestartGame;
    }

    public boolean isBooleanExitToMainMenu() {
        return booleanExitToMainMenu;
    }

    public void setBooleanExitToMainMenu(boolean booleanExitToMainMenu) {
        this.booleanExitToMainMenu = booleanExitToMainMenu;
    }

    public boolean isBooleanMenuYesOrNo() {
        return booleanMenuYesOrNo;
    }

    public void setBooleanMenuYesOrNo(boolean booleanMenuYesOrNo) {
        this.booleanMenuYesOrNo = booleanMenuYesOrNo;
    }

    public int getCurrentButton() {
        return currentButton;
    }

    public Color getColorWinText() {
        return colorWinText;
    }

    public void setColorWinText(Color colorWinText) {
        this.colorWinText = colorWinText;
    }

    public Color getColorGameOverText() {
        return colorGameOverText;
    }

    public void setColorGameOverText(Color colorGameOverText) {
        this.colorGameOverText = colorGameOverText;
    }

    public Labels getLabels() {
        return labels;
    }

    public Buttons getButtons() {
        return buttons;
    }
}
