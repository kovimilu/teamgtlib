package com.teamgtlib.Buildings;

import com.teamgtlib.NPCs.Visitor;

public class Shop extends Building {
    public static int COST_PRICE = 15000;
    public Shop(int x, int y) {
        super(x, y);
        this.price = this.COST_PRICE;
    }

    public void sellFood(Visitor obj){

    }
}
