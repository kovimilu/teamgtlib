package com.teamgtlib;

import com.teamgtlib.NPCs.NPC;
import com.teamgtlib.buildings.Buildable;
import com.teamgtlib.buildings.Building;

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

    /**
     *
     * @param x x Coordinate of the Building
     * @param y y Coordinate of the Building
     * @param type Buildable Enum
     * @return Returns a Building type so that you can call it's methods.
     */
    public static Building preBuild(Buildable type) {
        Building preBuiltbuilding = type.createObj(0,0);
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
