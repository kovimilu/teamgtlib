package com.teamgtlib.Buildings;

import com.teamgtlib.Drawable;

import java.awt.*;
import java.io.IOException;

public class Road implements Drawable {
    private int x;
    private int y;
    private static final int price = 1000;
    private int[] garbageLocations;
    private Image image;

    public Road(int x, int y){
        this.x = x;
        this.y = y;
    }

    private void cleaned(){
        //TODO később
    }

    @Override
    public void draw() throws IOException {
        //TODO
    }

    public int getPrice(){
        return this.price;
    }

}
