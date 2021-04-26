package com.teamgtlib.NPCs;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.Ride;
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
        setVisitorCountAndRefreshLabelText();
        Park.npcs.add(this);
    }

    private void setVisitorCountAndRefreshLabelText() {
        Park.player.setVisitorCount(Park.player.getVisitorCount() + 1);
        GameFrame.bg.refreshLabelText();
    }

    @Override
    public void whatToDo() {
        Random rand = new Random();
        ArrayList<String> random;
        random = new ArrayList<>();

        String LEAVE = "LEAVE";
        String EAT = "EAT";
        String RIDE = "RIDE";
        String IDLE = "IDLE";

        random.add(IDLE);
        random.add(LEAVE);
        random.add(EAT);
        random.add(RIDE);
        random.add(random.get(rand.nextInt(4)));
        // 5

        // 0 - 4
        if(mood < 40) {
            random.add(LEAVE);
            random.add(LEAVE);

            if(mood < 20) {
                random.add(LEAVE);
                random.add(LEAVE);
            }
            else {
                random.add(EAT);
                random.add(RIDE);
            }
        }
        else {
            random.add(EAT);
            random.add(EAT);
            random.add(RIDE);
            random.add(RIDE);
        }
        random.add(RIDE);


        String Choice = random.get(rand.nextInt(10));

        System.out.print(Choice + "\n");


        //LEAVE PARK
        if(Choice.equals("LEAVE") && !currentlyMoving) {
            //this.currentlyMoving = true;
            this.path = pathfinding(this.x,this.y,10,14);
            //timer();
            currentlyMoving = true;
            move(path);
            leave();
            Park.player.setVisitorCount(Park.player.getVisitorCount() - 1);
            GameFrame.bg.refreshLabelText();
            //GameFrame.bg.repaint();
        }
        if(Choice.equals("IDLE") && !currentlyMoving) {
            //this.currentlyMoving = true;
            this.path = pathfinding(this.x,this.y,this.x,this.y);
            currentlyMoving = true;
            wait(1000);
            move(path);
        }
        if(Choice.equals("RIDE") && !currentlyMoving) {
            //this.currentlyMoving = true;

            Point p = new Point(getAdjacentRoadsToRideCoords(rollRandomRide()));
            this.path = pathfinding(this.x,this.y,(int)p.getX(), (int)p.getY());

            //this.path = pathfinding(this.x,this.y,10,7);
            Ride r = (Ride) Park.buildings.get(13);
            this.mood -= 5;
            //timer();
            //ha van szemét

            currentlyMoving = true;
            move(path);
            r.addToQueue(this);
            r.start();
        }
        if(Choice.equals("EAT") && !currentlyMoving) {
            //TODO random shop + shop metódusok hívása
            this.path = pathfinding(this.x,this.y,8,9);
            currentlyMoving = true;
            move(path);
            wait(100);

        }

        //random cuccuk pathfindig rando mridehoz vagy bolthoz vagy haza megy
    }

    public void updateMood(int changeBy) {
        mood += changeBy;
    }

    public void buyFood(int price) {
        super.changeParkBudgetBy(price);
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
