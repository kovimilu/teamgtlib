package com.teamgtlib.gui;

import com.teamgtlib.Buildings.Buildable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GameFrame extends JFrame {

    static public boolean GameFrameButtonIsPressedOnce = false;
    static public String GameFrameCurrentButtonItemImageName = "";
    static public String GameFrameStatusPanelString = "";
    static public StatusPanel GameFrameStatusPanel = null;

    static public PlayAreaPanel bg;

    public GameFrame() throws IOException {
        setTitle("Beadandó");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));

        ImageIcon logoImage = new ImageIcon("res/_logo.png");
        this.setIconImage(logoImage.getImage());

        bg = new PlayAreaPanel();
        this.getContentPane().add(bg);

        StatusPanel statusPanel = new StatusPanel();
        this.getContentPane().add(statusPanel, BorderLayout.NORTH);
        GameFrameStatusPanel = statusPanel;

        UIPanel gamepanel = new UIPanel();
        this.getContentPane().add(gamepanel, BorderLayout.WEST);

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
