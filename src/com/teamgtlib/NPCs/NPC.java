package com.teamgtlib.NPCs;

import com.teamgtlib.buildings.Building;

import java.awt.*;
import java.util.ArrayList;

public abstract class NPC {
    static public ArrayList<Point> gridMap2 = new ArrayList<>();

    public ArrayList pathFinding(Building obj) {
        ArrayList<Point> gridMap = new ArrayList<>();
        gridMap.add(obj.whereAmI());
        return gridMap;
    }
}
