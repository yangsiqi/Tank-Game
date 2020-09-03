package ui;

import panel.StartPanel;
import panel.TankGame;

import javax.swing.*;

public class TankGame2 extends JFrame{
    StartPanel start;

    public TankGame2() {
        this.setResizable(false);
        start=new StartPanel();
        this.setTitle("Tank Game");
        this.add(start);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TankGame2();
    }
}
