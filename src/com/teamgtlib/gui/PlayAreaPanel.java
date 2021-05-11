package com.teamgtlib.gui;

import com.teamgtlib.GameException;
import com.teamgtlib.NPCs.NPC;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

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
        park.build(x, y, theUgliestSolutionICouldFind(), true);
        //System.out.println(park.buildingsToString()); // for debugging
    }

    static public void refreshLabelText()
    {
        GameFrame.GameFrameStatusPanelString = "$" + Park.player.getBudget();
        GameFrame.GameFrameStatusPanel.budgetLabel.setText(GameFrame.GameFrameStatusPanelString);
        GameFrame.GameFrameStatusPanel.budgetLabel.repaint();

        GameFrame.GameFrameStatusPanel.countLabel.setText("Workers: " + Park.player.getWorkerCount() + " | "
                + "Visitors: " + Park.player.getVisitorCount());
        GameFrame.GameFrameStatusPanel.countLabel.repaint();

        switch (GameFrame.SelectionState) {
            case NONE -> GameFrame.GameFrameStatusPanelString = "";
            case BUILD -> GameFrame.GameFrameStatusPanelString = "Currently selected building: " + GameFrame.GameFrameCurrentButtonItemImageName;
            case DEMOLISH -> GameFrame.GameFrameStatusPanelString = "Select building to demolish";
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
    public synchronized void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(backGroundDrawn) {
            g.drawImage(Park.image, -280, -20, 1280, 720, null);
        }
        if(GameFrame.SelectionState == SelectionType.BUILD) {
            Point newPoint = new Point(GridUtils.gridConverter(prevPt));
            //TODO
            /*
            //Building Area Market
            g.setColor(Color.green);
            Point newCurrentMousePt = new Point(GridUtils.gridToPX(GridUtils.gridConverter(CurrentMousePt)));
            g.drawRect((int)newCurrentMousePt.getX(), (int)newCurrentMousePt.getY(),
                    park.preBuild(theUgliestSolutionICouldFind()).getWidth() * 50,
                    park.preBuild(theUgliestSolutionICouldFind()).getHeight() * 50);
            //Building Area Market #END
            */
            if(!GridUtils.isOnGridMap(GridUtils.gridConverter(prevPt))) {
                GameFrame.SelectionState = SelectionType.NONE;
                try {
                    doAllThingForNow((int) newPoint.getX(), (int) newPoint.getY());
                    // TODO maybe done? (did: prevPt -> newPoint)
                }
                catch (GameException e) {
                    refreshExceptionLabelText(e.toString().split(":")[1]);
                }
            }
            refreshLabelText();
        }
        //draw buildings
        for (Building building : Park.buildings) {
            if(building.getState() == BuildingState.BUILT) {
                new ImageIcon(building.getClassImagePath()).paintIcon(this, g, GridUtils.gridToPX(building.getX()),
                        GridUtils.gridToPX(building.getY()));
            }
            else if(building.getState() == BuildingState.UNBUILT) {
                resizeImage(new ImageIcon(building.getBuildImagePath()),building.getWidth()*50,
                        building.getHeight()*50).paintIcon(this, g, GridUtils.gridToPX(building.getX()),
                        GridUtils.gridToPX(building.getY()));
            }
        }
        for (Point garbage : Park.garbage) {
            g.setColor(Color.black);
            g.fillOval(GridUtils.gridToPX((int)garbage.getX()) + 12,
                    GridUtils.gridToPX((int)garbage.getY()) + 12,10,10);
        }

        //TODO Temporary
        ArrayList<Ride> rides = new ArrayList<>();
        for (Building building : Park.buildings) {
            String[] buildingString = building.toString().split("\\ ",0);
            //System.out.printf(String.valueOf(buildingString));
            if(buildingString[0].equals("Ride")) {
                rides.add((Ride)building);
            }
        }
        for (Ride ride : rides ) {
            if(ride.getDurability() < 50) {
                g.setColor(Color.red);
                g.fillOval(GridUtils.gridToPX(ride.getX()) + 12,
                        GridUtils.gridToPX(ride.getY()) + 12,15,15);
            }
        }


        //draw npcs
        for (NPC npc : Park.npcs) {
            if(npc.getClassString().equals("Visitor")) {
                g.setColor(Color.cyan);
            }
            if(npc.getClassString().equals("Maintenance")) {
                g.setColor(Color.orange);
            }
            if(npc.getClassString().equals("Cleaner")) {
                g.setColor(Color.magenta);
            }
            g.fillOval(GridUtils.gridToPX(npc.getX()) + 12, GridUtils.gridToPX(npc.getY()) + 12,20,20);

            //queue
            for (Ride ride : rides ) {
                if(npc.getAdjacentRoads(ride).equals(npc.getPoint()))
                {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
                    g.setColor(Color.black);
                    String Q = String.valueOf(ride.getQueueSize());
                    g.drawString(Q,GridUtils.gridToPX(npc.getX()) + 15, GridUtils.gridToPX(npc.getY()) + 25);
                    g.setColor(Color.cyan);
                }
                /*for (NPC inQueue : Ride.queue) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
                    g.setColor(Color.black);
                    //String Q = String.valueOf(ride.getQueueSize());
                    String Q = "6";
                    g.drawString(Q,GridUtils.gridToPX(inQueue.getX()) + 15, GridUtils.gridToPX(inQueue.getY()) + 25);
                    g.setColor(Color.cyan);

                 */
            }
        }

    }

    private ImageIcon resizeImage(ImageIcon imageIcon, int w, int h){
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
            if (GameFrame.SelectionState == SelectionType.DEMOLISH) {
                UIPanel.demolish();
                GameFrame.SelectionState = SelectionType.NONE; // can be done in UIPanel.demolish() as well
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
            //GameFrame.bg.repaint();
                //System.out.println(" x: " + e.getX() + ", y: " + e.getY());
        }
    }
}