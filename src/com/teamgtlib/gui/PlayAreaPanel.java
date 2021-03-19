package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Locale;

public class PlayAreaPanel extends JPanel {

    ImageIcon dragAndDropImage = new ImageIcon("res/Ride.png");
    final int WIDTH = 100;
    final int HEIGHT = 100;
    Boolean backGroundDrawn = true;
    Point prevPt;

    Park park = new Park();

    public PlayAreaPanel() throws IOException {
        setPreferredSize(new Dimension(1280,720));

        PlayAreaPanel.ClickListener clickListener = new PlayAreaPanel.ClickListener();
        this.addMouseListener(clickListener);

        park.draw();// For now, this method load the background image.
    }

    /**
     * This method Loads in the image selected by the UI Button last presses. <br>
     * Pressing before placing the img doesnt work yet.
     * //Also does some string formatting.//
     */
    private void imageSelector()
    {
        String filename = GameFrame.GameFrameCurrentButtonItemImageName.toLowerCase();
        filename = filename.substring(0, 1).toUpperCase() + filename.substring(1);
        String str = "res/" + filename + ".png";
        //System.out.println(str);
        dragAndDropImage = new ImageIcon(str);
    }

    private void doAllThingForNow()
    {
        int placeholder = 10;
        park.player.updateBudget(-placeholder);
        System.out.println(park.player.getBudget());
    }

    private void refreshLabelText()
    {
        GameFrame.GameFrameStatusPanelString = "$" + park.player.getBudget();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(backGroundDrawn) {
            g.drawImage(Park.image, 0, 0, 1280, 720, null);
        }
        if(GameFrame.GameFrameButtonIsPressedOnce) {
            imageSelector();
            dragAndDropImage.paintIcon(this, g, (int) prevPt.getX(), (int) prevPt.getY());
            doAllThingForNow();
            GameFrame.GameFrameButtonIsPressedOnce = false;
        }
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
            if(GameFrame.GameFrameButtonIsPressedOnce) {
                refreshLabelText();
                repaint((int)prevPt.getX(), (int)prevPt.getY(), WIDTH, HEIGHT);
            }
        }
    }

}