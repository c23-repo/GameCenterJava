package com.gamecenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends Board{
    TicTacToeButtonListener tacListener = new TicTacToeButtonListener();
    int alternate = 0;

    private TicTacToe(){
        setTicTacToeListener();
    }
    public  class TicTacToeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            String s = "";
            if(!buttonClicked.getText().equals(s)){
                alternate -=1;
            }
            if (alternate % 2 ==0 && !buttonClicked.getText().equals("O")){
                buttonClicked.setText("X");
            }if(alternate %2 != 0 && !buttonClicked.getText().equals("X")) {
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
    public void setTicTacToeListener(){
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
        else if (winLogic(0, 3, 6)){
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

        if( !buttons.get(0).getText().equals("") && !buttons.get(1).getText().equals("") && !buttons.get(2).getText().equals("") && !buttons.get(3).getText().equals("") &&
                !buttons.get(4).getText().equals("") && !buttons.get(5).getText().equals("") && !buttons.get(6).getText().equals("") && !buttons.get(7).getText().equals("") &&
                !buttons.get(8).getText().equals("")){
            return true;
        }else {
            return false;
        }
    }

    public boolean winLogic(int a, int b, int c){

        if (buttons.get(a).getText().equals(buttons.get(b).getText())
                && buttons.get(b).getText().equals(buttons.get(c).getText())
                && !buttons.get(a).getText().equals("")) {
            return true;
        }else {
            return false;
        }
    }
    //Todo
    public static void main(String[] args) {
      JFrame window = new JFrame("TicTacToe");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.getContentPane().add(new TicTacToe());
      window.setBounds(300, 200, 300, 300);
      window.setVisible(true);
    }

}