import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    public MyWorld()
    {    
        super(610, 610, 1); 
        prepare();
    }

    private void prepare()
    {
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < 11; col++){
                Alien alien = new Alien();
                addObject(alien,80 + (col * 45),80 + (row * 45));
                alien.aliensLeft = 44;
                alien.level = 1;
                showText("LEVEL " + alien.level, 305, 305);
            }
        }
        Player player = new Player();
        addObject(player,305,580);
        player.canShoot = true;
        Bullet bullet = new Bullet();
        addObject(bullet,610,610);
        bullet.score = 0;
        showText("SCORE: " + bullet.score, 80, 30);
        showText("HIGH SCORE: " + bullet.highScore, 305, 30);
        AlienBullet alienBullet = new AlienBullet();
        addObject(alienBullet,610,610);
        alienBullet.lives = 3;
        showText("LIVES: " + alienBullet.lives, 530, 30);
    }
}