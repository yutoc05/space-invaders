import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

public class Alien extends Actor
{
    static int speed = 1;
    int [] counter = new int[5];
    int gameOverDelay = 0;
    static int aliensLeft = 44;
    static int level = 1;
    public void act() 
    {
        counter[0]++;
        if(counter[0] >= 5){
            move (speed);
            if(this.isAtEdge()){
                for(Alien a : getWorld().getObjects(Alien.class)){
                    a.setLocation(a.getX(), a.getY() + 20);
                    a.move(-speed);
                }
                speed *= -1;
            }
            counter[0] = 0;
        }
        if(aliensLeft <= 40 && aliensLeft > 30){
            counter[1]++;
            if(counter[1] >= 4){
                move(speed);
                counter[1] = 0;
            }
        }
        else if(aliensLeft <= 30 && aliensLeft > 20){
            counter[2]++;
            if(counter[2] >= 3){
                move(speed);
                counter[2] = 0;
            }
        }
        else if(aliensLeft <= 20 && aliensLeft > 10){
            counter[3]++;
            if(counter[3] >= 2){
                move(speed);
                counter[3] = 0;
            }
        }
        else if(aliensLeft <= 10 && aliensLeft > 0){
            counter[4]++;
            if(counter[4] >= 1){
                move(speed);
                counter[4] = 0;
            }
        }
        for(int i = 0; i < 5; i++){
            if(counter[i] == 0){
                counter[i] += level - 1;
            }
        }
        if(getY() >= 580){
            gameOverDelay++;
            if(gameOverDelay == 2){
                gameOver();
                return;
            }
        }
        getWorld().showText("", 305, 305);
        shoot();
    }

    public void shoot(){
        if(Greenfoot.getRandomNumber(800) == 5){
            getWorld().addObject(new AlienBullet(), this.getX(), this.getY());
        }
    }

    public void nextLevel(){
        level++;
        getWorld().showText("LEVEL " + level, 305, 305);
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < 11; col++){
                Alien alien = new Alien();
                getWorld().addObject(alien,80 + (col * 45),80 + (row * 45));
                alien.aliensLeft = 44;
            }
        }
        Player player = getWorld().getObjects(Player.class).get(0);
        player.setLocation(305, 580);
        Greenfoot.delay(100);
        getWorld().showText("", 305, 305);
    }

    public void gameOver(){
        getWorld().addObject(new Bullet(), 610, 610);
        Bullet bullet = getWorld().getObjects(Bullet.class).get(0);
        if(bullet.score > bullet.highScore){
            bullet.highScore = bullet.score;
            getWorld().showText("HIGH SCORE: " + bullet.highScore, 305, 30);
            JOptionPane.showMessageDialog(new JFrame(), "Game Over. You got a high score of " + bullet.highScore + ".");
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Game Over. You got a score of " + bullet.score + ".");
        }
        getWorld().removeObjects(getWorld().getObjects(null));
        Greenfoot.stop();
    }
}

