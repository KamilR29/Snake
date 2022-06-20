package com.company;

import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame(){

        MainPanel mainPanel = new MainPanel();
        this.add(mainPanel);
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }

}
