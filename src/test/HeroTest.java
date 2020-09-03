import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import model.*;

public class HeroTest {
    Hero hero;
    Bomb b;

    @BeforeEach
    public void setUp(){
        hero=new Hero(10,10);
        b=new Bomb(30,30);
    }

    @Test
    public void testMoveUp(){
        hero.moveUp();
        assertEquals(hero.getY(),9);
    }
    @Test
    public void testMoveDown(){
        hero.moveDown();
        hero.moveDown();
        assertEquals(hero.getY(),12);
    }
    @Test
    public void testMoveRight(){
        hero.moveRight();
        hero.moveRight();
        assertEquals(hero.getX(),12);
    }
    @Test
    public void testMoveLeft(){
        hero.moveLeft();
        assertEquals(hero.getX(),9);
    }
    @Test
    public void testMoveAround(){
        hero.moveLeft();
        hero.moveLeft();
        hero.moveRight();
        assertEquals(hero.getX(),9);
        hero.moveDown();
        hero.moveUp();
        hero.moveUp();
        assertEquals(hero.getY(),9);
    }

    @Test
    public void testShotEnemyUp(){
        hero.setDirect(0);
        hero.shotEnemy();
        assertEquals(hero.getBullet().getX(),10);
        assertEquals(hero.getBullet().getY(),9);
        assertEquals(hero.getBullet().getDirection(),0);
        assertTrue(hero.getbList().contains(hero.getBullet()));

    }

    @Test
    public void testShotEnemyRight(){
        hero.setDirect(1);
        hero.shotEnemy();
        assertEquals(hero.getBullet().getX(),11);
        assertEquals(hero.getBullet().getY(),10);
        assertEquals(hero.getBullet().getDirection(),1);
        assertTrue(hero.getbList().contains(hero.getBullet()));

    }

    @Test
    public void testShotEnemyDown(){
        hero.setDirect(2);
        hero.shotEnemy();
        assertEquals(hero.getBullet().getX(),10);
        assertEquals(hero.getBullet().getY(),11);
        assertEquals(hero.getBullet().getDirection(),2);
        assertTrue(hero.getbList().contains(hero.getBullet()));

    }

    @Test
    public void testShotEnemyLeft(){
        hero.setDirect(3);
        hero.shotEnemy();
        assertEquals(hero.getBullet().getX(),9);
        assertEquals(hero.getBullet().getY(),10);
        assertEquals(hero.getBullet().getDirection(),3);
        assertTrue(hero.getbList().contains(hero.getBullet()));

    }

    @Test
    public void testBeNotShotted(){
        hero.setBullet(new Bullet(20,20,0));
        hero.setLife(3);
        hero.loseLife();
        assertEquals(hero.getLife(),3);
        assertTrue(hero.getIsLive());
    }

    @Test
    public void testChooseColorHaveException(){

    }

//    @Test
//    //when hitTarget() is true
//    public void testBeShottedButNotDead(){
//        hero.heroTank.setLife(3);
//        hero.beShotted();
//        assertEquals(hero.heroTank.getLife(),2);
//        assertTrue(hero.heroTank.getIsLive());
//    }
//
//    @Test
//    //when hitTarget() is true
//    public void testBeShottedAndDead(){
//        hero.heroTank.setLife(1);
//        hero.beShotted();
//        assertEquals(hero.heroTank.getLife(),1);
//        assertFalse(hero.heroTank.getIsLive());
//    }



}
