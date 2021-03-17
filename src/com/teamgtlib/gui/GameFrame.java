package com.teamgtlib.gui;

import com.teamgtlib.Park;
import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Beadandó");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));

        StatusPanel statusPanel = new StatusPanel();
        getContentPane().add(statusPanel, BorderLayout.NORTH);

        GamePanel gamepanel = new GamePanel();
        getContentPane().add(gamepanel, BorderLayout.WEST);

        // setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
