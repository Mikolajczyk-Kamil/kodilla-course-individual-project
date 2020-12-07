package com.kodilla.pacman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class MainFrame extends JFrame {
    private GameSaver gameSaver = new GameSaver();

    private File file = new File("settings.txt");
    private boolean startAnimation;


    public MainFrame() {
        super("PAC-MAN");

        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("animations_images/ghostBlueAnimationLeft.png"));
            this.setIconImage(img);
        } catch (Exception e) {
            System.out.println(e);
        }

        gameSaver.readSettings();
        startAnimation = gameSaver.isStartAnimation();

        ChangePanelListener changePanelListener = new ChangePanelListener(this);

        MainMenu mainMenu = new MainMenu(changePanelListener, startAnimation);
        addKeyListener(mainMenu);
        add(mainMenu);

        pack();
        setResizable(false);
        setSize(new Dimension(836, 390));
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(600, 300);
        setVisible(true);

    }
}
