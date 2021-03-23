package com.teamgtlib.buildings;

import com.teamgtlib.NPCs.Visitor;

public class Shop extends Building {

    public static int COST_PRICE = 15000;

    public Shop(int x, int y) {
        super(x, y);
        price = COST_PRICE;
        height = 2;
        width = 2;
    }

    public void sellFood(Visitor obj){
        //TODO Requires Visitors Class
    }

    @Override
    public String toString() {
        return "Shop";
    }

    @Override
    public String getClassImagePath() {
        return "res/Shop.png";
    }
}
