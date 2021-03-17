package com.teamgtlib.gui;

import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIPanel extends JPanel {
    public UIPanel(){
        setPreferredSize(new Dimension(225,695));
        final int squareButtonsSize = 70;
        final JButton[] buttons = new JButton[9];

        for (int i = 0; i< 9; ++i)
        {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(squareButtonsSize,squareButtonsSize));


            buttons[i] = button;
            buttons[i].setText("<html>" + "Ride" + "<br>"
                    + (i+1) + "<br>"
                    + "costs: $303234" + "</html>");
            add(buttons[i]);
        }

        //button.setPreferredSize(new Dimension(squareButtonsSize,squareButtonsSize));
        //button.setText("asdasd");
        //button.setIcon(new ImageIcon(Park.image));
        //button.addActionListener(isclicked);
        //button.addMouseListener(test);


        JButton button4 = new JButton();
        button4.setPreferredSize(new Dimension(squareButtonsSize * 3,squareButtonsSize));
        add(button4);
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

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);
    }

}
