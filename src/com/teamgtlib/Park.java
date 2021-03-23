package com.teamgtlib;

import com.teamgtlib.Buildings.Buildable;
import com.teamgtlib.Buildings.Building;
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

    public Park() throws IOException {
        player = new Player();
        buildings = new ArrayList<>();
        this.loadClassImage();
    }

    public Boolean build(int x, int y , Buildable type) throws GameException { /* returns whether the build succeeded */
        Building building = type.createObj(x,y);
        final int newBudget = player.getBudget() - building.getPrice();
        if (newBudget >= 0) {
            player.setBudget(newBudget);
            buildings.add(building);
            return true;
        }
        else {
            throw new GameException("Not enough budget!");
        }
    }

    public static Building preBuild(int x, int y , Buildable type) {
        Building preBuiltbuilding = type.createObj(x,y);
        return preBuiltbuilding;
    }

    @Override
    public void loadClassImage() throws IOException {
        String[] classNameSplit = getClass().toString().split("\\.", 0);
        Park.image = ImageIO.read(new FileInputStream(
                "res/" + classNameSplit[classNameSplit.length - 1] + ".png"));
    }

    public String buildingsToString() { // for debugging
        return buildings.toString();
    }
}
