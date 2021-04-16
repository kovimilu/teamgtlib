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

    /**
     * Create the park with one new player and building container.
     * @throws IOException
     */
    public Park() throws IOException {
        buildings = new ArrayList<>();
        npcs = new ArrayList<>();
        player = new Player();
        this.loadClassImage();
    }

    /**
     *
     * @param x int
     * @param y int
     * @param type Buildable
     * @return Returns if the player can build a building. If the player can build, the player's budget changes
     *         and the method adds the building to the container.
     * @throws GameException
     */
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
     * @param type Buildable
     * @return @return Returns a Building type so that you can call it's methods.
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
