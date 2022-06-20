package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {


     int screenWidth = 600;
     int screenHeight = 600;
     int unitSize = 20;
     int gameUnits = ( screenWidth * screenHeight)/ unitSize;
     int delay = 90;
     int x[] = new int[gameUnits];
     int y[] = new int[gameUnits];
    int bodyParts = 2;
    int applesEaten;
    int appleX;
    int appleY;
    int counter = 0;
    boolean bombEaten = true;
    int bombX;
    int bombY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    Timer timerTime;
    int time = 0;
    int panelSize;




    GamePanel(int width, int height){
        screenWidth = width;
        screenHeight = height;
        random = new Random();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
        panelSize = width*height;


    }
    public void startGame(){
        newApple();
        newBomb();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
        timerTime = new Timer(1000,e -> time++);
        timerTime.start();


    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        draw(graphics);

    }
    public void draw(Graphics graphics){

        if(running) {


            for (int i = 0; i < screenHeight / unitSize; i++) {
                graphics.drawLine(0, i * unitSize, screenWidth, i * unitSize);
            }
            for (int i = 0; i < screenWidth / unitSize; i++) {
                graphics.drawLine(i * unitSize, 0, i * unitSize, screenHeight);
            }
            graphics.setColor(Color.red);
            graphics.fillOval(appleX, appleY, unitSize, unitSize);
            if(counter == 10 && bombEaten==false) {
                graphics.setColor(Color.blue);
                graphics.fillOval(bombX, bombY, unitSize, unitSize);
            }
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    graphics.setColor(new Color(31, 166, 3));
                    graphics.fillRect(x[i], y[i], unitSize, unitSize);
                } else {
                    graphics.setColor(new Color(98, 240, 70));
                    graphics.fillRect(x[i], y[i], unitSize, unitSize);
                }
            }
            graphics.setColor(Color.green);
            graphics.setFont(new Font("Ink Free", Font.BOLD,40));
            FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Apple: "+applesEaten, (screenWidth - fontMetrics.stringWidth("Apple: "+applesEaten))/2,graphics.getFont().getSize());

        }else {
            gameOver(graphics);
        }

    }
    public void newApple(){
        appleX = random.nextInt((int)(screenWidth / unitSize))* unitSize;
        appleY = random.nextInt((int)(screenHeight / unitSize))* unitSize;
        if(counter<10){
            counter++;
        }

        System.out.println(counter);
        System.out.println(bombEaten);


    }
    public void newBomb(){
        bombX = random.nextInt((int)(screenWidth / unitSize))* unitSize;
        bombY = random.nextInt((int)(screenHeight / unitSize))* unitSize;


    }
    public void move(){

        for (int i = bodyParts; i >0 ; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];

        }
        switch (direction){
            case 'U':
                y[0] = y[0]- unitSize;
                break;
            case 'D':
                y[0] = y[0]+ unitSize;
                break;
            case 'L':
                x[0] = x[0]- unitSize;
                break;
            case 'R':
                x[0] = x[0]+ unitSize;
                break;
        }

    }
    public void checkApple(){

        if((x[0]==appleX)&&(y[0]==appleY)){
            bodyParts++;
            applesEaten++;
            newApple();

        }

    }
    public void checkBomb(){

        if((x[0]==bombX)&&(y[0]==bombY)){
            if(bodyParts > 1) {
                bodyParts--;
            }
            applesEaten++;
            bombEaten = true;
            counter = 0;
        }
        if(counter==10 && bombEaten){
            newBomb();
            bombEaten = false;
        }

    }
    public void checkCollisions(){

        for (int i = bodyParts; i >0 ; i--) {

            if((x[0]==x[i])&&(y[0]==y[i])){
                running = false;
            }
        }
        if(x[0]<0){
            running = false;
        }
        if(x[0]> screenWidth){
            running = false;
        }
        if(y[0]<0){
            running = false;
        }
        if(y[0]> screenHeight){
            running = false;
        }
        if(!running){
            timer.stop();
            timerTime.stop();
        }


    }
    public void gameOver(Graphics graphics){

        graphics.setColor(Color.green);
        graphics.setFont(new Font("Ink Free", Font.BOLD,75));
        FontMetrics fontMetrics = getFontMetrics(graphics.getFont());
        graphics.drawString("GAME OVER", (screenWidth - fontMetrics.stringWidth("Game Over"))/2, screenHeight - (screenHeight/10));

        graphics.setColor(Color.green);
        graphics.setFont(new Font("Ink Free", Font.BOLD,40));
        FontMetrics fontMetrics1 = getFontMetrics(graphics.getFont());
        graphics.drawString("Apple: "+applesEaten, (screenWidth - fontMetrics1.stringWidth("Apple: "+applesEaten))/2,graphics.getFont().getSize());

        SaveFrame saveFrame = new SaveFrame(time,panelSize,applesEaten);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if(running){
            move();
            checkBomb();
            checkApple();

            checkCollisions();
        }
        repaint();

    }
    public class MyKeyAdapter  extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){

            switch (e.getKeyCode()){
                case KeyEvent.VK_A:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_D:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_W:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_S:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
