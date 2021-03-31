package com.gamecenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import static com.gamecenter.SizeEnum.*;


class TileSlideSubMenu extends JPanel {

    SubListener subListener = new SubListener();
    List<JButton> tileGameButton = Arrays.asList(new JButton[3]);

    public TileSlideSubMenu() {
        initButtons();
        addValsToButtons();

    }


    public void addValsToButtons() {
        tileGameButton.get(0).setText(THREES.squareWidthHeight() + "x" + THREES.squareWidthHeight());
        tileGameButton.get(1).setText(FOURS.squareWidthHeight() + "x" + FOURS.squareWidthHeight());
        tileGameButton.get(2).setText(FIVES.squareWidthHeight() + "x" + FIVES.squareWidthHeight());
    }

    private void initButtons() {
        JLabel intro = new JLabel("Please Choose Board Size To Play");
        intro.setFont(new Font("Arial", Font.BOLD, 25));
        add(intro);
        for (int i = 0; i <= tileGameButton.size() - 1; i++) {
            tileGameButton.set(i, new JButton());
            tileGameButton.get(i).setFont(new Font("Arial", Font.BOLD, 20));
            tileGameButton.get(i).addActionListener(subListener);
            add(tileGameButton.get(i));
        }
    }

    public class SubListener implements ActionListener {

        TileSlideMovements movementsListenerData;

        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            JFrame sSMWindow = new JFrame("Tile-Slide");
            sSMWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            int layout = sizeSelector(tileGameButton.indexOf(buttonClicked));
            movementsListenerData = new TileSlideMovements(layout);

            sSMWindow.getContentPane().add(new TileSlide(layout));
            sSMWindow.setBounds(300, 100, 500, 500);
            sSMWindow.setVisible(true);
        }

        int sizeSelector(int size) {
            return (size + tileGameButton.size());
        }
    }
}