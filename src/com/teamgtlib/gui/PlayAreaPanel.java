package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;

public class PlayAreaPanel extends JPanel {
    public PlayAreaPanel(){
        setPreferredSize(new Dimension(1280,720));
    }



    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);
    }

}