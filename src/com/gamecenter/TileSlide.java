package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class TileSlide extends Board {

    private int score = 0;
    private boolean gameComplete = true;
    private final TileSlideButtonListener tileSlideListener = new TileSlideButtonListener();
    private final TileSlideMovements movements;
    private final List<Integer> board;

    public TileSlide(int layoutSize) {
        super(layoutSize);
        movements = new TileSlideMovements(layoutSize);
        board = new ArrayList<>(movements.gridTiles);
        randomNumberGenerator(board);
        tileSlideListener.setButtons();
        setTileSlideListener();
    }

    /**
     * Generates a random number to be inserted into the board array.
     */
    private void randomNumberGenerator(List<Integer> arr) {
        int random = (int) Math.floor(Math.random() * movements.gridTiles);
        arr.add(random);
        while (arr.size() < movements.gridTiles) {
            random = (int) Math.floor(Math.random() * movements.gridTiles);
            if (!arr.contains(random)) {
                arr.add(random);
            }
        }
    }

    private int getNullTile() {
        return board.indexOf(0);
    }

    /**
     * Checks if the puzzle is solved
     *
     * @return boolean declaring solved or not
     */
    private boolean isSolved() {
        for (int i = 0; i < board.size() - 2; i++) {
            if (board.get(i) != 0 && board.get(i) == (i + 1)) {
                gameComplete = true;
            } else {
                gameComplete = false;
                break;
            }
        }
        return gameComplete;
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
                    score += 1;
                    int tempNewValue = board.get(board.indexOf(key));
                    int tempNewIndex = board.indexOf(key);
                    board.set(board.indexOf(0), tempNewValue);
                    board.set(tempNewIndex, 0);
                    setButtons();
                }
                if (isSolved()) {
                    JOptionPane.showMessageDialog(null,
                            "Congratulations! \n  You won in " + score + " moves. Exit to play new game.");
                }
            }
        }
    }

    public void setTileSlideListener() {
        for (JButton button : buttons) {
            button.addActionListener(tileSlideListener);
        }
    }
}
