package com.teamgtlib.gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Beadandó");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        // setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
