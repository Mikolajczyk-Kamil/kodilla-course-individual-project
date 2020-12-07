package com.kodilla.pacman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class MainMenu extends JComponent implements KeyListener {
    private GameSaver gameSaver = new GameSaver();
    private ChangePanelListener changePanelListener;

    public MainMenu(ChangePanelListener changePanelListener, boolean startAnimation) {
        this.changePanelListener = changePanelListener;
        this.startAnimation = startAnimation;


        changePanelListener.setKeyListener(this);

        prepareImages();
        prepareButtons();
        prepareLabels();

        if (!startAnimation) {
            stage = 3;

            pacmanLabel.setText("P A C _ M A N");

            add(pacmanLabel);
            add(pressAnyKeyLabel);
        }


        timerMain.start();
    }

    //PREPARE DATA
    private boolean settingsMenu = false;
    private boolean newOrLoadMenu = false;
    private boolean difficultyMenu = false;
    private boolean startAnimation;

    private int currentButton = 0;

    private ArrayList<JButton> mainButtonList = new ArrayList<>();
    private ArrayList<JButton> settingsButtonList = new ArrayList<>();
    private ArrayList<JButton> newGameOrLoadButtonList = new ArrayList<>();
    private ArrayList<JButton> difficultyChooseButtonList = new ArrayList<>();
    private ArrayList<JLabel> instructionList = new ArrayList<>();

    private JLabel startAnimationLabel = new JLabel("");
    private JLabel pacmanLabel = new JLabel("");
    private JLabel pressAnyKeyLabel = new JLabel("P R E S S  A N Y  K E Y  T O  S T A R T");
    private JLabel controlInformationLabel = new JLabel("CONTROL");


    private JButton playButton = new JButton("PLAY");
    private JButton settingsButton = new JButton("SETTINGS");
    private JButton exitButton = new JButton("EXIT");
    private JButton startAnimationButton = new JButton("START ANIMATION");
    private JButton backButton = new JButton("BACK");

    private JButton newGameButton = new JButton("NEW GAME");
    private JButton loadGameButton = new JButton("LOAD");

    private JButton difficultyEasyButton = new JButton("EASY");
    private JButton difficultyNormalButton = new JButton("NORMAL");
    private JButton difficultyHardButton = new JButton("HARD");
    private JButton difficultyExtremeButton = new JButton("EXTREME");

    public void prepareLabels() {
        pacmanLabel.setBounds(lettersLocation, 120, 800, 100);
        pacmanLabel.setForeground(new Color(255, 255, 255, 0));
        pacmanLabel.setFont(new Font("TimesRoman", Font.BOLD, 100));

        pressAnyKeyLabel.setBounds(lettersLocation + 230, 220, 800, 50);
        pressAnyKeyLabel.setForeground(new Color(255, 255, 255, 0));
        pressAnyKeyLabel.setFont(new Font("TimesRoman", Font.BOLD, 10));

        startAnimationLabel.setBounds(locationButtons.x + 40, locationButtons.y + 10, 800, 50);
        startAnimationLabel.setForeground(new Color(255, 255, 255));
        startAnimationLabel.setFont(new Font("Monospaced", Font.BOLD, 15));

        controlInformationLabel.setBounds(555, 310, 100, 20);
        controlInformationLabel.setForeground(new Color(200, 200, 200));
        controlInformationLabel.setFont(new Font("Monospaced", Font.BOLD, 15));

        if (startAnimation)
            startAnimationLabel.setText("ON");
        else
            startAnimationLabel.setText("OFF");
    }

    public void prepareButtons() {
        playButton.setBounds(locationButtons.x, locationButtons.y, 100, 20);
        playButton.setOpaque(false);
        playButton.setContentAreaFilled(false);
        playButton.setForeground(Color.BLACK);
        playButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        playButton.setBorderPainted(false);

        settingsButton.setBounds(locationButtons.x, locationButtons.y + 40, 100, 20);
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setForeground(Color.BLACK);
        settingsButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        settingsButton.setBorderPainted(false);

        exitButton.setBounds(locationButtons.x, locationButtons.y + 80, 100, 20);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        exitButton.setBorderPainted(false);

        startAnimationButton.setBounds(locationButtons.x - 25, locationButtons.y, 150, 20);
        startAnimationButton.setOpaque(false);
        startAnimationButton.setContentAreaFilled(false);
        startAnimationButton.setForeground(Color.decode("#3468eb"));
        startAnimationButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        startAnimationButton.setBorderPainted(true);

        backButton.setBounds(locationButtons.x, locationButtons.y + 120, 100, 20);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setForeground(Color.decode("#3468eb"));
        backButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        backButton.setBorderPainted(false);

        newGameButton.setBounds(locationButtons.x, locationButtons.y, 100, 20);
        newGameButton.setOpaque(false);
        newGameButton.setContentAreaFilled(false);
        newGameButton.setForeground(Color.decode("#3468eb"));
        newGameButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        newGameButton.setBorderPainted(false);

        loadGameButton.setBounds(locationButtons.x, locationButtons.y + 40, 100, 20);
        loadGameButton.setOpaque(false);
        loadGameButton.setContentAreaFilled(false);
        loadGameButton.setBorderPainted(false);

        if (changePanelListener.isSaveGameFileExist()){
            loadGameButton.setForeground(Color.decode("#3468eb"));
            loadGameButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
            System.out.println("!");
        } else {
            loadGameButton.setForeground(Color.gray);
            loadGameButton.setBorder(BorderFactory.createLineBorder(Color.gray));
            System.out.println("d");
        }

        difficultyEasyButton.setBounds(locationButtons.x, locationButtons.y - 20, 100, 20);
        difficultyEasyButton.setOpaque(false);
        difficultyEasyButton.setContentAreaFilled(false);
        difficultyEasyButton.setForeground(Color.decode("#3468eb"));
        difficultyEasyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        difficultyEasyButton.setBorderPainted(false);

        difficultyNormalButton.setBounds(locationButtons.x, locationButtons.y + 10, 100, 20);
        difficultyNormalButton.setOpaque(false);
        difficultyNormalButton.setContentAreaFilled(false);
        difficultyNormalButton.setForeground(Color.decode("#3468eb"));
        difficultyNormalButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        difficultyNormalButton.setBorderPainted(false);

        difficultyHardButton.setBounds(locationButtons.x, locationButtons.y + 40, 100, 20);
        difficultyHardButton.setOpaque(false);
        difficultyHardButton.setContentAreaFilled(false);
        difficultyHardButton.setForeground(Color.decode("#3468eb"));
        difficultyHardButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        difficultyHardButton.setBorderPainted(false);

        difficultyExtremeButton.setBounds(locationButtons.x, locationButtons.y + 70, 100, 20);
        difficultyExtremeButton.setOpaque(false);
        difficultyExtremeButton.setContentAreaFilled(false);
        difficultyExtremeButton.setForeground(Color.decode("#3468eb"));
        difficultyExtremeButton.setBorder(BorderFactory.createLineBorder(Color.decode("#3468eb")));
        difficultyExtremeButton.setBorderPainted(false);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newOrLoadMenu = true;

                for (JButton button : mainButtonList)
                    remove(button);

                for (JButton button : newGameOrLoadButtonList)
                    add(button);

                paintCurrentButtonFrame();
                repaint();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsMenu = true;
                currentButton = 0;

                add(startAnimationLabel);

                for (JButton button : mainButtonList)
                    remove(button);

                for (JButton button : settingsButtonList)
                    add(button);

                paintCurrentButtonFrame();
                repaint();

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        startAnimationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSaver.readSettings();

                if (gameSaver.isStartAnimation()) {
                    gameSaver.saveSettings(false);
                    gameSaver.readSettings();

                    if (!gameSaver.isStartAnimation())
                        startAnimationLabel.setText("OFF");

                } else {
                    gameSaver.saveSettings(true);
                    gameSaver.readSettings();

                    if (gameSaver.isStartAnimation())
                        startAnimationLabel.setText("ON");
                }
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficultyMenu = true;
                newOrLoadMenu = false;

                for (JButton button : newGameOrLoadButtonList)
                    remove(button);

                for (JButton button : difficultyChooseButtonList)
                    add(button);

                paintCurrentButtonFrame();
                repaint();
            }
        });

        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (changePanelListener.isSaveGameFileExist())
                    changePanelListener.loadSavegame();
            }
        });

        difficultyEasyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanelListener.setDifficulty(0);
                timerStartGameAnimation.start();
            }
        });

        difficultyNormalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanelListener.setDifficulty(1);
                timerStartGameAnimation.start();
            }
        });

        difficultyHardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanelListener.setDifficulty(2);
                timerStartGameAnimation.start();
            }
        });

        difficultyExtremeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanelListener.setDifficulty(3);
                timerStartGameAnimation.start();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsMenu = false;
                newOrLoadMenu = false;
                difficultyMenu = false;
                currentButton = 0;

                remove(startAnimationLabel);

                for (JButton button : settingsButtonList)
                    remove(button);

                for (JButton button : difficultyChooseButtonList)
                    remove(button);

                for (JButton button : newGameOrLoadButtonList)
                    remove(button);

                for (JButton button : mainButtonList)
                    add(button);

                paintCurrentButtonFrame();
                repaint();
            }
        });

        mainButtonList.add(playButton);
        mainButtonList.add(settingsButton);
        mainButtonList.add(exitButton);

        settingsButtonList.add(startAnimationButton);
        settingsButtonList.add(backButton);

        newGameOrLoadButtonList.add(newGameButton);
        newGameOrLoadButtonList.add(loadGameButton);
        newGameOrLoadButtonList.add(backButton);

        difficultyChooseButtonList.add(difficultyEasyButton);
        difficultyChooseButtonList.add(difficultyNormalButton);
        difficultyChooseButtonList.add(difficultyHardButton);
        difficultyChooseButtonList.add(difficultyExtremeButton);
        difficultyChooseButtonList.add(backButton);
    }

    public void prepareImages() {
        try {
            pacmanLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/pacmanAnimationLeft.png"));
            pacmanRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/pacmanAnimationRight.png"));

            orangeLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/ghostOrangeAnimationLeft.png"));
            orangeRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/ghostOrangeAnimationRight.png"));

            redLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/ghostRedAnimationLeft.png"));
            redRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/ghostRedAnimationRight.png"));

            blueLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/ghostBlueAnimationLeft.png"));
            blueRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/ghostBlueAnimationRight.png"));

            controlInformation = ImageIO.read(getClass().getClassLoader().getResourceAsStream("controlInfo.png"));

        } catch (IOException e) {
            System.out.println("Images error");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (stage == 0)
            g2d.drawImage(pacmanRight, counterMoving, locationPacmanImage.y, null);
        else if (stage == 1) {
            g2d.drawImage(pacmanLeft, counterMoving, locationPacmanImage.y, null);
            g2d.drawImage(orangeLeft, counterMoving + 300, locationPacmanImage.y, null);
            g2d.drawImage(redLeft, counterMoving + 400, locationPacmanImage.y, null);
            g2d.drawImage(blueLeft, counterMoving + 500, locationPacmanImage.y, null);
        } else if (stage == 2) {
            g2d.drawImage(pacmanRight, counterMoving, locationPacmanImage.y, null);
            g2d.drawImage(orangeRight, counterMoving + 300, locationPacmanImage.y, null);
            g2d.drawImage(redRight, counterMoving + 400, locationPacmanImage.y, null);
            g2d.drawImage(blueRight, counterMoving + 500, locationPacmanImage.y, null);
        }

        if (newOrLoadMenu || difficultyMenu){
            g2d.drawImage(controlInformation, 540, 190, null);
            add(controlInformationLabel);
        } else remove(controlInformationLabel);

    }

    public void paintCurrentButtonFrame() {
        if (!settingsMenu && !difficultyMenu && !newOrLoadMenu) {
            for (JButton button : mainButtonList) {
                if (mainButtonList.get(currentButton) == button) button.setBorderPainted(true);
                else button.setBorderPainted(false);
            }
        } else if (settingsMenu) {
            for (JButton button : settingsButtonList) {
                if (settingsButtonList.get(currentButton) == button) button.setBorderPainted(true);
                else button.setBorderPainted(false);
            }
        } else if (newOrLoadMenu) {
            for (JButton button : newGameOrLoadButtonList) {
                if (newGameOrLoadButtonList.get(currentButton) == button) button.setBorderPainted(true);
                else button.setBorderPainted(false);
            }
        } else if (difficultyMenu) {
            for (JButton button : difficultyChooseButtonList) {
                if (difficultyChooseButtonList.get(currentButton) == button) button.setBorderPainted(true);
                else button.setBorderPainted(false);
            }
        }
    }

    public void changeCurrentButton(KeyEvent e) {
        if (!settingsMenu && !difficultyMenu && !newOrLoadMenu) {
            if (e.getKeyCode() == KeyEvent.VK_UP && currentButton > 0) currentButton--;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton < mainButtonList.size() - 1) currentButton++;
        } else if (settingsMenu) {
            if (e.getKeyCode() == KeyEvent.VK_UP && currentButton > 0) currentButton--;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton < settingsButtonList.size() - 1)
                currentButton++;
        } else if (newOrLoadMenu) {
            if (e.getKeyCode() == KeyEvent.VK_UP && currentButton > 0) currentButton--;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton < newGameOrLoadButtonList.size() - 1)
                currentButton++;
        } else if (difficultyMenu) {
            if (e.getKeyCode() == KeyEvent.VK_UP && currentButton > 0) currentButton--;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN && currentButton < difficultyChooseButtonList.size() - 1)
                currentButton++;
        }

        paintCurrentButtonFrame();
        repaint();

    }

    public void enter() {
        if (!settingsMenu && !difficultyMenu && !newOrLoadMenu)
            mainButtonList.get(currentButton).doClick();
        else if (settingsMenu)
            settingsButtonList.get(currentButton).doClick();
        else if (newOrLoadMenu)
            newGameOrLoadButtonList.get(currentButton).doClick();
        else if (difficultyMenu)
            difficultyChooseButtonList.get(currentButton).doClick();
    }

    //START ANIMATIONS
    private BufferedImage pacmanLeft;
    private BufferedImage pacmanRight;

    private BufferedImage orangeLeft;
    private BufferedImage orangeRight;

    private BufferedImage redLeft;
    private BufferedImage redRight;

    private BufferedImage blueLeft;
    private BufferedImage blueRight;

    private BufferedImage controlInformation;

    private boolean booleanIncreaseOrReduceValue = true;

    private int counterMoving = -150;
    private int counterPressAnyKey = 0;
    private int counterPacmanLabelUp = 0;
    private int counterTimer = 0;
    private int counterTransitionAnimation = 0;
    private int counterHideLabels = 255;

    private int stage = 0;
    private int lettersLocation = 72;

    private Point locationButtons = new Point(340, 190);
    private Point locationPacmanImage = new Point(-150, 120);

    private Timer timerMain = new Timer(3, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (stage == 0) counterMoving++;
            else if (stage == 1) counterMoving -= 2;
            else if (stage == 2) {
                counterMoving += 4;

                if (counterMoving == lettersLocation) {
                    pacmanLabel.setText("P");
                    pacmanLabel.setForeground(new Color(255, 255, 255));
                } else if (counterMoving == lettersLocation + 100) pacmanLabel.setText("P A");
                else if (counterMoving == lettersLocation + 200) pacmanLabel.setText("P A C");
                else if (counterMoving == lettersLocation + 300) pacmanLabel.setText("P A C _");
                else if (counterMoving == lettersLocation + 400) pacmanLabel.setText("P A C _ M");
                else if (counterMoving == lettersLocation + 500) pacmanLabel.setText("P A C _ M A");
                else if (counterMoving == lettersLocation + 600) pacmanLabel.setText("P A C _ M A N");

            } else if (stage == 3) {

                if (booleanIncreaseOrReduceValue) counterTimer++;
                else counterTimer--;

                if (booleanIncreaseOrReduceValue && counterTimer % 5 == 0) counterPressAnyKey++;
                else if (!booleanIncreaseOrReduceValue && counterTimer % 5 == 0) counterPressAnyKey--;

                if (counterPressAnyKey == 50) booleanIncreaseOrReduceValue = true;
                else if (counterPressAnyKey == 200) booleanIncreaseOrReduceValue = false;

                pressAnyKeyLabel.setForeground(new Color(255, 255, 255, counterPressAnyKey));

                if (counterTransitionAnimation < 255 && !startAnimation) {
                    counterTransitionAnimation++;
                    pacmanLabel.setForeground(new Color(255, 255, 255, counterTransitionAnimation));
                }

            } else if (stage == 4) {
                if (counterTimer % 20 == 0 && counterTimer > 0) counterTimer -= 20;

                counterPacmanLabelUp++;

                if (counterPacmanLabelUp < 70 && counterTimer % 20 == 0) {
                    counterPacmanLabelUp++;
                    pacmanLabel.setBounds(lettersLocation, 120 - counterPacmanLabelUp, 800, 100);
                }

                if (counterPressAnyKey > 0) counterPressAnyKey--;
                else if (counterPressAnyKey == 0) remove(pressAnyKeyLabel);
                pressAnyKeyLabel.setForeground(new Color(255, 255, 255, counterPressAnyKey));

                if (counterPacmanLabelUp < 255) {
                    playButton.setForeground(new Color(52, 104, 235, counterPacmanLabelUp));
                    playButton.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 235, counterPacmanLabelUp)));

                    settingsButton.setForeground(new Color(52, 104, 235, counterPacmanLabelUp));
                    exitButton.setForeground(new Color(52, 104, 235, counterPacmanLabelUp));
                } else if (counterPacmanLabelUp == 255) {
                    stage = 5;
                    timerMain.stop();
                }

                if (!startAnimation) {
                    add(playButton);
                    add(settingsButton);
                    add(exitButton);
                }

            }


            if (counterMoving == 950 && stage == 0)
                stage = 1;
            else if (counterMoving == -700 && stage == 1) {
                stage = 2;
                add(pacmanLabel);
                add(pressAnyKeyLabel);
            } else if (counterMoving == 1300) {
                stage = 3;
                counterMoving = 1;

                add(playButton);
                add(settingsButton);
                add(exitButton);
            }

            repaint();
        }
    });

    private Timer timerStartGameAnimation = new Timer(2, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (counterHideLabels > 0) counterHideLabels--;
            if (counterHideLabels == 0) {
                timerStartGameAnimation.stop();
                changePanelListener.startGame();
            }

            pacmanLabel.setForeground(new Color(255, 255, 255, counterHideLabels));

            loadGameButton.setForeground(new Color(52, 104, 235, counterHideLabels));
            loadGameButton.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 235, counterHideLabels)));

            difficultyEasyButton.setForeground(new Color(52, 104, 235, counterHideLabels));
            difficultyEasyButton.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 235, counterHideLabels)));

            difficultyNormalButton.setForeground(new Color(52, 104, 235, counterHideLabels));
            difficultyNormalButton.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 235, counterHideLabels)));

            difficultyHardButton.setForeground(new Color(52, 104, 235, counterHideLabels));
            difficultyHardButton.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 235, counterHideLabels)));

            difficultyExtremeButton.setForeground(new Color(52, 104, 235, counterHideLabels));
            difficultyExtremeButton.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 235, counterHideLabels)));

            backButton.setForeground(new Color(52, 104, 235, counterHideLabels));
            backButton.setBorder(BorderFactory.createLineBorder(new Color(52, 104, 235, counterHideLabels)));
        }
    });


    //KEYBOARD LISTENER
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (stage == 3) {
            stage = 4;
            counterTimer = 1000;
            changeCurrentButton(e);
        } else if (stage == 5 && counterPacmanLabelUp > 250) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                changeCurrentButton(e);
            else if (e.getKeyCode() == KeyEvent.VK_ENTER) enter();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
