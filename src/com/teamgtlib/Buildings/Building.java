package com.teamgtlib.Buildings;

import com.teamgtlib.Drawable;

abstract class Building implements Drawable {
    final int x;
    final int y;
    int width;
    int height;
    int price;
    int moodValue;

    Building(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {

    }
}