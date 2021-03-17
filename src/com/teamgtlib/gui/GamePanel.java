package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    public GamePanel(){
        setPreferredSize(new Dimension(210,100));
        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(100,100));
        //button.setText("asdasd");
        button.setIcon(new ImageIcon(Park.image));
        //button.addActionListener(isclicked);
        //button.addMouseListener(test);
        add(button);



        final JButton button2 = new JButton();
        button2.setPreferredSize(new Dimension(100,100));
        add(button2);

        final JButton button3 = new JButton();
        button3.setPreferredSize(new Dimension(200,100));
        add(button3);
    }
    /*
    private final ActionListener isclicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("asd");
        }
    };
    */
    /*
    private final MouseListener test = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            //super.mouseReleased(e);
            System.out.println("asd");
        }
    };
    */
}
