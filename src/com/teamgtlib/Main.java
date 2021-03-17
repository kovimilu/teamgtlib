package com.teamgtlib;

import com.teamgtlib.gui.GameFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("No Errors");
        System.out.println("Current grade: " + (5.0f) / 1);

        Park p = new Park();
        p.draw();

        java.awt.EventQueue.invokeLater(() -> new GameFrame().setVisible(true));
    }
}
