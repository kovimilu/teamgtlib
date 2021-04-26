package com.teamgtlib.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GameFrame extends JFrame {

    static public SelectionType SelectionState = SelectionType.NONE;
    static public String GameFrameCurrentButtonItemImageName = "";
    static public String GameFrameStatusPanelString = "";
    static public StatusPanel GameFrameStatusPanel = null;

    static public PlayAreaPanel bg;
    static public StartPanel start;
    static public UIPanel gamepanel;
   // JLayeredPane layeredPane;

    public GameFrame() throws IOException {
        setTitle("Beadandó");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));

        ImageIcon logoImage = new ImageIcon("res/_logo.png");
        this.setIconImage(logoImage.getImage());

        //layeredPane = new JLayeredPane();
        //layeredPane.setBounds(0,0,500,500);

        start = new StartPanel();
        this.getContentPane().add(start);
        start.setLayout(null);



        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);

        start.playLabel.addMouseListener(startListener);
        start.notPlayLabel.addMouseListener(exitListener);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                final int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the game?", "Exit confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) System.exit(0);
            }
        });


    }

    MouseListener startListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                switchPanel();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };

    MouseListener exitListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            final int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit the game?", "Exit confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) System.exit(0);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };

    public void switchPanel() throws IOException {
        this.getContentPane().removeAll();
        bg = new PlayAreaPanel();
        GameFrameStatusPanel = new StatusPanel();
        UIPanel gamepanel = new UIPanel();

        this.getContentPane().add(bg);
        this.getContentPane().add(GameFrameStatusPanel, BorderLayout.NORTH);
        this.getContentPane().add(gamepanel, BorderLayout.WEST);

        this.repaint();
    }
}



