package com.teamgtlib.Buildings;

import com.teamgtlib.NPCs.Visitor;
import java.util.ArrayList;

/**
 * @author Kovacs Milan
 * @version 0.1
 * @since 2021.03.05
 */
public class Ride extends Building {
    Boolean BUILT = false;
    int durability;
    int MAXCAP = 20;
    int currentCap;
    Enum type;
    ArrayList<Visitor> queue;

    public Ride(int x, int y) {
        this.x = x;
        this.y = y;
        //TODO
    }

    public void use(Visitor Obj) {

    }
}
