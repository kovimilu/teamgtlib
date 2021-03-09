package com.teamgtlib.Buildings;

import com.teamgtlib.Drawable;

/**
 * @author Kovacs Milan
 * @version 0.2
 * @since 2021.03.05
 */
abstract public class Building implements Drawable {
    int Area;
    int side_a, side_b;
    int x;
    int y;
    int price;
    int moodValue;

    protected Building() {}

    public Building(int x, int y) {
        this.x = x;
        this.y = y;
        //TODO
    }

}