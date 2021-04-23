package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class GameFrame extends JFrame {

    static public SelectionType SelectionState = SelectionType.NONE;
    static public String GameFrameCurrentButtonItemImageName = "";
    static public String GameFrameStatusPanelString = "";
    static public StatusPanel GameFrameStatusPanel = null;

    static public PlayAreaPanel bg;

    public GameFrame() throws IOException {
        setTitle("Beadandó");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                final int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the game?", "Exit confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) System.exit(0);
            }
        });

    }
}
