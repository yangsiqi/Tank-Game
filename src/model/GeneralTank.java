package model;
import expctions.NotIntException;
import expctions.OutOfBoundaryException;

import java.util.Scanner;

public abstract class GeneralTank {
    protected int x_pos=0;
    protected int y_pos=0;
    protected int direct=0;
    protected int color;
    protected int speed=1;
    protected boolean isLive=true;
    protected int life=9;

    Scanner scanner = new Scanner(System.in);

    public GeneralTank(int x, int y){
        this.x_pos=x;
        this.y_pos=y;
    }

    public int getX(){
        return this.x_pos;
    }
    public void setX(int x2){
        this.x_pos=x2;
    }

    public int getY(){
        return this.y_pos;
    }
    public void setY(int y2){
        this.y_pos=y2;
    }

    public void setSpeed(int speed){
        this.speed=speed;
    }
    public int getSpeed(){
        return this.speed;
    }

    public void setDirect(int direct){ this.direct=direct; }
    public int getDirect(){ return this.direct; }

    public void setIsLive(boolean isLive){this.isLive=isLive; }
    public boolean getIsLive(){return this.isLive;}

    public int getColor(){
        return this.color;
    }

    public int getLife() { return life; }

    public void setLife(int life) { this.life = life; }

    //REQUIRES: life greater or equal to zero
    //EFFECT: check is the tank lose all its life
    public abstract void loseLife();

    //MODIFIES: this
    //EFFECTS:move up the tank by decreasing y
    public void moveUp(){ this.y_pos=y_pos-speed; }

    //MODIFIES: this
    //EFFECTS:move up the tank by increasing y
    public void moveDown() {this.y_pos=y_pos+speed; }

    //MODIFIES: this
    //EFFECTS:move up the tank by increasing x
    public void moveRight() {this.x_pos=x_pos+speed; }

    //MODIFIES: this
    //EFFECTS:move up the tank by decreasing x
    public void moveLeft() {this.x_pos=x_pos-speed; }


}
