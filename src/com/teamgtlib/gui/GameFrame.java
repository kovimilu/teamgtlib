package com.teamgtlib.gui;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {

    static public boolean GameFrameIsPressedOnce = false;

    public GameFrame() {
        setTitle("Beadandó");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));

        ImageIcon logoImage = new ImageIcon("res/_logo.png");
        this.setIconImage(logoImage.getImage());


        PlayAreaPanel bg = new PlayAreaPanel();
        this.getContentPane().add(bg);
        //this.getContentPane().setBackground(new Color(0x0BFA10));
        //DragPanel dragPanel = new DragPanel();
        //this.getContentPane().add(dragPanel);


        StatusPanel statusPanel = new StatusPanel();
        this.getContentPane().add(statusPanel, BorderLayout.NORTH);

        UIPanel gamepanel = new UIPanel();
        this.getContentPane().add(gamepanel, BorderLayout.WEST);

        // setResizable(false);
        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
