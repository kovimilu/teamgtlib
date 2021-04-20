package com.teamgtlib.gui;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.buildings.BuildingType;
import com.teamgtlib.buildings.Ride;
import com.teamgtlib.buildings.RideType;

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

        return new Point(xGrid,yGrid);
    }

    /**
     * Overloaded function.
     * Converts Mouse position Coordinate to gridMap Coordinate.
     * @param p int type
     * @return Returns converted Coordinate.
     */
    static public int gridConverter(int p) {
        int xGrid = p / 50;
        if(p % 50 > 0)xGrid++;

        return xGrid;
    }

    /**
     * Converts the gridMap position to Pixel Points.
     * @param p Point type
     * @return Returns the converted Point.
     */
    static public Point gridToPX(Point p) {
        int xGrid = (int) p.getX() - 1;
        xGrid *= 50 ;

        int yGrid = (int) p.getY() - 1;
        yGrid *= 50 ;

        return new Point(xGrid,yGrid);
    }
    /**
     * Converts the gridMap position to Pixel Coordinate.
     * @param p Point type
     * @return Returns the converted Coordinate.
     */
    static public int gridToPX(int p) {
        int xGrid = p - 1;
        xGrid *= 50 ;

        return xGrid;
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
                Point gridPos = new Point((int)p.getX() + i, (int)p.getY() + j);
                gridMap.add(gridPos);
            }
        }
        return false;
    }

    static public boolean addGridMap(Point p, BuildingType type) {
        for (Point point: gridMap) {
            System.out.println(p + "" + point);
            if(p.equals(point)) return true;
        }
        Building PREBUILT = Park.preBuild(type);
        int WIDTH = PREBUILT.getWidth();
        int HEIGHT = PREBUILT.getHeight();
        for (int i = 0; i < WIDTH; ++i) {
            for (int j = 0; j < HEIGHT; ++j) {
                Point gridPos = new Point((int)p.getX() + i, (int)p.getY() + j);
                gridMap.add(gridPos);
            }
        }
        return false;
    }

    public static void removeBuildingFromGridMap(Building building) {
        int WIDTH = building.getWidth();
        int HEIGHT = building.getHeight();
        Point p = GridUtils.gridConverter(new Point(building.getX(), building.getY()));
        for (int i = 1; i <= WIDTH; ++i) {
            for (int j = 1; j <= HEIGHT; ++j) {
                Point gridPos = new Point((int)p.getX() + i, (int)p.getY() + j);
                gridMap.remove(gridPos);
            }
        }
    }
}
