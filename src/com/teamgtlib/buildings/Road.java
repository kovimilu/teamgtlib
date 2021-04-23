package com.teamgtlib.buildings;

public class Road extends Building {
    private int x;
    private int y;
    public static int COST_PRICE = 1000;
    private boolean garbageLocations = false;
    private boolean visited;

    public Road(int x, int y){
      super(x,y);
      width = 1;
      height = 1;
      price = COST_PRICE;
      visited = false;
    }

    public void setgarbageLocations() {
        garbageLocations = true;
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

    public void setVisited (boolean visited){
        this.visited = visited;
    }

    public boolean getVisited(){
        return this.visited;
    }
}
