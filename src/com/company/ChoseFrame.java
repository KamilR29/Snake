package com.company;

import javax.swing.*;

public class ChoseFrame extends JFrame {

    JButton buttonOK = new JButton("OK");

    ChoseFrame(){
        ChosePanel chosePanel = new ChosePanel(buttonOK);
        this.add(chosePanel);
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        chosePanel.add(buttonOK);
        buttonOK.addActionListener(e -> this.dispose());


    }

}
