package com.teamgtlib.Buildings;

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

            //Park.buildings.add(//Self)
        }
    }

    @Override
    public String toString() {
        return "Bin";
    }

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
