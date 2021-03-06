package com.teamgtlib;

import com.teamgtlib.NPCs.NPC;
import com.teamgtlib.NPCs.Visitor;
import com.teamgtlib.buildings.*;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.GridUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class Park implements Drawable {
    public static Image image;
    public static ArrayList<Building> buildings;
    public static Player player = null;
    public static volatile ArrayList<NPC> npcs;
    public static int MAXVISITORS = 5; // just to see it works
    public static ArrayList<Point> garbage = new ArrayList<>();

    /**
     * Create the park with one new player and building container.
     * @throws IOException
     */
    public Park() throws IOException {
        buildings = new ArrayList<>();
        npcs = new ArrayList<>();
        player = new Player();
        this.loadClassImage();
        initBuildings();
        //initVisitors();
        timer();
        //System.out.printf(buildingsToString());
    }

    Timer t = new java.util.Timer();
    public void timer() {
        t.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                if(player.getVisitorCount() < MAXVISITORS){
                    initVisitors();
                    GameFrame.bg.repaint();
                }
            }
        }, 50, 5000);
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

            if (updateBudget) player.setBudget(newBudget);
            buildings.add(building);

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

    public String buildingsToString() { // for debugging
        return buildings.toString();
    }

    private void initBuildings() {
        initBuildHelper(10, 14, BuildingType.ROAD);
        initBuildHelper(10, 13, BuildingType.ROAD);
        initBuildHelper(10, 12, BuildingType.ROAD);
        initBuildHelper(10, 11, BuildingType.ROAD);
        initBuildHelper(10, 10, BuildingType.ROAD);
        initBuildHelper(10, 9, BuildingType.ROAD);
        initBuildHelper(10, 8, BuildingType.ROAD);
        initBuildHelper(10, 7, BuildingType.ROAD);
        initBuildHelper(10, 6, BuildingType.ROAD);
        initBuildHelper(10, 5, BuildingType.ROAD);
        initBuildHelper(11, 11, BuildingType.ROAD);
        initBuildHelper(12, 11, BuildingType.ROAD);

        initBuildHelper(9, 9, BuildingType.ROAD);
        initBuildHelper(8, 9, BuildingType.ROAD);
        initBuildHelper(6, 9, BuildingType.ROAD);
        initBuildHelper(5, 9, BuildingType.BIN);

        initBuildHelper(11, 8, BuildingType.ROAD);
        initBuildHelper(11, 9, DecorType.BUSH);

        initBuildHelper(9, 5, BuildingType.ROAD);
        initBuildHelper(8, 5, BuildingType.ROAD);
        initBuildHelper(8, 8, DecorType.BENCH);

        initBuildHelper(7, 9, BuildingType.ROAD);
        initBuildHelper(7, 8, BuildingType.ROAD);
        initBuildHelper(7, 7, BuildingType.ROAD);
        initBuildHelper(7, 6, BuildingType.ROAD);
        initBuildHelper(7, 5, BuildingType.ROAD);


        initBuildHelper(11, 5, RideType.CASTLE);

        initBuildHelper(11, 10, DecorType.BENCH);
        initBuildHelper(8, 10, BuildingType.SHOP);
        initBuildHelper(13, 10, DecorType.BUSH);
        initBuildHelper(9, 13, DecorType.TREE);
        initBuildHelper(11, 13, DecorType.TREE);

    }

    private void initBuildHelper(int x, int y, Buildable type) {
        Building building = null;
        try {
            building = build(x, y, type, false);
        } catch (GameException exception) {
            exception.printStackTrace();
        }
        GridUtils.addGridMap(new Point(building.getX(), building.getY()), BuildingType.ROAD);
    }

    private void initVisitors() {
        Visitor v = new Visitor();
    }
}
