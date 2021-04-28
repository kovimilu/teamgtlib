package com.teamgtlib;

import com.teamgtlib.gui.GameFrame;

import java.io.IOException;
import java.util.ConcurrentModificationException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current grade: " + (5.0f + 5.0f + 5.0f) / 3);

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GameFrame().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }catch (ConcurrentModificationException e) {
                System.out.printf("MULTI THREAD Exception");
            }

        });

    }
}
