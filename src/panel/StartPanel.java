package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel{

    public StartPanel(){
        this.setSize(400,300);
        this.setLayout(null);
        setFrame();


    }

    public void setFrame(){
        JPanel panel=new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setSize(400,300);
        panel.setLayout(null);
        JLabel welcomeLabel=new JLabel("WELCOME!");
        welcomeLabel.setSize(100,35);
        welcomeLabel.setLocation(160,60);
        welcomeLabel.setForeground(Color.WHITE);
        JLabel startingLabel=new JLabel();
        startingLabel.setSize(200,35);
        startingLabel.setLocation(100,100);
        startingLabel.setText("Click Enter to Start the Game");
        startingLabel.setForeground(Color.WHITE);

        JLabel instruction=new JLabel();
        instruction.setText("Instruction:");
        instruction.setForeground(Color.WHITE);
        instruction.setLocation(100,180);
        instruction.setSize(100,30);
        JLabel instruction1=new JLabel();
        instruction1.setText("Press W,A,S,D to move around");
        instruction1.setForeground(Color.WHITE);
        instruction1.setLocation(100,200);
        instruction1.setSize(200,30);
        JLabel instruction2=new JLabel();
        instruction2.setText("Press space to fire");
        instruction2.setForeground(Color.WHITE);
        instruction2.setLocation(100,220);
        instruction2.setSize(150,30);


        JButton enterButton=new JButton();

        enterButton.setText("Enter");
        enterButton.setForeground(Color.BLACK);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseColorPanel();
            }
        });
        enterButton.setSize(80,40);
        enterButton.setLocation(150,140);


        panel.add(startingLabel);
        panel.add(enterButton);
        panel.add(welcomeLabel);
        panel.add(instruction);
        panel.add(instruction1);
        panel.add(instruction2);

        this.add(panel);
        this.setVisible(true);
    }

}
