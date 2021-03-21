package com.teamgtlib.Buildings;

import java.io.IOException;

public class Road extends Building {
    private int x;
    private int y;
    public static int COST_PRICE = 1000;
    private int[] garbageLocations;

    public Road(int x, int y){
      super(x,y);
      this.price = this.COST_PRICE;
    }

    private void cleaned(){
        //TODO később
    }

    @Override
    public void draw() throws IOException {
        //TODO
    }

    @Override
    public String toString() {
        return "Road";
    }

}
