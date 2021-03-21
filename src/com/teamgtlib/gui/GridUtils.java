package com.teamgtlib.gui;

import java.awt.*;
import java.nio.channels.Pipe;
import java.util.ArrayList;

public class GridUtils { //TODO Might make this as a GridPoint "type" Class.
    static public ArrayList<Point> gridMap; // 20 x 14   (1000 x 700)
    GridUtils(){}

    static public Point gridConverter(Point p) {
        int xGrid = (int) p.getX() / 50;
        if((int) p.getX() % 50 > 0)xGrid++;

        int yGrid = (int) p.getY() / 50;
        if((int) p.getY() % 50 > 0)yGrid++;

        Point gridPos = null;
        gridPos.setLocation(xGrid,yGrid);

        return gridPos;
    }

    static public boolean alreadyOnGridMap(Point p) {
        boolean is_in = false;
        for(int i = 0; i < gridMap.size() && !is_in; ++i)
        {
            if(gridConverter(p) == gridMap.get(i))is_in = true;
            else {
                gridMap.add(p);
            }
        }
        return !is_in;
    }

}
