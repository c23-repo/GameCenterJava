package com.gamecenter;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static com.gamecenter.SizeEnum.THREES;


class Board extends JPanel {

    List<JButton> buttons;

    public Board() {
        setLayout(new GridLayout(THREES.squareWidthHeight(), THREES.squareWidthHeight()));
        buttons = Arrays.asList(new JButton[THREES.perfectSquareSize()]);
        initializeButtons();
    }

    public Board(int layoutSize) {
        buttons = Arrays.asList(new JButton[(layoutSize * layoutSize)]);
        setLayout(new GridLayout(layoutSize, layoutSize));
        initializeButtons();
    }

    private void initializeButtons() {
        for (int i = 0; i <= buttons.size() - 1; i++) {
            buttons.set(i, new JButton());
            buttons.get(i).setText("");
            buttons.get(i).setFont(new Font("Arial", Font.BOLD, 50));
            add(buttons.get(i));
        }
    }

}