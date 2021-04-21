package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
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
    /*
    private void getRides() {
        for (Building building : Park.buildings) {
            String[] buildingString = building.getClassImagePath().split(" ",0);
            if(buildingString.equals("Ride")) {
                rides.add((Ride)building);
            }
        }
    }
    */
    @Override
    public void whatToDo() {
        /*for (Ride ride : this.rides) {
            if(ride.getDurability() >= 50 ) repair(ride);
            break;
        }

         */
    }

    public void repair(Building obj) {
        //pathfinding

    }

    @Override
    public String getClassString() {
        return "Maintenance";
    }
}
