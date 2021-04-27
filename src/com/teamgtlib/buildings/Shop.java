package com.teamgtlib.buildings;

import com.teamgtlib.NPCs.Visitor;
import com.teamgtlib.Park;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.UIPanel;

public class Shop extends Building {

    public static int COST_PRICE = 15000;
    private int usageCost;

    public Shop(int x, int y) {
        super(x, y);
        price = COST_PRICE;
        height = 2;
        width = 2;
        usageCost = UIPanel.getPriceSliderValue();
        System.out.println("SHOP USAGE COST: " + usageCost);
    }

    public void sellFood(Visitor obj){
        obj.updateMood(10);
        Park.player.changeBudgetBy(usageCost);
        obj.setHasGarbage(true);
        GameFrame.GameFrameStatusPanel.repaint();
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
