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
    public static Player player = null;
    public static ArrayList<NPC> npcs;

    public Park(){

        player = new Player();
        buildings = new ArrayList<>();
    }

    //TODO This has to be done ASAP
    public void build(int x, int y , Buildable type)
    {
        Building building = type.createObj(x,y);
        player.updateBudget(- building.getPrice());
        buildings.add(building);
        System.out.println(building.toString());

    }

    public void buildTest(int x, int y , String type)
    {
        Building building = new Bin(x,y);
        if (type == "Bin") building = new Bin(x,y);

        this.buildings.add(building); //TODO Building is null WHY?
        player.updateBudget( -building.getPrice());
    }

    //TODO FIX:
    @Override
    public void draw() throws IOException {
        String[] classNameSplit = getClass().toString().split("\\.", 0);
        Park.image = ImageIO.read(new FileInputStream(
                "res/" + classNameSplit[classNameSplit.length - 1] + ".png"));
    }
}
