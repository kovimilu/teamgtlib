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
        Ride r = rollRandomRide();
        if(unbuiltRides && !currentlyMoving) {
            Point adjRoads = getAdjacentRoads(r);
            Park.player.changeBudgetBy(-wage);
            if (adjRoads != null) {
                Point p = new Point(adjRoads);
                this.path = pathfinding(this.x, this.y, (int) p.getX(), (int) p.getY());
                currentlyMoving = true;
                if(r.getDurability() < 50) {
                    move(path);
                    wait(3000);
                    repair(r);
                    GameFrame.bg.repaint();
                }
            }
            this.path = pathfinding(this.x,this.y,12,11);
            move(path);
        }
    }

    private void wage() {
        Park.player.changeBudgetBy(-wage);
    }

    public void repair(Ride obj) {
        obj.repairedDurability(50);

    }

    @Override
    public String getClassString() {
        return "Maintenance";
    }
}
