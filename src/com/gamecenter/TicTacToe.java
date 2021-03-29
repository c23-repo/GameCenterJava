package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends Board{
    TicTacToeButtonListener tacListener = new TicTacToeButtonListener();

    int alternate = 0;
    int count = 0;

    private TicTacToe(){
        setTicTacToe_Listener();
    }
    public  class TicTacToeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            if (alternate % 2 ==0){
                buttonClicked.setText("X");
            }else {
                buttonClicked.setText("O");
            }
            if (checkWin()==true){
                JOptionPane.showConfirmDialog(null,"Game-Over", "Gameover", JOptionPane.YES_NO_OPTION);
                reSetButtons();
            }
            alternate++;
            count++;
        }
    }
    public void setTicTacToe_Listener(){
        for (JButton button:buttons
             ) {
            button.addActionListener(tacListener);
        }
    }
    public void reSetButtons(){
        for (JButton button: buttons
             ) {
            button.setText("");
        }
    }
    public boolean checkWin() {
        //horizontal wins
        if (winLogic(0, 1, 2)) {
            return true;
        } else if (winLogic(3, 4, 5)){
            return true;
        }else if (winLogic(6, 7, 8)){
            return true;
        }
        //vertical wins
        else if (winLogic(3, 3, 6)){
            return true;
        }else if (winLogic(1, 4, 7)){
            return true;
        }else if (winLogic(2, 5, 8)){
            return true;
        }
        //diagonal wins
        else if (winLogic(0, 4, 8)){
            return true;
        }else if (winLogic(2, 4, 6)){
            return true;
        }else if(count==8) {
            JOptionPane.showMessageDialog(null,"draw.");

        }
        return false;
    }

    public boolean winLogic(int a, int b, int c){

        if (buttons[a].getText().equals(buttons[b].getText())
                && buttons[b].getText().equals(buttons[c].getText())
                && !buttons[a].getText().equals("")) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
      JFrame window = new JFrame("TicTacToe");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.getContentPane().add(new TicTacToe());
      window.setBounds(300, 200, 300, 300);
      window.setVisible(true);
    }

}