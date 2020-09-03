package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class EnemyTank extends GeneralTank implements Runnable{


    public EnemyTank(int x, int y) {
        super(x, y);
        this.life=1;
    }

    public void setEnemyList(ArrayList<EnemyTank> elist){


    }

    //using a helper method
    @Override
    public void loseLife() {
        if (!isLive){
            isLive=false;
        }else{
            isLive=true;
        }
    }


    @Override
    public void run() {
        while(true){

            switch (direct){
                case 0:
                    for(int i=0;i<30;i++){
                        if(y_pos>0){
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for(int i=0;i<30;i++){
                        if(x_pos<400-20){
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<30;i++){
                        if(y_pos<300-40){
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<30;i++){
                        if(x_pos>0){
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

            }

            this.direct=(int) (Math.random()*4);
            //hitBoundary();
            if(isLive==false){
                break;
            }
        }
    }
}
