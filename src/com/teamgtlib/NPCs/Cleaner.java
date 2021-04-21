package com.teamgtlib.NPCs;

import com.teamgtlib.Park;

public class Cleaner extends Worker {

    public Cleaner() {
        super(10,13);
        x = 10;
        y = 13;
        wage = 435;
        Park.npcs.add(this);
    }

    @Override
    public void whatToDo() {

    }

    public void clean() {

    }

    @Override
    public String getClassString() {
        return "Cleaner";
    }
}
