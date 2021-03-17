package com.teamgtlib;

import com.teamgtlib.Buildings.*;
import com.teamgtlib.NPCs.NPC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
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
    public void draw() throws IOException {
        String[] classNameSplit = getClass().toString().split("\\.", 0);
        Park.image = ImageIO.read(new FileInputStream(
                "res/" + classNameSplit[classNameSplit.length - 1] + ".png"));
    }
}
