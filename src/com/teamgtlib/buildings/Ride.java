package com.teamgtlib.buildings;

import com.teamgtlib.NPCs.Visitor;

import java.util.ArrayList;

public class Ride extends Building {
    private BuildingState state = BuildingState.UNBUILT;
    private int durability;
    private int MAXCAP;
    private ArrayList<Visitor> currentPassengers;
    private final RideType type;
    private ArrayList<Visitor> queue; // bármennyien lehetnek benne, de csak x másodpercenként (next) 1 ember ülhet fel

    /**
     *
     * @param x int
     * @param y int
     * @param type DecorType
     * Creates a Ride object according to the type parameter.
     */
    public Ride(int x, int y, RideType type) {
        super(x, y);
        this.type = type;

        switch (type) {
            case CAROUSEL -> {
                MAXCAP = RideConstants.CAROUSEL_MAXCAP;
                price = RideConstants.CAROUSEL_PRICE;
                moodValue = RideConstants.CAROUSEL_MOODVALUE;
                width = RideConstants.CAROUSEL_WIDTH;
                height = RideConstants.CAROUSEL_HEIGHT;
            }
            case CASTLE -> {
                MAXCAP = RideConstants.DODGEM_MAXCAP;
                price = RideConstants.DODGEM_PRICE;
                moodValue = RideConstants.DODGEM_MOODVALUE;
                width = RideConstants.DODGEM_WIDTH;
                height = RideConstants.DODGEM_HEIGHT;
            }
            case FERRISWHEEL -> {
                MAXCAP = RideConstants.FERRISWHEEL_MAXCAP;
                price = RideConstants.FERRISWHEEL_PRICE;
                moodValue = RideConstants.FERRISWHEEL_MOODVALUE;
                width = RideConstants.FERRISWHEEL_WIDTH;
                height = RideConstants.FERRISWHEEL_HEIGHT;
            }
            case ROLLERCOASTER -> {
                MAXCAP = RideConstants.ROLLERCOASTER_MAXCAP;
                price = RideConstants.ROLLERCOASTER_PRICE;
                moodValue = RideConstants.ROLLERCOASTER_MOODVALUE;
                width = RideConstants.ROLLERCOASTER_WIDTH;
                height = RideConstants.ROLLERCOASTER_HEIGHT;
            }
            case WATERSLIDE -> {
                MAXCAP = RideConstants.WATERSLIDE_MAXCAP;
                price = RideConstants.WATERSLIDE_PRICE;
                moodValue = RideConstants.WATERSLIDE_MOODVALUE;
                width = RideConstants.WATERSLIDE_WIDTH;
                height = RideConstants.WATERSLIDE_HEIGHT;
            }
        }
    }

    public void next() {
        // queue-ból szed ki legfeljebb MAXCAP-nyi Visitor-t, majd meghívja a startRide()-ot
    }

    private void startRide() {
        /* TODO
        ha timer letelt, vagy teli a Ride kapacitás,
         akkor start timer
         ha elég az ember, ezt hívja meg a next
         */

    }

    private void stopRide() {
        /* TODO
        cap-ból kiveszi az embereket
        számértékek hozzáadása
         */
        for (Visitor passenger : currentPassengers) {
            passenger.updateMood(0);
        }
        durability -= 0;
    }

    private void timer() {

    }

    @Override
    public String toString() {
        return "Ride" + " " + type;
    }

    @Override
    public String getClassImagePath() {
        switch (type) {
            case CAROUSEL -> {
                return "res/Carousel.png";
            }
            case CASTLE -> {
                return "res/Castle.png";
            }
            case FERRISWHEEL -> {
                return "res/Ferriswheel.png";
            }
            case ROLLERCOASTER -> {
                return "res/Rollercoaster.png";
            }
            case WATERSLIDE -> {
                return "res/Waterslide.png";
            }
        }
        return null;
    }

    public int getDurability() {
        return durability;
    }
}
