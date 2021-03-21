package com.teamgtlib;

import com.teamgtlib.gui.GameFrame;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
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
