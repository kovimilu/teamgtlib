package com.teamgtlib.NPCs;
import com.teamgtlib.Park;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Visitor extends NPC {
    private int mood; // TODO maybe add default value
    private boolean hasGarbage;

    Random rand = new Random();

    public Visitor() {
        super(10,10);
        //path = new ArrayList<>();
        x = 10;  //TODO bejárathoz
        y = 7;
        //mood = rand.nextInt(30) + 45; //45-75
        mood = 10;
        hasGarbage = false;
        Park.npcs.add(this);

    }

    @Override
    public void whatToDo() {
        //System.out.printf("EZ LE FUT?");
        this.path = pathfinding();
        //System.out.printf(String.valueOf(path));
        //if(mood < 20) pathfinding();
    }

    public void updateMood(int changeBy) {
        mood += changeBy;
    }

    public void buyFood() {
        updateMood(10);
        hasGarbage = true;
    }

    public void buyTicket(int price) {
        super.changeParkBudgetBy(price);
    }

    public void throwsGarbage() {
        //TODO közeli kukához megy
        if(hasGarbage){
            //TODO throws
        }
    }

    public void getsOnTheRide() {

    }

    @Override
    public String getClassString() {
        return "Visitor";
    }

}
