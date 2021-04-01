package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class TicTacToe extends Board {
    TicTacToeButtonListener tacListener = new TicTacToeButtonListener();
    int alternate = 0;
    private static final String GAME_OVER = "GameOver ";
    private static final String PLAYER_1 = "Player 1 ";
    private static final String PLAYER_2 = "Player 2 ";
    private static final String DRAW = "the game ended in a draw ";

    public TicTacToe() {
        setTicTacToeListener();
    }

    private class TicTacToeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();

            if (!buttonClicked.getText().equals("")) {
                alternate -= 1;
            }
            if (alternate % 2 == 0 && !buttonClicked.getText().equals("O")) {
                buttonClicked.setText("X");
            }
            if (alternate % 2 != 0 && !buttonClicked.getText().equals("X")) {
                buttonClicked.setText("O");
            }

            if (checkWin() && (alternate % 2 == 0)) {
                JOptionPane.showMessageDialog(null, GAME_OVER + PLAYER_1 + "won");
                resetButtons();
            } else if (checkWin() && (!(alternate % 2 == 0))) {
                JOptionPane.showMessageDialog(null, GAME_OVER + PLAYER_2 + "won");
                resetButtons();
            } else if (checkDraw()) {
                JOptionPane.showMessageDialog(null, DRAW + "no one won");
                resetButtons();
            }
            alternate++;
        }
    }

    private void setTicTacToeListener() {
        for (JButton button : buttons) {
            button.addActionListener(tacListener);
        }
    }


    private void resetButtons() {
        for (JButton button : buttons) {
            button.setText("");
        }
        alternate = 0;
    }

    private boolean checkWin() {
        //horizontal wins
        if (winLogic(0, 1, 2) || (winLogic(3, 4, 5)) || (winLogic(6, 7, 8))) {
            return true;
        }
        //vertical wins
        else if (winLogic(0, 3, 6) || (winLogic(1, 4, 7)) || (winLogic(2, 5, 8))) {
            return true;
        }
        //diagonal wins
        else if (winLogic(0, 4, 8) || (winLogic(2, 4, 6))) {
            return true;
        }
        return false;
    }

    private boolean checkDraw() {
        return (!buttons.get(0).getText().equals("") && !buttons.get(1).getText().equals("") && !buttons.get(2).getText().equals("") && !buttons.get(3).getText().equals("") &&
                !buttons.get(4).getText().equals("") && !buttons.get(5).getText().equals("") && !buttons.get(6).getText().equals("") && !buttons.get(7).getText().equals("") &&
                !buttons.get(8).getText().equals(""));
    }

    private boolean winLogic(int a, int b, int c) {
        return (buttons.get(a).getText().equals(buttons.get(b).getText())
                && buttons.get(b).getText().equals(buttons.get(c).getText())
                && !buttons.get(a).getText().equals(""));
    }

}