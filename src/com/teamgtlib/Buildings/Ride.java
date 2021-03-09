package com.teamgtlib.Buildings;

import com.teamgtlib.NPCs.Visitor;
import java.util.ArrayList;

public class Ride extends Building {
    private BuildingState state = BuildingState.UNBUILT;
    private int durability;
    private final int MAXCAP;
    private int currentCap;
    private final RideType type;
    private ArrayList<Visitor> queue;

    public Ride(int x, int y, RideType type) {
        this.x = x;
        this.y = y;
        this.type = type;

        switch (type) { // TODO the rest of the cases
            case CAROUSEL -> {
                MAXCAP = 50;
                price = 70000;
                moodValue = 30;
                width = 3;
                height = 3;
            }
            case DODGEM -> {
                MAXCAP = 0;
            }
            case FERRISWHEEL -> {
                MAXCAP = 0;
            }
            case ROLLERCOASTER -> {
                MAXCAP = 0;
            }
            case WATERSLIDE -> {
                MAXCAP = 0;
            }
            default -> {
                // TODO throw exception
                MAXCAP = 0;
                price = 0;
                moodValue = 0;
                width = 0;
                height = 0;
            }
        }
    }

    @Override
    public void draw() {

    }

    public void use(Visitor user) {

    }
}
