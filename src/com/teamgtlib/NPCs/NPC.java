package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.buildings.Ride;
import com.teamgtlib.buildings.Shop;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.PlayAreaPanel;
import com.teamgtlib.pathfinding.Grid;
import com.teamgtlib.pathfinding.PathFinding;
import com.teamgtlib.pathfinding.Point_;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public abstract class NPC {
    int x, y;
    int mood = 50; // TODO maybe add default value
    Boolean currentlyMoving = false;
    public List<Point_> path;

    public NPC(int x, int y) {
        path = new ArrayList<>();
        this.x = x;
        this.y = y;
        GameFrame.bg.repaint();
        PlayAreaPanel.refreshLabelText();
        updateTimer();
    }

    private ArrayList<Ride> getRides() {
        ArrayList<Ride> rides = new ArrayList<>();
        for (Building building : Park.buildings) {
            String[] buildingString = building.toString().split("\\ ",0);
            //System.out.printf(String.valueOf(buildingString));
            if(buildingString[0].equals("Ride")) {
                rides.add((Ride)building);
            }
        }
        //System.out.print(rides);
        return rides;
    }

    private ArrayList<Shop> getShops() {
        ArrayList<Shop> shops = new ArrayList<>();
        for (Building building : Park.buildings) {
            String[] buildingString = building.toString().split("\\ ",0);
            //System.out.printf(String.valueOf(buildingString));
            if(buildingString[0].equals("Shop")) {
                shops.add((Shop)building);
            }
        }
        //System.out.print(rides);
        return shops;
    }

    public Point getAdjacentRoads(Building obj) {
        Point North_P = new Point(obj.getX(),obj.getY() - 1);
        Point East_P = new Point(obj.getX() + 1,obj.getY());
        Point South_P = new Point(obj.getX(),obj.getY() + 1);
        Point West_P = new Point(obj.getX() - 1,obj.getY());

        ArrayList<Point> Adj = new ArrayList<>();

        int n = Park.buildings.size();
        for(int i = 0; i < n; ++i) {
            if(Park.buildings.get(i).getPoints().equals(North_P)) Adj.add(North_P);
            if(Park.buildings.get(i).getPoints().equals(East_P)) Adj.add(East_P);
            if(Park.buildings.get(i).getPoints().equals(South_P)) Adj.add(South_P);
            if(Park.buildings.get(i).getPoints().equals(West_P)) Adj.add(West_P);
        }

        if (Adj.isEmpty()) return null;

        //Distance
        ArrayList<Point> Adj_Diffs = new ArrayList<>();
        for (Point point : Adj) {
            //TODO this. might has to be point
            Point p = new Point(Math.abs((int) point.getX() - this.x), Math.abs((int) point.getY() - this.y));
            Adj_Diffs.add(p);
        }

        Point min_p = new Point(Adj_Diffs.get(0));
        int minIndex = 0;
        int n2 = Adj_Diffs.size();
        for(int i = 1; i < n2; ++i) {
            if((Adj_Diffs.get(i).getX() + Adj_Diffs.get(i).getX() > (min_p.getX() + min_p.getY()))) {
                min_p.setLocation(Adj_Diffs.get(i));
                minIndex = i;
            }
        }

        System.out.print("Ride Coords: " + Adj.get(minIndex) + "\n");
        return Adj.get(minIndex);
    }


    public Ride rollRandomRide() {
        ArrayList<Ride> rides = getRides();
        Random rand = new Random();
        int r = rand.nextInt(getRides().size());

        return rides.get(r);
    }

    public Shop rollRandomShop() {
        ArrayList<Shop> shops = getShops();
        Random rand = new Random();
        int r = rand.nextInt(getShops().size());

        return shops.get(r);
    }


    public void update() {
        whatToDo();
        //update();
        //timer();
        //if(!currentlyMoving && Park.npcs.contains(this)) {
        //    updateTimer();
        //}
    }

    Timer t = new java.util.Timer();
    public void updateTimer() {
        t.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                whatToDo();
                GameFrame.bg.repaint();
            }
        }, 0, 5000);
    }

    /**
     * @param sx starting x
     * @param sy starting y
     * @param fx finish x
     * @param fy finish y
     * @return path List, containing the the Points to the destination.
     */
    public List<Point_> pathfinding(int sx, int sy, int fx, int fy) {
        int width = 20;
        int height = 14;
        boolean[][] tiles = new boolean[width][height];

        // Fill it with values, false represents blocking tile
        for (int x = 0; x < 5; x++)
            for (int y = 0; y < 5; y++)
                tiles[x][y] = false;

        for(int i = 0; i < Park.buildings.size(); ++i) {
            if(Park.buildings.get(i).toString().equals("Road")) {
                //System.out.printf("\nRoad(" + i + ") : x: " + (GridUtils.gridConverter(Park.buildings.get(i).getX()) + 1)
                //+ ", y: " + (GridUtils.gridConverter(Park.buildings.get(i).getY())+ 1));
                tiles[Park.buildings.get(i).getX() - 1]
                        [Park.buildings.get(i).getY() - 1] = true;
            }
        }

        // Create a Grid instance
        Grid grid = new Grid(width, height, tiles);

        // Create endPoint_s
        Point_ start  = new Point_(sx - 1, sy - 1);
        Point_ target = new Point_(fx - 1, fy - 1);

        // Last argument will make this search be 4 directional

        // Print the path
        //for (Point_ point : path) System.out.println(point);
        return PathFinding.findPath(grid, start, target, false);
    }


    public abstract void whatToDo();

    public void leave() {
        wait(500);
        setX(0);
        setY(0);
        wait(100);
        GameFrame.bg.repaint();
        Park.npcs.remove(this);
        t.cancel();
    }

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
        int n = path.size();
        for (Point_ point_ : path) {
            GameFrame.bg.repaint();
            wait(500);
            setX(point_.getX() + 1);
            setY(point_.getY() + 1);
        }
        currentlyMoving = false;
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
