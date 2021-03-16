package com.teamgtlib;

import com.teamgtlib.Buildings.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("No Errors");
        System.out.println("Current grade: " + (5.0f)/ 1);


        Bin b = new Bin(0,0);
        b.draw();

        Player p = new Player();
        Park P = new Park();

        p.build(0, 0, DecorType.BENCH);

        P.buildings.get(0).draw();


    }
}
