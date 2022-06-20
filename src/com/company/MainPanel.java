package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPanel extends JPanel implements ActionListener {
    MainPanel(){


        this.setPreferredSize(new Dimension(600,600));
        this.setFocusable(true);

        JButton buttonGame = new JButton("Game");
        JButton buttonRank = new JButton("Rank");
        JButton buttonExit = new JButton("Exit");
        Color buttonColor = new Color(48, 48, 48);
        Dimension dimension = new Dimension(150,80);
        Font font = new Font("Serif",Font.BOLD,22);
        buttonGame.setForeground(Color.white);
        buttonRank.setForeground(Color.white);
        buttonExit.setForeground(Color.white);
        buttonGame.setPreferredSize(dimension);
        buttonRank.setPreferredSize(dimension);
        buttonExit.setPreferredSize(dimension);
        buttonGame.setBackground(buttonColor);
        buttonRank.setBackground(buttonColor);
        buttonExit.setBackground(buttonColor);
        buttonGame.setFont(font);
        buttonRank.setFont(font);
        buttonExit.setFont(font);

        JLabel background = new JLabel(new ImageIcon("snake_grafic.jpg"));
        background.setLayout(new FlowLayout());

        this.add(background);
        background.add(buttonGame);
        background.add(buttonRank);
        background.add(buttonExit);
        buttonGame.addActionListener(e -> Game());
        buttonRank.addActionListener(e -> Rank());
        buttonExit.addActionListener(e -> Exit());



    }

    public void Game(){

        ChoseFrame choseFrame = new ChoseFrame();


    }
    public void Rank(){

        RankFrame rankFrame = new RankFrame();

    }
    public void Exit(){
        System.exit(0);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
