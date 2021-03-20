package com.teamgtlib;

import com.teamgtlib.Buildings.BuildingType;
import com.teamgtlib.Buildings.DecorType;
import com.teamgtlib.Buildings.RideType;
import com.teamgtlib.gui.GameFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("No Errors");
        System.out.println("Current grade: " + (5.0f) / 1);


        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GameFrame().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Park p = new Park();
        p.build(15,15, DecorType.BUSH);
        p.build(15,15, DecorType.BENCH);
        p.build(15,15, DecorType.TREE);
        p.build(15,15, RideType.CAROUSEL);
        p.build(15,15, RideType.FERRISWHEEL);
        p.build(15,15, BuildingType.SHOP);
        p.build(15,15, BuildingType.ROAD);



    }
}
