package com.teamgtlib.buildings;

import com.teamgtlib.NPCs.Visitor;
import com.teamgtlib.Park;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.PlayAreaPanel;
import com.teamgtlib.gui.UIPanel;

import java.util.*;

import static java.lang.Math.min;

public class Ride extends Building {
    private BuildingState state = BuildingState.UNBUILT;
    private int durability;
    private int MAXCAP;
    private volatile List<Visitor> currentPassengers = Collections.synchronizedList(new ArrayList<>());
    private final RideType type;
    static public ArrayList<Visitor> queue = new ArrayList<>(); // bármennyien lehetnek benne, de csak x másodpercenként (next) 1 ember ülhet fel
    private int usageCost;

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
        usageCost = UIPanel.getPriceSliderValue();
        durability = 100;
        // if (usageCost == 0) usageCost = 5;
        System.out.println("RIDE USAGE COST:" + usageCost);

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
        timer();
    }

    public void timer(){
        Timer t = new java.util.Timer();
        t.schedule(new java.util.TimerTask() {
                       @Override
                       public void run() {
                           setState(BuildingState.BUILT);
                           GameFrame.bg.repaint();
                           t.cancel();
                       }
                   },5000
        );
    }

    public synchronized void start() {
        // queue-ból szed ki legfeljebb MAXCAP-nyi Visitor-t, majd meghívja a startRide()-ot
        if (!queue.isEmpty()) {
            int n = min(MAXCAP, queue.size());
            for (int i = 0; i < n; i++) {
                //System.out.printf(String.valueOf(queue));
                queue.get(i).buyTicket(usageCost);
                PlayAreaPanel.refreshLabelText();
                Visitor boardingPassenger = queue.remove(i);
                //System.out.printf(String.valueOf(boardingPassenger));

                //boardingPassenger.buyTicket(usageCost);
                System.out.print(Park.player.getBudget());
                currentPassengers.add(boardingPassenger);
            }
            startRide();
        }
    }

    private synchronized void startRide() {
        /*
        ha timer letelt, vagy teli a Ride kapacitás,
         akkor start timer
         ha elég az ember, ezt hívja meg a next
         */
        Timer timer = new java.util.Timer();
        timer.schedule(new java.util.TimerTask() {
                       @Override
                       public void run() {
                           rideEnded();
                           timer.cancel();
                       }
                   },5000 // TODO edit to actual value
        );
    }

    private synchronized void rideEnded() {
        /*
        cap-ból kiveszi az embereket
        számértékek hozzáadása
         */
        for (Visitor passenger : currentPassengers) {
            currentPassengers.remove(passenger);
            passenger.updateMood(moodValue);
        }
        this.durability -= 30; // TODO fill with value (maybe add to constants per ride type)
        GameFrame.bg.repaint();
        start();
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

    public void repairedDurability(int repairedBy) {
        this.durability += repairedBy;
    }

    public synchronized void addToQueue(Visitor visitor) {
        System.out.println("\nQUEUESIZE " + queue.size()); queue.add(visitor); }

    public synchronized void addToQueue(Visitor[] visitors) { queue.addAll(Arrays.asList(visitors)); }

    public int getQueueSize() { return queue.size(); }

    public void setState(BuildingState state) { this.state = state; }

    public BuildingState getState() { return state; }

    public ArrayList<Visitor> getCurrentPassengers() { return (ArrayList<Visitor>) currentPassengers; }

    public ArrayList<Visitor> getQueue() { return queue; }
}
