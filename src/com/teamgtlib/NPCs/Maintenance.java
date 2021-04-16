package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.buildings.Ride;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Maintenance extends Worker {
    public static ArrayList<Ride> rides;

    Random rand = new Random();

    public Maintenance() {
        x = rand.nextInt(10);
        y = rand.nextInt(10);
        //x = 1;
        //y = 1;
        wage = 1670;
        rides = new ArrayList<>();
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
