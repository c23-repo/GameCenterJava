package com.gamecenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class GameCenter extends JPanel {
 //   TicTacToe tic = new TicTacToe();

    TicListener ticListen = new TicListener();
    TileListener tileListen = new TileListener();

    int gridSquares = 2;
    List<JButton> gamebuttons = Arrays.asList(new JButton[2]);

    public GameCenter(){
        initializeButtons();
        addValuesToButtons();
    }

    public void addValuesToButtons(){
        gamebuttons.get(0).setText("Tic-Tac-Toe");
        gamebuttons.get(1).setText("Number-Slide-Puzzle");

    }
    private void initializeButtons() {
        JLabel intro = new JLabel("Please Choose A Game To Play");
        intro.setFont(new Font("Arial", Font.BOLD, 25));
        add(intro);
        for (int i = 0; i <= gamebuttons.size() - 1; i++) {
            gamebuttons.set(i, new JButton());
            gamebuttons.get(i).setFont(new Font("Arial", Font.BOLD, 20));
            add(gamebuttons.get(i));
        }
        gamebuttons.get(0).addActionListener(ticListen);
        gamebuttons.get(1).addActionListener(tileListen);
    }
    public class TicListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            JFrame twindow = new JFrame("Tic-Tac-Toe");
            twindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            twindow.getContentPane().add(new TicTacToe());
            twindow.setBounds(300, 100, 500, 500);
            twindow.setVisible(true);
        }
    }
    public class TileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            JFrame swindow = new JFrame("Tile-Slide");
            swindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            swindow.getContentPane().add(new TileSlide());
            swindow.setBounds(300, 100, 500, 500);
            swindow.setVisible(true);
        }
    }
    public static void main(String[] args) {
        JFrame window = new JFrame("GameCenter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new GameCenter());
        window.setBounds(300, 300, 420, 150);
        window.setVisible(true);
    }
}