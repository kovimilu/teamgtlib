package com.teamgtlib.Buildings;

public class Decor extends Building {
    private final DecorType type;

    public Decor(int x, int y, DecorType type) {
        this.x      = x;
        this.y      = y;
        this.type   = type;

        switch (type) {
            case BENCH -> {
                price       = DecorConstants.BENCH_PRICE;
                moodValue   = DecorConstants.BENCH_MOODVALUE;
                width       = DecorConstants.BENCH_WIDTH;
                height      = DecorConstants.BENCH_HEIGHT;
            }
            case TREE -> {
                price       = DecorConstants.TREE_PRICE;
                moodValue   = DecorConstants.TREE_MOODVALUE;
                width       = DecorConstants.TREE_WIDTH;
                height      = DecorConstants.TREE_HEIGHT;
            }
            case BUSH -> {
                price       = DecorConstants.BUSH_PRICE;
                moodValue   = DecorConstants.BUSH_MOODVALUE;
                width       = DecorConstants.BUSH_WIDTH;
                height      = DecorConstants.BUSH_HEIGHT;
            }
            default -> {
                // TODO throw exception
                price       = 0;
                moodValue   = 0;
                width       = 0;
                height      = 0;
            }
        }
    }

    public DecorType getType() {
        return type;
    }
}
