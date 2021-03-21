package com.teamgtlib.Buildings;

public class Road extends Building {
    private int x;
    private int y;
    public static int COST_PRICE = 1000;
    private int[] garbageLocations;

    public Road(int x, int y){
      super(x,y);
      price = COST_PRICE;
    }

    private void cleaned(){
        //TODO később
    }

    @Override
    public void loadClassImage() {
        //TODO
    }

    @Override
    public String toString() {
        return "Road";
    }

    @Override
    public String getClassImagePath() {
        return "res/Road.png";
    }
}
