package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayAreaPanel extends JPanel {

    ImageIcon dragAndDropImage = new ImageIcon("res/Ride.png");
    final int WIDTH = 100;
    final int HEIGHT = 100;
    Boolean backGroundDrawn = true;
    Point prevPt;

    public PlayAreaPanel(){
        setPreferredSize(new Dimension(1280,720));

        PlayAreaPanel.ClickListener clickListener = new PlayAreaPanel.ClickListener();
        this.addMouseListener(clickListener);
    }



    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(backGroundDrawn) {
            g.drawImage(Park.image, 0, 0, 1280, 720, null);
        }
        if(GameFrame.GameFrameIsPressedOnce) {
            dragAndDropImage.paintIcon(this, g, (int) prevPt.getX(), (int) prevPt.getY());
            GameFrame.GameFrameIsPressedOnce = false;
        }

    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
            if(GameFrame.GameFrameIsPressedOnce) {
                repaint((int)prevPt.getX(), (int)prevPt.getY(), WIDTH, HEIGHT);
            }
        }
    }

}