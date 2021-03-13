package com.teamgtlib.Buildings;

import com.teamgtlib.Drawable;
import com.teamgtlib.Main;
import com.teamgtlib.Park;

import javax.imageio.ImageIO;
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

    public void close(Building obj) {
        Park.buildings.remove(obj);
    }

    /**
     * Determens the type of the Class then reads in the corresponding image.
     */
    @Override
    public void draw() throws IOException {
        String[] classNameSplit = getClass().toString().split("\\.", 0);
        Park.image = ImageIO.read(new FileInputStream(
                "res/" + classNameSplit[classNameSplit.length - 1] + ".png"));
    }

    public int getPrice(){
        return this.price;
    }


}