package com.teamgtlib;

import com.teamgtlib.NPCs.NPC;
import com.teamgtlib.buildings.Buildable;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.buildings.BuildingType;
import com.teamgtlib.buildings.DecorType;
import com.teamgtlib.gui.GridUtils;

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
    public static Building[][] playAreaPanel;

    /**
     * Create the park with one new player and building container.
     * @throws IOException
     */
    public Park() throws IOException {
        buildings = new ArrayList<>();
        playAreaPanel = new Building[14][20];
        npcs = new ArrayList<>();
        player = new Player();
        this.loadClassImage();
        initBuildings();
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
    public Building build(int x, int y , Buildable type, boolean updateBudget) throws GameException { /* returns whether the build succeeded */
        Building building = type.createObj(x,y);
        final int newBudget = player.getBudget() - building.getPrice();
        if (newBudget >= 0) {

            for (int i = 0; i<building.getHeight(); i++) {
                for (int j = 0; j < building.getWidth(); j++) {
                    if (playAreaPanel[y / 50 + i][x / 50 + j] != null) {
                        throw new GameException("Not an empty space!");
                    }
                    playAreaPanel[y / 50 + i][x / 50 + j] = building;
                }
            }

            if (updateBudget) player.setBudget(newBudget);
            buildings.add(building);


            //map of the playAreaPanel (for debug)
            /*for(int i = 0; i<14; i++){
                for(int j = 0; j<20; j++){
                    System.out.print(playAreaPanel[i][j] + " ");
                }
                System.out.println();
            }*/

            return building;
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
        return type.createObj(0,0);
    }

    @Override
    public void loadClassImage() throws IOException {
        String[] classNameSplit = getClass().toString().split("\\.", 0);
        Park.image = ImageIO.read(new FileInputStream(
                "res/" + classNameSplit[classNameSplit.length - 1] + ".png"));
    }

    public Building[][] getPlayAreaPanel(){
        return playAreaPanel;
    }

    public String buildingsToString() { // for debugging
        return buildings.toString();
    }

    private void initBuildings() {
        initBuildHelper(10, 14, BuildingType.ROAD);
        initBuildHelper(9, 13, DecorType.TREE);
        initBuildHelper(11, 13, DecorType.TREE);
        initBuildHelper(10, 13, BuildingType.ROAD);
        initBuildHelper(10, 12, BuildingType.ROAD);
        initBuildHelper(10, 11, BuildingType.ROAD);
        initBuildHelper(11, 11, BuildingType.ROAD);
        initBuildHelper(12, 11, BuildingType.ROAD);
        initBuildHelper(10, 10, BuildingType.ROAD);
        initBuildHelper(11, 10, DecorType.BENCH);
        initBuildHelper(8, 10, BuildingType.SHOP);
        initBuildHelper(13, 10, DecorType.BUSH);
        initBuildHelper(10, 9, BuildingType.ROAD);
        initBuildHelper(10, 8, BuildingType.ROAD);
        initBuildHelper(10, 7, BuildingType.ROAD);
    }

    private void initBuildHelper(int x, int y, Buildable type) {
        Building building = null;
        try {
            building = build(GridUtils.gridToPX(x), GridUtils.gridToPX(y), type, false);
        } catch (GameException exception) {
            exception.printStackTrace();
        }
        GridUtils.addGridMap(new Point(building.getX(), building.getY()), BuildingType.ROAD);
    }
}
