import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AlienBullet extends Actor
{
    static int lives = 3;
    public void act() 
    {
        Actor player = this.getOneIntersectingObject(Player.class);
        this.setLocation(this.getX(), this.getY() + 5);
        if(this.isAtEdge()){
            getWorld().removeObject(this);
        }
        if(player != null){
            lives--;
            getWorld().showText("LIVES: " + lives, 530, 30);
            if(lives == 0){
                Alien alien = getWorld().getObjects(Alien.class).get(0);
                alien.gameOver();
                return;
            }
            Greenfoot.delay(50);
            getWorld().removeObject(this);
        }
    }
}
