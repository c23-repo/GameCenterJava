package com.gamecenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class GameCenter extends JPanel {

    TicListener ticListen = new TicListener();
    TileListener tileListen = new TileListener();

    int gridSquares = 2;
    List<JButton> gameButtons = Arrays.asList(new JButton[gridSquares]);

    public GameCenter() {
        initializeButtons();
        addValuesToButtons();
    }

    private void addValuesToButtons() {
        gameButtons.get(0).setText("Tic-Tac-Toe");
        gameButtons.get(1).setText("Number-Slide-Puzzle");

    }

    private void initializeButtons() {
        JLabel intro = new JLabel("Please Choose A Game To Play");
        intro.setFont(new Font("Arial", Font.BOLD, 25));
        add(intro);
        for (int i = 0; i <= gameButtons.size() - 1; i++) {
            gameButtons.set(i, new JButton());
            gameButtons.get(i).setFont(new Font("Arial", Font.BOLD, 20));
            add(gameButtons.get(i));
        }
        gameButtons.get(0).addActionListener(ticListen);
        gameButtons.get(1).addActionListener(tileListen);
    }

    private static class TicListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            JFrame tWindow = new JFrame("Tic-Tac-Toe");
            tWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tWindow.getContentPane().add(new TicTacToe());
            tWindow.setBounds(300, 100, 500, 500);
            tWindow.setVisible(true);
        }
    }

    private static class TileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            JFrame sWindow = new JFrame("TTile-Slide-Size-Select");
            sWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            sWindow.getContentPane().add(new TileSlideSubMenu());
            sWindow.setBounds(300, 100, 500, 500);
            sWindow.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("GameCenter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new GameCenter()).setBackground(Color.CYAN);
        window.setBounds(300, 300, 420, 150);
        window.setVisible(true);
    }
}