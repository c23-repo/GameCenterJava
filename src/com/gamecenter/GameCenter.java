package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class GameCenter extends JPanel {
 //   TicTacToe tic = new TicTacToe();

    TicListener ticListen = new TicListener();
    TileListener tileListen = new TileListener();

    int gridSquares = 3;
    List<JButton> gamebuttons = Arrays.asList(new JButton[3]);

    public GameCenter(){
        initializeButtons();
        addValuesToButtons();
    }

    public void addValuesToButtons(){
        gamebuttons.get(0).setText("Tic-Tac-Toe");
        gamebuttons.get(1).setText("Number-Slide-Puzzle");
        gamebuttons.get(2).setText("Picture-Slide-Puzzle");
    }
    private void initializeButtons() {
        for (int i = 0; i <= gamebuttons.size() - 1; i++) {
            gamebuttons.set(i, new JButton());
            add(gamebuttons.get(i));
        }
        gamebuttons.get(0).addActionListener(ticListen);
        gamebuttons.get(1).addActionListener(tileListen);
    }
    public class TicListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            JFrame twindow = new JFrame("Tic-Tac-Toe");
            twindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            twindow.getContentPane().add(new TicTacToe());
            twindow.setBounds(300, 200, 300, 300);
            twindow.setVisible(true);
        }
    }
    public class TileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            JFrame swindow = new JFrame("Tile-Slide");
            swindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            swindow.getContentPane().add(new TileSlide());
            swindow.setBounds(300, 200, 300, 300);
            swindow.setVisible(true);
        }
    }
    public static void main(String[] args) {
        JFrame window = new JFrame("GameCenter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new GameCenter());
        window.setBounds(300, 200, 300, 300);
        window.setVisible(true);
    }
}