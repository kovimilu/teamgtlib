package com.teamgtlib.buildings;

public class RideConstants {
    // Had to make an Array that contains the Prices to make the GUI generation easier.
    public static final int RCA[][] = new int[5][5];
    public RideConstants() {
        RCA[0][1] = CAROUSEL_PRICE;
        RCA[1][1] = DODGEM_PRICE;
        RCA[2][1] = WATERSLIDE_PRICE;
        RCA[3][1] = FERRISWHEEL_PRICE;
        RCA[4][1] = ROLLERCOASTER_PRICE;
    }

    public static final int CAROUSEL_MAXCAP         = 30;
    public static final int CAROUSEL_PRICE          = 55000;
    public static final int CAROUSEL_MOODVALUE      = 25;
    public static final int CAROUSEL_WIDTH          = 2;
    public static final int CAROUSEL_HEIGHT         = 2;

    public static final int DODGEM_MAXCAP           = 20;
    public static final int DODGEM_PRICE            = 90000;
    public static final int DODGEM_MOODVALUE        = 40;
    public static final int DODGEM_WIDTH            = 2;
    public static final int DODGEM_HEIGHT           = 3;

    public static final int WATERSLIDE_MAXCAP       = 15;
    public static final int WATERSLIDE_PRICE        = 145000;
    public static final int WATERSLIDE_MOODVALUE    = 25;
    public static final int WATERSLIDE_WIDTH        = 2;
    public static final int WATERSLIDE_HEIGHT       = 2;

    public static final int FERRISWHEEL_MAXCAP      = 50;
    public static final int FERRISWHEEL_PRICE       = 70000;
    public static final int FERRISWHEEL_MOODVALUE   = 30;
    public static final int FERRISWHEEL_WIDTH       = 3;
    public static final int FERRISWHEEL_HEIGHT      = 3;

    public static final int ROLLERCOASTER_MAXCAP    = 10;
    public static final int ROLLERCOASTER_PRICE     = 200000;
    public static final int ROLLERCOASTER_MOODVALUE = 50;
    public static final int ROLLERCOASTER_WIDTH     = 3;
    public static final int ROLLERCOASTER_HEIGHT    = 2;
}