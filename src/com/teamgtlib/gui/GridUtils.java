package com.teamgtlib.gui;

import com.teamgtlib.Buildings.Building;
import com.teamgtlib.Park;

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

    /*
    static public boolean isOnGridMap(Point p) {
        for (Point point: gridMap) {
            System.out.println(p + "" + point);
            if(p.equals(point)) {
                System.out.println("Benne volt");
                return true;
            }
        }
        gridMap.add(p);
        System.out.println("Nem volt benne");
        return false;
    }
    */

    static public boolean isOnGridMap(Point p) {
        for (Point point: gridMap) {
            System.out.println(p + "" + point);
            if(p.equals(point)) return true;
        }
        Building PREBUILT = Park.preBuild(0,0, PlayAreaPanel.theUgliestSolutionICouldFind());
        int WIDTH = PREBUILT.getWidth();
        int HEIGHT = PREBUILT.getHeight();
        for (int i = 0; i < WIDTH; ++i) {
            for (int j = 0; j < HEIGHT; ++j) {
                Point grisPos = new Point((int)p.getX() + i, (int)p.getY() + j);
                gridMap.add(grisPos);
            }
        }
System.out.println(gridMap); // debug
        return false;
    }

}
