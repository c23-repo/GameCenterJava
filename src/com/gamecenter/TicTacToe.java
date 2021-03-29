package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends Board{
    TicTacToeButtonListener tacListener = new TicTacToeButtonListener();
    int alternate = 0;

    private TicTacToe(){
        setTicTacToe_Listener();
    }
    public  class TicTacToeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            if(!buttonClicked.getText().equals("")){
                alternate -=1;
            }
            if (alternate % 2 ==0){
                buttonClicked.setText("X");
            }else {
                buttonClicked.setText("O");
            }
            if (checkWin()==true && (alternate % 2==0)){
                JOptionPane.showConfirmDialog(null,"GameOver - Player 1 won", "Game-Over", JOptionPane.YES_NO_OPTION);
                resetButtons();
            }
            else if (checkWin()==true && (!(alternate % 2==0))){
                JOptionPane.showConfirmDialog(null,"GameOver - Player 2 won", "Game-Over", JOptionPane.YES_NO_OPTION);
                resetButtons();
            }
            else if(checkDraw()==true){
                JOptionPane.showMessageDialog(null,"draw.");
                resetButtons();
            }
            alternate++;
        }
    }
    public void setTicTacToe_Listener(){
        for (JButton button:buttons
             ) {
            button.addActionListener(tacListener);
        }
    }
    public void resetButtons(){
        for (JButton button: buttons
             ) {
            button.setText("");
        }
        alternate=0;
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
        }

        return false;
    }
    public boolean checkDraw (){
        if( !buttons[0].getText().equals("") && !buttons[1].getText().equals("") && !buttons[2].getText().equals("") && !buttons[3].getText().equals("") &&
                !buttons[4].getText().equals("") && !buttons[5].getText().equals("") && !buttons[6].getText().equals("") && !buttons[7].getText().equals("") &&
                !buttons[8].getText().equals("")){
            return true;
        }else {
            return false;
        }
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