package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusPanel extends JPanel implements ActionListener{

    JLabel label = new JLabel(GameFrame.GameFrameStatusPanelString, SwingConstants.RIGHT);

    public StatusPanel(){
        setPreferredSize(new Dimension(1280,25));
        label.setForeground(Color.green);
        label.setPreferredSize(new Dimension(1200,20));
        this.add(label);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);
    }

    //TODO Currently does nothing
    @Override
    public void actionPerformed(ActionEvent e)
    {
        label.repaint();
    }
}
