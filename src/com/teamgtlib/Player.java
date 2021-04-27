package com.teamgtlib;

import com.teamgtlib.NPCs.Cleaner;
import com.teamgtlib.NPCs.Maintenance;

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
        workerCount++;
    }

    public void hireCleaner() {
        Cleaner c = new Cleaner();
        workerCount++;
    }

    public void fireMaintenance(){
        int n = Park.npcs.size();
        System.out.printf("npc arraylist:" + String.valueOf(n));
        for (int i = 0; i < n; ++i)
        {
            //System.out.printf(Park.npcs.get(i).getClassString());
            if(Park.npcs.get(i).getClassString().equals("Maintenance")) {
                Park.npcs.get(i).leave();
                Park.npcs.remove(Park.npcs.get(i));
                break;
            }
        }
    }

    public void fireCleaner(){
        int n = Park.npcs.size();
        System.out.printf("npc arraylist:" + String.valueOf(n));
        for (int i = 0; i < n; ++i)
        {
            //System.out.printf(Park.npcs.get(i).getClassString());
            if(Park.npcs.get(i).getClassString().equals("Cleaner")) {
                Park.npcs.get(i).leave();
                Park.npcs.remove(Park.npcs.get(i));
                break;
            }
        }
    }

    public void replaceWorker(){
        //TODO később
    }

    public void changeBudgetBy(int budget) {
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


