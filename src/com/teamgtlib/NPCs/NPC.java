package com.teamgtlib.NPCs;

import com.teamgtlib.Drawable;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.gui.GameFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;

public abstract class NPC {
    int x, y;
    static public ArrayList<Point> gridMap2 = new ArrayList<>();

    public ArrayList pathFinding(Building obj) {
        ArrayList<Point> gridMap = new ArrayList<>();
        gridMap.add(obj.whereAmI());
        return gridMap;
    }

    public abstract void whatToDo();

    public void budgetChange(int price) {
        Park.player.updateBudget(price);
    }

    public void timer(ArrayList<Point> testpath) {
        Timer t = new java.util.Timer();
        t.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                move(testpath);
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

    public void move(ArrayList<Point> testpath) {
        for (Point p : testpath) {
            GameFrame.bg.repaint();
            wait(500);
            setX((int)p.getX());
            setY((int)p.getY());

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
