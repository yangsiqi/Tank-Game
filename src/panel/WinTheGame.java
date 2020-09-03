package panel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WinTheGame extends JFrame {
    Image image;
    ImagePanel ig;

    public WinTheGame() {
        this.setTitle("Tank Game");
        this.setResizable(false);
        this.setSize(400, 300);
        this.setLayout(null);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        image = new ImageIcon("src/you-win-congratulation-banner-template-with-vector-14660914.jpg").getImage();
        ig = new ImagePanel();
        this.add(ig);
        this.setVisible(true);
    }

    private class ImagePanel extends JPanel {
        public ImagePanel() {
            this.setSize(400, 300);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            picLabel.setLocation(140, 185);
            this.setLayout(null);
            JLabel winnerLabel = new JLabel();
            winnerLabel.setLocation(110, 30);
            winnerLabel.setText("Congratulation! You Win!!");
            winnerLabel.setSize(180, 30);
            this.add(picLabel);
            this.add(winnerLabel);
        }

        @Override
        public void paint(Graphics g) {
            this.setBackground(Color.WHITE);
            super.paint(g);
            g.drawImage(image, 90, 80, 200, 200, null);
        }
    }
}
