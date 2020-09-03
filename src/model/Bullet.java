package model;

public class Bullet implements Movement, Shooting, Runnable{
    int x;
    int y;
    int speed=3;
    int direction;
    boolean isAlive =true;

    public Bullet(int x, int y, int direction){
        this.x=x;
        this.y=y;
        this.direction=direction;
    }

    public void shooting(){
        switch(this.direction){
            //move up
            case 0:
                flyUp();
                break;
            //move right
            case 1:
                flyRight();
                break;
            //move down
            case 2:
                flyDown();
                break;
            //move left
            case 3:
                flyLeft();
                break;
        }
    }

    public void bulletIsAlive(int x, int y){
        if(this.x>=0 && this.x<x && this.y>=0 && this.y<y){
            this.isAlive =true;
        }else
            this.isAlive=false;

    }

    public boolean hitTarget(){
        return false;//stub
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public int getSpeed() {
        return speed;
    }

    public void hitBoundary(){
        if(x<0||x>400||y<0||y>300){
            isAlive=false;
        }
    }

    @Override
    public void flyRight() {
        this.x=this.x+this.speed;
    }

    @Override
    public void flyLeft() {
        this.x=this.x-this.speed;
    }

    @Override
    public void flyUp() {
        this.y=this.y-this.speed;
    }

    @Override
    public void flyDown() {
        this.y=this.y+this.speed;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch(this.direction){
                //move up
                case 0:
                    flyUp();
                    break;
                //move right
                case 1:
                    flyRight();
                    break;
                //move down
                case 2:
                    flyDown();
                    break;
                //move left
                case 3:
                    flyLeft();
                    break;
            }
            hitBoundary();
            if(!isAlive){
                break;
            }

        }
    }
}
