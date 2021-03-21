package com.teamgtlib.gui;

import com.teamgtlib.Buildings.Buildable;
import com.teamgtlib.Buildings.BuildingType;
import com.teamgtlib.Buildings.DecorType;
import com.teamgtlib.Buildings.RideType;
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
        setPreferredSize(new Dimension(1280 - 280 //Subtracting the UIPanel's width.
                                                        ,700));
        PlayAreaPanel.ClickListener clickListener = new PlayAreaPanel.ClickListener();
        this.addMouseListener(clickListener);
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

    private Buildable theUgliestSolutionICouldFind()
    {
        String str = GameFrame.GameFrameCurrentButtonItemImageName.toLowerCase();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        if(str.equals("Carousel"))return RideType.CAROUSEL;
        if(str.equals("Dodgem"))return RideType.DODGEM;
        if(str.equals("Waterslide"))return RideType.WATERSLIDE;
        if(str.equals("Ferriswheel"))return RideType.FERRISWHEEL;
        if(str.equals("Rollercoaster"))return RideType.ROLLERCOASTER;

        if(str.equals("Bench"))return DecorType.BENCH;
        if(str.equals("Bush"))return DecorType.BUSH;
        if(str.equals("Tree"))return DecorType.TREE;

        if(str.equals("Shop"))return BuildingType.SHOP;
        if(str.equals("Road"))return BuildingType.ROAD;
        if(str.equals("Bin"))return BuildingType.BIN;
        return null;
    }

    private void doAllThingForNow(int x, int y)
    {
        park.build(x, y, theUgliestSolutionICouldFind());
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
            g.drawImage(Park.image, 0, 0, 1000, 700, null);
        }
        if(GameFrame.GameFrameButtonIsPressedOnce) {
            Point newPoint = new Point(GridUtils.gridToPX(GridUtils.gridConverter(prevPt)));

            if(GridUtils.alreadyOnGridMap(GridUtils.gridConverter(prevPt))) {
                imageSelector().paintIcon(this, g, (int) newPoint.getX(), (int) newPoint.getY());
                //imageSelector().paintIcon(this, g, (int) prevPt.getX(), (int) prevPt.getY());
                doAllThingForNow((int) prevPt.getX(), (int) prevPt.getY()); //TODO
                refreshLabelText();
            }
            System.out.println(GridUtils.gridConverter(prevPt));
            System.out.println(GridUtils.gridToPX(GridUtils.gridConverter(prevPt)));
            System.out.println(GridUtils.alreadyOnGridMap(GridUtils.gridConverter(prevPt)));

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
                Point newPoint = new Point(GridUtils.gridToPX(GridUtils.gridConverter(prevPt)));
                repaint((int)newPoint.getX(), (int)newPoint.getY(), WIDTH, HEIGHT);
                //repaint((int)prevPt.getX(), (int)prevPt.getY(), WIDTH, HEIGHT);
            }
        }
    }

}