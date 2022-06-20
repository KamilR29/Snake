package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RankPanel extends JPanel implements ActionListener {



    RankPanel(){
        this.setPreferredSize(new Dimension(600,600));
        this.setFocusable(true);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(55, 82, 55));

        JTextArea jTextArea = null;

        try {
            jTextArea = new JTextArea(showRank(),23,33);
            jTextArea.setBackground( new Color(74, 74, 74));
            jTextArea.setForeground(Color.white);
            jTextArea.setFont(new Font("Serif",Font.BOLD,18));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        this.add(jScrollPane);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



    }
    public ArrayList read() throws FileNotFoundException {
        ArrayList<RankSort> list = new ArrayList<>();

        File file = new File("score.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split("/");
            list.add(new RankSort(Integer.parseInt(strings[0]),strings[1]));
        }
        return list;

    }
    public String showRank() throws FileNotFoundException {
        MyComprator myComprator = new MyComprator();
        String text = "";
        ArrayList<RankSort> list = read();
        Collections.sort(list,myComprator);
        for (int i = 0; i < list.size(); i++) {
            text += "   Nick: "+list.get(i).name+" - Score: "+list.get(i).score+"\n";

        }
        return text;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
