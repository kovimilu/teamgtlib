package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.buildings.BuildingState;
import com.teamgtlib.buildings.Ride;
import com.teamgtlib.gui.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Maintenance extends Worker {
    public static ArrayList<Ride> rides;
    public ArrayList<Point> testpath;

    Random rand = new Random();

    public Maintenance() {
        //x = rand.nextInt(10);
        //y = rand.nextInt(10);
        x = 1;
        y = 1;
        testpath = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
        {
            Point p = new Point(1 + i,1);
            testpath.add(p);
        }
        wage = 1670;
        rides = new ArrayList<>();
        getRides();
        timer(testpath);
    }

    private void getRides() {
        for (Building building : Park.buildings) {
            String[] buildingString = building.getClassImagePath().split(" ",0);
            if(buildingString.equals("Ride")) {
                rides.add((Ride)building);
            }
        }
    }

    @Override
    public void whatToDo() {
        for (Ride ride : this.rides) {
            if(ride.getDurability() >= 50 ) repair(ride);
            break;
        }
    }

    public void repair(Building obj) {
        //pathfinding

    }

    @Override
    public String getClassString() {
        return "Maintenance";
    }
}
