package panel;

import javax.swing.*;
import java.awt.*;

public class LoseTheGame extends JFrame {
    Image image;
    ImagePanel ig;

    public LoseTheGame() {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        this.setTitle("Tank Game");
        this.setResizable(false);
        this.setSize(400, 300);
        this.setLayout(null);
        panel.setSize(400,300);
        panel.setBackground(Color.WHITE);
        JLabel losingLabel = new JLabel();
        Font font = new Font("Default", Font.PLAIN, 15);
        losingLabel.setFont(font);
        losingLabel.setLocation(140, 30);
        losingLabel.setText("Sorry! You Lose");
        losingLabel.setSize(180, 30);

        image = new ImageIcon("src/game-over.jpg").getImage();
        ig = new ImagePanel();
        ig.setLocation(50,80);

        panel.add(losingLabel);
        this.add(panel);
        this.add(ig);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private class ImagePanel extends JPanel{
        public ImagePanel() {
            this.setLayout(null);
            this.setSize(300, 200);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            this.add(picLabel);
        }

        @Override
        public void paint(Graphics g) {
            this.setBackground(Color.WHITE);
            super.paint(g);
            g.drawImage(image, 50, 0, 200, 200, null);
        }
    }
}
