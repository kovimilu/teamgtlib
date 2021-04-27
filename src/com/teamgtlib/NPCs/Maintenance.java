package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
import com.teamgtlib.Player;
import com.teamgtlib.buildings.*;
import com.teamgtlib.gui.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;

public class Maintenance extends Worker {
    //public static ArrayList<Ride> rides;
    //public ArrayList<Point> testpath;

    Random rand = new Random();
    boolean unbuiltRides = true;

    public Maintenance() {
        super(10,13);
        x = 10;
        y = 13;

        //pathFinding(Park.playAreaPanel[6][10],Park.playAreaPanel,testpath,(x-1),(y-1));
        wage = 1670;
        //rides = new ArrayList<>();
        Park.npcs.add(this);
        //getRides();
        //timer();
    }

    @Override
    public void whatToDo() {
        if(unbuiltRides && !currentlyMoving) {
            Ride r = rollRandomRide();
            Point adjRoads = getAdjacentRoads(r);
            Park.player.changeBudgetBy(-wage);
            if (adjRoads != null) {
                Point p = new Point(adjRoads);
                this.path = pathfinding(this.x, this.y, (int) p.getX(), (int) p.getY());
                currentlyMoving = true;
                move(path);
                //unbuiltRides = false;
                wait(5000);
            }
            this.path = pathfinding(this.x,this.y,12,11);
            move(path);
        }
    }

    private void wage() {
        Park.player.changeBudgetBy(-wage);
    }

    public void repair(Building obj) {
        //pathfinding

    }

    @Override
    public String getClassString() {
        return "Maintenance";
    }
}
