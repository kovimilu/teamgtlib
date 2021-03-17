package com.teamgtlib;

import com.teamgtlib.Buildings.*;
import com.teamgtlib.NPCs.NPC;
import java.awt.*;
import java.util.ArrayList;

public class Park implements Drawable {
    public static Image image;
    public static ArrayList<Building> buildings;
    public static Player player;
    public static ArrayList<NPC> npcs;
    public static ArrayList<Road> roads;

    public Park(){
        player = new Player();
    }

    public void build(int x, int y , String type, DecorType dtype, RideType rtype)
    {
        Building building = null;
        if (type == "Bin") building = new Bin(0, 0);
        if (type == "Shop")building = new Shop(0,0);
        if (type == "Road")building = new Road(0,0);



        buildings.add(building);
        player.updateBudget( -building.getPrice());
    }

    @Override
    public void draw() {
        //TODO
    }
}
