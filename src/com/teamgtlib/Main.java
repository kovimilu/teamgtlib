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
    }
}
