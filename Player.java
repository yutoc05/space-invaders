import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    static boolean canShoot = true;
    public void act() 
    {
        if(Greenfoot.isKeyDown("left")){
            this.move (-6);
        }
        if(Greenfoot.isKeyDown("right")){
            this.move (6);
        }
        shoot();
    }

    public void shoot(){
        if(Greenfoot.isKeyDown("space") && canShoot == true){
            getWorld().addObject(new Bullet(), this.getX(), this.getY()-15);
            canShoot = false;
        }
    }
}
