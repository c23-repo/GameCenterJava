package com.gamecenter.client;

import com.gamecenter.GameCenter;

import javax.swing.*;
import java.awt.*;

public class GameCenterClient {
    public static void main(String[] args) {
        JFrame window = new JFrame("GameCenter");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new GameCenter()).setBackground(Color.CYAN);
        window.setBounds(300, 300, 420, 150);
        window.setVisible(true);
    }
}