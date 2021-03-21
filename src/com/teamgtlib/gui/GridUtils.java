package com.teamgtlib.gui;

import java.awt.*;
import java.nio.channels.Pipe;
import java.util.ArrayList;

public class GridUtils { //TODO Might make this as a GridPoint "type" Class.
    static public ArrayList<Point> gridMap = new ArrayList<Point>(); // 20 x 14   (1000 x 700) //For some reason it's noly 20x13
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

    static public boolean alreadyOnGridMap(Point p) {
        boolean is_in = false;
        int n = gridMap.size();
        for(int i = 0; i < n && !is_in; ++i)
        {
            //should call gridConverter?
            if(gridConverter(p) == gridMap.get(i))is_in = true;
            else {
                gridMap.add(p);
            }
        }
        return !is_in;
    }

}
