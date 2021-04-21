package com.teamgtlib.NPCs;
import com.teamgtlib.Park;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Visitor extends NPC {
    private int mood; // TODO maybe add default value
    private boolean hasGarbage;
    public ArrayList<Point> path;

    Random rand = new Random();

    public Visitor() {
        path = new ArrayList<>();
        x = 10;  //TODO bejárathoz
        y = 10;
        //mood = rand.nextInt(30) + 45; //45-75
        mood = 10;
        hasGarbage = false;
        Park.npcs.add(this);
        updata();
    }

    private void updata() {
        whatToDo();
        timer(path);
        for(int i = 0; i < path.size(); ++i)
        {
            System.out.printf(path.get(i) + " ");
        }
    }

    @Override
    public void whatToDo() {
        /*
        initBuildHelper(10, 14, BuildingType.ROAD);
        initBuildHelper(9, 13, DecorType.TREE);
        initBuildHelper(11, 13, DecorType.TREE);
        initBuildHelper(10, 13, BuildingType.ROAD);
        initBuildHelper(10, 12, BuildingType.ROAD);
        initBuildHelper(10, 11, BuildingType.ROAD);
        initBuildHelper(11, 11, BuildingType.ROAD);
        initBuildHelper(12, 11, BuildingType.ROAD);
        initBuildHelper(10, 10, BuildingType.ROAD);
        initBuildHelper(11, 10, DecorType.BENCH);
        initBuildHelper(8, 10, BuildingType.SHOP);
        initBuildHelper(13, 10, DecorType.BUSH);
        initBuildHelper(10, 9, BuildingType.ROAD);
        initBuildHelper(10, 8, BuildingType.ROAD);
        initBuildHelper(10, 7, BuildingType.ROAD);
        * */
        pathFinding(Park.playAreaPanel[10][7],Park.playAreaPanel,path,x,y);
        //if(mood < 20) pathFinding(Park.playAreaPanel[6][10],Park.playAreaPanel, path,this.getX() -1,this.getY()-1);
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
