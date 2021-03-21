package com.teamgtlib.gui;

import java.awt.*;
import java.util.ArrayList;

public class GridUtils { //TODO Might make this as a GridPoint "type" Class.
    static public ArrayList<Point> gridMap = new ArrayList<>(); // 20 x 14   (1000 x 700) //For some reason it's noly 20x13
    GridUtils(){}

    static public Point gridConverter(Point p) {
        int xGrid = (int) p.getX() / 50;
        if((int) p.getX() % 50 > 0)xGrid++;

        int yGrid = (int) p.getY() / 50;
        if((int) p.getY() % 50 > 0)yGrid++;

        Point gridPos = new Point(xGrid,yGrid);

        return gridPos;
    }

    static public Point gridToPX(Point p) {
        int xGrid = (int) p.getX() -1;
        xGrid *= 50 ;

        int yGrid = (int) p.getY() - 1;
        yGrid *= 50 ;

        Point pixelPos = new Point(xGrid,yGrid);

        return pixelPos;
    }

    static public boolean isOnGridMap(Point p) {
        /*int n = gridMap.size();
        for(int i = 0; i < n; ++i)
        {
            //should call gridConverter?
            if(gridConverter(p) == gridMap.get(i)) {
                return true;
            }
        }*/
        for (Point point: gridMap) {
            if(gridConverter(p) == point) {
                return true;
            }
        }
        gridMap.add(p);
        return false;
    }

}
