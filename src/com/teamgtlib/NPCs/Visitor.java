package com.teamgtlib.NPCs;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.Bin;
import com.teamgtlib.buildings.Ride;
import com.teamgtlib.buildings.Shop;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.PlayAreaPanel;
import com.teamgtlib.pathfinding.Point_;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Visitor extends NPC {

    private boolean hasGarbage;
    boolean stuck = false;

    Ride r;
    private int prevX;
    private int prevY;

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
        random.add(RIDE);
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

        if(stuck) leave();
        if(r != null && r.getQueue().contains(this)) {
            r.start();
            return;
        }

        if(hasGarbage && !currentlyMoving) {
            setHasGarbage(false);
            ArrayList<Bin> bins = getBins();
            if(!bins.isEmpty()) {
                int min = bins.get(0).pathLength(this);
                int minIndex = 0;
                for (int i = 1; i < bins.size(); ++i) {
                    if (bins.get(i).pathLength(this) < min) {
                        min = bins.get(i).pathLength(this);
                        minIndex = i;
                    }
                }
                if(bins.get(minIndex).pathLength(this) <= 3 ) {
                    System.out.printf("\n\n\n  ez" + hasGarbage +" \n\n\n");

                    Point adjRoads = getAdjacentRoads(bins.get(minIndex));
                    this.path = pathfinding(this.x,this.y, adjRoads.x, adjRoads.y);
                    move(path);
                    wait(300);
                }
                else setHasGarbage(true);
            }
            else setHasGarbage(true);

        }
        if(Choice.equals("LEAVE") && !currentlyMoving) {
            this.path = pathfinding(this.x,this.y,10,14);
            currentlyMoving = true;
            move(path);
            leave();
            stuck = true;
            Park.player.setVisitorCount(Park.player.getVisitorCount() - 1);
            GameFrame.bg.refreshLabelText();
        }
        if(Choice.equals("IDLE") && !currentlyMoving) {
            this.path = pathfinding(this.x,this.y,this.x,this.y);
            currentlyMoving = true;
            wait(1000);
            move(path);
        }
        if(Choice.equals("RIDE") && !currentlyMoving) {
            r = rollRandomRide();
            Point adjRoads = getAdjacentRoads(r);
            if (adjRoads != null) {
                Point p = new Point(adjRoads);
                this.path = pathfinding(this.x, this.y, (int) p.getX(), (int) p.getY());
                currentlyMoving = true;
                if(r.getDurability() > 50) {
                    move(path);
                    wait(100);
                    r.addToQueue(this);
                    prevX = x;
                    prevY = y;
                    x = y = 0;
                    r.start();
                    x = prevX;
                    y = prevY;
                }
            }
        }
        if(Choice.equals("EAT") && !currentlyMoving) {
            Shop r = rollRandomShop();
            Point adjRoads = getAdjacentRoads(r);
            if (adjRoads != null) {
                Point p = new Point(adjRoads);
                this.path = pathfinding(this.x, this.y, (int) p.getX(), (int) p.getY());
                currentlyMoving = true;
                move(path);
                wait(100);
                r.sellFood(this);
            }
        }
    }
    public void throwGarbage() {
        Random rand = new Random();
        int chance = rand.nextInt(3);
        if(hasGarbage && chance == 1) {
            Point q = new Point(this.x, this.y);
            if(!Park.garbage.contains(q)) Park.garbage.add(q);
            this.hasGarbage = false;
        }
    }

    @Override
    public void move(List<Point_> path) {

        ArrayList<Bin> bins = getBins();
        for (int i = 0; i < bins.size(); ++i) {
            if(bins.get(i).distance(this) < 3) {
                updateMood(-10);
            }
            System.out.printf("MOODE CHANGED BY BIN PROX");
        }

        int n = path.size();
        for (Point_ point_ : path) {
            throwGarbage();
            GameFrame.bg.repaint();
            wait(500);
            setX(point_.getX() + 1);
            setY(point_.getY() + 1);
        }
        currentlyMoving = false;
    }

    public void updateMood(int changeBy) {
        mood += changeBy;
    }

    public void setHasGarbage(boolean hasGarbage) {
        this.hasGarbage = hasGarbage;
    }

    public void buyTicket(int price) {
        super.changeParkBudgetBy(price);
    }


    @Override
    public String getClassString() {
        return "Visitor";
    }

}
