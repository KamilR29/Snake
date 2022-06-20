package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SavePanel extends JPanel implements ActionListener {

    int score;
    String nickName;


    SavePanel(AbstractButton saveButton, int timerTime, int panelSize, int applesEaten){
        this.setPreferredSize(new Dimension(150,150));
        this.setFocusable(true);
        this.setLayout(new FlowLayout());


        JLabel labelNick = new JLabel();
        labelNick.setText("Nick:");

        JTextField nick = new JTextField(10);


        score = (applesEaten + ((timerTime*10000)/panelSize));

        JLabel labelScore = new JLabel("Score: "+score,SwingConstants.CENTER);
        labelScore.setPreferredSize(new Dimension(150,20));



        this.add(labelScore);
        this.add(labelNick);
        this.add(nick);



        saveButton.addActionListener(e -> {
            nickName = nick.getText();
            try {
                save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


    }
    public void save() throws IOException {
        FileWriter file = new FileWriter("score.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        bufferedWriter.write(score+"/"+nickName);
        bufferedWriter.newLine();
        bufferedWriter.close();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
