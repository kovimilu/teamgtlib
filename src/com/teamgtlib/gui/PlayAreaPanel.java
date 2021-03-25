package com.teamgtlib.gui;

import com.teamgtlib.GameException;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.*;

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

        if(!GameFrame.GameFrameButtonIsPressedOnce)GameFrame.GameFrameStatusPanelString = "";
        else GameFrame.GameFrameStatusPanelString = "Currently selected building: " + GameFrame.GameFrameCurrentButtonItemImageName;
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

            if(!GridUtils.isOnGridMap(GridUtils.gridConverter(prevPt))) {
                try {
                    doAllThingForNow((int) newPoint.getX(), (int) newPoint.getY());
                    // TODO maybe done? (did: prevPt -> newPoint)
                }
                catch (GameException e) {
                    refreshExceptionLabelText(e.toString().split(":")[1]);
                }

                refreshLabelText();
            }

            for (Building building : Park.buildings) {
                new ImageIcon(building.getClassImagePath()).paintIcon(this, g, building.getX(), building.getY());
            }

            GameFrame.GameFrameButtonIsPressedOnce = false;
            refreshLabelText();
        }
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
            if(GameFrame.GameFrameButtonIsPressedOnce) {
                repaint();
            }
        }
    }
}