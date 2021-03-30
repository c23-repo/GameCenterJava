
package com.gamecenter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
//import javax.swing.plaf.basic.BasicOptionPaneUI;


public class Board extends JPanel {

    int gridSquares = 9;
    List<JButton> buttons = Arrays.asList(new JButton[9]);


    public Board() {
        setLayout(new GridLayout(3, 3));
        initializeButtons();
    }

    private void initializeButtons() {
        for (int i = 0; i <= buttons.size() - 1; i++) {
            buttons.set(i, new JButton());
            buttons.get(i).setText("");
            buttons.get(i).setFont(new Font("Arial", Font.BOLD, 50));
            buttons.get(i).addActionListener(new ButtonListener());
            add(buttons.get(i));
        }
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
        }
    }

}