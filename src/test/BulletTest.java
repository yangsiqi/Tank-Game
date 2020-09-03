import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import model.*;
import panel.TankGame;

public class BulletTest {
    TankGame ipTest=new TankGame(1);
    Bullet testBullet;

    @BeforeEach
    public void setUp(){
        testBullet=new Bullet(10,20,0);

    }

    @Test
    public void testConstructor(){
        assertEquals(testBullet.getX(),10);
        assertEquals(testBullet.getY(),20);
        assertEquals(testBullet.getDirection(),0);
    }


    @Test
    public void testFlyUp(){
        testBullet=new Bullet(40,40,0);
        testBullet.flyUp();
        assertEquals(testBullet.getX(),40);
        assertEquals(testBullet.getY(),39);
    }

    @Test
    public void testFlyRight(){
        testBullet=new Bullet(30,30,0);
        testBullet.flyRight();
        assertEquals(testBullet.getX(),31);
        assertEquals(testBullet.getY(),30);
    }

    @Test
    public void testFlyDown(){
        testBullet=new Bullet(55,50,0);
        testBullet.flyDown();
        assertEquals(testBullet.getX(),55);
        assertEquals(testBullet.getY(),51);
    }

    @Test
    public void testFlyLeft(){
        testBullet=new Bullet(0,40,0);
        testBullet.flyLeft();
        assertEquals(testBullet.getX(),-1);
        assertEquals(testBullet.getY(),40);
    }


    @Test
    public void testShootingUp(){
        testBullet.shooting();
        assertEquals(testBullet.getY(),19);
        assertEquals(testBullet.getX(),10);
        assertEquals(testBullet.getDirection(),0);
    }
    @Test
    public void testShootingRight(){
        testBullet=new Bullet(10,20,1);
        testBullet.shooting();
        assertEquals(testBullet.getX(),11);
        assertEquals(testBullet.getY(),20);
        assertEquals(testBullet.getDirection(),1);
    }

    @Test
    public void testShootingDown(){
        testBullet=new Bullet(10,20,2);
        testBullet.shooting();
        assertEquals(testBullet.getX(),10);
        assertEquals(testBullet.getY(),21);
        assertEquals(testBullet.getDirection(),2);
    }

    @Test
    public void testShootingLeft(){
        testBullet=new Bullet(10,20,3);
        testBullet.shooting();
        assertEquals(testBullet.getX(),9);
        assertEquals(testBullet.getY(),20);
        assertEquals(testBullet.getDirection(),3);
    }

    @Test
    public void testBulletNotAlive(){
        testBullet=new Bullet(100,199,2);
        testBullet.shooting();
        assertEquals(testBullet.getY(),200);
        testBullet.bulletIsAlive(ipTest.getSizeX(),ipTest.getSizeY());
        assertFalse(testBullet.getIsAlive());
    }

    @Test
    public void testBulletOutOfBoundary(){
        testBullet=new Bullet(210,100,3);
        testBullet.shooting();
        testBullet.bulletIsAlive(ipTest.getSizeX(),ipTest.getSizeY());
        assertFalse(testBullet.getIsAlive());
    }

    @Test
    public void testBulletAlive(){
        testBullet.shooting();
        testBullet.bulletIsAlive(ipTest.getSizeX(),ipTest.getSizeY());
        assertTrue(testBullet.getIsAlive());
    }

//    @Test
//    public void testHitTarget(){
//
//    }
}
