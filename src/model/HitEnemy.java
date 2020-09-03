package model;

import java.util.Vector;

public class HitEnemy {
    Bullet b;
    EnemyTank enemyTank;

    public HitEnemy(Bullet b, EnemyTank enemyTank){
        this.b=b;
        this.enemyTank=enemyTank;
    }

    public void bulletsHitEnemy(){
            switch (enemyTank.getDirect()){
                case 0:
                case 2:
                    //if enemy tank face up or down
                    if(enemyTank.getX()<b.getX() && b.getX()<enemyTank.getX()+20
                            &&b.getY()>enemyTank.getY()&&b.getY()<enemyTank.getY()+30){
                        b.isAlive=false;
                        enemyTank.isLive=false;
                    }
                case 1:
                case 3:
                    //if enemy tank face left or right
                    if(b.getX() >enemyTank.getX()&&b.getX()<enemyTank.getX()+30
                            &&b.getY()>enemyTank.getY() && b.getY()<enemyTank.getY()+20){
                        b.isAlive=false;
                        enemyTank.isLive=false;
                    }
            }
    }
}
