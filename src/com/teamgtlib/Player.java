package com.teamgtlib;

import com.teamgtlib.NPCs.Maintenance;
import com.teamgtlib.NPCs.Visitor;

public class Player {
    private int budget;
    private int visitorCount;
    private int workerCount;

    Player(){
        budget = 1000000;
    }

    public void hireMaintenance() {
        Maintenance m = new Maintenance();
        Park.npcs.add(m);
    }

    public void fireWorker(){
        //TODO később
    }

    public void replaceWorker(){
        //TODO később
    }

    public void updateBudget(int budget) {
        this.budget += budget;
    }

    public int getBudget() {
        return budget;
    }

    public void updateVisitorCount(int visitorCount) {
        this.visitorCount += visitorCount;
    }

    public void updateWorkerCount(int workerCount) {
        this.workerCount += workerCount;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }
}


