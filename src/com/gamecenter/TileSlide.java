package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class TileSlide extends Board {

    int score = 0;
    boolean gameComplete = false;
    boolean stringArrayMap = false;
    boolean startNewGame = false;
    TileSlideMovements movements = new TileSlideMovements();
    TileSlideButtonListener tileSlideListener = new TileSlideButtonListener();
    List<Integer> board = new ArrayList<>(TileSlideMovements.GRID_TILES);
    List<Integer> currentBoard = new ArrayList<>(TileSlideMovements.GRID_TILES);
    List<ArrayList<Integer>> validMovementMap = new ArrayList<>();


    TileSlide() {
        tileSlideListener.setButtons();
        setTileSlideListener();
    }

    /**
     * Generates a random number to be inserted into the board array.
     */
    void randomNumberGenerator() {
        int random = (int) Math.floor(Math.random() * TileSlideMovements.GRID_TILES);
        board.add(random);
        while (board.size() < TileSlideMovements.GRID_TILES) {
            random = (int) Math.floor(Math.random() * TileSlideMovements.GRID_TILES);
            if (!board.contains(random)) {
                board.add(random);
            }
        }
    }

    /**
     * TileSlideButtonListener specifically works with integer values related to its Outer Class, Therefore its a
     * true Inner Class that only gets used here.
     */
    private class TileSlideButtonListener implements ActionListener {


        private void setButtons() {
            randomNumberGenerator();
            for (int i = 0; i <= buttons.length - 1; i++) {
//                buttons[i] = new JButton();
                buttons[i].setText(board.get(i).toString());
                if (board.get(i) == 0) buttons[i].setText(" ");
                buttons[i].addActionListener(this);
                add(buttons[i]);
            }
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton clickedButton = (JButton) actionEvent.getSource();

            if (!clickedButton.getText().equals("0")) {
                int key = Integer.parseInt(clickedButton.getText());
                if (movements.confirmLegalMovement(board.indexOf(key), movements.getBlankTile())) {
                    int zeroIndex = movements.getBlankTile();
                    int tempIndexValue = board.get(board.indexOf(key));
                    board.add(board.indexOf(key), 0);
                    board.add(board.indexOf(zeroIndex), tempIndexValue);
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
