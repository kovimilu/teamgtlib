package com.teamgtlib.Buildings;

public class Decor extends Building {
    private final DecorType type;

    public Decor(int x, int y, DecorType type) {
        super(x, y);
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
        }
    }

    public DecorType getType() {
        return type;
    }
}
