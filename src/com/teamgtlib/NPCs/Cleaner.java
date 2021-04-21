package com.teamgtlib.NPCs;

import com.teamgtlib.Park;

public class Cleaner extends Worker {

    public Cleaner() {
        super(10,13);
        x = 10;
        y = 13;
        wage = 435;
        Park.player.changeBudgetBy(-wage);
        Park.npcs.add(this);
    }

    @Override
    public void whatToDo() {
        this.path = pathfinding(this.x,this.y,8,9);
        timer();
    }

    public void clean() {

    }

    @Override
    public String getClassString() {
        return "Cleaner";
    }
}
