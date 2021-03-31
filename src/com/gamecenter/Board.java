
package com.gamecenter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;


public class Board extends JPanel {


    int gridSquares = 9;
    List<JButton> buttons = Arrays.asList(new JButton[gridSquares]);


    public Board() {
        setLayout(new GridLayout(3, 3));
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