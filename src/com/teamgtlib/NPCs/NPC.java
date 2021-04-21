package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.buildings.Road;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.GridUtils;
import com.teamgtlib.gui.PlayAreaPanel;
import com.teamgtlib.pathfinding.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

public abstract class NPC {
    int x, y;
    public List<Point_> path;

    public NPC(int x, int y) {
        path = new ArrayList<>();
        this.x = x;
        this.y = y;
        GameFrame.bg.repaint();
        update();
    }

    public void update() {
        whatToDo();
        timer();
        //updateTimer();
    }

    public void updateTimer() {
        Timer t = new java.util.Timer();
        t.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                update();
                GameFrame.bg.repaint();
                t.cancel(); }
        }, 500);
    }

    public List<Point_> pathfinding() {
        int width = 20;
        int height = 14;
        boolean[][] tiles = new boolean[width][height];

        // Fill it with values, false represents blocking tile
        for (int x = 0; x < 5; x++)
            for (int y = 0; y < 5; y++)
                tiles[x][y] = false;

        for(int i = 0; i < Park.buildings.size(); ++i) {
            if(Park.buildings.get(i).toString().equals("Road")) {
                System.out.printf("\nRoad(" + i + ") : x: " + (GridUtils.gridConverter(Park.buildings.get(i).getX()) + 1)
                + ", y: " + (GridUtils.gridConverter(Park.buildings.get(i).getY())+ 1));
                tiles[GridUtils.gridConverter(Park.buildings.get(i).getX())]
                        [GridUtils.gridConverter(Park.buildings.get(i).getY())] = true;
            }
        }

        // Create a Grid instance
        Grid grid = new Grid(width, height, tiles);

        // Create endPoint_s
        Point_ start  = new Point_(10 - 1, 7 - 1);
        Point_ target = new Point_(12 - 1, 11 - 1);

        // Last argument will make this search be 4 directional
        List<Point_> path = PathFinding.findPath(grid, start, target, false);

        // Print the path
        for (Point_ point : path) System.out.println(point);
        return path;
    }


    public abstract void whatToDo();

    public void changeParkBudgetBy(int price) { Park.player.changeBudgetBy(price); }

    public void timer() {
        Timer t = new java.util.Timer();
        t.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                move(path);
                GameFrame.bg.repaint();
                t.cancel(); }
        }, 500);
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void move(List<Point_> path) {
        //System.out.printf("MOVE LE FUT?: ");
        int n = path.size();
        //System.out.printf(String.valueOf(n));
        for (int i = 0; i < n; ++i) {
            System.out.printf("MOVE LE FUT?: ");
            GameFrame.bg.repaint();
            wait(500);
            setX(path.get(i).getX() + 1);
            setY(path.get(i).getY() + 1);

        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

     public abstract String getClassString();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
