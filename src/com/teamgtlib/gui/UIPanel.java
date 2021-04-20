package com.teamgtlib.gui;

import com.teamgtlib.GameException;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Makes the UI Buttons and connexts them with their ActionListeners
 */
public class UIPanel extends JPanel {
    public UIPanel() {
        final int squareButtonsSize = 85;
        setPreferredSize(new Dimension((squareButtonsSize + 5) * 3 + 10, 700));
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

        String str1 = "Maintenance";
        JButton buttonHM = new JButton();
        buttonHM.setPreferredSize(new Dimension(squareButtonsSize, squareButtonsSize));
        buttonHM.setMargin(new Insets(0, 0, 0, 0));
        buttonHM.setText("<html>" + "Hire:" + "<br>"
                + str1 + "<br>"
                + "costs:" + "<br>" + "$"+ "P_HOLDER" + "</html>");
        add(buttonHM);

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

        for (JButton button : buttons) {
            button.addActionListener(buttonArrayActionListener);
        }
        buttonHM.addActionListener(HireMaintenance);
        buttonHC.addActionListener(HireCleaner);

        buttonDemolish.addMouseListener(isReleased);
    }

    /**
     * Returns the "Item" on the pressed button.
     * @param e Gets an ActionEvent as a param.
     */
    private void buttonItemReturner(ActionEvent e) {
        String[] buttonTypeSplit = e.toString().split("<br>", 0);
        GameFrame.GameFrameCurrentButtonItemImageName = buttonTypeSplit[1];
    }

    private final ActionListener buttonArrayActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(GameFrame.SelectionState == SelectionType.NONE) {
                buttonItemReturner(e);
            }
            GameFrame.SelectionState = SelectionType.BUILD;
            System.out.println("GAMEFRAME BUTTON PRESSED");
            PlayAreaPanel.refreshLabelText();
        }
    };

    private final ActionListener HireMaintenance = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Park.player.hireMaintenance();
          GameFrame.bg.repaint();
          PlayAreaPanel.refreshLabelText();
        }
    };

    private final ActionListener HireCleaner = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Park.player.hireCleaner();
            GameFrame.bg.repaint();
        }
    };

    // bound to the Demolish button
    private final MouseListener isReleased = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            // super.mouseReleased(e);
            // GameFrame.bg.revalidate();
            // bg.repaint();
            GameFrame.SelectionState = SelectionType.DEMOLISH;
            System.out.println("DEMOLISH BUTTON PRESSED");
            PlayAreaPanel.refreshLabelText();
        }
    };

    public static void demolish() {
        Point newPoint = new Point(GridUtils.gridToPX(GridUtils.gridConverter(PlayAreaPanel.prevPt)));
        System.out.println(Park.buildings.toString());

        for (Building building : Park.buildings){
            if (building.getX() == newPoint.x && building.getY() == newPoint.y) {
                Park.buildings.remove(building);
                GridUtils.removeBuildingFromGridMap(building);
                System.out.println("REMOVED");
                break;
            }
        }

        demolishFromMatrix(newPoint);

        // GameFrame.DemolishButtonIsPressedOnce = false; // done in PlayAreaPanel's ClickListener
        System.out.println("NOW FALSE");
        GameFrame.bg.repaint(); // can be bg.repaint() as well with static import
        System.out.println(Park.buildings.toString());
    }

    public static void demolishFromMatrix(Point newPoint){
        for (int i = 0; i<14; i++) {
            for (int j = 0; j < 20; j++) {
                if(Park.playAreaPanel[i][j] != null){
                    if (Park.playAreaPanel[i][j].getX() == newPoint.x && Park.playAreaPanel[i][j].getY() == newPoint.y) {
                        Park.playAreaPanel[i][j] = null;
                        //break;
                    }
                }

            }
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Park.image, 0, 0, 1280, 720, null);
    }

}
