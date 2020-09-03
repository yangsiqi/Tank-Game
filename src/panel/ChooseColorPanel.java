package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseColorPanel extends JFrame{
    String userInput;
    int color;
    public ChooseColorPanel(){
        this.setTitle("Tank Game");
        this.setResizable(false);
        this.setSize(400,300);
        this.setLayout(null);
        setPanel();
    }

    public void setPanel(){
        JPanel p=new JPanel();
        p.setBackground(Color.WHITE);
        p.setSize(400,300);
        p.setLayout(null);
        JLabel choosingLabel=new JLabel();
        choosingLabel.setFont(new Font("TimesRoman",Font.PLAIN,14));
        choosingLabel.setText("Enter 1 to choose yellow as the color of your tank");
        choosingLabel.setSize(300,15);
        choosingLabel.setLocation(60,60);
        JLabel choosingLabel2=new JLabel();
        choosingLabel2.setFont(new Font("TimesRoman",Font.PLAIN,14));
        choosingLabel2.setText("Enter 2 to choose red as the color of your tank");
        choosingLabel2.setSize(300,15);
        choosingLabel2.setLocation(60,90);
        JLabel okLabel=new JLabel();
        okLabel.setFont(new Font("TimesRoman",Font.PLAIN,15));
        okLabel.setText("Click ok to enter the game");
        okLabel.setSize(180,15);
        okLabel.setLocation(100,120);

        JButton okButton=new JButton("OK");
        okButton.setSize(30,25);
        okButton.setLocation(200,160);


        JTextField txf=new JTextField();
        txf.setSize(50,25);
        txf.setLocation(140,160);
        userInput=txf.getText();

        try{
            color=Integer.parseInt(userInput);
        }catch (Exception e){
            color=1;
        }

        p.add(choosingLabel2);
        p.add(choosingLabel);
        p.add(okLabel);
        p.add(txf);
        p.add(okButton);
        this.add(p);
        this.setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput=txf.getText();

                try{
                    color=Integer.parseInt(userInput);
                }catch (Exception ex){
                    color=1;
                }
                new TankGame(color);
            }
        });

    }

    public String getInput(){
        return userInput;
    }

}
