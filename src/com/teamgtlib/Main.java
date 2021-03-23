package com.teamgtlib;

import com.formdev.flatlaf.FlatDarkLaf;
import com.teamgtlib.gui.GameFrame;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current grade: " + (5.0f) / 1);

        java.awt.EventQueue.invokeLater(() -> {
            try {
                setupLookAndFeel();
                new GameFrame().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private static void setupLookAndFeel() {
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            throw new IllegalStateException("Unsupported look and feel theme", ex);
        }
    }
}
