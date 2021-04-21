package com.teamgtlib.NPCs;

public class Cleaner extends Worker {

    public Cleaner() {
        super(10,10);
        x = 1;
        y = 1;
        wage = 435;
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
