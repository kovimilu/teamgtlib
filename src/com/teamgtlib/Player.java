package com.teamgtlib;

import com.teamgtlib.Buildings.*;
import com.teamgtlib.*;

public class Player {
    private int budget;
    private int visitorCount;
    private int workerCount;

    Player(){
        budget = 10000; // nem tudom mennyi legyen
    }

    public void hireWorker(){
        //TODO később
    }

    public void fireWorker(){
        //TODO később
    }

    public void replaceWorker(){
        //TODO később
    }

    static public void build(int x, int y , Object type)
    {
        Building building;
        building = new Ride(0,0, RideType.CAROUSEL);
        Park.buildings.add(building);
    }



    public Building buildRide(int x, int y, RideType type) throws Exception {
        //TODO exception
        Ride ride =  new Ride(x, y,type);
        budget -= ride.getPrice();
        return ride;
    }

    public Decor buildDecor(int x, int y, DecorType type){
        //TODO exception
        Decor decor = new Decor(x, y, type);
        budget -= decor.getPrice();
        return decor;
    }

    public Shop buildShop(int x, int y){
        //TODO exception
        Shop shop = new Shop(x, y);
        budget -= shop.getPrice();
        return shop;
    }

    public Road buildRoad(int x, int y){
        //TODO exception
        Road road = new Road(x, y);
        budget -= road.getPrice();
        return road;
    }

    public int getBudget() {
        return budget;
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


