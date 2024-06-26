import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Actor
{
    static int score = 0;
    static int highScore = 0;
    public void act() 
    {
        Actor alien = this.getOneIntersectingObject(Alien.class);
        this.setLocation(this.getX(), this.getY() - 5);
        if(this.isAtEdge()){
            Player player = getWorld().getObjects(Player.class).get(0);
            player.canShoot = true;
            getWorld().removeObject(this);
        }
        if(alien != null){
            score += 10;
            getWorld().showText("SCORE: " + score, 80, 30);
            setAliensLeft(-1);
            Player player = getWorld().getObjects(Player.class).get(0);
            player.canShoot = true;
            getWorld().removeObject(alien);
            getWorld().removeObject(this);
        }
    }

    public void setAliensLeft(int value){
        Alien alien = getWorld().getObjects(Alien.class).get(0);
        alien.aliensLeft += value;
        if(alien.aliensLeft == 0){
            alien.nextLevel();
        }
    }
}
