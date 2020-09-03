package model;

import expctions.NotIntException;
import expctions.OutOfBoundaryException;
import expctions.WrongInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Hero extends GeneralTank{
    //high coupling
    //hero and enemy are both tank, but having some different behavior
    //so we don't put it into one class
    Bullet bullet=null;
    Vector<Bullet> bList;

    public Hero(int x, int y){
        super(x,y);
        bList=new Vector<>();
    }


//    //MODIFIES: this
//    //EFFECTS:move up the tank by decreasing y
//    public void moveUp(){ this.y_pos=y_pos-speed; }
//
//    //MODIFIES: this
//    //EFFECTS:move up the tank by increasing y
//    public void moveDown() {this.y_pos=y_pos+speed; }
//
//    //MODIFIES: this
//    //EFFECTS:move up the tank by increasing x
//    public void moveRight() {this.x_pos=x_pos+speed; }
//
//    //MODIFIES: this
//    //EFFECTS:move up the tank by decreasing x
//    public void moveLeft() {this.x_pos=x_pos-speed; }

    public void shotEnemy(){

        switch (direct){
            case 0:
                this.bullet=new Bullet(x_pos+10,y_pos,0);
                this.bullet.shooting();
                bList.add(bullet);
                break;
            case 1:
                this.bullet=new Bullet(x_pos+30,y_pos+10,1);
                this.bullet.shooting();
                bList.add(this.bullet);
                break;
            case 2:
                this.bullet=new Bullet(x_pos+10,y_pos+30,2);
                this.bullet.shooting();
                bList.add(this.bullet);
                break;
            case 3:
                this.bullet=new Bullet(x_pos,y_pos+10,3);
                this.bullet.shooting();
                bList.add(this.bullet);
                break;
        }

        //start the bullet thread
        Thread t=new Thread(bullet);
        t.start();
    }

    //REQUIRES: life larger or equal to zero
    //EFFECTS: check is the tank lose all its life
    @Override
    public void loseLife() {
        if(this.bullet.hitTarget()){
            if(life>1){
                life=life-1;
                isLive=true;
            }
            else {
                life=0;
                isLive=false;
            }

        }
    }


    //MODIFIES:this
    //EFFECTS:let the user enter an english word as color of tank
    public void chooseColor() throws OutOfBoundaryException, NotIntException {
        System.out.println("Please enter the color you want for the tank, enter 1 for yellow, 2 for gray");
        String theColor=scanner.next();
            while(!checkGoodInput(theColor)){
                theColor=scanner.next();
            }


    }

    public boolean checkGoodInput(String theColor) {
        try{
            if(!Character.isDigit(theColor.charAt(0))){
                throw new NotIntException();
            }
            else if(Integer.parseInt(theColor)<1||Integer.parseInt(theColor)>2){
                throw new OutOfBoundaryException();
            }
        }catch (WrongInputException e){
            System.out.println("Please enter number 1 or 2");
            return false;
        }

        this.color=Integer.parseInt(theColor);
        return true;

    }
    public Bullet getBullet() {
        return bullet;
    }

    public Vector<Bullet> getbList(){
        return bList;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }


}
