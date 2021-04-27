package com.teamgtlib.buildings;

import com.teamgtlib.NPCs.Cleaner;
import com.teamgtlib.NPCs.NPC;
import com.teamgtlib.Park;
import com.teamgtlib.pathfinding.Point_;

import java.awt.*;
import java.util.List;

public class Bin extends Building {
    private static final int MAXBINS = 5;
    public static int currentBin = 0;
    public static int COST_PRICE = 500;

    public Bin(int x, int y) {
        super(x, y);
        width = 1;
        height = 1;
        price = COST_PRICE;
        if(currentBin > MAXBINS); //TODO throw exception
        else
        {
            currentBin++;
            this.moodValue = -25;
        }
    }

    public int distance(NPC v){
        int distance = (int) Math.sqrt(Math.pow((v.getX() - x),2) + Math.pow((v.getY() - y),2));
        return distance;
    }

    public int pathLength(NPC v){
        Point p = v.getAdjacentRoads(this);
        List<Point_> path = v.pathfinding(v.getX(), v.getY(), p.x, p.y);
        return path.size();
    }

    @Override
    public String toString() {
        return "Bin";
    }

    /**
     *
     * @param obj Buildging
     * Removes the obj from the building container.
     */
    @Override
    public void close(Building obj) {
        Park.buildings.remove(obj);
        if(currentBin > MAXBINS) currentBin--;
    }

    @Override
    public String getClassImagePath() {
        return "res/Bin.png";
    }
}
