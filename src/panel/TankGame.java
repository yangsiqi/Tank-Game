package panel;

import javax.swing.*;
import java.awt.*;

public class TankGame extends JFrame {
    MyPanel mp;
    int countDown;

    public TankGame(int color) {
        mp=new MyPanel(color);
        countDown=200;
        this.setResizable(false);
        this.setTitle("Tank Game");
        this.add(mp);
        this.setSize(400,300);
        this.addKeyListener(mp);
        //start the panel thread
        new Thread(mp).start();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public int getSizeX(){
        return this.getX();
    }

    public int getSizeY(){
        return this.getY();
    }

}

