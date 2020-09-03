package model;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Bomb {
    int x;
    int count;
    int y;
    boolean isAlive;

    public int getCount() {
        return count;
    }

    public Bomb(int x, int y){
        this.x=x;
        this.y=y;
        isAlive=true;
        count =9;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getIsAlive(){
        return isAlive;
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive=isAlive;
    }

    public void countDown(){
        count--;
    }


}
