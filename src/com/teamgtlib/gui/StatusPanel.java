package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;

/**
 * Class where the JLabels are created.
 */
public class StatusPanel extends JPanel{

    JLabel clickLabel = new JLabel( "",SwingConstants.LEFT);
    JLabel exceptionLabel = new JLabel( "",SwingConstants.RIGHT);
    JLabel countLabel = new JLabel( "Workers: "+ Park.player.getWorkerCount() + " | " + "Visitors: "
            + Park.player.getVisitorCount(),SwingConstants.CENTER);
    JLabel budgetLabel = new JLabel( "$"+ GameFrame.bg.park.player.getBudget(), SwingConstants.RIGHT);

    public StatusPanel(){
        setPreferredSize(new Dimension(1280,20));

        clickLabel.setForeground(Color.green);
        clickLabel.setPreferredSize(new Dimension(300,10));

        budgetLabel.setForeground(Color.green);
        budgetLabel.setPreferredSize(new Dimension(300,10));

        exceptionLabel.setForeground(Color.red);
        exceptionLabel.setPreferredSize(new Dimension(300,10));

        countLabel.setForeground(Color.green);
        countLabel.setPreferredSize(new Dimension(300,10));

        this.add(clickLabel);
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