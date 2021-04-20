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
    public static ArrayList<Ride> rides;
    public ArrayList<Point> testpath;

    Random rand = new Random();

    public Maintenance() {
        //x = rand.nextInt(10);
        //y = rand.nextInt(10);
        x = 2;
        y = 2;
        testpath = new ArrayList<>();
        searchPath(Park.playAreaPanel[0][5],Park.playAreaPanel,testpath,(x-1),(y-1));
        for (int i = 0; i<Park.buildings.size(); i++){
            if(Park.buildings.get(i) instanceof Road){
                ((Road) Park.buildings.get(i)).setVisited(false);
            }
        }

        if(testpath.size() > 0){
            for (int i = testpath.size()-1; i > 0; i--)
            {
                //Point p = new Point(1 + i,1);
                //testpath.add(p);
                System.out.println("test: " + testpath.get(i));
            }
        }else{
            System.out.println("nincs path");
        }

        Collections.reverse(testpath);
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
