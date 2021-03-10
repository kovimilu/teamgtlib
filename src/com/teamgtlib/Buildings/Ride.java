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
        this.x      = x;
        this.y      = y;
        this.type   = type;

        switch (type) {
            case CAROUSEL -> {
                MAXCAP      = RideConstants.CAROUSEL_MAXCAP;
                price       = RideConstants.CAROUSEL_PRICE;
                moodValue   = RideConstants.CAROUSEL_MOODVALUE;
                width       = RideConstants.CAROUSEL_WIDTH;
                height      = RideConstants.CAROUSEL_HEIGHT;
            }
            case DODGEM -> {
                MAXCAP      = RideConstants.DODGEM_MAXCAP;
                price       = RideConstants.DODGEM_PRICE;
                moodValue   = RideConstants.DODGEM_MOODVALUE;
                width       = RideConstants.DODGEM_WIDTH;
                height      = RideConstants.DODGEM_HEIGHT;
            }
            case FERRISWHEEL -> {
                MAXCAP      = RideConstants.FERRISWHEEL_MAXCAP;
                price       = RideConstants.FERRISWHEEL_PRICE;
                moodValue   = RideConstants.FERRISWHEEL_MOODVALUE;
                width       = RideConstants.FERRISWHEEL_WIDTH;
                height      = RideConstants.FERRISWHEEL_HEIGHT;
            }
            case ROLLERCOASTER -> {
                MAXCAP      = RideConstants.ROLLERCOASTER_MAXCAP;
                price       = RideConstants.ROLLERCOASTER_PRICE;
                moodValue   = RideConstants.ROLLERCOASTER_MOODVALUE;
                width       = RideConstants.ROLLERCOASTER_WIDTH;
                height      = RideConstants.ROLLERCOASTER_HEIGHT;
            }
            case WATERSLIDE -> {
                MAXCAP      = RideConstants.WATERSLIDE_MAXCAP;
                price       = RideConstants.WATERSLIDE_PRICE;
                moodValue   = RideConstants.WATERSLIDE_MOODVALUE;
                width       = RideConstants.WATERSLIDE_WIDTH;
                height      = RideConstants.WATERSLIDE_HEIGHT;
            }
            default -> {
                // TODO throw exception
                MAXCAP      = 0;
                price       = 0;
                moodValue   = 0;
                width       = 0;
                height      = 0;
            }
        }
    }

    public void use(Visitor user) {

    }
}
