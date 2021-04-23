package com.teamgtlib.NPCs;
import com.teamgtlib.Park;
import com.teamgtlib.gui.GameFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Visitor extends NPC {
    private boolean hasGarbage;

    Random rand = new Random();

    public Visitor() {
        super(10,13); // y = 14 amugy csak kilog
        x = 10;
        y = 13;
        //mood = rand.nextInt(30) + 45; //45-75
        //this.mood = 30;
        hasGarbage = false;
        Park.player.setVisitorCount(Park.player.getWorkerCount() + 1);
        Park.npcs.add(this);

    }

    @Override
    public void whatToDo() {

        if(this.mood < 20 && !currentlyMoving)
        {
            //this.currentlyMoving = true;
            this.path = pathfinding(this.x,this.y,10,13);
            //timer();
            move(path);
            leave();
            //GameFrame.bg.repaint();
        }
        if(this.mood > 20 && !currentlyMoving)
        {
            //this.currentlyMoving = true;
            this.path = pathfinding(this.x,this.y,10,7);

            //this.mood -= 50;
            //timer();
            move(path);
        }
        //random cuccuk pathfindig rando mridehoz vagy bolthoz vagy haza megy

        else System.out.printf("qwe");
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
