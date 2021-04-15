package com.teamgtlib.gui;

import com.teamgtlib.GameException;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class PlayAreaPanel extends JPanel {

    Boolean backGroundDrawn = true;
    static Point prevPt;
    Point CurrentMousePt;
    Park park = new Park();

    public PlayAreaPanel() throws IOException {
        setPreferredSize(new Dimension(1280 - 280 //Subtracting the UIPanel's width.
                                                        ,700));
        PlayAreaPanel.ClickListener clickListener = new PlayAreaPanel.ClickListener();
        this.addMouseListener(clickListener);
        PlayAreaPanel.MoveListener moveListener = new PlayAreaPanel.MoveListener();
        this.addMouseMotionListener(moveListener);
    }

    public static Buildable theUgliestSolutionICouldFind()
    {
        String str = GameFrame.GameFrameCurrentButtonItemImageName.toLowerCase();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        if(str.equals("Carousel"))return RideType.CAROUSEL;
        if(str.equals("Castle"))return RideType.CASTLE;
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

    private void doAllThingForNow(int x, int y) throws GameException {
        park.build(x, y, theUgliestSolutionICouldFind());
        System.out.println(park.buildingsToString()); // for debugging
    }

    static public void refreshLabelText()
    {
        GameFrame.GameFrameStatusPanelString = "$" + Park.player.getBudget();
        GameFrame.GameFrameStatusPanel.budgetLabel.setText(GameFrame.GameFrameStatusPanelString);
        GameFrame.GameFrameStatusPanel.budgetLabel.repaint();

        if (GameFrame.GameFrameButtonIsPressedOnce) {
            GameFrame.GameFrameStatusPanelString = "Currently selected building: " + GameFrame.GameFrameCurrentButtonItemImageName;
        } else if (GameFrame.DemolishButtonIsPressedOnce) {
            GameFrame.GameFrameStatusPanelString = "Select building to demolish";
        } else {
            GameFrame.GameFrameStatusPanelString = "";
        }

        GameFrame.GameFrameStatusPanel.clickLabel.setText(GameFrame.GameFrameStatusPanelString);
        GameFrame.GameFrameStatusPanel.clickLabel.repaint();
    }

    private void refreshExceptionLabelText(String e)
    {
        GameFrame.GameFrameStatusPanelString = e;
        GameFrame.GameFrameStatusPanel.exceptionLabel.setText(GameFrame.GameFrameStatusPanelString);
        GameFrame.GameFrameStatusPanel.exceptionLabel.repaint();
    }



    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(backGroundDrawn) {
            g.drawImage(Park.image, -280, -20, 1280, 720, null);
        }
        if(GameFrame.GameFrameButtonIsPressedOnce) {
            Point newPoint = new Point(GridUtils.gridToPX(GridUtils.gridConverter(prevPt)));
            //TODO
            //Building Area Market
            g.setColor(Color.green);
            Point newCurrentMousePt = new Point(GridUtils.gridToPX(GridUtils.gridConverter(CurrentMousePt)));
            g.drawRect((int)newCurrentMousePt.getX(), (int)newCurrentMousePt.getY(),
                    park.preBuild(theUgliestSolutionICouldFind()).getWidth() * 50,
                    park.preBuild(theUgliestSolutionICouldFind()).getHeight() * 50);
            //Building Area Market #END
            if(!GridUtils.isOnGridMap(GridUtils.gridConverter(prevPt))) {
                try {
                    doAllThingForNow((int) newPoint.getX(), (int) newPoint.getY());
                    // TODO maybe done? (did: prevPt -> newPoint)
                }
                catch (GameException e) {
                    refreshExceptionLabelText(e.toString().split(":")[1]);
                }
            }
            GameFrame.GameFrameButtonIsPressedOnce = false;
            refreshLabelText();
        }
        for (Building building : Park.buildings) {
            new ImageIcon(building.getClassImagePath()).paintIcon(this, g, building.getX(), building.getY());
        }
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
            if (GameFrame.DemolishButtonIsPressedOnce) {
                UIPanel.demolish();
                GameFrame.DemolishButtonIsPressedOnce = false; // can be done in UIPanel.demolish() as well
                refreshLabelText();
            }
            repaint();
        }
    }

    private class MoveListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
                CurrentMousePt = e.getPoint();
                //System.out.println(" x: " + e.getX() + ", y: " + e.getY());

        }
    }
}