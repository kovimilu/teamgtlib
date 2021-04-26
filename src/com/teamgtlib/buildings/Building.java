package com.teamgtlib.buildings;

import com.teamgtlib.Drawable;
import com.teamgtlib.Park;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.GridUtils;
import com.teamgtlib.gui.PlayAreaPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;

public abstract class Building implements Drawable {
    final int x;
    final int y;
    int width;
    int height;
    int price;
    int moodValue;
    BuildingState state;

    Building(int x, int y) {
        this.x = x;
        this.y = y;
        this.state = BuildingState.BUILT;
    }

    /**
     *
     * @param obj Buildging
     * Removes the obj from the building container.
     */
    public void close(Building obj) {
        Park.buildings.remove(obj);
    }

    @Override
    public void loadClassImage() throws IOException {
        String[] classNameSplit = getClass().toString().split("\\.", 0);
        Park.image = ImageIO.read(new FileInputStream(
                "res/" + classNameSplit[classNameSplit.length - 1] + ".png"));
    }

    public Point whereAmI() {
        Point p = new Point(this.x,this.y);
        return p;
    }

    public abstract String getClassImagePath();

    public String getBuildImagePath(){
        return "res/Worker.png";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Building)) {
            return false;
        }
        Building b = (Building) o;
        return x == b.x && y == b.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getPoints() {
        Point p = new Point(this.x, this.y);
        return p;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public int getMoodValue() {
        return moodValue;
    }

    public void setState(BuildingState state){
        this.state = state;
    }

    public BuildingState getState(){
        return this.state;
    };
}