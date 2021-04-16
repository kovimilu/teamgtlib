package com.teamgtlib.NPCs;

import com.teamgtlib.Drawable;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;

import java.awt.*;
import java.util.ArrayList;

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

    private void move(){}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

     public abstract String getClassString();
}
