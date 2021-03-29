
package com.gamecenter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;


public class Board extends JPanel {

    JButton buttons[] = new JButton[9];

    public Board() {
        setLayout(new GridLayout(3, 3));
        initializeButtons();
    }

    private void initializeButtons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new ButtonListener());
            add(buttons[i]);
        }
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
        }
    }

/*
    public static void main(String[] args) {
        JFrame window = new JFrame("Board");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Board());
        window.setBounds(300, 200, 300, 300);
        window.setVisible(true);
    }
*/

}