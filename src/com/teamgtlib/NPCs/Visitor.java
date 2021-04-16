package com.teamgtlib.NPCs;
import java.util.Random;

public class Visitor extends NPC {
    private int mood;
    private boolean hasGarbage;

    Random rand = new Random();

    public Visitor() {
        x = 1;  //TODO bejárathoz
        y = 1;
        mood = rand.nextInt(30) + 45; //45-75
        hasGarbage = false;
    }

    @Override
    public void whatToDo() {

    }

    public void updateMood(int changeBy) {
        mood += changeBy;
    }

    public void buysFood() {
        updateMood(10);
        hasGarbage = true;
    }

    public void buysTicket() {

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
