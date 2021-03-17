package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    public StatusPanel(){
        setPreferredSize(new Dimension(1280,25));
        JLabel label = new JLabel("PLACE HOLDER", SwingConstants.RIGHT);
        label.setPreferredSize(new Dimension(1200,20));
        this.add(label);

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);
    }
}
