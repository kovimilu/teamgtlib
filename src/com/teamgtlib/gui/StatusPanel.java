package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel{

    JLabel label = new JLabel( "$"+ String.valueOf(GameFrame.bg.park.player.getBudget()), SwingConstants.RIGHT);

    public StatusPanel(){
        setPreferredSize(new Dimension(1280,20));
        label.setForeground(Color.green);
        label.setPreferredSize(new Dimension(1200,15));
        this.add(label);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);
    }
}