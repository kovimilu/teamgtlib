package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Ride;

import java.awt.*;
import java.util.Random;

public class Cleaner extends Worker {

    public Cleaner() {
        super(10,13);
        x = 10;
        y = 13;
        wage = 435;
        Park.npcs.add(this);
    }

    @Override
    public void whatToDo() {
        if(!currentlyMoving && Park.garbage.size() > 0) {
            Random rand = new Random();
            int r = rand.nextInt(Park.garbage.size());
            Point adjRoads = Park.garbage.get(r);
            Park.player.changeBudgetBy(-wage);
            if (adjRoads != null) {
                Point p = new Point(adjRoads);
                this.path = pathfinding(this.x, this.y, (int) p.getX(), (int) p.getY());
                currentlyMoving = true;
                move(path);
                wait(1000);
                Park.garbage.remove(p);
            }
        }
        if(!currentlyMoving && Park.garbage.size() == 0) {
            this.path = pathfinding(this.x, this.y, 12, 11);
            move(path);
        }
    }

    @Override
    public String getClassString() {
        return "Cleaner";
    }
}
