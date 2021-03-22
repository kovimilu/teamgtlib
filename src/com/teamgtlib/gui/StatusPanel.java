package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel{

    JLabel exceptionLabel = new JLabel( "",SwingConstants.RIGHT);
    JLabel countLabel = new JLabel( "guests: ..." + "visitors: ....",SwingConstants.CENTER);
    JLabel budgetLabel = new JLabel( "$"+ String.valueOf(GameFrame.bg.park.player.getBudget()), SwingConstants.RIGHT);

    public StatusPanel(){
        setPreferredSize(new Dimension(1280,20));
        budgetLabel.setForeground(Color.green);
        budgetLabel.setPreferredSize(new Dimension(200,15));

        exceptionLabel.setForeground(Color.red);
        exceptionLabel.setPreferredSize(new Dimension(370,15));

        countLabel.setForeground(Color.green);
        countLabel.setPreferredSize(new Dimension(630,15));

        this.add(exceptionLabel);
        this.add(countLabel);
        this.add(budgetLabel);
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);

    }
}