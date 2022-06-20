package com.company;

import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(int width, int height){

        GamePanel gamePanel = new GamePanel(width,height);
        this.add(gamePanel);
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
