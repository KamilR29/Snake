package com.company;

import javax.swing.*;


public class SaveFrame extends JFrame {


    SaveFrame(int timerTime, int panelSize, int applesEaten){

        JButton saveButton = new JButton("Save");

        SavePanel savePanel= new SavePanel(saveButton,timerTime,panelSize,applesEaten);
        this.add(savePanel);
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


        savePanel.add(saveButton);
        saveButton.addActionListener(e -> this.dispose());


    }
}
