package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TileSlide extends Board {

    private static final int GRID_TILES = 9;
    int score = 0;
    boolean gameComplete = false;
    boolean stringArrayMap = false;
    boolean startNewGame = false;
    TileSlideMovements movements = new TileSlideMovements();
    TileSlideButtonListener tileSlideListener = new TileSlideButtonListener();
    private final List<Integer> board = new ArrayList<>(TileSlideMovements.GRID_TILES);
    List<Integer> currentBoard = new ArrayList<>(TileSlideMovements.GRID_TILES);


    TileSlide() {
        randomNumberGenerator(board);
        tileSlideListener.setButtons();
        setTileSlideListener();
    }

    /**
     * Generates a random number to be inserted into the board array.
     */
    void randomNumberGenerator(List<Integer> arr) {
        int random = (int) Math.floor(Math.random() * TileSlideMovements.GRID_TILES);
        arr.add(random);
        while (arr.size() < TileSlideMovements.GRID_TILES) {
            random = (int) Math.floor(Math.random() * TileSlideMovements.GRID_TILES);
            if (!arr.contains(random)) {
                arr.add(random);
            }
        }
    }

    int getNullTile() {
        return board.indexOf(0);
    }

    private boolean checkSolved() {
        for (int i = 0; i < board.size() - 2; i++) {
            if (board.get(i) != 0 && board.get(i) != (i + 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * TileSlideButtonListener specifically works with integer values related to its Outer Class, Therefore its a
     * true Inner Class that only gets used here.
     */
    private class TileSlideButtonListener implements ActionListener {


        private void setButtons() {
            for (int i = 0; i <= buttons.size() - 1; i++) {
                buttons.get(i).setText(board.get(i).toString());
                if (board.get(i) == 0) buttons.get(i).setText("");
                buttons.get(i).addActionListener(this);
                add(buttons.get(i));
            }
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton clickedButton = (JButton) actionEvent.getSource();

            if (!clickedButton.getText().equals("")) {
                int key = Integer.parseInt(clickedButton.getText());
                if (movements.confirmLegalMovement(board.indexOf(key), getNullTile())) {
                    int tempNewValue = board.get(board.indexOf(key));
                    int tempNewIndex = board.indexOf(key);
                    board.set(board.indexOf(0), tempNewValue);
                    board.set(tempNewIndex, 0);
                    System.out.println("need to do this for downs and right");
                    System.out.println(board.toString());
                    setButtons();
                }
            }
        }
    }

    public void setTileSlideListener() {
        for (JButton button : buttons) {
            button.addActionListener(tileSlideListener);
        }
    }

    // Inner class only for quick testing purposes only

    public static void main(String[] args) {
        JFrame window = new JFrame("TileSlide");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TileSlide());
        window.setBounds(300, 200, 300, 300);
        window.setVisible(true);
    }
}
