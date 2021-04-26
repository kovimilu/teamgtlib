package com.teamgtlib.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel {

    private BufferedImage image;
    JLabel playLabel = new JLabel( "");
    JLabel notPlayLabel = new JLabel("");

    public StartPanel() {

        try {
            image = ImageIO.read(new File("res/start.png"));
        } catch (IOException ex) {
            System.out.println("Wrong image path");
        }

        playLabel.setName("start");
        notPlayLabel.setName("exit");

        playLabel.setBounds(550, 520,170,50);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        //playLabel.setBorder(border);

        notPlayLabel.setBounds(510, 585,250,45);
        //notPlayLabel.setBorder(border);

        this.add(playLabel);
        this.add(notPlayLabel);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

}

