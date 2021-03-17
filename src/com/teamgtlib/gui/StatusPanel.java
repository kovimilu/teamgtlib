package com.teamgtlib.gui;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    public StatusPanel(){
        setPreferredSize(new Dimension(1280,20));
        JLabel label = new JLabel("PLACE HOLDER", SwingConstants.RIGHT);
        label.setPreferredSize(new Dimension(1200,20));
        this.add(label);

    }

}
