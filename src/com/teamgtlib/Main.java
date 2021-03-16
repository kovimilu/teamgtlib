package com.teamgtlib;

import com.teamgtlib.gui.GameFrame;

public class Main {
    public static void main(String[] args) {
        System.out.println("No Errors");
        System.out.println("Current grade: " + (5.0f) / 1);

        java.awt.EventQueue.invokeLater(() -> new GameFrame().setVisible(true));
    }
}
