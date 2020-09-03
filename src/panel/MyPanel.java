package panel;
import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import java.util.Timer;
import java.util.TimerTask;

public class MyPanel extends JPanel implements KeyListener, Runnable{
    int color;
    Hero hero;
    Vector<EnemyTank> enemyTankVector=new Vector<>();
    Vector<Bomb> bombs=new Vector<>();
    private int enemyTankSize=5;
    private int MAX_FIRE_TIMES=5;
    private Image bombImage1;
    private Image bombImage2;
    private Image bombImage3;
    private TimerPanel timer=new TimerPanel();

    public MyPanel(int color){
        this.color=color;
        hero=new Hero(100,100);
        hero.setSpeed(5);

        for(int i=0; i<enemyTankSize;i++){
            EnemyTank et=new EnemyTank((i+1)*50,150);
            et.setDirect((int) (Math.random()*4));
            Thread t=new Thread(et);
            t.start();
            enemyTankVector.add(et);
        }

        this.bombImage1 = new ImageIcon("src/bomb_1.gif").getImage();
        this.bombImage2 = new ImageIcon("src/bomb_2.gif").getImage();
        this.bombImage3 = new ImageIcon("src/bomb_3.gif").getImage();
        this.add(timer);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(Color.black);
        this.drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);

        //draw the bullet in the list
        for(int i=0;i<hero.getbList().size();i++){
            Bullet b=hero.getbList().get(i);
            if(b!=null &&b.getIsAlive()==true){
                this.drawBullet(b.getX(),b.getY(),g);
            }
            if(b.getIsAlive()==false){
                hero.getbList().remove(b);
            }
        }

        //draw the enemy tanks in the list
        for(int i=0;i<enemyTankVector.size();i++){
            EnemyTank et=enemyTankVector.get(i);
            if(et.getIsLive()){
                this.drawTank(et.getX(), et.getY(),g,et.getDirect(),0);
            }else{
                enemyTankVector.remove(et);
            }
        }
        //draw exiting bomb
        for(int i=0;i<bombs.size();i++){
            Bomb b=bombs.get(i);
            while(b.getCount()!=0){
                if(b.getCount()>6){
                    g.drawImage(bombImage1,b.getX(),b.getY(),30,30,this);
                }else if(b.getCount()>3){
                    g.drawImage(bombImage2,b.getX(),b.getY(),30,30,this);
                }else if(b.getCount()>0){
                    g.drawImage(bombImage3,b.getX(),b.getY(),30,30,this);
                }
                b.countDown();
            }
            if(b.getCount()==0){
                bombs.remove(b);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        //Up
        if (e.getKeyCode()==KeyEvent.VK_W){
            this.hero.setDirect(0);
            this.hero.moveUp();
        }
        //Right
        else if(e.getKeyCode()==KeyEvent.VK_D){
            this.hero.setDirect(1);
            this.hero.moveRight();
            //Down
        }
        //Down
        else if(e.getKeyCode()==KeyEvent.VK_S){
            this.hero.setDirect(2);
            this.hero.moveDown();
        }
        //Left
        else if(e.getKeyCode()==KeyEvent.VK_A){
            this.hero.setDirect(3);
            this.hero.moveLeft();
        }
        //check if the user press space to fire
        else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            //shot 5 bullets every time
            if(hero.getbList().size()<MAX_FIRE_TIMES){
                this.hero.shotEnemy();
            }
        }
        //have to repaint panel
        repaint();
    }
    public void drawBullet(int x, int y, Graphics g){
        g.draw3DRect(x,y,2,2 ,false );
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type){
        //hero tank is type 1, enemy tank is type 2
        switch (type){
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                if(color==2){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.yellow);
                }
                break;
        }

        switch (direct){
            case 0:
                g.fill3DRect(x,y,5,30,false);
                g.fill3DRect(x+15,y,5,30, false);
                g.fill3DRect(x+5,y+5,10,20, false);
                g.fillOval(x+5,y+5,10,10);
                g.drawLine(x+10,y+15,x+10,y);
                break;
            case 1:
                g.fill3DRect(x,y,30,5,false);
                g.fill3DRect(x,y+15,30,5, false);
                g.fill3DRect(x+5,y+5,20,10, false);
                g.fillOval(x+10,y+5,10,10);
                g.drawLine(x+15,y+10,x+30,y+10);
                break;
            case 2:
                g.fill3DRect(x,y,5,30,false);
                g.fill3DRect(x+15,y,5,30, false);
                g.fill3DRect(x+5,y+5,10,20, false);
                g.fillOval(x+5,y+5,10,10);
                g.drawLine(x+10,y+15,x+10,y+30);
                break;
            case 3:
                g.fill3DRect(x,y,30,5,false);
                g.fill3DRect(x,y+15,30,5, false);
                g.fill3DRect(x+5,y+5,20,10, false);
                g.fillOval(x+10,y+5,10,10);
                g.drawLine(x+15,y+10,x,y+10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void run() {
        boolean run=true;

        while(run){
            try {
                //repaint every 100ms
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            hitEnemy();
            this.repaint();
            if(timer.remainTimer<=0){
                new LoseTheGame();
                run=false;
            }
            if(enemyTankVector.size()==0){
                new WinTheGame();
                run=false;
            }
        }
    }

    public void hitEnemy(){
        for(int i=0;i<hero.getbList().size();i++){
            Bullet tempBullet=hero.getbList().get(i);
            if(tempBullet.getIsAlive()==true){
                for(int j=0;j<enemyTankVector.size();j++){
                    EnemyTank et=enemyTankVector.get(j);
                    if(et.getIsLive()==true){
                        HitEnemy hit=new HitEnemy(tempBullet,et);
                        hit.bulletsHitEnemy();
                        //if enemy tank is dead, make it explore
                        if(et.getIsLive()==false){
                            Bomb b=new Bomb(et.getX(),et.getY());
                            bombs.add(b);
                        }
                    }
                }
            }
        }
    }

    private class TimerPanel extends JPanel{
        private JLabel label;
        private long remainTimer;
        public TimerPanel(){
            countDown();
        }
        public void countDown(){

            this.setSize(400,300);
            label=new JLabel("",JLabel.CENTER);
            this.setLayout(new BorderLayout());
            this.add(label,BorderLayout.CENTER);

            int i=20;
            final long end=System.currentTimeMillis()+i*1000;
            Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                //calculate the remaining time
                public void run() {
                    long sub=end-System.currentTimeMillis();
                    remainTimer=sub/1000;
                    if(sub<0){
                        return;
                    }
                    updateTimer(sub);
                }
            },0,1000);
        }

        public void updateTimer(long sub) {
            Font font = new Font("Default", Font.PLAIN, 15);
            label.setFont(font);
            label.setText("Time Remaining: "+(int)(sub/1000)+"");
        }
    }

}
