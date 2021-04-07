package com.teamgtlib.buildings;

import com.teamgtlib.Drawable;
import com.teamgtlib.Park;
import com.teamgtlib.gui.GridUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class Building implements Drawable {
    final int x;
    final int y;
    int width;
    int height;
    int price;
    int moodValue;

    Building(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
}