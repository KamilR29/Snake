package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChosePanel extends JPanel implements ActionListener {

    ChosePanel(AbstractButton buttonOK){
        this.setPreferredSize(new Dimension(150,150));
        this.setFocusable(true);
        this.setLayout(new FlowLayout());

        JLabel labelWidth = new JLabel();
        JLabel labelHeight = new JLabel();
        labelHeight.setText("height");
        labelWidth.setText("width");

        JTextField width = new JTextField("600",10);

        JTextField height = new JTextField("600",10);
        this.add(labelWidth);
        this.add(width);
        this.add(labelHeight);
        this.add(height);


        buttonOK.addActionListener(e -> {
            Integer widthSize = Integer.parseInt(width.getText());
            Integer heightSize = Integer.parseInt(height.getText());
            startGame(widthSize, heightSize);
        });


    }
    public void startGame(int width, int height){

        GameFrame gameFrame = new GameFrame(width,height);




    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
