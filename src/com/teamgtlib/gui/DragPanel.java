package com.teamgtlib.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DragPanel extends JPanel {

    ImageIcon dragAndDropImage = new ImageIcon("res/Bin.png");
    final int WIDTH = 50;
    final int HEIGHT = 50;
    Point imageCorner;
    Point prevPt;

    DragPanel() {
        setPreferredSize(new Dimension(50,50));
        imageCorner = new Point(0, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dragAndDropImage.paintIcon(this, g, (int) imageCorner.getX(), (int) imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {

            Point currentPt = e.getPoint();

            imageCorner.translate(

                    (int) (currentPt.getX() - prevPt.getX()),
                    (int) (currentPt.getY() - prevPt.getY())
            );
            prevPt = currentPt;
            repaint();
        }
    }
}