package com.teamgtlib.gui;

import com.teamgtlib.Buildings.*;
import com.teamgtlib.Park;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIPanel extends JPanel {
    public UIPanel() {
        final int squareButtonsSize = 85;
        setPreferredSize(new Dimension((squareButtonsSize + 5) * 3, 695));
        final JButton[] buttons = new JButton[11];

        //Rides
        RideType[] ridetypes = RideType.values();
        RideConstants RC = new RideConstants();
        int i = 0;
        for (RideType ridetype : ridetypes) {
            JButton button = new JButton();
            int increaseButtonWithToFitText = 0;
            if (i > 2) increaseButtonWithToFitText = 25;
            button.setPreferredSize(new Dimension(squareButtonsSize
                    + increaseButtonWithToFitText, squareButtonsSize));

            buttons[i] = button;
            buttons[i].setMargin(new Insets(0, 0, 0, 0));
            buttons[i].setText("<html>" + "Build:" + "<br>"
                    + ridetype + "<br>"
                    + "costs:" + "<br>" + "$"+ RC.RCA[i][1] + "</html>");
            add(buttons[i]);
            i++;
        }

        int j = 0;
        DecorType[] decortypes = DecorType.values();
        DecorConstants DC = new DecorConstants();
        for (DecorType decortype : decortypes) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));

            buttons[i] = button;
            buttons[i].setMargin(new Insets(0, 0, 0, 0));
            buttons[i].setText("<html>" + "Build:" + "<br>"
                    + decortype + "<br>"
                    + "costs:" + "<br>" + "$"+ DC.DCA[j][0] + "</html>");
            add(buttons[i]);
            i++;
            j++;
        }


        JButton buttonRoad = new JButton();
        buttonRoad.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonRoad.setMargin(new Insets(0, 0, 0, 0));
        buttonRoad.setText("<html>" + "Build:" + "<br>"
                + "Road" + "<br>"
                + "costs:" + "<br>" + "$"+ Road.COST_PRICE + "</html>");
        buttons[i] = buttonRoad;
        add(buttonRoad);

        JButton buttonBin = new JButton();
        buttonBin.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonBin.setMargin(new Insets(0, 0, 0, 0));
        buttonBin.setText("<html>" + "Build:" + "<br>"
                + "Bin" + "<br>"
                + "costs:" + "<br>" + "$"+ Bin.COST_PRICE + "</html>");
        i++;
        buttons[i] = buttonBin;
        add(buttonBin);

        JButton buttonShop = new JButton();
        buttonShop.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonShop.setMargin(new Insets(0, 0, 0, 0));
        buttonShop.setText("<html>" + "Build:" + "<br>"
                + "Shop" + "<br>"
                + "costs:" + "<br>" + "$"+ Shop.COST_PRICE + "</html>");
        i++;
        buttons[i] = buttonShop;
        add(buttonShop);

        //##
        String str = "Cleaner";
        JButton buttonHC = new JButton();
        buttonHC.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonHC.setMargin(new Insets(0, 0, 0, 0));
        buttonHC.setText("<html>" + "Hire:" + "<br>"
                + str + "<br>"
                + "costs:" + "<br>" + "$"+ "P_HOLDER" + "</html>");
        add(buttonHC);

        JButton buttonRC = new JButton();
        buttonRC.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonRC.setMargin(new Insets(0, 0, 0, 0));
        buttonRC.setText("<html>" + "Relocate:" + "<br>"
                + str + "<br>"
                + "costs:" + "<br>" + "$"+ "P_HOLDER" + "</html>");
        add(buttonRC);

        JButton buttonFC = new JButton();
        buttonFC.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonFC.setMargin(new Insets(0, 0, 0, 0));
        buttonFC.setText("<html>" + "Fire:" + "<br>"
                + str + "<br>"
                + "costs:" + "<br>" + "$"+ "P_HOLDER" + "</html>");
        add(buttonFC);
        //##


        String str1 = "Worker";
        JButton buttonHW = new JButton();
        buttonHW.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonHW.setMargin(new Insets(0, 0, 0, 0));
        buttonHW.setText("<html>" + "Hire:" + "<br>"
                + str1 + "<br>"
                + "costs:" + "<br>" + "$"+ "P_HOLDER" + "</html>");
        add(buttonHW);

        JButton buttonFW = new JButton();
        buttonFW.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonFW.setMargin(new Insets(0, 0, 0, 0));
        buttonFW.setText("<html>" + "Fire:" + "<br>"
                + str1 + "<br>"
                + "costs:" + "<br>" + "$"+ "P_HOLDER" + "</html>");
        add(buttonFW);


        JButton buttonDemolish = new JButton();
        buttonDemolish.setPreferredSize(new Dimension(squareButtonsSize * 3,squareButtonsSize));
        buttonDemolish.setText("Select Building To Demolish");
        add(buttonDemolish);

        /*
        buttons[4].addActionListener(buttonArrayActionListener); //RollerC
        buttons[5].addActionListener(buttonArrayActionListener); //Bench
        buttonBin.addActionListener(buttonArrayActionListener); //Bin
        */
        for (int n = 0; n < buttons.length; ++n) {
            buttons[n].addActionListener(buttonArrayActionListener);
        }
        buttonDemolish.addMouseListener(isReleased);
        //buttons[4].addMouseListener(isRealesed);
        //button.setIcon(new ImageIcon(Park.image));
    }

    /**
     * Returns the "Item" on the pressed button.
     * @param e Gets an ActionEvent as a param.
     */
    private void buttonItemReturner(ActionEvent e)
    {
        String[] buttonTypeSplit = e.toString().split("<br>", 0);
        GameFrame.GameFrameCurrentButtonItemImageName = buttonTypeSplit[1];
        //System.out.println(buttonTypeSplit[1]);
    }

    private final ActionListener buttonArrayActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(!GameFrame.GameFrameButtonIsPressedOnce) {
                buttonItemReturner(e);
            }
            GameFrame.GameFrameButtonIsPressedOnce = true;
        }
    };

    // bound to the Demolish button
    private final MouseListener isReleased = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            // super.mouseReleased(e);
            // GameFrame.bg.revalidate();

            // TODO do below and leave out the desired building
            // bg.repaint();
            /*for (Building building : Park.buildings){
                String[] classNameSplit = building.getClass().toString().split("\\.", 0);
                // bg.paintComponent();
                // imageSelector(classNameSplit[classNameSplit.length - 1])
            }*/
        }
    };


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);
    }

}
