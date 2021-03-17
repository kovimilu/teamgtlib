package com.teamgtlib.Buildings;

public class DecorConstants {
    // Same reaseon as in RideConstansts
    public static final int DCA[][] = new int[3][3];
    public DecorConstants() {
            DCA[0][0] = BENCH_PRICE;
            DCA[1][0] = BUSH_PRICE;
            DCA[2][0] = TREE_PRICE;
    }

    // TODO: fill with values
    public static final int BENCH_PRICE     = 5000;
    public static final int BENCH_MOODVALUE = 10;
    public static final int BENCH_WIDTH     = 2;
    public static final int BENCH_HEIGHT    = 1;

    public static final int BUSH_PRICE     = 1500;
    public static final int BUSH_MOODVALUE = 2;
    public static final int BUSH_WIDTH     = 1;
    public static final int BUSH_HEIGHT    = 1;

    public static final int TREE_PRICE     = 3550;
    public static final int TREE_MOODVALUE = 5;
    public static final int TREE_WIDTH     = 1;
    public static final int TREE_HEIGHT    = 1;
}
