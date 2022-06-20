package com.company;

import javax.swing.*;

public class RankFrame extends JFrame {

    RankFrame(){

        RankPanel rankPanel = new RankPanel();
        this.add(rankPanel);
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }

}
