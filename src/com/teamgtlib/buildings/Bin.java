package com.teamgtlib.buildings;

import com.teamgtlib.Park;

public class Bin extends Building {
    private static final int MAXBINS = 5;
    public static int currentBin = 0;
    public static int COST_PRICE = 500;

    public Bin(int x, int y) {
        super(x, y);
        price = COST_PRICE;
        if(currentBin > MAXBINS); //TODO throw exception
        else
        {
            currentBin++;
            this.moodValue = -25;
        }
    }

    @Override
    public String toString() {
        return "Bin";
    }

    /**
     *
     * @param obj Buildging
     * Removes the obj from the building container.
     */
    @Override
    public void close(Building obj) {
        Park.buildings.remove(obj);
        if(currentBin > MAXBINS) currentBin--;
    }

    @Override
    public String getClassImagePath() {
        return "res/Bin.png";
    }
}