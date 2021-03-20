package com.teamgtlib.gui;

import com.teamgtlib.Buildings.DecorType;
import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class PlayAreaPanel extends JPanel {

    final int WIDTH = 100;
    final int HEIGHT = 100;
    Boolean backGroundDrawn = true;
    Point prevPt;

    Park park = new Park();

    public PlayAreaPanel() throws IOException {
        setPreferredSize(new Dimension(1280,720));
        PlayAreaPanel.ClickListener clickListener = new PlayAreaPanel.ClickListener();
        this.addMouseListener(clickListener);

        park.draw();//TODO FIX: For now, this method loads the background image.

    }

    /**
     * This method Loads in the image selected by the UI Button last presses. <br>
     * Pressing before placing the img doesnt work yet.
     * //Also does some string formatting.//
     */
    ImageIcon imageSelector()
    {
        String filename = GameFrame.GameFrameCurrentButtonItemImageName.toLowerCase();
        filename = filename.substring(0, 1).toUpperCase() + filename.substring(1);
        String str = "res/" + filename + ".png";
        //System.out.println(str);
        return new ImageIcon(str);
    }

    ImageIcon imageSelector(String filename)
    {
        filename = filename.substring(0, 1).toUpperCase() + filename.substring(1);
        String str = "res/" + filename + ".png";
        //System.out.println(str);
        return new ImageIcon(str);
    }

    private void doAllThingForNow(int x, int y)
    {
        park.player.updateBudget(-5600);
        //park.buildTest(x, y, GameFrame.GameFrameCurrentButtonItemImageName); //TODO Uncommenzting this line will crash the game xd
        park.build(x, y, DecorType.BENCH);
        System.out.println(park.buildingsToString()); // for debugging
    }

    private void refreshLabelText()
    {
        GameFrame.GameFrameStatusPanelString = "$" + park.player.getBudget();
        GameFrame.GameFrameStatusPanel.label.setText(GameFrame.GameFrameStatusPanelString);
        GameFrame.GameFrameStatusPanel.label.repaint();

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(backGroundDrawn) {
            g.drawImage(Park.image, 0, 0, 1280, 720, null);
        }
        if(GameFrame.GameFrameButtonIsPressedOnce) {
            imageSelector().paintIcon(this, g, (int) prevPt.getX(), (int) prevPt.getY());
            doAllThingForNow((int) prevPt.getX(), (int) prevPt.getY()); //TODO
            refreshLabelText();
            //System.out.println((int) prevPt.getX() + " " + (int) prevPt.getY());
            GameFrame.GameFrameButtonIsPressedOnce = false;
        }
    }

    // TODO decide if this and customPaint will be used
    public void paintComponent(Graphics g, ImageIcon paintThis)
    {
        super.paintComponent(g);
        if(backGroundDrawn) {
            g.drawImage(Park.image, 0, 0, 1280, 720, null);
        }
        if(GameFrame.GameFrameButtonIsPressedOnce) {
            paintThis.paintIcon(this, g, (int) prevPt.getX(), (int) prevPt.getY());
            doAllThingForNow((int) prevPt.getX(), (int) prevPt.getY()); //TODO
            refreshLabelText();
            //System.out.println((int) prevPt.getX() + " " + (int) prevPt.getY());
            GameFrame.GameFrameButtonIsPressedOnce = false;
        }
    }

    public void customPaint(Graphics g, ImageIcon paintThis) {
        paintComponent(g, paintThis);
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
            if(GameFrame.GameFrameButtonIsPressedOnce) {
                repaint((int)prevPt.getX(), (int)prevPt.getY(), WIDTH, HEIGHT);
            }
        }
    }

}