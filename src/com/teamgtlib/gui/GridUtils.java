package com.teamgtlib.gui;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;

import java.awt.*;
import java.util.ArrayList;

public class GridUtils {
    static public ArrayList<Point> gridMap = new ArrayList<>();
    GridUtils(){}

    /**
     * Converts Mouse position Points to gridMap Points.
     * @param p Point type
     * @return Returns converted Point.
     */
    static public Point gridConverter(Point p) {
        int xGrid = (int) p.getX() / 50;
        if((int) p.getX() % 50 > 0)xGrid++;

        int yGrid = (int) p.getY() / 50;
        if((int) p.getY() % 50 > 0)yGrid++;

        Point gridPos = new Point(xGrid,yGrid);

        return gridPos;
    }

    /**
     * Converts the gridMap position to Pixel Points.
     * @param p Point type
     * @return Returns the converte Point.
     */
    static public Point gridToPX(Point p) {
        int xGrid = (int) p.getX() -1;
        xGrid *= 50 ;

        int yGrid = (int) p.getY() - 1;
        yGrid *= 50 ;

        Point pixelPos = new Point(xGrid,yGrid);

        return pixelPos;
    }

    /**
     * @param p Coordinates of the Building.
     * @return Returns true or false Depending on weather the the selected area on the map is occupied or not.
     */
    static public boolean isOnGridMap(Point p) {
        for (Point point: gridMap) {
            System.out.println(p + "" + point);
            if(p.equals(point)) return true;
        }
        Building PREBUILT = Park.preBuild(PlayAreaPanel.theUgliestSolutionICouldFind());
        int WIDTH = PREBUILT.getWidth();
        int HEIGHT = PREBUILT.getHeight();
        for (int i = 0; i < WIDTH; ++i) {
            for (int j = 0; j < HEIGHT; ++j) {
                Point grisPos = new Point((int)p.getX() + i, (int)p.getY() + j);
                gridMap.add(grisPos);
            }
        }
        return false;
    }
}
