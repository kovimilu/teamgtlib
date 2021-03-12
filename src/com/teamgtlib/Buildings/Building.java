package com.teamgtlib.Buildings;

import com.teamgtlib.Drawable;
import com.teamgtlib.Park;

import javax.imageio.ImageIO;
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

    public void close(Building obj) {
        Park.container_building.remove(obj);
    }

    /**
     * Determens the type of the Class then reads in the corresponding image.
     */
    @Override
    public void draw() throws IOException {
        String className = getClass().toString();
        String[] classNameSplit = className.split("\\.", 0);
        className = classNameSplit[classNameSplit.length - 1] + ".png";
        System.out.println(className);
        //TODO Park.image = ImageIO.read(getClass().getResource(className));
    }
}