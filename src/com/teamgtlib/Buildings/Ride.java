package com.teamgtlib.Buildings;

import com.teamgtlib.NPCs.Visitor;
import java.util.ArrayList;

/**
 * @author Kovacs Milan
 * @version 0.2
 * @since 2021.03.05
 */
public class Ride extends Building {
    Boolean BUILT = false;
    int durability;
    private int MAXCAP;
    int currentCap;
    Enum type;
    ArrayList<Visitor> queue;

    /*
    public Ride(int x, int y) {
        this.x = x;
        this.y = y;
        MAXCAP = 20;
        //TODO
    }
    */

    public Ride(int x, int y, Enum type) {
        this.x = x;
        this.y = y;
        this.type = type;
        MAXCAP = 30;
        //TODO
    }

    @Override
    public void draw()
    {

    }

    public void use(Visitor Obj) {

    }
}
